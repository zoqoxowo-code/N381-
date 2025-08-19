/*     */ package com.lineage.data.cmd;
/*     */ 
/*     */ import com.lineage.config.Configtype;
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.serverpackets.S_CloseList;
/*     */ import com.lineage.server.serverpackets.S_ItemStatus;
/*     */ import com.lineage.server.serverpackets.S_ServerMessage;
/*     */ import com.lineage.server.serverpackets.S_SystemMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.utils.BroadcastUtil;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class EnchantWeapondiy
/*     */   extends EnchantExecutor
/*     */ {
/*  18 */   private static final Log _log = LogFactory.getLog(EnchantWeapondiy.class);
/*     */ 
/*     */ 
/*     */   
/*     */   public void failureEnchant(L1PcInstance pc, L1ItemInstance item) {
/*  23 */     StringBuilder s = new StringBuilder();
/*     */     
/*  25 */     if (pc.get_other().get_item_objid() != 0) {
/*  26 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("\\fT物品正在進行託售中.請在重新操作一次"));
/*  27 */       pc.sendPackets((ServerBasePacket)new S_CloseList(pc.getId()));
/*     */       
/*  29 */       pc.get_other().set_item_objid(0);
/*     */       return;
/*     */     } 
/*  32 */     String pm = "";
/*  33 */     if (item.getEnchantLevel() > 0) {
/*  34 */       pm = "+";
/*     */     }
/*  36 */     s.append(String.valueOf(String.valueOf(pm)) + item.getEnchantLevel() + " " + item.getName());
/*     */     
/*  38 */     if (!pc.isGm() && item.getEnchantLevel() - item.getItem().get_safeenchant() >= Configtype.weapon_savebroad - 1) {
/*  39 */       BroadcastUtil.broadcast(Integer.valueOf(Configtype.weaponbroadfail), Configtype.msg1_fail, new Object[] { pc.getName(), s.toString() });
/*     */     }
/*     */     
/*  42 */     pc.sendPackets((ServerBasePacket)new S_ServerMessage("武器似乎沒發生什麼事情。"));
/*     */   }
/*     */   
/*     */   public void failureEnchantdiy(L1PcInstance pc, L1ItemInstance item) {
/*  46 */     StringBuilder s = new StringBuilder();
/*     */     
/*  48 */     if (pc.get_other().get_item_objid() != 0) {
/*  49 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("\\fT物品正在進行託售中.請在重新操作一次"));
/*  50 */       pc.sendPackets((ServerBasePacket)new S_CloseList(pc.getId()));
/*     */       
/*  52 */       pc.get_other().set_item_objid(0);
/*     */       return;
/*     */     } 
/*  55 */     String pm = "";
/*  56 */     if (item.getEnchantLevel() > 0) {
/*  57 */       pm = "+";
/*     */     }
/*  59 */     s.append(String.valueOf(String.valueOf(pm)) + item.getEnchantLevel() + " " + item.getName());
/*     */     
/*  61 */     if (!pc.isGm() && item.getEnchantLevel() - item.getItem().get_safeenchant() >= Configtype.weapon_savebroad - 1) {
/*  62 */       BroadcastUtil.broadcast(Integer.valueOf(Configtype.weaponbroadfail), Configtype.msg1_fail, new Object[] { pc.getName(), s.toString() });
/*     */     }
/*     */     
/*  65 */     pc.sendPackets((ServerBasePacket)new S_ServerMessage(164, s.toString(), "$252"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void successEnchant(L1PcInstance pc, L1ItemInstance item, int i) {
/*  70 */     StringBuilder s = new StringBuilder();
/*  71 */     StringBuilder sa = new StringBuilder();
/*  72 */     StringBuilder sb = new StringBuilder();
/*  73 */     if (!item.isIdentified()) {
/*  74 */       s.append(item.getName());
/*     */     } else {
/*  76 */       s.append(item.getLogName());
/*     */     } 
/*  78 */     switch (i) {
/*     */       case 0:
/*  80 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(160, s.toString(), "$252", "$248"));
/*     */         return;
/*     */       
/*     */       case -1:
/*  84 */         sa.append("$246");
/*  85 */         sb.append("$247");
/*     */         break;
/*     */       
/*     */       case 1:
/*  89 */         sa.append("$245");
/*  90 */         sb.append("$247");
/*     */         break;
/*     */       
/*     */       case 2:
/*     */       case 3:
/*  95 */         sa.append("$245");
/*  96 */         sb.append("$248");
/*     */         break;
/*     */     } 
/*     */     
/* 100 */     pc.sendPackets((ServerBasePacket)new S_ServerMessage(161, s.toString(), sa.toString(), sb.toString()));
/* 101 */     int oldEnchantLvl = item.getEnchantLevel();
/* 102 */     int newEnchantLvl = oldEnchantLvl + i;
/* 103 */     item.setEnchantLevel(newEnchantLvl);
/* 104 */     pc.getInventory().updateItem(item, 4);
/* 105 */     pc.getInventory().saveItem(item, 4);
/* 106 */     if (oldEnchantLvl != newEnchantLvl) {
/*     */       
/* 108 */       if (!pc.isGm() && item.getEnchantLevel() - item.getItem().get_safeenchant() >= Configtype.weapon_savebroad) {
/* 109 */         BroadcastUtil.broadcast(Integer.valueOf(Configtype.weaponbroadtrue), Configtype.msg1_true, new Object[] { pc.getName(), s.toString() });
/*     */       }
/*     */       
/* 112 */       pc.sendPackets((ServerBasePacket)new S_ItemStatus(item));
/* 113 */       pc.getInventory().saveItem(item, 4);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\cmd\EnchantWeapondiy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */