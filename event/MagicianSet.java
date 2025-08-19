/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MagicianSet
/*    */   extends EventExecutor
/*    */ {
/* 14 */   private static final Log _log = LogFactory.getLog(MagicianSet.class);
/*    */   public static int ITEM_ID;
/*    */   
/*    */   public static EventExecutor get() {
/* 18 */     return new MagicianSet();
/*    */   }
/*    */   public static int ITEM_COUNT;
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 24 */       String[] set = event.get_eventother().split(",");
/* 25 */       ITEM_ID = Integer.parseInt(set[0]);
/* 26 */       ITEM_COUNT = Integer.parseInt(set[1]);
/* 27 */     } catch (Exception e) {
/* 28 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\MagicianSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */