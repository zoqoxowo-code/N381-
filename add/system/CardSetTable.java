/*     */ package com.add.system;
/*     */ 
/*     */ import com.lineage.DatabaseFactory;
/*     */ import com.lineage.server.utils.PerformanceTimer;
/*     */ import com.lineage.server.utils.SQLUtil;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CardSetTable
/*     */ {
/*  22 */   private static final Log _log = LogFactory.getLog(CardSetTable.class);
/*  23 */   private static final Map<Integer, CardPolySet> _cardIndex = new HashMap<>();
/*     */   private static CardSetTable _instance;
/*     */   
/*     */   public static CardSetTable get() {
/*  27 */     if (_instance == null) {
/*  28 */       _instance = new CardSetTable();
/*     */     }
/*  30 */     return _instance;
/*     */   }
/*     */   
/*     */   public void load() {
/*  34 */     PerformanceTimer timer = new PerformanceTimer();
/*  35 */     Connection cn = null;
/*  36 */     PreparedStatement ps = null;
/*  37 */     ResultSet rs = null;
/*  38 */     int t = 0;
/*     */     try {
/*  40 */       cn = DatabaseFactory.get().getConnection();
/*  41 */       ps = cn.prepareStatement("SELECT * FROM `w_變身卡片能力組合套卡`");
/*  42 */       rs = ps.executeQuery();
/*  43 */       while (rs.next()) {
/*  44 */         int id = rs.getInt("流水號");
/*  45 */         String msg1 = rs.getString("組合套卡名稱");
/*  46 */         String needisd = rs.getString("需求的變身卡編號").replaceAll(" ", "");
/*  47 */         String[] needi_tmp = needisd.split(",");
/*  48 */         int[] needids = new int[needi_tmp.length];
/*  49 */         int i = 0;
/*  50 */         while (i < needi_tmp.length) {
/*  51 */           needids[i] = Integer.parseInt(needi_tmp[i]);
/*  52 */           i++;
/*     */         } 
/*  54 */         String needquest = rs.getString("需求的玩家任務編號").replaceAll(" ", "");
/*  55 */         String[] needq_tmp = needquest.split(",");
/*  56 */         int[] needquests = new int[needq_tmp.length];
/*  57 */         int k = 0;
/*  58 */         while (k < needq_tmp.length) {
/*  59 */           needquests[k] = Integer.parseInt(needq_tmp[k]);
/*  60 */           k++;
/*     */         } 
/*  62 */         String needname = rs.getString("需求的變身卡名稱").replaceAll(" ", "");
/*  63 */         String[] needn_tmp = needname.split(",");
/*  64 */         String[] neednames = new String[needn_tmp.length];
/*  65 */         int j = 0;
/*  66 */         while (j < needn_tmp.length) {
/*  67 */           neednames[j] = needn_tmp[j];
/*  68 */           j++;
/*     */         } 
/*  70 */         int questid = rs.getInt("任務紀錄編號");
/*  71 */         int str = rs.getInt("力量");
/*  72 */         int dex = rs.getInt("敏捷");
/*  73 */         int con = rs.getInt("體質");
/*  74 */         int Int = rs.getInt("智力");
/*  75 */         int wis = rs.getInt("精神");
/*  76 */         int cha = rs.getInt("魅力");
/*  77 */         int ac = rs.getInt("防禦");
/*  78 */         int hp = rs.getInt("血量");
/*  79 */         int mp = rs.getInt("魔量");
/*  80 */         int hpr = rs.getInt("回血量");
/*  81 */         int mpr = rs.getInt("回魔量");
/*  82 */         int dmg = rs.getInt("近距離傷害");
/*  83 */         int bowdmg = rs.getInt("遠距離傷害");
/*  84 */         int hit = rs.getInt("近距離命中");
/*  85 */         int bowhit = rs.getInt("遠戰攻擊命中");
/*  86 */         int dmgr = rs.getInt("物理減免傷害");
/*  87 */         int mdmgr = rs.getInt("魔法減免傷害");
/*  88 */         int sp = rs.getInt("魔攻");
/*  89 */         int mhit = rs.getInt("魔法命中");
/*  90 */         int mr = rs.getInt("魔法防禦");
/*  91 */         int fire = rs.getInt("火屬性防禦");
/*  92 */         int water = rs.getInt("水屬性防禦");
/*  93 */         int wind = rs.getInt("風屬性防禦");
/*  94 */         int earth = rs.getInt("地屬性防禦");
/*  95 */         CardPolySet card = new CardPolySet(id, msg1, needids, needquests, neednames, questid, str, dex, 
/*  96 */             con, Int, wis, cha, ac, hp, mp, hpr, mpr, dmg, bowdmg, hit, bowhit, dmgr, mdmgr, sp, mhit, mr, 
/*  97 */             fire, water, wind, earth);
/*  98 */         _cardIndex.put(Integer.valueOf(id), card);
/*  99 */         t++;
/*     */       } 
/* 101 */     } catch (SQLException e) {
/* 102 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 104 */       SQLUtil.close(rs);
/* 105 */       SQLUtil.close(ps);
/* 106 */       SQLUtil.close(cn);
/*     */     } 
/* 108 */     _log.info("讀取->w_變身卡片能力組合套卡系統: " + t + "(" + timer.get() + "ms)");
/*     */   }
/*     */   
/*     */   public int CardCardSize() {
/* 112 */     return _cardIndex.size();
/*     */   }
/*     */   
/*     */   public CardPolySet getCard(int id) {
/* 116 */     return _cardIndex.get(Integer.valueOf(id));
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\system\CardSetTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */