/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import com.lineage.server.timecontroller.event.NewServerTime;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ public class NewServerSet
/*    */   extends EventExecutor
/*    */ {
/* 13 */   private static final Log _log = LogFactory.getLog(NewServerSet.class);
/*    */ 
/*    */   
/*    */   public static EventExecutor get() {
/* 17 */     return new NewServerSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 23 */       int time = Integer.parseInt(event.get_eventother());
/* 24 */       NewServerTime chatTime = new NewServerTime();
/* 25 */       chatTime.start(time);
/* 26 */     } catch (Exception e) {
/* 27 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\NewServerSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */