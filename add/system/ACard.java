/*     */ package com.add.system;
/*     */ 
/*     */ public class ACard {
/*     */   private int _id;
/*     */   private String _msg1;
/*     */   private String _msg2;
/*     */   private String _cmd;
/*     */   private int _questid;
/*     */   private int _polyid;
/*     */   private int _polytime;
/*     */   private int _polyitemid;
/*     */   private int _polyitemcount;
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
/*  39 */     return this._id;
/*     */   }
/*     */   
/*     */   public String getMsg1() {
/*  43 */     return this._msg1;
/*     */   }
/*     */   
/*     */   public String getMsg2() {
/*  47 */     return this._msg2;
/*     */   }
/*     */   
/*     */   public String getCmd() {
/*  51 */     return this._cmd;
/*     */   }
/*     */   
/*     */   public int getQuestId() {
/*  55 */     return this._questid;
/*     */   }
/*     */   
/*     */   public int getPolyId() {
/*  59 */     return this._polyid;
/*     */   }
/*     */   
/*     */   public int getPolyTime() {
/*  63 */     return this._polytime;
/*     */   }
/*     */   
/*     */   public int getPolyItemId() {
/*  67 */     return this._polyitemid;
/*     */   }
/*     */   
/*     */   public int getPolyItemCount() {
/*  71 */     return this._polyitemcount;
/*     */   }
/*     */   
/*     */   public int getAddStr() {
/*  75 */     return this._addstr;
/*     */   }
/*     */   
/*     */   public int getAddDex() {
/*  79 */     return this._adddex;
/*     */   }
/*     */   
/*     */   public int getAddCon() {
/*  83 */     return this._addcon;
/*     */   }
/*     */   
/*     */   public int getAddInt() {
/*  87 */     return this._addint;
/*     */   }
/*     */   
/*     */   public int getAddWis() {
/*  91 */     return this._addwis;
/*     */   }
/*     */   
/*     */   public int getAddCha() {
/*  95 */     return this._addcha;
/*     */   }
/*     */   
/*     */   public int getAddAc() {
/*  99 */     return this._ac;
/*     */   }
/*     */   
/*     */   public int getAddHp() {
/* 103 */     return this._addhp;
/*     */   }
/*     */   
/*     */   public int getAddMp() {
/* 107 */     return this._addmp;
/*     */   }
/*     */   
/*     */   public int getAddHpr() {
/* 111 */     return this._addhpr;
/*     */   }
/*     */   
/*     */   public int getAddMpr() {
/* 115 */     return this._addmpr;
/*     */   }
/*     */   
/*     */   public int getAddDmg() {
/* 119 */     return this._adddmg;
/*     */   }
/*     */   
/*     */   public int getAddBowDmg() {
/* 123 */     return this._addbowdmg;
/*     */   }
/*     */   
/*     */   public int getAddHit() {
/* 127 */     return this._addhit;
/*     */   }
/*     */   
/*     */   public int getAddBowHit() {
/* 131 */     return this._addbowhit;
/*     */   }
/*     */   
/*     */   public int getAddDmgR() {
/* 135 */     return this._adddmgr;
/*     */   }
/*     */   
/*     */   public int getAddMagicDmgR() {
/* 139 */     return this._addmdmgr;
/*     */   }
/*     */   
/*     */   public int getAddSp() {
/* 143 */     return this._addsp;
/*     */   }
/*     */   
/*     */   public int getAddMagicHit() {
/* 147 */     return this._addmhit;
/*     */   }
/*     */   
/*     */   public int getAddMr() {
/* 151 */     return this._addmr;
/*     */   }
/*     */   
/*     */   public int getAddFire() {
/* 155 */     return this._addfire;
/*     */   }
/*     */   
/*     */   public int getAddWater() {
/* 159 */     return this._addwater;
/*     */   }
/*     */   
/*     */   public int getAddWind() {
/* 163 */     return this._addwind;
/*     */   }
/*     */   
/*     */   public int getAddEarth() {
/* 167 */     return this._addearth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ACard(int Id, String msg1, String msg2, String Cmd, int QuestId, int PolyId, int PolyTime, int PolyItemId, int PolyItemCount, int AddStr, int AddDex, int AddCon, int AddInt, int AddWis, int AddCha, int Ac, int AddHp, int AddMp, int AddHpr, int AddMpr, int Dmg, int BowDmg, int Hit, int BowHit, int DmgR, int MagicDmgR, int Sp, int MagicHit, int Mr, int Fire, int Water, int Wind, int Earth) {
/* 176 */     this._id = Id;
/* 177 */     this._msg1 = msg1;
/* 178 */     this._msg2 = msg2;
/* 179 */     this._cmd = Cmd;
/* 180 */     this._questid = QuestId;
/* 181 */     this._polyid = PolyId;
/* 182 */     this._polytime = PolyTime;
/* 183 */     this._polyitemid = PolyItemId;
/* 184 */     this._polyitemcount = PolyItemCount;
/* 185 */     this._addstr = AddStr;
/* 186 */     this._adddex = AddDex;
/* 187 */     this._addcon = AddCon;
/* 188 */     this._addint = AddInt;
/* 189 */     this._addwis = AddWis;
/* 190 */     this._addcha = AddCha;
/* 191 */     this._ac = Ac;
/* 192 */     this._addhp = AddHp;
/* 193 */     this._addmp = AddMp;
/* 194 */     this._addhpr = AddHpr;
/* 195 */     this._addmpr = AddMpr;
/* 196 */     this._adddmg = Dmg;
/* 197 */     this._addbowdmg = BowDmg;
/* 198 */     this._addhit = Hit;
/* 199 */     this._addbowhit = BowHit;
/* 200 */     this._adddmgr = DmgR;
/* 201 */     this._addmdmgr = MagicDmgR;
/* 202 */     this._addsp = Sp;
/* 203 */     this._addmhit = MagicHit;
/* 204 */     this._addmr = Mr;
/* 205 */     this._addfire = Fire;
/* 206 */     this._addwater = Water;
/* 207 */     this._addwind = Wind;
/* 208 */     this._addearth = Earth;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\system\ACard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */