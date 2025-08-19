/*     */ package com.lineage.data.cmd;
/*     */ import com.lineage.config.ConfigRecord;
/*     */ import com.lineage.config.Configtype;
/*     */ import com.lineage.server.datatables.lock.LogEnchantReading;
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ import com.lineage.server.model.Instance.L1ItemPower;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.serverpackets.S_CloseList;
/*     */ import com.lineage.server.serverpackets.S_OwnCharStatus;
/*     */ import com.lineage.server.serverpackets.S_SPMR;
/*     */ import com.lineage.server.serverpackets.S_ServerMessage;
/*     */ import com.lineage.server.serverpackets.S_SystemMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.utils.BroadcastUtil;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class EnchantAccessory extends EnchantExecutor {
/*  18 */   private static final Log _log = LogFactory.getLog(EnchantAccessory.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void failureEnchant(L1PcInstance pc, L1ItemInstance item) {
/*  24 */     if (pc.get_other().get_item_objid() != 0) {
/*  25 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("\\fT物品正在進行託售中.請在重新操作一次"));
/*  26 */       pc.sendPackets((ServerBasePacket)new S_CloseList(pc.getId()));
/*     */       
/*  28 */       pc.get_other().set_item_objid(0);
/*     */       return;
/*     */     } 
/*  31 */     StringBuilder s = new StringBuilder();
/*  32 */     if (ConfigRecord.LOGGING_BAN_ENCHANT) {
/*  33 */       LogEnchantReading.get().failureEnchant(pc, item);
/*     */     }
/*  35 */     if (!item.isIdentified()) {
/*  36 */       s.append(item.getName());
/*     */     } else {
/*  38 */       s.append(item.getLogName());
/*     */     } 
/*  40 */     pc.sendPackets((ServerBasePacket)new S_ServerMessage(164, s.toString(), "$252"));
/*     */     
/*  42 */     if (!pc.isGm() && item.getEnchantLevel() - item.getItem().get_safeenchant() >= Configtype.Accessory_savebroad - 1) {
/*  43 */       BroadcastUtil.broadcast(Integer.valueOf(Configtype.Accessoryfalse), Configtype.msg4_fail, new Object[] { pc.getName(), s.toString() });
/*     */     }
/*     */ 
/*     */     
/*  47 */     pc.getInventory().removeItem(item, item.getCount());
/*  48 */     _log
/*  49 */       .info("人物:" + pc.getName() + "點爆物品" + item.getItem().getName() + " 物品OBJID:" + item.getId());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void successEnchant(L1PcInstance pc, L1ItemInstance item, int randomELevel) {
/*  55 */     if (pc.get_other().get_item_objid() != 0) {
/*  56 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("\\fT物品正在進行託售中.請在重新操作一次"));
/*  57 */       pc.sendPackets((ServerBasePacket)new S_CloseList(pc.getId()));
/*     */       
/*  59 */       pc.get_other().set_item_objid(0);
/*     */       return;
/*     */     } 
/*  62 */     StringBuilder s = new StringBuilder();
/*  63 */     StringBuilder sa = new StringBuilder();
/*  64 */     StringBuilder sb = new StringBuilder();
/*  65 */     if (!item.isIdentified()) {
/*  66 */       s.append(item.getName());
/*  67 */     } else if (item.getEnchantLevel() > 0) {
/*  68 */       s.append("+" + item.getEnchantLevel() + " " + item.getName());
/*  69 */     } else if (item.getEnchantLevel() < 0) {
/*  70 */       s.append(String.valueOf(String.valueOf(item.getEnchantLevel())) + " " + item.getName());
/*     */     } else {
/*  72 */       s.append(item.getName());
/*     */     } 
/*  74 */     switch (randomELevel) {
/*     */       case 0:
/*  76 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(160, s.toString(), "$252", "$248"));
/*  77 */         pc.setcheck_lv(true);
/*     */         return;
/*     */       
/*     */       case -1:
/*  81 */         sa.append("$246");
/*  82 */         sb.append("$247");
/*     */         break;
/*     */       
/*     */       case 1:
/*  86 */         sa.append("$252");
/*  87 */         sb.append("$247");
/*     */         break;
/*     */       
/*     */       case 2:
/*     */       case 3:
/*  92 */         sa.append("$252");
/*  93 */         sb.append("$248");
/*     */         break;
/*     */     } 
/*     */     
/*  97 */     pc.sendPackets((ServerBasePacket)new S_ServerMessage(161, s.toString(), sa.toString(), sb.toString()));
/*  98 */     int oldEnchantLvl = item.getEnchantLevel();
/*  99 */     int newEnchantLvl = oldEnchantLvl + randomELevel;
/* 100 */     if (oldEnchantLvl != newEnchantLvl) {
/* 101 */       item.setEnchantLevel(newEnchantLvl);
/* 102 */       pc.getInventory().updateItem(item, 4);
/* 103 */       pc.getInventory().saveItem(item, 4);
/* 104 */       if (!pc.isGm() && item.getEnchantLevel() - item.getItem().get_safeenchant() >= Configtype.Accessory_savebroad) {
/* 105 */         BroadcastUtil.broadcast(Integer.valueOf(Configtype.Accessorytrue), Configtype.msg4_true, new Object[] { pc.getName(), s.toString() });
/*     */       }
/* 107 */       if (item.isEquipped()) {
/* 108 */         Integer attack, bowattack, mr, sp, weight, hp; int use_type = item.getItem().getUseType();
/* 109 */         switch (use_type) {
/*     */           case 2:
/*     */           case 18:
/*     */           case 19:
/*     */           case 20:
/*     */           case 21:
/*     */           case 22:
/*     */           case 25:
/*     */           case 47:
/* 118 */             pc.addAc(-randomELevel);
/* 119 */             attack = (Integer)L1ItemPower.Attack.get(Integer.valueOf(item.getItemId()));
/* 120 */             if (attack != null) {
/* 121 */               pc.addMr(randomELevel * attack.intValue());
/*     */             }
/* 123 */             bowattack = (Integer)L1ItemPower.BowAttack.get(Integer.valueOf(item.getItemId()));
/* 124 */             if (bowattack != null) {
/* 125 */               pc.addMr(randomELevel * bowattack.intValue());
/*     */             }
/* 127 */             mr = (Integer)L1ItemPower.MR.get(Integer.valueOf(item.getItemId()));
/* 128 */             if (mr != null) {
/* 129 */               pc.addMr(randomELevel * mr.intValue());
/*     */             }
/* 131 */             sp = (Integer)L1ItemPower.SP.get(Integer.valueOf(item.getItemId()));
/* 132 */             if (sp != null) {
/* 133 */               pc.addSp(randomELevel * sp.intValue());
/*     */             }
/* 135 */             weight = (Integer)L1ItemPower.weightReductionByEnchant.get(Integer.valueOf(item.getItemId()));
/* 136 */             if (weight != null) {
/* 137 */               pc.addWeightReduction(randomELevel * weight.intValue());
/*     */             }
/* 139 */             hp = (Integer)L1ItemPower.HP.get(Integer.valueOf(item.getItemId()));
/* 140 */             if (hp == null) {
/*     */               break;
/*     */             }
/* 143 */             if (item.getItemId() == 300429) {
/* 144 */               int enchantlvl = item.getEnchantLevel();
/* 145 */               if (randomELevel == -1) {
/* 146 */                 enchantlvl++;
/*     */               }
/* 148 */               switch (enchantlvl) {
/*     */                 case 5:
/*     */                 case 7:
/*     */                 case 9:
/* 152 */                   pc.addMaxHp(randomELevel * hp.intValue());
/*     */                   break;
/*     */               } 
/*     */               
/*     */               break;
/*     */             } 
/* 158 */             pc.addMaxHp(randomELevel * hp.intValue());
/*     */             break;
/*     */           
/*     */           case 23:
/*     */           case 24:
/*     */           case 37:
/*     */           case 40:
/* 165 */             if (item.getItem().get_greater() != 3) {
/* 166 */               item.GreaterAtEnchant(pc, randomELevel);
/*     */             }
/*     */             break;
/*     */         } 
/*     */ 
/*     */         
/* 172 */         pc.sendPackets((ServerBasePacket)new S_SPMR(pc));
/* 173 */         pc.sendPackets((ServerBasePacket)new S_OwnCharStatus(pc));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\cmd\EnchantAccessory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */