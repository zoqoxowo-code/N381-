/*     */ package com.add;
/*     */ 
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ import com.lineage.server.model.Instance.L1MonsterInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.model.L1Inventory;
/*     */ import com.lineage.server.model.L1Location;
/*     */ import com.lineage.server.model.L1Object;
/*     */ import com.lineage.server.model.L1Teleport;
/*     */ import com.lineage.server.model.map.L1Map;
/*     */ import com.lineage.server.serverpackets.S_CharVisualUpdate;
/*     */ import com.lineage.server.serverpackets.S_MapID;
/*     */ import com.lineage.server.serverpackets.S_OtherCharPacks;
/*     */ import com.lineage.server.serverpackets.S_OwnCharPack;
/*     */ import com.lineage.server.serverpackets.S_ServerMessage;
/*     */ import com.lineage.server.serverpackets.S_SkillSound;
/*     */ import com.lineage.server.serverpackets.S_SystemMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.types.Point;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PeepCard
/*     */ {
/*  26 */   private static Random _random = new Random();
/*     */ 
/*     */   
/*     */   public static void TeleportPc(L1PcInstance pc, L1Object target) {
/*  30 */     if (target instanceof L1PcInstance) {
/*  31 */       L1PcInstance target_pc = (L1PcInstance)target;
/*  32 */       if (pc.getLocation().getTileLineDistance((Point)target_pc.getLocation()) > 4) {
/*  33 */         L1Location newLoc = pc.getLocation().randomLocation(1, 1, false);
/*  34 */         if (pc.glanceCheck(newLoc.getX(), newLoc.getY())) {
/*  35 */           L1Teleport.teleport(target_pc, newLoc.getX(), newLoc.getY(), pc.getMapId(), 5, true);
/*  36 */           pc.sendPackets((ServerBasePacket)new S_SkillSound(pc.getId(), 3932));
/*  37 */           pc.broadcastPacketAll((ServerBasePacket)new S_SkillSound(pc.getId(), 3932));
/*     */         } 
/*     */       } else {
/*  40 */         pc.sendPackets((ServerBasePacket)new S_SystemMessage("對方距離不夠遠，無法把他抓過來。"));
/*     */       } 
/*  42 */     } else if (target instanceof L1MonsterInstance) {
/*  43 */       L1MonsterInstance target_npc = (L1MonsterInstance)target;
/*  44 */       if (pc.getLocation().getTileLineDistance((Point)target_npc.getLocation()) > 4) {
/*  45 */         L1Location newLoc = pc.getLocation().randomLocation(1, 1, false);
/*  46 */         if (pc.glanceCheck(newLoc.getX(), newLoc.getY())) {
/*  47 */           target_npc.broadcastPacketAll((ServerBasePacket)new S_SkillSound(target_npc.getId(), 3932));
/*  48 */           target_npc.setX(newLoc.getX());
/*  49 */           target_npc.setY(newLoc.getY());
/*  50 */           target_npc.setHeading(target_npc.getHeading());
/*     */         } 
/*     */       } else {
/*  53 */         pc.sendPackets((ServerBasePacket)new S_SystemMessage("怪物距離不夠遠，無法把怪物抓過來。"));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void BackMagic(L1PcInstance pc, L1Object target) {
/*  59 */     int _x = pc.getX() - target.getX();
/*  60 */     int _y = pc.getY() - target.getY();
/*  61 */     if (Math.abs(_x) < 5 && Math.abs(_y) < 5) {
/*     */       int a; int f;
/*  63 */       if (_x > 0) {
/*  64 */         a = target.getX() - 1;
/*  65 */       } else if (_x < 0) {
/*  66 */         a = target.getX() + 1;
/*     */       } else {
/*  68 */         a = target.getX();
/*     */       } 
/*     */       
/*  71 */       if (_y > 0) {
/*  72 */         f = target.getY() - 1;
/*  73 */       } else if (_y < 0) {
/*  74 */         f = target.getY() + 1;
/*     */       } else {
/*  76 */         f = target.getY();
/*     */       } 
/*  78 */       if (target != null) {
/*  79 */         L1Map map = target.getMap();
/*  80 */         if (map.isPassable(a, f, null)) {
/*  81 */           target.setX(a);
/*  82 */           target.setY(f);
/*  83 */           if (target instanceof L1PcInstance) {
/*  84 */             L1PcInstance targetPc = (L1PcInstance)target;
/*  85 */             targetPc.sendPackets((ServerBasePacket)new S_MapID(targetPc.getMapId(), targetPc.getMap().isUnderwater()));
/*  86 */             targetPc.broadcastPacketAll((ServerBasePacket)new S_OtherCharPacks(targetPc));
/*  87 */             targetPc.sendPackets((ServerBasePacket)new S_OwnCharPack(targetPc));
/*  88 */             targetPc.sendPackets((ServerBasePacket)new S_CharVisualUpdate(targetPc));
/*  89 */             targetPc.removeAllKnownObjects();
/*  90 */             targetPc.updateObject();
/*     */           } 
/*     */         } 
/*  93 */         pc.sendPacketsAll((ServerBasePacket)new S_SkillSound(target.getId(), 2181));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void TakePc(L1PcInstance pc, L1Object target) {
/*  99 */     if (target instanceof L1PcInstance) {
/* 100 */       L1PcInstance target_pc = (L1PcInstance)target;
/* 101 */       int rnd = _random.nextInt(100) + 1;
/* 102 */       if (rnd < 0) {
/* 103 */         rnd = 0;
/*     */       }
/* 105 */       L1ItemInstance item = target_pc.getInventory().caoPenalty();
/* 106 */       if (item != null && _random.nextInt(100) + 1 < rnd) {
/* 107 */         target_pc.getInventory().tradeItem(item, item.isStackable() ? item.getCount() : 1L, (L1Inventory)pc.getInventory());
/* 108 */         target_pc.sendPackets((ServerBasePacket)new S_ServerMessage(638, item.getLogName()));
/* 109 */         pc.sendPackets((ServerBasePacket)new S_SystemMessage("成功偷到( " + item.getLogName() + " )。"));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\PeepCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */