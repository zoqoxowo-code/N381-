/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.datatables.RewardArmorTable;
/*    */ import com.lineage.server.datatables.RewardWeaponTable;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class weaponlvdmg
/*    */   extends EventExecutor
/*    */ {
/* 15 */   private static final Log _log = LogFactory.getLog(weaponlvdmg.class);
/*    */   
/*    */   public static boolean START = false;
/*    */   
/*    */   public static EventExecutor get() {
/* 20 */     return new weaponlvdmg();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 26 */       START = true;
/* 27 */       RewardWeaponTable.get();
/* 28 */       RewardArmorTable.getInstance();
/* 29 */     } catch (Exception e) {
/* 30 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\weaponlvdmg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */