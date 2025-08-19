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
/*    */ public class ElitePlateMail_Fafurion
/*    */   extends ItemExecutor
/*    */ {
/* 19 */   private static final Log _log = LogFactory.getLog(ElitePlateMail_Fafurion.class);
/*    */   
/*    */   private int _r;
/*    */   
/*    */   private int _hp_min;
/*    */   
/*    */   private int _hp_max;
/*    */ 
/*    */   
/*    */   public static ItemExecutor get() {
/* 29 */     return new ElitePlateMail_Fafurion();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(int[] data, L1PcInstance pc, L1ItemInstance item) {
/*    */     try {
/* 35 */       if (item == null) {
/*    */         return;
/*    */       }
/* 38 */       if (pc == null) {
/*    */         return;
/*    */       }
/* 41 */       if (item.getEnchantLevel() >= 0 && item.getEnchantLevel() <= 6) {
/* 42 */         this._r = ConfigOther.FAFURION_RANDOM_6;
/* 43 */         this._hp_min = ConfigOther.FAFURION_MIN_6;
/* 44 */         this._hp_max = ConfigOther.FAFURION_MAX_6;
/*    */       }
/* 46 */       else if (item.getEnchantLevel() == 7) {
/* 47 */         this._r = ConfigOther.FAFURION_RANDOM_7;
/* 48 */         this._hp_min = ConfigOther.FAFURION_MIN_7;
/* 49 */         this._hp_max = ConfigOther.FAFURION_MAX_7;
/* 50 */       } else if (item.getEnchantLevel() == 8) {
/* 51 */         this._r = ConfigOther.FAFURION_RANDOM_8;
/* 52 */         this._hp_min = ConfigOther.FAFURION_MIN_8;
/* 53 */         this._hp_max = ConfigOther.FAFURION_MAX_8;
/* 54 */       } else if (item.getEnchantLevel() >= 9) {
/* 55 */         this._r = ConfigOther.FAFURION_RANDOM_9;
/* 56 */         this._hp_min = ConfigOther.FAFURION_MIN_9;
/* 57 */         this._hp_max = ConfigOther.FAFURION_MAX_9;
/*    */       } 
/* 59 */       switch (data[0]) {
/*    */         case 0:
/* 61 */           pc.set_elitePlateMail_Fafurion(0, 0, 0);
/*    */           break;
/*    */         
/*    */         case 1:
/* 65 */           pc.set_elitePlateMail_Fafurion(this._r, this._hp_min, this._hp_max);
/*    */           break;
/*    */       } 
/*    */     
/* 69 */     } catch (Exception e) {
/* 70 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\ElitePlateMail_Fafurion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */