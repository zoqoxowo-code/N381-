/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ public class MazuSet
/*    */   extends EventExecutor
/*    */ {
/* 12 */   private static final Log _log = LogFactory.getLog(MazuSet.class);
/*    */ 
/*    */   
/*    */   public static EventExecutor get() {
/* 16 */     return new MazuSet();
/*    */   }
/*    */   
/*    */   public void execute(L1Event event) {}
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\MazuSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */