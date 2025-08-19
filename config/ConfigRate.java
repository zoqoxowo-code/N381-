/*     */ package com.lineage.config;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.util.Properties;
/*     */ 
/*     */ public final class ConfigRate
/*     */ {
/*     */   private static final String RATES_CONFIG_FILE = "./config/rates.properties";
/*     */   public static int ran1;
/*     */   public static int ran2;
/*     */   public static int ran3;
/*     */   public static int ran4;
/*     */   public static int ran5;
/*     */   public static int ran6;
/*     */   public static int ran7;
/*     */   public static int ran8;
/*     */   public static int ran9;
/*     */   public static int ran10;
/*     */   public static int ran11;
/*     */   public static int ran12;
/*     */   public static int ran13;
/*     */   public static int ran14;
/*     */   public static int ran15;
/*     */   public static int ran16;
/*     */   public static int ran17;
/*     */   public static int ran18;
/*     */   public static int ran19;
/*     */   public static int ran20;
/*     */   public static int ran21;
/*     */   public static int ran22;
/*     */   public static int ran23;
/*     */   public static int ran24;
/*     */   public static int ran25;
/*     */   public static int ran26;
/*     */   public static int ran27;
/*     */   public static int ran28;
/*     */   public static double RATE_XP;
/*     */   public static double RATE_LA;
/*     */   public static double RATE_KARMA;
/*     */   public static double RATE_DROP_ADENA;
/*     */   public static double RATE_DROP_ITEMS;
/*     */   public static int ENCHANT_CHANCE_WEAPON;
/*     */   public static int ENCHANT_CHANCE_ARMOR;
/*     */   public static int ATTR_ENCHANT_CHANCE;
/*     */   public static double RATE_WEIGHT_LIMIT;
/*     */   public static double RATE_WEIGHT_LIMIT_PET;
/*     */   public static double RATE_SHOP_SELLING_PRICE;
/*     */   public static double RATE_SHOP_PURCHASING_PRICE;
/*     */   public static int CREATE_CHANCE_DIARY;
/*     */   public static int CREATE_CHANCE_RECOLLECTION;
/*     */   public static int CREATE_CHANCE_MYSTERIOUS;
/*     */   public static int CREATE_CHANCE_PROCESSING;
/*     */   public static int CREATE_CHANCE_PROCESSING_DIAMOND;
/*     */   public static int CREATE_CHANCE_DANTES;
/*     */   public static int CREATE_CHANCE_ANCIENT_AMULET;
/*     */   public static int CREATE_CHANCE_HISTORY_BOOK;
/*     */   
/*     */   public static void load() throws ConfigErrorException {
/*  61 */     Properties set = new Properties();
/*     */     try {
/*  63 */       InputStream is = new FileInputStream(new File("./config/rates.properties"));
/*  64 */       set.load(is);
/*  65 */       is.close();
/*  66 */       RATE_XP = Double.parseDouble(set.getProperty("RateXp", "1.0"));
/*  67 */       RATE_LA = Double.parseDouble(set.getProperty("RateLawful", "1.0"));
/*  68 */       RATE_KARMA = Double.parseDouble(set.getProperty("RateKarma", "1.0"));
/*  69 */       RATE_DROP_ADENA = Double.parseDouble(set.getProperty("RateDropAdena", "1.0"));
/*  70 */       RATE_DROP_ITEMS = Double.parseDouble(set.getProperty("RateDropItems", "1.0"));
/*  71 */       ENCHANT_CHANCE_WEAPON = Integer.parseInt(set.getProperty("EnchantChanceWeapon", "68"));
/*  72 */       ENCHANT_CHANCE_ARMOR = Integer.parseInt(set.getProperty("EnchantChanceArmor", "52"));
/*  73 */       ATTR_ENCHANT_CHANCE = Integer.parseInt(set.getProperty("AttrEnchantChance", "10"));
/*  74 */       RATE_WEIGHT_LIMIT = Double.parseDouble(set.getProperty("RateWeightLimit", "1"));
/*  75 */       RATE_WEIGHT_LIMIT_PET = Double.parseDouble(set.getProperty("RateWeightLimitforPet", "1"));
/*  76 */       RATE_SHOP_SELLING_PRICE = Double.parseDouble(set.getProperty("RateShopSellingPrice", "1.0"));
/*  77 */       RATE_SHOP_PURCHASING_PRICE = Double.parseDouble(set.getProperty("RateShopPurchasingPrice", "1.0"));
/*  78 */       CREATE_CHANCE_DIARY = Integer.parseInt(set.getProperty("CreateChanceDiary", "33"));
/*  79 */       CREATE_CHANCE_RECOLLECTION = Integer.parseInt(set.getProperty("CreateChanceRecollection", "90"));
/*  80 */       CREATE_CHANCE_MYSTERIOUS = Integer.parseInt(set.getProperty("CreateChanceMysterious", "90"));
/*  81 */       CREATE_CHANCE_PROCESSING = Integer.parseInt(set.getProperty("CreateChanceProcessing", "90"));
/*  82 */       CREATE_CHANCE_PROCESSING_DIAMOND = Integer.parseInt(set.getProperty("CreateChanceProcessingDiamond", "90"));
/*  83 */       CREATE_CHANCE_DANTES = Integer.parseInt(set.getProperty("CreateChanceDantes", "50"));
/*  84 */       CREATE_CHANCE_ANCIENT_AMULET = Integer.parseInt(set.getProperty("CreateChanceAncientAmulet", "90"));
/*  85 */       CREATE_CHANCE_HISTORY_BOOK = Integer.parseInt(set.getProperty("CreateChanceHistoryBook", "5"));
/*  86 */       ran1 = Integer.parseInt(set.getProperty("ran1", "10"));
/*  87 */       ran2 = Integer.parseInt(set.getProperty("ran2", "10"));
/*  88 */       ran3 = Integer.parseInt(set.getProperty("ran3", "10"));
/*  89 */       ran4 = Integer.parseInt(set.getProperty("ran4", "10"));
/*  90 */       ran5 = Integer.parseInt(set.getProperty("ran5", "10"));
/*  91 */       ran6 = Integer.parseInt(set.getProperty("ran6", "10"));
/*  92 */       ran7 = Integer.parseInt(set.getProperty("ran7", "10"));
/*  93 */       ran8 = Integer.parseInt(set.getProperty("ran8", "10"));
/*  94 */       ran9 = Integer.parseInt(set.getProperty("ran9", "10"));
/*  95 */       ran10 = Integer.parseInt(set.getProperty("ran10", "10"));
/*  96 */       ran11 = Integer.parseInt(set.getProperty("ran11", "10"));
/*  97 */       ran12 = Integer.parseInt(set.getProperty("ran12", "10"));
/*  98 */       ran13 = Integer.parseInt(set.getProperty("ran13", "10"));
/*  99 */       ran14 = Integer.parseInt(set.getProperty("ran14", "10"));
/*     */       
/* 101 */       ran15 = Integer.parseInt(set.getProperty("ran15", "10"));
/* 102 */       ran16 = Integer.parseInt(set.getProperty("ran16", "10"));
/* 103 */       ran17 = Integer.parseInt(set.getProperty("ran17", "10"));
/* 104 */       ran18 = Integer.parseInt(set.getProperty("ran18", "10"));
/* 105 */       ran19 = Integer.parseInt(set.getProperty("ran19", "10"));
/* 106 */       ran20 = Integer.parseInt(set.getProperty("ran20", "10"));
/* 107 */       ran21 = Integer.parseInt(set.getProperty("ran21", "10"));
/* 108 */       ran22 = Integer.parseInt(set.getProperty("ran22", "10"));
/* 109 */       ran23 = Integer.parseInt(set.getProperty("ran23", "10"));
/* 110 */       ran24 = Integer.parseInt(set.getProperty("ran24", "10"));
/* 111 */       ran25 = Integer.parseInt(set.getProperty("ran25", "10"));
/* 112 */       ran26 = Integer.parseInt(set.getProperty("ran26", "10"));
/* 113 */       ran27 = Integer.parseInt(set.getProperty("ran27", "10"));
/* 114 */       ran28 = Integer.parseInt(set.getProperty("ran28", "10"));
/* 115 */     } catch (Exception e) {
/* 116 */       throw new ConfigErrorException("設置檔案遺失: ./config/rates.properties");
/*     */     } finally {
/* 118 */       set.clear();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigRate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */