/*    */ package com.add;
/*    */ 
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ import com.lineage.server.serverpackets.S_CharVisualUpdate;
/*    */ import com.lineage.server.serverpackets.S_OwnCharPack;
/*    */ import com.lineage.server.serverpackets.ServerBasePacket;
/*    */ 
/*    */ public class L1PcUnlock {
/*    */   public static void Pc_Unlock(L1PcInstance pc) {
/* 10 */     if (pc == null) {
/*    */       return;
/*    */     }
/* 13 */     pc.sendPackets((ServerBasePacket)new S_OwnCharPack(pc));
/* 14 */     pc.removeAllKnownObjects();
/* 15 */     pc.updateObject();
/* 16 */     pc.sendVisualEffectAtTeleport();
/* 17 */     pc.sendPackets((ServerBasePacket)new S_CharVisualUpdate(pc));
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\L1PcUnlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */