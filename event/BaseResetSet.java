/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BaseResetSet
/*    */   extends EventExecutor
/*    */ {
/* 13 */   private static final Log _log = LogFactory.getLog(BaseResetSet.class);
/* 14 */   public static int RETAIN = 0;
/*    */ 
/*    */   
/*    */   public static EventExecutor get() {
/* 18 */     return new BaseResetSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 24 */       String[] set = event.get_eventother().split(",");
/*    */       try {
/* 26 */         RETAIN = Integer.parseInt(set[0]);
/* 27 */       } catch (Exception exception) {}
/*    */     }
/* 29 */     catch (Exception e) {
/* 30 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\BaseResetSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */