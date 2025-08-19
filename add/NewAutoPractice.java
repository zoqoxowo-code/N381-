/*     */ package com.add;
/*     */ 
/*     */ import com.lineage.DatabaseFactory;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.model.L1Character;
/*     */ import com.lineage.server.serverpackets.S_NPCTalkReturn;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.utils.SQLUtil;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NewAutoPractice
/*     */ {
/*  23 */   private static final Log _log = LogFactory.getLog(NewAutoPractice.class);
/*     */   private static NewAutoPractice _instance;
/*     */   
/*     */   public static NewAutoPractice get() {
/*  27 */     if (_instance == null) {
/*  28 */       _instance = new NewAutoPractice();
/*     */     }
/*  30 */     return _instance;
/*     */   }
/*     */   
/*     */   public void load() {
/*  34 */     Connection co = null;
/*  35 */     PreparedStatement pm = null;
/*  36 */     ResultSet rs = null;
/*     */     try {
/*  38 */       co = DatabaseFactory.get().getConnection();
/*  39 */       pm = co.prepareStatement("SELECT * FROM `character_內掛仇人清單`");
/*  40 */       rs = pm.executeQuery(); do {  }
/*  41 */       while (rs.next());
/*     */     }
/*  43 */     catch (Exception e) {
/*  44 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/*  46 */       SQLUtil.close(rs);
/*  47 */       SQLUtil.close(pm);
/*  48 */       SQLUtil.close(co);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void load3() {
/*  53 */     Connection co = null;
/*  54 */     PreparedStatement pm = null;
/*  55 */     ResultSet rs = null;
/*     */     try {
/*  57 */       co = DatabaseFactory.get().getConnection();
/*  58 */       pm = co.prepareStatement("SELECT * FROM `character_bad_buddy`");
/*  59 */       rs = pm.executeQuery(); do {  }
/*  60 */       while (rs.next());
/*     */     }
/*  62 */     catch (Exception e) {
/*  63 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/*  65 */       SQLUtil.close(rs);
/*  66 */       SQLUtil.close(pm);
/*  67 */       SQLUtil.close(co);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void load2() {
/*  72 */     Connection co = null;
/*  73 */     PreparedStatement pm = null;
/*  74 */     ResultSet rs = null;
/*     */     try {
/*  76 */       co = DatabaseFactory.get().getConnection();
/*  77 */       pm = co.prepareStatement("SELECT * FROM `character_內掛被殺清單`");
/*  78 */       rs = pm.executeQuery(); do {  }
/*  79 */       while (rs.next());
/*     */     }
/*  81 */     catch (Exception e) {
/*  82 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/*  84 */       SQLUtil.close(rs);
/*  85 */       SQLUtil.close(pm);
/*  86 */       SQLUtil.close(co);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addEnemy(L1PcInstance pc) {
/*  91 */     Connection co = null;
/*  92 */     PreparedStatement pm = null;
/*  93 */     ResultSet rs = null;
/*     */     try {
/*  95 */       co = DatabaseFactory.get().getConnection();
/*  96 */       pm = co.prepareStatement("SELECT * FROM `character_內掛仇人清單`");
/*  97 */       rs = pm.executeQuery();
/*  98 */       while (rs.next()) {
/*  99 */         if (pc.getId() == rs.getInt("CharObjId")) {
/* 100 */           pc.setInEnemyList(rs.getString("EnemyObjId"));
/*     */         }
/*     */       } 
/* 103 */     } catch (Exception e) {
/* 104 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 106 */       SQLUtil.close(rs);
/* 107 */       SQLUtil.close(pm);
/* 108 */       SQLUtil.close(co);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void AddEnemyList(L1PcInstance pc, String name) {
/* 113 */     int id = LoadMaxId() + 1;
/* 114 */     Connection con = null;
/* 115 */     PreparedStatement pstm = null;
/*     */     try {
/* 117 */       con = DatabaseFactory.get().getConnection();
/* 118 */       pstm = con.prepareStatement("INSERT INTO `character_內掛仇人清單` SET `Id`=?,`CharObjId`=?,`EnemyObjId`=?");
/* 119 */       pstm.setInt(1, id);
/* 120 */       pstm.setInt(2, pc.getId());
/* 121 */       pstm.setString(3, name);
/* 122 */       pstm.execute();
/* 123 */     } catch (SQLException e) {
/* 124 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 126 */       SQLUtil.close(pstm);
/* 127 */       SQLUtil.close(con);
/*     */     } 
/* 129 */     pc.setInEnemyList(name);
/*     */   }
/*     */   
/*     */   public int LoadMaxId() {
/* 133 */     int id = 1;
/* 134 */     Connection co = null;
/* 135 */     PreparedStatement pm = null;
/* 136 */     ResultSet rs = null;
/*     */     try {
/* 138 */       co = DatabaseFactory.get().getConnection();
/* 139 */       pm = co.prepareStatement("SELECT MAX(Id) FROM character_內掛仇人清單");
/* 140 */       rs = pm.executeQuery();
/* 141 */       while (rs.next()) {
/* 142 */         id = rs.getInt(1);
/*     */       }
/* 144 */     } catch (Exception e) {
/* 145 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 147 */       SQLUtil.close(rs);
/* 148 */       SQLUtil.close(pm);
/* 149 */       SQLUtil.close(co);
/*     */     } 
/* 151 */     return id;
/*     */   }
/*     */   
/*     */   public void DeleteEnemyList(L1PcInstance pc, String name) {
/* 155 */     Connection cn = null;
/* 156 */     PreparedStatement ps = null;
/*     */     try {
/* 158 */       cn = DatabaseFactory.get().getConnection();
/* 159 */       ps = cn.prepareStatement("DELETE FROM `character_內掛仇人清單` WHERE `CharObjId`=? AND `EnemyObjId`=?");
/* 160 */       ps.setInt(1, pc.getId());
/* 161 */       ps.setString(2, name);
/* 162 */       ps.execute();
/* 163 */     } catch (SQLException e) {
/* 164 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 166 */       SQLUtil.close(ps);
/* 167 */       SQLUtil.close(cn);
/*     */     } 
/* 169 */     pc.removeInEnemyList(name);
/*     */   }
/*     */   
/*     */   public void AddAutoList(L1PcInstance pc, L1Character srpc) {
/* 173 */     int id = LoadMaxId2() + 1;
/* 174 */     Connection con = null;
/* 175 */     PreparedStatement pstm = null;
/*     */     try {
/* 177 */       con = DatabaseFactory.get().getConnection();
/* 178 */       pstm = con.prepareStatement("INSERT INTO `character_內掛被殺清單` SET `Id`=?,`CharObjId`=?,`EnemyName`=?,`Time`=?");
/* 179 */       pstm.setInt(1, id);
/* 180 */       pstm.setInt(2, pc.getId());
/* 181 */       pstm.setString(3, srpc.getName());
/* 182 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
/* 183 */       String times = sdf.format(Long.valueOf(System.currentTimeMillis()));
/* 184 */       pstm.setString(4, times);
/* 185 */       pstm.execute();
/* 186 */     } catch (SQLException e) {
/* 187 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 189 */       SQLUtil.close(pstm);
/* 190 */       SQLUtil.close(con);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int LoadMaxId2() {
/* 195 */     int id = 1;
/* 196 */     Connection co = null;
/* 197 */     PreparedStatement pm = null;
/* 198 */     ResultSet rs = null;
/*     */     try {
/* 200 */       co = DatabaseFactory.get().getConnection();
/* 201 */       String sql = "SELECT MAX(Id) FROM character_內掛被殺清單";
/* 202 */       pm = co.prepareStatement("SELECT MAX(Id) FROM character_內掛被殺清單");
/* 203 */       rs = pm.executeQuery();
/* 204 */       while (rs.next()) {
/* 205 */         id = rs.getInt(1);
/*     */       }
/* 207 */     } catch (Exception e) {
/* 208 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 210 */       SQLUtil.close(rs);
/* 211 */       SQLUtil.close(pm);
/* 212 */       SQLUtil.close(co);
/*     */     } 
/* 214 */     return id;
/*     */   }
/*     */   
/*     */   public void SearchAutoLog(L1PcInstance pc) {
/* 218 */     Connection conn = null;
/* 219 */     PreparedStatement pstm = null;
/* 220 */     ResultSet rs = null;
/*     */     try {
/* 222 */       conn = DatabaseFactory.get().getConnection();
/* 223 */       pstm = conn.prepareStatement("SELECT * FROM character_內掛被殺清單");
/* 224 */       rs = pstm.executeQuery();
/* 225 */       if (rs != null) {
/* 226 */         StringBuilder stringBuilder = new StringBuilder();
/* 227 */         int i = 0;
/* 228 */         while (rs.next()) {
/* 229 */           int objid = rs.getInt("CharObjId");
/* 230 */           String name = rs.getString("EnemyName");
/* 231 */           String time = rs.getString("Time");
/* 232 */           if (objid == pc.getId()) {
/* 233 */             stringBuilder.append(String.valueOf(String.valueOf(name)) + " [" + time + "],");
/* 234 */             i++;
/*     */           } 
/*     */         } 
/* 237 */         if (i == 0) {
/* 238 */           stringBuilder.append("目前沒有任何被殺相關紀錄");
/*     */         }
/* 240 */         String[] clientStrAry = stringBuilder.toString().split(",");
/* 241 */         pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "x_autolist", clientStrAry));
/*     */       } 
/* 243 */     } catch (SQLException e) {
/* 244 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 246 */       SQLUtil.close(pstm);
/* 247 */       SQLUtil.close(conn);
/* 248 */       SQLUtil.close(rs);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void ClearAutoLog(int objid) {
/* 253 */     Connection cn = null;
/* 254 */     PreparedStatement ps = null;
/*     */     try {
/* 256 */       cn = DatabaseFactory.get().getConnection();
/* 257 */       ps = cn.prepareStatement("DELETE FROM `character_內掛被殺清單` WHERE `CharObjId`=?");
/* 258 */       ps.setInt(1, objid);
/* 259 */       ps.execute();
/* 260 */     } catch (SQLException e) {
/* 261 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 263 */       SQLUtil.close(ps);
/* 264 */       SQLUtil.close(cn);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addBadEnemy(L1PcInstance pc) {
/* 269 */     Connection co = null;
/* 270 */     PreparedStatement pm = null;
/* 271 */     ResultSet rs = null;
/*     */     try {
/* 273 */       co = DatabaseFactory.get().getConnection();
/* 274 */       pm = co.prepareStatement("SELECT * FROM `character_bad_buddy`");
/* 275 */       rs = pm.executeQuery();
/* 276 */       while (rs.next()) {
/* 277 */         if (pc.getId() == rs.getInt("CharObjId")) {
/* 278 */           pc.setBadInEnemyList(rs.getString("EnemyObjId"));
/*     */         }
/*     */       } 
/* 281 */     } catch (Exception e) {
/* 282 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 284 */       SQLUtil.close(rs);
/* 285 */       SQLUtil.close(pm);
/* 286 */       SQLUtil.close(co);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void AddBadEnemyList(L1PcInstance pc, String name) {
/* 291 */     int id = LoadBadMaxId() + 1;
/* 292 */     Connection con = null;
/* 293 */     PreparedStatement pstm = null;
/*     */     try {
/* 295 */       con = DatabaseFactory.get().getConnection();
/* 296 */       pstm = con.prepareStatement("INSERT INTO `character_bad_buddy` SET `Id`=?,`CharObjId`=?,`EnemyObjId`=?");
/* 297 */       pstm.setInt(1, id);
/* 298 */       pstm.setInt(2, pc.getId());
/* 299 */       pstm.setString(3, name);
/* 300 */       pstm.execute();
/* 301 */     } catch (SQLException e) {
/* 302 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 304 */       SQLUtil.close(pstm);
/* 305 */       SQLUtil.close(con);
/*     */     } 
/* 307 */     pc.setBadInEnemyList(name);
/*     */   }
/*     */   
/*     */   public int LoadBadMaxId() {
/* 311 */     int id = 1;
/* 312 */     Connection co = null;
/* 313 */     PreparedStatement pm = null;
/* 314 */     ResultSet rs = null;
/*     */     try {
/* 316 */       co = DatabaseFactory.get().getConnection();
/* 317 */       pm = co.prepareStatement("SELECT MAX(Id) FROM character_bad_buddy");
/* 318 */       rs = pm.executeQuery();
/* 319 */       while (rs.next()) {
/* 320 */         id = rs.getInt(1);
/*     */       }
/* 322 */     } catch (Exception e) {
/* 323 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 325 */       SQLUtil.close(rs);
/* 326 */       SQLUtil.close(pm);
/* 327 */       SQLUtil.close(co);
/*     */     } 
/* 329 */     return id;
/*     */   }
/*     */   
/*     */   public void DeleteBadEnemyList(L1PcInstance pc, String name) {
/* 333 */     Connection cn = null;
/* 334 */     PreparedStatement ps = null;
/*     */     try {
/* 336 */       cn = DatabaseFactory.get().getConnection();
/* 337 */       ps = cn.prepareStatement("DELETE FROM `character_bad_buddy` WHERE `CharObjId`=? AND `EnemyObjId`=?");
/* 338 */       ps.setInt(1, pc.getId());
/* 339 */       ps.setString(2, name);
/* 340 */       ps.execute();
/* 341 */     } catch (SQLException e) {
/* 342 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } finally {
/* 344 */       SQLUtil.close(ps);
/* 345 */       SQLUtil.close(cn);
/*     */     } 
/* 347 */     pc.removeBadInEnemyList(name);
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\NewAutoPractice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */