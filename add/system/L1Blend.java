/*     */ package com.add.system;
/*     */ 
/*     */ import com.lineage.data.cmd.CreateNewItem;
/*     */ import com.lineage.server.datatables.ItemTable;
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ import com.lineage.server.model.Instance.L1NpcInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.serverpackets.S_CloseList;
/*     */ import com.lineage.server.serverpackets.S_ItemCount;
/*     */ import com.lineage.server.serverpackets.S_NPCTalkReturn;
/*     */ import com.lineage.server.serverpackets.S_ServerMessage;
/*     */ import com.lineage.server.serverpackets.S_SystemMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.utils.log.PlayerLogUtil;
/*     */ import com.lineage.server.world.World;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class L1Blend
/*     */ {
/*     */   private int _npcid;
/*     */   private String _action;
/*     */   private String _note;
/*     */   private int _checkLevel;
/*     */   private int _checkClass;
/*     */   private int _rnd;
/*     */   private int _hpConsume;
/*     */   private int _mpConsume;
/*     */   private int[] _materials;
/*     */   private int[] _materials_count;
/*     */   private int[] _materials_enchants;
/*     */   private int _new_item;
/*     */   private int _new_item_counts;
/*     */   private int _new_Enchantlvl_SW;
/*     */   private int _new_item_Enchantlvl;
/*     */   private int _new_item_Bless;
/*     */   private int _residue_item;
/*     */   private int _residue_count;
/*     */   private int _replacement_count;
/*     */   private boolean _inputamount;
/*     */   private boolean _all_in_once;
/*     */   private int _bonus_item;
/*     */   private int _bonus_item_count;
/*     */   private int _bonus_item_enchant;
/*     */   private String _sucesshtml;
/*     */   private String _failhtml;
/*     */   private String _Allmessage;
/*     */   private String _runmessage;
/*     */   private int _itembroad;
/*     */   private String _othermessage;
/*     */   private int _itemran;
/*     */   private int _itemranup;
/*     */   
/*     */   public int get_npcid() {
/*  58 */     return this._npcid;
/*     */   }
/*     */   
/*     */   public void set_npcid(int npcid) {
/*  62 */     this._npcid = npcid;
/*     */   }
/*     */   
/*     */   public String get_action() {
/*  66 */     return this._action;
/*     */   }
/*     */   
/*     */   public void set_action(String action) {
/*  70 */     this._action = action;
/*     */   }
/*     */   
/*     */   public String get_note() {
/*  74 */     return this._note;
/*     */   }
/*     */   
/*     */   public void set_note(String note) {
/*  78 */     this._note = note;
/*     */   }
/*     */   
/*     */   public int getCheckLevel() {
/*  82 */     return this._checkLevel;
/*     */   }
/*     */   
/*     */   public void setCheckLevel(int checkLevel) {
/*  86 */     this._checkLevel = checkLevel;
/*     */   }
/*     */   
/*     */   public int getCheckClass() {
/*  90 */     return this._checkClass;
/*     */   }
/*     */   
/*     */   public void setCheckClass(int checkClass) {
/*  94 */     this._checkClass = checkClass;
/*     */   }
/*     */   
/*     */   public int getRandom() {
/*  98 */     return this._rnd;
/*     */   }
/*     */   
/*     */   public void setRandom(int rnd) {
/* 102 */     this._rnd = rnd;
/*     */   }
/*     */   
/*     */   public int getHpConsume() {
/* 106 */     return this._hpConsume;
/*     */   }
/*     */   
/*     */   public void setHpConsume(int hpConsume) {
/* 110 */     this._hpConsume = hpConsume;
/*     */   }
/*     */   
/*     */   public int getMpConsume() {
/* 114 */     return this._mpConsume;
/*     */   }
/*     */   
/*     */   public void setMpConsume(int mpConsume) {
/* 118 */     this._mpConsume = mpConsume;
/*     */   }
/*     */   
/*     */   public final int[] getMaterials() {
/* 122 */     return this._materials;
/*     */   }
/*     */   
/*     */   public void setMaterials(int[] needids) {
/* 126 */     this._materials = needids;
/*     */   }
/*     */   
/*     */   public final int[] getMaterials_count() {
/* 130 */     return this._materials_count;
/*     */   }
/*     */   
/*     */   public final void setMaterials_count(int[] needcounts) {
/* 134 */     this._materials_count = needcounts;
/*     */   }
/*     */   
/*     */   public final int[] get_materials_enchants() {
/* 138 */     return this._materials_enchants;
/*     */   }
/*     */   
/*     */   public final void set_materials_enchants(int[] needenchants) {
/* 142 */     this._materials_enchants = needenchants;
/*     */   }
/*     */   
/*     */   public int getNew_item() {
/* 146 */     return this._new_item;
/*     */   }
/*     */   
/*     */   public void setNew_item(int new_item) {
/* 150 */     this._new_item = new_item;
/*     */   }
/*     */   
/*     */   public int getNew_item_counts() {
/* 154 */     return this._new_item_counts;
/*     */   }
/*     */   
/*     */   public void setNew_item_counts(int new_item_counts) {
/* 158 */     this._new_item_counts = new_item_counts;
/*     */   }
/*     */   
/*     */   public int getNew_Enchantlvl_SW() {
/* 162 */     return this._new_Enchantlvl_SW;
/*     */   }
/*     */   
/*     */   public void setNew_Enchantlvl_SW(int new_Enchantlvl_SW) {
/* 166 */     this._new_Enchantlvl_SW = new_Enchantlvl_SW;
/*     */   }
/*     */   
/*     */   public int getNew_item_Enchantlvl() {
/* 170 */     return this._new_item_Enchantlvl;
/*     */   }
/*     */   
/*     */   public void setNew_item_Enchantlvl(int new_item_Enchantlvl) {
/* 174 */     this._new_item_Enchantlvl = new_item_Enchantlvl;
/*     */   }
/*     */   
/*     */   public int getNew_item_Bless() {
/* 178 */     return this._new_item_Bless;
/*     */   }
/*     */   
/*     */   public void setNew_item_Bless(int new_item_bless) {
/* 182 */     this._new_item_Bless = new_item_bless;
/*     */   }
/*     */   
/*     */   public int getResidue_Item() {
/* 186 */     return this._residue_item;
/*     */   }
/*     */   
/*     */   public void setResidue_Item(int residueitem) {
/* 190 */     this._residue_item = residueitem;
/*     */   }
/*     */   
/*     */   public int getResidue_Count() {
/* 194 */     return this._residue_count;
/*     */   }
/*     */   
/*     */   public void setResidue_Count(int residuecount) {
/* 198 */     this._residue_count = residuecount;
/*     */   }
/*     */   
/*     */   public int getReplacement_count() {
/* 202 */     return this._replacement_count;
/*     */   }
/*     */   
/*     */   public void setReplacement_count(int replacement_count) {
/* 206 */     this._replacement_count = replacement_count;
/*     */   }
/*     */   
/*     */   public boolean isInputAmount() {
/* 210 */     return this._inputamount;
/*     */   }
/*     */   
/*     */   public void setInputAmount(boolean flag) {
/* 214 */     this._inputamount = flag;
/*     */   }
/*     */   
/*     */   public boolean isAll_In_Once() {
/* 218 */     return this._all_in_once;
/*     */   }
/*     */   
/*     */   public void setAll_In_Once(boolean flag) {
/* 222 */     this._all_in_once = flag;
/*     */   }
/*     */   
/*     */   public int getBonus_item() {
/* 226 */     return this._bonus_item;
/*     */   }
/*     */   
/*     */   public void setBonus_item(int bonusitem) {
/* 230 */     this._bonus_item = bonusitem;
/*     */   }
/*     */   
/*     */   public int getBonus_item_count() {
/* 234 */     return this._bonus_item_count;
/*     */   }
/*     */   
/*     */   public void setBonus_item_count(int bonusitemcount) {
/* 238 */     this._bonus_item_count = bonusitemcount;
/*     */   }
/*     */   
/*     */   public int getBonus_item_enchant() {
/* 242 */     return this._bonus_item_enchant;
/*     */   }
/*     */   
/*     */   public void setBonus_item_enchant(int bonusitemenchant) {
/* 246 */     this._bonus_item_enchant = bonusitemenchant;
/*     */   }
/*     */   
/*     */   public String get_sucesshtml() {
/* 250 */     return this._sucesshtml;
/*     */   }
/*     */   
/*     */   public void set_sucesshtml(String sucesshtml) {
/* 254 */     this._sucesshtml = sucesshtml;
/*     */   }
/*     */   
/*     */   public String get_runmessage() {
/* 258 */     return this._runmessage;
/*     */   }
/*     */   
/*     */   public void set_runmessage(String runmessage) {
/* 262 */     this._runmessage = runmessage;
/*     */   }
/*     */   
/*     */   public String get_failhtml() {
/* 266 */     return this._failhtml;
/*     */   }
/*     */   
/*     */   public void set_failhtml(String failhtml) {
/* 270 */     this._failhtml = failhtml;
/*     */   }
/*     */   
/*     */   public String get_Allmessage() {
/* 274 */     return this._Allmessage;
/*     */   }
/*     */   
/*     */   public void set_Allmessage(String Allmessage) {
/* 278 */     this._Allmessage = Allmessage;
/*     */   }
/*     */   
/*     */   public int getitembroad() {
/* 282 */     return this._itembroad;
/*     */   }
/*     */   
/*     */   public void setitembroad(int itembroad) {
/* 286 */     this._itembroad = itembroad;
/*     */   }
/*     */   
/*     */   public String get_othermessage() {
/* 290 */     return this._othermessage;
/*     */   }
/*     */   
/*     */   public void set_othermessage(String othermessage) {
/* 294 */     this._othermessage = othermessage;
/*     */   }
/*     */   
/*     */   public int getitemran() {
/* 298 */     return this._itemran;
/*     */   }
/*     */   
/*     */   public void setitemran(int itemran) {
/* 302 */     this._itemran = itemran;
/*     */   }
/*     */   
/*     */   public void setitemranup(int itemranup) {
/* 306 */     this._itemranup = itemranup;
/*     */   }
/*     */   
/*     */   public int getitemranup() {
/* 310 */     return this._itemranup;
/*     */   }
/*     */   
/*     */   public void ShowCraftHtml(L1PcInstance pc, L1NpcInstance npc, L1Blend ItemBlend) {
/* 314 */     String msg0 = "";
/* 315 */     String msg2 = "";
/* 316 */     String msg3 = "";
/* 317 */     String msg4 = "";
/* 318 */     String msg5 = "";
/* 319 */     String msg6 = "";
/* 320 */     String msg7 = "";
/* 321 */     String msg8 = "";
/* 322 */     String msg9 = "";
/* 323 */     String msg10 = "";
/* 324 */     String msg11 = "";
/* 325 */     String msg12 = "";
/* 326 */     String msg13 = "";
/* 327 */     String msg14 = "";
/* 328 */     String msg15 = "";
/* 329 */     String msg16 = "";
/* 330 */     String msg17 = "";
/* 331 */     String msg18 = "";
/* 332 */     String msg19 = "";
/* 333 */     String msg20 = "";
/* 334 */     String msg21 = "";
/* 335 */     L1ItemInstance Newitem = ItemTable.get().createItem(ItemBlend.getNew_item());
/* 336 */     if (Newitem != null) {
/* 337 */       Newitem.setCount(ItemBlend.getNew_item_counts());
/* 338 */       Newitem.setEnchantLevel(ItemBlend.getNew_item_Enchantlvl());
/* 339 */       Newitem.setIdentified(true);
/* 340 */       msg0 = Newitem.getLogName();
/*     */     } 
/* 342 */     L1ItemInstance Bonusitem = ItemTable.get().createItem(ItemBlend.getBonus_item());
/* 343 */     if (Bonusitem != null) {
/* 344 */       Bonusitem.setCount(ItemBlend.getBonus_item_count());
/* 345 */       Bonusitem.setEnchantLevel(ItemBlend.getBonus_item_enchant());
/* 346 */       Bonusitem.setIdentified(true);
/* 347 */       msg2 = "製造成功時額外獲得: " + Bonusitem.getLogName();
/*     */     } 
/* 349 */     if (ItemBlend.getCheckLevel() != 0) {
/* 350 */       msg3 = " " + ItemBlend.getCheckLevel() + "級以上。 ";
/*     */     } else {
/* 352 */       msg3 = " 無限制 ";
/*     */     } 
/* 354 */     if (ItemBlend.getCheckClass() == 1) {
/* 355 */       msg4 = " 王族";
/* 356 */     } else if (ItemBlend.getCheckClass() == 2) {
/* 357 */       msg4 = " 騎士";
/* 358 */     } else if (ItemBlend.getCheckClass() == 3) {
/* 359 */       msg4 = " 法師";
/* 360 */     } else if (ItemBlend.getCheckClass() == 4) {
/* 361 */       msg4 = " 妖精";
/* 362 */     } else if (ItemBlend.getCheckClass() == 5) {
/* 363 */       msg4 = " 黑妖";
/* 364 */     } else if (ItemBlend.getCheckClass() == 6) {
/* 365 */       msg4 = " 龍騎士";
/* 366 */     } else if (ItemBlend.getCheckClass() == 7) {
/* 367 */       msg4 = " 幻術師";
/* 368 */     } else if (ItemBlend.getCheckClass() == 0) {
/* 369 */       msg4 = " 所有職業";
/*     */     } 
/* 371 */     if (ItemBlend.getRandom() != -1 && ItemBlend.get_runmessage() != null) {
/* 372 */       msg5 = " " + ItemBlend.get_runmessage();
/*     */     } else {
/* 374 */       msg5 = " " + ItemBlend.getRandom() + " %";
/*     */     } 
/* 376 */     int HammerRnd = CheckForFireHammerCount(pc, npc, ItemBlend);
/* 377 */     if (HammerRnd > 0 && ItemBlend.get_othermessage() != null) {
/* 378 */       msg6 = "[" + ItemBlend.get_othermessage() + "]成功機率+: " + HammerRnd + " %";
/*     */     }
/* 380 */     int[] Materials = ItemBlend.getMaterials();
/* 381 */     int[] counts = ItemBlend.getMaterials_count();
/* 382 */     int[] enchants = ItemBlend.get_materials_enchants();
/* 383 */     if (Materials != null) {
/* 384 */       int i = 0;
/* 385 */       while (i < Materials.length) {
/* 386 */         L1ItemInstance temp = ItemTable.get().createItem(Materials[i]);
/* 387 */         temp.setEnchantLevel(enchants[i]);
/* 388 */         temp.setIdentified(true);
/* 389 */         int replacementcount = ItemBlend.getReplacement_count();
/* 390 */         if (temp.getItemId() == 80028 && replacementcount != 0) {
/* 391 */           msg7 = "可用(" + replacementcount + ")個火神痕跡替代火神契約";
/*     */         }
/* 393 */         switch (i) {
/*     */           case 0:
/* 395 */             msg8 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 1:
/* 399 */             msg9 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 2:
/* 403 */             msg10 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 3:
/* 407 */             msg11 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 4:
/* 411 */             msg12 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 5:
/* 415 */             msg13 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 6:
/* 419 */             msg14 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 7:
/* 423 */             msg15 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 8:
/* 427 */             msg16 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 9:
/* 431 */             msg17 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 10:
/* 435 */             msg18 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 11:
/* 439 */             msg19 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 12:
/* 443 */             msg20 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */           
/*     */           case 13:
/* 447 */             msg21 = String.valueOf(String.valueOf(temp.getLogName())) + " (" + counts[i] + ") 個";
/*     */             break;
/*     */         } 
/*     */         
/* 451 */         i++;
/*     */       } 
/*     */     } 
/* 454 */     String[] msgs = { msg0, msg2, msg3, msg4, msg5, msg6, msg7, msg8, msg9, msg10, msg11, msg12, msg13, msg14, 
/* 455 */         msg15, msg16, msg17, msg18, msg19, msg20, msg21 };
/* 456 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(npc.getId(), "ItemBlend", msgs));
/*     */   }
/*     */   
/*     */   private boolean CheckForReplacement(L1PcInstance pc, L1Blend ItemBlend) {
/* 460 */     boolean replace = false;
/* 461 */     int replacement = 80322;
/* 462 */     int replacementcount = ItemBlend.getReplacement_count();
/* 463 */     if (replacementcount != 0 && pc.getInventory().checkItem(80322, replacementcount)) {
/* 464 */       replace = true;
/*     */     }
/* 466 */     return replace;
/*     */   }
/*     */   
/*     */   private int CheckForFireHammerCount(L1PcInstance pc, L1NpcInstance npc, L1Blend ItemBlend) {
/* 470 */     int HammerCount = 0;
/* 471 */     L1ItemInstance firehammer = pc.getInventory().findItemId(ItemBlend.getitemran());
/* 472 */     if (firehammer != null) {
/* 473 */       HammerCount = (int)firehammer.getCount();
/* 474 */       if (HammerCount > ItemBlend.getitemranup()) {
/* 475 */         HammerCount = ItemBlend.getitemranup();
/*     */       }
/*     */     } 
/* 478 */     return HammerCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public void CheckCraftItem(L1PcInstance pc, L1NpcInstance npc, L1Blend ItemBlend, int amount, boolean checked) {
/* 483 */     int[] Materials = ItemBlend.getMaterials();
/* 484 */     int[] Materials_counts = ItemBlend.getMaterials_count();
/* 485 */     int[] enchants = ItemBlend.get_materials_enchants();
/* 486 */     if (checked || !ItemBlend.isInputAmount()) {
/* 487 */       boolean isok = true;
/* 488 */       int New_itemid = ItemBlend.getNew_item();
/* 489 */       int New_item_counts = ItemBlend.getNew_item_counts();
/* 490 */       L1ItemInstance newitem = ItemTable.get().createItem(New_itemid);
/* 491 */       if (New_itemid == 56148 && (
/* 492 */         pc.getInventory().findItemId(56147) != null || pc.getInventory().findItemId(56148) != null)) {
/* 493 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage("身上已有妲蒂斯的魔力。"));
/* 494 */         isok = false;
/*     */       } 
/* 496 */       if (New_itemid == 56147 && pc.getInventory().findItemId(56147) != null) {
/* 497 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage("身上已有妲蒂斯的魔力。"));
/* 498 */         isok = false;
/*     */       } 
/* 500 */       if (pc.getInventory().checkAddItem(newitem, New_item_counts) != 0) {
/* 501 */         isok = false;
/*     */       }
/* 503 */       if (ItemBlend.getCheckLevel() != 0 && pc.getLevel() < ItemBlend.getCheckLevel()) {
/* 504 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage("等級必須為" + ItemBlend.getCheckLevel() + "以上。"));
/* 505 */         isok = false;
/*     */       } 
/* 507 */       if (ItemBlend.getCheckClass() != 0) {
/* 508 */         byte class_id = 0;
/* 509 */         String Classmsg = "";
/* 510 */         if (pc.isCrown()) {
/* 511 */           class_id = 1;
/* 512 */         } else if (pc.isKnight()) {
/* 513 */           class_id = 2;
/* 514 */         } else if (pc.isWizard()) {
/* 515 */           class_id = 3;
/* 516 */         } else if (pc.isElf()) {
/* 517 */           class_id = 4;
/* 518 */         } else if (pc.isDarkelf()) {
/* 519 */           class_id = 5;
/* 520 */         } else if (pc.isDragonKnight()) {
/* 521 */           class_id = 6;
/* 522 */         } else if (pc.isIllusionist()) {
/* 523 */           class_id = 7;
/*     */         } 
/* 525 */         switch (ItemBlend.getCheckClass()) {
/*     */           case 1:
/* 527 */             Classmsg = "王族";
/*     */             break;
/*     */           
/*     */           case 2:
/* 531 */             Classmsg = "騎士";
/*     */             break;
/*     */           
/*     */           case 3:
/* 535 */             Classmsg = "法師";
/*     */             break;
/*     */           
/*     */           case 4:
/* 539 */             Classmsg = "妖精";
/*     */             break;
/*     */           
/*     */           case 5:
/* 543 */             Classmsg = "黑暗妖精";
/*     */             break;
/*     */           
/*     */           case 6:
/* 547 */             Classmsg = "龍騎士";
/*     */             break;
/*     */           
/*     */           case 7:
/* 551 */             Classmsg = "幻術士";
/*     */             break;
/*     */         } 
/*     */         
/* 555 */         if (ItemBlend.getCheckClass() != class_id) {
/* 556 */           pc.sendPackets((ServerBasePacket)new S_ServerMessage(166, "職業必須是", Classmsg, "才能製造此道具"));
/* 557 */           isok = false;
/*     */         } 
/*     */       } 
/* 560 */       if (ItemBlend.getHpConsume() != 0 || ItemBlend.getMpConsume() != 0) {
/* 561 */         if (pc.getCurrentHp() < ItemBlend.getHpConsume()) {
/* 562 */           pc.sendPackets((ServerBasePacket)new S_ServerMessage(166, "$1083", "必須有 (" + ItemBlend.getHpConsume() + ") ", 
/* 563 */                 "才能使用此道具", "以上"));
/* 564 */           isok = false;
/*     */         } 
/* 566 */         if (pc.getCurrentMp() < ItemBlend.getMpConsume()) {
/* 567 */           pc.sendPackets((ServerBasePacket)new S_ServerMessage(166, "$1084", "必須有 (" + ItemBlend.getMpConsume() + ") ", 
/* 568 */                 "才能使用此道具", "以上"));
/* 569 */           isok = false;
/*     */         } 
/*     */       } 
/* 572 */       boolean enough = false;
/* 573 */       if (isok) {
/* 574 */         int num = 0;
/* 575 */         int i = 0;
/* 576 */         while (i < Materials.length) {
/* 577 */           if (Materials[i] != 0 && Materials_counts[i] != 0) {
/* 578 */             if (Materials[i] == 80028 && !pc.getInventory().checkItem(Materials[i], Materials_counts[i]) && 
/* 579 */               CheckForReplacement(pc, ItemBlend)) {
/* 580 */               num++;
/* 581 */             } else if (!pc.getInventory().checkEnchantItem(Materials[i], enchants[i], 
/* 582 */                 Materials_counts[i])) {
/* 583 */               L1ItemInstance temp = ItemTable.get().createItem(Materials[i]);
/* 584 */               temp.setEnchantLevel(enchants[i]);
/* 585 */               temp.setIdentified(true);
/* 586 */               pc.sendPackets((ServerBasePacket)new S_ServerMessage(337, 
/* 587 */                     String.valueOf(String.valueOf(temp.getLogName())) + "(" + Materials_counts[i] + ")"));
/* 588 */               isok = false;
/*     */             } else {
/* 590 */               num++;
/*     */             } 
/*     */           }
/* 593 */           i++;
/*     */         } 
/* 595 */         if (num == Materials.length) {
/* 596 */           enough = true;
/*     */         }
/*     */       } 
/* 599 */       if (isok && enough) {
/* 600 */         if (ItemBlend.isAll_In_Once()) {
/* 601 */           int[] newcounts = new int[Materials_counts.length];
/* 602 */           int i = 0;
/* 603 */           while (i < Materials_counts.length) {
/* 604 */             newcounts[i] = Materials_counts[i] * amount;
/* 605 */             i++;
/*     */           } 
/* 607 */           i = 0;
/* 608 */           while (i < Materials.length) {
/* 609 */             pc.getInventory().consumeEnchantItem(Materials[i], enchants[i], newcounts[i]);
/* 610 */             i++;
/*     */           } 
/*     */         } else {
/* 613 */           int a = 0;
/* 614 */           while (a < amount) {
/* 615 */             int i = 0;
/* 616 */             while (i < Materials.length) {
/* 617 */               pc.getInventory().consumeEnchantItem(Materials[i], enchants[i], Materials_counts[i]);
/* 618 */               i++;
/*     */             } 
/* 620 */             a++;
/*     */           } 
/*     */         } 
/* 623 */         if (ItemBlend.getHpConsume() > 0) {
/* 624 */           pc.setCurrentHp(pc.getCurrentHp() - ItemBlend.getHpConsume());
/*     */         }
/* 626 */         if (ItemBlend.getMpConsume() > 0) {
/* 627 */           pc.setCurrentMp(pc.getCurrentMp() - ItemBlend.getMpConsume());
/*     */         }
/* 629 */         CraftItem(pc, npc, ItemBlend, amount);
/* 630 */         String sucesshtml = ItemBlend.get_sucesshtml();
/* 631 */         int DBrnd = ItemBlend.getRandom();
/* 632 */         if (sucesshtml != null && amount == 1 && DBrnd == 100) {
/* 633 */           pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), sucesshtml));
/*     */         }
/*     */       } else {
/* 636 */         String failhtml = ItemBlend.get_failhtml();
/* 637 */         int DBrnd = ItemBlend.getRandom();
/* 638 */         if (failhtml != null && amount == 1 && DBrnd == 100) {
/* 639 */           pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), failhtml));
/*     */         } else {
/* 641 */           pc.sendPackets((ServerBasePacket)new S_CloseList(pc.getId()));
/*     */         } 
/*     */       } 
/*     */       return;
/*     */     } 
/* 646 */     long xcount = CreateNewItem.checkNewItem(pc, Materials, Materials_counts);
/* 647 */     if (xcount >= 1L) {
/* 648 */       pc.sendPackets((ServerBasePacket)new S_ItemCount(npc.getId(), (int)xcount, null));
/*     */       return;
/*     */     } 
/* 651 */     pc.sendPackets((ServerBasePacket)new S_CloseList(pc.getId()));
/*     */   }
/*     */   
/*     */   private void CraftItem(L1PcInstance pc, L1NpcInstance npc, L1Blend ItemBlend, int amount) {
/* 655 */     Random _random = new Random();
/* 656 */     int DBrnd = ItemBlend.getRandom();
/* 657 */     int HammerRnd = CheckForFireHammerCount(pc, npc, ItemBlend);
/* 658 */     int TotalChance = DBrnd + HammerRnd;
/* 659 */     int New_itemid = ItemBlend.getNew_item();
/* 660 */     int New_item_counts = ItemBlend.getNew_item_counts();
/* 661 */     int Bonus_itemid = ItemBlend.getBonus_item();
/* 662 */     int Bonusitem_count = ItemBlend.getBonus_item_count();
/* 663 */     int Bonusitem_enchant = ItemBlend.getBonus_item_enchant();
/* 664 */     int ItemLV_SW = ItemBlend.getNew_Enchantlvl_SW();
/* 665 */     int ItemLV = ItemBlend.getNew_item_Enchantlvl();
/* 666 */     int ItemBless = ItemBlend.getNew_item_Bless();
/* 667 */     int ResdueItem = ItemBlend.getResidue_Item();
/* 668 */     int ResdueCount = ItemBlend.getResidue_Count();
/* 669 */     String npcName = npc.getNpcTemplate().get_name();
/* 670 */     int newamount = amount;
/* 671 */     int newcounts = New_item_counts;
/* 672 */     if (ItemBlend.isAll_In_Once()) {
/* 673 */       newamount = 1;
/* 674 */       newcounts = New_item_counts * amount;
/*     */     } 
/* 676 */     int i = 0;
/* 677 */     while (i < newamount) {
/* 678 */       if (_random.nextInt(100) + 1 <= TotalChance) {
/* 679 */         L1ItemInstance newitem = ItemTable.get().createItem(New_itemid);
/* 680 */         if (newitem != null && pc.getInventory().checkAddItem(newitem, newcounts) == 0) {
/* 681 */           if (newitem.isStackable()) {
/* 682 */             if (ItemLV_SW == 0) {
/* 683 */               newitem.setEnchantLevel(ItemLV);
/* 684 */               newitem.setBless(ItemBless);
/* 685 */               newitem.setIdentified(true);
/*     */             } else {
/* 687 */               newitem.setEnchantLevel(_random.nextInt(ItemLV) + 1);
/* 688 */               newitem.setBless(ItemBless);
/* 689 */               newitem.setIdentified(true);
/*     */             } 
/* 691 */             newitem.setCount(newcounts);
/* 692 */             pc.getInventory().storeItem(newitem);
/* 693 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(143, npcName, newitem.getLogName()));
/* 694 */             if (ItemBlend.getitembroad() > 0 && ItemBlend.get_Allmessage() != null) {
/* 695 */               World.get().broadcastPacketToAll((ServerBasePacket)new S_SystemMessage(
/* 696 */                     String.format(ItemBlend.get_Allmessage(), new Object[] { pc.getName(), newitem.getLogName() })));
/*     */             }
/* 698 */             firenpc("IP(" + pc.getNetConnection().getIp() + ")" + "玩家" + ":【 " + pc.getName() + " 】 " + 
/* 699 */                 "成功鑄造" + newitem.getLogName() + "(" + newcounts + ")" + " 】,時間:" + "(" + 
/* 700 */                 new Timestamp(System.currentTimeMillis()) + ")。");
/*     */           } else {
/* 702 */             int c = 0;
/* 703 */             while (c < newcounts) {
/* 704 */               L1ItemInstance newitem2 = ItemTable.get().createItem(New_itemid);
/* 705 */               if (ItemLV_SW == 0) {
/* 706 */                 newitem2.setEnchantLevel(ItemLV);
/* 707 */                 newitem2.setBless(ItemBless);
/* 708 */                 newitem2.setIdentified(true);
/*     */               } else {
/* 710 */                 newitem2.setEnchantLevel(_random.nextInt(ItemLV) + 1);
/* 711 */                 newitem2.setBless(ItemBless);
/* 712 */                 newitem2.setIdentified(true);
/*     */               } 
/* 714 */               newitem2.setCount(1L);
/* 715 */               pc.getInventory().storeItem(newitem2);
/* 716 */               pc.sendPackets((ServerBasePacket)new S_ServerMessage(143, npcName, newitem2.getLogName()));
/* 717 */               if (ItemBlend.getitembroad() > 0 && ItemBlend.get_Allmessage() != null) {
/* 718 */                 World.get().broadcastPacketToAll((ServerBasePacket)new S_SystemMessage(
/* 719 */                       String.format(ItemBlend.get_Allmessage(), new Object[] { pc.getName(), newitem.getLogName() })));
/*     */               }
/* 721 */               firenpc("IP(" + pc.getNetConnection().getIp() + ")" + "玩家" + ":【 " + pc.getName() + " 】 " + 
/* 722 */                   "成功鑄造" + newitem.getLogName() + "(" + newcounts + ")" + " 】,時間:" + "(" + 
/* 723 */                   new Timestamp(System.currentTimeMillis()) + ")。");
/* 724 */               c++;
/*     */             } 
/*     */           } 
/*     */         }
/* 728 */         L1ItemInstance bonusitem = ItemTable.get().createItem(Bonus_itemid);
/* 729 */         if (bonusitem != null && pc.getInventory().checkAddItem(bonusitem, Bonusitem_count) == 0) {
/* 730 */           if (bonusitem.isStackable()) {
/* 731 */             bonusitem.setEnchantLevel(Bonusitem_enchant);
/* 732 */             bonusitem.setIdentified(true);
/* 733 */             bonusitem.setCount(Bonusitem_count);
/* 734 */             pc.getInventory().storeItem(bonusitem);
/* 735 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(143, npcName, bonusitem.getLogName()));
/*     */           } else {
/* 737 */             int c2 = 0;
/* 738 */             while (c2 < Bonusitem_count) {
/* 739 */               L1ItemInstance bonusitem2 = ItemTable.get().createItem(Bonus_itemid);
/* 740 */               bonusitem2.setEnchantLevel(Bonusitem_enchant);
/* 741 */               bonusitem2.setIdentified(true);
/* 742 */               bonusitem2.setCount(1L);
/* 743 */               pc.getInventory().storeItem(bonusitem2);
/* 744 */               pc.sendPackets((ServerBasePacket)new S_ServerMessage(143, npcName, bonusitem2.getLogName()));
/* 745 */               c2++;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } else {
/* 750 */         L1ItemInstance residueitem = ItemTable.get().createItem(ResdueItem);
/* 751 */         if (residueitem != null && ResdueCount > 0) {
/* 752 */           if (pc.getInventory().checkAddItem(residueitem, ResdueCount) == 0) {
/* 753 */             residueitem.setCount(ResdueCount);
/* 754 */             pc.getInventory().storeItem(residueitem);
/* 755 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(143, npcName, residueitem.getLogName()));
/* 756 */             pc.sendPackets((ServerBasePacket)new S_SystemMessage("道具製造失敗了"));
/* 757 */             firenpcfail("IP(" + pc.getNetConnection().getIp() + ")" + "玩家" + ":【 " + pc.getName() + " 】 " + 
/* 758 */                 "失敗鑄造" + residueitem.getLogName() + "(" + newcounts + ")" + " 】,時間:" + "(" + 
/* 759 */                 new Timestamp(System.currentTimeMillis()) + ")。");
/*     */           } 
/*     */         } else {
/* 762 */           pc.sendPackets((ServerBasePacket)new S_SystemMessage("道具製造失敗了"));
/*     */         } 
/*     */       } 
/* 765 */       int Hammercount = CheckForFireHammerCount(pc, npc, ItemBlend);
/* 766 */       if (Hammercount > 0) {
/* 767 */         pc.getInventory().consumeItem(ItemBlend.getitemran(), Hammercount);
/*     */       }
/* 769 */       i++;
/*     */     } 
/* 771 */     pc.sendPackets((ServerBasePacket)new S_CloseList(pc.getId()));
/*     */   }
/*     */   
/*     */   public static void firenpc(String info) {
/* 775 */     PlayerLogUtil.writeLog("製作NPC記錄", info);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void firenpcfail(String info) {
/* 786 */     PlayerLogUtil.writeLog("製作NPC失敗記錄", info);
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\system\L1Blend.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */