/*    */ package com.lineage.data.item_armor.set;
/*    */ 
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ import com.lineage.server.serverpackets.S_SystemMessage;
/*    */ import com.lineage.server.serverpackets.ServerBasePacket;
/*    */ 
/*    */ public class Effect_Bow_modifier_dmg implements ArmorSetEffect {
/*    */   private final int _add;
/*    */   
/*    */   public Effect_Bow_modifier_dmg(int add) {
/* 11 */     this._add = add;
/*    */   }
/*    */ 
/*    */   
/*    */   public void giveEffect(L1PcInstance pc) {
/* 16 */     pc.addBowDmgup(this._add);
/* 17 */     if (pc.getarmor_setgive()) {
/* 18 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("套裝效果[遠距離攻擊]:+" + this._add));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancelEffect(L1PcInstance pc) {
/* 24 */     pc.addBowDmgup(-this._add);
/* 25 */     if (!pc.getarmor_setgive()) {
/* 26 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("移除套裝效果[遠距離攻擊]:-" + this._add));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public int get_mode() {
/* 32 */     return this._add;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\set\Effect_Bow_modifier_dmg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */