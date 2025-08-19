/*    */ package com.lineage.data.item_armor;
/*    */ 
/*    */ import com.lineage.data.executor.ItemExecutor;
/*    */ import com.lineage.server.model.Instance.L1ItemInstance;
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MaiteSi_Earring
/*    */   extends ItemExecutor
/*    */ {
/* 14 */   private static final Log _log = LogFactory.getLog(MaiteSi_Earring.class);
/*    */ 
/*    */ 
/*    */   
/* 18 */   private int _uhp_number = 0;
/*    */ 
/*    */   
/*    */   public static ItemExecutor get() {
/* 22 */     return new MaiteSi_Earring();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(int[] data, L1PcInstance pc, L1ItemInstance item) {
/*    */     try {
/* 28 */       if (item == null) {
/*    */         return;
/*    */       }
/* 31 */       if (pc == null) {
/*    */         return;
/*    */       }
/* 34 */       switch (data[0]) {
/*    */         case 0:
/* 36 */           pc.add_uhp_number(-this._uhp_number);
/*    */           break;
/*    */         
/*    */         case 1:
/* 40 */           pc.add_uhp_number(this._uhp_number);
/*    */           break;
/*    */       } 
/*    */     
/* 44 */     } catch (Exception e) {
/* 45 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void set_set(String[] set) {
/*    */     try {
/* 52 */       this._uhp_number = Integer.parseInt(set[1]);
/* 53 */     } catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\MaiteSi_Earring.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */