/*     */ package com.lineage.config;
/*     */ 
/*     */ import com.lineage.server.utils.PerformanceTimer;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.util.Properties;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public final class ConfigElfSkill {
/*  12 */   private static final Log _log = LogFactory.getLog(ConfigElfSkill.class);
/*     */   public static double TRIPLE_ARROW_DMG;
/*     */   public static double STRIKER_DMG2;
/*     */   public static int BLOODY_SOULADDMP;
/*     */   public static boolean IS_PET_BLESSING;
/*     */   public static double SOUL_OF_FLAME_DAMAGE;
/*     */   public static double SOUL_OF_FLAME_ALLDAMAGE;
/*     */   public static double ELEMENTAL_FIRE;
/*     */   public static int ELEMENTAL_FIRE_RND;
/*     */   public static int STRIKER_GALE_1;
/*     */   public static int STRIKER_GALE_2;
/*     */   public static int STRIKER_GALE_3;
/*     */   public static double STRIKER_GALE_INT;
/*     */   public static double STRIKER_GALE_MR;
/*     */   public static int DOWN_ER;
/*     */   public static int POLLUTE_WATER_RND_1;
/*     */   public static int POLLUTE_WATER_RND_2;
/*     */   public static int POLLUTE_WATER_RND_3;
/*     */   public static double POLLUTE_WATER_INT;
/*     */   public static double POLLUTE_WATER_MR;
/*     */   public static int EARTH_BIND_1;
/*     */   public static int EARTH_BIND_2;
/*     */   public static int EARTH_BIND_3;
/*     */   public static double EARTH_BIND_INT;
/*     */   public static double EARTH_BIND_MR;
/*     */   public static int ERASE_MAGIC_1;
/*     */   public static int ERASE_MAGIC_2;
/*     */   public static int ERASE_MAGIC_3;
/*     */   public static double ERASE_MAGIC_INT;
/*     */   public static double ERASE_MAGIC_MR;
/*     */   public static int AREA_OF_SILENCE_1;
/*     */   public static int AREA_OF_SILENCE_2;
/*     */   public static int AREA_OF_SILENCE_3;
/*     */   public static double AREA_OF_SILENCE_INT;
/*     */   public static double AREA_OF_SILENCE_MR;
/*     */   public static int ENTANGLE_1;
/*     */   public static int ENTANGLE_2;
/*     */   public static int ENTANGLE_3;
/*     */   public static double ENTANGLE_INT;
/*     */   public static double ENTANGLE_MR;
/*     */   public static int WIND_SHACKLE_1;
/*     */   public static int WIND_SHACKLE_2;
/*     */   public static int WIND_SHACKLE_3;
/*     */   public static double WIND_SHACKLE_INT;
/*     */   public static double WIND_SHACKLE_MR;
/*     */   private static final String CONFIG_FILE = "./config/妖精_技能設定表.properties";
/*     */   
/*     */   public static void load() throws ConfigErrorException {
/*  60 */     PerformanceTimer timer = new PerformanceTimer();
/*  61 */     Properties set = new Properties();
/*     */     try {
/*  63 */       InputStream is = new FileInputStream(new File("./config/妖精_技能設定表.properties"));
/*  64 */       set.load(is);
/*  65 */       is.close();
/*  66 */       IS_PET_BLESSING = Boolean.parseBoolean(set.getProperty("IS_PET_BLESSING", "true"));
/*  67 */       TRIPLE_ARROW_DMG = Double.parseDouble(set.getProperty("Triple_Arrow_Dmg", "1.0"));
/*  68 */       STRIKER_DMG2 = Double.parseDouble(set.getProperty("STRIKER_DMG2", "1.0"));
/*  69 */       BLOODY_SOULADDMP = Integer.parseInt(set.getProperty("BLOODY_SOULADDMP", "12"));
/*  70 */       SOUL_OF_FLAME_DAMAGE = Double.parseDouble(set.getProperty("SOUL_OF_FLAME_DAMAGE", "1.0"));
/*  71 */       SOUL_OF_FLAME_ALLDAMAGE = Double.parseDouble(set.getProperty("SOUL_OF_FLAME_ALLDAMAGE", "1.0"));
/*  72 */       ELEMENTAL_FIRE = Double.parseDouble(set.getProperty("ELEMENTAL_FIRE", "1.0"));
/*  73 */       ELEMENTAL_FIRE_RND = Integer.parseInt(set.getProperty("ELEMENTAL_FIRE_RND", "33"));
/*  74 */       STRIKER_GALE_1 = Integer.parseInt(set.getProperty("STRIKER_GALE_1", "5"));
/*  75 */       STRIKER_GALE_2 = Integer.parseInt(set.getProperty("STRIKER_GALE_2", "10"));
/*  76 */       STRIKER_GALE_3 = Integer.parseInt(set.getProperty("STRIKER_GALE_3", "15"));
/*  77 */       STRIKER_GALE_INT = Double.parseDouble(set.getProperty("STRIKER_GALE_INT", "0"));
/*  78 */       STRIKER_GALE_MR = Double.parseDouble(set.getProperty("STRIKER_GALE_MR", "0"));
/*  79 */       DOWN_ER = Integer.parseInt(set.getProperty("DOWN_ER", "5"));
/*  80 */       POLLUTE_WATER_RND_1 = Integer.parseInt(set.getProperty("POLLUTE_WATER_RND_1", "5"));
/*  81 */       POLLUTE_WATER_RND_2 = Integer.parseInt(set.getProperty("POLLUTE_WATER_RND_2", "10"));
/*  82 */       POLLUTE_WATER_RND_3 = Integer.parseInt(set.getProperty("POLLUTE_WATER_RND_3", "15"));
/*  83 */       POLLUTE_WATER_INT = Double.parseDouble(set.getProperty("POLLUTE_WATER_INT", "0"));
/*  84 */       POLLUTE_WATER_MR = Double.parseDouble(set.getProperty("POLLUTE_WATER_MR", "0"));
/*  85 */       EARTH_BIND_1 = Integer.parseInt(set.getProperty("EARTH_BIND_1", "5"));
/*  86 */       EARTH_BIND_2 = Integer.parseInt(set.getProperty("EARTH_BIND_2", "10"));
/*  87 */       EARTH_BIND_3 = Integer.parseInt(set.getProperty("EARTH_BIND_3", "15"));
/*  88 */       EARTH_BIND_INT = Double.parseDouble(set.getProperty("EARTH_BIND_INT", "0"));
/*  89 */       EARTH_BIND_MR = Double.parseDouble(set.getProperty("EARTH_BIND_MR", "0"));
/*  90 */       ERASE_MAGIC_1 = Integer.parseInt(set.getProperty("ERASE_MAGIC_1", "5"));
/*  91 */       ERASE_MAGIC_2 = Integer.parseInt(set.getProperty("ERASE_MAGIC_2", "10"));
/*  92 */       ERASE_MAGIC_3 = Integer.parseInt(set.getProperty("ERASE_MAGIC_3", "15"));
/*  93 */       ERASE_MAGIC_INT = Double.parseDouble(set.getProperty("ERASE_MAGIC_INT", "0"));
/*  94 */       ERASE_MAGIC_MR = Double.parseDouble(set.getProperty("ERASE_MAGIC_MR", "0"));
/*  95 */       AREA_OF_SILENCE_1 = Integer.parseInt(set.getProperty("AREA_OF_SILENCE_1", "5"));
/*  96 */       AREA_OF_SILENCE_2 = Integer.parseInt(set.getProperty("AREA_OF_SILENCE_2", "10"));
/*  97 */       AREA_OF_SILENCE_3 = Integer.parseInt(set.getProperty("AREA_OF_SILENCE_3", "15"));
/*  98 */       AREA_OF_SILENCE_INT = Double.parseDouble(set.getProperty("AREA_OF_SILENCE_INT", "0"));
/*  99 */       AREA_OF_SILENCE_MR = Double.parseDouble(set.getProperty("AREA_OF_SILENCE_MR", "0"));
/* 100 */       ENTANGLE_1 = Integer.parseInt(set.getProperty("ENTANGLE_1", "5"));
/* 101 */       ENTANGLE_2 = Integer.parseInt(set.getProperty("ENTANGLE_2", "10"));
/* 102 */       ENTANGLE_3 = Integer.parseInt(set.getProperty("ENTANGLE_3", "15"));
/* 103 */       ENTANGLE_INT = Double.parseDouble(set.getProperty("ENTANGLE_INT", "0"));
/* 104 */       ENTANGLE_MR = Double.parseDouble(set.getProperty("ENTANGLE_MR", "0"));
/* 105 */       WIND_SHACKLE_1 = Integer.parseInt(set.getProperty("WIND_SHACKLE_1", "5"));
/* 106 */       WIND_SHACKLE_2 = Integer.parseInt(set.getProperty("WIND_SHACKLE_2", "10"));
/* 107 */       WIND_SHACKLE_3 = Integer.parseInt(set.getProperty("WIND_SHACKLE_3", "15"));
/* 108 */       WIND_SHACKLE_INT = Double.parseDouble(set.getProperty("WIND_SHACKLE_INT", "0"));
/* 109 */       WIND_SHACKLE_MR = Double.parseDouble(set.getProperty("WIND_SHACKLE_MR", "0"));
/* 110 */     } catch (Exception e) {
/* 111 */       throw new ConfigErrorException("設置檔案遺失: ./config/妖精_技能設定表.properties");
/*     */     } finally {
/* 113 */       set.clear();
/* 114 */       _log.info("Config/妖精_技能設定表讀取完成 (" + timer.get() + "ms)");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigElfSkill.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */