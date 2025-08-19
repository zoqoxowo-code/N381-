/*    */ package com.add;
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
/*    */ public class dr_nametable
/*    */ {
/* 21 */   private static Logger _log = Logger.getLogger(dr_nametable.class.getName());
/*    */   private static dr_nametable _instance;
/*    */   
/*    */   public static dr_nametable getInstance() {
/* 25 */     if (_instance == null) {
/* 26 */       _instance = new dr_nametable();
/*    */     }
/* 28 */     return _instance;
/*    */   }
/*    */   private final Map<Integer, dr_name_message> _itemIdIndex;
/*    */   private dr_nametable() {
/* 32 */     this._itemIdIndex = Maps.newHashMap();
/* 33 */     loadSystemMessage();
/*    */   }
/*    */   
/*    */   private void loadSystemMessage() {
/* 37 */     Connection con = null;
/* 38 */     PreparedStatement pstm = null;
/* 39 */     ResultSet rs = null;
/*    */     try {
/* 41 */       con = DatabaseFactory.get().getConnection();
/* 42 */       pstm = con.prepareStatement("SELECT * FROM william_droptype_name");
/* 43 */       rs = pstm.executeQuery();
/* 44 */       fillSystemMessage(rs);
/* 45 */     } catch (SQLException e) {
/* 46 */       _log.log(Level.SEVERE, "error while creating william_droptype_name table", e);
/*    */     } finally {
/* 48 */       SQLUtil.close(rs);
/* 49 */       SQLUtil.close(pstm);
/* 50 */       SQLUtil.close(con);
/*    */     } 
/*    */   }
/*    */   
/*    */   private void fillSystemMessage(ResultSet rs) throws SQLException {
/* 55 */     while (rs.next()) {
/* 56 */       int Id = rs.getInt("type");
/* 57 */       String Message = rs.getString("type_name");
/* 58 */       dr_name_message System_Message = new dr_name_message(Id, Message);
/* 59 */       this._itemIdIndex.put(Integer.valueOf(Id), System_Message);
/*    */     } 
/*    */   }
/*    */   
/*    */   public dr_name_message getTemplate(int Id) {
/* 64 */     return this._itemIdIndex.get(Integer.valueOf(Id));
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\dr_nametable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */