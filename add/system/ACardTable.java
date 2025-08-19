/*    */ package com.add.system;
/*    */ 
/*    */ import com.lineage.DatabaseFactory;
/*    */ import com.lineage.server.utils.PerformanceTimer;
/*    */ import com.lineage.server.utils.SQLUtil;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ACardTable
/*    */ {
/* 22 */   private static final Log _log = LogFactory.getLog(ACardTable.class);
/* 23 */   private static final Map<Integer, ACard> _cardIndex = new HashMap<>();
/*    */   private static ACardTable _instance;
/*    */   
/*    */   public static ACardTable get() {
/* 27 */     if (_instance == null) {
/* 28 */       _instance = new ACardTable();
/*    */     }
/* 30 */     return _instance;
/*    */   }
/*    */   
/*    */   public void load() {
/* 34 */     PerformanceTimer timer = new PerformanceTimer();
/* 35 */     Connection cn = null;
/* 36 */     PreparedStatement ps = null;
/* 37 */     ResultSet rs = null;
/* 38 */     int i = 0;
/*    */     try {
/* 40 */       cn = DatabaseFactory.get().getConnection();
/* 41 */       ps = cn.prepareStatement("SELECT * FROM `w_變身卡片能力登入`");
/* 42 */       rs = ps.executeQuery();
/* 43 */       while (rs.next()) {
/* 44 */         int id = rs.getInt("流水號");
/* 45 */         String msg1 = rs.getString("獲得能力時的訊息");
/* 46 */         String msg2 = rs.getString("出現顯示能力頁面名稱");
/* 47 */         String cmd = rs.getString("對話檔指令");
/* 48 */         int questid = rs.getInt("任務編號");
/* 49 */         int polyid = rs.getInt("變身編號");
/* 50 */         int polytime = rs.getInt("變身時效");
/* 51 */         int polyitemid = rs.getInt("變身消耗道具編號");
/* 52 */         int polyitemcount = rs.getInt("變身消耗道具數量");
/* 53 */         int str = rs.getInt("力量");
/* 54 */         int dex = rs.getInt("敏捷");
/* 55 */         int con = rs.getInt("體質");
/* 56 */         int Int = rs.getInt("智力");
/* 57 */         int wis = rs.getInt("精神");
/* 58 */         int cha = rs.getInt("魅力");
/* 59 */         int ac = rs.getInt("防禦");
/* 60 */         int hp = rs.getInt("血量");
/* 61 */         int mp = rs.getInt("魔量");
/* 62 */         int hpr = rs.getInt("回血量");
/* 63 */         int mpr = rs.getInt("回魔量");
/* 64 */         int dmg = rs.getInt("近距離傷害");
/* 65 */         int bowdmg = rs.getInt("遠距離傷害");
/* 66 */         int hit = rs.getInt("近距離命中");
/* 67 */         int bowhit = rs.getInt("遠戰攻擊命中");
/* 68 */         int dmgr = rs.getInt("物理減免傷害");
/* 69 */         int mdmgr = rs.getInt("魔法減免傷害");
/* 70 */         int sp = rs.getInt("魔攻");
/* 71 */         int mhit = rs.getInt("魔法命中");
/* 72 */         int mr = rs.getInt("魔法防禦");
/* 73 */         int fire = rs.getInt("火屬性防禦");
/* 74 */         int water = rs.getInt("水屬性防禦");
/* 75 */         int wind = rs.getInt("風屬性防禦");
/* 76 */         int earth = rs.getInt("地屬性防禦");
/* 77 */         ACard card = new ACard(id, msg1, msg2, cmd, questid, polyid, polytime, polyitemid, polyitemcount, 
/* 78 */             str, dex, con, Int, wis, cha, ac, hp, mp, hpr, mpr, dmg, bowdmg, hit, bowhit, dmgr, mdmgr, sp, 
/* 79 */             mhit, mr, fire, water, wind, earth);
/* 80 */         _cardIndex.put(Integer.valueOf(id), card);
/* 81 */         i++;
/*    */       } 
/* 83 */     } catch (SQLException e) {
/* 84 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } finally {
/* 86 */       SQLUtil.close(rs);
/* 87 */       SQLUtil.close(ps);
/* 88 */       SQLUtil.close(cn);
/*    */     } 
/* 90 */     _log.info("讀取->w_變身卡片能力登入: " + i + "(" + timer.get() + "ms)");
/*    */   }
/*    */   
/*    */   public int ACardSize() {
/* 94 */     return _cardIndex.size();
/*    */   }
/*    */   
/*    */   public ACard getCard(int id) {
/* 98 */     return _cardIndex.get(Integer.valueOf(id));
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\system\ACardTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */