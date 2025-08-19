/*     */ package com.lineage.data.event;
/*     */ 
/*     */ import com.lineage.data.executor.EventExecutor;
/*     */ import com.lineage.server.datatables.RewardClanSkillsTable;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.serverpackets.S_HPUpdate;
/*     */ import com.lineage.server.serverpackets.S_MPUpdate;
/*     */ import com.lineage.server.serverpackets.S_OwnCharStatus;
/*     */ import com.lineage.server.serverpackets.S_SPMR;
/*     */ import com.lineage.server.serverpackets.S_ServerMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.templates.L1ClanSkills;
/*     */ import com.lineage.server.templates.L1Event;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClanSkillDBSet
/*     */   extends EventExecutor
/*     */ {
/*  23 */   private static final Log _log = LogFactory.getLog(ClanSkillDBSet.class);
/*     */   public static boolean START = false;
/*  25 */   public static String[] _skillNameNote = null;
/*     */ 
/*     */   
/*     */   public static EventExecutor get() {
/*  29 */     return new ClanSkillDBSet();
/*     */   }
/*     */ 
/*     */   
/*     */   public void execute(L1Event event) {
/*     */     try {
/*  35 */       if (ClanSkillSet.START) {
/*  36 */         _log.info("警告!活動設置:伊薇版血盟技能已啟動狀態下無法同時啟動111項血盟技能");
/*     */       } else {
/*  38 */         RewardClanSkillsTable.get();
/*  39 */         _skillNameNote = RewardClanSkillsTable.get().getSkillsNameNote();
/*  40 */         START = true;
/*     */       } 
/*  42 */     } catch (Exception e) {
/*  43 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void add(L1PcInstance pc) {
/*  48 */     if (!START) {
/*     */       return;
/*     */     }
/*  51 */     int clanSkillsId = pc.getClan().getClanSkillId();
/*  52 */     if (clanSkillsId == 0) {
/*     */       return;
/*     */     }
/*  55 */     int clanSkillsLv = pc.getClan().getClanSkillLv();
/*  56 */     if (clanSkillsLv == 0) {
/*     */       return;
/*     */     }
/*  59 */     L1ClanSkills skill = RewardClanSkillsTable.get().getClanSkillsList(clanSkillsId, clanSkillsLv);
/*  60 */     if (skill == null) {
/*     */       return;
/*     */     }
/*  63 */     int CheckLvturn = skill.getCheckLvturn();
/*  64 */     if (CheckLvturn != 0 && pc.getMeteLevel() < CheckLvturn) {
/*     */       return;
/*     */     }
/*  67 */     int CheckLevel = skill.getCheckLevel();
/*  68 */     if (CheckLevel != 0 && pc.getHighLevel() < CheckLevel) {
/*     */       return;
/*     */     }
/*  71 */     boolean OwnCharStatus = false;
/*  72 */     boolean hp = false;
/*  73 */     boolean mp = false;
/*  74 */     boolean spmr = false;
/*  75 */     int AddMaxHp = skill.getAddMaxHp();
/*  76 */     if (AddMaxHp != 0) {
/*  77 */       pc.addMaxHp(AddMaxHp);
/*  78 */       hp = true;
/*     */     } 
/*  80 */     int AddMaxMp = skill.getAddMaxMp();
/*  81 */     if (AddMaxMp != 0) {
/*  82 */       pc.addMaxMp(AddMaxMp);
/*  83 */       mp = true;
/*     */     } 
/*  85 */     int AddHpr = skill.getAddHpr();
/*  86 */     if (AddHpr != 0) {
/*  87 */       pc.addHpr(AddHpr);
/*     */     }
/*  89 */     int AddMpr = skill.getAddMpr();
/*  90 */     if (AddMpr != 0) {
/*  91 */       pc.addMpr(AddMpr);
/*     */     }
/*  93 */     int AddStr = skill.getAddStr();
/*  94 */     if (AddStr != 0) {
/*  95 */       pc.addStr(AddStr);
/*  96 */       OwnCharStatus = true;
/*     */     } 
/*  98 */     int AddDex = skill.getAddDex();
/*  99 */     if (AddDex != 0) {
/* 100 */       pc.addDex(AddDex);
/* 101 */       OwnCharStatus = true;
/*     */     } 
/* 103 */     int AddCon = skill.getAddCon();
/* 104 */     if (AddCon != 0) {
/* 105 */       pc.addCon(AddCon);
/* 106 */       OwnCharStatus = true;
/*     */     } 
/* 108 */     int AddInt = skill.getAddInt();
/* 109 */     if (AddInt != 0) {
/* 110 */       pc.addInt(AddInt);
/* 111 */       OwnCharStatus = true;
/*     */     } 
/* 113 */     int AddWis = skill.getAddWis();
/* 114 */     if (AddWis != 0) {
/* 115 */       pc.addWis(AddWis);
/* 116 */       OwnCharStatus = true;
/*     */     } 
/* 118 */     int AddCha = skill.getAddCha();
/* 119 */     if (AddCha != 0) {
/* 120 */       pc.addCha(AddCha);
/* 121 */       OwnCharStatus = true;
/*     */     } 
/* 123 */     int AddAc = skill.getAddAc();
/* 124 */     if (AddAc != 0) {
/* 125 */       pc.addAc(-AddAc);
/* 126 */       OwnCharStatus = true;
/*     */     } 
/* 128 */     int AddSp = skill.getAddSp();
/* 129 */     if (AddSp != 0) {
/* 130 */       pc.addSp(AddSp);
/*     */     }
/* 132 */     int AddMr = skill.getAddMr();
/* 133 */     if (AddMr != 0) {
/* 134 */       pc.addMr(AddMr);
/* 135 */       spmr = true;
/*     */     } 
/* 137 */     int AddDmg = skill.getAddDmg();
/* 138 */     if (AddDmg != 0) {
/* 139 */       pc.addDmgup(AddDmg);
/* 140 */       spmr = true;
/*     */     } 
/* 142 */     int AddBowDmg = skill.getAddBowDmg();
/* 143 */     if (AddBowDmg != 0) {
/* 144 */       pc.addBowDmgup(AddBowDmg);
/*     */     }
/* 146 */     int AddHit = skill.getAddHit();
/* 147 */     if (AddHit != 0) {
/* 148 */       pc.addHitup(AddHit);
/*     */     }
/* 150 */     int AddBowHit = skill.getAddBowHit();
/* 151 */     if (AddBowHit != 0) {
/* 152 */       pc.addBowHitup(AddBowHit);
/*     */     }
/* 154 */     int ReductionDmg = skill.getReductionDmg();
/* 155 */     if (ReductionDmg != 0) {
/* 156 */       pc.add_reduction_dmg(ReductionDmg);
/*     */     }
/* 158 */     int ReductionMagicDmg = skill.getReductionMagicDmg();
/* 159 */     if (ReductionMagicDmg != 0) {
/* 160 */       pc.add_magic_reduction_dmg(ReductionMagicDmg);
/*     */     }
/* 162 */     int AddWater = skill.getAddWater();
/* 163 */     if (AddWater != 0) {
/* 164 */       pc.addWater(AddWater);
/* 165 */       OwnCharStatus = true;
/*     */     } 
/* 167 */     int AddWind = skill.getAddWind();
/* 168 */     if (AddWind != 0) {
/* 169 */       pc.addWind(AddWind);
/* 170 */       OwnCharStatus = true;
/*     */     } 
/* 172 */     int AddFire = skill.getAddFire();
/* 173 */     if (AddFire != 0) {
/* 174 */       pc.addFire(AddFire);
/* 175 */       OwnCharStatus = true;
/*     */     } 
/* 177 */     int AddEarth = skill.getAddEarth();
/* 178 */     if (AddEarth != 0) {
/* 179 */       pc.addEarth(AddEarth);
/* 180 */       OwnCharStatus = true;
/*     */     } 
/* 182 */     if (OwnCharStatus) {
/* 183 */       pc.sendPackets((ServerBasePacket)new S_OwnCharStatus(pc));
/*     */     }
/* 185 */     if (hp) {
/* 186 */       pc.sendPackets((ServerBasePacket)new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
/*     */     }
/* 188 */     if (mp) {
/* 189 */       pc.sendPackets((ServerBasePacket)new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
/*     */     }
/* 191 */     if (spmr) {
/* 192 */       pc.sendPackets((ServerBasePacket)new S_SPMR(pc));
/*     */     }
/* 194 */     String ClanSkillName = skill.getClanSkillName();
/* 195 */     String Note = skill.getNote();
/* 196 */     if (ClanSkillName != null && Note != null) {
/* 197 */       pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU" + ClanSkillName + ":"));
/* 198 */       pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU" + Note));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\ClanSkillDBSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */