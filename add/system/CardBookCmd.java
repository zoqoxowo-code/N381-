/*     */ package com.add.system;
/*     */ 
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.model.L1Character;
/*     */ import com.lineage.server.model.L1PolyMorph;
/*     */ import com.lineage.server.serverpackets.S_NPCTalkReturn;
/*     */ import com.lineage.server.serverpackets.S_SystemMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CardBookCmd
/*     */ {
/*  17 */   private static final Log _log = LogFactory.getLog(CardBookCmd.class);
/*     */   private static CardBookCmd _instance;
/*     */   
/*     */   public static CardBookCmd get() {
/*  21 */     if (_instance == null) {
/*  22 */       _instance = new CardBookCmd();
/*     */     }
/*  24 */     return _instance;
/*     */   }
/*     */   public boolean Cmd(L1PcInstance pc, String cmd) {
/*     */     try {
/*     */       ACard card;
/*  29 */       boolean ok = false; String str;
/*  30 */       switch ((str = cmd).hashCode()) { case -7322848: if (!str.equals("cardset2"))
/*     */             break; 
/*  32 */           CardAllSet(pc);
/*  33 */           ok = true; break;
/*     */         case 553953106:
/*     */           if (!str.equals("cardset"))
/*     */             break; 
/*  37 */           CardSet(pc);
/*  38 */           ok = true; break;
/*     */         case 561663196:
/*     */           if (!str.equals("polycard"))
/*     */             break; 
/*  42 */           card = ACardTable.get().getCard(pc.getCardId());
/*  43 */           if (card != null) {
/*  44 */             if (pc.getQuest().get_step(card.getQuestId()) != 0) {
/*  45 */               if (card.getPolyId() != 0) {
/*  46 */                 if (card.getPolyItemId() != 0) {
/*  47 */                   if (pc.getInventory().checkItem(card.getPolyItemId(), card.getPolyItemCount())) {
/*  48 */                     L1PolyMorph.doPoly((L1Character)pc, card.getPolyId(), card.getPolyTime(), 1);
/*  49 */                     pc.getInventory().consumeItem(card.getPolyItemId(), card.getPolyItemCount());
/*     */                   } else {
/*  51 */                     pc.sendPackets((ServerBasePacket)new S_SystemMessage("變身需求道具不足"));
/*     */                   } 
/*     */                 } else {
/*  54 */                   L1PolyMorph.doPoly((L1Character)pc, card.getPolyId(), card.getPolyTime(), 1);
/*     */                 } 
/*     */               } else {
/*  57 */                 pc.sendPackets((ServerBasePacket)new S_SystemMessage("無法變身"));
/*     */               } 
/*     */             } else {
/*  60 */               pc.sendPackets((ServerBasePacket)new S_SystemMessage("尚未登入卡冊"));
/*     */             } 
/*     */           }
/*  63 */           ok = true;
/*     */           break; }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  69 */       if (ok) {
/*  70 */         return true;
/*     */       }
/*  72 */     } catch (Exception e) {
/*  73 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   private void CardAllSet(L1PcInstance pc) {
/*     */     try {
/*  80 */       int str = 0;
/*  81 */       int dex = 0;
/*  82 */       int con = 0;
/*  83 */       int Int = 0;
/*  84 */       int wis = 0;
/*  85 */       int cha = 0;
/*  86 */       int ac = 0;
/*  87 */       int hp = 0;
/*  88 */       int mp = 0;
/*  89 */       int hpr = 0;
/*  90 */       int mpr = 0;
/*  91 */       int dmg = 0;
/*  92 */       int bdmg = 0;
/*  93 */       int hit = 0;
/*  94 */       int bhit = 0;
/*  95 */       int dr = 0;
/*  96 */       int mdr = 0;
/*  97 */       int sp = 0;
/*  98 */       int mhit = 0;
/*  99 */       int mr = 0;
/* 100 */       int f = 0;
/* 101 */       int wind = 0;
/* 102 */       int w = 0;
/* 103 */       int e = 0;
/* 104 */       int i = 0;
/* 105 */       while (i <= ACardTable.get().ACardSize()) {
/* 106 */         ACard card = ACardTable.get().getCard(i);
/* 107 */         if (card != null && pc.getQuest().get_step(card.getQuestId()) != 0) {
/* 108 */           str += card.getAddStr();
/* 109 */           dex += card.getAddDex();
/* 110 */           con += card.getAddCon();
/* 111 */           Int += card.getAddInt();
/* 112 */           wis += card.getAddWis();
/* 113 */           cha += card.getAddCha();
/* 114 */           ac += card.getAddAc();
/* 115 */           hp += card.getAddHp();
/* 116 */           mp += card.getAddMp();
/* 117 */           hpr += card.getAddHpr();
/* 118 */           mpr += card.getAddMpr();
/* 119 */           dmg += card.getAddDmg();
/* 120 */           bdmg += card.getAddBowDmg();
/* 121 */           hit += card.getAddHit();
/* 122 */           bhit += card.getAddBowHit();
/* 123 */           dr += card.getAddDmgR();
/* 124 */           mdr += card.getAddMagicDmgR();
/* 125 */           sp += card.getAddSp();
/* 126 */           mhit += card.getAddMagicHit();
/* 127 */           mr += card.getAddMr();
/* 128 */           f += card.getAddFire();
/* 129 */           wind += card.getAddWind();
/* 130 */           e += card.getAddEarth();
/* 131 */           w += card.getAddWater();
/*     */         } 
/* 133 */         i++;
/*     */       } 
/* 135 */       i = 0;
/* 136 */       while (i <= CardSetTable.get().CardCardSize()) {
/* 137 */         CardPolySet cards = CardSetTable.get().getCard(i);
/* 138 */         if (cards != null && pc.getQuest().get_step(cards.getQuestId()) != 0) {
/* 139 */           str += cards.getAddStr();
/* 140 */           dex += cards.getAddDex();
/* 141 */           con += cards.getAddCon();
/* 142 */           Int += cards.getAddInt();
/* 143 */           wis += cards.getAddWis();
/* 144 */           cha += cards.getAddCha();
/* 145 */           ac += cards.getAddAc();
/* 146 */           hp += cards.getAddHp();
/* 147 */           mp += cards.getAddMp();
/* 148 */           hpr += cards.getAddHpr();
/* 149 */           mpr += cards.getAddMpr();
/* 150 */           dmg += cards.getAddDmg();
/* 151 */           bdmg += cards.getAddBowDmg();
/* 152 */           hit += cards.getAddHit();
/* 153 */           bhit += cards.getAddBowHit();
/* 154 */           dr += cards.getAddDmgR();
/* 155 */           mdr += cards.getAddMagicDmgR();
/* 156 */           sp += cards.getAddSp();
/* 157 */           mhit += cards.getAddMagicHit();
/* 158 */           mr += cards.getAddMr();
/* 159 */           f += cards.getAddFire();
/* 160 */           wind += cards.getAddWind();
/* 161 */           e += cards.getAddEarth();
/* 162 */           w += cards.getAddWater();
/*     */         } 
/* 164 */         i++;
/*     */       } 
/* 166 */       StringBuilder stringBuilder = new StringBuilder();
/* 167 */       stringBuilder.append("力量 +" + str + ",");
/* 168 */       stringBuilder.append("敏捷 +" + dex + ",");
/* 169 */       stringBuilder.append("體質 +" + con + ",");
/* 170 */       stringBuilder.append("智力 +" + Int + ",");
/* 171 */       stringBuilder.append("精神 +" + wis + ",");
/* 172 */       stringBuilder.append("魅力 +" + cha + ",");
/* 173 */       stringBuilder.append("防禦提升 +" + ac + ",");
/* 174 */       stringBuilder.append("HP +" + hp + ",");
/* 175 */       stringBuilder.append("MP +" + mp + ",");
/* 176 */       stringBuilder.append("血量回復 +" + hpr + ",");
/* 177 */       stringBuilder.append("魔力回復 +" + mpr + ",");
/* 178 */       stringBuilder.append("近距離傷害 +" + dmg + ",");
/* 179 */       stringBuilder.append("遠距離傷害 +" + bdmg + ",");
/* 180 */       stringBuilder.append("近距離命中 +" + hit + ",");
/* 181 */       stringBuilder.append("遠距離命中 +" + bhit + ",");
/* 182 */       stringBuilder.append("物理傷害減免 +" + dr + ",");
/* 183 */       stringBuilder.append("魔法傷害減免 +" + mdr + ",");
/* 184 */       stringBuilder.append("魔攻 +" + sp + ",");
/* 185 */       stringBuilder.append("魔法命中 +" + mhit + ",");
/* 186 */       stringBuilder.append("魔法防禦 +" + mr + ",");
/* 187 */       stringBuilder.append("火屬性防禦 +" + f + ",");
/* 188 */       stringBuilder.append("風屬性防禦 +" + wind + ",");
/* 189 */       stringBuilder.append("地屬性防禦 +" + e + ",");
/* 190 */       stringBuilder.append("水屬性防禦 +" + w + ",");
/* 191 */       String[] clientStrAry = stringBuilder.toString().split(",");
/* 192 */       pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "card_11", clientStrAry));
/* 193 */     } catch (Exception e2) {
/* 194 */       _log.error(e2.getLocalizedMessage(), e2);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void CardSet(L1PcInstance pc) {
/*     */     try {
/* 200 */       StringBuilder stringBuilder = new StringBuilder();
/* 201 */       int i = 0;
/* 202 */       while (i <= CardSetTable.get().CardCardSize()) {
/* 203 */         CardPolySet cards = CardSetTable.get().getCard(i);
/* 204 */         if (cards != null) {
/* 205 */           stringBuilder.append(String.valueOf(String.valueOf(cards.getMsg1())) + ",");
/* 206 */           int k = 0;
/* 207 */           int j = 0;
/* 208 */           while (j < (cards.getNeedQuest()).length) {
/* 209 */             if (pc.getQuest().get_step(cards.getNeedQuest()[j]) != 0) {
/* 210 */               stringBuilder.append(String.valueOf(String.valueOf(cards.getNeedName()[j])) + "(登入),");
/* 211 */               k++;
/*     */             } else {
/* 213 */               stringBuilder.append(String.valueOf(String.valueOf(cards.getNeedName()[j])) + "(未登),");
/*     */             } 
/* 215 */             j++;
/*     */           } 
/* 217 */           if (k == (cards.getNeedQuest()).length) {
/* 218 */             if (cards.getAddStr() != 0) {
/* 219 */               stringBuilder.append("力量 +" + cards.getAddStr() + ",");
/*     */             }
/* 221 */             if (cards.getAddDex() != 0) {
/* 222 */               stringBuilder.append("敏捷 +" + cards.getAddDex() + ",");
/*     */             }
/* 224 */             if (cards.getAddCon() != 0) {
/* 225 */               stringBuilder.append("體質 +" + cards.getAddCon() + ",");
/*     */             }
/* 227 */             if (cards.getAddInt() != 0) {
/* 228 */               stringBuilder.append("智力 +" + cards.getAddInt() + ",");
/*     */             }
/* 230 */             if (cards.getAddWis() != 0) {
/* 231 */               stringBuilder.append("精神 +" + cards.getAddWis() + ",");
/*     */             }
/* 233 */             if (cards.getAddCha() != 0) {
/* 234 */               stringBuilder.append("魅力 +" + cards.getAddCha() + ",");
/*     */             }
/* 236 */             if (cards.getAddAc() != 0) {
/* 237 */               stringBuilder.append("防禦提升 +" + cards.getAddAc() + ",");
/*     */             }
/* 239 */             if (cards.getAddHp() != 0) {
/* 240 */               stringBuilder.append("HP +" + cards.getAddHp() + ",");
/*     */             }
/* 242 */             if (cards.getAddMp() != 0) {
/* 243 */               stringBuilder.append("MP +" + cards.getAddMp() + ",");
/*     */             }
/* 245 */             if (cards.getAddHpr() != 0) {
/* 246 */               stringBuilder.append("血量回復 +" + cards.getAddHpr() + ",");
/*     */             }
/* 248 */             if (cards.getAddMpr() != 0) {
/* 249 */               stringBuilder.append("魔力回復 +" + cards.getAddMpr() + ",");
/*     */             }
/* 251 */             if (cards.getAddDmg() != 0) {
/* 252 */               stringBuilder.append("近距離傷害 +" + cards.getAddDmg() + ",");
/*     */             }
/* 254 */             if (cards.getAddBowDmg() != 0) {
/* 255 */               stringBuilder.append("遠距離傷害 +" + cards.getAddBowDmg() + ",");
/*     */             }
/* 257 */             if (cards.getAddHit() != 0) {
/* 258 */               stringBuilder.append("近距離命中 +" + cards.getAddHit() + ",");
/*     */             }
/* 260 */             if (cards.getAddBowHit() != 0) {
/* 261 */               stringBuilder.append("遠距離命中 +" + cards.getAddBowHit() + ",");
/*     */             }
/* 263 */             if (cards.getAddDmgR() != 0) {
/* 264 */               stringBuilder.append("物理傷害減免 +" + cards.getAddDmgR() + ",");
/*     */             }
/* 266 */             if (cards.getAddMagicDmgR() != 0) {
/* 267 */               stringBuilder.append("魔法傷害減免 +" + cards.getAddMagicDmgR() + ",");
/*     */             }
/* 269 */             if (cards.getAddSp() != 0) {
/* 270 */               stringBuilder.append("魔攻 +" + cards.getAddSp() + ",");
/*     */             }
/* 272 */             if (cards.getAddMagicHit() != 0) {
/* 273 */               stringBuilder.append("魔法命中 +" + cards.getAddMagicHit() + ",");
/*     */             }
/* 275 */             if (cards.getAddMr() != 0) {
/* 276 */               stringBuilder.append("魔法防禦 +" + cards.getAddMr() + ",");
/*     */             }
/* 278 */             if (cards.getAddFire() != 0) {
/* 279 */               stringBuilder.append("火屬性防禦 +" + cards.getAddFire() + ",");
/*     */             }
/* 281 */             if (cards.getAddWind() != 0) {
/* 282 */               stringBuilder.append("風屬性防禦 +" + cards.getAddWind() + ",");
/*     */             }
/* 284 */             if (cards.getAddEarth() != 0) {
/* 285 */               stringBuilder.append("地屬性防禦 +" + cards.getAddEarth() + ",");
/*     */             }
/* 287 */             if (cards.getAddWater() != 0) {
/* 288 */               stringBuilder.append("水屬性防禦 +" + cards.getAddWater() + ",");
/*     */             }
/* 290 */             stringBuilder.append("<以上為此套卡能力加成>,");
/*     */           } 
/*     */         } 
/* 293 */         i++;
/*     */       } 
/* 295 */       String[] clientStrAry = stringBuilder.toString().split(",");
/* 296 */       pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "card_10", clientStrAry));
/* 297 */     } catch (Exception e) {
/* 298 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean PolyCmd(L1PcInstance pc, String cmd) {
/*     */     try {
/* 304 */       boolean ok = false;
/* 305 */       StringBuilder stringBuilder = new StringBuilder();
/* 306 */       int i = 0;
/* 307 */       while (i <= ACardTable.get().ACardSize()) {
/* 308 */         ACard card = ACardTable.get().getCard(i);
/* 309 */         if (card != null && cmd.equals(card.getCmd())) {
/* 310 */           pc.setCarId(i);
/* 311 */           stringBuilder.append(String.valueOf(String.valueOf(card.getMsg2())) + ",");
/* 312 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddStr())) + ",");
/* 313 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddDex())) + ",");
/* 314 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddCon())) + ",");
/* 315 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddInt())) + ",");
/* 316 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddWis())) + ",");
/* 317 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddCha())) + ",");
/* 318 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddAc())) + ",");
/* 319 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddHp())) + ",");
/* 320 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddMp())) + ",");
/* 321 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddHpr())) + ",");
/* 322 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddMpr())) + ",");
/* 323 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddDmg())) + ",");
/* 324 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddBowDmg())) + ",");
/* 325 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddHit())) + ",");
/* 326 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddBowHit())) + ",");
/* 327 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddDmgR())) + ",");
/* 328 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddMagicDmgR())) + ",");
/* 329 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddSp())) + ",");
/* 330 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddMagicHit())) + ",");
/* 331 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddMr())) + ",");
/* 332 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddFire())) + ",");
/* 333 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddWind())) + ",");
/* 334 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddEarth())) + ",");
/* 335 */           stringBuilder.append(String.valueOf(String.valueOf(card.getAddWater())) + ",");
/* 336 */           if (pc.getQuest().get_step(card.getQuestId()) != 0) {
/* 337 */             stringBuilder.append("[已存入],");
/*     */           } else {
/* 339 */             stringBuilder.append("未偵測[存入],");
/*     */           } 
/* 341 */           String[] clientStrAry = stringBuilder.toString().split(",");
/* 342 */           pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "card_0", clientStrAry));
/* 343 */           ok = true;
/*     */           break;
/*     */         } 
/* 346 */         i++;
/*     */       } 
/* 348 */       if (ok) {
/* 349 */         return true;
/*     */       }
/* 351 */     } catch (Exception e) {
/* 352 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/* 354 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\system\CardBookCmd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */