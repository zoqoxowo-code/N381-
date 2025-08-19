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
/*    */ public final class Config_Pc_Damage
/*    */ {
/*    */   private static final String Config_Occupational_Damage = "./config/其他控制端/職業傷害設定表.properties";
/*    */   public static double Other_To_isCrownnpc;
/*    */   public static double Other_To_isKnightnpc;
/*    */   public static double Other_To_isWizardnpc;
/*    */   public static double Other_To_isElfnpc;
/*    */   public static double Other_To_isDarkelfnpc;
/*    */   public static double Other_To_isDragonKnightnpc;
/*    */   public static double Other_To_isIllusionistnpc;
/*    */   public static double Other_To_isCrownpc;
/*    */   public static double Other_To_isKnightpc;
/*    */   public static double Other_To_isWizardpc;
/*    */   public static double Other_To_isElfpc;
/*    */   public static double Other_To_isDarkelfpc;
/*    */   public static double Other_To_isDragonKnightpc;
/*    */   public static double Other_To_isIllusionistpc;
/*    */   public static double Crown_ADD_MagicPC;
/*    */   public static double Knight_ADD_MagicPC;
/*    */   public static double Elf_ADD_MagicPC;
/*    */   public static double Darkelf_ADD_MagicPC;
/*    */   public static double Wizard_ADD_MagicPC;
/*    */   public static double DragonKnight_ADD_MagicPC;
/*    */   public static double Illusionist_ADD_MagicPC;
/*    */   public static double Crown_ADD_MagicNPC;
/*    */   public static double Knight_ADD_MagicNPC;
/*    */   public static double Elf_ADD_MagicNPC;
/*    */   public static double Darkelf_ADD_MagicNPC;
/*    */   public static double Wizard_ADD_MagicNPC;
/*    */   public static double DragonKnight_ADD_MagicNPC;
/*    */   public static double Illusionist_ADD_MagicNPC;
/*    */   public static double ModDmg;
/*    */   public static double BossDmg;
/*    */   public static int AllMobHit_chance;
/*    */   public static int BossMobHit_chance;
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 49 */     Properties set = new Properties();
/*    */     try {
/* 51 */       InputStream is = new FileInputStream(new File("./config/其他控制端/職業傷害設定表.properties"));
/* 52 */       set.load(is);
/* 53 */       is.close();
/* 54 */       AllMobHit_chance = Integer.parseInt(set.getProperty("AllMobHit_chance", "0"));
/* 55 */       BossMobHit_chance = Integer.parseInt(set.getProperty("BossMobHit_chance", "0"));
/* 56 */       Other_To_isCrownnpc = Double.parseDouble(set.getProperty("Other_To_isCrown_npc", "0.0"));
/* 57 */       Other_To_isKnightnpc = Double.parseDouble(set.getProperty("Other_To_isKnight_npc", "0.0"));
/* 58 */       Other_To_isWizardnpc = Double.parseDouble(set.getProperty("Other_To_isWizard_npc", "0.0"));
/* 59 */       Other_To_isElfnpc = Double.parseDouble(set.getProperty("Other_To_isElf_npc", "0.0"));
/* 60 */       Other_To_isDarkelfnpc = Double.parseDouble(set.getProperty("Other_To_isDarkelf_npc", "0.0"));
/* 61 */       Other_To_isDragonKnightnpc = Double.parseDouble(set.getProperty("Other_To_isDragonKnight_npc", "0.0"));
/* 62 */       Other_To_isIllusionistnpc = Double.parseDouble(set.getProperty("Other_To_isIllusionist_npc", "0.0"));
/* 63 */       Other_To_isCrownpc = Double.parseDouble(set.getProperty("Other_To_isCrown_pc", "0.0"));
/* 64 */       Other_To_isKnightpc = Double.parseDouble(set.getProperty("Other_To_isKnight_pc", "0.0"));
/* 65 */       Other_To_isWizardpc = Double.parseDouble(set.getProperty("Other_To_isWizard_pc", "0.0"));
/* 66 */       Other_To_isElfpc = Double.parseDouble(set.getProperty("Other_To_isElf_pc", "0.0"));
/* 67 */       Other_To_isDarkelfpc = Double.parseDouble(set.getProperty("Other_To_isDarkelf_pc", "0.0"));
/* 68 */       Other_To_isDragonKnightpc = Double.parseDouble(set.getProperty("Other_To_isDragonKnight_pc", "0.0"));
/* 69 */       Other_To_isIllusionistpc = Double.parseDouble(set.getProperty("Other_To_isIllusionist_pc", "0.0"));
/* 70 */       Crown_ADD_MagicPC = Double.parseDouble(set.getProperty("Other_ADD_isCrown_MagicPC", "1.0"));
/* 71 */       Knight_ADD_MagicPC = Double.parseDouble(set.getProperty("Other_ADD_isKnight_MagicPC", "1.0"));
/* 72 */       Elf_ADD_MagicPC = Double.parseDouble(set.getProperty("Other_ADD_isElf_MagicPC", "1.0"));
/* 73 */       Darkelf_ADD_MagicPC = Double.parseDouble(set.getProperty("Other_ADD_isDarkelf_MagicPC", "1.0"));
/* 74 */       Wizard_ADD_MagicPC = Double.parseDouble(set.getProperty("Other_ADD_isWizard_MagicPC", "1.0"));
/* 75 */       DragonKnight_ADD_MagicPC = Double.parseDouble(set.getProperty("Other_ADD_isDragonKnight_MagicPC", "1.0"));
/* 76 */       Illusionist_ADD_MagicPC = Double.parseDouble(set.getProperty("Other_ADD_isIllusionist_MagicPC", "1.0"));
/*    */ 
/*    */ 
/*    */       
/* 80 */       Crown_ADD_MagicNPC = Double.parseDouble(set.getProperty("Other_ADD_isCrown_MagicNPC", "1.0"));
/* 81 */       Knight_ADD_MagicNPC = Double.parseDouble(set.getProperty("Other_ADD_isKnight_MagicNPC", "1.0"));
/* 82 */       Elf_ADD_MagicNPC = Double.parseDouble(set.getProperty("Other_ADD_isElf_MagicNPC", "1.0"));
/* 83 */       Darkelf_ADD_MagicNPC = Double.parseDouble(set.getProperty("Other_ADD_isDarkelf_MagicNPC", "1.0"));
/* 84 */       Wizard_ADD_MagicNPC = Double.parseDouble(set.getProperty("Other_ADD_isWizard_MagicNPC", "1.0"));
/* 85 */       DragonKnight_ADD_MagicNPC = Double.parseDouble(set.getProperty("Other_ADD_isDragonKnight_MagicNPC", "1.0"));
/* 86 */       Illusionist_ADD_MagicNPC = Double.parseDouble(set.getProperty("Other_ADD_isIllusionist_MagicNPC", "1.0"));
/*    */       
/* 88 */       ModDmg = Double.parseDouble(set.getProperty("ModDmg", "1.0"));
/* 89 */       BossDmg = Double.parseDouble(set.getProperty("BossDmg", "1.0"));
/* 90 */     } catch (Exception e) {
/* 91 */       throw new ConfigErrorException("設置檔案遺失:./config/powerKz/各職業傷害設定表.properties");
/*    */     } finally {
/* 93 */       set.clear();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\Config_Pc_Damage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */