/*    */ package com.eric;
/*    */ 
/*    */ import com.lineage.server.model.Instance.L1NpcInstance;
/*    */ import com.lineage.server.utils.L1SpawnUtil;
/*    */ import java.util.Timer;
/*    */ import java.util.TimerTask;
/*    */ 
/*    */ public class RandomMobDeleteTimer extends TimerTask {
/*    */   private int _randomMobId;
/*    */   private L1NpcInstance[] _npc;
/*    */   
/*    */   public RandomMobDeleteTimer(int randomMobId, L1NpcInstance[] npc) {
/* 13 */     this._randomMobId = randomMobId;
/* 14 */     this._npc = npc;
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 19 */     L1SpawnUtil.spawn(this._randomMobId);
/*    */     L1NpcInstance[] npc2;
/* 21 */     int length = (npc2 = this._npc).length;
/* 22 */     int i = 0;
/* 23 */     while (i < length) {
/* 24 */       L1NpcInstance npc = npc2[i];
/* 25 */       npc.deleteMe();
/* 26 */       i++;
/*    */     } 
/* 28 */     cancel();
/*    */   }
/*    */   
/*    */   public void begin() {
/* 32 */     Timer timer = new Timer();
/* 33 */     if (RandomMobTable.getInstance().getTimeSecondToDelete(this._randomMobId) > 0)
/* 34 */       timer.schedule(this, (RandomMobTable.getInstance().getTimeSecondToDelete(this._randomMobId) * 1000)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\eric\RandomMobDeleteTimer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */