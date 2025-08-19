/*    */ package com.lineage.data.executor;
/*    */ 
/*    */ import com.lineage.server.model.Instance.L1NpcInstance;
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ import com.lineage.server.model.L1Character;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class NpcExecutor
/*    */ {
/*    */   public abstract int type();
/*    */   
/*    */   public void talk(L1PcInstance pc, L1NpcInstance npc) {}
/*    */   
/*    */   public void action(L1PcInstance pc, L1NpcInstance npc, String cmd, long amount) {}
/*    */   
/*    */   public void attack(L1PcInstance pc, L1NpcInstance npc) {}
/*    */   
/*    */   public L1PcInstance death(L1Character lastAttacker, L1NpcInstance npc) {
/* 20 */     return null;
/*    */   }
/*    */   
/*    */   public int workTime() {
/* 24 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void work(L1NpcInstance npc) {}
/*    */ 
/*    */   
/*    */   public void spawn(L1NpcInstance npc) {}
/*    */   
/*    */   public String[] get_set() {
/* 34 */     return null;
/*    */   }
/*    */   
/*    */   public void set_set(String[] set) {}
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\executor\NpcExecutor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */