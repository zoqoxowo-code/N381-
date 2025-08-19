/*    */ package com.lineage.config;
/*    */ 
/*    */ import com.lineage.server.utils.PerformanceTimer;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.util.Properties;
/*    */ import java.util.StringTokenizer;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public final class ConfigKnightSkill
/*    */ {
/* 14 */   private static final Log _log = LogFactory.getLog(ConfigKnightSkill.class);
/*    */   private static final String CONFIG_FILE = "./config/騎士_技能設定表.properties";
/*    */   public static int[] SHOCK_STUN_TIMER;
/*    */   public static int IMPACT_HALO_1;
/*    */   public static int IMPACT_HALO_2;
/*    */   public static int IMPACT_HALO_3;
/*    */   public static int IMPACT_HALO_4;
/*    */   public static double IMPACT_HALO_INT;
/*    */   public static double IMPACT_HALO_MR;
/*    */   public static int COUNTER_BARRIER_ROM;
/*    */   public static double COUNTER_BARRIER_DMG;
/*    */   public static int SOLID_CARRIAGE_MODE;
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 28 */     PerformanceTimer timer = new PerformanceTimer();
/* 29 */     Properties set = new Properties();
/*    */     try {
/* 31 */       InputStream is = new FileInputStream(new File("./config/騎士_技能設定表.properties"));
/* 32 */       set.load(is);
/* 33 */       is.close();
/* 34 */       IMPACT_HALO_1 = Integer.parseInt(set.getProperty("IMPACT_HALO_1", "50"));
/* 35 */       IMPACT_HALO_2 = Integer.parseInt(set.getProperty("IMPACT_HALO_2", "70"));
/* 36 */       IMPACT_HALO_3 = Integer.parseInt(set.getProperty("IMPACT_HALO_3", "90"));
/* 37 */       IMPACT_HALO_4 = Integer.parseInt(set.getProperty("IMPACT_HALO_4", "90"));
/* 38 */       IMPACT_HALO_INT = Double.parseDouble(set.getProperty("IMPACT_HALO_INT", "0"));
/* 39 */       IMPACT_HALO_MR = Double.parseDouble(set.getProperty("IMPACT_HALO_MR", "0"));
/* 40 */       COUNTER_BARRIER_ROM = Integer.parseInt(set.getProperty("COUNTER_BARRIER_ROM", "33"));
/* 41 */       COUNTER_BARRIER_DMG = Double.parseDouble(set.getProperty("COUNTER_BARRIER_DMG", "2.0"));
/* 42 */       SOLID_CARRIAGE_MODE = Integer.parseInt(set.getProperty("SOLID_CARRIAGE_MODE", "1"));
/* 43 */       SHOCK_STUN_TIMER = toIntArray(set.getProperty("SHOCK_STUN_TIMER", ""), "~");
/* 44 */     } catch (Exception e) {
/* 45 */       throw new ConfigErrorException("設置檔案遺失: ./config/騎士_技能設定表.properties");
/*    */     } finally {
/* 47 */       set.clear();
/* 48 */       _log.info("Config/騎士_技能設定表讀取完成 (" + timer.get() + "ms)");
/*    */     } 
/*    */   }
/*    */   
/*    */   public static int[] toIntArray(String text, String type) {
/* 53 */     StringTokenizer st = new StringTokenizer(text, type);
/* 54 */     int[] iReturn = new int[st.countTokens()];
/* 55 */     int i = 0;
/* 56 */     while (i < iReturn.length) {
/* 57 */       iReturn[i] = Integer.parseInt(st.nextToken());
/* 58 */       i++;
/*    */     } 
/* 60 */     return iReturn;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigKnightSkill.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */