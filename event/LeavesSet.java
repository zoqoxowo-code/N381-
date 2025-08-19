/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import com.lineage.server.timecontroller.event.LeavesTime;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LeavesSet
/*    */   extends EventExecutor
/*    */ {
/* 19 */   private static final Log _log = LogFactory.getLog(LeavesSet.class);
/*    */   public static boolean START = false;
/* 21 */   public static int TIME = 0;
/* 22 */   public static int EXP = 0;
/* 23 */   public static int MAXEXP = 400000;
/*    */ 
/*    */   
/*    */   public static int MIN_LEVEL;
/*    */ 
/*    */   
/*    */   public static EventExecutor get() {
/* 30 */     return new LeavesSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 36 */       START = true;
/* 37 */       String[] set = event.get_eventother().split(",");
/*    */       try {
/* 39 */         TIME = Integer.parseInt(set[0]);
/* 40 */       } catch (Exception e2) {
/* 41 */         TIME = 15;
/* 42 */         _log.error("未設定時間(使用預設15分鐘)");
/*    */       } 
/*    */       try {
/* 45 */         EXP = Integer.parseInt(set[1]);
/* 46 */       } catch (Exception e2) {
/* 47 */         EXP = 4000;
/* 48 */         _log.error("未設定增加的經驗質(使用預設4000)");
/*    */       } 
/*    */       try {
/* 51 */         MIN_LEVEL = Integer.parseInt(set[2]);
/* 52 */       } catch (Exception e2) {
/* 53 */         MIN_LEVEL = 45;
/* 54 */         _log.error("未設定等級最少值(使用預設45)");
/*    */       } 
/* 56 */       MAXEXP = EXP * 200;
/* 57 */       LeavesTime leavesTime = new LeavesTime();
/* 58 */       leavesTime.start();
/* 59 */     } catch (Exception e) {
/* 60 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\LeavesSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */