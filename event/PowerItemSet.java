/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.datatables.lock.CharItemPowerReading;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PowerItemSet
/*    */   extends EventExecutor
/*    */ {
/* 17 */   private static final Log _log = LogFactory.getLog(PowerItemSet.class);
/*    */   public static boolean START = false;
/* 19 */   public static int HOLER = 0;
/* 20 */   public static int ARMORHOLE = 0;
/* 21 */   public static int WEAPONHOLE = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static EventExecutor get() {
/* 28 */     return new PowerItemSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 34 */       START = true;
/* 35 */       String[] set = event.get_eventother().split(",");
/* 36 */       HOLER = Integer.parseInt(set[0]);
/* 37 */       ARMORHOLE = Integer.parseInt(set[1]);
/* 38 */       if (ARMORHOLE > 5) {
/* 39 */         ARMORHOLE = 5;
/*    */       }
/* 41 */       WEAPONHOLE = Integer.parseInt(set[2]);
/* 42 */       if (WEAPONHOLE > 5) {
/* 43 */         WEAPONHOLE = 5;
/*    */       }
/* 45 */       CharItemPowerReading.get().load();
/* 46 */     } catch (Exception e) {
/* 47 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\PowerItemSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */