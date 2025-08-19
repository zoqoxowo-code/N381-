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
/*    */ public final class ConfigIllusionstSkill {
/* 12 */   private static final Log _log = LogFactory.getLog(ConfigPrinceSkill.class);
/*    */   public static int ILLUSION_AVATAR_DAMAGE;
/*    */   public static int JOY_OF_PAIN_PC;
/*    */   public static int JOY_OF_PAIN_NPC;
/*    */   public static int JOY_OF_PAIN_DMG;
/*    */   public static int BONE_BREAK_1;
/*    */   public static int BONE_BREAK_2;
/*    */   public static int BONE_BREAK_3;
/*    */   public static double BONE_BREAK_INT;
/*    */   public static double BONE_BREAK_MR;
/*    */   public static int PHAN_TASM_1;
/*    */   public static int PHAN_TASM_2;
/*    */   public static int PHAN_TASM_3;
/*    */   public static double PHANTASM_INT;
/*    */   public static double PHANTASM_MR;
/*    */   public static int MIRROR;
/*    */   public static int KIRINGKU_DOWN_MR1;
/*    */   public static int KIRINGKU_DOWN_MR2;
/*    */   public static int KIRINGKU_DOWN_MR3;
/*    */   public static int KIRINGKU_DOWN_MR4;
/*    */   private static final String CONFIG_FILE = "./config/幻術師_技能設定表.properties";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 35 */     PerformanceTimer timer = new PerformanceTimer();
/* 36 */     Properties set = new Properties();
/*    */     try {
/* 38 */       InputStream is = new FileInputStream(new File("./config/幻術師_技能設定表.properties"));
/* 39 */       set.load(is);
/* 40 */       is.close();
/* 41 */       ILLUSION_AVATAR_DAMAGE = Integer.parseInt(set.getProperty("ILLUSION_AVATAR_DAMAGE", "1"));
/* 42 */       JOY_OF_PAIN_PC = Integer.parseInt(set.getProperty("JOY_OF_PAIN_PC", "1"));
/* 43 */       JOY_OF_PAIN_NPC = Integer.parseInt(set.getProperty("JOY_OF_PAIN_NPC", "1"));
/* 44 */       JOY_OF_PAIN_DMG = Integer.parseInt(set.getProperty("JOY_OF_PAIN_DMG", "100"));
/* 45 */       BONE_BREAK_1 = Integer.parseInt(set.getProperty("BONE_BREAK_1", "5"));
/* 46 */       BONE_BREAK_2 = Integer.parseInt(set.getProperty("BONE_BREAK_2", "10"));
/* 47 */       BONE_BREAK_3 = Integer.parseInt(set.getProperty("BONE_BREAK_3", "15"));
/* 48 */       BONE_BREAK_INT = Double.parseDouble(set.getProperty("BONE_BREAK_INT", "0"));
/* 49 */       BONE_BREAK_MR = Double.parseDouble(set.getProperty("BONE_BREAK_MR", "0"));
/* 50 */       PHAN_TASM_1 = Integer.parseInt(set.getProperty("PHAN_TASM_1", "5"));
/* 51 */       PHAN_TASM_2 = Integer.parseInt(set.getProperty("PHAN_TASM_2", "10"));
/* 52 */       PHAN_TASM_3 = Integer.parseInt(set.getProperty("PHAN_TASM_3", "15"));
/* 53 */       PHANTASM_INT = Double.parseDouble(set.getProperty("PHANTASM_INT", "0"));
/* 54 */       PHANTASM_MR = Double.parseDouble(set.getProperty("PHANTASM_MR", "0"));
/* 55 */       MIRROR = Integer.parseInt(set.getProperty("MIRROR", "5"));
/* 56 */       KIRINGKU_DOWN_MR1 = Integer.parseInt(set.getProperty("KIRINGKU_DOWN_MR1", "100"));
/* 57 */       KIRINGKU_DOWN_MR2 = Integer.parseInt(set.getProperty("KIRINGKU_DOWN_MR2", "100"));
/* 58 */       KIRINGKU_DOWN_MR3 = Integer.parseInt(set.getProperty("KIRINGKU_DOWN_MR3", "100"));
/* 59 */       KIRINGKU_DOWN_MR4 = Integer.parseInt(set.getProperty("KIRINGKU_DOWN_MR4", "100"));
/* 60 */     } catch (Exception e) {
/* 61 */       throw new ConfigErrorException("設置檔案遺失: ./config/幻術師_技能設定表.properties");
/*    */     } finally {
/* 63 */       set.clear();
/* 64 */       _log.info("Config/幻術師_技能設定表讀取完成 (" + timer.get() + "ms)");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigIllusionstSkill.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */