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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ProtectorSet
/*    */   extends EventExecutor
/*    */ {
/* 22 */   private static final Log _log = LogFactory.getLog(ProtectorSet.class); public static int ITEM_ID; public static int CHANCE; public static int DROP_LIMIT; public static int HP_UP;
/*    */   public static int MP_UP;
/*    */   
/*    */   public static EventExecutor get() {
/* 26 */     return new ProtectorSet();
/*    */   }
/*    */   public static int DMG_UP; public static int DMG_DOWN; public static int SP_UP; public static boolean DEATH_VALUE_EXP; public static boolean DEATH_VALUE_ITEM;
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 32 */       String[] set = event.get_eventother().split(",");
/* 33 */       ITEM_ID = Integer.parseInt(set[0]);
/* 34 */       CHANCE = Integer.parseInt(set[1]);
/* 35 */       DROP_LIMIT = Integer.parseInt(set[2]);
/* 36 */       HP_UP = Integer.parseInt(set[3]);
/* 37 */       MP_UP = Integer.parseInt(set[4]);
/* 38 */       DMG_UP = Integer.parseInt(set[5]);
/* 39 */       DMG_DOWN = Integer.parseInt(set[6]);
/* 40 */       SP_UP = Integer.parseInt(set[7]);
/* 41 */       DEATH_VALUE_EXP = Boolean.parseBoolean(set[8]);
/* 42 */       DEATH_VALUE_ITEM = Boolean.parseBoolean(set[9]);
/* 43 */     } catch (Exception e) {
/* 44 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\ProtectorSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */