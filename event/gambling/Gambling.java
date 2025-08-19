/*     */ package com.lineage.data.event.gambling;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Gambling
/*     */   extends GamblingConfig
/*     */ {
/*  17 */   private final Map<Integer, GamblingNpc> _npcidMap = new HashMap<>();
/*  18 */   private final Random _random = new Random(); public int WIN;
/*     */   private GamblingNpc _onenpc;
/*     */   
/*     */   public void clear() {
/*  22 */     this._npcidMap.clear();
/*  23 */     this._onenpc = null;
/*  24 */     this._adena = 0L;
/*     */   }
/*     */   private long _adena; private long _upadena;
/*     */   public long get_allAdena() {
/*  28 */     return this._adena;
/*     */   }
/*     */   
/*     */   public void set_gmaNpc(long previous) {
/*  32 */     if (GamblingConfig.ISGFX) {
/*  33 */       GamblingConfig.ISGFX = false;
/*     */     } else {
/*  35 */       GamblingConfig.ISGFX = true;
/*     */     } 
/*  37 */     this.WIN = this._random.nextInt(5);
/*  38 */     int i = 0;
/*  39 */     while (this._npcidMap.size() < 5) {
/*  40 */       int npcid = GamblingConfig.NPCID[this._random.nextInt(GamblingConfig.NPCID.length)];
/*  41 */       if (this._npcidMap.get(new Integer(npcid)) == null) {
/*  42 */         GamblingNpc gamnpc = new GamblingNpc(this);
/*  43 */         gamnpc.showNpc(npcid, i++);
/*  44 */         this._npcidMap.put(new Integer(npcid), gamnpc);
/*     */       } 
/*     */     } 
/*  47 */     this._upadena = previous;
/*     */   }
/*     */   
/*     */   public long get_allRate() {
/*  51 */     long adena = 0L;
/*  52 */     Iterator<GamblingNpc> iterator = this._npcidMap.values().iterator();
/*  53 */     while (iterator.hasNext()) {
/*  54 */       GamblingNpc gamblingNpc = iterator.next();
/*  55 */       adena += gamblingNpc.get_adena();
/*     */     } 
/*  57 */     return adena + this._upadena;
/*     */   }
/*     */   
/*     */   public void set_allRate() {
/*  61 */     long adena = this._upadena;
/*  62 */     Iterator<GamblingNpc> iterator = this._npcidMap.values().iterator();
/*  63 */     while (iterator.hasNext()) {
/*  64 */       GamblingNpc gamblingNpc = iterator.next();
/*  65 */       adena += gamblingNpc.get_adena();
/*     */     } 
/*  67 */     this._adena = adena;
/*  68 */     Iterator<GamblingNpc> iterator2 = this._npcidMap.values().iterator();
/*  69 */     while (iterator2.hasNext()) {
/*  70 */       GamblingNpc gamblingNpc = iterator2.next();
/*  71 */       set_npcRate(gamblingNpc, adena);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void set_npcRate(GamblingNpc npc, long adena) {
/*  76 */     double rate = (10 + this._random.nextInt(20));
/*  77 */     npc.set_rate(rate / 10.0D);
/*     */   }
/*     */   
/*     */   public Map<Integer, GamblingNpc> get_allNpc() {
/*  81 */     return this._npcidMap;
/*     */   }
/*     */   
/*     */   public GamblingNpc get_oneNpc() {
/*  85 */     return this._onenpc;
/*     */   }
/*     */   
/*     */   public void set_oneNpc(GamblingNpc onenpc) {
/*  89 */     this._onenpc = onenpc;
/*     */   }
/*     */   
/*     */   public void startGam() {
/*  93 */     Iterator<GamblingNpc> iterator = this._npcidMap.values().iterator();
/*  94 */     while (iterator.hasNext()) {
/*  95 */       GamblingNpc gamblingNpc = iterator.next();
/*  96 */       gamblingNpc.getStart();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delAllNpc() {
/* 101 */     Iterator<GamblingNpc> iterator = this._npcidMap.values().iterator();
/* 102 */     while (iterator.hasNext()) {
/* 103 */       GamblingNpc gamblingNpc = iterator.next();
/* 104 */       gamblingNpc.delNpc();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\gambling\Gambling.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */