/*     */ package com.lineage.config;
/*     */ import com.lineage.DatabaseFactory;
/*     */ import com.lineage.server.serverpackets.S_KillMessage;
/*     */ import com.lineage.server.serverpackets.S_PacketBoxGree;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.utils.SQLUtil;
/*     */ import com.lineage.server.world.World;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class ConfigKill {
/*  19 */   private static final Log _log = LogFactory.getLog(ConfigKill.class);
/*  20 */   private static final Map<Integer, Kill> KILL_TEXT_LIST = new HashMap<>();
/*     */   private static ConfigKill _instance;
/*  22 */   private static final Random _random = new Random();
/*  23 */   public static int KILLLEVEL = 90;
/*     */   
/*     */   public static ConfigKill get() {
/*  26 */     if (_instance == null) {
/*  27 */       _instance = new ConfigKill();
/*     */     }
/*  29 */     return _instance;
/*     */   }
/*     */   
/*     */   private ConfigKill() {
/*  33 */     load();
/*     */   }
/*     */   
/*     */   private void load() {
/*  37 */     Connection co = null;
/*  38 */     PreparedStatement pm = null;
/*  39 */     ResultSet rs = null;
/*  40 */     int i = 0;
/*     */     try {
/*  42 */       co = DatabaseFactory.get().getConnection();
/*  43 */       pm = co.prepareStatement("SELECT * FROM `廣播_殺人_顯示`");
/*  44 */       rs = pm.executeQuery();
/*  45 */       while (rs.next()) {
/*  46 */         int id = rs.getInt("代碼");
/*  47 */         int type = rs.getInt("類型");
/*  48 */         if (id > 5) {
/*  49 */           String message = rs.getString("訊息內容");
/*  50 */           Kill msg = new Kill(null);
/*  51 */           msg._type = type;
/*  52 */           msg._message = message;
/*  53 */           KILL_TEXT_LIST.put(Integer.valueOf(i), msg);
/*  54 */           i++;
/*     */         } 
/*     */       } 
/*  57 */     } catch (SQLException e) {
/*  58 */       _log.error("廣播_殺人_顯示", e);
/*     */     } finally {
/*  60 */       SQLUtil.close(rs);
/*  61 */       SQLUtil.close(pm);
/*  62 */       SQLUtil.close(co);
/*     */     } 
/*  64 */     _log.info("廣播_殺人_顯示殺人公告->" + KILL_TEXT_LIST.size());
/*     */   }
/*     */   
/*     */   public void msg(String fpcName, String pcName, String weaponName) {
/*  68 */     if (KILL_TEXT_LIST.isEmpty())
/*     */       return; 
/*     */     try {
/*  71 */       int r = _random.nextInt(KILL_TEXT_LIST.size());
/*  72 */       String msg = (KILL_TEXT_LIST.get(Integer.valueOf(r)))._message;
/*  73 */       if (msg != null) {
/*  74 */         int type = (KILL_TEXT_LIST.get(Integer.valueOf(r)))._type;
/*  75 */         String out = null;
/*  76 */         switch (type) {
/*     */           case 0:
/*  78 */             out = String.format(msg, new Object[] { fpcName, pcName });
/*     */             break;
/*     */           case 1:
/*  81 */             out = String.format(msg, new Object[] { pcName, fpcName });
/*     */             break;
/*     */           case 2:
/*  84 */             out = String.format(msg, new Object[] { fpcName, weaponName, pcName });
/*     */             break;
/*     */           case 3:
/*  87 */             out = String.format(msg, new Object[] { pcName, fpcName, weaponName });
/*     */             break;
/*     */         } 
/*  90 */         World.get().broadcastPacketToAll((ServerBasePacket)new S_KillMessage(out));
/*  91 */         World.get().broadcastPacketToAll((ServerBasePacket)new S_PacketBoxGree(2, out));
/*     */       } 
/*  93 */     } catch (Exception e) {
/*  94 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void msgnoweapon(String fpcName, String pcName, String weaponName) {
/*  99 */     if (KILL_TEXT_LIST.isEmpty())
/*     */       return; 
/*     */     try {
/* 102 */       int r = _random.nextInt(KILL_TEXT_LIST.size());
/* 103 */       String msg = (KILL_TEXT_LIST.get(Integer.valueOf(r)))._message;
/* 104 */       if (msg != null) {
/* 105 */         int type = (KILL_TEXT_LIST.get(Integer.valueOf(r)))._type;
/* 106 */         String out = null;
/* 107 */         switch (type) {
/*     */           case 0:
/* 109 */             out = String.format(msg, new Object[] { fpcName, pcName });
/*     */             break;
/*     */           case 1:
/* 112 */             out = String.format(msg, new Object[] { pcName, fpcName });
/*     */             break;
/*     */           case 2:
/* 115 */             out = String.format(msg, new Object[] { fpcName, weaponName, pcName });
/*     */             break;
/*     */           case 3:
/* 118 */             out = String.format(msg, new Object[] { pcName, fpcName, "空手" });
/*     */             break;
/*     */         } 
/* 121 */         if (ConfigOther.killmsg == 0)
/* 122 */         { World.get().broadcastPacketToAll((ServerBasePacket)new S_KillMessage(out)); }
/*     */         else
/* 124 */         { World.get().broadcastPacketToAll((ServerBasePacket)new S_PacketBoxGree(2, out)); } 
/*     */       } 
/* 126 */     } catch (Exception e) {
/* 127 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void msg1(String fpcName, String pcName, String weaponName) {
/* 132 */     if (KILL_TEXT_LIST.isEmpty())
/*     */       return; 
/*     */     try {
/* 135 */       int r = _random.nextInt(KILL_TEXT_LIST.size());
/* 136 */       String msg = (KILL_TEXT_LIST.get(Integer.valueOf(r)))._message;
/* 137 */       if (msg != null) {
/* 138 */         int type = (KILL_TEXT_LIST.get(Integer.valueOf(r)))._type;
/* 139 */         String out = null;
/* 140 */         switch (type) {
/*     */           case 0:
/* 142 */             out = String.format(msg, new Object[] { "**守護者**", pcName });
/*     */             break;
/*     */           case 1:
/* 145 */             out = String.format(msg, new Object[] { pcName, "**守護者**" });
/*     */             break;
/*     */           case 2:
/* 148 */             out = String.format(msg, new Object[] { "**守護者**", weaponName, pcName });
/*     */             break;
/*     */           case 3:
/* 151 */             out = String.format(msg, new Object[] { pcName, "**守護者**", weaponName });
/*     */             break;
/*     */         } 
/* 154 */         if (ConfigOther.killmsg == 0)
/* 155 */         { World.get().broadcastPacketToAll((ServerBasePacket)new S_KillMessage(out)); }
/*     */         else
/* 157 */         { World.get().broadcastPacketToAll((ServerBasePacket)new S_PacketBoxGree(2, out)); } 
/*     */       } 
/* 159 */     } catch (Exception e) {
/* 160 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private class Kill {
/*     */     private int _type;
/*     */     private String _message;
/*     */     
/*     */     private Kill() {}
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigKill.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */