/*    */ package com.lineage.config;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.util.Properties;
/*    */ 
/*    */ public final class Config {
/*    */   public static final int vergame = 3800;
/*    */   private static final String SERVER_CONFIG_FILE = "./config/server.properties";
/* 11 */   public static String checkip = "";
/*    */   public static boolean CACHE_MAP_FILES;
/*    */   public static boolean LOGINS_TO_AUTOENTICATION;
/*    */   public static String RSA_KEY_E;
/*    */   public static String RSA_KEY_N;
/*    */   public static boolean DEBUG = false;
/*    */   public static int SERVERNO;
/*    */   public static boolean ISUBUNTU = false;
/*    */   public static String GAME_SERVER_HOST_NAME;
/*    */   public static String GAME_SERVER_PORT;
/*    */   public static String SERVERNAME;
/*    */   public static String CHAT_SERVER_HOST_NAME;
/*    */   public static int CHAT_SERVER_PORT;
/*    */   public static String TIME_ZONE;
/*    */   public static int CLIENT_LANGUAGE;
/*    */   public static String CLIENT_LANGUAGE_CODE;
/* 27 */   public static String[] LANGUAGE_CODE_ARRAY = new String[] { "UTF8", "EUCKR", "UTF8", "BIG5", "SJIS", "GBK" };
/* 28 */   public static String[] AUTORESTART = null;
/*    */   public static boolean AUTO_CREATE_ACCOUNTS;
/* 30 */   public static short MAX_ONLINE_USERS = 10;
/*    */   public static int AUTOSAVE_INTERVAL;
/*    */   public static int AUTOSAVE_INTERVAL_INVENTORY;
/*    */   public static int PC_RECOGNIZE_RANGE;
/*    */   public static int RESTART_LOGIN;
/*    */   public static boolean NEWS;
/*    */   public static boolean GUI;
/*    */   public static boolean TestServer;
/*    */   public static boolean BanIpFromIDC;
/*    */   public static String TestServerPassWords;
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 42 */     Properties pack = new Properties();
/*    */     try {
/* 44 */       InputStream is = new FileInputStream(new File("./config/pack.properties"));
/* 45 */       pack.load(is);
/* 46 */       is.close();
/* 47 */       LOGINS_TO_AUTOENTICATION = Boolean.parseBoolean(pack.getProperty("Autoentication", "false"));
/* 48 */       RSA_KEY_E = pack.getProperty("RSA_KEY_E", "0");
/* 49 */       RSA_KEY_N = pack.getProperty("RSA_KEY_N", "0");
/* 50 */     } catch (Exception e) {
/* 51 */       System.err.println("沒有找到登入器加密設置檔案: ./config/pack.properties");
/*    */     } finally {
/* 53 */       pack.clear();
/*    */     } 
/* 55 */     Properties set = new Properties();
/*    */     try {
/* 57 */       Object is2 = new FileInputStream(new File("./config/server.properties"));
/* 58 */       set.load((InputStream)is2);
/* 59 */       ((InputStream)is2).close();
/* 60 */       GUI = Boolean.parseBoolean(set.getProperty("GUI", "true"));
/* 61 */       SERVERNO = Integer.parseInt(set.getProperty("ServerNo", "1"));
/* 62 */       GAME_SERVER_HOST_NAME = set.getProperty("GameserverHostname", "*");
/* 63 */       GAME_SERVER_PORT = set.getProperty("GameserverPort", "2000-2001");
/* 64 */       CLIENT_LANGUAGE = Integer.parseInt(set.getProperty("ClientLanguage", "3"));
/* 65 */       CLIENT_LANGUAGE_CODE = LANGUAGE_CODE_ARRAY[CLIENT_LANGUAGE];
/* 66 */       String tmp = set.getProperty("AutoRestart", "");
/* 67 */       if (!tmp.equalsIgnoreCase("null")) {
/* 68 */         AUTORESTART = tmp.split(",");
/*    */       }
/* 70 */       CACHE_MAP_FILES = Boolean.parseBoolean(set.getProperty("CacheMapFiles", "false"));
/* 71 */       TIME_ZONE = set.getProperty("TimeZone", "CST");
/* 72 */       AUTO_CREATE_ACCOUNTS = Boolean.parseBoolean(set.getProperty("AutoCreateAccounts", "true"));
/* 73 */       MAX_ONLINE_USERS = Short.parseShort(set.getProperty("MaximumOnlineUsers", "30"));
/*    */ 
/*    */ 
/*    */       
/* 77 */       AUTOSAVE_INTERVAL = Integer.parseInt(set.getProperty("AutosaveInterval", "1200"), 10);
/* 78 */       AUTOSAVE_INTERVAL /= 60;
/* 79 */       if (AUTOSAVE_INTERVAL <= 0) {
/* 80 */         AUTOSAVE_INTERVAL = 20;
/*    */       }
/* 82 */       AUTOSAVE_INTERVAL_INVENTORY = Integer.parseInt(set.getProperty("AutosaveIntervalOfInventory", "300"), 10);
/* 83 */       AUTOSAVE_INTERVAL_INVENTORY /= 60;
/* 84 */       if (AUTOSAVE_INTERVAL_INVENTORY <= 0) {
/* 85 */         AUTOSAVE_INTERVAL_INVENTORY = 5;
/*    */       }
/* 87 */       PC_RECOGNIZE_RANGE = Integer.parseInt(set.getProperty("PcRecognizeRange", "13"));
/* 88 */       RESTART_LOGIN = Integer.parseInt(set.getProperty("restartlogin", "30"));
/* 89 */       NEWS = Boolean.parseBoolean(set.getProperty("News", "false"));
/* 90 */       BanIpFromIDC = Boolean.parseBoolean(set.getProperty("BanIpFromIDC", "true"));
/* 91 */       TestServer = Boolean.parseBoolean(set.getProperty("TestServer", "false"));
/* 92 */       TestServerPassWords = set.getProperty("TestServerPassWords", "wftest2");
/* 93 */     } catch (Exception e2) {
/* 94 */       throw new ConfigErrorException("設置檔案遺失: ./config/server.properties");
/*    */     } finally {
/* 96 */       set.clear();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\Config.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */