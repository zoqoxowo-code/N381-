/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.datatables.ItemUpdateTable;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemUpdateSet
/*    */   extends EventExecutor
/*    */ {
/* 14 */   private static final Log _log = LogFactory.getLog(ItemUpdateSet.class);
/*    */   
/*    */   public static boolean MODE = false;
/*    */   
/*    */   public static EventExecutor get() {
/* 19 */     return new ItemUpdateSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 25 */       String[] set = event.get_eventother().split(",");
/* 26 */       MODE = Boolean.parseBoolean(set[0]);
/* 27 */       ItemUpdateTable.get().load();
/* 28 */     } catch (Exception e) {
/* 29 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\ItemUpdateSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */