/*    */ package com.lineage.data.cmd;
/*    */ 
/*    */ import com.lineage.server.datatables.lock.CharSkillReading;
/*    */ import com.lineage.server.model.Instance.L1ItemInstance;
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ import com.lineage.server.serverpackets.S_ServerMessage;
/*    */ import com.lineage.server.serverpackets.ServerBasePacket;
/*    */ 
/*    */ public class Skill_Check
/*    */ {
/*    */   public static void check(L1PcInstance pc, L1ItemInstance item, int skillid, int magicLv, int attribute) {
/* 12 */     if (CharSkillReading.get().spellCheck(pc.getId(), skillid)) {
/* 13 */       S_ServerMessage msg = new S_ServerMessage(79);
/* 14 */       pc.sendPackets((ServerBasePacket)msg);
/* 15 */     } else if (skillid != 0) {
/* 16 */       Skill_StudyingExecutor addSkill = new Skill_Studying();
/* 17 */       addSkill.magic(pc, skillid, magicLv, attribute, item.getId());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\cmd\Skill_Check.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */