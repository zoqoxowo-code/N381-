/*    */ package com.lineage.data.item_armor;
/*    */ 
/*    */ import com.lineage.config.ConfigOther;
/*    */ import com.lineage.data.executor.ItemExecutor;
/*    */ import com.lineage.server.model.Instance.L1ItemInstance;
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ElitePlateMail_Lindvior
/*    */   extends ItemExecutor
/*    */ {
/* 19 */   private static final Log _log = LogFactory.getLog(ElitePlateMail_Lindvior.class);
/*    */   private int _r;
/*    */   
/*    */   public static ItemExecutor get() {
/* 23 */     return new ElitePlateMail_Lindvior();
/*    */   }
/*    */   private int _mp_min; private int _mp_max;
/*    */   
/*    */   public void execute(int[] data, L1PcInstance pc, L1ItemInstance item) {
/*    */     try {
/* 29 */       if (item == null) {
/*    */         return;
/*    */       }
/* 32 */       if (pc == null) {
/*    */         return;
/*    */       }
/* 35 */       if (item.getEnchantLevel() >= 0 && item.getEnchantLevel() <= 6) {
/* 36 */         this._r = ConfigOther.LINDVIOR_RANDOM_6;
/* 37 */         this._mp_min = ConfigOther.LINDVIOR_MIN_6;
/* 38 */         this._mp_max = ConfigOther.LINDVIOR_MAX_6;
/*    */       }
/* 40 */       else if (item.getEnchantLevel() == 7) {
/* 41 */         this._r = ConfigOther.LINDVIOR_RANDOM_7;
/* 42 */         this._mp_min = ConfigOther.LINDVIOR_MIN_7;
/* 43 */         this._mp_max = ConfigOther.LINDVIOR_MAX_7;
/* 44 */       } else if (item.getEnchantLevel() == 8) {
/* 45 */         this._r = ConfigOther.LINDVIOR_RANDOM_8;
/* 46 */         this._mp_min = ConfigOther.LINDVIOR_MIN_8;
/* 47 */         this._mp_max = ConfigOther.LINDVIOR_MAX_8;
/* 48 */       } else if (item.getEnchantLevel() >= 9) {
/* 49 */         this._r = ConfigOther.LINDVIOR_RANDOM_9;
/* 50 */         this._mp_min = ConfigOther.LINDVIOR_MIN_9;
/* 51 */         this._mp_max = ConfigOther.LINDVIOR_MAX_9;
/*    */       } 
/* 53 */       switch (data[0]) {
/*    */         case 0:
/* 55 */           pc.set_elitePlateMail_Lindvior(0, 0, 0);
/*    */           break;
/*    */         
/*    */         case 1:
/* 59 */           pc.set_elitePlateMail_Lindvior(this._r, this._mp_min, this._mp_max);
/*    */           break;
/*    */       } 
/*    */     
/* 63 */     } catch (Exception e) {
/* 64 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\ElitePlateMail_Lindvior.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */