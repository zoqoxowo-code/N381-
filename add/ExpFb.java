/*    */ package com.add;
/*    */ 
/*    */ import com.lineage.data.npc.other.exp_game01;
/*    */ import com.lineage.data.npc.other.exp_game02;
/*    */ import com.lineage.data.npc.other.exp_game03;
/*    */ import com.lineage.data.npc.other.exp_game04;
/*    */ import com.lineage.data.npc.other.exp_game05;
/*    */ import com.lineage.data.npc.other.exp_game06;
/*    */ import com.lineage.data.npc.other.exp_game07;
/*    */ import com.lineage.data.npc.other.exp_game08;
/*    */ import com.lineage.data.npc.other.exp_game09;
/*    */ import com.lineage.data.npc.other.exp_game1;
/*    */ import com.lineage.data.npc.other.exp_game2;
/*    */ import com.lineage.data.npc.other.exp_game3;
/*    */ import com.lineage.data.npc.other.exp_game4;
/*    */ import com.lineage.data.npc.other.exp_game5;
/*    */ import com.lineage.data.npc.other.exp_game6;
/*    */ import com.lineage.data.npc.other.exp_game7;
/*    */ import com.lineage.data.npc.other.exp_game8;
/*    */ import com.lineage.data.npc.other.exp_game9;
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ import com.lineage.server.serverpackets.S_SystemMessage;
/*    */ import com.lineage.server.serverpackets.ServerBasePacket;
/*    */ import java.util.logging.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExpFb
/*    */ {
/* 31 */   private static Logger _log = Logger.getLogger(ExpFb.class.getName());
/*    */   private static ExpFb _instance;
/*    */   
/*    */   public static ExpFb getInstance() {
/* 35 */     if (_instance == null) {
/* 36 */       _instance = new ExpFb();
/*    */     }
/* 38 */     return _instance;
/*    */   }
/*    */   
/*    */   public void PcCommand(L1PcInstance pc, String cmd) {
/* 42 */     if (cmd.equalsIgnoreCase("exp_game1")) {
/* 43 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("該天賦技能已滿"));
/* 44 */       exp_game1.getInstance().enterTextTask(pc);
/* 45 */     } else if (cmd.equalsIgnoreCase("exp_game2")) {
/* 46 */       exp_game2.getInstance().enterTextTask(pc);
/* 47 */     } else if (cmd.equalsIgnoreCase("exp_game3")) {
/* 48 */       exp_game3.getInstance().enterTextTask(pc);
/* 49 */     } else if (cmd.equalsIgnoreCase("exp_game4")) {
/* 50 */       exp_game4.getInstance().enterTextTask(pc);
/* 51 */     } else if (cmd.equalsIgnoreCase("exp_game5")) {
/* 52 */       exp_game5.getInstance().enterTextTask(pc);
/* 53 */     } else if (cmd.equalsIgnoreCase("exp_game6")) {
/* 54 */       exp_game6.getInstance().enterTextTask(pc);
/* 55 */     } else if (cmd.equalsIgnoreCase("exp_game7")) {
/* 56 */       exp_game7.getInstance().enterTextTask(pc);
/* 57 */     } else if (cmd.equalsIgnoreCase("exp_game8")) {
/* 58 */       exp_game8.getInstance().enterTextTask(pc);
/* 59 */     } else if (cmd.equalsIgnoreCase("exp_game9")) {
/* 60 */       exp_game9.getInstance().enterTextTask(pc);
/* 61 */     } else if (cmd.equalsIgnoreCase("exp_game01")) {
/* 62 */       exp_game01.getInstance().enterTextTask(pc);
/* 63 */     } else if (cmd.equalsIgnoreCase("exp_game02")) {
/* 64 */       exp_game02.getInstance().enterTextTask(pc);
/* 65 */     } else if (cmd.equalsIgnoreCase("exp_game03")) {
/* 66 */       exp_game03.getInstance().enterTextTask(pc);
/* 67 */     } else if (cmd.equalsIgnoreCase("exp_game04")) {
/* 68 */       exp_game04.getInstance().enterTextTask(pc);
/* 69 */     } else if (cmd.equalsIgnoreCase("exp_game05")) {
/* 70 */       exp_game05.getInstance().enterTextTask(pc);
/* 71 */     } else if (cmd.equalsIgnoreCase("exp_game06")) {
/* 72 */       exp_game06.getInstance().enterTextTask(pc);
/* 73 */     } else if (cmd.equalsIgnoreCase("exp_game07")) {
/* 74 */       exp_game07.getInstance().enterTextTask(pc);
/* 75 */     } else if (cmd.equalsIgnoreCase("exp_game08")) {
/* 76 */       exp_game08.getInstance().enterTextTask(pc);
/* 77 */     } else if (cmd.equalsIgnoreCase("exp_game09")) {
/* 78 */       exp_game09.getInstance().enterTextTask(pc);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\ExpFb.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */