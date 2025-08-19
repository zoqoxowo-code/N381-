/*    */ package com.add;
/*    */ 
/*    */ import com.lineage.config.ConfigOther;
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ import com.lineage.server.thread.GeneralThreadPool;
/*    */ import com.lineage.server.world.World;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class L1DayPresentTimer {
/*    */   private static MessageTimer _messageTimer;
/*    */   
/*    */   public static void initialize() {
/* 13 */     _messageTimer = new MessageTimer(null);
/* 14 */     GeneralThreadPool.get().execute(_messageTimer);
/*    */   }
/*    */   
/*    */   private static void ShowMessageToAll() {
/* 18 */     Iterator<L1PcInstance> iterator = World.get().getAllPlayers().iterator();
/* 19 */     while (iterator.hasNext()) {
/* 20 */       L1PcInstance pc = iterator.next();
/* 21 */       L1DayPresent.forTimeMessage(pc);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static class MessageTimer
/*    */     implements Runnable {
/*    */     public void run() {
/* 28 */       int time = ConfigOther.onlydaytime;
/*    */       while (true) {
/*    */         try {
/* 31 */           Thread.sleep(time);
/* 32 */         } catch (Exception exception) {
/*    */           return;
/*    */         } 
/* 35 */         L1DayPresentTimer.ShowMessageToAll();
/*    */       } 
/*    */     }
/*    */     
/*    */     private MessageTimer() {}
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\L1DayPresentTimer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */