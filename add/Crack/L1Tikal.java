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
/*     */ import com.lineage.server.utils.collections.Lists;
/*     */ import com.lineage.server.world.World;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public class L1Tikal
/*     */ {
/*  36 */   private static Logger _log = Logger.getLogger(L1Tikal.class.getName()); public static final int STATUS_NONE = 0; public static final int STATUS_READY = 1;
/*  37 */   private static List<L1PcInstance> playerList = Lists.newArrayList(); public static final int STATUS_PLAYING = 2; public static final int STATUS_AGAIN = 3; public static final int STATUS_END = 4;
/*  38 */   public static int _status = 0; private static final int END_STATUS_WINNER = 1; private static final int END_STATUS_NOWINNER = 2;
/*  39 */   public static int _type = 0;
/*     */ 
/*     */   
/*     */   public static void enterGame(L1PcInstance pc, int npcid) {
/*  43 */     L1Object obj = World.get().findObject(npcid);
/*  44 */     L1NpcInstance npc = (L1NpcInstance)obj;
/*  45 */     if (!L1CrackTime.getStart().getGateOpen()) {
/*  46 */       pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(npc.getId(), "tikalgate2"));
/*     */       return;
/*     */     } 
/*  49 */     if (!pc.getInventory().checkItem(49273, 1L)) {
/*  50 */       pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(npc.getId(), "tikalgate3"));
/*     */       return;
/*     */     } 
/*  53 */     if (getGameStatus() == 2) {
/*  54 */       if (playerList.contains(pc)) {
/*  55 */         L1Teleport.teleport(pc, 32730, 32866, (short)784, 2, true);
/*     */       } else {
/*  57 */         pc.sendPackets((ServerBasePacket)new S_SystemMessage("副本已開始，無法進入。"));
/*     */       } 
/*     */       return;
/*     */     } 
/*  61 */     if (getGameStatus() == 3) {
/*  62 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("副本正在重置中。"));
/*     */       return;
/*     */     } 
/*  65 */     if (getGameStatus() == 4) {
/*  66 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("BOSS已死亡，無法進入。"));
/*     */       return;
/*     */     } 
/*  69 */     if (playerList.size() >= L1Config_other._2213) {
/*  70 */       pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(npc.getId(), "tikalgate4"));
/*     */       return;
/*     */     } 
/*  73 */     if (getGameStatus() == 0) {
/*  74 */       L1Teleport.teleport(pc, 32730, 32866, (short)784, 2, true);
/*  75 */       pc.getInventory().consumeItem(49273, 1L);
/*  76 */       addPlayerList(pc);
/*     */     } 
/*  78 */     if (getGameStatus() == 1 && playerList.size() < L1Config_other._2213) {
/*  79 */       L1Teleport.teleport(pc, 32730, 32866, (short)784, 2, true);
/*  80 */       pc.getInventory().consumeItem(49273, 1L);
/*  81 */       addPlayerList(pc);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void addPlayerList(L1PcInstance pc) {
/*  86 */     if (!playerList.contains(pc)) {
/*  87 */       playerList.add(pc);
/*     */     }
/*  89 */     if (playerList.size() == L1Config_other._2211) {
/*  90 */       if (getGameStatus() == 0) {
/*  91 */         setGameStatus(1);
/*  92 */         Iterator<L1Object> iterator = World.get().getVisibleObjects(784).values().iterator();
/*  93 */         while (iterator.hasNext()) {
/*  94 */           Object obj = iterator.next();
/*  95 */           if (obj instanceof L1PcInstance) {
/*  96 */             L1PcInstance tgpc = (L1PcInstance)obj;
/*  97 */             tgpc.sendPackets((ServerBasePacket)new S_SystemMessage("時空裂痕副本將在5秒後開始。"));
/*     */           } 
/*     */         } 
/* 100 */         OverTime(5);
/*     */       } 
/* 102 */     } else if (playerList.size() < L1Config_other._2211) {
/* 103 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("需要有至少 " + L1Config_other._2211 + " 人以上參加者才可能開始副本。"));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void removePlayerList(L1PcInstance pc) {
/* 108 */     if (playerList.contains(pc)) {
/* 109 */       playerList.remove(pc);
/* 110 */       L1Teleport.teleport(pc, 33442, 32797, (short)4, 5, true);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void setGameStatus(int i) {
/* 115 */     _status = i;
/*     */   }
/*     */   
/*     */   private static int getGameStatus() {
/* 119 */     return _status;
/*     */   }
/*     */   
/*     */   private static void setGameEnd(int type) {
/* 123 */     switch (type) {
/*     */       case 1:
/* 125 */         sendEndMessage(type);
/*     */         break;
/*     */       
/*     */       case 2:
/* 129 */         sendEndMessage(type);
/*     */         break;
/*     */     } 
/*     */     
/* 133 */     _type = type;
/*     */   }
/*     */   
/*     */   public static int getGameEnd() {
/* 137 */     return _type;
/*     */   }
/*     */   
/*     */   private static void startAgain() {
/* 141 */     (new Again(null)).begin();
/*     */   }
/*     */   
/*     */   private static void startAgain2() {
/* 145 */     (new Again2(null)).begin();
/*     */   }
/*     */   
/*     */   private static void sendEndMessage(int type) {
/* 149 */     if (type == 1) {
/* 150 */       Iterator<L1PcInstance> iterator = playerList.iterator();
/* 151 */       while (iterator.hasNext()) {
/* 152 */         L1PcInstance pc = iterator.next();
/* 153 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(1488));
/*     */       } 
/* 155 */     } else if (type == 2) {
/* 156 */       Iterator<L1PcInstance> iterator2 = playerList.iterator();
/* 157 */       while (iterator2.hasNext()) {
/* 158 */         L1PcInstance pc = iterator2.next();
/* 159 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(1490));
/*     */       } 
/*     */     } 
/* 162 */     Overtime2(type);
/*     */   }
/*     */   
/*     */   private static void Overtime2(int type) {
/* 166 */     int time = 40;
/*     */     try {
/* 168 */       while (time >= 0) {
/* 169 */         Thread.sleep(1000L);
/* 170 */         Iterator<L1PcInstance> iterator = playerList.iterator();
/* 171 */         while (iterator.hasNext()) {
/* 172 */           L1PcInstance pc = iterator.next();
/* 173 */           if (time == 35 && type == 1) {
/* 174 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1489)); continue;
/* 175 */           }  if (time == 30) {
/* 176 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1476)); continue;
/* 177 */           }  if (time == 20) {
/* 178 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1477)); continue;
/* 179 */           }  if (time == 10) {
/* 180 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1478)); continue;
/* 181 */           }  if (time == 5) {
/* 182 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1480)); continue;
/* 183 */           }  if (time == 4) {
/* 184 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1481)); continue;
/* 185 */           }  if (time == 3) {
/* 186 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1482)); continue;
/* 187 */           }  if (time == 2) {
/* 188 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1483)); continue;
/* 189 */           }  if (time == 1) {
/* 190 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1484)); continue;
/*     */           } 
/* 192 */           if (time != 0 || type != 2) {
/*     */             continue;
/*     */           }
/* 195 */           setGameStatus(3);
/* 196 */           playerList.clear();
/* 197 */           startAgain();
/*     */         } 
/*     */         
/* 200 */         time--;
/*     */       } 
/* 202 */     } catch (Exception e) {
/* 203 */       _log.warning(e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void OverTime(int time) {
/*     */     try {
/* 209 */       while (time >= 0) {
/* 210 */         Thread.sleep(1000L);
/* 211 */         time--;
/* 212 */         Iterator<L1PcInstance> iterator = playerList.iterator();
/* 213 */         while (iterator.hasNext()) {
/* 214 */           L1PcInstance pc = iterator.next();
/* 215 */           if (time == 4) {
/* 216 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1485)); continue;
/* 217 */           }  if (time == 3) {
/* 218 */             pc.sendPackets((ServerBasePacket)new S_ServerMessage(1486)); continue;
/*     */           } 
/* 220 */           if (time != 2) {
/*     */             continue;
/*     */           }
/* 223 */           pc.sendPackets((ServerBasePacket)new S_ServerMessage(1487));
/*     */         } 
/*     */         
/* 226 */         if (time == 1) {
/* 227 */           L1SpawnUtil.spawn(92000, 32751, 32871, (short)784, 0);
/* 228 */           L1SpawnUtil.spawn(92001, 32750, 32860, (short)784, 0);
/* 229 */           startSeekBossSecond();
/*     */         } 
/*     */       } 
/* 232 */     } catch (Exception e) {
/* 233 */       _log.warning(e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void startSeekBossSecond() {
/* 238 */     (new SeekBossSecond(null)).begin();
/*     */   }
/*     */   
/*     */   private static int MobCount(short mapId) {
/* 242 */     int MobCount = 0;
/* 243 */     Iterator<L1Object> iterator = World.get().getVisibleObjects(mapId).values().iterator();
/* 244 */     while (iterator.hasNext()) {
/* 245 */       Object obj = iterator.next();
/* 246 */       if (obj instanceof L1MonsterInstance) {
/* 247 */         L1MonsterInstance mob = (L1MonsterInstance)obj;
/* 248 */         if (mob == null || mob.isDead()) {
/*     */           continue;
/*     */         }
/* 251 */         MobCount++;
/*     */       } 
/*     */     } 
/* 254 */     return MobCount;
/*     */   }
/*     */   
/*     */   private static int PcCount(short mapId) {
/* 258 */     int PcCount = 0;
/* 259 */     Iterator<L1Object> iterator = World.get().getVisibleObjects(mapId).values().iterator();
/* 260 */     while (iterator.hasNext()) {
/* 261 */       Object obj = iterator.next();
/* 262 */       if (obj instanceof L1PcInstance) {
/* 263 */         L1PcInstance pc = (L1PcInstance)obj;
/* 264 */         if (pc == null || pc.isDead()) {
/*     */           continue;
/*     */         }
/* 267 */         PcCount++;
/*     */       } 
/*     */     } 
/* 270 */     return PcCount;
/*     */   }
/*     */   
/*     */   private static class Again extends TimerTask { private Again() {}
/*     */     
/*     */     public void run() {
/* 276 */       L1Tikal.setGameStatus(0);
/* 277 */       Iterator<L1Object> iterator = World.get().getVisibleObjects(784).values().iterator();
/* 278 */       while (iterator.hasNext()) {
/* 279 */         Object obj = iterator.next();
/* 280 */         if (obj instanceof L1NpcInstance) {
/* 281 */           L1NpcInstance npc = (L1NpcInstance)obj;
/* 282 */           npc.deleteMe();
/*     */         } 
/*     */       } 
/* 285 */       cancel();
/*     */     }
/*     */     
/*     */     public void begin() {
/* 289 */       Timer timer = new Timer();
/* 290 */       timer.schedule(this, (L1Config_other._2212 * 60 * 1000));
/*     */     } }
/*     */ 
/*     */   
/*     */   private static class Again2 extends TimerTask { private Again2() {}
/*     */     
/*     */     public void run() {
/* 297 */       L1Tikal.setGameStatus(0);
/* 298 */       Iterator<L1Object> iterator = World.get().getVisibleObjects(784).values().iterator();
/* 299 */       while (iterator.hasNext()) {
/* 300 */         Object obj = iterator.next();
/* 301 */         if (obj instanceof L1NpcInstance) {
/* 302 */           L1NpcInstance npc = (L1NpcInstance)obj;
/* 303 */           npc.deleteMe();
/*     */         } 
/*     */       } 
/* 306 */       cancel();
/*     */     }
/*     */     
/*     */     public void begin() {
/* 310 */       Timer timer = new Timer();
/* 311 */       timer.schedule(this, (L1Config_other._2218 * 60 * 1000));
/*     */     } }
/*     */   
/*     */   private static class SeekBossSecond extends TimerTask {
/*     */     private SeekBossSecond() {}
/*     */     
/*     */     public void run() {
/* 318 */       if (L1Tikal.MobCount((short)784) == 0) {
/* 319 */         L1Tikal.setGameEnd(1);
/* 320 */       } else if (L1Tikal.PcCount((short)784) == 0) {
/* 321 */         L1Tikal.setGameEnd(2);
/*     */       } else {
/* 323 */         L1Tikal.startSeekBossSecond();
/*     */       } 
/* 325 */       cancel();
/*     */     }
/*     */     
/*     */     public void begin() {
/* 329 */       Timer timer = new Timer();
/* 330 */       timer.schedule(this, 5000L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\Crack\L1Tikal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */