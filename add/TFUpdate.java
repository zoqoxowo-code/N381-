/*     */ package com.add;
/*     */ 
/*     */ import com.lineage.config.Configtf;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.serverpackets.S_HPUpdate;
/*     */ import com.lineage.server.serverpackets.S_MPUpdate;
/*     */ import com.lineage.server.serverpackets.S_NPCTalkReturn;
/*     */ import com.lineage.server.serverpackets.S_OwnCharStatus2;
/*     */ import com.lineage.server.serverpackets.S_SPMR;
/*     */ import com.lineage.server.serverpackets.S_SystemMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TFUpdate
/*     */ {
/*  19 */   private static Logger _log = Logger.getLogger(TFUpdate.class.getName());
/*     */   private static TFUpdate _instance;
/*     */   
/*     */   public static TFUpdate getInstance() {
/*  23 */     if (_instance == null) {
/*  24 */       _instance = new TFUpdate();
/*     */     }
/*  26 */     return _instance;
/*     */   }
/*     */   
/*     */   public boolean PcCommand(L1PcInstance pc, String cmd) {
/*  30 */     if (cmd.equalsIgnoreCase("aaa")) {
/*  31 */       boolean isTalent = false;
/*  32 */       if (pc.get_other2().get_TfCount() > 0) {
/*  33 */         isTalent = true;
/*     */       }
/*  35 */       if (isTalent) {
/*  36 */         if (pc.get_other2().get_Str() >= Configtf.tfup1) {
/*  37 */           pc.sendPackets((ServerBasePacket)new S_SystemMessage("該天賦技能已滿"));
/*  38 */           isTalent = false;
/*     */         } else {
/*  40 */           pc.get_other2().set_Str(pc.get_other2().get_Str() + Configtf.tftype1);
/*  41 */           pc.get_other2().set_TfCount(pc.get_other2().get_TfCount() - 1);
/*  42 */           pc.get_other2().set_TfCount1(pc.get_other2().get_TfCount1() + 1);
/*  43 */           pc.addStr(Configtf.tftype1);
/*  44 */           pc.sendPackets((ServerBasePacket)new S_OwnCharStatus2(pc));
/*     */         } 
/*     */       }
/*  47 */       TF(pc);
/*  48 */     } else if (cmd.equalsIgnoreCase("bbb")) {
/*  49 */       boolean isTalent = false;
/*  50 */       if (pc.get_other2().get_TfCount() > 0) {
/*  51 */         isTalent = true;
/*     */       }
/*  53 */       if (isTalent) {
/*  54 */         if (pc.get_other2().get_Dex() >= Configtf.tfup2) {
/*  55 */           pc.sendPackets((ServerBasePacket)new S_SystemMessage("該天賦技能已滿"));
/*  56 */           isTalent = false;
/*     */         } else {
/*  58 */           pc.get_other2().set_Dex(pc.get_other2().get_Dex() + Configtf.tftype2);
/*  59 */           pc.get_other2().set_TfCount(pc.get_other2().get_TfCount() - 1);
/*  60 */           pc.get_other2().set_TfCount1(pc.get_other2().get_TfCount1() + 1);
/*  61 */           pc.addDex(Configtf.tftype2);
/*  62 */           pc.sendPackets((ServerBasePacket)new S_OwnCharStatus2(pc));
/*     */         } 
/*     */       }
/*  65 */       TF(pc);
/*  66 */     } else if (cmd.equalsIgnoreCase("ccc")) {
/*  67 */       boolean isTalent = false;
/*  68 */       if (pc.get_other2().get_TfCount() > 0) {
/*  69 */         isTalent = true;
/*     */       }
/*  71 */       if (isTalent) {
/*  72 */         if (pc.get_other2().get_Int() >= Configtf.tfup3) {
/*  73 */           pc.sendPackets((ServerBasePacket)new S_SystemMessage("該天賦技能已滿"));
/*  74 */           isTalent = false;
/*     */         } else {
/*  76 */           pc.get_other2().set_Int(pc.get_other2().get_Int() + Configtf.tftype3);
/*  77 */           pc.get_other2().set_TfCount(pc.get_other2().get_TfCount() - 1);
/*  78 */           pc.get_other2().set_TfCount1(pc.get_other2().get_TfCount1() + 1);
/*  79 */           pc.addInt(Configtf.tftype3);
/*  80 */           pc.sendPackets((ServerBasePacket)new S_OwnCharStatus2(pc));
/*     */         } 
/*     */       }
/*  83 */       TF(pc);
/*  84 */     } else if (cmd.equalsIgnoreCase("ddd")) {
/*  85 */       boolean isTalent = false;
/*  86 */       if (pc.get_other2().get_TfCount() > 0) {
/*  87 */         isTalent = true;
/*     */       }
/*  89 */       if (isTalent) {
/*  90 */         if (pc.get_other2().get_Attack() >= Configtf.tfup4) {
/*  91 */           pc.sendPackets((ServerBasePacket)new S_SystemMessage("該天賦技能已滿"));
/*  92 */           isTalent = false;
/*     */         } else {
/*  94 */           pc.get_other2().set_Attack(pc.get_other2().get_Attack() + Configtf.tftype4);
/*  95 */           pc.get_other2().set_TfCount(pc.get_other2().get_TfCount() - 1);
/*  96 */           pc.get_other2().set_TfCount1(pc.get_other2().get_TfCount1() + 1);
/*  97 */           pc.addDmgup(Configtf.tftype4);
/*     */         } 
/*     */       }
/* 100 */       TF(pc);
/* 101 */     } else if (cmd.equalsIgnoreCase("eee")) {
/* 102 */       boolean isTalent = false;
/* 103 */       if (pc.get_other2().get_TfCount() > 0) {
/* 104 */         isTalent = true;
/*     */       }
/* 106 */       if (isTalent) {
/* 107 */         if (pc.get_other2().get_BowAttack() >= Configtf.tfup5) {
/* 108 */           pc.sendPackets((ServerBasePacket)new S_SystemMessage("該天賦技能已滿"));
/* 109 */           isTalent = false;
/*     */         } else {
/* 111 */           pc.get_other2().set_BowAttack(pc.get_other2().get_BowAttack() + Configtf.tftype5);
/* 112 */           pc.get_other2().set_TfCount(pc.get_other2().get_TfCount() - 1);
/* 113 */           pc.get_other2().set_TfCount1(pc.get_other2().get_TfCount1() + 1);
/* 114 */           pc.addBowDmgup(Configtf.tftype5);
/*     */         } 
/*     */       }
/* 117 */       TF(pc);
/* 118 */     } else if (cmd.equalsIgnoreCase("fff")) {
/* 119 */       boolean isTalent = false;
/* 120 */       if (pc.get_other2().get_TfCount() > 0) {
/* 121 */         isTalent = true;
/*     */       }
/* 123 */       if (isTalent) {
/* 124 */         if (pc.get_other2().get_Hp() >= Configtf.tfup6) {
/* 125 */           pc.sendPackets((ServerBasePacket)new S_SystemMessage("該天賦技能已滿"));
/* 126 */           isTalent = false;
/*     */         } else {
/* 128 */           pc.get_other2().set_Hp(pc.get_other2().get_Hp() + Configtf.tftype6);
/* 129 */           pc.get_other2().set_TfCount(pc.get_other2().get_TfCount() - 1);
/* 130 */           pc.get_other2().set_TfCount1(pc.get_other2().get_TfCount1() + 1);
/* 131 */           pc.addMaxHp(Configtf.tftype6);
/* 132 */           pc.sendPackets((ServerBasePacket)new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
/*     */         } 
/*     */       }
/* 135 */       TF(pc);
/* 136 */     } else if (cmd.equalsIgnoreCase("ggg")) {
/* 137 */       boolean isTalent = false;
/* 138 */       if (pc.get_other2().get_TfCount() > 0) {
/* 139 */         isTalent = true;
/*     */       }
/* 141 */       if (isTalent) {
/* 142 */         if (pc.get_other2().get_Mp() >= Configtf.tfup7) {
/* 143 */           pc.sendPackets((ServerBasePacket)new S_SystemMessage("該天賦技能已滿"));
/* 144 */           isTalent = false;
/*     */         } else {
/* 146 */           pc.get_other2().set_Mp(pc.get_other2().get_Mp() + Configtf.tftype7);
/* 147 */           pc.get_other2().set_TfCount(pc.get_other2().get_TfCount() - 1);
/* 148 */           pc.get_other2().set_TfCount1(pc.get_other2().get_TfCount1() + 1);
/* 149 */           pc.addMaxMp(Configtf.tftype7);
/* 150 */           pc.sendPackets((ServerBasePacket)new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
/*     */         } 
/*     */       }
/* 153 */       TF(pc);
/* 154 */     } else if (cmd.equalsIgnoreCase("hhh")) {
/* 155 */       boolean isTalent = false;
/* 156 */       if (pc.get_other2().get_TfCount() > 0) {
/* 157 */         isTalent = true;
/*     */       }
/* 159 */       if (isTalent) {
/* 160 */         if (pc.get_other2().get_ReductionDmg() >= Configtf.tfup8) {
/* 161 */           pc.sendPackets((ServerBasePacket)new S_SystemMessage("該天賦技能已滿"));
/* 162 */           isTalent = false;
/*     */         } else {
/* 164 */           pc.get_other2().set_ReductionDmg(pc.get_other2().get_ReductionDmg() + Configtf.tftype8);
/* 165 */           pc.get_other2().set_TfCount(pc.get_other2().get_TfCount() - 1);
/* 166 */           pc.get_other2().set_TfCount1(pc.get_other2().get_TfCount1() + 1);
/* 167 */           pc.addother_ReductionDmg(Configtf.tftype8);
/*     */         } 
/*     */       }
/* 170 */       TF(pc);
/* 171 */     } else if (cmd.equalsIgnoreCase("iii")) {
/* 172 */       boolean isTalent = false;
/* 173 */       if (pc.get_other2().get_TfCount() > 0) {
/* 174 */         isTalent = true;
/*     */       }
/* 176 */       if (isTalent) {
/* 177 */         if (pc.get_other2().get_Sp() >= Configtf.tfup9) {
/* 178 */           pc.sendPackets((ServerBasePacket)new S_SystemMessage("該天賦技能已滿"));
/* 179 */           isTalent = false;
/*     */         } else {
/* 181 */           pc.get_other2().set_Sp(pc.get_other2().get_Sp() + Configtf.tftype9);
/* 182 */           pc.get_other2().set_TfCount(pc.get_other2().get_TfCount() - 1);
/* 183 */           pc.get_other2().set_TfCount1(pc.get_other2().get_TfCount1() + 1);
/* 184 */           pc.addSp(Configtf.tftype9);
/* 185 */           pc.sendPackets((ServerBasePacket)new S_SPMR(pc));
/*     */         } 
/*     */       }
/* 188 */       TF(pc);
/*     */     } else {
/* 190 */       if (!cmd.equalsIgnoreCase("jjj")) {
/* 191 */         return false;
/*     */       }
/* 193 */       boolean isTalent = false;
/* 194 */       if (pc.get_other2().get_TfCount() > 0) {
/* 195 */         isTalent = true;
/*     */       }
/* 197 */       if (isTalent) {
/* 198 */         if (pc.get_other2().get_Mr() >= Configtf.tfup10) {
/* 199 */           pc.sendPackets((ServerBasePacket)new S_SystemMessage("該天賦技能已滿"));
/* 200 */           isTalent = false;
/*     */         } else {
/* 202 */           pc.get_other2().set_Mr(pc.get_other2().get_Mr() + Configtf.tftype10);
/* 203 */           pc.get_other2().set_TfCount(pc.get_other2().get_TfCount() - 1);
/* 204 */           pc.get_other2().set_TfCount1(pc.get_other2().get_TfCount1() + 1);
/* 205 */           pc.addMr(Configtf.tftype10);
/* 206 */           pc.sendPackets((ServerBasePacket)new S_SPMR(pc));
/*     */         } 
/*     */       }
/* 209 */       TF(pc);
/*     */     } 
/* 211 */     return true;
/*     */   }
/*     */   
/*     */   public void TF(L1PcInstance pc) {
/* 215 */     String[] info = new String[11];
/* 216 */     if (pc.get_other2().get_TfCount() > 0) {
/* 217 */       info[0] = String.valueOf(pc.get_other2().get_TfCount());
/*     */     } else {
/* 219 */       info[0] = "0";
/*     */     } 
/* 221 */     if (pc.get_other2().get_Str() > 0) {
/* 222 */       info[1] = String.valueOf(pc.get_other2().get_Str());
/*     */     } else {
/* 224 */       info[1] = "0";
/*     */     } 
/* 226 */     if (pc.get_other2().get_Dex() > 0) {
/* 227 */       info[2] = String.valueOf(pc.get_other2().get_Dex());
/*     */     } else {
/* 229 */       info[2] = "0";
/*     */     } 
/* 231 */     if (pc.get_other2().get_Int() > 0) {
/* 232 */       info[3] = String.valueOf(pc.get_other2().get_Int());
/*     */     } else {
/* 234 */       info[3] = "0";
/*     */     } 
/* 236 */     if (pc.get_other2().get_Attack() > 0) {
/* 237 */       info[4] = String.valueOf(pc.get_other2().get_Attack());
/*     */     } else {
/* 239 */       info[4] = "0";
/*     */     } 
/* 241 */     if (pc.get_other2().get_BowAttack() > 0) {
/* 242 */       info[5] = String.valueOf(pc.get_other2().get_BowAttack());
/*     */     } else {
/* 244 */       info[5] = "0";
/*     */     } 
/* 246 */     if (pc.get_other2().get_Hp() > 0) {
/* 247 */       info[6] = String.valueOf(pc.get_other2().get_Hp());
/*     */     } else {
/* 249 */       info[6] = "0";
/*     */     } 
/* 251 */     if (pc.get_other2().get_Mp() > 0) {
/* 252 */       info[7] = String.valueOf(pc.get_other2().get_Mp());
/*     */     } else {
/* 254 */       info[7] = "0";
/*     */     } 
/* 256 */     if (pc.get_other2().get_ReductionDmg() > 0) {
/* 257 */       info[8] = String.valueOf(pc.get_other2().get_ReductionDmg());
/*     */     } else {
/* 259 */       info[8] = "0";
/*     */     } 
/* 261 */     if (pc.get_other2().get_Sp() > 0) {
/* 262 */       info[9] = String.valueOf(pc.get_other2().get_Sp());
/*     */     } else {
/* 264 */       info[9] = "0";
/*     */     } 
/* 266 */     if (pc.get_other2().get_Mr() > 0) {
/* 267 */       info[10] = String.valueOf(pc.get_other2().get_Mr());
/*     */     } else {
/* 269 */       info[10] = "0";
/*     */     } 
/* 271 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "tfcount", info));
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\TFUpdate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */