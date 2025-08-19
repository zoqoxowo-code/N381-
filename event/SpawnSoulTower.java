/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ 
/*    */ 
/*    */ public class SpawnSoulTower
/*    */   extends EventExecutor
/*    */ {
/*    */   public static EventExecutor get() {
/* 11 */     return new SpawnSoulTower();
/*    */   }
/*    */   
/*    */   public void execute(L1Event event) {}
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\SpawnSoulTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */