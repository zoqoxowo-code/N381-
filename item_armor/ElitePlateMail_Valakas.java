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
/*    */ public class ElitePlateMail_Valakas
/*    */   extends ItemExecutor
/*    */ {
/* 18 */   private static final Log _log = LogFactory.getLog(ElitePlateMail_Valakas.class);
/*    */   private int _dmg;
/*    */   
/*    */   public static ItemExecutor get() {
/* 22 */     return new ElitePlateMail_Valakas();
/*    */   }
/*    */   private int _bowdmg;
/*    */   
/*    */   public void execute(int[] data, L1PcInstance pc, L1ItemInstance item) {
/*    */     try {
/* 28 */       if (item == null) {
/*    */         return;
/*    */       }
/* 31 */       if (pc == null) {
/*    */         return;
/*    */       }
/* 34 */       if (item.getEnchantLevel() >= 0 && item.getEnchantLevel() <= 6) {
/* 35 */         this._dmg = ConfigOther.VALAKAS_DMG_6;
/* 36 */         this._bowdmg = ConfigOther.VALAKAS_BOWDMG_6;
/* 37 */       } else if (item.getEnchantLevel() == 7) {
/* 38 */         this._dmg = ConfigOther.VALAKAS_DMG_7;
/* 39 */         this._bowdmg = ConfigOther.VALAKAS_BOWDMG_7;
/* 40 */       } else if (item.getEnchantLevel() == 8) {
/* 41 */         this._dmg = ConfigOther.VALAKAS_DMG_8;
/* 42 */         this._bowdmg = ConfigOther.VALAKAS_BOWDMG_8;
/* 43 */       } else if (item.getEnchantLevel() >= 9) {
/* 44 */         this._dmg = ConfigOther.VALAKAS_DMG_9;
/* 45 */         this._bowdmg = ConfigOther.VALAKAS_BOWDMG_9;
/*    */       } 
/* 47 */       switch (data[0]) {
/*    */         case 0:
/* 49 */           pc.set_elitePlateMail_Valakas(0, 0);
/*    */           break;
/*    */         
/*    */         case 1:
/* 53 */           pc.set_elitePlateMail_Valakas(this._dmg, this._bowdmg);
/*    */           break;
/*    */       } 
/*    */     
/* 57 */     } catch (Exception e) {
/* 58 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\ElitePlateMail_Valakas.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */