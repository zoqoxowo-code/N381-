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
/*    */ public final class ConfigDragonKnightSkill {
/* 12 */   private static final Log _log = LogFactory.getLog(ConfigDragonKnightSkill.class);
/*    */   public static int FOE_SLAYER_RND;
/*    */   public static int FOE_SLAYER_SEC;
/*    */   public static int FOE_SLAYER_DMG;
/*    */   public static int VULNERABILITY_OTHER;
/*    */   public static int VULNERABILITY_ROM;
/*    */   public static int VULNERABILITY_1;
/*    */   public static int VULNERABILITY_2;
/*    */   public static int VULNERABILITY_3;
/*    */   public static int SLAY_BREAK_1;
/*    */   public static int SLAY_BREAK_2;
/*    */   public static int SLAY_BREAK_3;
/*    */   public static boolean SLAY_BREAK_NOT_TELEPORT;
/*    */   public static int MORTAL_BODY_ROM;
/*    */   public static int MORTAL_BODY_DMG;
/*    */   private static final String CONFIG_FILE = "./config/龍騎士_技能設定表.properties";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 30 */     PerformanceTimer timer = new PerformanceTimer();
/* 31 */     Properties set = new Properties();
/*    */     try {
/* 33 */       InputStream is = new FileInputStream(new File("./config/龍騎士_技能設定表.properties"));
/* 34 */       set.load(is);
/* 35 */       is.close();
/* 36 */       MORTAL_BODY_ROM = Integer.parseInt(set.getProperty("MORTAL_BODY_ROM", "23"));
/* 37 */       MORTAL_BODY_DMG = Integer.parseInt(set.getProperty("MORTAL_BODY_DMG", "30"));
/* 38 */       SLAY_BREAK_NOT_TELEPORT = Boolean.parseBoolean(set.getProperty("SLAY_BREAK_NOT_TELEPORT", "true"));
/* 39 */       FOE_SLAYER_RND = Integer.parseInt(set.getProperty("FOE_SLAYER_RND", "15"));
/* 40 */       FOE_SLAYER_SEC = Integer.parseInt(set.getProperty("FOE_SLAYER_SEC", "30"));
/* 41 */       FOE_SLAYER_DMG = Integer.parseInt(set.getProperty("FOE_SLAYER_DMG", "10"));
/* 42 */       VULNERABILITY_OTHER = Integer.parseInt(set.getProperty("VULNERABILITY_OTHER", "10"));
/* 43 */       VULNERABILITY_ROM = Integer.parseInt(set.getProperty("VULNERABILITY_ROM", "15"));
/* 44 */       VULNERABILITY_1 = Integer.parseInt(set.getProperty("VULNERABILITY_1", "5"));
/* 45 */       VULNERABILITY_2 = Integer.parseInt(set.getProperty("VULNERABILITY_2", "10"));
/* 46 */       VULNERABILITY_3 = Integer.parseInt(set.getProperty("VULNERABILITY_3", "15"));
/* 47 */       SLAY_BREAK_1 = Integer.parseInt(set.getProperty("SLAY_BREAK_1", "5"));
/* 48 */       SLAY_BREAK_2 = Integer.parseInt(set.getProperty("SLAY_BREAK_2", "10"));
/* 49 */       SLAY_BREAK_3 = Integer.parseInt(set.getProperty("SLAY_BREAK_3", "15"));
/* 50 */     } catch (Exception e) {
/* 51 */       throw new ConfigErrorException("設置檔案遺失: ./config/龍騎士_技能設定表.properties");
/*    */     } finally {
/* 53 */       set.clear();
/* 54 */       _log.info("Config/龍騎士_技能設定表讀取完成 (" + timer.get() + "ms)");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigDragonKnightSkill.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */