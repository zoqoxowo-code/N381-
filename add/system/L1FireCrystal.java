/*     */ package com.add.system;
/*     */ 
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class L1FireCrystal
/*     */ {
/*     */   private int _itemid;
/*     */   private int _enchant_lv0;
/*     */   private int _enchant_lv1;
/*     */   private int _enchant_lv2;
/*     */   private int _enchant_lv3;
/*     */   private int _enchant_lv4;
/*     */   private int _enchant_lv5;
/*     */   private int _enchant_lv6;
/*     */   private int _enchant_lv7;
/*     */   private int _enchant_lv8;
/*     */   private int _enchant_lv9;
/*     */   private int _enchant_lv10;
/*     */   private int _enchant_lv11;
/*     */   private int _enchant_lv12;
/*     */   private int _enchant_lv13;
/*     */   private int _enchant_lv14;
/*     */   
/*     */   public L1FireCrystal(int itemid, int enchant_lv0, int enchant_lv1, int enchant_lv2, int enchant_lv3, int enchant_lv4, int enchant_lv5, int enchant_lv6, int enchant_lv7, int enchant_lv8, int enchant_lv9, int enchant_lv10, int enchant_lv11, int enchant_lv12, int enchant_lv13, int enchant_lv14) {
/*  27 */     this._itemid = itemid;
/*  28 */     this._enchant_lv0 = enchant_lv0;
/*  29 */     this._enchant_lv1 = enchant_lv1;
/*  30 */     this._enchant_lv2 = enchant_lv2;
/*  31 */     this._enchant_lv3 = enchant_lv3;
/*  32 */     this._enchant_lv4 = enchant_lv4;
/*  33 */     this._enchant_lv5 = enchant_lv5;
/*  34 */     this._enchant_lv6 = enchant_lv6;
/*  35 */     this._enchant_lv7 = enchant_lv7;
/*  36 */     this._enchant_lv8 = enchant_lv8;
/*  37 */     this._enchant_lv9 = enchant_lv9;
/*  38 */     this._enchant_lv10 = enchant_lv10;
/*  39 */     this._enchant_lv11 = enchant_lv11;
/*  40 */     this._enchant_lv12 = enchant_lv12;
/*  41 */     this._enchant_lv13 = enchant_lv13;
/*  42 */     this._enchant_lv14 = enchant_lv14;
/*     */   }
/*     */   
/*     */   public int get_itemid() {
/*  46 */     return this._itemid;
/*     */   }
/*     */   
/*     */   public int get_CrystalCount(L1ItemInstance item) {
/*  50 */     int enchantlv = item.getEnchantLevel();
/*  51 */     int crystalcount = 0;
/*  52 */     switch (enchantlv) {
/*     */       case 0:
/*  54 */         crystalcount = this._enchant_lv0;
/*     */         break;
/*     */       
/*     */       case 1:
/*  58 */         crystalcount = this._enchant_lv1;
/*     */         break;
/*     */       
/*     */       case 2:
/*  62 */         crystalcount = this._enchant_lv2;
/*     */         break;
/*     */       
/*     */       case 3:
/*  66 */         crystalcount = this._enchant_lv3;
/*     */         break;
/*     */       
/*     */       case 4:
/*  70 */         crystalcount = this._enchant_lv4;
/*     */         break;
/*     */       
/*     */       case 5:
/*  74 */         crystalcount = this._enchant_lv5;
/*     */         break;
/*     */       
/*     */       case 6:
/*  78 */         crystalcount = this._enchant_lv6;
/*     */         break;
/*     */       
/*     */       case 7:
/*  82 */         crystalcount = this._enchant_lv7;
/*     */         break;
/*     */       
/*     */       case 8:
/*  86 */         crystalcount = this._enchant_lv8;
/*     */         break;
/*     */       
/*     */       case 9:
/*  90 */         crystalcount = this._enchant_lv9;
/*     */         break;
/*     */       
/*     */       case 10:
/*  94 */         crystalcount = this._enchant_lv10;
/*     */         break;
/*     */       
/*     */       case 11:
/*  98 */         crystalcount = this._enchant_lv11;
/*     */         break;
/*     */       
/*     */       case 12:
/* 102 */         crystalcount = this._enchant_lv12;
/*     */         break;
/*     */       
/*     */       case 13:
/* 106 */         crystalcount = this._enchant_lv13;
/*     */         break;
/*     */       
/*     */       case 14:
/* 110 */         crystalcount = this._enchant_lv14;
/*     */         break;
/*     */     } 
/*     */     
/* 114 */     if (enchantlv > 14) {
/* 115 */       crystalcount = this._enchant_lv14;
/*     */     }
/* 117 */     int safeenchant = item.getItem().get_safeenchant();
/* 118 */     if (item.getItem().getType2() == 2 && safeenchant >= 4) {
/* 119 */       if (enchantlv > 12) {
/* 120 */         crystalcount = this._enchant_lv12;
/*     */       }
/* 122 */     } else if (item.getItem().getType2() == 2 && safeenchant == 0) {
/* 123 */       if (enchantlv > 3) {
/* 124 */         crystalcount = this._enchant_lv3;
/*     */       }
/* 126 */     } else if (item.getItem().getType2() == 2 && safeenchant == -1) {
/* 127 */       crystalcount = this._enchant_lv0;
/*     */     } 
/* 129 */     return crystalcount;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\system\L1FireCrystal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */