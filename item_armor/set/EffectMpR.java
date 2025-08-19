/*    */ package com.lineage.data.item_armor.set;
/*    */ 
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ import com.lineage.server.serverpackets.S_SystemMessage;
/*    */ import com.lineage.server.serverpackets.ServerBasePacket;
/*    */ 
/*    */ public class EffectMpR implements ArmorSetEffect {
/*    */   private final int _add;
/*    */   
/*    */   public EffectMpR(int add) {
/* 11 */     this._add = add;
/*    */   }
/*    */ 
/*    */   
/*    */   public void giveEffect(L1PcInstance pc) {
/* 16 */     pc.addMpr(this._add);
/* 17 */     if (pc.getarmor_setgive()) {
/* 18 */       String type = "";
/* 19 */       if (this._add > 0) {
/* 20 */         type = "+";
/*    */       }
/* 22 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("套裝效果[回魔]:" + type + this._add));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancelEffect(L1PcInstance pc) {
/* 28 */     pc.addMpr(-this._add);
/* 29 */     if (!pc.getarmor_setgive()) {
/* 30 */       if (this._add < 0) {
/* 31 */         pc.sendPackets((ServerBasePacket)new S_SystemMessage("移除套裝效果[回魔]:+" + -this._add));
/*    */       } else {
/* 33 */         pc.sendPackets((ServerBasePacket)new S_SystemMessage("移除套裝效果[回魔]:+" + this._add));
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public int get_mode() {
/* 40 */     return this._add;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\set\EffectMpR.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */