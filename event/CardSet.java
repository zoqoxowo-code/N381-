/*     */ package com.lineage.data.event;
/*     */ 
/*     */ import com.lineage.data.executor.EventExecutor;
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.serverpackets.S_HPUpdate;
/*     */ import com.lineage.server.serverpackets.S_MPUpdate;
/*     */ import com.lineage.server.serverpackets.S_OwnCharStatus;
/*     */ import com.lineage.server.serverpackets.S_SPMR;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.templates.L1Event;
/*     */ import java.util.Iterator;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CardSet
/*     */   extends EventExecutor
/*     */ {
/*  24 */   private static final Log _log = LogFactory.getLog(CardSet.class);
/*     */   public static boolean START = false;
/*     */   public static int USE_TIME;
/*     */   
/*     */   public static EventExecutor get() {
/*  29 */     return new CardSet();
/*     */   }
/*     */   public static int USE_TIME2; public static int USE_TIME3;
/*     */   
/*     */   public void execute(L1Event event) {
/*     */     try {
/*  35 */       START = true;
/*  36 */       String[] set = event.get_eventother().split(",");
/*     */       try {
/*  38 */         USE_TIME = Integer.parseInt(set[0]);
/*  39 */       } catch (Exception e2) {
/*  40 */         USE_TIME = 720;
/*  41 */         _log.error("未設定月卡使用期限(使用預設720小時)");
/*     */       } 
/*     */       try {
/*  44 */         USE_TIME2 = Integer.parseInt(set[1]);
/*  45 */       } catch (Exception e2) {
/*  46 */         USE_TIME2 = 24;
/*  47 */         _log.error("未設定日卡使用期限(使用預設24小時)");
/*     */       } 
/*     */       try {
/*  50 */         USE_TIME3 = Integer.parseInt(set[2]);
/*  51 */       } catch (Exception e2) {
/*  52 */         USE_TIME3 = 1;
/*  53 */         _log.error("未設定日卡使用期限(使用預設1小時)");
/*     */       } 
/*  55 */     } catch (Exception e) {
/*  56 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void load_card_mode(L1PcInstance pc) {
/*     */     try {
/*  62 */       Iterator<L1ItemInstance> iterator = pc.getInventory().getItems().iterator();
/*  63 */       while (iterator.hasNext()) {
/*  64 */         L1ItemInstance item = iterator.next();
/*  65 */         String classname = item.getItem().getclassname();
/*  66 */         if (classname.startsWith("shop.VIP_Card_")) {
/*  67 */           if (item.get_card_use() != 1) {
/*  68 */             item.setEquipped(false); continue;
/*     */           } 
/*  70 */           int card_id = 0;
/*     */           try {
/*  72 */             String cardmode = classname.substring(14);
/*  73 */             card_id = Integer.parseInt(cardmode);
/*  74 */           } catch (Exception e2) {
/*  75 */             String cardmode2 = classname.substring(15);
/*  76 */             card_id = Integer.parseInt(cardmode2);
/*     */           } 
/*  78 */           if (card_id == 0) {
/*     */             return;
/*     */           }
/*  81 */           item.setEquipped(true);
/*  82 */           switch (card_id) {
/*     */             case 1:
/*  84 */               pc.set_VIP1(true);
/*  85 */               pc.addDmgup(3);
/*  86 */               pc.addHitup(2);
/*  87 */               pc.addBowDmgup(3);
/*  88 */               pc.addBowHitup(2);
/*  89 */               pc.addSp(2);
/*  90 */               pc.addMaxHp(200);
/*  91 */               pc.addMaxMp(100);
/*  92 */               pc.setCurrentHp(pc.getCurrentHp() + 200);
/*  93 */               pc.setCurrentMp(pc.getCurrentMp() + 100);
/*  94 */               pc.addStr(1);
/*  95 */               pc.addDex(1);
/*  96 */               pc.addCon(1);
/*  97 */               pc.addWis(1);
/*  98 */               pc.addInt(1);
/*  99 */               pc.addCha(1);
/* 100 */               pc.addRegistStun(3);
/* 101 */               pc.add_regist_freeze(3);
/* 102 */               pc.addRegistStone(3);
/* 103 */               pc.addRegistSleep(3);
/* 104 */               pc.addRegistSustain(3);
/* 105 */               pc.addRegistBlind(3);
/*     */               break;
/*     */             
/*     */             case 2:
/* 109 */               pc.set_VIP2(true);
/* 110 */               pc.add_exp(50);
/* 111 */               pc.addHpr(10);
/* 112 */               pc.addMpr(5);
/* 113 */               pc.addStr(1);
/* 114 */               pc.addDex(1);
/* 115 */               pc.addCon(1);
/* 116 */               pc.addWis(1);
/* 117 */               pc.addInt(1);
/* 118 */               pc.addCha(1);
/*     */               break;
/*     */             
/*     */             case 3:
/* 122 */               pc.set_VIP3(true);
/* 123 */               pc.add_exp(30);
/* 124 */               pc.addStr(2);
/* 125 */               pc.addDex(2);
/* 126 */               pc.addCon(2);
/* 127 */               pc.addWis(2);
/* 128 */               pc.addInt(2);
/* 129 */               pc.addCha(2);
/*     */               break;
/*     */             
/*     */             case 4:
/* 133 */               pc.add_exp(100);
/*     */               break;
/*     */             
/*     */             case 5:
/* 137 */               pc.add_exp(100);
/*     */               break;
/*     */           } 
/*     */           
/* 141 */           pc.sendPackets((ServerBasePacket)new S_OwnCharStatus(pc));
/* 142 */           pc.sendPackets((ServerBasePacket)new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
/* 143 */           pc.sendPackets((ServerBasePacket)new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
/* 144 */           pc.sendPackets((ServerBasePacket)new S_SPMR(pc));
/*     */         }
/*     */       
/*     */       } 
/* 148 */     } catch (Exception e) {
/* 149 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void set_card_mode(L1PcInstance pc, L1ItemInstance item) {
/* 154 */     if (!START) {
/*     */       return;
/*     */     }
/*     */     try {
/* 158 */       String classname = item.getItem().getclassname();
/* 159 */       if (!classname.startsWith("shop.VIP_Card_")) {
/*     */         return;
/*     */       }
/* 162 */       int card_id = 0;
/*     */       try {
/* 164 */         String cardmode = classname.substring(14);
/* 165 */         card_id = Integer.parseInt(cardmode);
/* 166 */       } catch (Exception e2) {
/* 167 */         String cardmode2 = classname.substring(15);
/* 168 */         card_id = Integer.parseInt(cardmode2);
/*     */       } 
/* 170 */       if (card_id == 0) {
/*     */         return;
/*     */       }
/* 173 */       item.setEquipped(true);
/* 174 */       switch (card_id) {
/*     */         case 1:
/* 176 */           pc.set_VIP1(true);
/* 177 */           pc.addDmgup(3);
/* 178 */           pc.addHitup(2);
/* 179 */           pc.addBowDmgup(3);
/* 180 */           pc.addBowHitup(2);
/* 181 */           pc.addSp(2);
/* 182 */           pc.addMaxHp(200);
/* 183 */           pc.addMaxMp(100);
/* 184 */           pc.addStr(1);
/* 185 */           pc.addDex(1);
/* 186 */           pc.addCon(1);
/* 187 */           pc.addWis(1);
/* 188 */           pc.addInt(1);
/* 189 */           pc.addCha(1);
/* 190 */           pc.addRegistStun(3);
/* 191 */           pc.add_regist_freeze(3);
/* 192 */           pc.addRegistStone(3);
/* 193 */           pc.addRegistSleep(3);
/* 194 */           pc.addRegistSustain(3);
/* 195 */           pc.addRegistBlind(3);
/*     */           break;
/*     */         
/*     */         case 2:
/* 199 */           pc.set_VIP2(true);
/* 200 */           pc.add_exp(50);
/* 201 */           pc.addHpr(10);
/* 202 */           pc.addMpr(5);
/* 203 */           pc.addStr(1);
/* 204 */           pc.addDex(1);
/* 205 */           pc.addCon(1);
/* 206 */           pc.addWis(1);
/* 207 */           pc.addInt(1);
/* 208 */           pc.addCha(1);
/*     */           break;
/*     */         
/*     */         case 3:
/* 212 */           pc.set_VIP3(true);
/* 213 */           pc.add_exp(30);
/* 214 */           pc.addStr(2);
/* 215 */           pc.addDex(2);
/* 216 */           pc.addCon(2);
/* 217 */           pc.addWis(2);
/* 218 */           pc.addInt(2);
/* 219 */           pc.addCha(2);
/*     */           break;
/*     */         
/*     */         case 4:
/* 223 */           pc.add_exp(100);
/*     */           break;
/*     */         
/*     */         case 5:
/* 227 */           pc.add_exp(100);
/*     */           break;
/*     */       } 
/*     */       
/* 231 */       pc.sendPackets((ServerBasePacket)new S_OwnCharStatus(pc));
/* 232 */       pc.sendPackets((ServerBasePacket)new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
/* 233 */       pc.sendPackets((ServerBasePacket)new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
/* 234 */       pc.sendPackets((ServerBasePacket)new S_SPMR(pc));
/* 235 */     } catch (Exception e) {
/* 236 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void remove_card_mode(L1PcInstance pc, L1ItemInstance item) {
/* 241 */     if (!START) {
/*     */       return;
/*     */     }
/*     */     try {
/* 245 */       String classname = item.getItem().getclassname();
/* 246 */       if (!classname.startsWith("shop.VIP_Card_")) {
/*     */         return;
/*     */       }
/* 249 */       int card_id = 0;
/*     */       try {
/* 251 */         String cardmode = classname.substring(14);
/* 252 */         card_id = Integer.parseInt(cardmode);
/* 253 */       } catch (Exception e2) {
/* 254 */         String cardmode2 = classname.substring(15);
/* 255 */         card_id = Integer.parseInt(cardmode2);
/*     */       } 
/* 257 */       if (card_id == 0) {
/*     */         return;
/*     */       }
/* 260 */       item.setEquipped(false);
/* 261 */       switch (card_id) {
/*     */         case 1:
/* 263 */           pc.set_VIP1(false);
/* 264 */           pc.addDmgup(-3);
/* 265 */           pc.addHitup(-2);
/* 266 */           pc.addBowDmgup(-3);
/* 267 */           pc.addBowHitup(-2);
/* 268 */           pc.addSp(-2);
/* 269 */           pc.addMaxHp(-200);
/* 270 */           pc.addMaxMp(-100);
/* 271 */           pc.addStr(-1);
/* 272 */           pc.addDex(-1);
/* 273 */           pc.addCon(-1);
/* 274 */           pc.addWis(-1);
/* 275 */           pc.addInt(-1);
/* 276 */           pc.addCha(-1);
/* 277 */           pc.addRegistStun(-3);
/* 278 */           pc.add_regist_freeze(-3);
/* 279 */           pc.addRegistStone(-3);
/* 280 */           pc.addRegistSleep(-3);
/* 281 */           pc.addRegistSustain(-3);
/* 282 */           pc.addRegistBlind(-3);
/*     */           break;
/*     */         
/*     */         case 2:
/* 286 */           pc.set_VIP2(false);
/* 287 */           pc.add_exp(-50);
/* 288 */           pc.addHpr(-10);
/* 289 */           pc.addMpr(-5);
/* 290 */           pc.addStr(-1);
/* 291 */           pc.addDex(-1);
/* 292 */           pc.addCon(-1);
/* 293 */           pc.addWis(-1);
/* 294 */           pc.addInt(-1);
/* 295 */           pc.addCha(-1);
/*     */           break;
/*     */         
/*     */         case 3:
/* 299 */           pc.set_VIP3(false);
/* 300 */           pc.add_exp(-30);
/* 301 */           pc.addStr(-2);
/* 302 */           pc.addDex(-2);
/* 303 */           pc.addCon(-2);
/* 304 */           pc.addWis(-2);
/* 305 */           pc.addInt(-2);
/* 306 */           pc.addCha(-2);
/*     */           break;
/*     */         
/*     */         case 4:
/* 310 */           pc.add_exp(-100);
/*     */           break;
/*     */         
/*     */         case 5:
/* 314 */           pc.add_exp(-100);
/*     */           break;
/*     */       } 
/*     */       
/* 318 */       pc.sendPackets((ServerBasePacket)new S_OwnCharStatus(pc));
/* 319 */       pc.sendPackets((ServerBasePacket)new S_SPMR(pc));
/* 320 */     } catch (Exception e) {
/* 321 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\CardSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */