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
/*    */ public class L1FireSmithCrystalTable
/*    */ {
/* 22 */   private static final Log _log = LogFactory.getLog(L1FireSmithCrystalTable.class);
/*    */   
/*    */   private static L1FireSmithCrystalTable _instance;
/*    */   
/* 26 */   private final Map<Integer, L1FireCrystal> _FireCrystalIndex = new HashMap<>();
/*    */ 
/*    */   
/*    */   public static L1FireSmithCrystalTable get() {
/* 30 */     if (_instance == null) {
/* 31 */       _instance = new L1FireSmithCrystalTable();
/*    */     }
/* 33 */     return _instance;
/*    */   }
/*    */   
/*    */   public void load() {
/* 37 */     PerformanceTimer timer = new PerformanceTimer();
/* 38 */     Connection con = null;
/* 39 */     PreparedStatement pstm = null;
/* 40 */     ResultSet rs = null;
/*    */     try {
/* 42 */       con = DatabaseFactory.get().getConnection();
/* 43 */       pstm = con.prepareStatement("SELECT * FROM system_firesmith_crystal");
/* 44 */       rs = pstm.executeQuery();
/* 45 */       while (rs.next()) {
/* 46 */         int itemid = rs.getInt("itemid");
/* 47 */         int enchant_lv0 = rs.getInt("enchant_lv0");
/* 48 */         int enchant_lv2 = rs.getInt("enchant_lv1");
/* 49 */         int enchant_lv3 = rs.getInt("enchant_lv2");
/* 50 */         int enchant_lv4 = rs.getInt("enchant_lv3");
/* 51 */         int enchant_lv5 = rs.getInt("enchant_lv4");
/* 52 */         int enchant_lv6 = rs.getInt("enchant_lv5");
/* 53 */         int enchant_lv7 = rs.getInt("enchant_lv6");
/* 54 */         int enchant_lv8 = rs.getInt("enchant_lv7");
/* 55 */         int enchant_lv9 = rs.getInt("enchant_lv8");
/* 56 */         int enchant_lv10 = rs.getInt("enchant_lv9");
/* 57 */         int enchant_lv11 = rs.getInt("enchant_lv10");
/* 58 */         int enchant_lv12 = rs.getInt("enchant_lv11");
/* 59 */         int enchant_lv13 = rs.getInt("enchant_lv12");
/* 60 */         int enchant_lv14 = rs.getInt("enchant_lv13");
/* 61 */         int enchant_lv15 = rs.getInt("enchant_lv14");
/* 62 */         L1FireCrystal fireCrystal = new L1FireCrystal(itemid, enchant_lv0, enchant_lv2, enchant_lv3, 
/* 63 */             enchant_lv4, enchant_lv5, enchant_lv6, enchant_lv7, enchant_lv8, enchant_lv9, enchant_lv10, 
/* 64 */             enchant_lv11, enchant_lv12, enchant_lv13, enchant_lv14, enchant_lv15);
/* 65 */         this._FireCrystalIndex.put(Integer.valueOf(itemid), fireCrystal);
/*    */       } 
/* 67 */     } catch (SQLException e) {
/* 68 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } finally {
/* 70 */       SQLUtil.close(rs);
/* 71 */       SQLUtil.close(pstm);
/* 72 */       SQLUtil.close(con);
/*    */     } 
/* 74 */     _log.info("載入火神融煉道具資料數量: " + this._FireCrystalIndex.size() + "(" + timer.get() + "ms)");
/*    */   }
/*    */   
/*    */   public L1FireCrystal getTemplate(int itemid) {
/* 78 */     return this._FireCrystalIndex.get(Integer.valueOf(itemid));
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\system\L1FireSmithCrystalTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */