/*     */ package com.lineage.config;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.Properties;
/*     */ import java.util.StringTokenizer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ConfigOther
/*     */ {
/*     */   private static final String LIANG = "./config/other.properties";
/*     */   public static int SHOCK_STUN_OVERLAY;
/*     */   public static int Lost_Item_high;
/*     */   public static int Lost_Item_Low;
/*     */   public static int Lost_Item_Count;
/*     */   public static int Lost_Item_Rnd;
/*     */   public static int Lost_Item_high_2;
/*     */   public static int Lost_Item_Low_2;
/*     */   public static int Lost_Item_Count_2;
/*     */   public static int Lost_Item_Rnd_2;
/*     */   public static int Lost_Item_high_3;
/*     */   public static int Lost_Item_Low_3;
/*     */   public static int Lost_Item_Count_3;
/*     */   public static int Lost_Item_Rnd_3;
/*     */   public static int Lost_Item_high_4;
/*     */   public static int Lost_Item_Low_4;
/*     */   public static int Lost_Item_Count_4;
/*     */   public static int Lost_Item_Rnd_4;
/*     */   public static int Lost_Item_high_5;
/*     */   public static int Lost_Item_Low_5;
/*     */   public static int Lost_Item_Count_5;
/*     */   public static int Lost_Item_Rnd_5;
/*     */   public static int Lost_Item_high_6;
/*     */   public static int Lost_Item_Low_6;
/*     */   public static int Lost_Item_Count_6;
/*     */   public static int Lost_Item_Rnd_6;
/*     */   public static int Lost_Item_high_7;
/*     */   public static int Lost_Item_Low_7;
/*     */   public static int Lost_Item_Count_7;
/*     */   public static int Lost_Item_Rnd_7;
/*     */   public static int Lost_Item_high_8;
/*     */   public static int Lost_Item_Low_8;
/*     */   public static int Lost_Item_Count_8;
/*     */   public static int Lost_Item_Rnd_8;
/*     */   public static int Lost_Skill_high;
/*     */   public static int Lost_Skill_Low;
/*     */   public static int Lost_Skill_Count;
/*     */   public static int Lost_Skill_Rnd;
/*     */   public static int Lost_Skill_high_2;
/*     */   public static int Lost_Skill_Low_2;
/*     */   public static int Lost_Skill_Count_2;
/*     */   public static int Lost_Skill_Rnd_2;
/*     */   public static int Lost_Skill_high_3;
/*     */   public static int Lost_Skill_Low_3;
/*     */   public static int Lost_Skill_Count_3;
/*     */   public static int Lost_Skill_Rnd_3;
/*     */   public static int Lost_Skill_high_4;
/*     */   public static int Lost_Skill_Low_4;
/*     */   public static int Lost_Skill_Count_4;
/*     */   public static int Lost_Skill_Rnd_4;
/*     */   public static int Lost_Skill_high_5;
/*     */   public static int Lost_Skill_Low_5;
/*     */   public static int Lost_Skill_Count_5;
/*     */   public static int Lost_Skill_Rnd_5;
/*     */   public static int Lost_Skill_high_6;
/*     */   public static int Lost_Skill_Low_6;
/*     */   public static int Lost_Skill_Count_6;
/*     */   public static int Lost_Skill_Rnd_6;
/*     */   public static int Lost_Skill_high_7;
/*     */   public static int Lost_Skill_Low_7;
/*     */   public static int Lost_Skill_Count_7;
/*     */   public static int Lost_Skill_Rnd_7;
/*     */   public static int Lost_Skill_high_8;
/*     */   public static int Lost_Skill_Low_8;
/*     */   public static int Lost_Skill_Count_8;
/*     */   public static int Lost_Skill_Rnd_8;
/*     */   public static int Lost_Item;
/*     */   public static int Lost_Count_1;
/*     */   public static int Lost_Count_2;
/*     */   public static int Lost_Item2;
/*     */   public static int Lost_Count2_1;
/*     */   public static int Lost_Count2_2;
/*     */   public static int ExpRateLost;
/*     */   public static int LostItem_ON;
/*     */   public static int LostItem2_ON;
/*     */   public static boolean ALT_GM_HIDE;
/*     */   public static int Call_party_itemid;
/*     */   public static int Call_party_count;
/*     */   public static int target_party_itemid;
/*     */   public static int target_party_count;
/*     */   public static String clanmsg5;
/*     */   public static String clanmsg6;
/*     */   public static int pcdmgpet;
/*     */   public static int pcdmgsumm;
/*     */   public static int petcountchatype;
/*     */   public static int petcountchatype1;
/*     */   public static int tamingmonstercount;
/*     */   public static int summmonstercount;
/*     */   public static boolean summoncountcha;
/*     */   public static boolean petcountcha;
/* 114 */   public static double petdmgother = 0.0D;
/* 115 */   public static double summondmgother = 0.0D;
/*     */   public static boolean war_pet_summ;
/*     */   public static double petdmgotherpc_war;
/*     */   public static double summondmgotherpc_war;
/*     */   public static double pcdmgpet_war;
/*     */   public static double pcdmgsumm_war;
/* 121 */   public static double petdmgotherpc = 0.0D;
/* 122 */   public static double summondmgotherpc = 0.0D;
/*     */   public static boolean Quitgameshop = false;
/*     */   public static int recaseff;
/*     */   public static int recaseffcount;
/*     */   public static int PcLevelUp;
/*     */   public static boolean Pickupitemtoall = false;
/*     */   public static boolean DropitemMsgall = false;
/*     */   public static int PetLevelUp;
/*     */   public static boolean AllCall_clan_Crown;
/*     */   public static int Call_alliance_itemid;
/*     */   public static int Call_alliance_count;
/*     */   public static int Call_clan_itemid;
/*     */   public static int Call_clan_count;
/*     */   public static int target_clan_itemid;
/*     */   public static int target_clan_count;
/*     */   public static String alliancemsg;
/*     */   public static String alliancemsg1;
/*     */   public static String alliancemsg2;
/*     */   public static String clanmsg;
/*     */   public static String partymsg;
/*     */   public static String clanmsg1;
/*     */   public static String clanmsg2;
/*     */   public static boolean Reset_Map;
/*     */   public static int Reset_Map_Time;
/*     */   public static boolean SPEED = false;
/* 147 */   public static double SPEED_TIME = 1.0D;
/* 148 */   public static double IMMUNE_TO_HARM = 1.0D;
/* 149 */   public static double IMMUNE_TO_HARM_NPC = 1.0D;
/*     */   public static int CharNamebyte;
/*     */   public static int CharNameEnbyte;
/*     */   public static boolean KILLRED = true;
/*     */   public static boolean IS_CHECK = false;
/*     */   public static boolean dropcolor = true;
/*     */   public static boolean CLANDEL;
/*     */   public static boolean CLANTITLE;
/*     */   public static int SCLANCOUNT;
/*     */   public static int dead_score;
/*     */   public static boolean LIGHT;
/*     */   public static boolean HPBAR;
/*     */   public static boolean SHOPINFO;
/*     */   public static int CASTLEHPR;
/*     */   public static int CASTLEMPR;
/*     */   public static int FORESTHPR;
/*     */   public static int FORESTMPR;
/*     */   public static boolean WAR_DOLL;
/*     */   public static int SET_GLOBAL;
/*     */   public static int SET_GLOBAL_COUNT;
/*     */   public static int SET_GLOBAL_TIME;
/*     */   public static int SET_SHOUT_TIME;
/*     */   public static int ENCOUNTER_LV;
/*     */   public static int ILLEGAL_SPEEDUP_PUNISHMENT;
/*     */   public static String CreateCharInfo;
/*     */   public static boolean WHO_ONLINE_MSG_ON;
/*     */   public static int[] NEW_CHAR_LOC;
/*     */   public static int[] AtkNo;
/*     */   public static int[] AtkNo_pc;
/*     */   public static int[] WAR_DISABLE_SKILLS;
/*     */   public static int[] WAR_DISABLE_ITEM;
/*     */   public static int[] MAP_IDSKILL;
/*     */   public static int[] MAP_SKILL;
/*     */   public static int[] MAP_IDITEM;
/*     */   public static int[] MAP_ITEM;
/*     */   public static int drainedMana;
/*     */   public static boolean newcharpra;
/*     */   public static int newcharpralv;
/*     */   public static int summtime;
/*     */   public static boolean logpcpower;
/*     */   public static int armor_type1;
/*     */   public static int armor_type2;
/*     */   public static int armor_type3;
/*     */   public static int armor_type4;
/*     */   public static int armor_type5;
/*     */   public static int armor_type6;
/*     */   public static int armor_type7;
/*     */   public static int armor_type8;
/*     */   public static int armor_type9;
/*     */   public static int armor_type10;
/*     */   public static int armor_type11;
/*     */   public static int armor_type12;
/*     */   public static int armor_type13;
/*     */   public static int armor_type14;
/*     */   public static int armor_type15;
/*     */   public static int armor_type16;
/*     */   public static int armor_type17;
/*     */   public static int armor_type18;
/*     */   public static int armor_type19;
/*     */   public static int armor_type20;
/*     */   public static int armor_type21;
/*     */   public static int armor_type22;
/*     */   public static int armor_type23;
/*     */   public static int armor_type24;
/*     */   public static int armor_type25;
/*     */   public static int Attack_1;
/*     */   public static int Attack_2;
/*     */   public static int Attack_3;
/*     */   public static int Attack_4;
/*     */   public static int Attack_5;
/*     */   public static int Attack_Miss;
/*     */   public static int NeedItem;
/*     */   public static int NeedItemCount;
/*     */   public static String Msg;
/*     */   public static String ItemMsg;
/*     */   public static int NeedItem1;
/*     */   public static int NeedItemCount1;
/*     */   public static String Msg1;
/*     */   public static String ItemMsg1;
/*     */   public static int[] Give_skill;
/*     */   public static int[] Give_skill1;
/*     */   public static int NeedItem2;
/*     */   public static int NeedItemCount2;
/*     */   public static String Msg2;
/*     */   public static String ItemMsg2;
/*     */   public static int[] Give_skill2;
/*     */   public static int TextMinPlayer;
/*     */   public static int TextMaxPlayer;
/*     */   public static int TextLevel;
/*     */   public static int tcheckitem;
/*     */   public static int TextMoney;
/*     */   public static int Textnpa1;
/*     */   public static int Textnpa2;
/*     */   public static int Textnpa3;
/*     */   public static int Textnpa4;
/*     */   public static int Textnpa5;
/*     */   public static int Textnpa6;
/*     */   public static int Textnpa7;
/*     */   public static int Textnpa8;
/*     */   public static int Textnpa9;
/*     */   public static int Textnpa10;
/*     */   public static boolean RankLevel = false;
/* 251 */   public static int day_level = 40;
/* 252 */   public static int restday = 18;
/*     */   public static boolean Illusionistpc = false;
/*     */   public static boolean DragonKnightpc = false;
/* 255 */   public static int clancount = 3;
/* 256 */   public static int clancountexp = 10;
/* 257 */   public static int clanLeaderlv = 45;
/*     */   public static boolean warProtector = true;
/*     */   public static boolean restsavepclog = true;
/*     */   public static int checkitem76;
/*     */   public static int checkitemcount76;
/*     */   public static int checkitem81;
/*     */   public static int checkitemcount81;
/*     */   public static int checkitem59;
/*     */   public static int checkitemcount59;
/* 266 */   public static int monbossitem = 40308;
/* 267 */   public static int monbossitemcount = 10000;
/* 268 */   public static int montime = 40;
/* 269 */   public static int monsec = 18;
/* 270 */   public static int killmsg = 1;
/* 271 */   public static int dropmsg = 1;
/* 272 */   public static int boxsmsg = 1;
/* 273 */   public static int killlevel = 40;
/*     */   public static boolean logpcgiveitem;
/*     */   public static int logpclevel;
/*     */   public static int logpcresthp;
/*     */   public static int logpcrestmp;
/*     */   public static boolean logpcallmsg;
/*     */   public static int logpctfcount;
/*     */   public static boolean onlydaypre;
/*     */   public static int onlydaytime;
/*     */   public static int dateStartTime;
/*     */   public static int dollcount;
/*     */   public static int dollcount1;
/*     */   public static int petlevel;
/*     */   public static int petexp;
/*     */   public static int giftset;
/*     */   public static boolean partyexp;
/*     */   public static double partyexp1;
/*     */   public static int partycount;
/*     */   public static int warehouselevel;
/* 292 */   public static int shopitemrest = 0;
/*     */   
/*     */   public static int tradelevel;
/*     */   
/*     */   public static boolean npclevlecolor;
/*     */   
/*     */   public static int Scarecrowlevel;
/*     */   
/*     */   public static int FAFURION_RANDOM_6;
/*     */   
/*     */   public static int FAFURION_MIN_6;
/*     */   
/*     */   public static int FAFURION_MAX_6;
/*     */   
/*     */   public static int FAFURION_RANDOM_7;
/*     */   
/*     */   public static int FAFURION_MIN_7;
/*     */   
/*     */   public static int FAFURION_MAX_7;
/*     */   
/*     */   public static int FAFURION_RANDOM_8;
/*     */   
/*     */   public static int FAFURION_MIN_8;
/*     */   
/*     */   public static int FAFURION_MAX_8;
/*     */   
/*     */   public static int FAFURION_RANDOM_9;
/*     */   public static int FAFURION_MIN_9;
/*     */   public static int FAFURION_MAX_9;
/*     */   public static int VALAKAS_DMG_6;
/*     */   public static int VALAKAS_BOWDMG_6;
/*     */   public static int VALAKAS_DMG_7;
/*     */   public static int VALAKAS_BOWDMG_7;
/*     */   public static int VALAKAS_DMG_8;
/*     */   public static int VALAKAS_BOWDMG_8;
/*     */   public static int VALAKAS_DMG_9;
/*     */   public static int VALAKAS_BOWDMG_9;
/*     */   public static int ANTHARAS_DMGR_6;
/*     */   public static int ANTHARAS_DMGR_7;
/*     */   public static int ANTHARAS_DMGR_8;
/*     */   public static int ANTHARAS_DMGR_9;
/*     */   public static int LINDVIOR_RANDOM_6;
/*     */   public static int LINDVIOR_MIN_6;
/*     */   public static int LINDVIOR_MAX_6;
/*     */   public static int LINDVIOR_RANDOM_7;
/*     */   public static int LINDVIOR_MIN_7;
/*     */   public static int LINDVIOR_MAX_7;
/*     */   public static int LINDVIOR_RANDOM_8;
/*     */   public static int LINDVIOR_MIN_8;
/*     */   public static int LINDVIOR_MAX_8;
/*     */   public static int LINDVIOR_RANDOM_9;
/*     */   public static int LINDVIOR_MIN_9;
/*     */   public static int LINDVIOR_MAX_9;
/*     */   public static String Item_Price;
/* 346 */   public static Long CALL_ALL_REPLY_SECOND = Long.valueOf(5L);
/*     */   
/*     */   public static void load() throws ConfigErrorException {
/* 349 */     Properties set = new Properties();
/*     */     try {
/* 351 */       InputStream is = new FileInputStream(new File("./config/other.properties"));
/* 352 */       InputStreamReader isr = new InputStreamReader(is, "utf-8");
/* 353 */       set.load(isr);
/* 354 */       is.close();
/* 355 */       ALT_GM_HIDE = Boolean.parseBoolean(set.getProperty("ALT_GM_HIDE", "true"));
/* 356 */       Call_party_itemid = Integer.parseInt(set.getProperty("Call_party_itemid", "10"));
/* 357 */       Call_party_count = Integer.parseInt(set.getProperty("Call_party_count", "10"));
/* 358 */       target_party_itemid = Integer.parseInt(set.getProperty("target_party_itemid", "10"));
/* 359 */       target_party_count = Integer.parseInt(set.getProperty("target_party_count", "10"));
/* 360 */       clanmsg5 = set.getProperty("clanmsg5", "");
/* 361 */       clanmsg6 = set.getProperty("clanmsg6", "");
/* 362 */       pcdmgpet = Integer.parseInt(set.getProperty("pcdmgpet", "100"));
/* 363 */       pcdmgsumm = Integer.parseInt(set.getProperty("pcdmgsumm", "100"));
/* 364 */       petcountchatype = Integer.parseInt(set.getProperty("petcountchatype", "100"));
/* 365 */       petcountchatype1 = Integer.parseInt(set.getProperty("petcountchatype1", "100"));
/* 366 */       tamingmonstercount = Integer.parseInt(set.getProperty("tamingmonstercount", "10"));
/* 367 */       summmonstercount = Integer.parseInt(set.getProperty("summmonstercount", "10"));
/* 368 */       summoncountcha = Boolean.parseBoolean(set.getProperty("summoncountcha", "false"));
/* 369 */       petcountcha = Boolean.parseBoolean(set.getProperty("petcountcha", "false"));
/* 370 */       petdmgother = Double.parseDouble(set.getProperty("petdmgother", "0.0"));
/* 371 */       summondmgother = Double.parseDouble(set.getProperty("summondmgother", "0.0"));
/* 372 */       petdmgotherpc = Double.parseDouble(set.getProperty("petdmgotherpc", "0.0"));
/* 373 */       summondmgotherpc = Double.parseDouble(set.getProperty("summondmgotherpc", "0.0"));
/* 374 */       petdmgotherpc_war = Double.parseDouble(set.getProperty("petdmgotherpc_war", "0.0"));
/* 375 */       summondmgotherpc_war = Double.parseDouble(set.getProperty("summondmgotherpc_war", "0.0"));
/* 376 */       pcdmgpet_war = Double.parseDouble(set.getProperty("pcdmgpet_war", "0.0"));
/* 377 */       pcdmgsumm_war = Double.parseDouble(set.getProperty("pcdmgsumm_war", "0.0"));
/* 378 */       war_pet_summ = Boolean.parseBoolean(set.getProperty("war_pet_summ", "false"));
/* 379 */       Quitgameshop = Boolean.parseBoolean(set.getProperty("Quitgameshop", "false"));
/* 380 */       recaseff = Integer.parseInt(set.getProperty("recaseff", "20"));
/* 381 */       recaseffcount = Integer.parseInt(set.getProperty("recaseffcount", "20"));
/* 382 */       Pickupitemtoall = Boolean.parseBoolean(set.getProperty("Pickupitemtoall", "false"));
/* 383 */       DropitemMsgall = Boolean.parseBoolean(set.getProperty("DropitemMsgall", "false"));
/* 384 */       PcLevelUp = Integer.parseInt(set.getProperty("PcLevelUp", "10"));
/* 385 */       PetLevelUp = Integer.parseInt(set.getProperty("PetLevelUp", "50"));
/* 386 */       AllCall_clan_Crown = Boolean.parseBoolean(set.getProperty("AllCall_clan_Crown", "false"));
/* 387 */       Call_alliance_itemid = Integer.parseInt(set.getProperty("Call_alliance_itemid", "10"));
/* 388 */       Call_alliance_count = Integer.parseInt(set.getProperty("Call_alliance_count", "10"));
/* 389 */       alliancemsg = set.getProperty("alliancemsg", "");
/* 390 */       alliancemsg1 = set.getProperty("alliancemsg1", "");
/* 391 */       alliancemsg2 = set.getProperty("alliancemsg2", "");
/* 392 */       Call_clan_itemid = Integer.parseInt(set.getProperty("Call_clan_itemid", "10"));
/* 393 */       Call_clan_count = Integer.parseInt(set.getProperty("Call_clan_count", "10"));
/* 394 */       target_clan_itemid = Integer.parseInt(set.getProperty("target_clan_itemid", "10"));
/* 395 */       target_clan_count = Integer.parseInt(set.getProperty("target_clan_count", "10"));
/* 396 */       clanmsg = set.getProperty("clanmsg", "");
/* 397 */       partymsg = set.getProperty("partymsg", "");
/* 398 */       clanmsg1 = set.getProperty("clanmsg1", "");
/* 399 */       clanmsg2 = set.getProperty("clanmsg2", "");
/* 400 */       Reset_Map = Boolean.parseBoolean(set.getProperty("Reset_Map", "false"));
/* 401 */       Reset_Map_Time = Integer.parseInt(set.getProperty("Reset_Map_Time", "20"));
/* 402 */       MAP_IDITEM = toIntArray(set.getProperty("MAP_IDITEM", ""), ",");
/* 403 */       MAP_ITEM = toIntArray(set.getProperty("MAP_ITEM", ""), ",");
/* 404 */       MAP_IDSKILL = toIntArray(set.getProperty("MAP_IDSKILL", ""), ",");
/* 405 */       MAP_SKILL = toIntArray(set.getProperty("MAP_SKILL", ""), ",");
/* 406 */       WAR_DISABLE_SKILLS = toIntArray(set.getProperty("WAR_DISABLE_SKILLS", ""), ",");
/* 407 */       WAR_DISABLE_ITEM = toIntArray(set.getProperty("WAR_DISABLE_ITEM", ""), ",");
/* 408 */       SPEED = Boolean.parseBoolean(set.getProperty("speed", "false"));
/* 409 */       dropcolor = Boolean.parseBoolean(set.getProperty("dropcolor", "false"));
/* 410 */       SPEED_TIME = Double.parseDouble(set.getProperty("speed_time", "1.0"));
/* 411 */       IMMUNE_TO_HARM = Double.parseDouble(set.getProperty("IMMUNE_TO_HARM", "1.0"));
/* 412 */       IMMUNE_TO_HARM_NPC = Double.parseDouble(set.getProperty("IMMUNE_TO_HARM_NPC", "1.0"));
/* 413 */       AtkNo = toIntArray(set.getProperty("AtkNo", ""), ",");
/* 414 */       AtkNo_pc = toIntArray(set.getProperty("AtkNo_pc", ""), ",");
/* 415 */       ILLEGAL_SPEEDUP_PUNISHMENT = Integer.parseInt(set.getProperty("Punishment", "0"));
/* 416 */       ENCOUNTER_LV = Integer.parseInt(set.getProperty("encounter_lv", "20"));
/* 417 */       KILLRED = Boolean.parseBoolean(set.getProperty("kill_red", "false"));
/* 418 */       CLANDEL = Boolean.parseBoolean(set.getProperty("clanadel", "false"));
/* 419 */       CLANTITLE = Boolean.parseBoolean(set.getProperty("clanatitle", "false"));
/* 420 */       CharNamebyte = Integer.parseInt(set.getProperty("CharNamebyte", "5"));
/* 421 */       CharNameEnbyte = Integer.parseInt(set.getProperty("CharNameEnbyte", "12"));
/* 422 */       armor_type1 = Integer.parseInt(set.getProperty("armor_type1", "100"));
/* 423 */       armor_type2 = Integer.parseInt(set.getProperty("armor_type2", "100"));
/* 424 */       armor_type3 = Integer.parseInt(set.getProperty("armor_type3", "100"));
/* 425 */       armor_type4 = Integer.parseInt(set.getProperty("armor_type4", "100"));
/* 426 */       armor_type5 = Integer.parseInt(set.getProperty("armor_type5", "100"));
/* 427 */       armor_type6 = Integer.parseInt(set.getProperty("armor_type6", "100"));
/* 428 */       armor_type7 = Integer.parseInt(set.getProperty("armor_type7", "100"));
/* 429 */       armor_type8 = Integer.parseInt(set.getProperty("armor_type8", "100"));
/* 430 */       armor_type9 = Integer.parseInt(set.getProperty("armor_type9", "100"));
/* 431 */       armor_type10 = Integer.parseInt(set.getProperty("armor_type10", "100"));
/* 432 */       armor_type11 = Integer.parseInt(set.getProperty("armor_type11", "100"));
/* 433 */       armor_type12 = Integer.parseInt(set.getProperty("armor_type12", "100"));
/* 434 */       armor_type13 = Integer.parseInt(set.getProperty("armor_type13", "100"));
/* 435 */       armor_type14 = Integer.parseInt(set.getProperty("armor_type14", "100"));
/* 436 */       armor_type15 = Integer.parseInt(set.getProperty("armor_type15", "100"));
/* 437 */       armor_type16 = Integer.parseInt(set.getProperty("armor_type16", "100"));
/* 438 */       armor_type17 = Integer.parseInt(set.getProperty("armor_type17", "100"));
/* 439 */       armor_type18 = Integer.parseInt(set.getProperty("armor_type18", "100"));
/* 440 */       armor_type19 = Integer.parseInt(set.getProperty("armor_type19", "100"));
/* 441 */       armor_type20 = Integer.parseInt(set.getProperty("armor_type20", "100"));
/* 442 */       armor_type21 = Integer.parseInt(set.getProperty("armor_type21", "100"));
/* 443 */       armor_type22 = Integer.parseInt(set.getProperty("armor_type22", "100"));
/* 444 */       armor_type23 = Integer.parseInt(set.getProperty("armor_type23", "100"));
/* 445 */       armor_type24 = Integer.parseInt(set.getProperty("armor_type24", "100"));
/* 446 */       armor_type25 = Integer.parseInt(set.getProperty("armor_type25", "100"));
/* 447 */       SCLANCOUNT = Integer.parseInt(set.getProperty("sclancount", "100"));
/* 448 */       dead_score = Integer.parseInt(set.getProperty("dead_score", "100"));
/* 449 */       LIGHT = Boolean.parseBoolean(set.getProperty("light", "false"));
/* 450 */       HPBAR = Boolean.parseBoolean(set.getProperty("hpbar", "false"));
/* 451 */       SHOPINFO = Boolean.parseBoolean(set.getProperty("shopinfo", "false"));
/* 452 */       SET_GLOBAL = Integer.parseInt(set.getProperty("set_global", "100"));
/* 453 */       SET_GLOBAL_COUNT = Integer.parseInt(set.getProperty("set_global_count", "100"));
/* 454 */       SET_GLOBAL_TIME = Integer.parseInt(set.getProperty("set_global_time", "5"));
/* 455 */       SET_SHOUT_TIME = Integer.parseInt(set.getProperty("set_shout_time", "5"));
/* 456 */       WAR_DOLL = Boolean.parseBoolean(set.getProperty("war_doll", "true"));
/* 457 */       logpcpower = Boolean.parseBoolean(set.getProperty("logpcpower", "true"));
/* 458 */       newcharpra = Boolean.parseBoolean(set.getProperty("newcharpra", "true"));
/* 459 */       newcharpralv = Integer.parseInt(set.getProperty("newcharpralv", "5"));
/* 460 */       String tmp13 = set.getProperty("CreateCharInfo", "");
/* 461 */       if (!tmp13.equalsIgnoreCase("null")) {
/* 462 */         CreateCharInfo = tmp13;
/*     */       }
/* 464 */       WHO_ONLINE_MSG_ON = Boolean.parseBoolean(set.getProperty("WHO_ONLINE_MSG_ON", "true"));
/* 465 */       summtime = Integer.parseInt(set.getProperty("summtime", "3600"));
/* 466 */       drainedMana = Integer.parseInt(set.getProperty("drainedMana", "5"));
/* 467 */       NeedItem = Integer.parseInt(set.getProperty("NeedItem", "3600"));
/* 468 */       NeedItemCount = Integer.parseInt(set.getProperty("NeedItemCount", "3600"));
/* 469 */       Msg = set.getProperty("Msg", "");
/* 470 */       NeedItem1 = Integer.parseInt(set.getProperty("NeedItem1", "3600"));
/* 471 */       NeedItemCount1 = Integer.parseInt(set.getProperty("NeedItemCount1", "3600"));
/* 472 */       Msg1 = set.getProperty("Msg1", "");
/* 473 */       ItemMsg1 = set.getProperty("ItemMsg1", "");
/* 474 */       ItemMsg = set.getProperty("ItemMsg", "");
/* 475 */       NeedItem2 = Integer.parseInt(set.getProperty("NeedItem2", "3600"));
/* 476 */       NeedItemCount2 = Integer.parseInt(set.getProperty("NeedItemCount2", "3600"));
/* 477 */       Msg2 = set.getProperty("Msg2", "");
/* 478 */       ItemMsg2 = set.getProperty("ItemMsg2", "");
/* 479 */       Give_skill = toIntArray(set.getProperty("Give_skill", ""), ",");
/* 480 */       Give_skill1 = toIntArray(set.getProperty("Give_skill1", ""), ",");
/* 481 */       Give_skill2 = toIntArray(set.getProperty("Give_skill2", ""), ",");
/* 482 */       Attack_1 = Integer.parseInt(set.getProperty("Attack_1", "100"));
/* 483 */       Attack_2 = Integer.parseInt(set.getProperty("Attack_2", "100"));
/* 484 */       Attack_3 = Integer.parseInt(set.getProperty("Attack_3", "100"));
/* 485 */       Attack_4 = Integer.parseInt(set.getProperty("Attack_4", "100"));
/* 486 */       Attack_5 = Integer.parseInt(set.getProperty("Attack_5", "100"));
/* 487 */       Attack_Miss = Integer.parseInt(set.getProperty("Attack_Miss", "100"));
/* 488 */       TextMinPlayer = Integer.parseInt(set.getProperty("TextMinPlayer", "1"));
/* 489 */       TextMaxPlayer = Integer.parseInt(set.getProperty("TextMaxPlayer", "20"));
/* 490 */       TextLevel = Integer.parseInt(set.getProperty("TextLevel", "52"));
/* 491 */       tcheckitem = Integer.parseInt(set.getProperty("tcheckitem", "5"));
/* 492 */       TextMoney = Integer.parseInt(set.getProperty("TextMoney", "5"));
/* 493 */       Textnpa1 = Integer.parseInt(set.getProperty("Textnpa1", "5"));
/* 494 */       Textnpa2 = Integer.parseInt(set.getProperty("Textnpa2", "5"));
/* 495 */       Textnpa3 = Integer.parseInt(set.getProperty("Textnpa3", "5"));
/* 496 */       Textnpa4 = Integer.parseInt(set.getProperty("Textnpa4", "5"));
/* 497 */       Textnpa5 = Integer.parseInt(set.getProperty("Textnpa5", "5"));
/* 498 */       Textnpa6 = Integer.parseInt(set.getProperty("Textnpa6", "5"));
/* 499 */       Textnpa7 = Integer.parseInt(set.getProperty("Textnpa7", "5"));
/* 500 */       Textnpa8 = Integer.parseInt(set.getProperty("Textnpa8", "5"));
/* 501 */       Textnpa9 = Integer.parseInt(set.getProperty("Textnpa9", "5"));
/* 502 */       Textnpa10 = Integer.parseInt(set.getProperty("Textnpa10", "5"));
/* 503 */       String rb1 = set.getProperty("NEW_CHAR_LOC", "33080,33392,4");
/* 504 */       if (!rb1.equalsIgnoreCase("null")) {
/* 505 */         String[] rb2 = rb1.split(",");
/* 506 */         NEW_CHAR_LOC = new int[] { Integer.valueOf(rb2[0]).intValue(), 
/* 507 */             Integer.valueOf(rb2[1]).intValue(), Integer.valueOf(rb2[2]).intValue() }; int[] arrayOfInt = new int[3];
/*     */       } 
/* 509 */       RankLevel = Boolean.parseBoolean(set.getProperty("RankLevel", "false"));
/* 510 */       day_level = Integer.parseInt(set.getProperty("day_level", "5"));
/* 511 */       restday = Integer.parseInt(set.getProperty("restday", "5"));
/* 512 */       Illusionistpc = Boolean.parseBoolean(set.getProperty("Illusionistpc", "false"));
/* 513 */       DragonKnightpc = Boolean.parseBoolean(set.getProperty("DragonKnightpc", "false"));
/* 514 */       clancount = Integer.parseInt(set.getProperty("clancount", "5"));
/* 515 */       clancountexp = Integer.parseInt(set.getProperty("clancountexp", "5"));
/* 516 */       clanLeaderlv = Integer.parseInt(set.getProperty("clanLeaderlv", "5"));
/* 517 */       warProtector = Boolean.parseBoolean(set.getProperty("warProtector", "false"));
/* 518 */       restsavepclog = Boolean.parseBoolean(set.getProperty("restsavepclog", "false"));
/* 519 */       checkitem76 = Integer.parseInt(set.getProperty("checkitem76", "5"));
/* 520 */       checkitemcount76 = Integer.parseInt(set.getProperty("checkitemcount76", "5"));
/* 521 */       checkitem81 = Integer.parseInt(set.getProperty("checkitem81", "5"));
/* 522 */       checkitemcount81 = Integer.parseInt(set.getProperty("checkitemcount81", "5"));
/* 523 */       checkitem59 = Integer.parseInt(set.getProperty("checkitem59", "5"));
/* 524 */       checkitemcount59 = Integer.parseInt(set.getProperty("checkitemcount59", "5"));
/* 525 */       monbossitem = Integer.parseInt(set.getProperty("monbossitem", "5"));
/* 526 */       monbossitemcount = Integer.parseInt(set.getProperty("monbossitemcount", "5"));
/* 527 */       montime = Integer.parseInt(set.getProperty("montime", "5"));
/* 528 */       monsec = Integer.parseInt(set.getProperty("monsec", "5"));
/* 529 */       killmsg = Integer.parseInt(set.getProperty("killmsg", "5"));
/* 530 */       dropmsg = Integer.parseInt(set.getProperty("dropmsg", "5"));
/* 531 */       boxsmsg = Integer.parseInt(set.getProperty("boxsmsg", "5"));
/* 532 */       killlevel = Integer.parseInt(set.getProperty("killlevel", "5"));
/* 533 */       logpcgiveitem = Boolean.parseBoolean(set.getProperty("logpcgiveitem", "false"));
/* 534 */       logpclevel = Integer.parseInt(set.getProperty("logpclevel", "5"));
/* 535 */       logpcresthp = Integer.parseInt(set.getProperty("logpcresthp", "5"));
/* 536 */       logpcrestmp = Integer.parseInt(set.getProperty("logpcrestmp", "5"));
/* 537 */       logpcallmsg = Boolean.parseBoolean(set.getProperty("logpcallmsg", "false"));
/* 538 */       logpctfcount = Integer.parseInt(set.getProperty("logpctfcount", "5"));
/* 539 */       onlydaypre = Boolean.parseBoolean(set.getProperty("onlydaypre", "false"));
/* 540 */       onlydaytime = Integer.parseInt(set.getProperty("onlydaytime", "5"));
/* 541 */       dateStartTime = Integer.parseInt(set.getProperty("dateStartTime", "5"));
/* 542 */       dollcount = Integer.parseInt(set.getProperty("dollcount", "5"));
/* 543 */       dollcount1 = Integer.parseInt(set.getProperty("dollcount1", "5"));
/* 544 */       petlevel = Integer.parseInt(set.getProperty("petlevel", "5"));
/* 545 */       petexp = Integer.parseInt(set.getProperty("petexp", "5"));
/* 546 */       giftset = Integer.parseInt(set.getProperty("giftset", "5"));
/* 547 */       partyexp = Boolean.parseBoolean(set.getProperty("partyexp", "false"));
/* 548 */       partyexp1 = Double.parseDouble(set.getProperty("partyexp1", "0.1"));
/* 549 */       partycount = Integer.parseInt(set.getProperty("partycount", "5"));
/* 550 */       warehouselevel = Integer.parseInt(set.getProperty("warehouselevel", "5"));
/* 551 */       shopitemrest = Integer.parseInt(set.getProperty("shopitemrest", "0"));
/* 552 */       tradelevel = Integer.parseInt(set.getProperty("tradelevel", "5"));
/* 553 */       npclevlecolor = Boolean.parseBoolean(set.getProperty("npclevlecolor", "false"));
/* 554 */       Scarecrowlevel = Integer.parseInt(set.getProperty("Scarecrowlevel", "5"));
/*     */       
/* 556 */       Lost_Item_high = Integer.parseInt(set.getProperty("Lost_Item_high", "10"));
/* 557 */       Lost_Item_Low = Integer.parseInt(set.getProperty("Lost_Item_Low", "10"));
/* 558 */       Lost_Item_Count = Integer.parseInt(set.getProperty("Lost_Item_Count", "10"));
/* 559 */       Lost_Item_Rnd = Integer.parseInt(set.getProperty("Lost_Item_Rnd", "10"));
/*     */ 
/*     */       
/* 562 */       Lost_Item_high_2 = Integer.parseInt(set.getProperty("Lost_Item_high_2", "10"));
/* 563 */       Lost_Item_Low_2 = Integer.parseInt(set.getProperty("Lost_Item_Low_2", "10"));
/* 564 */       Lost_Item_Count_2 = Integer.parseInt(set.getProperty("Lost_Item_Count_2", "10"));
/* 565 */       Lost_Item_Rnd_2 = Integer.parseInt(set.getProperty("Lost_Item_Rnd_2", "10"));
/*     */       
/* 567 */       Lost_Item_high_3 = Integer.parseInt(set.getProperty("Lost_Item_high_3", "10"));
/* 568 */       Lost_Item_Low_3 = Integer.parseInt(set.getProperty("Lost_Item_Low_3", "10"));
/* 569 */       Lost_Item_Count_3 = Integer.parseInt(set.getProperty("Lost_Item_Count_3", "10"));
/* 570 */       Lost_Item_Rnd_3 = Integer.parseInt(set.getProperty("Lost_Item_Rnd_3", "10"));
/*     */ 
/*     */       
/* 573 */       Lost_Item_high_4 = Integer.parseInt(set.getProperty("Lost_Item_high_4", "10"));
/* 574 */       Lost_Item_Low_4 = Integer.parseInt(set.getProperty("Lost_Item_Low_4", "10"));
/* 575 */       Lost_Item_Count_4 = Integer.parseInt(set.getProperty("Lost_Item_Count_4", "10"));
/* 576 */       Lost_Item_Rnd_4 = Integer.parseInt(set.getProperty("Lost_Item_Rnd_4", "10"));
/*     */ 
/*     */       
/* 579 */       Lost_Item_high_5 = Integer.parseInt(set.getProperty("Lost_Item_high_5", "10"));
/* 580 */       Lost_Item_Low_5 = Integer.parseInt(set.getProperty("Lost_Item_Low_5", "10"));
/* 581 */       Lost_Item_Count_5 = Integer.parseInt(set.getProperty("Lost_Item_Count_5", "10"));
/* 582 */       Lost_Item_Rnd_5 = Integer.parseInt(set.getProperty("Lost_Item_Rnd_5", "10"));
/*     */       
/* 584 */       Lost_Item_high_6 = Integer.parseInt(set.getProperty("Lost_Item_high_6", "10"));
/* 585 */       Lost_Item_Low_6 = Integer.parseInt(set.getProperty("Lost_Item_Low_6", "10"));
/* 586 */       Lost_Item_Count_6 = Integer.parseInt(set.getProperty("Lost_Item_Count_6", "10"));
/* 587 */       Lost_Item_Rnd_6 = Integer.parseInt(set.getProperty("Lost_Item_Rnd_6", "10"));
/*     */       
/* 589 */       Lost_Item_high_7 = Integer.parseInt(set.getProperty("Lost_Item_high_7", "10"));
/* 590 */       Lost_Item_Low_7 = Integer.parseInt(set.getProperty("Lost_Item_Low_7", "10"));
/* 591 */       Lost_Item_Count_7 = Integer.parseInt(set.getProperty("Lost_Item_Count_7", "10"));
/* 592 */       Lost_Item_Rnd_7 = Integer.parseInt(set.getProperty("Lost_Item_Rnd_7", "10"));
/*     */       
/* 594 */       Lost_Item_high_8 = Integer.parseInt(set.getProperty("Lost_Item_high_8", "10"));
/* 595 */       Lost_Item_Low_8 = Integer.parseInt(set.getProperty("Lost_Item_Low_8", "10"));
/* 596 */       Lost_Item_Count_8 = Integer.parseInt(set.getProperty("Lost_Item_Count_8", "10"));
/* 597 */       Lost_Item_Rnd_8 = Integer.parseInt(set.getProperty("Lost_Item_Rnd_8", "10"));
/*     */       
/* 599 */       Lost_Skill_high = Integer.parseInt(set.getProperty("Lost_Skill_high", "10"));
/* 600 */       Lost_Skill_Low = Integer.parseInt(set.getProperty("Lost_Skill_Low", "10"));
/* 601 */       Lost_Skill_Count = Integer.parseInt(set.getProperty("Lost_Skill_Count", "10"));
/* 602 */       Lost_Skill_Rnd = Integer.parseInt(set.getProperty("Lost_Skill_Rnd", "10"));
/*     */ 
/*     */       
/* 605 */       Lost_Skill_high_2 = Integer.parseInt(set.getProperty("Lost_Skill_high_2", "10"));
/* 606 */       Lost_Skill_Low_2 = Integer.parseInt(set.getProperty("Lost_Skill_Low_2", "10"));
/* 607 */       Lost_Skill_Count_2 = Integer.parseInt(set.getProperty("Lost_Skill_Count_2", "10"));
/* 608 */       Lost_Skill_Rnd_2 = Integer.parseInt(set.getProperty("Lost_Skill_Rnd_2", "10"));
/*     */       
/* 610 */       Lost_Skill_high_3 = Integer.parseInt(set.getProperty("Lost_Skill_high_3", "10"));
/* 611 */       Lost_Skill_Low_3 = Integer.parseInt(set.getProperty("Lost_Skill_Low_3", "10"));
/* 612 */       Lost_Skill_Count_3 = Integer.parseInt(set.getProperty("Lost_Skill_Count_3", "10"));
/* 613 */       Lost_Skill_Rnd_3 = Integer.parseInt(set.getProperty("Lost_Skill_Rnd_3", "10"));
/*     */ 
/*     */       
/* 616 */       Lost_Skill_high_4 = Integer.parseInt(set.getProperty("Lost_Skill_high_4", "10"));
/* 617 */       Lost_Skill_Low_4 = Integer.parseInt(set.getProperty("Lost_Skill_Low_4", "10"));
/* 618 */       Lost_Skill_Count_4 = Integer.parseInt(set.getProperty("Lost_Skill_Count_4", "10"));
/* 619 */       Lost_Skill_Rnd_4 = Integer.parseInt(set.getProperty("Lost_Skill_Rnd_4", "10"));
/*     */ 
/*     */       
/* 622 */       Lost_Skill_high_5 = Integer.parseInt(set.getProperty("Lost_Skill_high_5", "10"));
/* 623 */       Lost_Skill_Low_5 = Integer.parseInt(set.getProperty("Lost_Skill_Low_5", "10"));
/* 624 */       Lost_Skill_Count_5 = Integer.parseInt(set.getProperty("Lost_Skill_Count_5", "10"));
/* 625 */       Lost_Skill_Rnd_5 = Integer.parseInt(set.getProperty("Lost_Skill_Rnd_5", "10"));
/*     */       
/* 627 */       Lost_Skill_high_6 = Integer.parseInt(set.getProperty("Lost_Skill_high_6", "10"));
/* 628 */       Lost_Skill_Low_6 = Integer.parseInt(set.getProperty("Lost_Skill_Low_6", "10"));
/* 629 */       Lost_Skill_Count_6 = Integer.parseInt(set.getProperty("Lost_Skill_Count_6", "10"));
/* 630 */       Lost_Skill_Rnd_6 = Integer.parseInt(set.getProperty("Lost_Skill_Rnd_6", "10"));
/*     */       
/* 632 */       Lost_Skill_high_7 = Integer.parseInt(set.getProperty("Lost_Skill_high_7", "10"));
/* 633 */       Lost_Skill_Low_7 = Integer.parseInt(set.getProperty("Lost_Skill_Low_7", "10"));
/* 634 */       Lost_Skill_Count_7 = Integer.parseInt(set.getProperty("Lost_Skill_Count_7", "10"));
/* 635 */       Lost_Skill_Rnd_7 = Integer.parseInt(set.getProperty("Lost_Skill_Rnd_7", "10"));
/*     */       
/* 637 */       Lost_Skill_high_8 = Integer.parseInt(set.getProperty("Lost_Skill_high_8", "10"));
/* 638 */       Lost_Skill_Low_8 = Integer.parseInt(set.getProperty("Lost_Skill_Low_8", "10"));
/* 639 */       Lost_Skill_Count_8 = Integer.parseInt(set.getProperty("Lost_Skill_Count_8", "10"));
/* 640 */       Lost_Skill_Rnd_8 = Integer.parseInt(set.getProperty("Lost_Skill_Rnd_8", "10"));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 645 */       Lost_Item = Integer.parseInt(set.getProperty("Lost_Item", "10"));
/* 646 */       Lost_Count_1 = Integer.parseInt(set.getProperty("Lost_Count_1", "10"));
/* 647 */       Lost_Count_2 = Integer.parseInt(set.getProperty("Lost_Count_2", "10"));
/*     */       
/* 649 */       Lost_Item2 = Integer.parseInt(set.getProperty("Lost_Item2", "10"));
/* 650 */       Lost_Count2_1 = Integer.parseInt(set.getProperty("Lost_Count2_1", "10"));
/* 651 */       Lost_Count2_2 = Integer.parseInt(set.getProperty("Lost_Count2_2", "10"));
/* 652 */       ExpRateLost = Integer.parseInt(set.getProperty("ExpRateLost", "0"));
/* 653 */       LostItem_ON = Integer.parseInt(set.getProperty("LostItem_ON", "0"));
/* 654 */       LostItem2_ON = Integer.parseInt(set.getProperty("LostItem2_ON", "0"));
/*     */ 
/*     */       
/* 657 */       FAFURION_RANDOM_6 = Integer.parseInt(set.getProperty("FAFURION_RANDOM_6", "50"));
/* 658 */       FAFURION_MIN_6 = Integer.parseInt(set.getProperty("FAFURION_MIN_6", "20"));
/* 659 */       FAFURION_MAX_6 = Integer.parseInt(set.getProperty("FAFURION_MAX_6", "40"));
/* 660 */       FAFURION_RANDOM_7 = Integer.parseInt(set.getProperty("FAFURION_RANDOM_7", "50"));
/* 661 */       FAFURION_MIN_7 = Integer.parseInt(set.getProperty("FAFURION_MIN_7", "20"));
/* 662 */       FAFURION_MAX_7 = Integer.parseInt(set.getProperty("FAFURION_MAX_7", "40"));
/* 663 */       FAFURION_RANDOM_8 = Integer.parseInt(set.getProperty("FAFURION_RANDOM_8", "50"));
/* 664 */       FAFURION_MIN_8 = Integer.parseInt(set.getProperty("FAFURION_MIN_8", "20"));
/* 665 */       FAFURION_MAX_8 = Integer.parseInt(set.getProperty("FAFURION_MAX_8", "40"));
/* 666 */       FAFURION_RANDOM_9 = Integer.parseInt(set.getProperty("FAFURION_RANDOM_9", "50"));
/* 667 */       FAFURION_MIN_9 = Integer.parseInt(set.getProperty("FAFURION_MIN_9", "20"));
/* 668 */       FAFURION_MAX_9 = Integer.parseInt(set.getProperty("FAFURION_MAX_9", "40"));
/*     */       
/* 670 */       VALAKAS_DMG_6 = Integer.parseInt(set.getProperty("VALAKAS_DMG_6", "20"));
/* 671 */       VALAKAS_BOWDMG_6 = Integer.parseInt(set.getProperty("VALAKAS_BOWDMG_6", "40"));
/* 672 */       VALAKAS_DMG_7 = Integer.parseInt(set.getProperty("VALAKAS_DMG_7", "20"));
/* 673 */       VALAKAS_BOWDMG_7 = Integer.parseInt(set.getProperty("VALAKAS_BOWDMG_7", "40"));
/* 674 */       VALAKAS_DMG_8 = Integer.parseInt(set.getProperty("VALAKAS_DMG_8", "20"));
/* 675 */       VALAKAS_BOWDMG_8 = Integer.parseInt(set.getProperty("VALAKAS_BOWDMG_8", "40"));
/* 676 */       VALAKAS_DMG_9 = Integer.parseInt(set.getProperty("VALAKAS_DMG_9", "20"));
/* 677 */       VALAKAS_BOWDMG_9 = Integer.parseInt(set.getProperty("VALAKAS_BOWDMG_9", "40"));
/*     */       
/* 679 */       ANTHARAS_DMGR_6 = Integer.parseInt(set.getProperty("ANTHARAS_DMGR_6", "20"));
/* 680 */       ANTHARAS_DMGR_7 = Integer.parseInt(set.getProperty("ANTHARAS_DMGR_7", "20"));
/* 681 */       ANTHARAS_DMGR_8 = Integer.parseInt(set.getProperty("ANTHARAS_DMGR_8", "20"));
/* 682 */       ANTHARAS_DMGR_9 = Integer.parseInt(set.getProperty("ANTHARAS_DMGR_9", "20"));
/*     */       
/* 684 */       LINDVIOR_RANDOM_6 = Integer.parseInt(set.getProperty("LINDVIOR_RANDOM_6", "50"));
/* 685 */       LINDVIOR_MIN_6 = Integer.parseInt(set.getProperty("LINDVIOR_MIN_6", "20"));
/* 686 */       LINDVIOR_MAX_6 = Integer.parseInt(set.getProperty("LINDVIOR_MAX_6", "40"));
/* 687 */       LINDVIOR_RANDOM_7 = Integer.parseInt(set.getProperty("LINDVIOR_RANDOM_7", "50"));
/* 688 */       LINDVIOR_MIN_7 = Integer.parseInt(set.getProperty("LINDVIOR_MIN_7", "20"));
/* 689 */       LINDVIOR_MAX_7 = Integer.parseInt(set.getProperty("LINDVIOR_MAX_7", "40"));
/* 690 */       LINDVIOR_RANDOM_8 = Integer.parseInt(set.getProperty("LINDVIOR_RANDOM_8", "50"));
/* 691 */       LINDVIOR_MIN_8 = Integer.parseInt(set.getProperty("LINDVIOR_MIN_8", "20"));
/* 692 */       LINDVIOR_MAX_8 = Integer.parseInt(set.getProperty("LINDVIOR_MAX_8", "40"));
/* 693 */       LINDVIOR_RANDOM_9 = Integer.parseInt(set.getProperty("LINDVIOR_RANDOM_9", "50"));
/* 694 */       LINDVIOR_MIN_9 = Integer.parseInt(set.getProperty("LINDVIOR_MIN_9", "20"));
/* 695 */       LINDVIOR_MAX_9 = Integer.parseInt(set.getProperty("LINDVIOR_MAX_9", "40"));
/*     */ 
/*     */       
/* 698 */       Item_Price = set.getProperty("Item_Price", "260124,500");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 704 */       CALL_ALL_REPLY_SECOND = Long.valueOf(set.getProperty("call_all_reply_second", "5"));
/*     */ 
/*     */ 
/*     */       
/* 708 */       SHOCK_STUN_OVERLAY = Integer.parseInt(set.getProperty("SHOCK_STUN_OVERLAY", "0"));
/*     */     }
/* 710 */     catch (Exception e) {
/* 711 */       throw new ConfigErrorException("設置檔案遺失: ./config/other.properties");
/*     */     } finally {
/* 713 */       set.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int[] toIntArray(String text, String type) {
/* 718 */     StringTokenizer st = new StringTokenizer(text, type);
/* 719 */     int[] iReturn = new int[st.countTokens()];
/* 720 */     int i = 0;
/* 721 */     while (i < iReturn.length) {
/* 722 */       iReturn[i] = Integer.parseInt(st.nextToken());
/* 723 */       i++;
/*     */     } 
/* 725 */     return iReturn;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigOther.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */