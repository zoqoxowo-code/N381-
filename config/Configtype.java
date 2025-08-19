/*    */ package com.lineage.config;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.Properties;
/*    */ import org.apache.commons.logging.Log;
/*    */ 
/*    */ public final class Configtype {
/*    */   public static int weaponbroadfail;
/*    */   public static int armorbroadfail;
/*    */   public static int weaponbroadtrue;
/*    */   public static int armorbroadtrue;
/*    */   public static int Accessoryfalse;
/*    */   public static int Accessorytrue;
/* 17 */   public static int weapon_savebroad = 0;
/* 18 */   public static int armor_savebroad = 0;
/* 19 */   public static int Accessory_savebroad = 0;
/*    */   public static String msg1_fail;
/*    */   public static String msg1_true;
/*    */   public static String msg4_fail;
/*    */   public static String msg4_true;
/*    */   public static int armorlv;
/*    */   public static int weaponlv;
/*    */   private static Log _log;
/*    */   private static final String OTHER_SETTINGS_FILE = "./config/其他控制端/武卷防捲設定表.properties";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 30 */     Properties set = new Properties();
/*    */     try {
/* 32 */       InputStream is = new FileInputStream(new File("./config/其他控制端/武卷防捲設定表.properties"));
/* 33 */       InputStreamReader isr = new InputStreamReader(is, "utf-8");
/* 34 */       set.load(isr);
/* 35 */       is.close();
/* 36 */       Accessoryfalse = Integer.parseInt(set.getProperty("Accessoryfalse", "0"));
/* 37 */       Accessorytrue = Integer.parseInt(set.getProperty("Accessorytrue", "0"));
/* 38 */       weaponbroadfail = Integer.parseInt(set.getProperty("weaponbroadfail", "0"));
/* 39 */       armorbroadfail = Integer.parseInt(set.getProperty("armorbroadfail", "0"));
/* 40 */       weaponbroadtrue = Integer.parseInt(set.getProperty("weaponbroadtrue", "0"));
/* 41 */       armorbroadtrue = Integer.parseInt(set.getProperty("armorbroadtrue", "0"));
/* 42 */       weapon_savebroad = Integer.parseInt(set.getProperty("weapon_savebroad", ""));
/* 43 */       armor_savebroad = Integer.parseInt(set.getProperty("armor_savebroad", ""));
/* 44 */       Accessory_savebroad = Integer.parseInt(set.getProperty("Accessory_savebroad", ""));
/* 45 */       msg1_fail = set.getProperty("msg1_fail", "");
/* 46 */       msg1_true = set.getProperty("msg1_true", "");
/* 47 */       msg4_fail = set.getProperty("msg4_fail", "");
/* 48 */       msg4_true = set.getProperty("msg4_true", "");
/* 49 */       armorlv = Integer.parseInt(set.getProperty("armorlv", "10"));
/* 50 */       weaponlv = Integer.parseInt(set.getProperty("weaponlv", "10"));
/* 51 */     } catch (Exception e) {
/* 52 */       throw new ConfigErrorException("設置檔案遺失: ./config/其他控制端/武卷防捲設定表.properties");
/*    */     } finally {
/* 54 */       set.clear();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\Configtype.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */