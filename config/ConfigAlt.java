/*     */ package com.lineage.config;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public final class ConfigAlt {
/*  15 */   private static final Log _log = LogFactory.getLog(ConfigAlt.class);
/*     */   public static short GLOBAL_CHAT_LEVEL;
/*     */   public static short WHISPER_CHAT_LEVEL;
/*     */   public static byte AUTO_LOOT;
/*     */   public static int LOOTING_RANGE;
/*     */   public static boolean ALT_NONPVP;
/*     */   public static boolean ALT_PUNISHMENT;
/*     */   public static boolean ALT_ATKMSG;
/*     */   public static boolean CLAN_ALLIANCE;
/*     */   public static int ALT_ITEM_DELETION_TIME;
/*     */   public static boolean ALT_WHO_COMMANDX;
/*     */   public static int ALT_WHO_TYPE;
/*     */   public static double ALT_WHO_COUNT;
/*     */   public static int ALT_WAR_TIME;
/*     */   public static int ALT_WAR_TIME_UNIT;
/*     */   public static int ALT_WAR_INTERVAL;
/*     */   public static int ALT_WAR_INTERVAL_UNIT;
/*     */   public static int ALT_RATE_OF_DUTY;
/*     */   public static boolean SPAWN_HOME_POINT;
/*     */   public static int SPAWN_HOME_POINT_RANGE;
/*     */   public static int SPAWN_HOME_POINT_COUNT;
/*     */   public static int SPAWN_HOME_POINT_DELAY;
/*     */   public static int ELEMENTAL_STONE_AMOUNT;
/*     */   public static int HOUSE_TAX_INTERVAL;
/*     */   public static int HOUSE_TAX_ADENA;
/*     */   public static int MAX_DOLL_COUNT;
/*     */   public static int MAX_NPC_ITEM;
/*     */   public static int MAX_PERSONAL_WAREHOUSE_ITEM;
/*     */   public static int MAX_CLAN_WAREHOUSE_ITEM;
/*     */   public static int DELETE_CHARACTER_AFTER_LV;
/*     */   public static boolean DELETE_CHARACTER_AFTER_7DAYS;
/*     */   public static int NPC_DELETION_TIME;
/*     */   public static int DEFAULT_CHARACTER_SLOT;
/*     */   public static int MEDICINE;
/*     */   public static int POWER;
/*     */   public static int POWERMEDICINE;
/*     */   public static int BaseResetPOWER;
/*     */   public static boolean DORP_ITEM;
/*     */   public static final int MAX_NPC = 35;
/*     */   public static int MAX_PARTY_SIZE;
/*     */   public static boolean METE_GIVE_POTION;
/*  56 */   public static List<Integer> DRAGON_KEY_MAP_LIST = new ArrayList<>();
/*  57 */   public static List<Integer> NO_AI_MAP_LIST = new ArrayList<>();
/*     */   
/*     */   public static boolean GM_OVERHEARD;
/*     */   
/*     */   public static boolean GM_OVERHEARD0;
/*     */   
/*     */   public static boolean GM_OVERHEARD4;
/*     */   public static boolean GM_OVERHEARD11;
/*     */   public static boolean GM_OVERHEARD13;
/*     */   public static boolean ALT_WARPUNISHMENT;
/*     */   public static int CHAR_BOOK_INIT_COUNT;
/*     */   public static int CHAR_BOOK_MAX_CHARGE;
/*     */   public static boolean QUIZ_SET_SWITCH;
/*     */   public static Calendar QUIZ_SET_RESET_TIME;
/*     */   public static int QUIZ_SET_TYPE;
/*     */   public static int QUIZ_SET_LEVEL;
/*     */   public static int[][] QUIZ_SET_LIST;
/*     */   public static String NO_CD;
/*     */   private static final String ALT_SETTINGS_FILE = "./config/altsettings.properties";
/*     */   
/*     */   public static void load() throws ConfigErrorException {
/*  78 */     Properties set = new Properties();
/*     */     try {
/*  80 */       InputStream is = new FileInputStream(new File("./config/altsettings.properties"));
/*  81 */       InputStreamReader isr = new InputStreamReader(is, "utf-8");
/*  82 */       set.load(isr);
/*  83 */       is.close();
/*     */ 
/*     */ 
/*     */       
/*  87 */       GM_OVERHEARD = Boolean.parseBoolean(set.getProperty("GM_OVERHEARD", "false"));
/*  88 */       GM_OVERHEARD0 = Boolean.parseBoolean(set.getProperty("GM_OVERHEARD0", "false"));
/*  89 */       GM_OVERHEARD4 = Boolean.parseBoolean(set.getProperty("GM_OVERHEARD4", "false"));
/*  90 */       GM_OVERHEARD11 = Boolean.parseBoolean(set.getProperty("GM_OVERHEARD11", "false"));
/*  91 */       GM_OVERHEARD13 = Boolean.parseBoolean(set.getProperty("GM_OVERHEARD13", "false"));
/*  92 */       GLOBAL_CHAT_LEVEL = Short.parseShort(set.getProperty("GlobalChatLevel", "30"));
/*  93 */       WHISPER_CHAT_LEVEL = Short.parseShort(set.getProperty("WhisperChatLevel", "5"));
/*  94 */       AUTO_LOOT = Byte.parseByte(set.getProperty("AutoLoot", "2"));
/*  95 */       LOOTING_RANGE = Integer.parseInt(set.getProperty("LootingRange", "3"));
/*  96 */       ALT_NONPVP = Boolean.parseBoolean(set.getProperty("NonPvP", "true"));
/*  97 */       ALT_PUNISHMENT = Boolean.parseBoolean(set.getProperty("Punishment", "true"));
/*  98 */       ALT_WARPUNISHMENT = Boolean.parseBoolean(set.getProperty("WarPunishment", "false"));
/*  99 */       CLAN_ALLIANCE = Boolean.parseBoolean(set.getProperty("ClanAlliance", "true"));
/* 100 */       ALT_ITEM_DELETION_TIME = Integer.parseInt(set.getProperty("ItemDeletionTime", "10"));
/* 101 */       if (ALT_ITEM_DELETION_TIME > 60) {
/* 102 */         ALT_ITEM_DELETION_TIME = 60;
/*     */       }
/* 104 */       ALT_WHO_COMMANDX = Boolean.parseBoolean(set.getProperty("WhoCommandx", "false"));
/* 105 */       ALT_WHO_TYPE = Integer.parseInt(set.getProperty("Who_type", "0"));
/* 106 */       ALT_WHO_COUNT = Double.parseDouble(set.getProperty("WhoCommandcount", "1.0"));
/* 107 */       if (ALT_WHO_COUNT < 1.0D) {
/* 108 */         ALT_WHO_COUNT = 1.0D;
/*     */       }
/* 110 */       String strWar = set.getProperty("WarTime", "2h");
/* 111 */       if (strWar.indexOf("d") >= 0) {
/* 112 */         ALT_WAR_TIME_UNIT = 5;
/* 113 */         strWar = strWar.replace("d", "");
/* 114 */       } else if (strWar.indexOf("h") >= 0) {
/* 115 */         ALT_WAR_TIME_UNIT = 11;
/* 116 */         strWar = strWar.replace("h", "");
/* 117 */       } else if (strWar.indexOf("m") >= 0) {
/* 118 */         ALT_WAR_TIME_UNIT = 12;
/* 119 */         strWar = strWar.replace("m", "");
/*     */       } 
/* 121 */       ALT_WAR_TIME = Integer.parseInt(strWar);
/* 122 */       strWar = set.getProperty("WarInterval", "4d");
/* 123 */       if (strWar.indexOf("d") >= 0) {
/* 124 */         ALT_WAR_INTERVAL_UNIT = 5;
/* 125 */         strWar = strWar.replace("d", "");
/* 126 */       } else if (strWar.indexOf("h") >= 0) {
/* 127 */         ALT_WAR_INTERVAL_UNIT = 11;
/* 128 */         strWar = strWar.replace("h", "");
/* 129 */       } else if (strWar.indexOf("m") >= 0) {
/* 130 */         ALT_WAR_INTERVAL_UNIT = 12;
/* 131 */         strWar = strWar.replace("m", "");
/*     */       } 
/* 133 */       ALT_WAR_INTERVAL = Integer.parseInt(strWar);
/* 134 */       SPAWN_HOME_POINT = Boolean.parseBoolean(set.getProperty("SpawnHomePoint", "true"));
/* 135 */       SPAWN_HOME_POINT_COUNT = Integer.parseInt(set.getProperty("SpawnHomePointCount", "2"));
/* 136 */       SPAWN_HOME_POINT_DELAY = Integer.parseInt(set.getProperty("SpawnHomePointDelay", "100"));
/* 137 */       SPAWN_HOME_POINT_RANGE = Integer.parseInt(set.getProperty("SpawnHomePointRange", "8"));
/* 138 */       ELEMENTAL_STONE_AMOUNT = Integer.parseInt(set.getProperty("ElementalStoneAmount", "300"));
/* 139 */       HOUSE_TAX_INTERVAL = Integer.parseInt(set.getProperty("HouseTaxInterval", "10"));
/* 140 */       HOUSE_TAX_ADENA = Integer.parseInt(set.getProperty("HouseTaxAdena", "2000"));
/* 141 */       MAX_DOLL_COUNT = Integer.parseInt(set.getProperty("MaxDollCount", "1"));
/* 142 */       MAX_NPC_ITEM = Integer.parseInt(set.getProperty("MaxNpcItem", "8"));
/* 143 */       MAX_PERSONAL_WAREHOUSE_ITEM = Integer.parseInt(set.getProperty("MaxPersonalWarehouseItem", "100"));
/* 144 */       MAX_CLAN_WAREHOUSE_ITEM = Integer.parseInt(set.getProperty("MaxClanWarehouseItem", "200"));
/* 145 */       DELETE_CHARACTER_AFTER_LV = Integer.parseInt(set.getProperty("DeleteCharacterAfterLV", "60"));
/* 146 */       DELETE_CHARACTER_AFTER_7DAYS = Boolean.parseBoolean(set.getProperty("DeleteCharacterAfter7Days", "True"));
/* 147 */       NPC_DELETION_TIME = Integer.parseInt(set.getProperty("NpcDeletionTime", "10"));
/* 148 */       DEFAULT_CHARACTER_SLOT = Integer.parseInt(set.getProperty("DefaultCharacterSlot", "4"));
/* 149 */       MEDICINE = Integer.parseInt(set.getProperty("Medicine", "20"));
/* 150 */       POWER = Integer.parseInt(set.getProperty("Power", "35"));
/* 151 */       POWERMEDICINE = Integer.parseInt(set.getProperty("MedicinePower", "45"));
/* 152 */       BaseResetPOWER = Integer.parseInt(set.getProperty("BaseResetPOWER", "37"));
/* 153 */       DORP_ITEM = Boolean.parseBoolean(set.getProperty("dorpitem", "true"));
/* 154 */       METE_GIVE_POTION = Boolean.parseBoolean(set.getProperty("MeteGivePotion", "false"));
/* 155 */       CHAR_BOOK_INIT_COUNT = Integer.parseInt(set.getProperty("CharBookInitCount", "60"));
/* 156 */       CHAR_BOOK_MAX_CHARGE = Integer.parseInt(set.getProperty("CharBookMaxCharge", "4"));
/* 157 */       NO_CD = set.getProperty("NO_CD", "null");
/* 158 */       QUIZ_SET_SWITCH = Boolean.parseBoolean(set.getProperty("QuizSetSwitch", "false"));
/* 159 */       String tmp10 = set.getProperty("QuizSetResetTime", "");
/* 160 */       if (!tmp10.equalsIgnoreCase("null")) {
/* 161 */         String[] temp = tmp10.split(":");
/* 162 */         if (temp.length == 3) {
/* 163 */           Calendar cal = Calendar.getInstance();
/* 164 */           cal.set(11, Integer.parseInt(temp[0]));
/* 165 */           cal.set(12, Integer.parseInt(temp[1]));
/* 166 */           cal.set(13, Integer.parseInt(temp[2]));
/* 167 */           QUIZ_SET_RESET_TIME = cal;
/*     */         } else {
/* 169 */           _log.info("[每日一題系統] 重置時間有誤, 請重新設置!");
/*     */         } 
/*     */       } 
/* 172 */       QUIZ_SET_TYPE = Integer.parseInt(set.getProperty("QuizSetType", "1"));
/* 173 */       QUIZ_SET_LEVEL = Integer.parseInt(set.getProperty("QuizSetLevel", "0"));
/* 174 */       String tmp11 = set.getProperty("QuizSetList", "");
/* 175 */       if (!tmp11.equalsIgnoreCase("null")) {
/* 176 */         String[] temp2 = tmp11.split(",");
/* 177 */         int size = temp2.length;
/* 178 */         QUIZ_SET_LIST = new int[size][2];
/* 179 */         int i = 0;
/* 180 */         while (i < size) {
/* 181 */           String[] temp3 = temp2[i].split(":");
/* 182 */           QUIZ_SET_LIST[i][0] = Integer.valueOf(temp3[0]).intValue();
/* 183 */           QUIZ_SET_LIST[i][1] = Integer.valueOf(temp3[1]).intValue();
/* 184 */           i++;
/*     */         } 
/*     */       } 
/* 187 */       if (set.getProperty("DragonKeyMapList") != null) {
/*     */         String[] split;
/* 189 */         int length = (split = set.getProperty("DragonKeyMapList").split(",")).length;
/* 190 */         int j = 0;
/* 191 */         while (j < length) {
/* 192 */           String str = split[j];
/* 193 */           DRAGON_KEY_MAP_LIST.add(Integer.valueOf(Integer.parseInt(str)));
/* 194 */           j++;
/*     */         } 
/*     */       } 
/* 197 */     } catch (Exception e) {
/* 198 */       throw new ConfigErrorException("設置檔案遺失: ./config/altsettings.properties");
/*     */     } finally {
/* 200 */       set.clear();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigAlt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */