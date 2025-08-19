/*    */ package com.lineage.config;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.util.Properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ConfigSQL
/*    */ {
/*    */   public static String DB_DRIVER;
/*    */   public static String DB_URL1_LOGIN;
/*    */   public static String DB_URL2_LOGIN;
/*    */   public static String DB_URL3_LOGIN;
/*    */   public static String DB_LOGIN_LOGIN;
/*    */   public static String DB_PASSWORD_LOGIN;
/*    */   public static String DB_URL1;
/*    */   public static String DB_URL2;
/*    */   public static String DB_URL3;
/*    */   public static String DB_LOGIN;
/*    */   public static String DB_PASSWORD;
/*    */   private static final String SQL_CONFIG = "./config/sql.properties";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 53 */     Properties set = new Properties();
/*    */     try {
/* 55 */       InputStream is = new FileInputStream(new File("./config/sql.properties"));
/* 56 */       set.load(is);
/* 57 */       is.close();
/*    */       
/* 59 */       DB_DRIVER = set.getProperty("Driver", "com.mysql.jdbc.Driver");
/*    */       
/* 61 */       DB_URL1_LOGIN = set.getProperty("URL1_LOGIN", "jdbc:mysql://localhost/");
/* 62 */       DB_URL2_LOGIN = set.getProperty("URL2_LOGIN", "l1jsrc");
/* 63 */       DB_URL3_LOGIN = set.getProperty("URL3_LOGIN", "?useUnicode=true&characterEncoding=UTF8");
/* 64 */       DB_LOGIN_LOGIN = set.getProperty("Login_LOGIN", "root");
/* 65 */       DB_PASSWORD_LOGIN = set.getProperty("Password_LOGIN", "123456");
/*    */       
/* 67 */       DB_URL1 = set.getProperty("URL1", "jdbc:mysql://localhost/");
/* 68 */       DB_URL2 = set.getProperty("URL2", "l1jsrc");
/* 69 */       DB_URL3 = set.getProperty("URL3", "?useUnicode=true&characterEncoding=UTF8");
/* 70 */       DB_LOGIN = set.getProperty("Login", "root");
/* 71 */       DB_PASSWORD = set.getProperty("Password", "123456");
/*    */     }
/* 73 */     catch (Exception e) {
/* 74 */       throw new ConfigErrorException("設置檔案遺失: ./config/sql.properties");
/*    */     } finally {
/*    */       
/* 77 */       set.clear();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigSQL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */