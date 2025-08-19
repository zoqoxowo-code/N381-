/*    */ package com.add;
/*    */ 
/*    */ import com.lineage.DatabaseFactory;
/*    */ import com.lineage.server.utils.PerformanceTimer;
/*    */ import com.lineage.server.utils.SQLUtil;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Timestamp;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemTimeTableadd
/*    */ {
/* 23 */   private static final Log _log = LogFactory.getLog(ItemTimeTableadd.class);
/* 24 */   public static final Map<Integer, L1ItemTimeadd> TIME = new HashMap<>();
/*    */   private static ItemTimeTableadd _instance;
/*    */   
/*    */   public static ItemTimeTableadd get() {
/* 28 */     if (_instance == null) {
/* 29 */       _instance = new ItemTimeTableadd();
/*    */     }
/* 31 */     return _instance;
/*    */   }
/*    */   
/*    */   public void load() {
/* 35 */     PerformanceTimer timer = new PerformanceTimer();
/* 36 */     Connection con = null;
/* 37 */     PreparedStatement pstm = null;
/* 38 */     ResultSet rs = null;
/*    */     try {
/* 40 */       con = DatabaseFactory.get().getConnection();
/* 41 */       pstm = con.prepareStatement("SELECT * FROM `w_物品日期限制`");
/* 42 */       rs = pstm.executeQuery();
/* 43 */       while (rs.next()) {
/* 44 */         int key = rs.getInt("道具編號");
/* 45 */         Timestamp next_reset_time = rs.getTimestamp("物品時間限制使用");
/* 46 */         L1ItemTimeadd itemTime = new L1ItemTimeadd(next_reset_time);
/* 47 */         TIME.put(Integer.valueOf(key), itemTime);
/*    */       } 
/* 49 */     } catch (SQLException e) {
/* 50 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } finally {
/* 52 */       SQLUtil.close(rs);
/* 53 */       SQLUtil.close(pstm);
/* 54 */       SQLUtil.close(con);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\ItemTimeTableadd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */