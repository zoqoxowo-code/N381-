/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FeatureItemSet
/*    */   extends EventExecutor
/*    */ {
/* 13 */   private static final Log _log = LogFactory.getLog(FeatureItemSet.class);
/*    */   
/*    */   public static boolean POWER_START = false;
/*    */   
/*    */   public static EventExecutor get() {
/* 18 */     return new FeatureItemSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 24 */       String[] set = event.get_eventother().split(",");
/* 25 */       POWER_START = Boolean.parseBoolean(set[0]);
/* 26 */     } catch (Exception e) {
/* 27 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\FeatureItemSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */