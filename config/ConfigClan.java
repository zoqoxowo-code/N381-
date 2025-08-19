/*    */ package com.lineage.config;
/*    */ import com.lineage.server.beans.clan.ClanLevelUpCondition;
/*    */ import com.lineage.server.beans.errors.LogicError;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Properties;
/*    */ import java.util.StringTokenizer;
/*    */ 
/*    */ public final class ConfigClan {
/* 13 */   public static List<ClanLevelUpCondition> clansLevelUpCondition = new ArrayList<>();
/* 14 */   public static Integer CLAN_MAX_LEVEL = Integer.valueOf(10);
/*    */   public static int clanlevel;
/*    */   public static String clanmsg1;
/*    */   public static boolean clandelt;
/*    */   public static boolean clanskill;
/*    */   public static int clanresttime;
/*    */   public static int PcContribution;
/*    */   public static int PcClanAdena;
/*    */   public static int ClanItem44070;
/*    */   public static int ClanContribution;
/*    */   public static int ClanItem44070_1;
/*    */   public static int ClanContribution_1;
/*    */   private static final String OTHER_SETTINGS_FILE = "./config/其他控制端/血盟等級設定表.properties";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/* 29 */     Properties set = new Properties();
/*    */     try {
/* 31 */       InputStream is = new FileInputStream(new File("./config/其他控制端/血盟等級設定表.properties"));
/* 32 */       InputStreamReader isr = new InputStreamReader(is, "utf-8");
/* 33 */       set.load(isr);
/* 34 */       is.close();
/*    */       
/* 36 */       setClansLevelCondition(set);
/*    */       
/* 38 */       clanlevel = Integer.parseInt(set.getProperty("clanlevel", "0"));
/* 39 */       clanmsg1 = set.getProperty("clanmsg1", "");
/* 40 */       PcClanAdena = Integer.parseInt(set.getProperty("PcClanAdena", "0"));
/* 41 */       ClanItem44070 = Integer.parseInt(set.getProperty("ClanItem44070", "0"));
/* 42 */       ClanContribution = Integer.parseInt(set.getProperty("ClanContribution", "0"));
/* 43 */       ClanItem44070_1 = Integer.parseInt(set.getProperty("ClanItem44070_1", "0"));
/* 44 */       ClanContribution_1 = Integer.parseInt(set.getProperty("ClanContribution_1", "0"));
/* 45 */       clandelt = Boolean.parseBoolean(set.getProperty("clandelt", "true"));
/* 46 */       clanskill = Boolean.parseBoolean(set.getProperty("clanskill", "true"));
/* 47 */       clanresttime = Integer.parseInt(set.getProperty("clanresttime", "0"));
/* 48 */       PcContribution = Integer.parseInt(set.getProperty("PcContribution", "0"));
/* 49 */     } catch (LogicError e) {
/* 50 */       throw new ConfigErrorException(e.getMsg());
/* 51 */     } catch (Exception e) {
/* 52 */       throw new ConfigErrorException("設置檔案遺失: ./config/其他控制端/血盟等級設定表.properties");
/*    */     } finally {
/* 54 */       set.clear();
/*    */     } 
/*    */   }
/*    */   
/*    */   private static void setClansLevelCondition(Properties properties) {
/* 59 */     for (int i = 0; i < CLAN_MAX_LEVEL.intValue(); i++) {
/* 60 */       clansLevelUpCondition.add(getClanLevelCondition(properties, Integer.valueOf(i + 1)));
/*    */     }
/*    */   }
/*    */   
/*    */   private static ClanLevelUpCondition getClanLevelCondition(Properties properties, Integer level) {
/* 65 */     int[] items = toIntArray(properties.getProperty("clanlv" + level, ""), ",");
/* 66 */     int[] itemsCount = toIntArray(properties.getProperty("clanlvcount" + level, ""), ",");
/* 67 */     int energy = Integer.parseInt(properties.getProperty("clanenergy" + level, "0"));
/* 68 */     int adena = Integer.parseInt(properties.getProperty("clanadena" + level, "0"));
/*    */ 
/*    */     
/* 71 */     if (items.length > 0 && items.length != itemsCount.length) {
/* 72 */       throw new LogicError("設置檔案錯誤: 血盟升級道具與數量不匹配");
/*    */     }
/*    */     
/* 75 */     ClanLevelUpCondition condition = new ClanLevelUpCondition();
/* 76 */     condition.setClanEnergy(Integer.valueOf(energy));
/* 77 */     condition.setClanAdena(Integer.valueOf(adena));
/*    */     
/* 79 */     for (int i = 0; i < items.length; i++) {
/* 80 */       condition.putMaterial(Integer.valueOf(items[i]), Integer.valueOf(itemsCount[i]));
/*    */     }
/*    */     
/* 83 */     return condition;
/*    */   }
/*    */   
/*    */   public static int[] toIntArray(String text, String type) {
/* 87 */     StringTokenizer st = new StringTokenizer(text, type);
/* 88 */     int[] iReturn = new int[st.countTokens()];
/* 89 */     int i = 0;
/* 90 */     while (i < iReturn.length) {
/* 91 */       iReturn[i] = Integer.parseInt(st.nextToken());
/* 92 */       i++;
/*    */     } 
/* 94 */     return iReturn;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigClan.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */