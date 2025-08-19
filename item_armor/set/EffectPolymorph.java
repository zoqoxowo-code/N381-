/*    */ package com.lineage.data.item_armor.set;
/*    */ 
/*    */ import com.lineage.server.model.Instance.L1ItemInstance;
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ import com.lineage.server.model.L1Character;
/*    */ import com.lineage.server.model.L1PolyMorph;
/*    */ import com.lineage.server.serverpackets.S_ServerMessage;
/*    */ import com.lineage.server.serverpackets.ServerBasePacket;
/*    */ 
/*    */ public class EffectPolymorph implements ArmorSetEffect {
/*    */   private int _gfxId;
/*    */   
/*    */   public EffectPolymorph(int gfxId) {
/* 14 */     this._gfxId = gfxId;
/*    */   }
/*    */ 
/*    */   
/*    */   public void giveEffect(L1PcInstance pc) {
/* 19 */     int awakeSkillId = pc.getAwakeSkillId();
/* 20 */     if (awakeSkillId == 185 || awakeSkillId == 190 || awakeSkillId == 195) {
/* 21 */       pc.sendPackets((ServerBasePacket)new S_ServerMessage(1384));
/*    */       return;
/*    */     } 
/* 24 */     if (this._gfxId == 6080 || this._gfxId == 6094) {
/* 25 */       if (pc.get_sex() == 0) {
/* 26 */         this._gfxId = 6094;
/*    */       } else {
/* 28 */         this._gfxId = 6080;
/*    */       } 
/* 30 */       if (!isRemainderOfCharge(pc)) {
/*    */         return;
/*    */       }
/*    */     } 
/* 34 */     L1PolyMorph.doPoly((L1Character)pc, this._gfxId, 0, 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancelEffect(L1PcInstance pc) {
/* 39 */     int awakeSkillId = pc.getAwakeSkillId();
/* 40 */     if (awakeSkillId == 185 || awakeSkillId == 190 || awakeSkillId == 195) {
/* 41 */       pc.sendPackets((ServerBasePacket)new S_ServerMessage(1384));
/*    */       return;
/*    */     } 
/* 44 */     if (this._gfxId == 6080 || this._gfxId == 6094) {
/* 45 */       if (pc.get_sex() == 0) {
/* 46 */         this._gfxId = 6094;
/*    */       } else {
/* 48 */         this._gfxId = 6080;
/*    */       } 
/*    */     }
/* 51 */     if (pc.getTempCharGfx() != this._gfxId) {
/*    */       return;
/*    */     }
/* 54 */     L1PolyMorph.undoPoly((L1Character)pc);
/*    */   }
/*    */   
/*    */   private boolean isRemainderOfCharge(L1PcInstance pc) {
/* 58 */     if (pc.getInventory().checkItem(20383, 1L)) {
/* 59 */       L1ItemInstance item = pc.getInventory().findItemId(20383);
/* 60 */       if (item != null && item.getChargeCount() != 0) {
/* 61 */         return true;
/*    */       }
/*    */     } 
/* 64 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get_mode() {
/* 69 */     return this._gfxId;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\set\EffectPolymorph.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */