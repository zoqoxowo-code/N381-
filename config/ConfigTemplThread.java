/*    */ package com.lineage.config;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.Properties;
/*    */ import org.apache.commons.logging.Log;
/*    */ 
/*    */ public final class ConfigTemplThread {
/*    */   public static int dropitem1;
/*    */   public static int dropitem2;
/*    */   public static int dropitem3;
/*    */   public static int dropitem4;
/*    */   public static int dropitem5;
/*    */   public static int dropitem6;
/*    */   public static int dropitem7;
/*    */   public static int dropitem8;
/*    */   public static int dropitem9;
/*    */   public static int dropitem10;
/*    */   public static int dropitem11;
/*    */   public static int dropitem12;
/*    */   public static int dropitem13;
/*    */   public static int dropitem14;
/*    */   public static int dropitem15;
/*    */   public static int dropitem16;
/*    */   public static int dropitem17;
/*    */   public static int dropitem18;
/*    */   public static int dropitem19;
/*    */   public static int dropitem20;
/*    */   public static int dropitem21;
/*    */   public static int dropitem22;
/*    */   public static int dropitem23;
/*    */   public static int dropitem24;
/*    */   public static int dropitem25;
/*    */   public static int dropitem26;
/*    */   public static int dropran;
/*    */   private static Log _log;
/*    */   private static final String OTHER_SETTINGS_FILE = "./config/其他控制端/夢幻之島副本設定表.properties";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 42 */     Properties set = new Properties();
/*    */     try {
/* 44 */       InputStream is = new FileInputStream(new File("./config/其他控制端/夢幻之島副本設定表.properties"));
/* 45 */       InputStreamReader isr = new InputStreamReader(is, "utf-8");
/* 46 */       set.load(isr);
/* 47 */       is.close();
/* 48 */       dropitem1 = Integer.parseInt(set.getProperty("dropitem1", "1"));
/* 49 */       dropitem2 = Integer.parseInt(set.getProperty("dropitem2", "1"));
/* 50 */       dropitem3 = Integer.parseInt(set.getProperty("dropitem3", "1"));
/* 51 */       dropitem4 = Integer.parseInt(set.getProperty("dropitem4", "1"));
/* 52 */       dropitem5 = Integer.parseInt(set.getProperty("dropitem5", "1"));
/* 53 */       dropitem6 = Integer.parseInt(set.getProperty("dropitem6", "1"));
/* 54 */       dropitem7 = Integer.parseInt(set.getProperty("dropitem7", "1"));
/* 55 */       dropitem8 = Integer.parseInt(set.getProperty("dropitem8", "1"));
/* 56 */       dropitem9 = Integer.parseInt(set.getProperty("dropitem9", "1"));
/* 57 */       dropitem10 = Integer.parseInt(set.getProperty("dropitem10", "1"));
/* 58 */       dropitem11 = Integer.parseInt(set.getProperty("dropitem11", "1"));
/* 59 */       dropitem12 = Integer.parseInt(set.getProperty("dropitem12", "1"));
/* 60 */       dropitem13 = Integer.parseInt(set.getProperty("dropitem13", "1"));
/* 61 */       dropitem14 = Integer.parseInt(set.getProperty("dropitem14", "1"));
/* 62 */       dropitem15 = Integer.parseInt(set.getProperty("dropitem15", "1"));
/* 63 */       dropitem16 = Integer.parseInt(set.getProperty("dropitem16", "1"));
/* 64 */       dropitem17 = Integer.parseInt(set.getProperty("dropitem17", "1"));
/* 65 */       dropitem18 = Integer.parseInt(set.getProperty("dropitem18", "1"));
/* 66 */       dropitem19 = Integer.parseInt(set.getProperty("dropitem19", "1"));
/* 67 */       dropitem20 = Integer.parseInt(set.getProperty("dropitem20", "1"));
/* 68 */       dropitem21 = Integer.parseInt(set.getProperty("dropitem21", "1"));
/* 69 */       dropitem22 = Integer.parseInt(set.getProperty("dropitem22", "1"));
/* 70 */       dropitem23 = Integer.parseInt(set.getProperty("dropitem23", "1"));
/* 71 */       dropitem24 = Integer.parseInt(set.getProperty("dropitem24", "1"));
/* 72 */       dropitem25 = Integer.parseInt(set.getProperty("dropitem25", "1"));
/* 73 */       dropitem26 = Integer.parseInt(set.getProperty("dropitem26", "1"));
/* 74 */       dropran = Integer.parseInt(set.getProperty("dropran", "1"));
/* 75 */     } catch (Exception e) {
/* 76 */       throw new ConfigErrorException("設置檔案遺失: ./config/其他控制端/夢幻之島副本設定表.properties");
/*    */     } finally {
/* 78 */       set.clear();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigTemplThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */