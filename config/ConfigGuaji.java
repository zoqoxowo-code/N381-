/*    */ package com.lineage.config;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.Properties;
/*    */ import java.util.StringTokenizer;
/*    */ import org.apache.commons.logging.Log;
/*    */ 
/*    */ public final class ConfigGuaji {
/*    */   public static boolean Guaji_tele;
/*    */   public static int Guaji_tele_item;
/*    */   public static int Guaji_tele_itemcount;
/*    */   public static int itemadena1;
/*    */   public static int itemadena2;
/*    */   public static int itemadena3;
/*    */   public static int itemadena4;
/*    */   public static int itemadena5;
/*    */   public static int itemadena6;
/*    */   public static int itemadena7;
/*    */   public static int itemadena8;
/*    */   public static int itemadena9;
/*    */   public static int itemadena21;
/*    */   public static int itemadena22;
/*    */   public static boolean followtele;
/*    */   public static boolean Guaji_save;
/*    */   public static int Guaji_level;
/*    */   public static String guaji;
/*    */   public static double adena;
/*    */   public static double guajiexp2;
/*    */   public static boolean checktimeguaji;
/*    */   public static boolean Guaji_action;
/*    */   public static int[] Guaji_map_stopskill;
/*    */   public static int[] GUAJI_ITEM;
/*    */   public static double guaji_hu_exp;
/*    */   public static double guaji_hu_adena;
/*    */   public static int guaji_check;
/*    */   private static Log _log;
/*    */   private static final String OTHER_SETTINGS_FILE = "./config/其他控制端/掛機相關設置表.properties";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 43 */     Properties set = new Properties();
/*    */     try {
/* 45 */       InputStream is = new FileInputStream(new File("./config/其他控制端/掛機相關設置表.properties"));
/* 46 */       InputStreamReader isr = new InputStreamReader(is, "utf-8");
/* 47 */       set.load(isr);
/* 48 */       is.close();
/* 49 */       guaji_hu_exp = Double.parseDouble(set.getProperty("guaji_hu_exp", "0.0"));
/* 50 */       guaji_hu_adena = Double.parseDouble(set.getProperty("guaji_hu_adena", "0.0"));
/* 51 */       guaji_check = Integer.parseInt(set.getProperty("guaji_check", "100"));
/* 52 */       Guaji_tele = Boolean.parseBoolean(set.getProperty("Guaji_tele", "true"));
/* 53 */       Guaji_tele_item = Integer.parseInt(set.getProperty("Guaji_tele_item", "100"));
/* 54 */       Guaji_tele_itemcount = Integer.parseInt(set.getProperty("Guaji_tele_itemcount", "100"));
/* 55 */       guaji = set.getProperty("guaji", "");
/* 56 */       adena = Double.parseDouble(set.getProperty("adena", "0.0"));
/* 57 */       if (adena < 0.0D) {
/* 58 */         adena = 0.0D;
/*    */       }
/* 60 */       itemadena1 = Integer.parseInt(set.getProperty("itemadena1", "100"));
/* 61 */       itemadena2 = Integer.parseInt(set.getProperty("itemadena2", "100"));
/* 62 */       itemadena3 = Integer.parseInt(set.getProperty("itemadena3", "100"));
/* 63 */       itemadena4 = Integer.parseInt(set.getProperty("itemadena4", "100"));
/* 64 */       itemadena5 = Integer.parseInt(set.getProperty("itemadena5", "100"));
/* 65 */       itemadena6 = Integer.parseInt(set.getProperty("itemadena6", "100"));
/* 66 */       itemadena7 = Integer.parseInt(set.getProperty("itemadena7", "100"));
/* 67 */       itemadena8 = Integer.parseInt(set.getProperty("itemadena8", "100"));
/* 68 */       itemadena9 = Integer.parseInt(set.getProperty("itemadena9", "100"));
/* 69 */       itemadena21 = Integer.parseInt(set.getProperty("itemadena21", "100"));
/* 70 */       itemadena22 = Integer.parseInt(set.getProperty("itemadena22", "100"));
/* 71 */       Guaji_save = Boolean.parseBoolean(set.getProperty("Guaji_save", "true"));
/* 72 */       Guaji_level = Integer.parseInt(set.getProperty("Guaji_level", "100"));
/* 73 */       GUAJI_ITEM = toIntArray(set.getProperty("GUAJI_ITEM", ""), ",");
/* 74 */       Guaji_map_stopskill = toIntArray(set.getProperty("Guaji_map_stopskill", ""), ",");
/* 75 */       checktimeguaji = Boolean.parseBoolean(set.getProperty("checktimeguaji", "true"));
/* 76 */       followtele = Boolean.parseBoolean(set.getProperty("followtele", "true"));
/* 77 */       guajiexp2 = Double.parseDouble(set.getProperty("guajiexp2", "0.0"));
/* 78 */       Guaji_action = Boolean.parseBoolean(set.getProperty("Guaji_action", "true"));
/* 79 */     } catch (Exception e) {
/* 80 */       throw new ConfigErrorException("設置檔案遺失: ./config/其他控制端/掛機相關設置表.properties");
/*    */     } finally {
/* 82 */       set.clear();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static int[] toIntArray(String text, String type) {
/* 87 */     StringTokenizer st = new StringTokenizer(text, type);
/* 88 */     int[] iReturn = new int[st.countTokens()];
/* 89 */     int i = 0;
/* 90 */     while (i < iReturn.length) {
/* 91 */       iReturn[i] = Integer.parseInt(st.nextToken());
/* 92 */       i++;
/*    */     } 
/* 94 */     return iReturn;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigGuaji.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */