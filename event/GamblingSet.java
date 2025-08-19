/*     */ package com.lineage.data.event;
/*     */ 
/*     */ import com.lineage.data.executor.EventExecutor;
/*     */ import com.lineage.server.IdFactoryNpc;
/*     */ import com.lineage.server.datatables.ItemTable;
/*     */ import com.lineage.server.datatables.NpcTable;
/*     */ import com.lineage.server.datatables.lock.GamblingReading;
/*     */ import com.lineage.server.model.Instance.L1DoorInstance;
/*     */ import com.lineage.server.model.L1Object;
/*     */ import com.lineage.server.templates.L1Event;
/*     */ import com.lineage.server.templates.L1Item;
/*     */ import com.lineage.server.timecontroller.event.GamblingTime;
/*     */ import com.lineage.server.world.World;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GamblingSet
/*     */   extends EventExecutor
/*     */ {
/*     */   public static int GAMADENATIME;
/*  25 */   private static final Log _log = LogFactory.getLog(GamblingSet.class);
/*  26 */   public static int ADENAITEM = 40308;
/*     */   public static int GAMADENA;
/*     */   
/*     */   public static EventExecutor get() {
/*  30 */     return new GamblingSet();
/*     */   }
/*     */   public static String GAMADENANAME;
/*     */   
/*     */   public void execute(L1Event event) {
/*     */     try {
/*  36 */       String[] set = event.get_eventother().split(",");
/*     */       try {
/*  38 */         GAMADENATIME = Integer.parseInt(set[0]);
/*  39 */       } catch (Exception e2) {
/*  40 */         GAMADENATIME = 30;
/*  41 */         _log.error("未設定每場比賽間隔時間(分鐘)(使用預設30分鐘)");
/*     */       } 
/*     */       try {
/*  44 */         GAMADENA = Integer.parseInt(set[1]);
/*  45 */       } catch (Exception e2) {
/*  46 */         GAMADENA = 5000;
/*  47 */         _log.error("未設定奇岩賭場 下注額(每張賭票售價)(使用預設5000)");
/*     */       } 
/*     */       try {
/*  50 */         ADENAITEM = Integer.parseInt(set[2]);
/*  51 */         L1Item item = ItemTable.get().getTemplate(ADENAITEM);
/*  52 */         if (item != null) {
/*  53 */           GAMADENANAME = item.getNameId();
/*     */         }
/*  55 */       } catch (Exception e2) {
/*  56 */         ADENAITEM = 40308;
/*  57 */         GAMADENANAME = "$4";
/*  58 */         _log.error("未設定奇岩賭場 下注物品編號(使用預設40308)");
/*     */       } 
/*  60 */       GamblingReading.get().load();
/*  61 */       GamblingTime gamblingTimeController = new GamblingTime();
/*  62 */       gamblingTimeController.start();
/*  63 */       spawnDoor();
/*  64 */     } catch (Exception e) {
/*  65 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void spawnDoor() {
/*  70 */     int[][] gamDoors = { { 51, 1487, 33521, 32861, 4, 1, 33523, 33523, -1
/*  71 */         }, { 52, 1487, 33519, 32863, 4, 1, 33523, 33523, -1
/*  72 */         }, { 53, 1487, 33517, 32865, 4, 1, 33523, 33523, -1
/*  73 */         }, { 54, 1487, 33515, 32867, 4, 1, 33523, 33523, -1
/*  74 */         }, { 55, 1487, 33513, 32869, 4, 1, 33523, 33523, -1 } };
/*     */     
/*  76 */     int array[][], length = (array = gamDoors).length;
/*  77 */     int i = 0;
/*  78 */     while (i < length) {
/*  79 */       int[] doorInfo = array[i];
/*  80 */       L1DoorInstance door = (L1DoorInstance)NpcTable.get().newNpcInstance(81158);
/*  81 */       if (door != null) {
/*  82 */         door.setId(IdFactoryNpc.get().nextId());
/*  83 */         int id = doorInfo[0];
/*  84 */         int gfxid = doorInfo[1];
/*  85 */         int locx = doorInfo[2];
/*  86 */         int locy = doorInfo[3];
/*  87 */         int mapid = doorInfo[4];
/*  88 */         int direction = doorInfo[5];
/*  89 */         int left_edge_location = doorInfo[6];
/*  90 */         int right_edge_location = doorInfo[7];
/*  91 */         int hp = doorInfo[8];
/*  92 */         int keeper = doorInfo[9];
/*  93 */         door.setDoorId(id);
/*  94 */         door.setGfxId(gfxid);
/*  95 */         door.setX(locx);
/*  96 */         door.setY(locy);
/*  97 */         door.setMap((short)mapid);
/*  98 */         door.setHomeX(locx);
/*  99 */         door.setHomeY(locy);
/* 100 */         door.setDirection(direction);
/* 101 */         door.setLeftEdgeLocation(left_edge_location);
/* 102 */         door.setRightEdgeLocation(right_edge_location);
/* 103 */         door.setMaxHp(hp);
/* 104 */         door.setCurrentHp(hp);
/* 105 */         door.setKeeperId(keeper);
/* 106 */         World.get().storeObject((L1Object)door);
/* 107 */         World.get().addVisibleObject((L1Object)door);
/*     */       } 
/* 109 */       i++;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\GamblingSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */