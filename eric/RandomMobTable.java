/*     */ package com.eric;
/*     */ 
/*     */ import com.lineage.DatabaseFactory;
/*     */ import com.lineage.server.datatables.MapsTable;
/*     */ import com.lineage.server.utils.L1SpawnUtil;
/*     */ import com.lineage.server.utils.SQLUtil;
/*     */ import com.lineage.server.utils.collections.Maps;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RandomMobTable
/*     */ {
/*  25 */   private static Logger _log = Logger.getLogger(RandomMobTable.class.getName());
/*     */   private static RandomMobTable _instance;
/*     */   
/*     */   private RandomMobTable() {
/*  29 */     this._mobs = Maps.newHashMap();
/*  30 */     loadRandomMobFromDatabase();
/*     */   }
/*     */   private final Map<Integer, Data> _mobs;
/*     */   private void loadRandomMobFromDatabase() {
/*  34 */     Connection con = null;
/*  35 */     PreparedStatement pstm = null;
/*  36 */     ResultSet rs = null;
/*     */     try {
/*  38 */       con = DatabaseFactory.get().getConnection();
/*  39 */       pstm = con.prepareStatement("SELECT * FROM eric_random_mob");
/*  40 */       rs = pstm.executeQuery();
/*  41 */       while (rs.next()) {
/*  42 */         Data data = new Data(null);
/*  43 */         int id = rs.getInt("id");
/*  44 */         data.id = id;
/*  45 */         data.note = rs.getString("note");
/*  46 */         String[] temp = rs.getString("mapId").split(",");
/*  47 */         short[] i = new short[temp.length];
/*  48 */         int loop = 0;
/*     */         String[] array;
/*  50 */         int length = (array = temp).length;
/*  51 */         int j = 0;
/*  52 */         while (j < length) {
/*  53 */           String s = array[j];
/*  54 */           i[loop] = (short)Integer.parseInt(s);
/*  55 */           loop++;
/*  56 */           j++;
/*     */         } 
/*  58 */         data.mapId = i;
/*  59 */         data.mobId = rs.getInt("mobId");
/*  60 */         data.cont = rs.getInt("cont");
/*  61 */         data.timeSecondToDelete = rs.getInt("timeSecondToKill");
/*  62 */         data.isActive = rs.getBoolean("isActive");
/*  63 */         this._mobs.put(new Integer(id), data);
/*     */       } 
/*  65 */       _log.config("RandomMob " + this._mobs.size());
/*  66 */     } catch (SQLException e) {
/*  67 */       e.printStackTrace();
/*  68 */       _log.log(Level.SEVERE, e.getLocalizedMessage(), e);
/*     */     } finally {
/*  70 */       SQLUtil.close(rs);
/*  71 */       SQLUtil.close(pstm);
/*  72 */       SQLUtil.close(con);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void startRandomMob() {
/*  77 */     Iterator<Data> iterator = this._mobs.values().iterator();
/*  78 */     while (iterator.hasNext()) {
/*  79 */       Data data = iterator.next();
/*  80 */       if (data.isActive) {
/*  81 */         L1SpawnUtil.spawn(data.id);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static RandomMobTable getInstance() {
/*  87 */     if (_instance == null) {
/*  88 */       _instance = new RandomMobTable();
/*     */     }
/*  90 */     return _instance;
/*     */   }
/*     */   
/*     */   public short getRandomMapId(int RandomMobId) {
/*  94 */     Data data = this._mobs.get(Integer.valueOf(RandomMobId));
/*  95 */     if (data == null) {
/*  96 */       return 0;
/*     */     }
/*  98 */     int length = ((Data)this._mobs.get(Integer.valueOf(RandomMobId))).mapId.length;
/*  99 */     int rand = (new Random()).nextInt(length);
/* 100 */     return ((Data)this._mobs.get(Integer.valueOf(RandomMobId))).mapId[rand];
/*     */   }
/*     */   
/*     */   public int getRandomMapX(int mapId) {
/* 104 */     int startX = MapsTable.get().getStartX(mapId);
/* 105 */     int endX = MapsTable.get().getEndX(mapId);
/* 106 */     int rand = (new Random()).nextInt(endX - startX);
/* 107 */     return startX + rand;
/*     */   }
/*     */   
/*     */   public int getRandomMapY(int mapId) {
/* 111 */     int startY = MapsTable.get().getStartY(mapId);
/* 112 */     int endY = MapsTable.get().getEndY(mapId);
/* 113 */     int rand = (new Random()).nextInt(endY - startY);
/* 114 */     return startY + rand;
/*     */   }
/*     */   
/*     */   public String getName(int RandomMobId) {
/* 118 */     Data data = this._mobs.get(Integer.valueOf(RandomMobId));
/* 119 */     if (data == null) {
/* 120 */       return "";
/*     */     }
/* 122 */     return ((Data)this._mobs.get(Integer.valueOf(RandomMobId))).note;
/*     */   }
/*     */   
/*     */   public int getMobId(int RandomMobId) {
/* 126 */     Data data = this._mobs.get(Integer.valueOf(RandomMobId));
/* 127 */     if (data == null) {
/* 128 */       return 0;
/*     */     }
/* 130 */     return ((Data)this._mobs.get(Integer.valueOf(RandomMobId))).mobId;
/*     */   }
/*     */   
/*     */   public int getCont(int RandomMobId) {
/* 134 */     Data data = this._mobs.get(Integer.valueOf(RandomMobId));
/* 135 */     if (data == null) {
/* 136 */       return 0;
/*     */     }
/* 138 */     return ((Data)this._mobs.get(Integer.valueOf(RandomMobId))).cont;
/*     */   }
/*     */   
/*     */   public int getTimeSecondToDelete(int RandomMobId) {
/* 142 */     Data data = this._mobs.get(Integer.valueOf(RandomMobId));
/* 143 */     if (data == null) {
/* 144 */       return 0;
/*     */     }
/* 146 */     return ((Data)this._mobs.get(Integer.valueOf(RandomMobId))).timeSecondToDelete;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class Data
/*     */   {
/*     */     private Data() {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 159 */     public int id = 0;
/* 160 */     public String note = "";
/* 161 */     public int mobId = 0;
/* 162 */     public int cont = 0;
/* 163 */     public short[] mapId = new short[0];
/* 164 */     public int timeSecondToDelete = -1;
/*     */     public boolean isActive = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\eric\RandomMobTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */