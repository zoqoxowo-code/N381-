/*     */ package com.lineage.data.item_armor.set;
/*     */ 
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.model.L1PcInventory;
/*     */ import com.lineage.server.serverpackets.S_SkillSound;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArmorSetImpl
/*     */   extends ArmorSet
/*     */ {
/*  21 */   private static final Log _log = LogFactory.getLog(ArmorSetImpl.class); private final int _id;
/*     */   private final int[] _ids;
/*     */   
/*     */   protected ArmorSetImpl(int id, int[] ids, int[] gfxids) {
/*  25 */     this._id = id;
/*  26 */     this._ids = ids;
/*  27 */     this._gfxids = gfxids;
/*  28 */     this._effects = new ArrayList<>();
/*     */   }
/*     */   private final ArrayList<ArmorSetEffect> _effects; private final int[] _gfxids;
/*     */   public int get_id() {
/*  32 */     return this._id;
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] get_ids() {
/*  37 */     return this._ids;
/*     */   }
/*     */   
/*     */   public void addEffect(ArmorSetEffect effect) {
/*  41 */     this._effects.add(effect);
/*     */   }
/*     */   
/*     */   public void removeEffect(ArmorSetEffect effect) {
/*  45 */     this._effects.remove(effect);
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] get_mode() {
/*  50 */     int[] mode = new int[31];
/*  51 */     Iterator<ArmorSetEffect> iterator = this._effects.iterator();
/*  52 */     while (iterator.hasNext()) {
/*  53 */       ArmorSetEffect effect = iterator.next();
/*  54 */       if (effect instanceof EffectStat_Str) {
/*  55 */         mode[0] = effect.get_mode();
/*     */       }
/*  57 */       if (effect instanceof EffectStat_Dex) {
/*  58 */         mode[1] = effect.get_mode();
/*     */       }
/*  60 */       if (effect instanceof EffectStat_Con) {
/*  61 */         mode[2] = effect.get_mode();
/*     */       }
/*  63 */       if (effect instanceof EffectStat_Wis) {
/*  64 */         mode[3] = effect.get_mode();
/*     */       }
/*  66 */       if (effect instanceof EffectStat_Int) {
/*  67 */         mode[4] = effect.get_mode();
/*     */       }
/*  69 */       if (effect instanceof EffectStat_Cha) {
/*  70 */         mode[5] = effect.get_mode();
/*     */       }
/*  72 */       if (effect instanceof EffectHp) {
/*  73 */         mode[6] = effect.get_mode();
/*     */       }
/*  75 */       if (effect instanceof EffectMp) {
/*  76 */         mode[7] = effect.get_mode();
/*     */       }
/*  78 */       if (effect instanceof EffectMr) {
/*  79 */         mode[8] = effect.get_mode();
/*     */       }
/*  81 */       if (effect instanceof EffectSp) {
/*  82 */         mode[9] = effect.get_mode();
/*     */       }
/*  84 */       if (effect instanceof EffectHaste) {
/*  85 */         mode[10] = effect.get_mode();
/*     */       }
/*  87 */       if (effect instanceof EffectDefenseFire) {
/*  88 */         mode[11] = effect.get_mode();
/*     */       }
/*  90 */       if (effect instanceof EffectDefenseWater) {
/*  91 */         mode[12] = effect.get_mode();
/*     */       }
/*  93 */       if (effect instanceof EffectDefenseWind) {
/*  94 */         mode[13] = effect.get_mode();
/*     */       }
/*  96 */       if (effect instanceof EffectDefenseEarth) {
/*  97 */         mode[14] = effect.get_mode();
/*     */       }
/*  99 */       if (effect instanceof EffectRegist_Freeze) {
/* 100 */         mode[15] = effect.get_mode();
/*     */       }
/* 102 */       if (effect instanceof EffectRegist_Stone) {
/* 103 */         mode[16] = effect.get_mode();
/*     */       }
/* 105 */       if (effect instanceof EffectRegist_Sleep) {
/* 106 */         mode[17] = effect.get_mode();
/*     */       }
/* 108 */       if (effect instanceof EffectRegist_Blind) {
/* 109 */         mode[18] = effect.get_mode();
/*     */       }
/* 111 */       if (effect instanceof EffectRegist_Stun) {
/* 112 */         mode[19] = effect.get_mode();
/*     */       }
/* 114 */       if (effect instanceof EffectRegist_Sustain) {
/* 115 */         mode[20] = effect.get_mode();
/*     */       }
/* 117 */       if (effect instanceof EffectHpR) {
/* 118 */         mode[21] = effect.get_mode();
/*     */       }
/* 120 */       if (effect instanceof EffectMpR) {
/* 121 */         mode[22] = effect.get_mode();
/*     */       }
/* 123 */       if (effect instanceof Effect_Modifier_dmg) {
/* 124 */         mode[23] = effect.get_mode();
/*     */       }
/* 126 */       if (effect instanceof Effect_Reduction_dmg) {
/* 127 */         mode[24] = effect.get_mode();
/*     */       }
/* 129 */       if (effect instanceof Effect_Magic_modifier_dmg) {
/* 130 */         mode[25] = effect.get_mode();
/*     */       }
/* 132 */       if (effect instanceof Effect_Magic_reduction_dmg) {
/* 133 */         mode[26] = effect.get_mode();
/*     */       }
/* 135 */       if (effect instanceof Effect_Bow_modifier_dmg) {
/* 136 */         mode[27] = effect.get_mode();
/*     */       }
/* 138 */       if (effect instanceof Effect_Hit_modifier) {
/* 139 */         mode[28] = effect.get_mode();
/*     */       }
/* 141 */       if (effect instanceof Effect_Bow_Hit_modifier) {
/* 142 */         mode[29] = effect.get_mode();
/*     */       }
/* 144 */       if (effect instanceof Effect_MagicCritical_chance) {
/* 145 */         mode[30] = effect.get_mode();
/*     */       }
/*     */     } 
/* 148 */     return mode;
/*     */   }
/*     */ 
/*     */   
/*     */   public void giveEffect(L1PcInstance pc) {
/*     */     try {
/* 154 */       Iterator<ArmorSetEffect> iterator = this._effects.iterator();
/* 155 */       while (iterator.hasNext()) {
/* 156 */         ArmorSetEffect effect = iterator.next();
/* 157 */         effect.giveEffect(pc);
/*     */       } 
/* 159 */       if (this._gfxids != null) {
/*     */         
/* 161 */         int gfxids[], length = (gfxids = this._gfxids).length;
/* 162 */         int i = 0;
/* 163 */         while (i < length) {
/* 164 */           int gfx = gfxids[i];
/* 165 */           pc.sendPacketsX8((ServerBasePacket)new S_SkillSound(pc.getId(), gfx));
/* 166 */           i++;
/*     */         } 
/*     */       } 
/* 169 */     } catch (Exception ex) {
/* 170 */       _log.error(ex.getLocalizedMessage(), ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void cancelEffect(L1PcInstance pc) {
/*     */     try {
/* 177 */       Iterator<ArmorSetEffect> iterator = this._effects.iterator();
/* 178 */       while (iterator.hasNext()) {
/* 179 */         ArmorSetEffect effect = iterator.next();
/* 180 */         effect.cancelEffect(pc);
/*     */       } 
/* 182 */     } catch (Exception ex) {
/* 183 */       _log.error(ex.getLocalizedMessage(), ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isValid(L1PcInstance pc) {
/* 189 */     return pc.getInventory().checkEquipped(this._ids);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPartOfSet(int id) {
/* 195 */     int ids[], length = (ids = this._ids).length;
/* 196 */     int j = 0;
/* 197 */     while (j < length) {
/* 198 */       int i = ids[j];
/* 199 */       if (id == i) {
/* 200 */         return true;
/*     */       }
/* 202 */       j++;
/*     */     } 
/* 204 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEquippedRingOfArmorSet(L1PcInstance pc) {
/* 209 */     L1PcInventory pcInventory = pc.getInventory();
/* 210 */     L1ItemInstance armor = null;
/* 211 */     boolean isSetContainRing = false;
/*     */     
/* 213 */     int ids[], length = (ids = this._ids).length;
/* 214 */     int i = 0;
/* 215 */     while (i < length) {
/* 216 */       int id = ids[i];
/* 217 */       armor = pcInventory.findItemId(id);
/* 218 */       if (armor.getItem().getUseType() == 23) {
/* 219 */         isSetContainRing = true;
/*     */         break;
/*     */       } 
/* 222 */       i++;
/*     */     } 
/* 224 */     if (armor != null && isSetContainRing) {
/* 225 */       int itemId = armor.getItem().getItemId();
/* 226 */       if (pcInventory.getTypeEquipped(2, 9) == 2) {
/* 227 */         L1ItemInstance[] ring = new L1ItemInstance[2];
/* 228 */         ring = pcInventory.getRingEquipped();
/* 229 */         if (ring[0].getItem().getItemId() == itemId && ring[1].getItem().getItemId() == itemId) {
/* 230 */           return true;
/*     */         }
/*     */       } 
/* 233 */       if (pcInventory.getTypeEquipped(2, 9) == 3) {
/* 234 */         L1ItemInstance[] ring = new L1ItemInstance[3];
/* 235 */         ring = pcInventory.getRingEquipped();
/* 236 */         if ((ring[0].getItem().getItemId() == itemId && ring[1].getItem().getItemId() == itemId) || (
/* 237 */           ring[0].getItem().getItemId() == itemId && ring[2].getItem().getItemId() == itemId) || (
/* 238 */           ring[1].getItem().getItemId() == itemId && ring[2].getItem().getItemId() == itemId)) {
/* 239 */           return true;
/*     */         }
/*     */       } 
/* 242 */       if (pcInventory.getTypeEquipped(2, 9) == 4) {
/* 243 */         L1ItemInstance[] ring = new L1ItemInstance[4];
/* 244 */         ring = pcInventory.getRingEquipped();
/* 245 */         if ((ring[0].getItem().getItemId() == itemId && ring[1].getItem().getItemId() == itemId) || (
/* 246 */           ring[0].getItem().getItemId() == itemId && ring[2].getItem().getItemId() == itemId) || (
/* 247 */           ring[0].getItem().getItemId() == itemId && ring[3].getItem().getItemId() == itemId) || (
/* 248 */           ring[1].getItem().getItemId() == itemId && ring[2].getItem().getItemId() == itemId) || (
/* 249 */           ring[1].getItem().getItemId() == itemId && ring[3].getItem().getItemId() == itemId) || (
/* 250 */           ring[2].getItem().getItemId() == itemId && ring[3].getItem().getItemId() == itemId)) {
/* 251 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/* 255 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\set\ArmorSetImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */