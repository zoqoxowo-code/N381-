/*    */ package com.lineage.config;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.Properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ConfigAi
/*    */ {
/*    */   public static boolean longntimeai_3;
/*    */   public static int logintime;
/*    */   public static int aitimeran;
/*    */   public static int aitimelast;
/*    */   public static boolean ALTE;
/*    */   public static int aialteitem;
/* 39 */   public static int aialteitemcount = 0;
/* 40 */   public static int aiX = 0; public static boolean kickai;
/* 41 */   public static int aiY = 0;
/* 42 */   public static int aimap = 0;
/*    */   public static String msg0;
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 46 */     Properties set = new Properties();
/*    */     try {
/* 48 */       InputStream is = new FileInputStream(new File("./config/其他控制端/外掛偵測.properties"));
/* 49 */       InputStreamReader isr = new InputStreamReader(is, "utf-8");
/* 50 */       set.load(isr);
/* 51 */       is.close();
/* 52 */       longntimeai_3 = Boolean.parseBoolean(set.getProperty("longntimeai_3", "false"));
/* 53 */       logintime = Integer.parseInt(set.getProperty("logintime", "0"));
/* 54 */       aitimeran = Integer.parseInt(set.getProperty("aitimeran", "0"));
/* 55 */       aitimelast = Integer.parseInt(set.getProperty("aitimelast", "0"));
/* 56 */       ALTE = Boolean.parseBoolean(set.getProperty("ALTE", "false"));
/* 57 */       aialteitem = Integer.parseInt(set.getProperty("aialteitem", "0"));
/* 58 */       aialteitemcount = Integer.parseInt(set.getProperty("aialteitemcount", "0"));
/* 59 */       kickai = Boolean.parseBoolean(set.getProperty("kickai", "false"));
/* 60 */       aiX = Integer.parseInt(set.getProperty("aiX", "0"));
/* 61 */       aiY = Integer.parseInt(set.getProperty("aiY", "0"));
/* 62 */       aimap = Integer.parseInt(set.getProperty("aimap", "0"));
/* 63 */       msg0 = set.getProperty("msg0", "");
/* 64 */       msg1 = set.getProperty("msg1", "");
/* 65 */       msg2 = set.getProperty("msg2", "");
/* 66 */       msg3 = set.getProperty("msg3", "");
/* 67 */       msg4 = set.getProperty("msg4", "");
/* 68 */       msg5 = set.getProperty("msg5", "");
/* 69 */       msg6 = set.getProperty("msg6", "");
/* 70 */       msg7 = set.getProperty("msg7", "");
/* 71 */       msg8 = set.getProperty("msg8", "");
/* 72 */       msg9 = set.getProperty("msg9", "");
/* 73 */       msg10 = set.getProperty("msg10", "");
/* 74 */       msg11 = set.getProperty("msg11", "");
/* 75 */       msg12 = set.getProperty("msg12", "");
/* 76 */       AIeffect = Integer.parseInt(set.getProperty("AIeffect", "0"));
/* 77 */     } catch (Exception e) {
/* 78 */       throw new ConfigErrorException("設置檔案遺失: ./config/其他控制端/外掛偵測.properties");
/*    */     } finally {
/* 80 */       set.clear();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static String msg1;
/*    */   public static String msg2;
/*    */   public static String msg3;
/*    */   public static String msg4;
/*    */   public static String msg5;
/*    */   public static String msg6;
/*    */   public static String msg7;
/*    */   public static String msg8;
/*    */   public static String msg9;
/*    */   public static String msg10;
/*    */   public static String msg11;
/*    */   public static String msg12;
/*    */   public static int AIeffect;
/*    */   private static final String OTHER_SETTINGS_FILE = "./config/其他控制端/外掛偵測.properties";
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigAi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */