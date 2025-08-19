/*     */ package com.lineage.data.item_armor.set;
/*     */ 
/*     */ import com.lineage.server.datatables.ArmorSetTable;
/*     */ import com.lineage.server.datatables.ItemTable;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.templates.L1ArmorSets;
/*     */ import java.util.HashMap;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ArmorSet
/*     */ {
/*  16 */   private static final Log _log = LogFactory.getLog(ArmorSet.class);
/*  17 */   private static final HashMap<Integer, ArmorSet> _allSet = new HashMap<>();
/*     */ 
/*     */   
/*     */   public abstract int[] get_ids();
/*     */   
/*     */   public abstract int[] get_mode();
/*     */   
/*     */   public abstract void giveEffect(L1PcInstance paramL1PcInstance);
/*     */   
/*     */   public abstract void cancelEffect(L1PcInstance paramL1PcInstance);
/*     */   
/*     */   public abstract boolean isValid(L1PcInstance paramL1PcInstance);
/*     */   
/*     */   public abstract boolean isPartOfSet(int paramInt);
/*     */   
/*     */   public abstract boolean isEquippedRingOfArmorSet(L1PcInstance paramL1PcInstance);
/*     */   
/*     */   public static HashMap<Integer, ArmorSet> getAllSet() {
/*  35 */     return _allSet;
/*     */   }
/*     */   
/*     */   public static void load() {
/*     */     try {
/*     */       L1ArmorSets[] allList;
/*  41 */       int length = (allList = ArmorSetTable.get().getAllList()).length;
/*  42 */       int i = 0;
/*  43 */       while (i < length) {
/*  44 */         L1ArmorSets armorSets = allList[i];
/*  45 */         int id = armorSets.getId();
/*  46 */         int[] gfxs = null;
/*  47 */         if (armorSets.get_gfxs() != null) {
/*  48 */           gfxs = armorSets.get_gfxs();
/*     */         }
/*  50 */         ArmorSetImpl value = new ArmorSetImpl(id, getArray(id, armorSets.getSets()), gfxs);
/*     */         
/*  52 */         if (armorSets.getPolyId() != -1) {
/*  53 */           value.addEffect(new EffectPolymorph(armorSets.getPolyId()));
/*     */         }
/*  55 */         if (armorSets.getAc() != 0) {
/*  56 */           value.addEffect(new EffectAc(armorSets.getAc()));
/*     */         }
/*  58 */         if (armorSets.getMr() != 0) {
/*  59 */           value.addEffect(new EffectMr(armorSets.getMr()));
/*     */         }
/*  61 */         if (armorSets.getHp() != 0) {
/*  62 */           value.addEffect(new EffectHp(armorSets.getHp()));
/*     */         }
/*  64 */         if (armorSets.getHpr() != 0) {
/*  65 */           value.addEffect(new EffectHpR(armorSets.getHpr()));
/*     */         }
/*  67 */         if (armorSets.getMp() != 0) {
/*  68 */           value.addEffect(new EffectMp(armorSets.getMp()));
/*     */         }
/*  70 */         if (armorSets.getMpr() != 0) {
/*  71 */           value.addEffect(new EffectMpR(armorSets.getMpr()));
/*     */         }
/*  73 */         if (armorSets.getDefenseWater() != 0) {
/*  74 */           value.addEffect(new EffectDefenseWater(armorSets.getDefenseWater()));
/*     */         }
/*  76 */         if (armorSets.getDefenseWind() != 0) {
/*  77 */           value.addEffect(new EffectDefenseWind(armorSets.getDefenseWind()));
/*     */         }
/*  79 */         if (armorSets.getDefenseFire() != 0) {
/*  80 */           value.addEffect(new EffectDefenseFire(armorSets.getDefenseFire()));
/*     */         }
/*  82 */         if (armorSets.getDefenseEarth() != 0) {
/*  83 */           value.addEffect(new EffectDefenseEarth(armorSets.getDefenseEarth()));
/*     */         }
/*     */ 
/*     */         
/*  87 */         if (armorSets.get_regist_stun() != 0) {
/*  88 */           value.addEffect(new EffectRegist_Stun(armorSets.get_regist_stun()));
/*     */         }
/*  90 */         if (armorSets.get_regist_stone() != 0) {
/*  91 */           value.addEffect(new EffectRegist_Stone(armorSets.get_regist_stone()));
/*     */         }
/*  93 */         if (armorSets.get_regist_sleep() != 0) {
/*  94 */           value.addEffect(new EffectRegist_Sleep(armorSets.get_regist_sleep()));
/*     */         }
/*  96 */         if (armorSets.get_regist_freeze() != 0) {
/*  97 */           value.addEffect(new EffectRegist_Freeze(armorSets.get_regist_freeze()));
/*     */         }
/*  99 */         if (armorSets.get_regist_sustain() != 0) {
/* 100 */           value.addEffect(new EffectRegist_Sustain(armorSets.get_regist_sustain()));
/*     */         }
/* 102 */         if (armorSets.get_regist_blind() != 0) {
/* 103 */           value.addEffect(new EffectRegist_Blind(armorSets.get_regist_blind()));
/*     */         }
/* 105 */         if (armorSets.getStr() != 0) {
/* 106 */           value.addEffect(new EffectStat_Str(armorSets.getStr()));
/*     */         }
/* 108 */         if (armorSets.getDex() != 0) {
/* 109 */           value.addEffect(new EffectStat_Dex(armorSets.getDex()));
/*     */         }
/* 111 */         if (armorSets.getCon() != 0) {
/* 112 */           value.addEffect(new EffectStat_Con(armorSets.getCon()));
/*     */         }
/* 114 */         if (armorSets.getWis() != 0) {
/* 115 */           value.addEffect(new EffectStat_Wis(armorSets.getWis()));
/*     */         }
/* 117 */         if (armorSets.getCha() != 0) {
/* 118 */           value.addEffect(new EffectStat_Cha(armorSets.getCha()));
/*     */         }
/* 120 */         if (armorSets.getIntl() != 0) {
/* 121 */           value.addEffect(new EffectStat_Int(armorSets.getIntl()));
/*     */         }
/* 123 */         if (armorSets.get_modifier_dmg() != 0) {
/* 124 */           value.addEffect(new Effect_Modifier_dmg(armorSets.get_modifier_dmg()));
/*     */         }
/* 126 */         if (armorSets.get_reduction_dmg() != 0) {
/* 127 */           value.addEffect(new Effect_Reduction_dmg(armorSets.get_reduction_dmg()));
/*     */         }
/* 129 */         if (armorSets.get_magic_modifier_dmg() != 0) {
/* 130 */           value.addEffect(new Effect_Magic_modifier_dmg(armorSets.get_magic_modifier_dmg()));
/*     */         }
/* 132 */         if (armorSets.get_magic_reduction_dmg() != 0) {
/* 133 */           value.addEffect(new Effect_Magic_reduction_dmg(armorSets.get_magic_reduction_dmg()));
/*     */         }
/* 135 */         if (armorSets.get_bow_modifier_dmg() != 0) {
/* 136 */           value.addEffect(new Effect_Bow_modifier_dmg(armorSets.get_bow_modifier_dmg()));
/*     */         }
/* 138 */         if (armorSets.get_haste() != 0) {
/* 139 */           value.addEffect(new EffectHaste(armorSets.get_haste()));
/*     */         }
/* 141 */         if (armorSets.get_sp() != 0) {
/* 142 */           value.addEffect(new EffectSp(armorSets.get_sp()));
/*     */         }
/* 144 */         if (armorSets.get_hit_modifier() != 0) {
/* 145 */           value.addEffect(new Effect_Hit_modifier(armorSets.get_hit_modifier()));
/*     */         }
/* 147 */         if (armorSets.get_bow_hit_modifier() != 0) {
/* 148 */           value.addEffect(new Effect_Bow_Hit_modifier(armorSets.get_bow_hit_modifier()));
/*     */         }
/* 150 */         if (armorSets.get_magiccritical_chance() != 0) {
/* 151 */           value.addEffect(new Effect_MagicCritical_chance(armorSets.get_magiccritical_chance()));
/*     */         }
/* 153 */         _allSet.put(Integer.valueOf(armorSets.getId()), value);
/* 154 */         i++;
/*     */       } 
/* 156 */     } catch (Exception e) {
/* 157 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 159 */       ItemTable.get().se_mode();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int[] getArray(int id, String s) {
/* 164 */     String[] clientStrAry = s.split(",");
/* 165 */     int[] array = new int[clientStrAry.length];
/*     */     try {
/* 167 */       int i = 0;
/* 168 */       while (i < clientStrAry.length) {
/* 169 */         array[i] = Integer.parseInt(clientStrAry[i]);
/* 170 */         i++;
/*     */       } 
/* 172 */     } catch (Exception e) {
/* 173 */       _log.error("編號:" + id + " 套件設置錯誤!!檢查資料庫!!", e);
/*     */     } 
/* 175 */     return array;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\set\ArmorSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */