/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.BroadcastController;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BroadcastSet
/*    */   extends EventExecutor
/*    */ {
/* 14 */   private static final Log _log = LogFactory.getLog(PowerItemSet.class);
/*    */ 
/*    */   
/*    */   public static int ITEM_ID;
/*    */ 
/*    */   
/*    */   public static EventExecutor get() {
/* 21 */     return new BroadcastSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 27 */       String[] set = event.get_eventother().split(",");
/* 28 */       ITEM_ID = Integer.parseInt(set[0]);
/* 29 */       BroadcastController.getInstance().start();
/* 30 */     } catch (Exception e) {
/* 31 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\BroadcastSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */