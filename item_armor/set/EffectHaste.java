/*    */ package com.lineage.data.item_armor.set;
/*    */ 
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ import com.lineage.server.serverpackets.S_SkillHaste;
/*    */ import com.lineage.server.serverpackets.S_SystemMessage;
/*    */ import com.lineage.server.serverpackets.ServerBasePacket;
/*    */ 
/*    */ public class EffectHaste implements ArmorSetEffect {
/*    */   private final int _add;
/*    */   
/*    */   public EffectHaste(int add) {
/* 12 */     this._add = add;
/*    */   }
/*    */ 
/*    */   
/*    */   public void giveEffect(L1PcInstance pc) {
/* 17 */     pc.addHasteItemEquipped(this._add);
/* 18 */     pc.removeHasteSkillEffect();
/* 19 */     pc.sendPackets((ServerBasePacket)new S_SkillHaste(pc.getId(), 1, -1));
/* 20 */     if (pc.getMoveSpeed() != 1) {
/* 21 */       pc.setMoveSpeed(1);
/* 22 */       pc.broadcastPacketAll((ServerBasePacket)new S_SkillHaste(pc.getId(), 1, 0));
/*    */     } 
/* 24 */     if (pc.getarmor_setgive()) {
/* 25 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("套裝效果[綠水狀態]"));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancelEffect(L1PcInstance pc) {
/* 31 */     pc.addHasteItemEquipped(-this._add);
/* 32 */     if (pc.getHasteItemEquipped() == 0) {
/* 33 */       pc.setMoveSpeed(0);
/* 34 */       pc.sendPacketsAll((ServerBasePacket)new S_SkillHaste(pc.getId(), 0, 0));
/*    */     } 
/* 36 */     if (pc.getarmor_setgive()) {
/* 37 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("移除套裝效果[綠水狀態]"));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public int get_mode() {
/* 43 */     return this._add;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\set\EffectHaste.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */