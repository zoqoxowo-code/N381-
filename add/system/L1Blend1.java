/*     */ package com.add.system;
/*     */ 
/*     */ import com.lineage.server.datatables.ItemTable;
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ import com.lineage.server.model.Instance.L1NpcInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.serverpackets.S_NPCTalkReturn;
/*     */ import com.lineage.server.serverpackets.S_ServerMessage;
/*     */ import com.lineage.server.serverpackets.S_SystemMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.world.World;
/*     */ import com.lineage.william.L1Blend_buff;
/*     */ 
/*     */ public class L1Blend1 {
/*     */   private int _npcid;
/*     */   private String _action;
/*     */   private String _note;
/*     */   private int _checkLevel;
/*     */   private int _checkClass;
/*     */   private int[] _materials;
/*     */   private int[] _materials_count;
/*     */   private int[] _materials_enchants;
/*     */   private String _sucesshtml;
/*     */   private String _failhtml;
/*     */   private String _Allmessage;
/*     */   private int _quest;
/*     */   private String _givebuff;
/*     */   
/*     */   public int get_npcid() {
/*  30 */     return this._npcid;
/*     */   }
/*     */   
/*     */   public void set_npcid(int npcid) {
/*  34 */     this._npcid = npcid;
/*     */   }
/*     */   
/*     */   public String get_action() {
/*  38 */     return this._action;
/*     */   }
/*     */   
/*     */   public void set_action(String action) {
/*  42 */     this._action = action;
/*     */   }
/*     */   
/*     */   public String get_note() {
/*  46 */     return this._note;
/*     */   }
/*     */   
/*     */   public void set_note(String note) {
/*  50 */     this._note = note;
/*     */   }
/*     */   
/*     */   public int getCheckLevel() {
/*  54 */     return this._checkLevel;
/*     */   }
/*     */   
/*     */   public void setCheckLevel(int checkLevel) {
/*  58 */     this._checkLevel = checkLevel;
/*     */   }
/*     */   
/*     */   public int getCheckClass() {
/*  62 */     return this._checkClass;
/*     */   }
/*     */   
/*     */   public void setCheckClass(int checkClass) {
/*  66 */     this._checkClass = checkClass;
/*     */   }
/*     */   
/*     */   public final int[] getMaterials() {
/*  70 */     return this._materials;
/*     */   }
/*     */   
/*     */   public void setMaterials(int[] needids) {
/*  74 */     this._materials = needids;
/*     */   }
/*     */   
/*     */   public final int[] getMaterials_count() {
/*  78 */     return this._materials_count;
/*     */   }
/*     */   
/*     */   public final void setMaterials_count(int[] needcounts) {
/*  82 */     this._materials_count = needcounts;
/*     */   }
/*     */   
/*     */   public final int[] get_materials_enchants() {
/*  86 */     return this._materials_enchants;
/*     */   }
/*     */   
/*     */   public final void set_materials_enchants(int[] needenchants) {
/*  90 */     this._materials_enchants = needenchants;
/*     */   }
/*     */   
/*     */   public String get_sucesshtml() {
/*  94 */     return this._sucesshtml;
/*     */   }
/*     */   
/*     */   public void set_sucesshtml(String sucesshtml) {
/*  98 */     this._sucesshtml = sucesshtml;
/*     */   }
/*     */   
/*     */   public String get_failhtml() {
/* 102 */     return this._failhtml;
/*     */   }
/*     */   
/*     */   public void set_failhtml(String failhtml) {
/* 106 */     this._failhtml = failhtml;
/*     */   }
/*     */   
/*     */   public String get_Allmessage() {
/* 110 */     return this._Allmessage;
/*     */   }
/*     */   
/*     */   public void set_Allmessage(String Allmessage) {
/* 114 */     this._Allmessage = Allmessage;
/*     */   }
/*     */   
/*     */   public int getquest() {
/* 118 */     return this._quest;
/*     */   }
/*     */   
/*     */   public void setquest(int quest) {
/* 122 */     this._quest = quest;
/*     */   }
/*     */   
/*     */   public String get_givebuff() {
/* 126 */     return this._givebuff;
/*     */   }
/*     */   
/*     */   public void set_givebuff(String givebuff) {
/* 130 */     this._givebuff = givebuff;
/*     */   }
/*     */   
/*     */   public void ShowCraftHtml(L1PcInstance pc, L1NpcInstance npc, L1Blend1 ItemBlend) {
/* 134 */     String msg0 = "";
/* 135 */     String msg2 = "";
/* 136 */     String msg3 = "";
/* 137 */     String msg4 = "";
/* 138 */     String msg5 = "";
/* 139 */     String msg6 = "";
/* 140 */     String msg7 = "";
/* 141 */     String msg8 = "";
/* 142 */     String msg9 = "";
/* 143 */     String msg10 = "";
/* 144 */     String msg11 = "";
/* 145 */     String msg12 = "";
/* 146 */     String msg13 = "";
/* 147 */     String msg14 = "";
/* 148 */     String msg15 = "";
/* 149 */     String msg16 = "";
/* 150 */     String msg17 = "";
/* 151 */     String msg18 = "";
/* 152 */     String msg19 = "";
/* 153 */     String msg20 = "";
/* 154 */     String msg21 = "";
/* 155 */     String msg22 = "";
/* 156 */     String msg23 = "";
/* 157 */     String msg24 = "";
/* 158 */     String msg25 = "";
/* 159 */     String msg26 = "";
/* 160 */     String msg27 = "";
/* 161 */     String msg28 = "";
/* 162 */     String msg29 = "";
/* 163 */     String msg30 = "";
/* 164 */     String msg31 = "";
/* 165 */     String msg32 = "";
/* 166 */     String msg33 = "";
/* 167 */     String msg34 = "";
/* 168 */     String msg35 = "";
/* 169 */     String msg36 = "";
/* 170 */     String msg37 = "";
/* 171 */     String msg38 = "";
/* 172 */     String msg39 = "";
/* 173 */     String msg40 = "";
/* 174 */     String msg41 = "";
/* 175 */     String msg42 = "";
/* 176 */     String msg43 = "";
/* 177 */     String msg44 = "";
/* 178 */     String msg45 = "";
/* 179 */     String msg46 = "";
/* 180 */     String msg47 = "";
/* 181 */     String msg48 = "";
/* 182 */     String msg49 = "";
/* 183 */     String msg50 = "";
/* 184 */     String msg51 = "";
/* 185 */     String msg52 = "";
/* 186 */     String msg53 = "";
/* 187 */     String msg54 = "";
/* 188 */     String msg55 = "";
/* 189 */     msg0 = get_note();
/* 190 */     msg2 = get_givebuff();
/* 191 */     if (ItemBlend.getCheckLevel() != 0) {
/* 192 */       msg3 = " " + ItemBlend.getCheckLevel() + "級以上。 ";
/*     */     } else {
/* 194 */       msg3 = " 無限制 ";
/*     */     } 
/* 196 */     if (ItemBlend.getCheckClass() == 1) {
/* 197 */       msg4 = " 王族";
/* 198 */     } else if (ItemBlend.getCheckClass() == 2) {
/* 199 */       msg4 = " 騎士";
/* 200 */     } else if (ItemBlend.getCheckClass() == 3) {
/* 201 */       msg4 = " 法師";
/* 202 */     } else if (ItemBlend.getCheckClass() == 4) {
/* 203 */       msg4 = " 妖精";
/* 204 */     } else if (ItemBlend.getCheckClass() == 5) {
/* 205 */       msg4 = " 黑妖";
/* 206 */     } else if (ItemBlend.getCheckClass() == 0) {
/* 207 */       msg4 = " 所有職業";
/*     */     } 
/* 209 */     if (pc.getQuest().get_step(ItemBlend.getquest()) == 2) {
/* 210 */       msg55 = "[已解鎖此成就]";
/*     */     } else {
/* 212 */       msg55 = "[未解此成就]";
/*     */     } 
/* 214 */     int[] Materials = ItemBlend.getMaterials();
/* 215 */     int[] counts = ItemBlend.getMaterials_count();
/* 216 */     int[] enchants = ItemBlend.get_materials_enchants();
/* 217 */     if (Materials != null) {
/* 218 */       int i = 0;
/* 219 */       while (i < Materials.length) {
/* 220 */         L1ItemInstance temp = ItemTable.get().createItem(Materials[i]);
/* 221 */         temp.setEnchantLevel(enchants[i]);
/* 222 */         temp.setIdentified(true);
/* 223 */         switch (i) {
/*     */           case 0:
/* 225 */             msg5 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 1:
/* 229 */             msg6 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 2:
/* 233 */             msg7 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 3:
/* 237 */             msg8 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 4:
/* 241 */             msg9 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 5:
/* 245 */             msg10 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 6:
/* 249 */             msg11 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 7:
/* 253 */             msg12 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 8:
/* 257 */             msg13 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 9:
/* 261 */             msg14 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 10:
/* 265 */             msg15 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 11:
/* 269 */             msg16 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 12:
/* 273 */             msg17 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 13:
/* 277 */             msg18 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 14:
/* 281 */             msg19 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 15:
/* 285 */             msg20 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 16:
/* 289 */             msg21 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 17:
/* 293 */             msg22 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 18:
/* 297 */             msg23 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 19:
/* 301 */             msg24 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 20:
/* 305 */             msg25 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 21:
/* 309 */             msg26 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 22:
/* 313 */             msg27 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 23:
/* 317 */             msg28 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 24:
/* 321 */             msg29 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 25:
/* 325 */             msg30 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 26:
/* 329 */             msg31 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 27:
/* 333 */             msg32 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 28:
/* 337 */             msg33 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 29:
/* 341 */             msg34 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 30:
/* 345 */             msg35 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 31:
/* 349 */             msg36 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 32:
/* 353 */             msg37 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 33:
/* 357 */             msg38 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 34:
/* 361 */             msg39 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 35:
/* 365 */             msg40 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 36:
/* 369 */             msg41 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 37:
/* 373 */             msg42 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 38:
/* 377 */             msg43 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 39:
/* 381 */             msg44 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 40:
/* 385 */             msg45 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 41:
/* 389 */             msg46 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 42:
/* 393 */             msg47 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 43:
/* 397 */             msg48 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 44:
/* 401 */             msg49 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 45:
/* 405 */             msg50 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 46:
/* 409 */             msg51 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 47:
/* 413 */             msg52 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 48:
/* 417 */             msg53 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 49:
/* 421 */             msg54 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */         } 
/*     */         
/* 425 */         i++;
/*     */       } 
/*     */     } 
/* 428 */     String[] msgs = { msg0, msg2, msg3, msg4, msg5, msg6, msg7, msg8, msg9, msg10, msg11, msg12, msg13, msg14, 
/* 429 */         msg15, msg16, msg17, msg18, msg19, msg20, msg21, msg22, msg23, msg24, msg25, msg26, msg27, msg28, msg29, 
/* 430 */         msg30, msg31, msg32, msg33, msg34, msg35, msg36, msg37, msg38, msg39, msg40, msg41, msg42, msg43, msg44, 
/* 431 */         msg45, msg46, msg47, msg48, msg49, msg50, msg51, msg52, msg53, msg54, msg55 };
/* 432 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(npc.getId(), "ItemBlend2", msgs));
/*     */   }
/*     */ 
/*     */   
/*     */   public void CheckCraftItem(L1PcInstance pc, L1NpcInstance npc, L1Blend1 ItemBlend, int amount, boolean checked) {
/* 437 */     int[] Materials = ItemBlend.getMaterials();
/* 438 */     int[] Materials_counts = ItemBlend.getMaterials_count();
/* 439 */     int[] enchants = ItemBlend.get_materials_enchants();
/* 440 */     boolean isok = true;
/* 441 */     if (pc.getQuest().get_step(ItemBlend.getquest()) == 2) {
/* 442 */       pc.sendPackets((ServerBasePacket)new S_ServerMessage("此成就已完成。"));
/* 443 */       isok = false;
/*     */     } 
/* 445 */     if (ItemBlend.getCheckLevel() != 0 && pc.getLevel() < ItemBlend.getCheckLevel()) {
/* 446 */       pc.sendPackets((ServerBasePacket)new S_ServerMessage("等級必須為" + ItemBlend.getCheckLevel() + "以上。"));
/* 447 */       isok = false;
/*     */     } 
/* 449 */     if (ItemBlend.getCheckClass() != 0) {
/* 450 */       byte class_id = 0;
/* 451 */       String Classmsg = "";
/* 452 */       if (pc.isCrown()) {
/* 453 */         class_id = 1;
/* 454 */       } else if (pc.isKnight()) {
/* 455 */         class_id = 2;
/* 456 */       } else if (pc.isWizard()) {
/* 457 */         class_id = 3;
/* 458 */       } else if (pc.isElf()) {
/* 459 */         class_id = 4;
/* 460 */       } else if (pc.isDarkelf()) {
/* 461 */         class_id = 5;
/* 462 */       } else if (pc.isDragonKnight()) {
/* 463 */         class_id = 6;
/* 464 */       } else if (pc.isIllusionist()) {
/* 465 */         class_id = 7;
/*     */       } 
/* 467 */       switch (ItemBlend.getCheckClass()) {
/*     */         case 1:
/* 469 */           Classmsg = "王族";
/*     */           break;
/*     */         
/*     */         case 2:
/* 473 */           Classmsg = "騎士";
/*     */           break;
/*     */         
/*     */         case 3:
/* 477 */           Classmsg = "法師";
/*     */           break;
/*     */         
/*     */         case 4:
/* 481 */           Classmsg = "妖精";
/*     */           break;
/*     */         
/*     */         case 5:
/* 485 */           Classmsg = "黑暗妖精";
/*     */           break;
/*     */       } 
/*     */       
/* 489 */       if (ItemBlend.getCheckClass() != class_id) {
/* 490 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(166, "職業必須是", Classmsg, "才能製造此道具"));
/* 491 */         isok = false;
/*     */       } 
/*     */     } 
/* 494 */     boolean enough = false;
/* 495 */     if (isok) {
/* 496 */       int num = 0;
/* 497 */       int i = 0;
/* 498 */       while (i < Materials.length) {
/* 499 */         if (Materials[i] != 0 && Materials_counts[i] != 0) {
/* 500 */           if (!pc.getInventory().checkEnchantItem(Materials[i], enchants[i], Materials_counts[i])) {
/* 501 */             L1ItemInstance temp = ItemTable.get().createItem(Materials[i]);
/* 502 */             temp.setEnchantLevel(enchants[i]);
/* 503 */             temp.setIdentified(true);
/* 504 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(337, 
/* 505 */                   String.valueOf(String.valueOf(temp.getLogName())) + "(" + Materials_counts[i] + ")"));
/* 506 */             isok = false;
/*     */           } else {
/* 508 */             num++;
/*     */           } 
/*     */         }
/* 511 */         i++;
/*     */       } 
/* 513 */       if (num == Materials.length) {
/* 514 */         enough = true;
/*     */       }
/*     */     } 
/* 517 */     if (isok && enough) {
/* 518 */       int[] newcounts = new int[Materials_counts.length];
/* 519 */       int i = 0;
/* 520 */       while (i < Materials_counts.length) {
/* 521 */         newcounts[i] = Materials_counts[i] * amount;
/* 522 */         i++;
/*     */       } 
/* 524 */       i = 0;
/* 525 */       while (i < Materials.length) {
/* 526 */         pc.getInventory().consumeEnchantItem(Materials[i], enchants[i], newcounts[i]);
/* 527 */         i++;
/*     */       } 
/* 529 */       if (ItemBlend.get_Allmessage() != null) {
/* 530 */         World.get().broadcastPacketToAll(
/* 531 */             (ServerBasePacket)new S_SystemMessage(String.format(ItemBlend.get_Allmessage(), new Object[] { pc.getName(), get_note() })));
/*     */       }
/* 533 */       pc.sendPackets((ServerBasePacket)new S_ServerMessage(ItemBlend.get_sucesshtml()));
/* 534 */       pc.getQuest().set_step(ItemBlend.getquest(), 1);
/* 535 */       L1Blend_buff.forIntensifyArmor(pc);
/* 536 */       pc.getQuest().set_step(ItemBlend.getquest(), 2);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\system\L1Blend1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */