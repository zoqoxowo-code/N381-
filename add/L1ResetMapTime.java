/*    */ package com.add;
/*    */ 
/*    */ import com.lineage.DatabaseFactory;
/*    */ import com.lineage.server.utils.SQLUtil;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Calendar;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class L1ResetMapTime
/*    */ {
/* 18 */   private static final Log _log = LogFactory.getLog(L1ResetMapTime.class);
/*    */   private static L1ResetMapTime _instance;
/*    */   
/*    */   public static L1ResetMapTime get() {
/* 22 */     if (_instance == null) {
/* 23 */       _instance = new L1ResetMapTime();
/*    */     }
/* 25 */     return _instance;
/*    */   }
/*    */   
/*    */   private void updateResetMapTime(int id, Calendar reset_cal) {
/* 29 */     Connection con = null;
/* 30 */     PreparedStatement pstm = null;
/*    */     try {
/* 32 */       con = DatabaseFactory.get().getConnection();
/* 33 */       pstm = con.prepareStatement("UPDATE `config_other` SET `resetMaptime`=? WHERE `id`=?");
/* 34 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
/* 35 */       String fm = sdf.format(reset_cal.getTime());
/* 36 */       int i = 0;
/* 37 */       pstm.setString(++i, fm);
/* 38 */       pstm.setInt(++i, id);
/* 39 */       pstm.execute();
/* 40 */     } catch (Exception e) {
/* 41 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } finally {
/* 43 */       SQLUtil.close(pstm);
/* 44 */       SQLUtil.close(con);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\L1ResetMapTime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */