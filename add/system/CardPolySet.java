/*     */ package com.add.system;
/*     */ 
/*     */ public class CardPolySet {
/*     */   private int _id;
/*     */   private String _msg1;
/*     */   private int[] _needids;
/*     */   private int[] _needquest;
/*     */   private String[] _needname;
/*     */   private int _questid;
/*     */   private int _addstr;
/*     */   private int _adddex;
/*     */   private int _addcon;
/*     */   private int _addint;
/*     */   private int _addwis;
/*     */   private int _addcha;
/*     */   private int _ac;
/*     */   private int _addhp;
/*     */   private int _addmp;
/*     */   private int _addhpr;
/*     */   private int _addmpr;
/*     */   private int _adddmg;
/*     */   private int _addbowdmg;
/*     */   private int _addhit;
/*     */   private int _addbowhit;
/*     */   private int _adddmgr;
/*     */   private int _addmdmgr;
/*     */   private int _addsp;
/*     */   private int _addmhit;
/*     */   private int _addmr;
/*     */   private int _addfire;
/*     */   private int _addwater;
/*     */   private int _addwind;
/*     */   private int _addearth;
/*     */   
/*     */   public int getId() {
/*  36 */     return this._id;
/*     */   }
/*     */   
/*     */   public String getMsg1() {
/*  40 */     return this._msg1;
/*     */   }
/*     */   
/*     */   public final int[] getNeedids() {
/*  44 */     return this._needids;
/*     */   }
/*     */   
/*     */   public final int[] getNeedQuest() {
/*  48 */     return this._needquest;
/*     */   }
/*     */   
/*     */   public final String[] getNeedName() {
/*  52 */     return this._needname;
/*     */   }
/*     */   
/*     */   public int getQuestId() {
/*  56 */     return this._questid;
/*     */   }
/*     */   
/*     */   public int getAddStr() {
/*  60 */     return this._addstr;
/*     */   }
/*     */   
/*     */   public int getAddDex() {
/*  64 */     return this._adddex;
/*     */   }
/*     */   
/*     */   public int getAddCon() {
/*  68 */     return this._addcon;
/*     */   }
/*     */   
/*     */   public int getAddInt() {
/*  72 */     return this._addint;
/*     */   }
/*     */   
/*     */   public int getAddWis() {
/*  76 */     return this._addwis;
/*     */   }
/*     */   
/*     */   public int getAddCha() {
/*  80 */     return this._addcha;
/*     */   }
/*     */   
/*     */   public int getAddAc() {
/*  84 */     return this._ac;
/*     */   }
/*     */   
/*     */   public int getAddHp() {
/*  88 */     return this._addhp;
/*     */   }
/*     */   
/*     */   public int getAddMp() {
/*  92 */     return this._addmp;
/*     */   }
/*     */   
/*     */   public int getAddHpr() {
/*  96 */     return this._addhpr;
/*     */   }
/*     */   
/*     */   public int getAddMpr() {
/* 100 */     return this._addmpr;
/*     */   }
/*     */   
/*     */   public int getAddDmg() {
/* 104 */     return this._adddmg;
/*     */   }
/*     */   
/*     */   public int getAddBowDmg() {
/* 108 */     return this._addbowdmg;
/*     */   }
/*     */   
/*     */   public int getAddHit() {
/* 112 */     return this._addhit;
/*     */   }
/*     */   
/*     */   public int getAddBowHit() {
/* 116 */     return this._addbowhit;
/*     */   }
/*     */   
/*     */   public int getAddDmgR() {
/* 120 */     return this._adddmgr;
/*     */   }
/*     */   
/*     */   public int getAddMagicDmgR() {
/* 124 */     return this._addmdmgr;
/*     */   }
/*     */   
/*     */   public int getAddSp() {
/* 128 */     return this._addsp;
/*     */   }
/*     */   
/*     */   public int getAddMagicHit() {
/* 132 */     return this._addmhit;
/*     */   }
/*     */   
/*     */   public int getAddMr() {
/* 136 */     return this._addmr;
/*     */   }
/*     */   
/*     */   public int getAddFire() {
/* 140 */     return this._addfire;
/*     */   }
/*     */   
/*     */   public int getAddWater() {
/* 144 */     return this._addwater;
/*     */   }
/*     */   
/*     */   public int getAddWind() {
/* 148 */     return this._addwind;
/*     */   }
/*     */   
/*     */   public int getAddEarth() {
/* 152 */     return this._addearth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CardPolySet(int Id, String msg1, int[] needids, int[] needquest, String[] needname, int QuestId, int AddStr, int AddDex, int AddCon, int AddInt, int AddWis, int AddCha, int Ac, int AddHp, int AddMp, int AddHpr, int AddMpr, int Dmg, int BowDmg, int Hit, int BowHit, int DmgR, int MagicDmgR, int Sp, int MagicHit, int Mr, int Fire, int Water, int Wind, int Earth) {
/* 161 */     this._id = Id;
/* 162 */     this._msg1 = msg1;
/* 163 */     this._needids = needids;
/* 164 */     this._needquest = needquest;
/* 165 */     this._needname = needname;
/* 166 */     this._questid = QuestId;
/* 167 */     this._addstr = AddStr;
/* 168 */     this._adddex = AddDex;
/* 169 */     this._addcon = AddCon;
/* 170 */     this._addint = AddInt;
/* 171 */     this._addwis = AddWis;
/* 172 */     this._addcha = AddCha;
/* 173 */     this._ac = Ac;
/* 174 */     this._addhp = AddHp;
/* 175 */     this._addmp = AddMp;
/* 176 */     this._addhpr = AddHpr;
/* 177 */     this._addmpr = AddMpr;
/* 178 */     this._adddmg = Dmg;
/* 179 */     this._addbowdmg = BowDmg;
/* 180 */     this._addhit = Hit;
/* 181 */     this._addbowhit = BowHit;
/* 182 */     this._adddmgr = DmgR;
/* 183 */     this._addmdmgr = MagicDmgR;
/* 184 */     this._addsp = Sp;
/* 185 */     this._addmhit = MagicHit;
/* 186 */     this._addmr = Mr;
/* 187 */     this._addfire = Fire;
/* 188 */     this._addwater = Water;
/* 189 */     this._addwind = Wind;
/* 190 */     this._addearth = Earth;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\system\CardPolySet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */