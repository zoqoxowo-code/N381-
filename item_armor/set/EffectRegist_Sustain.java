/*    */ package com.lineage.data.item_armor.set;
/*    */ 
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ 
/*    */ public class EffectRegist_Sustain implements ArmorSetEffect {
/*    */   private final int _add;
/*    */   
/*    */   public EffectRegist_Sustain(int add) {
/*  9 */     this._add = add;
/*    */   }
/*    */ 
/*    */   
/*    */   public void giveEffect(L1PcInstance pc) {
/* 14 */     pc.addRegistSustain(this._add);
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancelEffect(L1PcInstance pc) {
/* 19 */     pc.addRegistSustain(-this._add);
/*    */   }
/*    */ 
/*    */   
/*    */   public int get_mode() {
/* 24 */     return this._add;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\set\EffectRegist_Sustain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */