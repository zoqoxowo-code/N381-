/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class En_lv
/*    */   extends EventExecutor
/*    */ {
/* 13 */   private static final Log _log = LogFactory.getLog(En_lv.class);
/*    */   
/*    */   public static boolean START = false;
/*    */   
/*    */   public static EventExecutor get() {
/* 18 */     return new En_lv();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 24 */       START = true;
/* 25 */     } catch (Exception e) {
/* 26 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\En_lv.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */