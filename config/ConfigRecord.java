/*    */ package com.lineage.config;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.util.Properties;
/*    */ 
/*    */ public final class ConfigRecord {
/*    */   public static boolean LOGGING_BAN_ENCHANT = false;
/*    */   public static boolean LOGGING_CHAT_NORMAL = false;
/*    */   public static boolean LOGGING_CHAT_SHOUT = false;
/*    */   public static boolean LOGGING_CHAT_WORLD = false;
/*    */   public static boolean LOGGING_CHAT_CLAN = false;
/*    */   public static boolean LOGGING_CHAT_WHISPER = false;
/*    */   public static boolean LOGGING_CHAT_PARTY = false;
/*    */   public static boolean LOGGING_CHAT_BUSINESS = false;
/*    */   public static boolean LOGGING_CHAT_COMBINED = false;
/*    */   public static boolean LOGGING_CHAT_CHAT_PARTY = false;
/*    */   private static final String RECORD_FILE = "./config/record.properties";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 22 */     Properties set = new Properties();
/*    */     try {
/* 24 */       InputStream is = new FileInputStream(new File("./config/record.properties"));
/* 25 */       set.load(is);
/* 26 */       is.close();
/* 27 */       LOGGING_BAN_ENCHANT = Boolean.parseBoolean(set.getProperty("LoggingBanEnchant", "false"));
/* 28 */       LOGGING_CHAT_NORMAL = Boolean.parseBoolean(set.getProperty("LoggingChatNormal", "false"));
/* 29 */       LOGGING_CHAT_SHOUT = Boolean.parseBoolean(set.getProperty("LoggingChatShout", "false"));
/* 30 */       LOGGING_CHAT_WORLD = Boolean.parseBoolean(set.getProperty("LoggingChatWorld", "false"));
/* 31 */       LOGGING_CHAT_CLAN = Boolean.parseBoolean(set.getProperty("LoggingChatClan", "false"));
/* 32 */       LOGGING_CHAT_WHISPER = Boolean.parseBoolean(set.getProperty("LoggingChatWhisper", "false"));
/* 33 */       LOGGING_CHAT_PARTY = Boolean.parseBoolean(set.getProperty("LoggingChatParty", "false"));
/* 34 */       LOGGING_CHAT_BUSINESS = Boolean.parseBoolean(set.getProperty("LoggingBusiness", "false"));
/* 35 */       LOGGING_CHAT_COMBINED = Boolean.parseBoolean(set.getProperty("LoggingChatCombined", "false"));
/* 36 */       LOGGING_CHAT_CHAT_PARTY = Boolean.parseBoolean(set.getProperty("LoggingChatChatParty", "false"));
/* 37 */     } catch (Exception e) {
/* 38 */       throw new ConfigErrorException("設置檔案遺失: ./config/record.properties");
/*    */     } finally {
/* 40 */       set.clear();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */