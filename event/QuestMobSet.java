/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.datatables.ServerQuestMobTable;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QuestMobSet
/*    */   extends EventExecutor
/*    */ {
/* 14 */   private static final Log _log = LogFactory.getLog(QuestMobSet.class);
/*    */   
/*    */   public static boolean START = false;
/*    */   
/*    */   public static EventExecutor get() {
/* 19 */     return new QuestMobSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 25 */       START = true;
/* 26 */       ServerQuestMobTable.get();
/* 27 */     } catch (Exception e) {
/* 28 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\QuestMobSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */