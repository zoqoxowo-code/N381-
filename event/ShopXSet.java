/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.datatables.ShopXTable;
/*    */ import com.lineage.server.datatables.lock.DwarfShopReading;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import com.lineage.server.timecontroller.event.ShopXTime;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShopXSet
/*    */   extends EventExecutor
/*    */ {
/* 19 */   private static final Log _log = LogFactory.getLog(ShopXSet.class); public static int ADENA;
/*    */   public static int DATE;
/*    */   
/*    */   public static EventExecutor get() {
/* 23 */     return new ShopXSet();
/*    */   }
/*    */   public static int MIN; public static int MAX;
/*    */   
/*    */   public void execute(L1Event event) {
/*    */     try {
/* 29 */       String[] set = event.get_eventother().split(",");
/* 30 */       ADENA = Integer.parseInt(set[0]);
/* 31 */       DATE = Integer.parseInt(set[1]);
/* 32 */       MIN = Integer.parseInt(set[2]);
/* 33 */       MAX = Integer.parseInt(set[3]);
/* 34 */       DwarfShopReading.get().load();
/* 35 */       ShopXTable.get().load();
/* 36 */       ShopXTime timer = new ShopXTime();
/* 37 */       timer.start();
/* 38 */     } catch (Exception e) {
/* 39 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\ShopXSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */