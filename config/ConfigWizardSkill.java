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
/*     */ public final class ConfigWizardSkill {
/*  12 */   private static final Log _log = LogFactory.getLog(ConfigWizardSkill.class);
/*     */   public static int DISINTEGRATE_RND;
/*     */   public static int DISINTEGRATE_CRITICAL_RND;
/*     */   public static int SPR;
/*     */   public static int CRITICAL_SPR;
/*     */   public static double IMMUNE_TO_HARM;
/*     */   public static int SILENCE_1;
/*     */   public static int SILENCE_2;
/*     */   public static int SILENCE_3;
/*     */   public static double SILENCE_INT;
/*     */   public static double SILENCE_MR;
/*     */   public static int CURSE_PARALYZE_1;
/*     */   public static int CURSE_PARALYZE_2;
/*     */   public static int CURSE_PARALYZE_3;
/*     */   public static double CURSE_PARALYZE_INT;
/*     */   public static double CURSE_PARALYZE_MR;
/*     */   public static int CURSE_READY_TIME;
/*     */   public static int CURSE_TIME;
/*     */   public static int CANCELLATION_1;
/*     */   public static int CANCELLATION_2;
/*     */   public static int CANCELLATION_3;
/*     */   public static double CANCELLATION_INT;
/*     */   public static double CANCELLATION_MR;
/*     */   public static int ICE_LANCE_1;
/*     */   public static int ICE_LANCE_2;
/*     */   public static int ICE_LANCE_3;
/*     */   public static double ICE_LANCE_INT;
/*     */   public static double ICE_LANCE_MR;
/*     */   public static int DECAY_POTION_1;
/*     */   public static int DECAY_POTION_2;
/*     */   public static int DECAY_POTION_3;
/*     */   public static double DECAY_POTION_INT;
/*     */   public static double DECAY_POTION_MR;
/*     */   public static int FOG_OF_SLEEPING_1;
/*     */   public static int FOG_OF_SLEEPING_2;
/*     */   public static int FOG_OF_SLEEPING_3;
/*     */   public static double FOG_OF_SLEEPING_INT;
/*     */   public static double FOG_OF_SLEEPING_MR;
/*     */   public static int DARKNESS_1;
/*     */   public static int DARKNESS_2;
/*     */   public static int DARKNESS_3;
/*     */   public static double DARKNESS_INT;
/*     */   public static double DARKNESS_MR;
/*     */   private static final String CONFIG_FILE = "./config/法師_技能設定表.properties";
/*     */   
/*     */   public static void load() throws ConfigErrorException {
/*  58 */     PerformanceTimer timer = new PerformanceTimer();
/*  59 */     Properties set = new Properties();
/*     */     try {
/*  61 */       InputStream is = new FileInputStream(new File("./config/法師_技能設定表.properties"));
/*  62 */       set.load(is);
/*  63 */       is.close();
/*  64 */       CRITICAL_SPR = Integer.parseInt(set.getProperty("CRITICAL_SPR", "11748"));
/*  65 */       DISINTEGRATE_CRITICAL_RND = Integer.parseInt(set.getProperty("DISINTEGRATE_CRITICAL_RND", "1"));
/*  66 */       SPR = Integer.parseInt(set.getProperty("SPR", "11748"));
/*  67 */       DISINTEGRATE_RND = Integer.parseInt(set.getProperty("DISINTEGRATE_RND", "1"));
/*  68 */       IMMUNE_TO_HARM = Double.parseDouble(set.getProperty("IMMUNE_TO_HARM", "2.0"));
/*  69 */       SILENCE_1 = Integer.parseInt(set.getProperty("SILENCE_1", "5"));
/*  70 */       SILENCE_2 = Integer.parseInt(set.getProperty("SILENCE_2", "10"));
/*  71 */       SILENCE_3 = Integer.parseInt(set.getProperty("SILENCE_3", "15"));
/*  72 */       SILENCE_INT = Double.parseDouble(set.getProperty("SILENCE_INT", "0"));
/*  73 */       SILENCE_MR = Double.parseDouble(set.getProperty("SILENCE_MR", "0"));
/*  74 */       CURSE_PARALYZE_1 = Integer.parseInt(set.getProperty("CURSE_PARALYZE_1", "5"));
/*  75 */       CURSE_PARALYZE_2 = Integer.parseInt(set.getProperty("CURSE_PARALYZE_2", "10"));
/*  76 */       CURSE_PARALYZE_3 = Integer.parseInt(set.getProperty("CURSE_PARALYZE_3", "15"));
/*  77 */       CURSE_PARALYZE_INT = Double.parseDouble(set.getProperty("CURSE_PARALYZE_INT", "0"));
/*  78 */       CURSE_PARALYZE_MR = Double.parseDouble(set.getProperty("CURSE_PARALYZE_MR", "0"));
/*  79 */       CURSE_READY_TIME = Integer.parseInt(set.getProperty("CURSE_READY_TIME", "5"));
/*  80 */       CURSE_TIME = Integer.parseInt(set.getProperty("CURSE_TIME", "4"));
/*  81 */       CANCELLATION_1 = Integer.parseInt(set.getProperty("CANCELLATION_1", "5"));
/*  82 */       CANCELLATION_2 = Integer.parseInt(set.getProperty("CANCELLATION_2", "10"));
/*  83 */       CANCELLATION_3 = Integer.parseInt(set.getProperty("CANCELLATION_3", "15"));
/*  84 */       CANCELLATION_INT = Double.parseDouble(set.getProperty("CANCELLATION_INT", "0"));
/*  85 */       CANCELLATION_MR = Double.parseDouble(set.getProperty("CANCELLATION_MR", "0"));
/*  86 */       ICE_LANCE_1 = Integer.parseInt(set.getProperty("ICE_LANCE_1", "5"));
/*  87 */       ICE_LANCE_2 = Integer.parseInt(set.getProperty("ICE_LANCE_2", "10"));
/*  88 */       ICE_LANCE_3 = Integer.parseInt(set.getProperty("ICE_LANCE_3", "15"));
/*  89 */       ICE_LANCE_INT = Double.parseDouble(set.getProperty("ICE_LANCE_INT", "0"));
/*  90 */       ICE_LANCE_MR = Double.parseDouble(set.getProperty("ICE_LANCE_MR", "0"));
/*  91 */       DECAY_POTION_1 = Integer.parseInt(set.getProperty("DECAY_POTION_1", "5"));
/*  92 */       DECAY_POTION_2 = Integer.parseInt(set.getProperty("DECAY_POTION_2", "10"));
/*  93 */       DECAY_POTION_3 = Integer.parseInt(set.getProperty("DECAY_POTION_3", "15"));
/*  94 */       DECAY_POTION_INT = Double.parseDouble(set.getProperty("DECAY_POTION_INT", "0"));
/*  95 */       DECAY_POTION_MR = Double.parseDouble(set.getProperty("DECAY_POTION_MR", "0"));
/*  96 */       FOG_OF_SLEEPING_1 = Integer.parseInt(set.getProperty("FOG_OF_SLEEPING_1", "5"));
/*  97 */       FOG_OF_SLEEPING_2 = Integer.parseInt(set.getProperty("FOG_OF_SLEEPING_2", "10"));
/*  98 */       FOG_OF_SLEEPING_3 = Integer.parseInt(set.getProperty("FOG_OF_SLEEPING_3", "15"));
/*  99 */       FOG_OF_SLEEPING_INT = Double.parseDouble(set.getProperty("FOG_OF_SLEEPING_INT", "0"));
/* 100 */       FOG_OF_SLEEPING_MR = Double.parseDouble(set.getProperty("FOG_OF_SLEEPING_MR", "0"));
/* 101 */       DARKNESS_1 = Integer.parseInt(set.getProperty("DARKNESS_1", "5"));
/* 102 */       DARKNESS_2 = Integer.parseInt(set.getProperty("DARKNESS_2", "10"));
/* 103 */       DARKNESS_3 = Integer.parseInt(set.getProperty("DARKNESS_3", "15"));
/* 104 */       DARKNESS_INT = Double.parseDouble(set.getProperty("DARKNESS_INT", "0"));
/* 105 */       DARKNESS_MR = Double.parseDouble(set.getProperty("DARKNESS_MR", "0"));
/* 106 */     } catch (Exception e) {
/* 107 */       throw new ConfigErrorException("設置檔案遺失: ./config/法師_技能設定表.properties");
/*     */     } finally {
/* 109 */       set.clear();
/* 110 */       _log.info("Config/法師_技能設定表讀取完成 (" + timer.get() + "ms)");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigWizardSkill.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */