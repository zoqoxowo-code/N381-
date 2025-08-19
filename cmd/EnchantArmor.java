/*     */ package com.lineage.data.cmd;
/*     */ 
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
/*     */ import com.lineage.william.GiveBack;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class EnchantArmor extends EnchantExecutor {
/*  21 */   private static final Log _log = LogFactory.getLog(EnchantArmor.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void failureEnchant(L1PcInstance pc, L1ItemInstance item) {
/*  27 */     if (pc.get_other().get_item_objid() != 0) {
/*  28 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("\\fT物品正在進行託售中.請在重新操作一次"));
/*  29 */       pc.sendPackets((ServerBasePacket)new S_CloseList(pc.getId()));
/*     */       
/*  31 */       pc.get_other().set_item_objid(0);
/*     */       return;
/*     */     } 
/*  34 */     StringBuilder s = new StringBuilder();
/*  35 */     if (ConfigRecord.LOGGING_BAN_ENCHANT) {
/*  36 */       LogEnchantReading.get().failureEnchant(pc, item);
/*     */     }
/*  38 */     if (!item.isIdentified()) {
/*  39 */       s.append(item.getName());
/*     */     } else {
/*  41 */       s.append(item.getLogName());
/*     */     } 
/*  43 */     pc.sendPackets((ServerBasePacket)new S_ServerMessage(164, s.toString(), "$252"));
/*     */ 
/*     */     
/*  46 */     GiveBack.savepcid.add(Integer.valueOf(pc.getId()));
/*  47 */     GiveBack.saveweapon.add(item);
/*  48 */     GiveBack.savename.add(item.getNumberedViewName(1L));
/*     */     
/*  50 */     if (!pc.isGm() && item.getEnchantLevel() - item.getItem().get_safeenchant() >= Configtype.armor_savebroad - 1) {
/*  51 */       BroadcastUtil.broadcast(Integer.valueOf(Configtype.armorbroadfail), Configtype.msg1_fail, new Object[] { pc.getName(), s.toString() });
/*     */     }
/*  53 */     pc.getInventory().removeItem(item, item.getCount());
/*  54 */     _log.info("人物:" + pc.getName() + "點爆物品" + item.getItem().getName() + " 物品OBJID:" + item.getId());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void successEnchant(L1PcInstance pc, L1ItemInstance item, int randomELevel) {
/*  60 */     if (pc.get_other().get_item_objid() != 0) {
/*  61 */       pc.sendPackets((ServerBasePacket)new S_SystemMessage("\\fT物品正在進行託售中.請在重新操作一次"));
/*  62 */       pc.sendPackets((ServerBasePacket)new S_CloseList(pc.getId()));
/*     */       
/*  64 */       pc.get_other().set_item_objid(0);
/*     */       return;
/*     */     } 
/*  67 */     StringBuilder s = new StringBuilder();
/*  68 */     StringBuilder sa = new StringBuilder();
/*  69 */     StringBuilder sb = new StringBuilder();
/*  70 */     if (!item.isIdentified()) {
/*  71 */       s.append(item.getName());
/*  72 */     } else if (item.getEnchantLevel() > 0) {
/*  73 */       s.append("+" + item.getEnchantLevel() + " " + item.getName());
/*  74 */     } else if (item.getEnchantLevel() < 0) {
/*  75 */       s.append(String.valueOf(String.valueOf(item.getEnchantLevel())) + " " + item.getName());
/*     */     } else {
/*  77 */       s.append(item.getName());
/*     */     } 
/*  79 */     switch (randomELevel) {
/*     */       case 0:
/*  81 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(160, s.toString(), "$252", "$248"));
/*  82 */         pc.setcheck_lv(true);
/*     */         return;
/*     */       
/*     */       case -1:
/*  86 */         sa.append("$246");
/*  87 */         sb.append("$247");
/*     */         break;
/*     */       
/*     */       case 1:
/*  91 */         sa.append("$252");
/*  92 */         sb.append("$247");
/*     */         break;
/*     */       
/*     */       case 2:
/*     */       case 3:
/*  97 */         sa.append("$252");
/*  98 */         sb.append("$248");
/*     */         break;
/*     */     } 
/*     */     
/* 102 */     pc.sendPackets((ServerBasePacket)new S_ServerMessage(161, s.toString(), sa.toString(), sb.toString()));
/* 103 */     int oldEnchantLvl = item.getEnchantLevel();
/* 104 */     int newEnchantLvl = oldEnchantLvl + randomELevel;
/* 105 */     if (oldEnchantLvl != newEnchantLvl) {
/* 106 */       item.setEnchantLevel(newEnchantLvl);
/* 107 */       pc.getInventory().updateItem(item, 4);
/* 108 */       pc.getInventory().saveItem(item, 4);
/* 109 */       if (!pc.isGm() && item.getEnchantLevel() - item.getItem().get_safeenchant() >= Configtype.armor_savebroad) {
/* 110 */         BroadcastUtil.broadcast(Integer.valueOf(Configtype.armorbroadtrue), Configtype.msg1_true, new Object[] { pc.getName(), s.toString() });
/*     */       }
/* 112 */       if (item.isEquipped()) {
/* 113 */         Integer attack, bowattack, mr, sp, weight, hp; int use_type = item.getItem().getUseType();
/* 114 */         switch (use_type) {
/*     */           case 2:
/*     */           case 18:
/*     */           case 19:
/*     */           case 20:
/*     */           case 21:
/*     */           case 22:
/*     */           case 25:
/*     */           case 47:
/* 123 */             pc.addAc(-randomELevel);
/* 124 */             attack = (Integer)L1ItemPower.Attack.get(Integer.valueOf(item.getItemId()));
/* 125 */             if (attack != null) {
/* 126 */               pc.addMr(randomELevel * attack.intValue());
/*     */             }
/* 128 */             bowattack = (Integer)L1ItemPower.BowAttack.get(Integer.valueOf(item.getItemId()));
/* 129 */             if (bowattack != null) {
/* 130 */               pc.addMr(randomELevel * bowattack.intValue());
/*     */             }
/* 132 */             mr = (Integer)L1ItemPower.MR.get(Integer.valueOf(item.getItemId()));
/* 133 */             if (mr != null) {
/* 134 */               pc.addMr(randomELevel * mr.intValue());
/*     */             }
/* 136 */             sp = (Integer)L1ItemPower.SP.get(Integer.valueOf(item.getItemId()));
/* 137 */             if (sp != null) {
/* 138 */               pc.addSp(randomELevel * sp.intValue());
/*     */             }
/* 140 */             weight = (Integer)L1ItemPower.weightReductionByEnchant.get(Integer.valueOf(item.getItemId()));
/* 141 */             if (weight != null) {
/* 142 */               pc.addWeightReduction(randomELevel * weight.intValue());
/*     */             }
/* 144 */             hp = (Integer)L1ItemPower.HP.get(Integer.valueOf(item.getItemId()));
/* 145 */             if (hp == null) {
/*     */               break;
/*     */             }
/* 148 */             if (item.getItemId() == 300429) {
/* 149 */               int enchantlvl = item.getEnchantLevel();
/* 150 */               if (randomELevel == -1) {
/* 151 */                 enchantlvl++;
/*     */               }
/* 153 */               switch (enchantlvl) {
/*     */                 case 5:
/*     */                 case 7:
/*     */                 case 9:
/* 157 */                   pc.addMaxHp(randomELevel * hp.intValue());
/*     */                   break;
/*     */               } 
/*     */               
/*     */               break;
/*     */             } 
/* 163 */             pc.addMaxHp(randomELevel * hp.intValue());
/*     */             break;
/*     */           
/*     */           case 23:
/*     */           case 24:
/*     */           case 37:
/*     */           case 40:
/* 170 */             if (item.getItem().get_greater() != 3) {
/* 171 */               item.GreaterAtEnchant(pc, randomELevel);
/*     */             }
/*     */             break;
/*     */         } 
/*     */ 
/*     */         
/* 177 */         pc.sendPackets((ServerBasePacket)new S_SPMR(pc));
/* 178 */         pc.sendPackets((ServerBasePacket)new S_OwnCharStatus(pc));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\cmd\EnchantArmor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */