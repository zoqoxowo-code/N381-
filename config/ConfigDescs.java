/*    */ package com.lineage.config;
/*    */ 
/*    */ import com.lineage.DatabaseFactory;
/*    */ import com.lineage.server.utils.SQLUtil;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class ConfigDescs {
/* 15 */   private static final Log _log = LogFactory.getLog(ConfigDescs.class);
/* 16 */   private static final Map<Integer, String> _show_desc = new HashMap<>();
/*    */   private static ConfigDescs _instance;
/*    */   
/*    */   public static ConfigDescs get() {
/* 20 */     if (_instance == null) {
/* 21 */       _instance = new ConfigDescs();
/*    */     }
/* 23 */     return _instance;
/*    */   }
/*    */   
/*    */   private ConfigDescs() {
/* 27 */     load();
/*    */   }
/*    */   
/*    */   private void load() {
/* 31 */     Connection co = null;
/* 32 */     PreparedStatement pm = null;
/* 33 */     ResultSet rs = null;
/*    */     try {
/* 35 */       co = DatabaseFactory.get().getConnection();
/* 36 */       pm = co.prepareStatement("SELECT * FROM `廣播_定時_顯示`");
/* 37 */       rs = pm.executeQuery();
/* 38 */       while (rs.next()) {
/* 39 */         int id = rs.getInt("代碼");
/* 40 */         String message = rs.getString("訊息內容");
/* 41 */         _show_desc.put(Integer.valueOf(id), message);
/*    */       } 
/* 43 */     } catch (SQLException e) {
/* 44 */       _log.error("廣播_定時_顯示", e);
/*    */     } finally {
/* 46 */       SQLUtil.close(rs);
/* 47 */       SQLUtil.close(pm);
/* 48 */       SQLUtil.close(co);
/*    */     } 
/* 50 */     _log.info("廣播_定時_顯示定時公告->" + _show_desc.size());
/*    */   }
/*    */   
/*    */   public static String getShow(int nameid) {
/*    */     try {
/* 55 */       return _show_desc.get(new Integer(nameid));
/* 56 */     } catch (Exception e) {
/* 57 */       e.printStackTrace();
/*    */       
/* 59 */       return null;
/*    */     } 
/*    */   }
/*    */   public static int get_show_size() {
/* 63 */     return _show_desc.size();
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigDescs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */