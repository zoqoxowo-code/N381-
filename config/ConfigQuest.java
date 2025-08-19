/*     */ package com.lineage.config;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.Properties;
/*     */ import org.apache.commons.logging.Log;
/*     */ 
/*     */ public final class ConfigQuest {
/*     */   public static int QuestMap_Time;
/*     */   public static int Time;
/*     */   public static int Quest1;
/*     */   public static int Quest2;
/*     */   public static int Quest3;
/*     */   public static int Quest4;
/*     */   public static int Quest5;
/*     */   public static int Quest6;
/*     */   public static int Quest7;
/*     */   public static int Quest8;
/*     */   public static int Quest9;
/*     */   public static int Quest10;
/*     */   public static int Quest11;
/*     */   public static int Quest12;
/*     */   public static int Quest13;
/*     */   public static int Quest14;
/*     */   public static int Quest15;
/*     */   public static int Quest16;
/*     */   public static int Quest17;
/*     */   public static int Quest18;
/*     */   public static int Quest19;
/*     */   public static int Quest20;
/*     */   public static int Quest21;
/*     */   public static int Quest22;
/*     */   public static int Quest23;
/*     */   public static int Quest24;
/*     */   public static int Quest25;
/*     */   public static int Quest26;
/*     */   public static int Quest27;
/*     */   public static int Quest28;
/*     */   public static int Quest29;
/*     */   public static int Quest30;
/*     */   public static int Quest31;
/*     */   public static int Quest32;
/*     */   public static int Quest33;
/*     */   public static int Quest34;
/*     */   public static int Quest35;
/*     */   public static int Quest36;
/*     */   public static int Quest37;
/*     */   public static int Quest38;
/*     */   public static int Quest39;
/*     */   public static int Quest40;
/*     */   public static int Quest41;
/*     */   public static int Quest42;
/*     */   public static int Quest43;
/*     */   public static int Quest44;
/*     */   public static int Quest45;
/*     */   public static int Quest46;
/*     */   public static int Quest47;
/*     */   public static int Quest48;
/*     */   public static int Quest49;
/*     */   public static int Quest50;
/*     */   private static Log _log;
/*     */   private static final String OTHER_SETTINGS_FILE = "./config/其他控制端/任務重置設定表.properties";
/*     */   
/*     */   public static void load() throws ConfigErrorException {
/*  67 */     Properties set = new Properties();
/*     */     try {
/*  69 */       InputStream is = new FileInputStream(new File("./config/其他控制端/任務重置設定表.properties"));
/*  70 */       InputStreamReader isr = new InputStreamReader(is, "utf-8");
/*  71 */       set.load(isr);
/*  72 */       is.close();
/*  73 */       QuestMap_Time = Integer.parseInt(set.getProperty("QuestMap_Time", "0"));
/*  74 */       Time = Integer.parseInt(set.getProperty("Time", "0"));
/*  75 */       Quest1 = Integer.parseInt(set.getProperty("Quest1", "0"));
/*  76 */       Quest2 = Integer.parseInt(set.getProperty("Quest2", "0"));
/*  77 */       Quest3 = Integer.parseInt(set.getProperty("Quest3", "0"));
/*  78 */       Quest4 = Integer.parseInt(set.getProperty("Quest4", "0"));
/*  79 */       Quest5 = Integer.parseInt(set.getProperty("Quest5", "0"));
/*  80 */       Quest6 = Integer.parseInt(set.getProperty("Quest6", "0"));
/*  81 */       Quest7 = Integer.parseInt(set.getProperty("Quest7", "0"));
/*  82 */       Quest8 = Integer.parseInt(set.getProperty("Quest8", "0"));
/*  83 */       Quest9 = Integer.parseInt(set.getProperty("Quest9", "0"));
/*  84 */       Quest10 = Integer.parseInt(set.getProperty("Quest10", "0"));
/*  85 */       Quest11 = Integer.parseInt(set.getProperty("Quest11", "0"));
/*  86 */       Quest12 = Integer.parseInt(set.getProperty("Quest12", "0"));
/*  87 */       Quest13 = Integer.parseInt(set.getProperty("Quest13", "0"));
/*  88 */       Quest14 = Integer.parseInt(set.getProperty("Quest14", "0"));
/*  89 */       Quest15 = Integer.parseInt(set.getProperty("Quest15", "0"));
/*  90 */       Quest16 = Integer.parseInt(set.getProperty("Quest16", "0"));
/*  91 */       Quest17 = Integer.parseInt(set.getProperty("Quest17", "0"));
/*  92 */       Quest18 = Integer.parseInt(set.getProperty("Quest18", "0"));
/*  93 */       Quest19 = Integer.parseInt(set.getProperty("Quest19", "0"));
/*  94 */       Quest20 = Integer.parseInt(set.getProperty("Quest20", "0"));
/*  95 */       Quest21 = Integer.parseInt(set.getProperty("Quest21", "0"));
/*  96 */       Quest22 = Integer.parseInt(set.getProperty("Quest22", "0"));
/*  97 */       Quest23 = Integer.parseInt(set.getProperty("Quest23", "0"));
/*  98 */       Quest24 = Integer.parseInt(set.getProperty("Quest24", "0"));
/*  99 */       Quest25 = Integer.parseInt(set.getProperty("Quest25", "0"));
/* 100 */       Quest26 = Integer.parseInt(set.getProperty("Quest26", "0"));
/* 101 */       Quest27 = Integer.parseInt(set.getProperty("Quest27", "0"));
/* 102 */       Quest28 = Integer.parseInt(set.getProperty("Quest28", "0"));
/* 103 */       Quest29 = Integer.parseInt(set.getProperty("Quest29", "0"));
/* 104 */       Quest30 = Integer.parseInt(set.getProperty("Quest30", "0"));
/* 105 */       Quest31 = Integer.parseInt(set.getProperty("Quest31", "0"));
/* 106 */       Quest32 = Integer.parseInt(set.getProperty("Quest32", "0"));
/* 107 */       Quest33 = Integer.parseInt(set.getProperty("Quest33", "0"));
/* 108 */       Quest34 = Integer.parseInt(set.getProperty("Quest34", "0"));
/* 109 */       Quest35 = Integer.parseInt(set.getProperty("Quest35", "0"));
/* 110 */       Quest36 = Integer.parseInt(set.getProperty("Quest36", "0"));
/* 111 */       Quest37 = Integer.parseInt(set.getProperty("Quest37", "0"));
/* 112 */       Quest38 = Integer.parseInt(set.getProperty("Quest38", "0"));
/* 113 */       Quest39 = Integer.parseInt(set.getProperty("Quest39", "0"));
/* 114 */       Quest40 = Integer.parseInt(set.getProperty("Quest40", "0"));
/* 115 */       Quest41 = Integer.parseInt(set.getProperty("Quest41", "0"));
/* 116 */       Quest42 = Integer.parseInt(set.getProperty("Quest42", "0"));
/* 117 */       Quest43 = Integer.parseInt(set.getProperty("Quest43", "0"));
/* 118 */       Quest44 = Integer.parseInt(set.getProperty("Quest44", "0"));
/* 119 */       Quest45 = Integer.parseInt(set.getProperty("Quest45", "0"));
/* 120 */       Quest46 = Integer.parseInt(set.getProperty("Quest46", "0"));
/* 121 */       Quest47 = Integer.parseInt(set.getProperty("Quest47", "0"));
/* 122 */       Quest48 = Integer.parseInt(set.getProperty("Quest48", "0"));
/* 123 */       Quest49 = Integer.parseInt(set.getProperty("Quest49", "0"));
/* 124 */       Quest50 = Integer.parseInt(set.getProperty("Quest50", "0"));
/* 125 */     } catch (Exception e) {
/* 126 */       throw new ConfigErrorException("設置檔案遺失: ./config/其他控制端/任務重置設定表.properties");
/*     */     } finally {
/* 128 */       set.clear();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigQuest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */