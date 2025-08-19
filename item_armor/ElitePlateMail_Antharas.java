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
/*    */ public class ElitePlateMail_Antharas
/*    */   extends ItemExecutor
/*    */ {
/* 17 */   private static final Log _log = LogFactory.getLog(ElitePlateMail_Antharas.class);
/*    */   private int reduceDmg;
/*    */   
/*    */   public static ItemExecutor get() {
/* 21 */     return new ElitePlateMail_Antharas();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(int[] data, L1PcInstance pc, L1ItemInstance item) {
/*    */     try {
/* 27 */       if (item == null) {
/*    */         return;
/*    */       }
/* 30 */       if (pc == null) {
/*    */         return;
/*    */       }
/*    */       
/* 34 */       if (item.getEnchantLevel() >= 0 && item.getEnchantLevel() <= 6) {
/* 35 */         this.reduceDmg = ConfigOther.ANTHARAS_DMGR_6;
/* 36 */       } else if (item.getEnchantLevel() == 7) {
/* 37 */         this.reduceDmg = ConfigOther.ANTHARAS_DMGR_7;
/* 38 */       } else if (item.getEnchantLevel() == 8) {
/* 39 */         this.reduceDmg = ConfigOther.ANTHARAS_DMGR_8;
/* 40 */       } else if (item.getEnchantLevel() >= 9) {
/* 41 */         this.reduceDmg = ConfigOther.ANTHARAS_DMGR_9;
/*    */       } 
/*    */       
/* 44 */       switch (data[0]) {
/*    */         case 0:
/* 46 */           pc.addDamageReductionByArmor(-this.reduceDmg);
/* 47 */           pc.set_venom_resist(-1);
/*    */           break;
/*    */         
/*    */         case 1:
/* 51 */           pc.addDamageReductionByArmor(this.reduceDmg);
/* 52 */           pc.set_venom_resist(1);
/*    */           break;
/*    */       } 
/*    */     
/* 56 */     } catch (Exception e) {
/* 57 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\ElitePlateMail_Antharas.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */