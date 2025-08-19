/*    */ package com.lineage.config;
/*    */ 
/*    */ import com.lineage.commons.system.LanSecurityManager;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.util.Properties;
/*    */ 
/*    */ public final class ConfigIpCheck {
/*    */   public static int ipcount;
/*    */   public static int timeOutSocket;
/*    */   public static boolean IPCHECKPACK;
/*    */   public static boolean IPCHECK;
/*    */   public static int TIMEMILLIS;
/*    */   public static int COUNT;
/*    */   public static boolean SETDB;
/*    */   public static boolean UFW;
/*    */   public static boolean ISONEIP;
/*    */   public static int ONETIMEMILLIS;
/*    */   private static final String _ipcheck = "./config/ipcheck.properties";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 23 */     Properties set = new Properties();
/*    */     try {
/* 25 */       InputStream is = new FileInputStream(new File("./config/ipcheck.properties"));
/* 26 */       set.load(is);
/* 27 */       is.close();
/* 28 */       IPCHECKPACK = Boolean.parseBoolean(set.getProperty("IPCHECKPACK", "false"));
/* 29 */       if (IPCHECKPACK) {
/* 30 */         LanSecurityManager manager = new LanSecurityManager();
/* 31 */         manager.stsrt_cmd_tmp();
/*    */       } 
/* 33 */       IPCHECK = Boolean.parseBoolean(set.getProperty("IPCHECK", "false"));
/* 34 */       TIMEMILLIS = Integer.parseInt(set.getProperty("TIMEMILLIS", "1000"));
/* 35 */       ipcount = Integer.parseInt(set.getProperty("ipcount", "3"));
/* 36 */       COUNT = Integer.parseInt(set.getProperty("COUNT", "10"));
/* 37 */       SETDB = Boolean.parseBoolean(set.getProperty("SETDB", "false"));
/* 38 */       UFW = Boolean.parseBoolean(set.getProperty("UFW", "true"));
/* 39 */       ISONEIP = Boolean.parseBoolean(set.getProperty("ISONEIP", "false"));
/* 40 */       ONETIMEMILLIS = Integer.parseInt(set.getProperty("ONETIMEMILLIS", "20000"));
/* 41 */       timeOutSocket = Integer.parseInt(set.getProperty("timeOutSocket", "60"));
/* 42 */       if (ONETIMEMILLIS != 0) {
/* 43 */         LanSecurityManager manager = new LanSecurityManager();
/* 44 */         manager.stsrt_cmd();
/*    */       } 
/* 46 */     } catch (Exception e) {
/* 47 */       throw new ConfigErrorException("設置檔案遺失: ./config/ipcheck.properties");
/*    */     } finally {
/* 49 */       set.clear();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigIpCheck.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */