/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.config.ConfigOther;
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import com.lineage.server.timecontroller.event.ranking.RankingClanTimer;
/*    */ import com.lineage.server.timecontroller.event.ranking.RankingHeroTimer;
/*    */ import com.lineage.server.timecontroller.event.ranking.RankingHeroTimerlv;
/*    */ import com.lineage.server.timecontroller.event.ranking.RankingKillTimer;
/*    */ import com.lineage.server.timecontroller.event.ranking.RankingWealthTimer;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ public class Ranking4
/*    */   extends EventExecutor
/*    */ {
/* 18 */   private static final Log _log = LogFactory.getLog(Ranking4.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static EventExecutor get() {
/* 25 */     return new Ranking4();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 31 */       RankingKillTimer killTimer = new RankingKillTimer();
/* 32 */       killTimer.start();
/* 33 */       Thread.sleep(500L);
/* 34 */       RankingWealthTimer wealthTimer = new RankingWealthTimer();
/* 35 */       wealthTimer.start();
/* 36 */       Thread.sleep(500L);
/* 37 */       if (ConfigOther.RankLevel) {
/* 38 */         RankingHeroTimerlv heroTimer = new RankingHeroTimerlv();
/* 39 */         heroTimer.start();
/*    */       } else {
/* 41 */         RankingHeroTimer heroTimer2 = new RankingHeroTimer();
/* 42 */         heroTimer2.start();
/*    */       } 
/* 44 */       Thread.sleep(500L);
/* 45 */       RankingClanTimer clanRTimer = new RankingClanTimer();
/* 46 */       clanRTimer.start();
/* 47 */     } catch (Exception e) {
/* 48 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\Ranking4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */