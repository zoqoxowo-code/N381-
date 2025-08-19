/*     */ package com.add.Crack;
/*     */ 
/*     */ import com.add.L1Config_other;
/*     */ import com.lineage.server.IdFactory;
/*     */ import com.lineage.server.datatables.NpcTable;
/*     */ import com.lineage.server.model.Instance.L1MonsterInstance;
/*     */ import com.lineage.server.model.Instance.L1NpcInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.model.L1Location;
/*     */ import com.lineage.server.model.L1Object;
/*     */ import com.lineage.server.model.L1Teleport;
/*     */ import com.lineage.server.serverpackets.S_CharVisualUpdate;
/*     */ import com.lineage.server.serverpackets.S_MapID;
/*     */ import com.lineage.server.serverpackets.S_OtherCharPacks;
/*     */ import com.lineage.server.serverpackets.S_OwnCharPack;
/*     */ import com.lineage.server.serverpackets.S_RemoveObject;
/*     */ import com.lineage.server.serverpackets.S_Weather;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.templates.L1Npc;
/*     */ import com.lineage.server.thread.GeneralThreadPool;
/*     */ import com.lineage.server.utils.Random;
/*     */ import com.lineage.server.world.World;
/*     */ import com.lineage.server.world.WorldNpc;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.Iterator;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class L1CrackTime
/*     */   extends TimerTask
/*     */ {
/*  44 */   private static Logger _log = Logger.getLogger(L1CrackTime.class.getName()); private Timer _timeHandler; private boolean _isOver;
/*  45 */   private static final int[][] _crack = new int[][] { { 32639, 32876, 780 }, { 32794, 32751, 783 } }; private int _Crack; private int _startTime;
/*  46 */   private static final int[][] _crackLoc = new int[][] { { 32728, 32709, 4 }, { 32848, 32639, 4 }, { 32852, 32705, 4 }, { 32913, 33168, 4
/*  47 */       }, { 32957, 33247, 4 }, { 32913, 33425, 4 }, { 34255, 33203, 4 }, { 34232, 33312, 4
/*  48 */       }, { 34276, 33359, 4 } }; private static L1CrackTime _instance;
/*     */   private boolean _GateOpen;
/*     */   public static boolean _BossKill = false;
/*     */   
/*     */   public static L1CrackTime getStart() {
/*  53 */     if (_instance == null) {
/*  54 */       _instance = new L1CrackTime();
/*     */     }
/*  56 */     return _instance;
/*     */   }
/*     */   
/*     */   private L1CrackTime() {
/*  60 */     this._timeHandler = new Timer(true);
/*  61 */     this._isOver = false;
/*  62 */     this._Crack = 0;
/*  63 */     this._startTime = 0;
/*  64 */     this._GateOpen = false;
/*  65 */     this._timeHandler.schedule(this, 1000L, 1000L);
/*  66 */     GeneralThreadPool.get().execute(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  71 */     if (this._isOver) {
/*     */       try {
/*  73 */         clear();
/*  74 */         Thread.sleep((L1Config_other._2216 * 3600 * 1000));
/*  75 */       } catch (InterruptedException e) {
/*  76 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*  79 */     switch (++this._startTime) {
/*     */       case 60:
/*  81 */         spawnCrack();
/*     */         break;
/*     */     } 
/*     */     
/*  85 */     if (this._startTime >= 120 && !getBossKill()) {
/*  86 */       setGateOpen(true);
/*     */     }
/*  88 */     if (this._startTime == (L1Config_other._2217 - 1) * 60 && !getBossKill()) {
/*  89 */       World.get().broadcastServerMessage("時空裂痕即將關閉...");
/*     */     }
/*  91 */     if (this._startTime >= L1Config_other._2217 * 60 && !getBossKill()) {
/*  92 */       if ((L1Tikal.getGameEnd() == 0 && this._Crack == 2) || (L1Thebes.getGameEnd() == 0 && this._Crack == 1)) {
/*  93 */         this._isOver = true;
/*  94 */       } else if ((L1Tikal.getGameEnd() == 1 && this._Crack == 2) || (
/*  95 */         L1Thebes.getGameEnd() == 1 && this._Crack == 1)) {
/*  96 */         Iterator<L1PcInstance> iterator = World.get().getAllPlayers().iterator();
/*  97 */         while (iterator.hasNext()) {
/*  98 */           L1PcInstance pc = iterator.next();
/*  99 */           if (pc.getMapId() >= 780 && pc.getMapId() <= 784 && pc.isDead()) {
/* 100 */             restartPlayer(pc, 32616, 32782, (short)4);
/*     */           }
/*     */         } 
/* 103 */         setBossKill(true);
/* 104 */       } else if ((L1Tikal.getGameEnd() == 2 && this._Crack == 2) || (
/* 105 */         L1Thebes.getGameEnd() == 2 && this._Crack == 1)) {
/* 106 */         this._isOver = true;
/*     */       } 
/*     */     }
/* 109 */     if (this._startTime >= (L1Config_other._2217 + L1Config_other._2218) * 60) {
/* 110 */       this._isOver = true;
/*     */     }
/*     */   }
/*     */   
/*     */   private void clear() {
/* 115 */     this._startTime = 0;
/* 116 */     this._isOver = false;
/* 117 */     this._Crack = 0;
/* 118 */     setGateOpen(false);
/* 119 */     setBossKill(false);
/* 120 */     L1Tikal.setGameStatus(0);
/* 121 */     L1Thebes.setGameStatus(0);
/* 122 */     World.get().broadcastServerMessage("時空裂痕關閉了。");
/* 123 */     Iterator<L1NpcInstance> iterator = WorldNpc.get().all().iterator();
/* 124 */     while (iterator.hasNext()) {
/* 125 */       L1Object obj = (L1Object)iterator.next();
/* 126 */       if (obj instanceof L1NpcInstance) {
/* 127 */         L1NpcInstance Cracknpc = (L1NpcInstance)obj;
/* 128 */         if (Cracknpc.getNpcId() != 71254) {
/*     */           continue;
/*     */         }
/* 131 */         Cracknpc.deleteMe();
/*     */       } 
/*     */     } 
/* 134 */     Iterator<L1NpcInstance> iterator2 = WorldNpc.get().all().iterator();
/* 135 */     while (iterator2.hasNext()) {
/* 136 */       L1Object obj = (L1Object)iterator2.next();
/* 137 */       if (obj instanceof L1MonsterInstance) {
/* 138 */         L1MonsterInstance mob = (L1MonsterInstance)obj;
/* 139 */         if ((mob.getNpcId() < 46107 || mob.getNpcId() > 46122) && (
/* 140 */           mob.getNpcId() < 46123 || mob.getNpcId() > 46124) && (
/* 141 */           mob.getNpcId() < 92002 || mob.getNpcId() > 92017) && (
/* 142 */           mob.getNpcId() < 92000 || mob.getNpcId() > 92001)) {
/*     */           continue;
/*     */         }
/* 145 */         mob.deleteMe();
/*     */       } 
/*     */     } 
/* 148 */     Iterator<L1PcInstance> iterator3 = World.get().getAllPlayers().iterator();
/* 149 */     while (iterator3.hasNext()) {
/* 150 */       L1PcInstance pc = iterator3.next();
/* 151 */       if (pc.getMapId() >= 780 && pc.getMapId() <= 784) {
/* 152 */         if (pc.isDead()) {
/* 153 */           restartPlayer(pc, 32616, 32782, (short)4); continue;
/*     */         } 
/* 155 */         L1Teleport.teleport(pc, 33442, 32797, (short)4, 5, true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void spawnCrack() {
/* 162 */     L1Location crack = null;
/* 163 */     L1Location crack_loc = null;
/* 164 */     int rnd1 = Random.nextInt(2);
/* 165 */     int rnd2 = Random.nextInt(9);
/* 166 */     crack = new L1Location(_crack[rnd1][0], _crack[rnd1][1], _crack[rnd1][2]);
/* 167 */     crack_loc = new L1Location(_crackLoc[rnd2][0], _crackLoc[rnd2][1], 
/* 168 */         _crackLoc[rnd2][2]);
/* 169 */     if (rnd1 == 1) {
/* 170 */       this._Crack = 1;
/*     */     } else {
/* 172 */       this._Crack = 2;
/*     */     } 
/* 174 */     if (getBossKill()) {
/* 175 */       World.get().broadcastServerMessage("時空裂痕開啟了，裂痕的力量減弱，因此關閉時間呈現被延後的狀態...");
/*     */     } else {
/* 177 */       World.get().broadcastServerMessage("時空裂痕開啟了！！異界侵略即將開始...");
/*     */     } 
/* 179 */     createCrack(crack.getX(), crack.getY(), (short)crack.getMapId(), crack_loc.getX(), crack_loc.getY(), 
/* 180 */         (short)crack_loc.getMapId());
/* 181 */     createCrack(crack_loc.getX(), crack_loc.getY(), (short)crack_loc.getMapId(), crack.getX(), crack.getY(), 
/* 182 */         (short)crack.getMapId());
/*     */   }
/*     */ 
/*     */   
/*     */   private void createCrack(int x, int y, short mapId, int to_x, int to_y, short to_mapId) {
/*     */     try {
/* 188 */       L1Npc l1npc = NpcTable.get().getTemplate(71254);
/* 189 */       if (l1npc == null) {
/*     */         return;
/*     */       }
/* 192 */       String s = l1npc.getImpl();
/* 193 */       Constructor<?> constructor = Class.forName("com.lineage.server.model.Instance." + s + "Instance")
/* 194 */         .getConstructors()[0];
/* 195 */       Object[] aobj = { l1npc };
/* 196 */       L1NpcInstance npc = (L1NpcInstance)constructor.newInstance(aobj);
/* 197 */       npc.setId(IdFactory.get().nextId());
/* 198 */       npc.setX(x);
/* 199 */       npc.setY(y);
/* 200 */       npc.setMap(mapId);
/* 201 */       npc.setHomeX(npc.getX());
/* 202 */       npc.setHomeY(npc.getY());
/* 203 */       npc.setHeading(0);
/* 204 */       World.get().storeObject((L1Object)npc);
/* 205 */       World.get().addVisibleObject((L1Object)npc);
/* 206 */       Teleport teleport = new Teleport(npc, to_x, to_y, to_mapId);
/* 207 */       GeneralThreadPool.get().execute(teleport);
/* 208 */     } catch (Exception e) {
/* 209 */       _log.log(Level.SEVERE, e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void restartPlayer(L1PcInstance pc, int locx, int locy, short mapid) {
/* 214 */     pc.removeAllKnownObjects();
/* 215 */     pc.broadcastPacketAll((ServerBasePacket)new S_RemoveObject((L1Object)pc));
/* 216 */     pc.setCurrentHp(pc.getLevel());
/* 217 */     pc.set_food(40);
/* 218 */     pc.setDead(false);
/* 219 */     pc.setStatus(0);
/* 220 */     World.get().moveVisibleObject((L1Object)pc, mapid);
/* 221 */     pc.setX(locx);
/* 222 */     pc.setY(locy);
/* 223 */     pc.setMap(mapid);
/* 224 */     pc.sendPackets((ServerBasePacket)new S_MapID(pc, pc.getMapId(), pc.getMap().isUnderwater()));
/* 225 */     pc.broadcastPacketAll((ServerBasePacket)new S_OtherCharPacks(pc));
/* 226 */     pc.sendPackets((ServerBasePacket)new S_OwnCharPack(pc));
/* 227 */     pc.sendPackets((ServerBasePacket)new S_CharVisualUpdate(pc));
/* 228 */     pc.startHpRegeneration();
/* 229 */     pc.startMpRegeneration();
/* 230 */     pc.sendPackets((ServerBasePacket)new S_Weather(World.get().getWeather()));
/* 231 */     pc.stopPcDeleteTimer();
/* 232 */     if (pc.getHellTime() > 0) {
/* 233 */       pc.beginHell(false);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setGateOpen(boolean GateOpen) {
/* 238 */     this._GateOpen = GateOpen;
/*     */   }
/*     */   
/*     */   public boolean getGateOpen() {
/* 242 */     return this._GateOpen;
/*     */   }
/*     */   
/*     */   public static void setBossKill(boolean BossKill) {
/* 246 */     _BossKill = BossKill;
/*     */   }
/*     */   
/*     */   private static boolean getBossKill() {
/* 250 */     return _BossKill;
/*     */   }
/*     */   
/*     */   class Teleport implements Runnable {
/*     */     private L1NpcInstance _npc;
/*     */     private int _to_x;
/*     */     private int _to_y;
/*     */     private short _to_mapId;
/*     */     
/*     */     public Teleport(L1NpcInstance npc, int to_x, int to_y, short to_mapId) {
/* 260 */       this._npc = null;
/* 261 */       this._to_x = 0;
/* 262 */       this._to_y = 0;
/* 263 */       this._to_mapId = 0;
/* 264 */       this._npc = npc;
/* 265 */       this._to_x = to_x;
/* 266 */       this._to_y = to_y;
/* 267 */       this._to_mapId = to_mapId;
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/*     */       try {
/* 273 */         Thread.sleep(1000L);
/* 274 */         while (!this._npc._destroyed) {
/* 275 */           Iterator<L1Object> iterator = World.get()
/* 276 */             .getVisiblePoint(this._npc.getLocation(), 1, this._npc.get_showId()).iterator();
/* 277 */           while (iterator.hasNext()) {
/* 278 */             L1Object obj = iterator.next();
/* 279 */             if (obj instanceof L1PcInstance) {
/* 280 */               L1PcInstance target = (L1PcInstance)obj;
/* 281 */               L1Location tmp_loc = new L1Location(this._to_x, this._to_y, this._to_mapId);
/* 282 */               L1Location rnd_loc = tmp_loc.randomLocation(1, 5, false);
/* 283 */               L1Teleport.teleport(target, rnd_loc.getX(), rnd_loc.getY(), (short)rnd_loc.getMapId(), 
/* 284 */                   target.getHeading(), true);
/*     */             } 
/*     */           } 
/* 287 */           Thread.sleep(1000L);
/*     */         } 
/*     */         return;
/* 290 */       } catch (Exception e) {
/* 291 */         L1CrackTime._log.log(Level.SEVERE, e.getLocalizedMessage(), e);
/*     */         return;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\Crack\L1CrackTime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */