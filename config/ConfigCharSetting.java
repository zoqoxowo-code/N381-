/*    */ package com.lineage.config;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.util.Properties;
/*    */ 
/*    */ public final class ConfigCharSetting {
/*    */   public static int PRINCE_MAX_HP;
/*    */   public static int PRINCE_MAX_MP;
/*    */   public static int KNIGHT_MAX_HP;
/*    */   public static int KNIGHT_MAX_MP;
/*    */   public static int ELF_MAX_HP;
/*    */   public static int ELF_MAX_MP;
/*    */   public static int WIZARD_MAX_HP;
/*    */   public static int WIZARD_MAX_MP;
/*    */   public static int DARKELF_MAX_HP;
/*    */   public static int DARKELF_MAX_MP;
/*    */   public static int DRAGONKNIGHT_MAX_HP;
/*    */   public static int DRAGONKNIGHT_MAX_MP;
/*    */   public static int ILLUSIONIST_MAX_HP;
/*    */   public static int ILLUSIONIST_MAX_MP;
/*    */   public static int PRINCE_HP;
/*    */   public static int KNIGHT_HP;
/*    */   public static int ELF_HP;
/*    */   public static int WIZARD_HP;
/*    */   public static int DARKELF_HP;
/*    */   public static int DRAGONKNIGHT_HP;
/*    */   public static int ILLUSIONIST_HP;
/*    */   private static final String CHAR_SETTINGS_CONFIG_FILE = "./config/charsettings.properties";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 33 */     Properties set = new Properties();
/*    */     try {
/* 35 */       InputStream is = new FileInputStream(new File("./config/charsettings.properties"));
/* 36 */       set.load(is);
/* 37 */       is.close();
/* 38 */       PRINCE_MAX_HP = Integer.parseInt(set.getProperty("PrinceMaxHP", "1000"));
/* 39 */       PRINCE_MAX_MP = Integer.parseInt(set.getProperty("PrinceMaxMP", "800"));
/* 40 */       KNIGHT_MAX_HP = Integer.parseInt(set.getProperty("KnightMaxHP", "1400"));
/* 41 */       KNIGHT_MAX_MP = Integer.parseInt(set.getProperty("KnightMaxMP", "600"));
/* 42 */       ELF_MAX_HP = Integer.parseInt(set.getProperty("ElfMaxHP", "1000"));
/* 43 */       ELF_MAX_MP = Integer.parseInt(set.getProperty("ElfMaxMP", "900"));
/* 44 */       WIZARD_MAX_HP = Integer.parseInt(set.getProperty("WizardMaxHP", "800"));
/* 45 */       WIZARD_MAX_MP = Integer.parseInt(set.getProperty("WizardMaxMP", "1200"));
/* 46 */       DARKELF_MAX_HP = Integer.parseInt(set.getProperty("DarkelfMaxHP", "1000"));
/* 47 */       DARKELF_MAX_MP = Integer.parseInt(set.getProperty("DarkelfMaxMP", "900"));
/* 48 */       DRAGONKNIGHT_MAX_HP = Integer.parseInt(set.getProperty("DragonKnightMaxHP", "1400"));
/* 49 */       DRAGONKNIGHT_MAX_MP = Integer.parseInt(set.getProperty("DragonKnightMaxMP", "600"));
/* 50 */       ILLUSIONIST_MAX_HP = Integer.parseInt(set.getProperty("IllusionistMaxHP", "900"));
/* 51 */       ILLUSIONIST_MAX_MP = Integer.parseInt(set.getProperty("IllusionistMaxMP", "1100"));
/* 52 */       PRINCE_HP = Integer.parseInt(set.getProperty("PRINCE_HP", "13"));
/* 53 */       KNIGHT_HP = Integer.parseInt(set.getProperty("KNIGHT_HP", "19"));
/* 54 */       ELF_HP = Integer.parseInt(set.getProperty("ELF_HP", "12"));
/* 55 */       WIZARD_HP = Integer.parseInt(set.getProperty("WIZARD_HP", "9"));
/* 56 */       DARKELF_HP = Integer.parseInt(set.getProperty("DARKELF_HP", "12"));
/* 57 */       DRAGONKNIGHT_HP = Integer.parseInt(set.getProperty("DRAGONKNIGHT_HP", "18"));
/* 58 */       ILLUSIONIST_HP = Integer.parseInt(set.getProperty("ILLUSIONIST_HP", "11"));
/* 59 */     } catch (Exception e) {
/* 60 */       throw new ConfigErrorException("設置檔案遺失: ./config/charsettings.properties");
/*    */     } finally {
/* 62 */       set.clear();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigCharSetting.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */