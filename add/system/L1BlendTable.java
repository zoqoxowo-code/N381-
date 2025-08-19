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
/*     */ public class L1BlendTable
/*     */ {
/*  23 */   private static final Log _log = LogFactory.getLog(L1BlendTable.class);
/*     */   
/*     */   private static L1BlendTable _instance;
/*     */   
/*  27 */   private final Map<String, L1Blend> _CraftIndex = new HashMap<>();
/*  28 */   private final Map<String, String> _CraftList = new HashMap<>();
/*     */ 
/*     */   
/*     */   public static L1BlendTable getInstance() {
/*  32 */     if (_instance == null) {
/*  33 */       _instance = new L1BlendTable();
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
/*  45 */       pstm = con.prepareStatement("SELECT * FROM w_火神裝備製作");
/*  46 */       rs = pstm.executeQuery();
/*  47 */       fillBlendTable(rs);
/*  48 */     } catch (SQLException e) {
/*  49 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/*  51 */       SQLUtil.close(rs);
/*  52 */       SQLUtil.close(pstm);
/*  53 */       SQLUtil.close(con);
/*     */     } 
/*  55 */     _log.info("載入道具製造資料數量: " + this._CraftIndex.size() + "(" + timer.get() + "ms)");
/*     */   }
/*     */   
/*     */   private void fillBlendTable(ResultSet rs) throws SQLException {
/*  59 */     while (rs.next()) {
/*  60 */       int npcid = rs.getInt("npcid");
/*  61 */       String action = rs.getString("action");
/*  62 */       String note = rs.getString("note");
/*  63 */       int checkLevel = rs.getInt("checkLevel");
/*  64 */       int checkClass = rs.getInt("checkClass");
/*  65 */       int rnd = rs.getInt("rnd");
/*  66 */       int hpConsume = rs.getInt("hpConsume");
/*  67 */       int mpConsume = rs.getInt("mpConsume");
/*  68 */       int bonusitem = rs.getInt("bonus_item");
/*  69 */       int bonusitemcount = rs.getInt("bonus_item_count");
/*  70 */       int bonusitemenchant = rs.getInt("bonus_item_enchant");
/*  71 */       String materials = rs.getString("materials").replaceAll(" ", "");
/*  72 */       String[] needids_tmp = materials.split(",");
/*  73 */       int[] needids = new int[needids_tmp.length];
/*  74 */       int i = 0;
/*  75 */       while (i < needids_tmp.length) {
/*  76 */         needids[i] = Integer.parseInt(needids_tmp[i]);
/*  77 */         i++;
/*     */       } 
/*  79 */       String materials_count = rs.getString("materials_count").replaceAll(" ", "");
/*  80 */       String[] needcounts_tmp = materials_count.split(",");
/*  81 */       int[] needcounts = new int[needcounts_tmp.length];
/*  82 */       int j = 0;
/*  83 */       while (j < needcounts_tmp.length) {
/*  84 */         needcounts[j] = Integer.parseInt(needcounts_tmp[j]);
/*  85 */         j++;
/*     */       } 
/*  87 */       String materials_enchants = rs.getString("materials_enchants").replaceAll(" ", "");
/*  88 */       String[] needenchants_tmp = materials_enchants.split(",");
/*  89 */       int[] needenchants = new int[needenchants_tmp.length];
/*  90 */       int k = 0;
/*  91 */       while (k < needenchants_tmp.length) {
/*  92 */         needenchants[k] = Integer.parseInt(needenchants_tmp[k]);
/*  93 */         k++;
/*     */       } 
/*  95 */       int new_item = rs.getInt("new_item");
/*  96 */       int new_item_counts = rs.getInt("new_item_counts");
/*  97 */       int new_Enchantlvl_SW = rs.getInt("new_Enchantlvl_SW");
/*  98 */       int new_item_Enchantlvl = rs.getInt("new_item_Enchantlvl");
/*  99 */       int new_item_bless = rs.getInt("new_item_Bless");
/* 100 */       int residueitem = rs.getInt("residue_item");
/* 101 */       int residuecount = rs.getInt("residue_count");
/* 102 */       int replacement_count = rs.getInt("replacement_count");
/* 103 */       boolean inputamount = rs.getBoolean("input_amount");
/* 104 */       boolean all_in_once = rs.getBoolean("all_in_once");
/* 105 */       String sucesshtml = rs.getString("sucess_html");
/* 106 */       String failhtml = rs.getString("fail_html");
/* 107 */       String Allmessage = rs.getString("Allmessage");
/* 108 */       String runmessage = rs.getString("顯示假機率");
/* 109 */       int itemran = rs.getInt("自訂機率道具");
/* 110 */       int itemranup = rs.getInt("自訂機率數量上限");
/* 111 */       String othermessage = rs.getString("自訂機率道具名稱");
/* 112 */       int itembroad = rs.getInt("公告");
/* 113 */       L1Blend Item_Blend = new L1Blend();
/* 114 */       Item_Blend.set_npcid(npcid);
/* 115 */       Item_Blend.set_action(action);
/* 116 */       Item_Blend.set_note(note);
/* 117 */       Item_Blend.setCheckLevel(checkLevel);
/* 118 */       Item_Blend.setCheckClass(checkClass);
/* 119 */       Item_Blend.setRandom(rnd);
/* 120 */       Item_Blend.setHpConsume(hpConsume);
/* 121 */       Item_Blend.setMpConsume(mpConsume);
/* 122 */       Item_Blend.setMaterials(needids);
/* 123 */       Item_Blend.setMaterials_count(needcounts);
/* 124 */       Item_Blend.set_materials_enchants(needenchants);
/* 125 */       Item_Blend.setNew_item(new_item);
/* 126 */       Item_Blend.setNew_item_counts(new_item_counts);
/* 127 */       Item_Blend.setNew_Enchantlvl_SW(new_Enchantlvl_SW);
/* 128 */       Item_Blend.setNew_item_Enchantlvl(new_item_Enchantlvl);
/* 129 */       Item_Blend.setNew_item_Bless(new_item_bless);
/* 130 */       Item_Blend.setResidue_Item(residueitem);
/* 131 */       Item_Blend.setResidue_Count(residuecount);
/* 132 */       Item_Blend.setReplacement_count(replacement_count);
/* 133 */       Item_Blend.setInputAmount(inputamount);
/* 134 */       Item_Blend.setAll_In_Once(all_in_once);
/* 135 */       Item_Blend.setBonus_item(bonusitem);
/* 136 */       Item_Blend.setBonus_item_count(bonusitemcount);
/* 137 */       Item_Blend.setBonus_item_enchant(bonusitemenchant);
/* 138 */       Item_Blend.set_sucesshtml(sucesshtml);
/* 139 */       Item_Blend.set_failhtml(failhtml);
/* 140 */       Item_Blend.set_Allmessage(Allmessage);
/* 141 */       Item_Blend.set_runmessage(runmessage);
/* 142 */       Item_Blend.setitembroad(itembroad);
/* 143 */       Item_Blend.setitemran(itemran);
/* 144 */       Item_Blend.setitemranup(itemranup);
/* 145 */       Item_Blend.set_othermessage(othermessage);
/* 146 */       String key = String.valueOf(String.valueOf(npcid)) + action;
/* 147 */       this._CraftIndex.put(key, Item_Blend);
/* 148 */       loadCraftList(npcid);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void loadCraftList(int npcid) {
/* 153 */     Connection con = null;
/* 154 */     PreparedStatement pstm = null;
/* 155 */     ResultSet rs = null;
/*     */     try {
/* 157 */       con = DatabaseFactory.get().getConnection();
/* 158 */       pstm = con.prepareStatement("SELECT * FROM `w_火神裝備製作` WHERE `npcid` =?");
/* 159 */       pstm.setInt(1, npcid);
/* 160 */       rs = pstm.executeQuery();
/* 161 */       while (rs.next()) {
/* 162 */         String action = rs.getString("action");
/* 163 */         String note = rs.getString("note");
/* 164 */         String key = String.valueOf(String.valueOf(npcid)) + action;
/* 165 */         this._CraftList.put(key, note);
/*     */       } 
/* 167 */     } catch (SQLException e) {
/* 168 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 170 */       SQLUtil.close(rs);
/* 171 */       SQLUtil.close(pstm);
/* 172 */       SQLUtil.close(con);
/*     */     } 
/*     */   }
/*     */   
/*     */   public L1Blend getTemplate(String craftkey) {
/* 177 */     return this._CraftIndex.get(craftkey);
/*     */   }
/*     */   
/*     */   public Map<String, String> get_craftlist() {
/* 181 */     return this._CraftList;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\system\L1BlendTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */