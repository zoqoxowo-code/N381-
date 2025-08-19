/*    */ package com.lineage.config;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.Properties;
/*    */ import org.apache.commons.logging.Log;
/*    */ 
/*    */ public final class Configtf {
/*    */   public static int retfitem;
/*    */   public static int retfitemcount;
/*    */   public static String msg0;
/*    */   public static int tftype1;
/*    */   public static int tftype2;
/*    */   public static int tftype3;
/*    */   public static int tftype4;
/*    */   public static int tftype5;
/*    */   public static int tftype6;
/*    */   public static int tftype7;
/*    */   public static int tftype8;
/*    */   public static int tftype9;
/*    */   public static int tftype10;
/*    */   public static int tfup;
/*    */   public static int tfup1;
/*    */   public static int tfup2;
/*    */   public static int tfup3;
/*    */   public static int tfup4;
/*    */   public static int tfup5;
/*    */   public static int tfup6;
/*    */   public static int tfup7;
/*    */   public static int tfup8;
/*    */   public static int tfup9;
/*    */   public static int tfup10;
/*    */   private static Log _log;
/*    */   private static final String OTHER_SETTINGS_FILE = "./config/其他控制端/天賦控制表.properties";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 39 */     Properties set = new Properties();
/*    */     try {
/* 41 */       InputStream is = new FileInputStream(new File("./config/其他控制端/天賦控制表.properties"));
/* 42 */       InputStreamReader isr = new InputStreamReader(is, "utf-8");
/* 43 */       set.load(isr);
/* 44 */       is.close();
/* 45 */       retfitem = Integer.parseInt(set.getProperty("retfitem", "1"));
/* 46 */       retfitemcount = Integer.parseInt(set.getProperty("retfitemcount", "1"));
/* 47 */       tftype1 = Integer.parseInt(set.getProperty("tftype1", "1"));
/* 48 */       tftype2 = Integer.parseInt(set.getProperty("tftype2", "1"));
/* 49 */       tftype3 = Integer.parseInt(set.getProperty("tftype3", "1"));
/* 50 */       tftype4 = Integer.parseInt(set.getProperty("tftype4", "1"));
/* 51 */       tftype5 = Integer.parseInt(set.getProperty("tftype5", "1"));
/* 52 */       tftype6 = Integer.parseInt(set.getProperty("tftype6", "1"));
/* 53 */       tftype7 = Integer.parseInt(set.getProperty("tftype7", "1"));
/* 54 */       tftype8 = Integer.parseInt(set.getProperty("tftype8", "1"));
/* 55 */       tftype9 = Integer.parseInt(set.getProperty("tftype9", "1"));
/* 56 */       tftype10 = Integer.parseInt(set.getProperty("tftype10", "1"));
/* 57 */       tfup = Integer.parseInt(set.getProperty("tfup", "1"));
/* 58 */       msg0 = set.getProperty("msg0", "");
/* 59 */       tfup1 = Integer.parseInt(set.getProperty("tfup1", "1"));
/* 60 */       tfup2 = Integer.parseInt(set.getProperty("tfup2", "1"));
/* 61 */       tfup3 = Integer.parseInt(set.getProperty("tfup3", "1"));
/* 62 */       tfup4 = Integer.parseInt(set.getProperty("tfup4", "1"));
/* 63 */       tfup5 = Integer.parseInt(set.getProperty("tfup5", "1"));
/* 64 */       tfup6 = Integer.parseInt(set.getProperty("tfup6", "1"));
/* 65 */       tfup7 = Integer.parseInt(set.getProperty("tfup7", "1"));
/* 66 */       tfup8 = Integer.parseInt(set.getProperty("tfup8", "1"));
/* 67 */       tfup9 = Integer.parseInt(set.getProperty("tfup9", "1"));
/* 68 */       tfup10 = Integer.parseInt(set.getProperty("tfup10", "1"));
/* 69 */     } catch (Exception e) {
/* 70 */       throw new ConfigErrorException("設置檔案遺失: ./config/其他控制端/天賦控制表.properties");
/*    */     } finally {
/* 72 */       set.clear();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\Configtf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */