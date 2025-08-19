/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.datatables.C1_Name_Table;
/*    */ import com.lineage.server.datatables.C1_Name_Type_Table;
/*    */ import com.lineage.server.datatables.lock.CharacterC1Reading;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CampSet
/*    */   extends EventExecutor
/*    */ {
/* 16 */   private static final Log _log = LogFactory.getLog(CampSet.class);
/*    */   
/*    */   public static boolean CAMPSTART = false;
/*    */   
/*    */   public static EventExecutor get() {
/* 21 */     return new CampSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 27 */       CAMPSTART = true;
/* 28 */       C1_Name_Table.get().load();
/* 29 */       C1_Name_Type_Table.get().load();
/* 30 */       CharacterC1Reading.get().load();
/* 31 */     } catch (Exception e) {
/* 32 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\CampSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */