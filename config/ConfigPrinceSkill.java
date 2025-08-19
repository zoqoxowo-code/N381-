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
/*    */ public final class ConfigPrinceSkill {
/* 12 */   private static final Log _log = LogFactory.getLog(ConfigPrinceSkill.class);
/*    */   public static double STRIKER_DMG;
/*    */   private static final String CONFIG_FILE = "./config/王族_技能設定表.properties";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 17 */     PerformanceTimer timer = new PerformanceTimer();
/* 18 */     Properties set = new Properties();
/*    */     try {
/* 20 */       InputStream is = new FileInputStream(new File("./config/王族_技能設定表.properties"));
/* 21 */       set.load(is);
/* 22 */       is.close();
/* 23 */       STRIKER_DMG = Double.parseDouble(set.getProperty("STRIKER_DMG", "1.0"));
/* 24 */     } catch (Exception e) {
/* 25 */       throw new ConfigErrorException("設置檔案遺失: ./config/王族_技能設定表.properties");
/*    */     } finally {
/* 27 */       set.clear();
/* 28 */       _log.info("Config/王族_技能設定表讀取完成 (" + timer.get() + "ms)");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigPrinceSkill.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */