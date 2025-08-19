/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.datatables.lock.VIPReading;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import com.lineage.server.timecontroller.event.VIPTimer;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VIPSet
/*    */   extends EventExecutor
/*    */ {
/* 17 */   private static final Log _log = LogFactory.getLog(VIPSet.class);
/*    */   public static int ADENA;
/*    */   
/*    */   public static EventExecutor get() {
/* 21 */     return new VIPSet();
/*    */   }
/*    */   public static int DATETIME; public static int ITEMID;
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 27 */       String[] set = event.get_eventother().split(",");
/* 28 */       ADENA = Integer.parseInt(set[0]);
/* 29 */       DATETIME = Integer.parseInt(set[1]);
/* 30 */       ITEMID = Integer.parseInt(set[2]);
/* 31 */       VIPReading.get().load();
/* 32 */       VIPTimer exp11Timer = new VIPTimer();
/* 33 */       exp11Timer.start();
/* 34 */     } catch (Exception e) {
/* 35 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\VIPSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */