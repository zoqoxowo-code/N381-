/*    */ package com.eric;
/*    */ 
/*    */ import com.lineage.DatabaseFactory;
/*    */ import com.lineage.server.utils.SQLUtil;
/*    */ import com.lineage.server.utils.collections.Maps;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.Map;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class StartCheckWarTime
/*    */ {
/* 21 */   private static Logger _log = Logger.getLogger(StartCheckWarTime.class.getName());
/*    */   private static StartCheckWarTime _instance;
/*    */   
/*    */   private StartCheckWarTime() {
/* 25 */     this._check = Maps.newHashMap();
/* 26 */     loadStartCheckWarTimeFromDatabase();
/*    */   }
/*    */   private final Map<Integer, Data> _check;
/*    */   private void loadStartCheckWarTimeFromDatabase() {
/* 30 */     Connection con = null;
/* 31 */     PreparedStatement pstm = null;
/* 32 */     ResultSet rs = null;
/*    */     try {
/* 34 */       con = DatabaseFactory.get().getConnection();
/* 35 */       pstm = con.prepareStatement("SELECT * FROM eric_startcheckwartime");
/* 36 */       rs = pstm.executeQuery();
/* 37 */       while (rs.next()) {
/* 38 */         Data data = new Data(null);
/* 39 */         int id = rs.getInt("castle_id");
/* 40 */         rs.getString("name");
/* 41 */         data._isActive = rs.getBoolean("isActive");
/* 42 */         this._check.put(new Integer(id), data);
/*    */       } 
/* 44 */       _log.config("StartCheckWarTime " + this._check.size());
/* 45 */     } catch (SQLException e) {
/* 46 */       e.printStackTrace();
/* 47 */       _log.log(Level.SEVERE, e.getLocalizedMessage(), e);
/*    */     } finally {
/* 49 */       SQLUtil.close(rs);
/* 50 */       SQLUtil.close(pstm);
/* 51 */       SQLUtil.close(con);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static StartCheckWarTime getInstance() {
/* 56 */     if (_instance == null) {
/* 57 */       _instance = new StartCheckWarTime();
/*    */     }
/* 59 */     return _instance;
/*    */   }
/*    */   
/*    */   public boolean isActive(int castleId) {
/* 63 */     Data data = this._check.get(Integer.valueOf(castleId));
/* 64 */     return !(data != null && !((Data)this._check.get(Integer.valueOf(castleId)))._isActive);
/*    */   }
/*    */   
/*    */   private class Data {
/*    */     private Data() {}
/*    */     
/*    */     public boolean _isActive = true;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\eric\StartCheckWarTime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */