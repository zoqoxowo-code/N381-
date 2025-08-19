/*    */ package com.add;
/*    */ 
/*    */ import com.lineage.DatabaseFactory;
/*    */ import com.lineage.server.utils.PerformanceTimer;
/*    */ import com.lineage.server.utils.SQLUtil;
/*    */ import com.lineage.server.utils.collections.Maps;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Timestamp;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Calendar;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class L1SystemMessageTable
/*    */ {
/* 25 */   private static final Log _log = LogFactory.getLog(L1SystemMessageTable.class);
/*    */   
/*    */   private static L1SystemMessageTable _instance;
/*    */   
/* 29 */   private final Map<Integer, L1SystemMessage> _ConfigIndex = Maps.newHashMap();
/*    */ 
/*    */   
/*    */   public static L1SystemMessageTable get() {
/* 33 */     if (_instance == null) {
/* 34 */       _instance = new L1SystemMessageTable();
/*    */     }
/* 36 */     return _instance;
/*    */   }
/*    */   
/*    */   public void loadSystemMessage() {
/* 40 */     PerformanceTimer timer = new PerformanceTimer();
/* 41 */     Connection con = null;
/* 42 */     PreparedStatement pstm = null;
/* 43 */     ResultSet rs = null;
/*    */     try {
/* 45 */       con = DatabaseFactory.get().getConnection();
/* 46 */       pstm = con.prepareStatement("SELECT * FROM config_other");
/* 47 */       rs = pstm.executeQuery();
/* 48 */       fillSystemMessage(rs);
/* 49 */     } catch (SQLException e) {
/* 50 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } finally {
/* 52 */       SQLUtil.close(rs);
/* 53 */       SQLUtil.close(pstm);
/* 54 */       SQLUtil.close(con);
/*    */     } 
/* 56 */     _log.info("載入DB化系統設定檔資料數量: " + this._ConfigIndex.size() + "(" + timer.get() + "ms)");
/*    */   }
/*    */   
/*    */   private void fillSystemMessage(ResultSet rs) throws SQLException {
/* 60 */     while (rs.next()) {
/* 61 */       int Id = rs.getInt("id");
/* 62 */       String Message = rs.getString("message");
/* 63 */       Timestamp time = rs.getTimestamp("resetMaptime");
/* 64 */       Calendar resetmaptime = null;
/* 65 */       if (time != null) {
/* 66 */         resetmaptime = timestampToCalendar(rs.getTimestamp("resetMaptime"));
/*    */       }
/* 68 */       L1SystemMessage System_Message = new L1SystemMessage(Id, Message, resetmaptime);
/* 69 */       this._ConfigIndex.put(Integer.valueOf(Id), System_Message);
/*    */     } 
/*    */   }
/*    */   
/*    */   public L1SystemMessage getTemplate(int Id) {
/* 74 */     return this._ConfigIndex.get(Integer.valueOf(Id));
/*    */   }
/*    */   
/*    */   private Calendar timestampToCalendar(Timestamp ts) {
/* 78 */     Calendar cal = Calendar.getInstance();
/* 79 */     cal.setTimeInMillis(ts.getTime());
/* 80 */     return cal;
/*    */   }
/*    */   
/*    */   public void updateResetTime(int id, Calendar reset_cal) {
/* 84 */     Connection con = null;
/* 85 */     PreparedStatement pstm = null;
/*    */     try {
/* 87 */       con = DatabaseFactory.get().getConnection();
/* 88 */       pstm = con.prepareStatement("UPDATE `config_other` SET `resetMaptime`=? WHERE `id`=?");
/* 89 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
/* 90 */       String fm = sdf.format(reset_cal.getTime());
/* 91 */       int i = 0;
/* 92 */       pstm.setString(++i, fm);
/* 93 */       pstm.setInt(++i, id);
/* 94 */       pstm.execute();
/* 95 */     } catch (Exception e) {
/* 96 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } finally {
/* 98 */       SQLUtil.close(pstm);
/* 99 */       SQLUtil.close(con);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\L1SystemMessageTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */