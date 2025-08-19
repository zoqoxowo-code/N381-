/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.datatables.UBSpawnTable;
/*    */ import com.lineage.server.datatables.UBTable;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import com.lineage.server.timecontroller.event.UbTime;
/*    */ 
/*    */ public class UbSet extends EventExecutor {
/*    */   public static EventExecutor get() {
/* 11 */     return new UbSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/* 16 */     UBTable.getInstance().load();
/* 17 */     UBSpawnTable.getInstance().load();
/* 18 */     UbTime ubTimeContoroller = new UbTime();
/* 19 */     ubTimeContoroller.start();
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\UbSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */