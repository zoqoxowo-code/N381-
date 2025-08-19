/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import com.lineage.server.timecontroller.event.ClanShowTimer;
/*    */ import com.lineage.server.timecontroller.event.ClanSkillTimer;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClanSkillSet
/*    */   extends EventExecutor
/*    */ {
/* 15 */   private static final Log _log = LogFactory.getLog(ClanSkillSet.class);
/*    */   
/*    */   public static boolean START = false;
/*    */   
/*    */   public static EventExecutor get() {
/* 20 */     return new ClanSkillSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 26 */       if (ClanSkillDBSet.START) {
/* 27 */         _log.info("警告!活動設置:111項血盟技能已啟動狀態下無法同時啟動伊薇版血盟技能");
/*    */       } else {
/* 29 */         START = true;
/* 30 */         ClanSkillTimer useTimer = new ClanSkillTimer();
/* 31 */         useTimer.start();
/*    */       } 
/* 33 */       ClanShowTimer clanShowTimer = new ClanShowTimer();
/* 34 */       clanShowTimer.start();
/* 35 */     } catch (Exception e) {
/* 36 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\ClanSkillSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */