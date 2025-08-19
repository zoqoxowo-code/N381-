/*    */ package com.add;
/*    */ 
/*    */ import com.lineage.DatabaseFactory;
/*    */ import com.lineage.server.utils.PerformanceTimer;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SetBossTable
/*    */ {
/* 21 */   private static final Log _log = LogFactory.getLog(SetBossTable.class);
/*    */ 
/*    */   
/*    */   private static SetBossTable _instance;
/*    */ 
/*    */   
/* 27 */   private final Map<Integer, L1SetBoss> _ConfigQuestIndex = new HashMap<>();
/*    */ 
/*    */   
/*    */   public static SetBossTable get() {
/* 31 */     if (_instance == null) {
/* 32 */       _instance = new SetBossTable();
/*    */     }
/* 34 */     return _instance;
/*    */   }
/*    */   
/*    */   public void loadSetQuest() {
/* 38 */     PerformanceTimer timer = new PerformanceTimer();
/* 39 */     Connection con = null;
/* 40 */     PreparedStatement pstm = null;
/* 41 */     ResultSet rs = null;
/*    */     try {
/* 43 */       con = DatabaseFactory.get().getConnection();
/* 44 */       pstm = con.prepareStatement("SELECT * FROM w_bosschallenge");
/* 45 */       rs = pstm.executeQuery();
/* 46 */       fillSystemMessage(rs);
/* 47 */     } catch (SQLException e) {
/* 48 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } finally {
/* 50 */       SQLUtil.close(rs);
/* 51 */       SQLUtil.close(pstm);
/* 52 */       SQLUtil.close(con);
/*    */     } 
/* 54 */     _log.info("讀取->w_Boss挑戰副本檔資料數量: " + this._ConfigQuestIndex.size() + "(" + timer.get() + "ms)");
/*    */   }
/*    */   
/*    */   private void fillSystemMessage(ResultSet rs) throws SQLException {
/* 58 */     while (rs.next()) {
/* 59 */       int Id = rs.getInt("code");
/* 60 */       String Message = rs.getString("set");
/* 61 */       L1SetBoss Quest = new L1SetBoss();
/* 62 */       Quest.set_id(Id);
/* 63 */       Quest.set_message(Message);
/* 64 */       this._ConfigQuestIndex.put(Integer.valueOf(Id), Quest);
/*    */     } 
/*    */   }
/*    */   
/*    */   public L1SetBoss getTemplate(int Id) {
/* 69 */     return this._ConfigQuestIndex.get(Integer.valueOf(Id));
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\SetBossTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */