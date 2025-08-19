/*    */ package com.lineage.config;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.Properties;
/*    */ import org.apache.commons.logging.Log;
/*    */ 
/*    */ public final class ConfigWho {
/* 11 */   public static int RATE_XP_WHO = 1;
/*    */   public static boolean whoitemeq;
/*    */   public static boolean check_who_exp;
/*    */   public static int whoexp;
/*    */   public static boolean check_who_armor;
/*    */   public static int whoarmor;
/*    */   public static boolean check_who_weapon;
/*    */   public static int whoweapon;
/*    */   private static Log _log;
/*    */   private static final String OTHER_SETTINGS_FILE = "./config/其他控制端/WHO設定表.properties";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 23 */     Properties set = new Properties();
/*    */     try {
/* 25 */       InputStream is = new FileInputStream(new File("./config/其他控制端/WHO設定表.properties"));
/* 26 */       InputStreamReader isr = new InputStreamReader(is, "utf-8");
/* 27 */       set.load(isr);
/* 28 */       is.close();
/* 29 */       RATE_XP_WHO = Integer.parseInt(set.getProperty("rate_xp_who", "1"));
/* 30 */       whoitemeq = Boolean.parseBoolean(set.getProperty("whoitemeq", "false"));
/* 31 */       check_who_exp = Boolean.parseBoolean(set.getProperty("check_who_exp", "false"));
/* 32 */       whoexp = Integer.parseInt(set.getProperty("whoexp", "1"));
/* 33 */       check_who_weapon = Boolean.parseBoolean(set.getProperty("check_who_weapon", "false"));
/* 34 */       whoweapon = Integer.parseInt(set.getProperty("whoweapon", "1"));
/* 35 */       check_who_armor = Boolean.parseBoolean(set.getProperty("check_who_armor", "false"));
/* 36 */       whoarmor = Integer.parseInt(set.getProperty("whoarmor", "1"));
/* 37 */     } catch (Exception e) {
/* 38 */       throw new ConfigErrorException("設置檔案遺失: ./config/其他控制端/WHO設定表.properties");
/*    */     } finally {
/* 40 */       set.clear();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigWho.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */