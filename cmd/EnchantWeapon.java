/*     */ package com.lineage.data.cmd;
/*     */ 
/*     */ import com.lineage.config.ConfigRecord;
/*     */ import com.lineage.config.Configtype;
/*     */ import com.lineage.server.datatables.lock.LogEnchantReading;
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.serverpackets.S_CloseList;
/*     */ import com.lineage.server.serverpackets.S_ItemStatus;
/*     */ import com.lineage.server.serverpackets.S_ServerMessage;
/*     */ import com.lineage.server.serverpackets.S_SystemMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.utils.BroadcastUtil;
/*     */ import com.lineage.william.GiveBack;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ 
/*     */ public class EnchantWeapon
/*     */   extends EnchantExecutor
/*     */ {
/*  22 */   private static final Log _log = LogFactory.getLog(EnchantWeapon.class);
/*     */ 
/*     */ 
/*     */   
/*     */   public void failureEnchant(L1PcInstance pc, L1ItemInstance item) {
/*  27 */     StringBuilder s = new StringBuilder();
/*  28 */     if (ConfigRecord.LOGGING_BAN_ENCHANT) {
/*  29 */       LogEnchantReading.get().failureEnchant(pc, item);
/*     */     }
/*     */     
/*  32 */     if (pc.get_other().get_item_objid() != 0) {
/*  33 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("\\fT物品正在進行託售中.請在重新操作一次"));
/*  34 */       pc.sendPackets((ServerBasePacket)new S_CloseList(pc.getId()));
/*     */       
/*  36 */       pc.get_other().set_item_objid(0);
/*     */       return;
/*     */     } 
/*  39 */     String pm = "";
/*  40 */     if (item.getEnchantLevel() > 0) {
/*  41 */       pm = "+";
/*     */     }
/*  43 */     s.append(String.valueOf(String.valueOf(pm)) + item.getEnchantLevel() + " " + item.getName());
/*  44 */     if (!pc.isGm() && item.getEnchantLevel() - item.getItem().get_safeenchant() >= Configtype.weapon_savebroad - 1) {
/*  45 */       BroadcastUtil.broadcast(Integer.valueOf(Configtype.weaponbroadfail), Configtype.msg1_fail, new Object[] { pc.getName(), s.toString() });
/*     */     }
/*  47 */     pc.sendPackets((ServerBasePacket)new S_ServerMessage(164, s.toString(), "$252"));
/*     */     
/*  49 */     GiveBack.savepcid.add(Integer.valueOf(pc.getId()));
/*  50 */     GiveBack.saveweapon.add(item);
/*  51 */     GiveBack.savename.add(item.getNumberedViewName(1L));
/*     */     
/*  53 */     pc.getInventory().removeItem(item, item.getCount());
/*  54 */     _log
/*  55 */       .info("人物:" + pc.getName() + "點爆物品(武器)" + item.getItem().getName() + " 物品OBJID:" + item.getId());
/*     */   }
/*     */ 
/*     */   
/*     */   public void successEnchant(L1PcInstance pc, L1ItemInstance item, int i) {
/*  60 */     StringBuilder s = new StringBuilder();
/*  61 */     StringBuilder sa = new StringBuilder();
/*  62 */     StringBuilder sb = new StringBuilder();
/*     */     
/*  64 */     if (pc.get_other().get_item_objid() != 0) {
/*  65 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("\\fT物品正在進行託售中.請在重新操作一次"));
/*  66 */       pc.sendPackets((ServerBasePacket)new S_CloseList(pc.getId()));
/*     */       
/*  68 */       pc.get_other().set_item_objid(0);
/*     */       return;
/*     */     } 
/*  71 */     if (!item.isIdentified()) {
/*  72 */       s.append(item.getName());
/*     */     } else {
/*  74 */       s.append(item.getLogName());
/*     */     } 
/*  76 */     switch (i) {
/*     */       case 0:
/*  78 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(160, s.toString(), "$252", "$248"));
/*     */         return;
/*     */       
/*     */       case -1:
/*  82 */         sa.append("$246");
/*  83 */         sb.append("$247");
/*     */         break;
/*     */       
/*     */       case 1:
/*  87 */         sa.append("$245");
/*  88 */         sb.append("$247");
/*     */         break;
/*     */       
/*     */       case 2:
/*     */       case 3:
/*  93 */         sa.append("$245");
/*  94 */         sb.append("$248");
/*     */         break;
/*     */     } 
/*     */     
/*  98 */     pc.sendPackets((ServerBasePacket)new S_ServerMessage(161, s.toString(), sa.toString(), sb.toString()));
/*  99 */     int oldEnchantLvl = item.getEnchantLevel();
/* 100 */     int newEnchantLvl = oldEnchantLvl + i;
/* 101 */     item.setEnchantLevel(newEnchantLvl);
/* 102 */     pc.getInventory().updateItem(item, 4);
/* 103 */     pc.getInventory().saveItem(item, 4);
/* 104 */     if (oldEnchantLvl != newEnchantLvl) {
/* 105 */       if (!pc.isGm() && item.getEnchantLevel() - item.getItem().get_safeenchant() >= Configtype.weapon_savebroad) {
/* 106 */         BroadcastUtil.broadcast(Integer.valueOf(Configtype.weaponbroadfail), Configtype.msg1_true, new Object[] { pc.getName(), s.toString() });
/*     */       }
/* 108 */       pc.sendPackets((ServerBasePacket)new S_ItemStatus(item));
/* 109 */       pc.getInventory().saveItem(item, 4);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\cmd\EnchantWeapon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */