/*     */ package com.lineage.data.cmd;
/*     */ 
/*     */ import com.lineage.server.datatables.ItemTable;
/*     */ import com.lineage.server.datatables.lock.CharShiftingReading;
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ import com.lineage.server.model.Instance.L1NpcInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.model.L1Character;
/*     */ import com.lineage.server.model.L1Object;
/*     */ import com.lineage.server.serverpackets.S_HelpMessage;
/*     */ import com.lineage.server.serverpackets.S_ItemCount;
/*     */ import com.lineage.server.serverpackets.S_ServerMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.templates.L1Item;
/*     */ import com.lineage.server.utils.DigitalUtil;
/*     */ import com.lineage.server.world.World;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CreateNewItem
/*     */ {
/*  24 */   private static final Log _log = LogFactory.getLog(CreateNewItem.class);
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean delItems(L1PcInstance pc, int[] srcItemIds, int[] counts, long amount) {
/*     */     try {
/*  30 */       if (pc == null) {
/*  31 */         return false;
/*     */       }
/*  33 */       if (amount <= 0L) {
/*  34 */         return false;
/*     */       }
/*  36 */       if (srcItemIds.length <= 0) {
/*  37 */         return false;
/*     */       }
/*  39 */       if (counts.length <= 0) {
/*  40 */         return false;
/*     */       }
/*  42 */       if (srcItemIds.length != counts.length) {
/*  43 */         _log.error("道具交換物品與數量陣列設置異常!");
/*  44 */         return false;
/*     */       } 
/*  46 */       int i = 0;
/*  47 */       while (i < srcItemIds.length) {
/*  48 */         long itemCount = counts[i] * amount;
/*  49 */         L1ItemInstance item = pc.getInventory().checkItemX(srcItemIds[i], itemCount);
/*  50 */         if (item == null) {
/*  51 */           return false;
/*     */         }
/*  53 */         i++;
/*     */       } 
/*  55 */       i = 0;
/*  56 */       while (i < srcItemIds.length) {
/*  57 */         long itemCount2 = counts[i] * amount;
/*  58 */         L1ItemInstance item = pc.getInventory().checkItemX(srcItemIds[i], itemCount2);
/*  59 */         if (item == null) {
/*  60 */           return false;
/*     */         }
/*  62 */         pc.getInventory().removeItem(item, itemCount2);
/*  63 */         i++;
/*     */       } 
/*  65 */       return true;
/*  66 */     } catch (Exception e) {
/*  67 */       _log.error(e.getLocalizedMessage(), e);
/*  68 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean getItem(L1PcInstance pc, L1NpcInstance npc, String cmd, int[] items, int[] counts, int[] gitems, int[] gcounts, long amount) {
/*  74 */     long xcount = checkNewItem(pc, items, counts);
/*  75 */     if (xcount <= 0L) {
/*  76 */       return true;
/*     */     }
/*  78 */     if (amount == 0L) {
/*  79 */       pc.sendPackets((ServerBasePacket)new S_ItemCount(npc.getId(), (int)xcount, cmd));
/*  80 */       return false;
/*     */     } 
/*  82 */     if (xcount >= amount) {
/*  83 */       createNewItem(pc, items, counts, gitems, amount, gcounts);
/*     */     }
/*  85 */     return true;
/*     */   }
/*     */   
/*     */   public static long checkNewItem(L1PcInstance pc, int srcItemId, int count) {
/*     */     try {
/*  90 */       if (pc == null) {
/*  91 */         return -1L;
/*     */       }
/*  93 */       L1ItemInstance item = pc.getInventory().findItemIdNoEq(srcItemId);
/*  94 */       long itemCount = -1L;
/*  95 */       if (item != null) {
/*  96 */         itemCount = item.getCount() / count;
/*     */       }
/*  98 */       if (itemCount < 1L) {
/*  99 */         L1Item tgItem = ItemTable.get().getTemplate(srcItemId);
/* 100 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(337, String.valueOf(String.valueOf(tgItem.getNameId())) + "(" + (
/* 101 */               count - ((item == null) ? 0L : item.getCount())) + ")"));
/* 102 */         return -1L;
/*     */       } 
/* 104 */       return itemCount;
/* 105 */     } catch (Exception e) {
/* 106 */       _log.error(e.getLocalizedMessage(), e);
/* 107 */       return -1L;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static long checkNewItem(L1PcInstance pc, int[] srcItemIds, int[] counts) {
/*     */     try {
/* 113 */       if (pc == null) {
/* 114 */         return -1L;
/*     */       }
/* 116 */       if (srcItemIds.length <= 0) {
/* 117 */         return -1L;
/*     */       }
/* 119 */       if (counts.length <= 0) {
/* 120 */         return -1L;
/*     */       }
/* 122 */       if (srcItemIds.length != counts.length) {
/* 123 */         _log.error("道具交換物品與數量陣列設置異常!");
/* 124 */         return -1L;
/*     */       } 
/* 126 */       long[] checkCount = new long[srcItemIds.length];
/* 127 */       boolean error = false;
/* 128 */       int i = 0;
/* 129 */       while (i < srcItemIds.length) {
/* 130 */         int itemid = srcItemIds[i];
/* 131 */         int count = counts[i];
/* 132 */         L1ItemInstance item = pc.getInventory().findItemIdNoEq(itemid);
/* 133 */         if (item != null) {
/* 134 */           long itemCount = item.getCount() / count;
/* 135 */           checkCount[i] = itemCount;
/* 136 */           if (itemCount < 1L) {
/* 137 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(337, 
/* 138 */                   String.valueOf(String.valueOf(item.getName())) + "(" + (count - item.getCount()) + ")"));
/* 139 */             error = true;
/*     */           } 
/*     */         } else {
/* 142 */           L1Item tgItem = ItemTable.get().getTemplate(itemid);
/* 143 */           pc.sendPackets((ServerBasePacket)new S_ServerMessage(337, String.valueOf(String.valueOf(tgItem.getNameId())) + "(" + count + ")"));
/* 144 */           error = true;
/*     */         } 
/* 146 */         i++;
/*     */       } 
/* 148 */       if (!error) {
/* 149 */         long count2 = DigitalUtil.returnMin(checkCount);
/* 150 */         return count2;
/*     */       } 
/* 152 */     } catch (Exception e) {
/* 153 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/* 155 */     return -1L;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void createNewItem(L1PcInstance pc, int[] srcItemIds, int[] counts, int getItemId, long amount, int getCount) {
/*     */     try {
/* 161 */       if (pc == null) {
/*     */         return;
/*     */       }
/* 164 */       if (amount <= 0L) {
/*     */         return;
/*     */       }
/* 167 */       if (srcItemIds.length <= 0) {
/*     */         return;
/*     */       }
/* 170 */       if (counts.length <= 0) {
/*     */         return;
/*     */       }
/* 173 */       if (srcItemIds.length != counts.length) {
/* 174 */         _log.error("道具交換物品與數量陣列設置異常!");
/*     */         return;
/*     */       } 
/* 177 */       if (getItemId == 0) {
/*     */         return;
/*     */       }
/* 180 */       if (getCount == 0) {
/*     */         return;
/*     */       }
/* 183 */       boolean error = false;
/* 184 */       int i = 0;
/* 185 */       while (i < srcItemIds.length) {
/* 186 */         long itemCount = counts[i] * amount;
/* 187 */         L1ItemInstance item = pc.getInventory().checkItemX(srcItemIds[i], itemCount);
/* 188 */         if (item == null) {
/* 189 */           error = true;
/*     */         }
/* 191 */         i++;
/*     */       } 
/* 193 */       if (!error && !getItemIsOk(pc, getItemId, amount, getCount)) {
/* 194 */         error = true;
/*     */       }
/* 196 */       if (!error) {
/* 197 */         i = 0;
/* 198 */         while (i < srcItemIds.length) {
/* 199 */           long itemCount2 = counts[i] * amount;
/* 200 */           L1ItemInstance item = pc.getInventory().checkItemX(srcItemIds[i], itemCount2);
/* 201 */           if (item != null) {
/* 202 */             pc.getInventory().removeItem(item, itemCount2);
/*     */           } else {
/* 204 */             error = true;
/*     */           } 
/* 206 */           i++;
/*     */         } 
/*     */       } 
/* 209 */       if (!error) {
/* 210 */         giveItem(pc, getItemId, amount, getCount);
/*     */       }
/* 212 */     } catch (Exception e) {
/* 213 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void createNewItem(L1PcInstance pc, int[] srcItemIds, int[] counts, int[] getItemIds, long amount, int[] getCounts) {
/*     */     try {
/* 220 */       if (pc == null) {
/*     */         return;
/*     */       }
/* 223 */       if (amount <= 0L) {
/*     */         return;
/*     */       }
/* 226 */       if (srcItemIds.length <= 0) {
/*     */         return;
/*     */       }
/* 229 */       if (counts.length <= 0) {
/*     */         return;
/*     */       }
/* 232 */       if (srcItemIds.length != counts.length) {
/* 233 */         _log.error("道具交換物品與數量陣列設置異常!");
/*     */         return;
/*     */       } 
/* 236 */       if (getItemIds.length <= 0) {
/*     */         return;
/*     */       }
/* 239 */       if (getCounts.length <= 0) {
/*     */         return;
/*     */       }
/* 242 */       if (getItemIds.length != getCounts.length) {
/* 243 */         _log.error("道具交換物品與數量陣列設置異常!");
/*     */         return;
/*     */       } 
/* 246 */       boolean error = false;
/* 247 */       int i = 0;
/* 248 */       while (i < srcItemIds.length) {
/* 249 */         long itemCount = counts[i] * amount;
/* 250 */         L1ItemInstance item = pc.getInventory().checkItemX(srcItemIds[i], itemCount);
/* 251 */         if (item == null) {
/* 252 */           error = true;
/*     */         }
/* 254 */         i++;
/*     */       } 
/* 256 */       if (!error) {
/* 257 */         i = 0;
/* 258 */         while (i < getItemIds.length) {
/* 259 */           if (!getItemIsOk(pc, getItemIds[i], amount, getCounts[i])) {
/* 260 */             error = true;
/*     */           }
/* 262 */           i++;
/*     */         } 
/*     */       } 
/* 265 */       if (!error) {
/* 266 */         i = 0;
/* 267 */         while (i < srcItemIds.length) {
/* 268 */           long itemCount2 = counts[i] * amount;
/* 269 */           L1ItemInstance item = pc.getInventory().checkItemX(srcItemIds[i], itemCount2);
/* 270 */           if (item != null) {
/* 271 */             pc.getInventory().removeItem(item, itemCount2);
/*     */           } else {
/* 273 */             error = true;
/*     */           } 
/* 275 */           i++;
/*     */         } 
/*     */       } 
/* 278 */       if (!error) {
/* 279 */         i = 0;
/* 280 */         while (i < getItemIds.length) {
/* 281 */           giveItem(pc, getItemIds[i], amount, getCounts[i]);
/* 282 */           i++;
/*     */         } 
/*     */       } 
/* 285 */     } catch (Exception e) {
/* 286 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean getItemIsOk(L1PcInstance pc, int getItemId, long amount, int getCount) {
/*     */     try {
/* 293 */       if (pc == null) {
/* 294 */         return false;
/*     */       }
/* 296 */       L1Item tgItem = ItemTable.get().getTemplate(getItemId);
/* 297 */       if (pc.getInventory().checkAddItem(tgItem, amount * getCount) != 0) {
/* 298 */         return false;
/*     */       }
/* 300 */     } catch (Exception e) {
/* 301 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/* 303 */     return true;
/*     */   }
/*     */   
/*     */   private static void giveItem(L1PcInstance pc, int getItemId, long amount, int getCount) {
/*     */     try {
/* 308 */       if (pc == null) {
/*     */         return;
/*     */       }
/* 311 */       L1Item tgItem = ItemTable.get().getTemplate(getItemId);
/* 312 */       if (tgItem.isStackable()) {
/* 313 */         L1ItemInstance tgItemX = ItemTable.get().createItem(getItemId);
/* 314 */         tgItemX.setCount(amount * getCount);
/* 315 */         createNewItem(pc, tgItemX);
/*     */       } else {
/* 317 */         int get = 0;
/* 318 */         while (get < amount * getCount) {
/* 319 */           L1ItemInstance tgItemX2 = ItemTable.get().createItem(getItemId);
/* 320 */           tgItemX2.setCount(1L);
/* 321 */           createNewItem(pc, tgItemX2);
/* 322 */           get++;
/*     */         } 
/*     */       } 
/* 325 */     } catch (Exception e) {
/* 326 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void createNewItem(L1PcInstance pc, int srcItemId, int count, int getItemId, int getCount) {
/* 332 */     createNewItem(pc, srcItemId, count, getItemId, 1L, getCount);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void createNewItem(L1PcInstance pc, int srcItemId, int count, int getItemId, long amount, int getCount) {
/* 337 */     long itemCount1 = count * amount;
/* 338 */     L1ItemInstance item1 = pc.getInventory().checkItemX(srcItemId, itemCount1);
/* 339 */     if (item1 != null) {
/* 340 */       L1ItemInstance tgItem = ItemTable.get().createItem(getItemId);
/* 341 */       if (pc.getInventory().checkAddItem(tgItem, amount * getCount) == 0) {
/* 342 */         pc.getInventory().removeItem(item1, itemCount1);
/* 343 */         if (tgItem.isStackable()) {
/* 344 */           tgItem.setCount(amount * getCount);
/* 345 */           createNewItem(pc, tgItem);
/*     */         } else {
/* 347 */           int get = 0;
/* 348 */           while (get < amount * getCount) {
/* 349 */             L1ItemInstance tgItemX = ItemTable.get().createItem(getItemId);
/* 350 */             tgItemX.setCount(1L);
/* 351 */             createNewItem(pc, tgItemX);
/* 352 */             get++;
/*     */           } 
/*     */         } 
/*     */       } else {
/* 356 */         World.get().removeObject((L1Object)tgItem);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void createNewItem(L1PcInstance pc, int srcItemId, int count, int getItemId, long amount) {
/* 363 */     long itemCount1 = count * amount;
/* 364 */     L1ItemInstance item1 = pc.getInventory().checkItemX(srcItemId, itemCount1);
/* 365 */     if (item1 != null) {
/* 366 */       L1ItemInstance tgItem = ItemTable.get().createItem(getItemId);
/* 367 */       if (pc.getInventory().checkAddItem(tgItem, amount) == 0) {
/* 368 */         pc.getInventory().removeItem(item1, itemCount1);
/* 369 */         if (tgItem.isStackable()) {
/* 370 */           tgItem.setCount(amount);
/* 371 */           createNewItem(pc, tgItem);
/*     */         } else {
/* 373 */           int get = 0;
/* 374 */           while (get < amount) {
/* 375 */             L1ItemInstance tgItemX = ItemTable.get().createItem(getItemId);
/* 376 */             tgItemX.setCount(1L);
/* 377 */             createNewItem(pc, tgItemX);
/* 378 */             get++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void createNewItem(L1PcInstance pc, L1ItemInstance item) {
/*     */     try {
/* 387 */       if (pc == null) {
/*     */         return;
/*     */       }
/* 390 */       if (item == null) {
/*     */         return;
/*     */       }
/* 393 */       pc.getInventory().storeItem(item);
/* 394 */       pc.sendPackets((ServerBasePacket)new S_ServerMessage(403, item.getLogName()));
/* 395 */     } catch (Exception e) {
/* 396 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void createNewItem(L1PcInstance pc, L1ItemInstance item, long count) {
/*     */     try {
/* 402 */       if (pc == null) {
/*     */         return;
/*     */       }
/* 405 */       if (item == null) {
/*     */         return;
/*     */       }
/* 408 */       item.setCount(count);
/* 409 */       if (pc.getInventory().checkAddItem(item, count) == 0) {
/* 410 */         pc.getInventory().storeItem(item);
/*     */       } else {
/* 412 */         item.set_showId(pc.get_showId());
/* 413 */         World.get().getInventory(pc.getX(), pc.getY(), pc.getMapId()).storeItem(item);
/*     */       } 
/* 415 */       pc.sendPackets((ServerBasePacket)new S_ServerMessage(403, item.getLogName()));
/* 416 */     } catch (Exception e) {
/* 417 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean createNewItem(L1PcInstance pc, int item_id, long count) {
/*     */     try {
/* 423 */       if (pc == null) {
/* 424 */         return false;
/*     */       }
/* 426 */       L1ItemInstance item = ItemTable.get().createItem(item_id);
/* 427 */       if (item != null) {
/* 428 */         item.setCount(count);
/* 429 */         if (pc.getInventory().checkAddItem(item, count) == 0) {
/* 430 */           pc.getInventory().storeItem(item);
/*     */         } else {
/* 432 */           item.set_showId(pc.get_showId());
/* 433 */           World.get().getInventory(pc.getX(), pc.getY(), pc.getMapId()).storeItem(item);
/*     */         } 
/* 435 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(403, item.getLogName()));
/* 436 */         return true;
/*     */       } 
/* 438 */       _log.error("給予物件失敗 原因: 指定編號物品不存在(" + item_id + ")");
/* 439 */       return false;
/* 440 */     } catch (Exception e) {
/* 441 */       _log.error(e.getLocalizedMessage(), e);
/* 442 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean createNewItemAi(L1PcInstance pc, int item_id, long count) {
/*     */     try {
/* 448 */       if (pc == null) {
/* 449 */         return false;
/*     */       }
/* 451 */       L1ItemInstance item = ItemTable.get().createItem(item_id);
/* 452 */       if (item != null) {
/* 453 */         item.setCount(count);
/* 454 */         if (pc.getInventory().checkAddItem(item, count) == 0) {
/* 455 */           pc.getInventory().storeItem(item);
/*     */         } else {
/* 457 */           item.set_showId(pc.get_showId());
/* 458 */           World.get().getInventory(pc.getX(), pc.getY(), pc.getMapId()).storeItem(item);
/*     */         } 
/* 460 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(403, item.getLogName()));
/* 461 */         return true;
/*     */       } 
/* 463 */       _log.error("給予物件失敗 原因: 指定編號物品不存在(" + item_id + ")");
/* 464 */       return false;
/* 465 */     } catch (Exception e) {
/* 466 */       _log.error(e.getLocalizedMessage(), e);
/* 467 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void getQuestItem(L1Character atk, L1NpcInstance npc, int item_id, long count) {
/*     */     try {
/* 474 */       if (atk == null) {
/*     */         return;
/*     */       }
/* 477 */       L1ItemInstance item = ItemTable.get().createItem(item_id);
/* 478 */       if (item != null) {
/* 479 */         item.setCount(count);
/* 480 */         if (atk.getInventory().checkAddItem(item, count) == 0) {
/* 481 */           atk.getInventory().storeItem(item);
/*     */         } else {
/* 483 */           item.set_showId(atk.get_showId());
/* 484 */           World.get().getInventory(atk.getX(), atk.getY(), atk.getMapId()).storeItem(item);
/*     */         } 
/* 486 */         if (atk instanceof L1PcInstance) {
/* 487 */           L1PcInstance pc = (L1PcInstance)atk;
/* 488 */           if (npc != null) {
/* 489 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(143, npc.getNameId(), item.getLogName()));
/* 490 */             pc.sendPackets((ServerBasePacket)new S_HelpMessage("\\fW" + npc.getNameId() + "給你" + item.getLogName()));
/*     */           } else {
/* 492 */             pc.sendPackets((ServerBasePacket)new S_HelpMessage("\\fW給你", item.getLogName()));
/*     */           } 
/*     */         } 
/*     */       } else {
/* 496 */         _log.error("給予物件失敗 原因: 指定編號物品不存在(" + item_id + ")");
/*     */       } 
/* 498 */     } catch (Exception e) {
/* 499 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void updateA(L1PcInstance pc, L1ItemInstance srcItem, L1ItemInstance newItem, int enchant, int down, int mode) {
/*     */     try {
/* 506 */       if (pc == null) {
/*     */         return;
/*     */       }
/* 509 */       if (srcItem == null) {
/*     */         return;
/*     */       }
/* 512 */       if (newItem == null) {
/*     */         return;
/*     */       }
/* 515 */       newItem.setCount(1L);
/* 516 */       if (srcItem.getEnchantLevel() > enchant) {
/* 517 */         newItem.setEnchantLevel(srcItem.getEnchantLevel() - down);
/*     */       } else {
/* 519 */         newItem.setEnchantLevel(srcItem.getEnchantLevel());
/*     */       } 
/* 521 */       newItem.setAttrEnchantKind(srcItem.getAttrEnchantKind());
/* 522 */       newItem.setAttrEnchantLevel(srcItem.getAttrEnchantLevel());
/* 523 */       newItem.setIdentified(true);
/* 524 */       int srcObjid = srcItem.getId();
/* 525 */       L1Item srcItemX = srcItem.getItem();
/* 526 */       if (pc.getInventory().removeItem(srcItem) == 1L) {
/* 527 */         pc.getInventory().storeItem(newItem);
/* 528 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(403, newItem.getLogName()));
/* 529 */         CharShiftingReading.get().newShifting(pc, 0, null, srcObjid, srcItemX, newItem, mode);
/*     */       } 
/* 531 */     } catch (Exception e) {
/* 532 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void updateB(L1PcInstance pc, L1ItemInstance srcItem, int newid) {
/*     */     try {
/* 538 */       if (pc == null) {
/*     */         return;
/*     */       }
/* 541 */       if (srcItem == null) {
/*     */         return;
/*     */       }
/* 544 */       L1ItemInstance newItem = ItemTable.get().createItem(newid);
/* 545 */       if (newItem != null) {
/* 546 */         if (pc.getInventory().removeItem(srcItem) == 1L) {
/* 547 */           pc.getInventory().storeItem(newItem);
/*     */         }
/*     */       } else {
/* 550 */         _log.error("給予物件失敗 原因: 指定編號物品不存在(" + newid + ")");
/*     */       } 
/* 552 */     } catch (Exception e) {
/* 553 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void createNewItem_LV(L1PcInstance pc, int item_id, int count, int EnchantLevel) {
/* 559 */     L1ItemInstance item = ItemTable.get().createItem(item_id);
/* 560 */     item.setCount(count);
/* 561 */     item.setEnchantLevel(EnchantLevel);
/* 562 */     item.setIdentified(true);
/* 563 */     if (pc.getInventory().checkAddItem(item, count) == 0) {
/* 564 */       pc.getInventory().storeItem(item);
/* 565 */       pc.sendPackets((ServerBasePacket)new S_ServerMessage(403, item.getLogName()));
/*     */     } else {
/* 567 */       World.get().removeObject((L1Object)item);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean createNewItem(L1PcInstance pc, int item_id, int count, int en) {
/*     */     try {
/* 573 */       if (pc == null) {
/* 574 */         return false;
/*     */       }
/* 576 */       L1ItemInstance item = ItemTable.get().createItem(item_id);
/* 577 */       if (item != null) {
/* 578 */         if (item.isStackable()) {
/* 579 */           item.setCount(count);
/*     */         } else {
/* 581 */           item.setCount(1L);
/*     */         } 
/* 583 */         item.setEnchantLevel(en);
/* 584 */         if (pc.getInventory().checkAddItem(item, count) == 0) {
/* 585 */           pc.getInventory().storeItem(item);
/*     */         } else {
/* 587 */           World.get().getInventory(pc.getX(), pc.getY(), pc.getMapId()).storeItem(item);
/*     */         } 
/* 589 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(403, item.getLogName()));
/* 590 */         return true;
/*     */       } 
/* 592 */       _log.error("給予物件失敗 原因: 指定編號物品不存在(" + item_id + ")");
/* 593 */       return false;
/* 594 */     } catch (Exception e) {
/* 595 */       _log.error(e.getLocalizedMessage(), e);
/* 596 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void createNewItem_NPC(L1PcInstance pc, String npcName, int item_id, int count) {
/* 602 */     L1ItemInstance item = ItemTable.get().createItem(item_id);
/* 603 */     item.setCount(count);
/* 604 */     if (pc.getInventory().checkAddItem(item, count) == 0) {
/* 605 */       pc.getInventory().storeItem(item);
/*     */     } else {
/* 607 */       World.get().getInventory(pc.getX(), pc.getY(), pc.getMapId()).storeItem(item);
/*     */     } 
/* 609 */     pc.sendPackets((ServerBasePacket)new S_ServerMessage(143, npcName, item.getLogName()));
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\cmd\CreateNewItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */