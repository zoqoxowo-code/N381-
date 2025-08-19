/*     */ package com.add;
/*     */ 
/*     */ import com.lineage.DatabaseFactory;
/*     */ import com.lineage.Server;
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.serverpackets.S_HPUpdate;
/*     */ import com.lineage.server.serverpackets.S_MPUpdate;
/*     */ import com.lineage.server.serverpackets.S_OwnCharStatus;
/*     */ import com.lineage.server.serverpackets.S_OwnCharStatus2;
/*     */ import com.lineage.server.serverpackets.S_SPMR;
/*     */ import com.lineage.server.serverpackets.S_SystemMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.utils.SQLUtil;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class En_count
/*     */ {
/*  28 */   private static ArrayList<ArrayList<Object>> aData = new ArrayList<>();
/*     */   private static boolean BUILD_DATA = false;
/*     */   public static final String TOKEN = ",";
/*     */   
/*     */   public static void main(String[] a) {
/*     */     try {
/*     */       while (true) {
/*  35 */         Server.main(null);
/*     */       }
/*  37 */     } catch (Exception exception) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public static void forIntensifyArmor(L1PcInstance pc, L1ItemInstance item) {
/*  42 */     ArrayList<Object> aTempData = null;
/*  43 */     if (!BUILD_DATA) {
/*  44 */       BUILD_DATA = true;
/*  45 */       getData();
/*     */     } 
/*  47 */     int i = 0;
/*  48 */     while (i < aData.size()) {
/*  49 */       aTempData = aData.get(i);
/*  50 */       if (pc.getArmorCount1() >= ((Integer)aTempData.get(0)).intValue() && 
/*  51 */         pc.getArmorCount1() <= ((Integer)aTempData.get(15)).intValue()) {
/*  52 */         String add1 = "";
/*  53 */         String add2 = "";
/*  54 */         String add3 = "";
/*  55 */         String add4 = "";
/*  56 */         String add5 = "";
/*  57 */         String add6 = "";
/*  58 */         String add7 = "";
/*  59 */         String add8 = "";
/*  60 */         String add9 = "";
/*  61 */         String add10 = "";
/*  62 */         String add11 = "";
/*  63 */         String add12 = "";
/*  64 */         String add13 = "";
/*  65 */         String add14 = "";
/*  66 */         String add15 = "";
/*  67 */         String add16 = "";
/*  68 */         String add17 = "";
/*  69 */         String add18 = "";
/*  70 */         String add19 = "";
/*  71 */         String add20 = "";
/*  72 */         String add21 = "";
/*  73 */         String add22 = "";
/*  74 */         String add23 = "";
/*  75 */         String add24 = "";
/*  76 */         String add25 = "";
/*  77 */         if (((Integer)aTempData.get(1)).intValue() != 0) {
/*  78 */           pc.addStr(((Integer)aTempData.get(1)).intValue());
/*  79 */           add1 = "(力量+ " + ((Integer)aTempData.get(1)).intValue() + ")";
/*     */         } 
/*  81 */         if (((Integer)aTempData.get(2)).intValue() != 0) {
/*  82 */           pc.addDex(((Integer)aTempData.get(2)).intValue());
/*  83 */           add2 = "(敏捷+ " + ((Integer)aTempData.get(2)).intValue() + ")";
/*     */         } 
/*  85 */         if (((Integer)aTempData.get(3)).intValue() != 0) {
/*  86 */           pc.addInt(((Integer)aTempData.get(3)).intValue());
/*  87 */           add3 = "(智力+ " + ((Integer)aTempData.get(3)).intValue() + ")";
/*     */         } 
/*  89 */         if (((Integer)aTempData.get(4)).intValue() != 0) {
/*  90 */           pc.addCon(((Integer)aTempData.get(4)).intValue());
/*  91 */           add4 = "(體質+ " + ((Integer)aTempData.get(4)).intValue() + ")";
/*     */         } 
/*  93 */         if (((Integer)aTempData.get(5)).intValue() != 0) {
/*  94 */           pc.addWis(((Integer)aTempData.get(5)).intValue());
/*  95 */           add5 = "(精神+ " + ((Integer)aTempData.get(5)).intValue() + ")";
/*     */         } 
/*  97 */         if (((Integer)aTempData.get(6)).intValue() != 0) {
/*  98 */           pc.addCha(((Integer)aTempData.get(6)).intValue());
/*  99 */           add6 = "(魅力+ " + ((Integer)aTempData.get(6)).intValue() + ")";
/*     */         } 
/* 101 */         if (((Integer)aTempData.get(7)).intValue() != 0) {
/* 102 */           pc.addSp(((Integer)aTempData.get(7)).intValue());
/* 103 */           add7 = "(魔攻+ " + ((Integer)aTempData.get(7)).intValue() + ")";
/*     */         } 
/* 105 */         if (((Integer)aTempData.get(8)).intValue() != 0) {
/* 106 */           pc.addMaxHp(((Integer)aTempData.get(8)).intValue());
/* 107 */           add8 = "(血量+ " + ((Integer)aTempData.get(8)).intValue() + ")";
/*     */         } 
/* 109 */         if (((Integer)aTempData.get(9)).intValue() != 0) {
/* 110 */           pc.addMaxMp(((Integer)aTempData.get(9)).intValue());
/* 111 */           add9 = "(魔量+ " + ((Integer)aTempData.get(9)).intValue() + ")";
/*     */         } 
/* 113 */         if (((Integer)aTempData.get(10)).intValue() != 0) {
/* 114 */           pc.addother_ReductionDmg(((Integer)aTempData.get(10)).intValue());
/* 115 */           add10 = "(減傷+ " + ((Integer)aTempData.get(10)).intValue() + ")";
/*     */         } 
/* 117 */         if (((Integer)aTempData.get(11)).intValue() != 0) {
/* 118 */           pc.addMr(((Integer)aTempData.get(11)).intValue());
/* 119 */           add11 = "(抗魔+ " + ((Integer)aTempData.get(11)).intValue() + ")";
/*     */         } 
/* 121 */         if (((Integer)aTempData.get(12)).intValue() != 0) {
/* 122 */           pc.addAc(((Integer)aTempData.get(12)).intValue());
/* 123 */           add12 = "(防禦+ " + ((Integer)aTempData.get(12)).intValue() + ")";
/*     */         } 
/* 125 */         if (((Integer)aTempData.get(13)).intValue() != 0) {
/* 126 */           pc.addDmgup(((Integer)aTempData.get(13)).intValue());
/* 127 */           add13 = "(近戰攻擊+ " + ((Integer)aTempData.get(13)).intValue() + ")";
/*     */         } 
/* 129 */         if (((Integer)aTempData.get(14)).intValue() != 0) {
/* 130 */           pc.addBowDmgup(((Integer)aTempData.get(14)).intValue());
/* 131 */           add14 = "(遠戰攻擊+ " + ((Integer)aTempData.get(14)).intValue() + ")";
/*     */         } 
/* 133 */         pc.sendPackets((ServerBasePacket)new S_SystemMessage("裝備總加成[:" + pc.getArmorCount1() + "]賦予下方能力:"));
/* 134 */         pc.sendPackets((ServerBasePacket)new S_SystemMessage(String.valueOf(String.valueOf(add1)) + add2 + add3 + add4 + add5 + add6 + add7 + add8 + 
/* 135 */               add9 + add10 + add11 + add12 + add13 + add14));
/*     */         
/* 137 */         pc.sendPackets((ServerBasePacket)new S_SPMR(pc));
/* 138 */         pc.sendPackets((ServerBasePacket)new S_OwnCharStatus(pc));
/* 139 */         pc.sendPackets((ServerBasePacket)new S_OwnCharStatus2(pc));
/* 140 */         pc.sendPackets((ServerBasePacket)new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
/* 141 */         pc.sendPackets((ServerBasePacket)new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
/*     */       } 
/* 143 */       i++;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void forIntensifyArmor1(L1PcInstance pc, L1ItemInstance item) {
/* 148 */     ArrayList<Object> aTempData = null;
/* 149 */     if (!BUILD_DATA) {
/* 150 */       BUILD_DATA = true;
/* 151 */       getData();
/*     */     } 
/* 153 */     int i = 0;
/* 154 */     while (i < aData.size()) {
/* 155 */       aTempData = aData.get(i);
/* 156 */       if (pc.getArmorCount1() >= ((Integer)aTempData.get(0)).intValue() && 
/* 157 */         pc.getArmorCount1() <= ((Integer)aTempData.get(15)).intValue()) {
/* 158 */         if (((Integer)aTempData.get(1)).intValue() != 0) {
/* 159 */           pc.addStr(-((Integer)aTempData.get(1)).intValue());
/*     */         }
/* 161 */         if (((Integer)aTempData.get(2)).intValue() != 0) {
/* 162 */           pc.addDex(-((Integer)aTempData.get(2)).intValue());
/*     */         }
/* 164 */         if (((Integer)aTempData.get(3)).intValue() != 0) {
/* 165 */           pc.addInt(-((Integer)aTempData.get(3)).intValue());
/*     */         }
/* 167 */         if (((Integer)aTempData.get(4)).intValue() != 0) {
/* 168 */           pc.addCon(-((Integer)aTempData.get(4)).intValue());
/*     */         }
/* 170 */         if (((Integer)aTempData.get(5)).intValue() != 0) {
/* 171 */           pc.addWis(-((Integer)aTempData.get(5)).intValue());
/*     */         }
/* 173 */         if (((Integer)aTempData.get(6)).intValue() != 0) {
/* 174 */           pc.addCha(-((Integer)aTempData.get(6)).intValue());
/*     */         }
/* 176 */         if (((Integer)aTempData.get(7)).intValue() != 0) {
/* 177 */           pc.addSp(-((Integer)aTempData.get(7)).intValue());
/*     */         }
/* 179 */         if (((Integer)aTempData.get(8)).intValue() != 0) {
/* 180 */           pc.addMaxHp(-((Integer)aTempData.get(8)).intValue());
/*     */         }
/* 182 */         if (((Integer)aTempData.get(9)).intValue() != 0) {
/* 183 */           pc.addMaxMp(-((Integer)aTempData.get(9)).intValue());
/*     */         }
/* 185 */         if (((Integer)aTempData.get(10)).intValue() != 0) {
/* 186 */           pc.addother_ReductionDmg(-((Integer)aTempData.get(10)).intValue());
/*     */         }
/* 188 */         if (((Integer)aTempData.get(11)).intValue() != 0) {
/* 189 */           pc.addMr(-((Integer)aTempData.get(11)).intValue());
/*     */         }
/* 191 */         if (((Integer)aTempData.get(12)).intValue() != 0) {
/* 192 */           pc.addAc(-((Integer)aTempData.get(12)).intValue());
/*     */         }
/* 194 */         if (((Integer)aTempData.get(13)).intValue() != 0) {
/* 195 */           pc.addDmgup(-((Integer)aTempData.get(13)).intValue());
/*     */         }
/* 197 */         if (((Integer)aTempData.get(14)).intValue() != 0) {
/* 198 */           pc.addBowDmgup(-((Integer)aTempData.get(14)).intValue());
/*     */         }
/* 200 */         pc.sendPackets((ServerBasePacket)new S_SPMR(pc));
/* 201 */         pc.sendPackets((ServerBasePacket)new S_OwnCharStatus(pc));
/* 202 */         pc.sendPackets((ServerBasePacket)new S_OwnCharStatus2(pc));
/* 203 */         pc.sendPackets((ServerBasePacket)new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
/* 204 */         pc.sendPackets((ServerBasePacket)new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
/*     */       } 
/* 206 */       i++;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void getData() {
/* 211 */     Connection conn = null;
/* 212 */     PreparedStatement pstmt = null;
/* 213 */     ResultSet rs = null;
/*     */     
/* 215 */     try { conn = DatabaseFactory.get().getConnection();
/* 216 */       pstmt = conn.prepareStatement("SELECT * FROM w_裝備總加成能力");
/* 217 */       rs = pstmt.executeQuery();
/* 218 */       ArrayList<Object> aReturn = null;
/* 219 */       if (rs != null) {
/* 220 */         while (rs.next()) {
/* 221 */           aReturn = new ArrayList();
/* 222 */           aReturn.add(0, new Integer(rs.getInt("EnchantLevel_min")));
/* 223 */           aReturn.add(1, new Integer(rs.getInt("str")));
/* 224 */           aReturn.add(2, new Integer(rs.getInt("dex")));
/* 225 */           aReturn.add(3, new Integer(rs.getInt("int")));
/* 226 */           aReturn.add(4, new Integer(rs.getInt("con")));
/* 227 */           aReturn.add(5, new Integer(rs.getInt("wis")));
/* 228 */           aReturn.add(6, new Integer(rs.getInt("cha")));
/* 229 */           aReturn.add(7, new Integer(rs.getInt("sp")));
/* 230 */           aReturn.add(8, new Integer(rs.getInt("hp")));
/* 231 */           aReturn.add(9, new Integer(rs.getInt("mp")));
/* 232 */           aReturn.add(10, new Integer(rs.getInt("ReductionDmg")));
/* 233 */           aReturn.add(11, new Integer(rs.getInt("Mr")));
/* 234 */           aReturn.add(12, new Integer(rs.getInt("Ac")));
/* 235 */           aReturn.add(13, new Integer(rs.getInt("attack")));
/* 236 */           aReturn.add(14, new Integer(rs.getInt("bowattack")));
/* 237 */           aReturn.add(15, new Integer(rs.getInt("EnchantLevel_max")));
/* 238 */           aData.add(aReturn);
/*     */         } 
/*     */       } }
/* 241 */     catch (SQLException sQLException) {  }
/*     */     finally
/* 243 */     { SQLUtil.close(rs);
/* 244 */       SQLUtil.close(pstmt);
/* 245 */       SQLUtil.close(conn); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\En_count.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */