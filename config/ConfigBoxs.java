/*    */ package com.lineage.config;
/*    */ import com.lineage.DatabaseFactory;
/*    */ import com.lineage.server.serverpackets.S_BoxMessage;
/*    */ import com.lineage.server.serverpackets.S_PacketBoxGree;
/*    */ import com.lineage.server.serverpackets.ServerBasePacket;
/*    */ import com.lineage.server.utils.SQLUtil;
/*    */ import com.lineage.server.world.World;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Random;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class ConfigBoxs {
/* 19 */   private static final Log _log = LogFactory.getLog(ConfigBoxs.class);
/* 20 */   private static final Map<Integer, Box> _box_msg_list = new HashMap<>();
/*    */   private static ConfigBoxs _instance;
/* 22 */   private static final Random _random = new Random();
/*    */   
/*    */   public static ConfigBoxs get() {
/* 25 */     if (_instance == null) {
/* 26 */       _instance = new ConfigBoxs();
/*    */     }
/* 28 */     return _instance;
/*    */   }
/*    */   
/*    */   private ConfigBoxs() {
/* 32 */     load();
/*    */   }
/*    */   
/*    */   private void load() {
/* 36 */     Connection co = null;
/* 37 */     PreparedStatement pm = null;
/* 38 */     ResultSet rs = null;
/* 39 */     int i = 0;
/*    */     try {
/* 41 */       co = DatabaseFactory.get().getConnection();
/* 42 */       pm = co.prepareStatement("SELECT * FROM `廣播_寶箱_顯示`");
/* 43 */       rs = pm.executeQuery();
/* 44 */       while (rs.next()) {
/* 45 */         int id = rs.getInt("代號");
/* 46 */         int type = rs.getInt("類型");
/* 47 */         if (id > 5) {
/* 48 */           String message = rs.getString("訊息內容");
/* 49 */           Box msg = new Box(null);
/* 50 */           msg._type = type;
/* 51 */           msg._message = message;
/* 52 */           _box_msg_list.put(Integer.valueOf(i), msg);
/* 53 */           i++;
/*    */         } 
/*    */       } 
/* 56 */     } catch (SQLException e) {
/* 57 */       _log.error("廣播_寶箱_顯示", e);
/*    */     } finally {
/* 59 */       SQLUtil.close(rs);
/* 60 */       SQLUtil.close(pm);
/* 61 */       SQLUtil.close(co);
/*    */     } 
/* 63 */     _log.info("廣播_寶箱_顯示開盒公告->" + _box_msg_list.size());
/*    */   }
/*    */   
/*    */   public static void msg(String string1, String string2, String string3) {
/* 67 */     if (_box_msg_list.isEmpty())
/*    */       return; 
/*    */     try {
/* 70 */       int r = _random.nextInt(_box_msg_list.size());
/* 71 */       String msg = (_box_msg_list.get(Integer.valueOf(r)))._message;
/* 72 */       if (msg != null) {
/* 73 */         int type = (_box_msg_list.get(Integer.valueOf(r)))._type;
/* 74 */         String out = null;
/* 75 */         switch (type) {
/*    */           case 1:
/* 77 */             out = String.format(msg, new Object[] { string1, string2, string3 });
/*    */             break;
/*    */         } 
/* 80 */         if (ConfigOther.boxsmsg == 0)
/* 81 */         { World.get().broadcastPacketToAll((ServerBasePacket)new S_BoxMessage(out)); }
/*    */         else
/* 83 */         { World.get().broadcastPacketToAll((ServerBasePacket)new S_PacketBoxGree(2, out)); } 
/*    */       } 
/* 85 */     } catch (Exception e) {
/* 86 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */   
/*    */   private class Box {
/*    */     private int _type;
/*    */     private String _message;
/*    */     
/*    */     private Box() {}
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigBoxs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */