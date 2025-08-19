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
/*    */ 
/*    */ 
/*    */ public class DimiterBlessRune
/*    */   extends ItemExecutor
/*    */ {
/* 18 */   private static final Log _log = LogFactory.getLog(DimiterBlessRune.class); private int _r;
/*    */   private int _mp_min;
/*    */   
/*    */   public static ItemExecutor get() {
/* 22 */     return new DimiterBlessRune();
/*    */   }
/*    */   private int _mp_max; private int _r2; private int _time;
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
/* 36 */           pc.set_DimiterBless(0, 0, 0, 0, 0);
/*    */           break;
/*    */         
/*    */         case 1:
/* 40 */           pc.set_DimiterBless(this._r, this._mp_min, this._mp_max, this._r2, this._time);
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
/* 52 */       this._r = Integer.parseInt(set[1]);
/* 53 */     } catch (Exception exception) {}
/*    */     
/*    */     try {
/* 56 */       this._mp_min = Integer.parseInt(set[2]);
/* 57 */     } catch (Exception exception) {}
/*    */     
/*    */     try {
/* 60 */       this._mp_max = Integer.parseInt(set[3]);
/* 61 */     } catch (Exception exception) {}
/*    */     
/*    */     try {
/* 64 */       this._r2 = Integer.parseInt(set[4]);
/* 65 */     } catch (Exception exception) {}
/*    */     
/*    */     try {
/* 68 */       this._time = Integer.parseInt(set[5]);
/* 69 */     } catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\DimiterBlessRune.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */