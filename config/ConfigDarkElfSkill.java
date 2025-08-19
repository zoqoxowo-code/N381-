/*    */ package com.lineage.config;
/*    */ 
/*    */ import com.lineage.server.utils.PerformanceTimer;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.util.Properties;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public final class ConfigDarkElfSkill {
/* 12 */   private static final Log _log = LogFactory.getLog(ConfigDarkElfSkill.class);
/*    */   public static int ARMOR_BREAK_CHANCE_1;
/*    */   public static int ARMOR_BREAK_CHANCE_2;
/*    */   public static int ARMOR_BREAK_CHANCE_3;
/*    */   public static double ARMOR_BREAK_DMG;
/*    */   public static int BURNING_CHANCE;
/*    */   public static double BURNING_DMG;
/*    */   public static int DOUBLE_BREAK_CHANCE;
/*    */   public static double DOUBLE_BREAK_DMG;
/*    */   public static int DARK_BLIND_1;
/*    */   public static int DARK_BLIND_2;
/*    */   public static int DARK_BLIND_3;
/*    */   public static double DARK_BLIND_INT;
/*    */   public static double DARK_BLIND_MR;
/*    */   private static final String CONFIG_FILE = "./config/黑暗妖精_技能設定表.properties";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 29 */     PerformanceTimer timer = new PerformanceTimer();
/* 30 */     Properties set = new Properties();
/*    */     try {
/* 32 */       InputStream is = new FileInputStream(new File("./config/黑暗妖精_技能設定表.properties"));
/* 33 */       set.load(is);
/* 34 */       is.close();
/* 35 */       BURNING_CHANCE = Integer.parseInt(set.getProperty("BURNING_CHANCE", "15"));
/* 36 */       ARMOR_BREAK_DMG = Double.parseDouble(set.getProperty("ARMOR_BREAK_DMG", "1.3"));
/* 37 */       BURNING_DMG = Double.parseDouble(set.getProperty("BURNING_DMG", "1.3"));
/* 38 */       DOUBLE_BREAK_CHANCE = Integer.parseInt(set.getProperty("DOUBLE_BREAK_CHANCE", "15"));
/* 39 */       DOUBLE_BREAK_DMG = Double.parseDouble(set.getProperty("DOUBLE_BREAK_DMG", "1.5"));
/* 40 */       DARK_BLIND_1 = Integer.parseInt(set.getProperty("DARK_BLIND_1", "5"));
/* 41 */       DARK_BLIND_2 = Integer.parseInt(set.getProperty("DARK_BLIND_2", "10"));
/* 42 */       DARK_BLIND_3 = Integer.parseInt(set.getProperty("DARK_BLIND_3", "15"));
/* 43 */       DARK_BLIND_INT = Double.parseDouble(set.getProperty("DARK_BLIND_INT", "0"));
/* 44 */       DARK_BLIND_MR = Double.parseDouble(set.getProperty("DARK_BLIND_MR", "0"));
/* 45 */       ARMOR_BREAK_CHANCE_1 = Integer.parseInt(set.getProperty("ARMOR_BREAK_CHANCE_1", "5"));
/* 46 */       ARMOR_BREAK_CHANCE_2 = Integer.parseInt(set.getProperty("ARMOR_BREAK_CHANCE_2", "10"));
/* 47 */       ARMOR_BREAK_CHANCE_3 = Integer.parseInt(set.getProperty("ARMOR_BREAK_CHANCE_3", "15"));
/* 48 */     } catch (Exception e) {
/* 49 */       throw new ConfigErrorException("設置檔案遺失: ./config/黑暗妖精_技能設定表.properties");
/*    */     } finally {
/* 51 */       set.clear();
/* 52 */       _log.info("Config/黑暗妖精_技能設定表讀取完成 (" + timer.get() + "ms)");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigDarkElfSkill.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */