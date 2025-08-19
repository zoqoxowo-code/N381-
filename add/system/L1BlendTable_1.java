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
/*     */ 
/*     */ public class L1BlendTable_1
/*     */ {
/*  23 */   private static final Log _log = LogFactory.getLog(L1BlendTable_1.class);
/*     */   
/*     */   private static L1BlendTable_1 _instance;
/*     */   
/*  27 */   private final Map<String, L1Blend1> _CraftIndex = new HashMap<>();
/*  28 */   private final Map<String, String> _CraftList = new HashMap<>();
/*     */ 
/*     */   
/*     */   public static L1BlendTable_1 getInstance() {
/*  32 */     if (_instance == null) {
/*  33 */       _instance = new L1BlendTable_1();
/*     */     }
/*  35 */     return _instance;
/*     */   }
/*     */   
/*     */   public void loadBlendTable() {
/*  39 */     PerformanceTimer timer = new PerformanceTimer();
/*  40 */     Connection con = null;
/*  41 */     PreparedStatement pstm = null;
/*  42 */     ResultSet rs = null;
/*     */     try {
/*  44 */       con = DatabaseFactory.get().getConnection();
/*  45 */       pstm = con.prepareStatement("SELECT * FROM w_成就圖鑑收集設定");
/*  46 */       rs = pstm.executeQuery();
/*  47 */       fillBlendTable(rs);
/*  48 */     } catch (SQLException e) {
/*  49 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/*  51 */       SQLUtil.close(rs);
/*  52 */       SQLUtil.close(pstm);
/*  53 */       SQLUtil.close(con);
/*     */     } 
/*  55 */     _log.info("載入成就收集資料數量: " + this._CraftIndex.size() + "(" + timer.get() + "ms)");
/*     */   }
/*     */   
/*     */   private void fillBlendTable(ResultSet rs) throws SQLException {
/*  59 */     while (rs.next()) {
/*  60 */       int npcid = rs.getInt("npcid");
/*  61 */       String action = rs.getString("action");
/*  62 */       String note = rs.getString("note");
/*  63 */       int checkLevel = rs.getInt("checkLevel");
/*  64 */       int checkClass = rs.getInt("checkClass");
/*  65 */       String materials = rs.getString("materials").replaceAll(" ", "");
/*  66 */       String[] needids_tmp = materials.split(",");
/*  67 */       int[] needids = new int[needids_tmp.length];
/*  68 */       int i = 0;
/*  69 */       while (i < needids_tmp.length) {
/*  70 */         needids[i] = Integer.parseInt(needids_tmp[i]);
/*  71 */         i++;
/*     */       } 
/*  73 */       String materials_count = rs.getString("materials_count").replaceAll(" ", "");
/*  74 */       String[] needcounts_tmp = materials_count.split(",");
/*  75 */       int[] needcounts = new int[needcounts_tmp.length];
/*  76 */       int j = 0;
/*  77 */       while (j < needcounts_tmp.length) {
/*  78 */         needcounts[j] = Integer.parseInt(needcounts_tmp[j]);
/*  79 */         j++;
/*     */       } 
/*  81 */       String materials_enchants = rs.getString("materials_enchants").replaceAll(" ", "");
/*  82 */       String[] needenchants_tmp = materials_enchants.split(",");
/*  83 */       int[] needenchants = new int[needenchants_tmp.length];
/*  84 */       int k = 0;
/*  85 */       while (k < needenchants_tmp.length) {
/*  86 */         needenchants[k] = Integer.parseInt(needenchants_tmp[k]);
/*  87 */         k++;
/*     */       } 
/*  89 */       String sucesshtml = rs.getString("sucess_html");
/*  90 */       String failhtml = rs.getString("fail_html");
/*  91 */       String Allmessage = rs.getString("Allmessage");
/*  92 */       int quest = rs.getInt("quest");
/*  93 */       String givebuff = rs.getString("能力說明");
/*  94 */       L1Blend1 Item_Blend1 = new L1Blend1();
/*  95 */       Item_Blend1.set_npcid(npcid);
/*  96 */       Item_Blend1.set_action(action);
/*  97 */       Item_Blend1.set_note(note);
/*  98 */       Item_Blend1.setCheckLevel(checkLevel);
/*  99 */       Item_Blend1.setCheckClass(checkClass);
/* 100 */       Item_Blend1.setMaterials(needids);
/* 101 */       Item_Blend1.setMaterials_count(needcounts);
/* 102 */       Item_Blend1.set_materials_enchants(needenchants);
/* 103 */       Item_Blend1.set_sucesshtml(sucesshtml);
/* 104 */       Item_Blend1.set_failhtml(failhtml);
/* 105 */       Item_Blend1.set_Allmessage(Allmessage);
/* 106 */       Item_Blend1.setquest(quest);
/* 107 */       Item_Blend1.set_givebuff(givebuff);
/* 108 */       String key = String.valueOf(String.valueOf(npcid)) + action;
/* 109 */       this._CraftIndex.put(key, Item_Blend1);
/* 110 */       loadCraftList(npcid);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void loadCraftList(int npcid) {
/* 115 */     Connection con = null;
/* 116 */     PreparedStatement pstm = null;
/* 117 */     ResultSet rs = null;
/*     */     try {
/* 119 */       con = DatabaseFactory.get().getConnection();
/* 120 */       pstm = con.prepareStatement("SELECT * FROM `w_成就圖鑑收集設定` WHERE `npcid` =?");
/* 121 */       pstm.setInt(1, npcid);
/* 122 */       rs = pstm.executeQuery();
/* 123 */       while (rs.next()) {
/* 124 */         String action = rs.getString("action");
/* 125 */         String note = rs.getString("note");
/* 126 */         String key = String.valueOf(String.valueOf(npcid)) + action;
/* 127 */         this._CraftList.put(key, note);
/*     */       } 
/* 129 */     } catch (SQLException e) {
/* 130 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 132 */       SQLUtil.close(rs);
/* 133 */       SQLUtil.close(pstm);
/* 134 */       SQLUtil.close(con);
/*     */     } 
/*     */   }
/*     */   
/*     */   public L1Blend1 getTemplate(String craftkey) {
/* 139 */     return this._CraftIndex.get(craftkey);
/*     */   }
/*     */   
/*     */   public Map<String, String> get_craftlist() {
/* 143 */     return this._CraftList;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\system\L1BlendTable_1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */