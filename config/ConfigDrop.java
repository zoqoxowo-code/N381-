/*     */ package com.lineage.config;
/*     */ 
/*     */ import com.lineage.DatabaseFactory;
/*     */ import com.lineage.server.serverpackets.S_BoxMessage;
/*     */ import com.lineage.server.serverpackets.S_PacketBoxGree;
/*     */ import com.lineage.server.serverpackets.S_ServerMessage;
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
/*     */ public class ConfigDrop {
/*  21 */   private static final Log _log = LogFactory.getLog(ConfigDrop.class);
/*  22 */   private static final Map<Integer, Drop> _drop_msg_list = new HashMap<>();
/*  23 */   private static final Random _random = new Random();
/*     */   private static ConfigDrop _instance;
/*     */   
/*     */   private ConfigDrop() {
/*  27 */     load();
/*     */   }
/*     */   
/*     */   public static ConfigDrop get() {
/*  31 */     if (_instance == null) {
/*  32 */       _instance = new ConfigDrop();
/*     */     }
/*  34 */     return _instance;
/*     */   }
/*     */   
/*     */   public static void msg(String string1, String string2, String string3, String string4) {
/*  38 */     if (_drop_msg_list.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     try {
/*  42 */       int r = _random.nextInt(_drop_msg_list.size());
/*  43 */       String msg = (_drop_msg_list.get(Integer.valueOf(r)))._message;
/*  44 */       if (msg != null) {
/*  45 */         int type = (_drop_msg_list.get(Integer.valueOf(r)))._type;
/*  46 */         String out = null;
/*  47 */         switch (type) {
/*     */           case 0:
/*  49 */             out = String.format(msg, new Object[] { string1, string2, string3 });
/*     */             break;
/*     */           case 1:
/*  52 */             out = String.format(msg, new Object[] { string2, string1, string3 });
/*     */             break;
/*     */           case 2:
/*  55 */             out = String.format(msg, new Object[] { string1, string4, string2, string3 });
/*     */             break;
/*     */           case 3:
/*  58 */             out = String.format(msg, new Object[] { string2, string1, string4, string3 });
/*     */             break;
/*     */         } 
/*  61 */         if (ConfigOther.dropmsg == 0) {
/*  62 */           World.get().broadcastPacketToAll((ServerBasePacket)new S_BoxMessage(out));
/*     */         } else {
/*  64 */           World.get().broadcastPacketToAll((ServerBasePacket)new S_PacketBoxGree(2, out));
/*  65 */           World.get().broadcastPacketToAll((ServerBasePacket)new S_ServerMessage(out));
/*     */         } 
/*     */       } 
/*  68 */     } catch (Exception e) {
/*  69 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void load() {
/*  74 */     Connection co = null;
/*  75 */     PreparedStatement pm = null;
/*  76 */     ResultSet rs = null;
/*  77 */     int i = 0;
/*     */     try {
/*  79 */       co = DatabaseFactory.get().getConnection();
/*  80 */       pm = co.prepareStatement("SELECT * FROM `廣播_掉寶_顯示`");
/*  81 */       rs = pm.executeQuery();
/*  82 */       while (rs.next()) {
/*  83 */         int id = rs.getInt("代號");
/*  84 */         int type = rs.getInt("類型");
/*  85 */         if (id > 5) {
/*  86 */           String message = rs.getString("訊息內容");
/*  87 */           Drop msg = new Drop(null);
/*  88 */           msg._type = type;
/*  89 */           msg._message = message;
/*  90 */           _drop_msg_list.put(Integer.valueOf(i), msg);
/*  91 */           i++;
/*     */         } 
/*     */       } 
/*  94 */     } catch (SQLException e) {
/*  95 */       _log.error("廣播_掉寶_顯示", e);
/*     */     } finally {
/*  97 */       SQLUtil.close(rs);
/*  98 */       SQLUtil.close(pm);
/*  99 */       SQLUtil.close(co);
/*     */     } 
/* 101 */     _log.info("廣播_掉寶_顯示掉寶公告->" + _drop_msg_list.size());
/*     */   }
/*     */   
/*     */   private class Drop {
/*     */     private int _type;
/*     */     private String _message;
/*     */     
/*     */     private Drop() {}
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigDrop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */