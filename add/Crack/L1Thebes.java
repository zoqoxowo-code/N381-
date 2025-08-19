/*     */ package com.add.Crack;
/*     */ 
/*     */ import com.add.L1Config_other;
/*     */ import com.lineage.server.model.Instance.L1MonsterInstance;
/*     */ import com.lineage.server.model.Instance.L1NpcInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.model.L1Object;
/*     */ import com.lineage.server.model.L1Teleport;
/*     */ import com.lineage.server.serverpackets.S_NPCTalkReturn;
/*     */ import com.lineage.server.serverpackets.S_ServerMessage;
/*     */ import com.lineage.server.serverpackets.S_SystemMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.utils.L1SpawnUtil;
/*     */ import com.lineage.server.world.World;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
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
/*     */ 
/*     */ 
/*     */ public class L1Thebes
/*     */ {
/*  35 */   private static Logger _log = Logger.getLogger(L1Thebes.class.getName()); public static final int STATUS_NONE = 0; public static final int STATUS_READY = 1;
/*  36 */   private static ArrayList<L1PcInstance> playerList = new ArrayList<>(); public static final int STATUS_PLAYING = 2; public static final int STATUS_AGAIN = 3; public static final int STATUS_END = 4;
/*  37 */   public static int _status = 0; private static final int END_STATUS_WINNER = 1; private static final int END_STATUS_NOWINNER = 2;
/*  38 */   public static int _type = 0;
/*     */ 
/*     */   
/*     */   public static void enterGame(L1PcInstance pc, int npcid) {
/*  42 */     L1Object obj = World.get().findObject(npcid);
/*  43 */     L1NpcInstance npc = (L1NpcInstance)obj;
/*  44 */     if (!L1CrackTime.getStart().getGateOpen()) {
/*  45 */       pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(npc.getId(), "thebegate2"));
/*     */       return;
/*     */     } 
/*  48 */     if (!pc.getInventory().checkItem(49242, 1L)) {
/*  49 */       pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(npc.getId(), "thebegate3"));
/*     */       return;
/*     */     } 
/*  52 */     if (getGameStatus() == 2) {
/*  53 */       if (playerList.contains(pc)) {
/*  54 */         L1Teleport.teleport(pc, 32734, 32832, (short)782, 2, true);
/*     */       } else {
/*  56 */         pc.sendPackets((ServerBasePacket)new S_SystemMessage("副本已開始，無法進入。"));
/*     */       } 
/*     */       return;
/*     */     } 
/*  60 */     if (getGameStatus() == 3) {
/*  61 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("副本正在重置中。"));
/*     */       return;
/*     */     } 
/*  64 */     if (getGameStatus() == 4) {
/*  65 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("BOSS已死亡，無法進入。"));
/*     */       return;
/*     */     } 
/*  68 */     if (playerList.size() >= L1Config_other._2213) {
/*  69 */       pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(npc.getId(), "thebegate4"));
/*     */       return;
/*     */     } 
/*  72 */     if (getGameStatus() == 0) {
/*  73 */       L1Teleport.teleport(pc, 32734, 32832, (short)782, 2, true);
/*  74 */       pc.getInventory().consumeItem(49242, 1L);
/*  75 */       addPlayerList(pc);
/*     */     } 
/*  77 */     if (getGameStatus() == 1 && playerList.size() < L1Config_other._2213) {
/*  78 */       L1Teleport.teleport(pc, 32734, 32832, (short)782, 2, true);
/*  79 */       pc.getInventory().consumeItem(49242, 1L);
/*  80 */       addPlayerList(pc);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void addPlayerList(L1PcInstance pc) {
/*  85 */     if (!playerList.contains(pc)) {
/*  86 */       playerList.add(pc);
/*     */     }
/*  88 */     if (playerList.size() == L1Config_other._2211) {
/*  89 */       if (getGameStatus() == 0) {
/*  90 */         setGameStatus(1);
/*  91 */         Iterator<L1Object> iterator = World.get().getVisibleObjects(782).values().iterator();
/*  92 */         while (iterator.hasNext()) {
/*  93 */           Object obj = iterator.next();
/*  94 */           if (obj instanceof L1PcInstance) {
/*  95 */             L1PcInstance tgpc = (L1PcInstance)obj;
/*  96 */             tgpc.sendPackets((ServerBasePacket)new S_SystemMessage("時空裂痕副本將在5秒後開始。"));
/*     */           } 
/*     */         } 
/*  99 */         OverTime(5);
/*     */       } 
/* 101 */     } else if (playerList.size() < L1Config_other._2211) {
/* 102 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("需要有至少 " + L1Config_other._2211 + " 人以上參加者才可能開始副本。"));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void removePlayerList(L1PcInstance pc) {
/* 107 */     if (playerList.contains(pc)) {
/* 108 */       playerList.remove(pc);
/* 109 */       L1Teleport.teleport(pc, 33442, 32797, (short)4, 5, true);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void setGameStatus(int i) {
/* 114 */     _status = i;
/*     */   }
/*     */   
/*     */   private static int getGameStatus() {
/* 118 */     return _status;
/*     */   }
/*     */   
/*     */   private static void setGameEnd(int type) {
/* 122 */     switch (type) {
/*     */       case 1:
/* 124 */         sendEndMessage(type);
/*     */         break;
/*     */       
/*     */       case 2:
/* 128 */         sendEndMessage(type);
/*     */         break;
/*     */     } 
/*     */     
/* 132 */     _type = type;
/*     */   }
/*     */   
/*     */   public static int getGameEnd() {
/* 136 */     return _type;
/*     */   }
/*     */   
/*     */   private static void startAgain() {
/* 140 */     (new Again(null)).begin();
/*     */   }
/*     */   
/*     */   private static void startAgain2() {
/* 144 */     (new Again2(null)).begin();
/*     */   }
/*     */   
/*     */   private static void sendEndMessage(int type) {
/* 148 */     if (type == 1) {
/* 149 */       Iterator<L1PcInstance> iterator = playerList.iterator();
/* 150 */       while (iterator.hasNext()) {
/* 151 */         L1PcInstance pc = iterator.next();
/* 152 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(1474));
/*     */       } 
/* 154 */     } else if (type == 2) {
/* 155 */       Iterator<L1PcInstance> iterator2 = playerList.iterator();
/* 156 */       while (iterator2.hasNext()) {
/* 157 */         L1PcInstance pc = iterator2.next();
/* 158 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(1479));
/*     */       } 
/*     */     } 
/* 161 */     Overtime2(type);
/*     */   }
/*     */   
/*     */   private static void Overtime2(int type) {
/* 165 */     int time = 40;
/*     */     try {
/* 167 */       while (time >= 0) {
/* 168 */         Thread.sleep(1000L);
/* 169 */         Iterator<L1PcInstance> iterator = playerList.iterator();
/* 170 */         while (iterator.hasNext()) {
/* 171 */           L1PcInstance pc = iterator.next();
/* 172 */           if (time == 35 && type == 1) {
/* 173 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1475)); continue;
/* 174 */           }  if (time == 30) {
/* 175 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1476)); continue;
/* 176 */           }  if (time == 20) {
/* 177 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1477)); continue;
/* 178 */           }  if (time == 10) {
/* 179 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1478)); continue;
/* 180 */           }  if (time == 5) {
/* 181 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1480)); continue;
/* 182 */           }  if (time == 4) {
/* 183 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1481)); continue;
/* 184 */           }  if (time == 3) {
/* 185 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1482)); continue;
/* 186 */           }  if (time == 2) {
/* 187 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1483)); continue;
/* 188 */           }  if (time == 1) {
/* 189 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1484)); continue;
/*     */           } 
/* 191 */           if (time != 0 || type != 2) {
/*     */             continue;
/*     */           }
/* 194 */           setGameStatus(3);
/* 195 */           playerList.clear();
/* 196 */           startAgain();
/*     */         } 
/*     */         
/* 199 */         time--;
/*     */       } 
/* 201 */     } catch (Exception e) {
/* 202 */       _log.warning(e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void OverTime(int time) {
/*     */     try {
/* 208 */       while (time >= 0) {
/* 209 */         Thread.sleep(1000L);
/* 210 */         time--;
/* 211 */         Iterator<L1PcInstance> iterator = playerList.iterator();
/* 212 */         while (iterator.hasNext()) {
/* 213 */           L1PcInstance pc = iterator.next();
/* 214 */           if (time == 4) {
/* 215 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1471)); continue;
/* 216 */           }  if (time == 3) {
/* 217 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1472)); continue;
/*     */           } 
/* 219 */           if (time != 2) {
/*     */             continue;
/*     */           }
/* 222 */           pc.sendPackets((ServerBasePacket)new S_ServerMessage(1473));
/*     */         } 
/*     */         
/* 225 */         if (time == 1) {
/* 226 */           L1SpawnUtil.spawn(46124, 32781, 32826, (short)782, 0);
/* 227 */           L1SpawnUtil.spawn(46123, 32781, 32837, (short)782, 0);
/* 228 */           startSeekBossSecond();
/*     */         } 
/*     */       } 
/* 231 */     } catch (Exception e) {
/* 232 */       _log.warning(e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void startSeekBossSecond() {
/* 237 */     (new SeekBossSecond(null)).begin();
/*     */   }
/*     */   
/*     */   private static int MobCount(short mapId) {
/* 241 */     int MobCount = 0;
/* 242 */     Iterator<L1Object> iterator = World.get().getVisibleObjects(mapId).values().iterator();
/* 243 */     while (iterator.hasNext()) {
/* 244 */       Object obj = iterator.next();
/* 245 */       if (obj instanceof L1MonsterInstance) {
/* 246 */         L1MonsterInstance mob = (L1MonsterInstance)obj;
/* 247 */         if (mob == null || mob.isDead()) {
/*     */           continue;
/*     */         }
/* 250 */         MobCount++;
/*     */       } 
/*     */     } 
/* 253 */     return MobCount;
/*     */   }
/*     */   
/*     */   private static int PcCount(short mapId) {
/* 257 */     int PcCount = 0;
/* 258 */     Iterator<L1Object> iterator = World.get().getVisibleObjects(mapId).values().iterator();
/* 259 */     while (iterator.hasNext()) {
/* 260 */       Object obj = iterator.next();
/* 261 */       if (obj instanceof L1PcInstance) {
/* 262 */         L1PcInstance pc = (L1PcInstance)obj;
/* 263 */         if (pc == null || pc.isDead()) {
/*     */           continue;
/*     */         }
/* 266 */         PcCount++;
/*     */       } 
/*     */     } 
/* 269 */     return PcCount;
/*     */   }
/*     */   
/*     */   private static class Again extends TimerTask { private Again() {}
/*     */     
/*     */     public void run() {
/* 275 */       L1Thebes.setGameStatus(0);
/* 276 */       Iterator<L1Object> iterator = World.get().getVisibleObjects(782).values().iterator();
/* 277 */       while (iterator.hasNext()) {
/* 278 */         Object obj = iterator.next();
/* 279 */         if (obj instanceof L1NpcInstance) {
/* 280 */           L1NpcInstance npc = (L1NpcInstance)obj;
/* 281 */           npc.deleteMe();
/*     */         } 
/*     */       } 
/* 284 */       cancel();
/*     */     }
/*     */     
/*     */     public void begin() {
/* 288 */       Timer timer = new Timer();
/* 289 */       timer.schedule(this, (L1Config_other._2212 * 60 * 1000));
/*     */     } }
/*     */ 
/*     */   
/*     */   private static class Again2 extends TimerTask { private Again2() {}
/*     */     
/*     */     public void run() {
/* 296 */       L1Thebes.setGameStatus(0);
/* 297 */       Iterator<L1Object> iterator = World.get().getVisibleObjects(782).values().iterator();
/* 298 */       while (iterator.hasNext()) {
/* 299 */         Object obj = iterator.next();
/* 300 */         if (obj instanceof L1NpcInstance) {
/* 301 */           L1NpcInstance npc = (L1NpcInstance)obj;
/* 302 */           npc.deleteMe();
/*     */         } 
/*     */       } 
/* 305 */       cancel();
/*     */     }
/*     */     
/*     */     public void begin() {
/* 309 */       Timer timer = new Timer();
/* 310 */       timer.schedule(this, (L1Config_other._2218 * 60 * 1000));
/*     */     } }
/*     */   
/*     */   private static class SeekBossSecond extends TimerTask {
/*     */     private SeekBossSecond() {}
/*     */     
/*     */     public void run() {
/* 317 */       if (L1Thebes.MobCount((short)782) == 0) {
/* 318 */         L1Thebes.setGameEnd(1);
/* 319 */       } else if (L1Thebes.PcCount((short)782) == 0) {
/* 320 */         L1Thebes.setGameEnd(2);
/*     */       } else {
/* 322 */         L1Thebes.startSeekBossSecond();
/*     */       } 
/* 324 */       cancel();
/*     */     }
/*     */     
/*     */     public void begin() {
/* 328 */       Timer timer = new Timer();
/* 329 */       timer.schedule(this, 5000L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\Crack\L1Thebes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */