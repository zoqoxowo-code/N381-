/*   */ package com.lineage.data.event;
/*   */ 
/*   */ import com.lineage.data.executor.EventExecutor;
/*   */ import com.lineage.server.templates.L1Event;
/*   */ 
/*   */ public class SpawnOtherSet extends EventExecutor {
/*   */   public static EventExecutor get() {
/* 8 */     return new SpawnOtherSet();
/*   */   }
/*   */   
/*   */   public void execute(L1Event event) {}
/*   */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\SpawnOtherSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */