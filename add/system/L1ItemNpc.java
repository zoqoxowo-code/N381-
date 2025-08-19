/*     */ package com.add.system;
/*     */ 
/*     */ import com.lineage.DatabaseFactory;
/*     */ import com.lineage.echo.ClientExecutor;
/*     */ import com.lineage.server.IdFactory;
/*     */ import com.lineage.server.datatables.NpcTable;
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ import com.lineage.server.model.Instance.L1MonsterInstance;
/*     */ import com.lineage.server.model.Instance.L1NpcInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.model.L1Character;
/*     */ import com.lineage.server.model.L1Object;
/*     */ import com.lineage.server.serverpackets.S_DoActionGFX;
/*     */ import com.lineage.server.serverpackets.S_GreenMessage;
/*     */ import com.lineage.server.serverpackets.S_NPCPack;
/*     */ import com.lineage.server.serverpackets.S_ServerMessage;
/*     */ import com.lineage.server.serverpackets.S_SystemMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.types.Point;
/*     */ import com.lineage.server.utils.Random;
/*     */ import com.lineage.server.world.World;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class L1ItemNpc
/*     */ {
/*  36 */   private static Logger _log = Logger.getLogger(L1ItemNpc.class.getName());
/*     */   private static boolean NO_MORE_GET_DATA5 = false;
/*  38 */   private static ArrayList<int[]> aData5 = (ArrayList)new ArrayList<>();
/*     */ 
/*     */   
/*     */   public static void forRequestItemUSe(ClientExecutor client, L1ItemInstance itemInstance) {
/*  42 */     L1PcInstance user = client.getActiveChar();
/*  43 */     int[] aTempData = null;
/*  44 */     int iX = user.getX();
/*  45 */     int iY = user.getY();
/*  46 */     int iMap = user.getMapId();
/*  47 */     int iX2 = 0;
/*  48 */     int iY2 = 0;
/*  49 */     int iX3 = 0;
/*  50 */     int iY3 = 0;
/*  51 */     short iMap2 = 0;
/*  52 */     boolean found = false;
/*  53 */     int itemid = itemInstance.getItemId();
/*  54 */     if (!NO_MORE_GET_DATA5) {
/*  55 */       NO_MORE_GET_DATA5 = true;
/*  56 */       getData5();
/*     */     } 
/*  58 */     int i = 0;
/*  59 */     while (i < aData5.size()) {
/*  60 */       aTempData = aData5.get(i);
/*  61 */       iX2 = aTempData[5];
/*  62 */       iY2 = aTempData[6];
/*  63 */       iX3 = aTempData[7];
/*  64 */       iY3 = aTempData[8];
/*  65 */       iMap2 = (short)aTempData[10];
/*  66 */       if (aTempData[1] == itemid && user.getInventory().checkItem(aTempData[1], aTempData[2])) {
/*     */         try {
/*  68 */           if (iMap2 != -1 && iMap != iMap2) {
/*  69 */             user.sendPackets((ServerBasePacket)new S_SystemMessage("無法此在地圖使用。"));
/*     */             return;
/*     */           } 
/*  72 */           if (iX2 != -1 && iX3 != -1 && iY2 != -1 && iY3 != -1 && (
/*  73 */             iX < iX2 || iX > iX3 || iY < iY2 || iY > iY3)) {
/*  74 */             user.sendPackets((ServerBasePacket)new S_SystemMessage("無法此在座標使用。"));
/*     */             return;
/*     */           } 
/*  77 */           if (aTempData[0] != 0) {
/*  78 */             byte class_id = 0;
/*  79 */             String msg = "";
/*  80 */             if (user.isCrown()) {
/*  81 */               class_id = 1;
/*  82 */             } else if (user.isKnight()) {
/*  83 */               class_id = 2;
/*  84 */             } else if (user.isWizard()) {
/*  85 */               class_id = 3;
/*  86 */             } else if (user.isElf()) {
/*  87 */               class_id = 4;
/*  88 */             } else if (user.isDarkelf()) {
/*  89 */               class_id = 5;
/*  90 */             } else if (user.isDragonKnight()) {
/*  91 */               class_id = 6;
/*  92 */             } else if (user.isIllusionist()) {
/*  93 */               class_id = 7;
/*     */             } 
/*  95 */             switch (aTempData[0]) {
/*     */               case 1:
/*  97 */                 msg = "王族";
/*     */                 break;
/*     */               
/*     */               case 2:
/* 101 */                 msg = "騎士";
/*     */                 break;
/*     */               
/*     */               case 3:
/* 105 */                 msg = "法師";
/*     */                 break;
/*     */               
/*     */               case 4:
/* 109 */                 msg = "妖精";
/*     */                 break;
/*     */               
/*     */               case 5:
/* 113 */                 msg = "黑暗妖精";
/*     */                 break;
/*     */               
/*     */               case 6:
/* 117 */                 msg = "龍騎士";
/*     */                 break;
/*     */               
/*     */               case 7:
/* 121 */                 msg = "幻術師";
/*     */                 break;
/*     */             } 
/*     */             
/* 125 */             if (aTempData[0] != class_id) {
/* 126 */               user.sendPackets((ServerBasePacket)new S_ServerMessage(166, "職業必須是" + msg + "才能使用此道具"));
/*     */               return;
/*     */             } 
/*     */           } 
/* 130 */           Iterator<L1Object> iterator = World.get().getObject().iterator();
/* 131 */           while (iterator.hasNext()) {
/* 132 */             L1Object obj = iterator.next();
/* 133 */             if (obj instanceof L1MonsterInstance) {
/* 134 */               L1MonsterInstance mob = (L1MonsterInstance)obj;
/* 135 */               if (mob != null && aTempData[12] != 0 && mob.getNpcTemplate().get_npcId() == aTempData[4]) {
/* 136 */                 found = true;
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/* 142 */           if (found) {
/* 143 */             user.sendPackets((ServerBasePacket)new S_ServerMessage(79));
/*     */           } else {
/* 145 */             mobspawn(user, aTempData[4], aTempData[9], aTempData[11], aTempData[13], aTempData[14]);
/* 146 */             String npcname = NpcTable.get().getNpcName(aTempData[4]);
/* 147 */             user.sendPackets((ServerBasePacket)new S_GreenMessage(String.valueOf(String.valueOf(npcname)) + "出現了。"));
/* 148 */             Iterator<L1PcInstance> iterator2 = World.get().getVisiblePlayer((L1Object)user, 50).iterator();
/* 149 */             while (iterator2.hasNext()) {
/* 150 */               L1PcInstance listner = iterator2.next();
/* 151 */               if (user.get_showId() == listner.get_showId()) {
/* 152 */                 listner.sendPackets((ServerBasePacket)new S_GreenMessage(String.valueOf(String.valueOf(npcname)) + "出現了。"));
/*     */               }
/*     */             } 
/*     */           } 
/* 156 */           if (aTempData[3] == 1 && !found) {
/* 157 */             int j = 0;
/* 158 */             while (j < aTempData[2]) {
/* 159 */               L1ItemInstance item = user.getInventory().findItemId(aTempData[1]);
/* 160 */               user.getInventory().removeItem(item.getId(), 1L);
/* 161 */               j++;
/*     */             } 
/*     */           } 
/* 164 */         } catch (Exception e) {
/* 165 */           _log.log(Level.SEVERE, e.getLocalizedMessage(), e);
/*     */         } 
/*     */       }
/* 168 */       i++;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void getData5() {
/* 173 */     Connection con = null;
/*     */     try {
/* 175 */       con = DatabaseFactory.get().getConnection();
/* 176 */       Statement stat = con.createStatement();
/* 177 */       ResultSet rset = stat.executeQuery("SELECT * FROM system_item_npc");
/* 178 */       int[] aReturn = null;
/* 179 */       if (rset != null) {
/* 180 */         while (rset.next()) {
/* 181 */           aReturn = new int[] { rset.getInt("class"), rset.getInt("materials"), rset.getInt("counts"), 
/* 182 */               rset.getInt("destroy"), rset.getInt("monster_id"), rset.getInt("location_minx"), 
/* 183 */               rset.getInt("location_miny"), rset.getInt("location_maxx"), rset.getInt("location_maxy"), 
/* 184 */               rset.getInt("location_area"), rset.getInt("map_id"), rset.getInt("delete_time"), 
/* 185 */               rset.getInt("found"), rset.getInt("spawn_x"), rset.getInt("spawn_y") };
/* 186 */           aData5.add(aReturn);
/*     */         } 
/*     */       }
/* 189 */       if (con != null && !con.isClosed()) {
/* 190 */         con.close();
/*     */       }
/* 192 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */   
/*     */   private static void mobspawn(L1PcInstance pc, int npcId, int randomRange, int timeMillisToDelete, int spawnx, int spawny) {
/*     */     try {
/*     */       Iterator<L1PcInstance> iterator;
/* 199 */       L1NpcInstance npc = NpcTable.get().newNpcInstance(npcId);
/* 200 */       npc.setId(IdFactory.get().nextId());
/* 201 */       npc.setMap(pc.getMapId());
/* 202 */       npc.set_showId(pc.get_showId());
/* 203 */       if (randomRange == 0) {
/* 204 */         if (spawnx > 0 && spawny > 0) {
/* 205 */           npc.setX(spawnx);
/* 206 */           npc.setY(spawny);
/*     */         } else {
/* 208 */           npc.getLocation().set(pc.getLocation());
/* 209 */           npc.getLocation().forward(pc.getHeading());
/*     */         } 
/*     */       } else {
/* 212 */         int tryCount = 0;
/*     */         do {
/* 214 */           tryCount++;
/* 215 */           npc.setX(pc.getX() + Random.nextInt(randomRange) - Random.nextInt(randomRange));
/* 216 */           npc.setY(pc.getY() + Random.nextInt(randomRange) - Random.nextInt(randomRange));
/* 217 */           if (npc.getMap().isInMap((Point)npc.getLocation()) && npc.getMap().isPassable((Point)npc.getLocation(), (L1Character)npc)) {
/*     */             break;
/*     */           }
/* 220 */           Thread.sleep(1L);
/* 221 */         } while (tryCount < 50);
/* 222 */         if (tryCount >= 50) {
/* 223 */           npc.getLocation().set(pc.getLocation());
/* 224 */           npc.getLocation().forward(pc.getHeading());
/*     */         } 
/*     */       } 
/* 227 */       npc.setHomeX(npc.getX());
/* 228 */       npc.setHomeY(npc.getY());
/* 229 */       npc.setHeading(5);
/* 230 */       npc.setMovementDistance(50);
/* 231 */       World.get().storeObject((L1Object)npc);
/* 232 */       World.get().addVisibleObject((L1Object)npc);
/* 233 */       int gfx = npc.getTempCharGfx();
/* 234 */       switch (gfx) {
/*     */         case 7548:
/*     */         case 7550:
/*     */         case 7552:
/*     */         case 7554:
/*     */         case 7585:
/*     */         case 7591:
/*     */         case 7840:
/*     */         case 8096:
/* 243 */           npc.broadcastPacketAll((ServerBasePacket)new S_NPCPack(npc));
/* 244 */           npc.broadcastPacketAll((ServerBasePacket)new S_DoActionGFX(npc.getId(), 11));
/*     */           break;
/*     */         
/*     */         case 7539:
/*     */         case 7557:
/*     */         case 7558:
/*     */         case 7864:
/*     */         case 7869:
/*     */         case 7870:
/*     */         case 8036:
/*     */         case 8054:
/*     */         case 8055:
/* 256 */           iterator = World.get().getVisiblePlayer((L1Object)npc, 50).iterator();
/* 257 */           while (iterator.hasNext()) {
/* 258 */             L1PcInstance _pc = iterator.next();
/* 259 */             if (npc.getTempCharGfx() == 7539) {
/* 260 */               _pc.sendPackets((ServerBasePacket)new S_ServerMessage(1570)); continue;
/* 261 */             }  if (npc.getTempCharGfx() == 7864) {
/* 262 */               _pc.sendPackets((ServerBasePacket)new S_ServerMessage(1657)); continue;
/*     */             } 
/* 264 */             if (npc.getTempCharGfx() != 8036) {
/*     */               continue;
/*     */             }
/* 267 */             _pc.sendPackets((ServerBasePacket)new S_ServerMessage(1755));
/*     */           } 
/*     */           
/* 270 */           npc.broadcastPacketAll((ServerBasePacket)new S_NPCPack(npc));
/* 271 */           npc.broadcastPacketAll((ServerBasePacket)new S_DoActionGFX(npc.getId(), 11));
/*     */           break;
/*     */         
/*     */         case 145:
/*     */         case 2158:
/*     */         case 3547:
/*     */         case 3566:
/*     */         case 3957:
/*     */         case 3969:
/*     */         case 3984:
/*     */         case 3989:
/*     */         case 7719:
/*     */         case 10071:
/*     */         case 11465:
/*     */         case 11467:
/* 286 */           npc.broadcastPacketAll((ServerBasePacket)new S_NPCPack(npc));
/* 287 */           npc.broadcastPacketAll((ServerBasePacket)new S_DoActionGFX(npc.getId(), 4));
/*     */           break;
/*     */         
/*     */         case 30:
/* 291 */           npc.broadcastPacketAll((ServerBasePacket)new S_NPCPack(npc));
/* 292 */           npc.broadcastPacketAll((ServerBasePacket)new S_DoActionGFX(npc.getId(), 30));
/*     */           break;
/*     */       } 
/*     */       
/* 296 */       npc.turnOnOffLight();
/* 297 */       npc.startChat(0);
/* 298 */       if (timeMillisToDelete > 0) {
/* 299 */         npc.set_spawnTime(timeMillisToDelete);
/*     */       }
/* 301 */     } catch (Exception e) {
/* 302 */       _log.log(Level.SEVERE, e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\system\L1ItemNpc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */