/*     */ package com.lineage.data.cmd;
/*     */ 
/*     */ import com.lineage.server.datatables.SkillsTable;
/*     */ import com.lineage.server.datatables.lock.CharSkillReading;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.serverpackets.S_AddSkill;
/*     */ import com.lineage.server.serverpackets.S_ServerMessage;
/*     */ import com.lineage.server.serverpackets.S_SkillSound;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.templates.L1Skills;
/*     */ 
/*     */ public class Skill_Studying
/*     */   implements Skill_StudyingExecutor
/*     */ {
/*     */   public void magic(L1PcInstance pc, int skillId, int magicAtt, int attribute, int itemObj) {
/*  16 */     int pclvl = pc.getLevel();
/*  17 */     boolean isUse = true;
/*  18 */     if (pc.isCrown()) {
/*  19 */       S_ServerMessage msg; switch (magicAtt) {
/*     */         case 1:
/*  21 */           if (pclvl >= 10) {
/*  22 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/*  25 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 2:
/*  29 */           if (pclvl >= 20) {
/*  30 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/*  33 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 21:
/*  37 */           if (pclvl >= 15) {
/*  38 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/*  41 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 22:
/*  45 */           if (pclvl >= 30) {
/*  46 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/*  49 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 23:
/*  53 */           if (pclvl >= 40) {
/*  54 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/*  57 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 24:
/*  61 */           if (pclvl >= 45) {
/*  62 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/*  65 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 25:
/*  69 */           if (pclvl >= 50) {
/*  70 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/*  73 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 26:
/*  77 */           if (pclvl >= 55) {
/*  78 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/*  81 */           isUse = false;
/*     */           break;
/*     */         
/*     */         default:
/*  85 */           msg = new S_ServerMessage(79);
/*  86 */           pc.sendPackets((ServerBasePacket)msg);
/*     */           break;
/*     */       } 
/*     */     
/*  90 */     } else if (pc.isKnight()) {
/*  91 */       S_ServerMessage msg; switch (magicAtt) {
/*     */         case 1:
/*  93 */           if (pclvl >= 50) {
/*  94 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/*  97 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 31:
/* 101 */           if (pclvl >= 50) {
/* 102 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 105 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 32:
/* 109 */           if (pclvl >= 60) {
/* 110 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 113 */           isUse = false;
/*     */           break;
/*     */         
/*     */         default:
/* 117 */           msg = new S_ServerMessage(79);
/* 118 */           pc.sendPackets((ServerBasePacket)msg);
/*     */           break;
/*     */       } 
/*     */     
/* 122 */     } else if (pc.isWizard()) {
/* 123 */       S_ServerMessage msg; switch (magicAtt) {
/*     */         case 1:
/* 125 */           if (pclvl >= 4) {
/* 126 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 129 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 2:
/* 133 */           if (pclvl >= 8) {
/* 134 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 137 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 3:
/* 141 */           if (pclvl >= 12) {
/* 142 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 145 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 4:
/* 149 */           if (pclvl >= 16) {
/* 150 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 153 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 5:
/* 157 */           if (pclvl >= 20) {
/* 158 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 161 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 6:
/* 165 */           if (pclvl >= 24) {
/* 166 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 169 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 7:
/* 173 */           if (pclvl >= 28) {
/* 174 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 177 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 8:
/* 181 */           if (pclvl >= 32) {
/* 182 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 185 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 9:
/* 189 */           if (pclvl >= 36) {
/* 190 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 193 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 10:
/* 197 */           if (pclvl >= 40) {
/* 198 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 201 */           isUse = false;
/*     */           break;
/*     */         
/*     */         default:
/* 205 */           msg = new S_ServerMessage(79);
/* 206 */           pc.sendPackets((ServerBasePacket)msg);
/*     */           break;
/*     */       } 
/*     */     
/* 210 */     } else if (pc.isElf()) {
/* 211 */       S_ServerMessage msg; switch (magicAtt) {
/*     */         case 1:
/* 213 */           if (pclvl >= 8) {
/* 214 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 217 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 2:
/* 221 */           if (pclvl >= 16) {
/* 222 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 225 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 3:
/* 229 */           if (pclvl >= 24) {
/* 230 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 233 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 4:
/* 237 */           if (pclvl >= 32) {
/* 238 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 241 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 5:
/* 245 */           if (pclvl >= 40) {
/* 246 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 249 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 6:
/* 253 */           if (pclvl >= 48) {
/* 254 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 257 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 11:
/* 261 */           if (pclvl >= 10) {
/* 262 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 265 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 12:
/* 269 */           if (pclvl >= 20) {
/* 270 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 273 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 13:
/* 277 */           if (pclvl >= 30) {
/* 278 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 281 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 14:
/* 285 */           if (pclvl >= 40) {
/* 286 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 289 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 15:
/* 293 */           if (pclvl >= 50) {
/* 294 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 297 */           isUse = false;
/*     */           break;
/*     */         
/*     */         default:
/* 301 */           msg = new S_ServerMessage(79);
/* 302 */           pc.sendPackets((ServerBasePacket)msg);
/*     */           break;
/*     */       } 
/*     */     
/* 306 */     } else if (pc.isDarkelf()) {
/* 307 */       S_ServerMessage msg; switch (magicAtt) {
/*     */         case 1:
/* 309 */           if (pclvl >= 12) {
/* 310 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 313 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 2:
/* 317 */           if (pclvl >= 24) {
/* 318 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 321 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 41:
/* 325 */           if (pclvl >= 15) {
/* 326 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 329 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 42:
/* 333 */           if (pclvl >= 30) {
/* 334 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 337 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 43:
/* 341 */           if (pclvl >= 45) {
/* 342 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 345 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 44:
/* 349 */           if (pclvl >= 60) {
/* 350 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 353 */           isUse = false;
/*     */           break;
/*     */         
/*     */         default:
/* 357 */           msg = new S_ServerMessage(79);
/* 358 */           pc.sendPackets((ServerBasePacket)msg);
/*     */           break;
/*     */       } 
/*     */     
/* 362 */     } else if (pc.isDragonKnight()) {
/* 363 */       S_ServerMessage msg; switch (magicAtt) {
/*     */         case 51:
/* 365 */           if (pclvl >= 15) {
/* 366 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 369 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 52:
/* 373 */           if (pclvl >= 30) {
/* 374 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 377 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 53:
/* 381 */           if (pclvl >= 45) {
/* 382 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 385 */           isUse = false;
/*     */           break;
/*     */         
/*     */         default:
/* 389 */           msg = new S_ServerMessage(79);
/* 390 */           pc.sendPackets((ServerBasePacket)msg);
/*     */           break;
/*     */       } 
/*     */     
/* 394 */     } else if (pc.isIllusionist()) {
/* 395 */       S_ServerMessage msg; switch (magicAtt) {
/*     */         case 61:
/* 397 */           if (pclvl >= 10) {
/* 398 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 401 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 62:
/* 405 */           if (pclvl >= 20) {
/* 406 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 409 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 63:
/* 413 */           if (pclvl >= 30) {
/* 414 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 417 */           isUse = false;
/*     */           break;
/*     */         
/*     */         case 64:
/* 421 */           if (pclvl >= 40) {
/* 422 */             mapPosition(pc, skillId, attribute, itemObj);
/*     */             break;
/*     */           } 
/* 425 */           isUse = false;
/*     */           break;
/*     */         
/*     */         default:
/* 429 */           msg = new S_ServerMessage(79);
/* 430 */           pc.sendPackets((ServerBasePacket)msg);
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 435 */     if (!isUse) {
/* 436 */       S_ServerMessage msg = new S_ServerMessage(312);
/* 437 */       pc.sendPackets((ServerBasePacket)msg);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void mapPosition(L1PcInstance pc, int skillId, int attribute, int itemObj) {
/* 442 */     boolean isOk = false;
/* 443 */     spellBook(pc, skillId, itemObj);
/*     */   }
/*     */   
/*     */   private void spellBook(L1PcInstance pc, int skillId, int itemObj) {
/* 447 */     pc.getInventory().removeItem(pc.getInventory().getItem(itemObj), 1L);
/* 448 */     pc.sendPackets((ServerBasePacket)new S_AddSkill(pc, skillId));
/* 449 */     char c = 'ã';
/* 450 */     S_SkillSound sound = new S_SkillSound(pc.getId(), 227);
/* 451 */     pc.sendPacketsX8((ServerBasePacket)sound);
/* 452 */     L1Skills skill = SkillsTable.get().getTemplate(skillId);
/* 453 */     String skillName = skill.getName();
/* 454 */     CharSkillReading.get().spellMastery(pc.getId(), skillId, skillName, 0, 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\cmd\Skill_Studying.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */