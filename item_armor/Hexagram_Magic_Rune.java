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
/*    */ public class Hexagram_Magic_Rune
/*    */   extends ItemExecutor
/*    */ {
/* 17 */   private static final Log _log = LogFactory.getLog(Hexagram_Magic_Rune.class);
/*    */ 
/*    */ 
/*    */   
/* 21 */   private int _r = 0;
/* 22 */   private int _hp_min = 0;
/* 23 */   private int _hp_max = 0;
/* 24 */   private int _gfx = 0;
/*    */ 
/*    */   
/*    */   public static ItemExecutor get() {
/* 28 */     return new Hexagram_Magic_Rune();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(int[] data, L1PcInstance pc, L1ItemInstance item) {
/*    */     try {
/* 34 */       if (item == null) {
/*    */         return;
/*    */       }
/* 37 */       if (pc == null) {
/*    */         return;
/*    */       }
/* 40 */       switch (data[0]) {
/*    */         case 0:
/* 42 */           pc.set_Hexagram_Magic_Rune(0, 0, 0, 0);
/*    */           break;
/*    */         
/*    */         case 1:
/* 46 */           pc.set_Hexagram_Magic_Rune(this._r, this._hp_min, this._hp_max, this._gfx);
/*    */           break;
/*    */       } 
/*    */     
/* 50 */     } catch (Exception e) {
/* 51 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void set_set(String[] set) {
/*    */     try {
/* 58 */       this._r = Integer.parseInt(set[1]);
/* 59 */     } catch (Exception exception) {}
/*    */     
/*    */     try {
/* 62 */       this._hp_min = Integer.parseInt(set[2]);
/* 63 */     } catch (Exception exception) {}
/*    */     
/*    */     try {
/* 66 */       this._hp_max = Integer.parseInt(set[3]);
/* 67 */     } catch (Exception exception) {}
/*    */     
/*    */     try {
/* 70 */       this._gfx = Integer.parseInt(set[4]);
/* 71 */     } catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\Hexagram_Magic_Rune.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */