/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.datatables.QuestTable;
/*    */ import com.lineage.server.datatables.QuesttSpawnTable;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import com.lineage.server.timecontroller.quest.ChapterQuestTimer2;
/*    */ import com.lineage.server.timecontroller.quest.QuestTimer;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QuestSet
/*    */   extends EventExecutor
/*    */ {
/* 17 */   private static final Log _log = LogFactory.getLog(QuestSet.class);
/*    */   
/*    */   public static boolean ISQUEST = false;
/*    */   
/*    */   public static EventExecutor get() {
/* 22 */     return new QuestSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 28 */       ISQUEST = true;
/* 29 */       QuestTable.get().load();
/* 30 */       if (QuestTable.get().size() > 0) {
/* 31 */         QuesttSpawnTable.get().load();
/*    */       }
/* 33 */       QuestTimer questTimer = new QuestTimer();
/* 34 */       questTimer.start();
/* 35 */       ChapterQuestTimer2 questTimer2 = new ChapterQuestTimer2();
/* 36 */       questTimer2.start();
/* 37 */     } catch (Exception e) {
/* 38 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\QuestSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */