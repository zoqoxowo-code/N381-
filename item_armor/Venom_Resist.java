/*    */ package com.lineage.data.item_armor;
/*    */ 
/*    */ import com.lineage.data.executor.ItemExecutor;
/*    */ import com.lineage.server.model.Instance.L1ItemInstance;
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ public class Venom_Resist
/*    */   extends ItemExecutor
/*    */ {
/* 13 */   private static final Log _log = LogFactory.getLog(Venom_Resist.class);
/*    */ 
/*    */   
/*    */   public static ItemExecutor get() {
/* 17 */     return new Venom_Resist();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(int[] data, L1PcInstance pc, L1ItemInstance item) {
/*    */     try {
/* 23 */       if (item == null) {
/*    */         return;
/*    */       }
/* 26 */       if (pc == null) {
/*    */         return;
/*    */       }
/* 29 */       switch (data[0]) {
/*    */         case 0:
/* 31 */           pc.set_venom_resist(-1);
/*    */           break;
/*    */         
/*    */         case 1:
/* 35 */           pc.set_venom_resist(1);
/*    */           break;
/*    */       } 
/*    */     
/* 39 */     } catch (Exception e) {
/* 40 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\Venom_Resist.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */