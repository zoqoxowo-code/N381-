/*    */ package com.lineage.config;
/*    */ 
/*    */ import com.lineage.DatabaseFactoryLogin;
/*    */ import com.lineage.server.utils.SQLUtil;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public final class ConfigServer {
/* 13 */   private static final Log _log = LogFactory.getLog(ConfigServer.class);
/*    */   public static boolean DBClearAll;
/*    */   
/*    */   public static void loadDB() {
/* 17 */     Connection cn = null;
/* 18 */     PreparedStatement ps = null;
/* 19 */     ResultSet rs = null;
/* 20 */     int size = 0;
/* 21 */     int i = 0;
/*    */     try {
/* 23 */       cn = DatabaseFactoryLogin.get().getConnection();
/* 24 */       ps = cn.prepareStatement("SELECT * FROM `config_server`");
/* 25 */       rs = ps.executeQuery();
/* 26 */       while (rs.next()) {
/* 27 */         String id = rs.getString("id");
/* 28 */         String set = rs.getString("設置");
/* 29 */         int set_int = 0;
/* 30 */         boolean set_boolean = false;
/* 31 */         if (set.equalsIgnoreCase("false") || set.equalsIgnoreCase("true")) {
/* 32 */           set_boolean = rs.getBoolean("設置");
/*    */         } else {
/*    */           try {
/* 35 */             set_int = rs.getInt("設置");
/* 36 */           } catch (Exception exception) {}
/*    */         } 
/* 38 */         if (id.equalsIgnoreCase("DBClearAll")) {
/* 39 */           DBClearAll = set_boolean;
/* 40 */           i++;
/*    */         } 
/*    */       } 
/* 43 */     } catch (SQLException e) {
/* 44 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } finally {
/* 46 */       SQLUtil.close(rs);
/* 47 */       SQLUtil.close(ps);
/* 48 */       SQLUtil.close(cn);
/*    */     } 
/* 50 */     _log.info("Config->Server設置: 0筆 / 處理: " + i + "筆");
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */