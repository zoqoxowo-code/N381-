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
/*    */ 
/*    */ 
/*    */ public class Hades_Cloak
/*    */   extends ItemExecutor
/*    */ {
/* 16 */   private static final Log _log = LogFactory.getLog(Hades_Cloak.class);
/*    */   private int _r;
/*    */   
/*    */   public static ItemExecutor get() {
/* 20 */     return new Hades_Cloak();
/*    */   }
/*    */   private int _dmg_min; private int _dmg_max;
/*    */   
/*    */   public void execute(int[] data, L1PcInstance pc, L1ItemInstance item) {
/*    */     try {
/* 26 */       if (item == null) {
/*    */         return;
/*    */       }
/* 29 */       if (pc == null) {
/*    */         return;
/*    */       }
/* 32 */       switch (data[0]) {
/*    */         case 0:
/* 34 */           pc.set_hades_cloak(0, 0, 0);
/*    */           break;
/*    */         
/*    */         case 1:
/* 38 */           pc.set_hades_cloak(this._r, this._dmg_min, this._dmg_max);
/*    */           break;
/*    */       } 
/*    */     
/* 42 */     } catch (Exception e) {
/* 43 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void set_set(String[] set) {
/*    */     try {
/* 50 */       this._r = Integer.parseInt(set[1]);
/* 51 */     } catch (Exception exception) {}
/*    */     
/*    */     try {
/* 54 */       this._dmg_min = Integer.parseInt(set[2]);
/* 55 */     } catch (Exception exception) {}
/*    */     
/*    */     try {
/* 58 */       this._dmg_max = Integer.parseInt(set[3]);
/* 59 */     } catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\Hades_Cloak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */