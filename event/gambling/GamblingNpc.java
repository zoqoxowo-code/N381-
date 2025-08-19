/*     */ package com.lineage.data.event.gambling;
/*     */ 
/*     */ import com.lineage.server.datatables.NpcTable;
/*     */ import com.lineage.server.model.Instance.L1NpcInstance;
/*     */ import com.lineage.server.model.L1Character;
/*     */ import com.lineage.server.serverpackets.S_MoveCharPacket;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.templates.L1Npc;
/*     */ import com.lineage.server.thread.GeneralThreadPool;
/*     */ import com.lineage.server.types.Point;
/*     */ import com.lineage.server.utils.L1SpawnUtil;
/*     */ import java.util.Random;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GamblingNpc
/*     */   implements Runnable
/*     */ {
/*  34 */   private static final Log _log = LogFactory.getLog(GamblingNpc.class); private Gambling _gambling; private L1NpcInstance _npc; private boolean _isOver; private Point[] _tgLoc; private int _xId;
/*  35 */   private static final byte[] HEADING_TABLE_X = new byte[] { 0, 1, 1, 1, -1, -1, -1 }; private int _sId; private long _adena; private double _rate; private Point _loc; private Random _random; private int _randomTime;
/*  36 */   private static final byte[] HEADING_TABLE_Y = new byte[] { -1, -1, 1, 1, 1, -1 };
/*  37 */   private static final int[][] xx = new int[5][1];
/*     */ 
/*     */   
/*     */   public GamblingNpc(Gambling gambling) {
/*  41 */     this._isOver = false;
/*  42 */     this._sId = 1;
/*  43 */     this._random = new Random();
/*  44 */     this._gambling = gambling;
/*     */   }
/*     */   
/*     */   public Gambling get_gambling() {
/*  48 */     return this._gambling;
/*     */   }
/*     */   
/*     */   public void set_rate(double rate) {
/*  52 */     this._rate = rate;
/*     */   }
/*     */   
/*     */   public double get_rate() {
/*  56 */     return this._rate;
/*     */   }
/*     */   
/*     */   public void add_adena(long adena) {
/*  60 */     this._adena += adena;
/*     */   }
/*     */   
/*     */   public long get_adena() {
/*  64 */     return this._adena;
/*     */   }
/*     */   
/*     */   public void delNpc() {
/*  68 */     this._npc.deleteMe();
/*     */   }
/*     */   
/*     */   public L1NpcInstance get_npc() {
/*  72 */     return this._npc;
/*     */   }
/*     */   
/*     */   public int get_xId() {
/*  76 */     return this._xId;
/*     */   }
/*     */   
/*     */   public void showNpc(int npcid, int i) {
/*  80 */     this._xId = i;
/*  81 */     L1Npc npc = NpcTable.get().getTemplate(npcid);
/*  82 */     if (npc != null) {
/*  83 */       int[] gfxids; this._tgLoc = GamblingConfig.TGLOC[i];
/*  84 */       int x = this._tgLoc[0].getX();
/*  85 */       int y = this._tgLoc[0].getY();
/*  86 */       short mapid = 4;
/*  87 */       int heading = 6;
/*     */       
/*  89 */       if (GamblingConfig.ISGFX) {
/*  90 */         gfxids = GamblingConfig.GFX[i];
/*     */       } else {
/*  92 */         gfxids = GamblingConfig.GFXD[i];
/*     */       } 
/*  94 */       int gfxid = gfxids[this._random.nextInt(gfxids.length)];
/*  95 */       this._npc = L1SpawnUtil.spawn(npcid, x, y, (short)4, 6, gfxid);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void getStart() {
/* 100 */     GeneralThreadPool.get().schedule(this, 10L);
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/* 106 */       this._loc = this._tgLoc[1];
/* 107 */       while (!this._isOver) {
/* 108 */         if (this._xId == this._gambling.WIN) {
/* 109 */           this._randomTime = 150;
/*     */         } else {
/* 111 */           this._randomTime = 190;
/*     */         } 
/* 113 */         int ss = 190;
/* 114 */         if (this._random.nextInt(100) < 25) {
/* 115 */           ss = 150;
/*     */         }
/* 117 */         int speed = ss + this._random.nextInt(this._randomTime);
/* 118 */         Thread.sleep(speed);
/* 119 */         actionStart();
/*     */       } 
/* 121 */     } catch (InterruptedException e) {
/* 122 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setDirectionMove(int heading) {
/* 127 */     if (heading >= 0) {
/* 128 */       int locx = this._npc.getX();
/* 129 */       int locy = this._npc.getY();
/* 130 */       locx += HEADING_TABLE_X[heading];
/* 131 */       locy += HEADING_TABLE_Y[heading];
/* 132 */       this._npc.setHeading(heading);
/* 133 */       this._npc.setX(locx);
/* 134 */       this._npc.setY(locy);
/* 135 */       this._npc.broadcastPacketAll((ServerBasePacket)new S_MoveCharPacket((L1Character)this._npc));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void actionStart() {
/* 140 */     int x = this._loc.getX();
/* 141 */     int y = this._loc.getY();
/*     */     try {
/* 143 */       int dir = this._npc.targetDirection(x, y);
/* 144 */       setDirectionMove(dir);
/* 145 */       if (this._npc.getLocation().getTileLineDistance(this._loc) < 2) {
/* 146 */         this._loc = this._tgLoc[this._sId];
/* 147 */         this._sId++;
/*     */       } 
/* 149 */     } catch (Exception e) {
/* 150 */       if (this._gambling.get_oneNpc() == null) {
/* 151 */         this._gambling.set_oneNpc(this);
/* 152 */         int[] array = xx[this._xId];
/* 153 */         int n = 0;
/* 154 */         array[0] = array[0] + 1;
/*     */       } 
/* 156 */       int dir2 = this._npc.targetDirection(x, y);
/* 157 */       setDirectionMove(dir2);
/* 158 */       this._isOver = true;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\gambling\GamblingNpc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */