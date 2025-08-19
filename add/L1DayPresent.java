/*     */ package com.add;
/*     */ 
/*     */ import com.lineage.DatabaseFactory;
/*     */ import com.lineage.server.datatables.ItemTable;
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.serverpackets.S_ServerMessage;
/*     */ import com.lineage.server.serverpackets.S_SystemMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.utils.PerformanceTimer;
/*     */ import com.lineage.server.world.World;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.StringTokenizer;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class L1DayPresent
/*     */ {
/*  31 */   private static final Log _log = LogFactory.getLog(L1DayPresent.class);
/*  32 */   private static final Map<Integer, ArrayList<L1DayPresent>> _buddyMap = new HashMap<>();
/*  33 */   private static ArrayList array = new ArrayList();
/*     */   private static boolean NO_MORE_GET_DATA15d = false;
/*     */   public static final String TOKEN = ",";
/*     */   
/*     */   public static void forTimeMessage(L1PcInstance pc) {
/*  38 */     ArrayList<Integer> aTempData = null;
/*  39 */     if (!NO_MORE_GET_DATA15d) {
/*  40 */       NO_MORE_GET_DATA15d = true;
/*  41 */       getData15d();
/*     */     } 
/*  43 */     int i = 0;
/*  44 */     while (i < array.size()) {
/*  45 */       aTempData = array.get(i);
/*  46 */       Calendar nowTime = Calendar.getInstance();
/*  47 */       if (((Integer)aTempData.get(0)).intValue() != 0 && ((Integer)aTempData.get(1)).intValue() != 0) {
/*  48 */         if (nowTime.get(2) + 1 == ((Integer)aTempData.get(0)).intValue() && 
/*  49 */           nowTime.get(5) == ((Integer)aTempData.get(1)).intValue()) {
/*  50 */           if (((Integer)aTempData.get(3)).intValue() != 0 && 
/*  51 */             pc.getLevel() < ((Integer)aTempData.get(3)).intValue()) {
/*     */             return;
/*     */           }
/*  54 */           if (((Integer)aTempData.get(2)).intValue() != 0) {
/*  55 */             byte class_id = 0;
/*  56 */             if (pc.isCrown()) {
/*  57 */               class_id = 1;
/*  58 */             } else if (pc.isKnight()) {
/*  59 */               class_id = 2;
/*  60 */             } else if (pc.isWizard()) {
/*  61 */               class_id = 3;
/*  62 */             } else if (pc.isElf()) {
/*  63 */               class_id = 4;
/*  64 */             } else if (pc.isDarkelf()) {
/*  65 */               class_id = 5;
/*  66 */             } else if (pc.isDragonKnight()) {
/*  67 */               class_id = 6;
/*  68 */             } else if (pc.isIllusionist()) {
/*  69 */               class_id = 7;
/*     */             } 
/*  71 */             if (((Integer)aTempData.get(2)).intValue() != class_id) {
/*     */               return;
/*     */             }
/*     */           } 
/*  75 */           if ((int[])aTempData.get(5) != null && (int[])aTempData.get(6) != null) {
/*  76 */             int[] giveMaterials = (int[])aTempData.get(5);
/*  77 */             int[] giveCounts = (int[])aTempData.get(6);
/*  78 */             int l = 0;
/*  79 */             while (l < giveMaterials.length) {
/*  80 */               L1ItemInstance item = ItemTable.get().createItem(giveMaterials[l]);
/*  81 */               if (item.isStackable()) {
/*  82 */                 item.setCount(giveCounts[l]);
/*     */               } else {
/*  84 */                 item.setCount(1L);
/*     */               } 
/*  86 */               if (item != null) {
/*  87 */                 if (pc.getInventory().checkAddItem(item, giveCounts[l]) == 0) {
/*  88 */                   pc.getInventory().storeItem(item);
/*     */                 } else {
/*  90 */                   World.get().getInventory(pc.getX(), pc.getY(), pc.getMapId()).storeItem(item);
/*     */                 } 
/*  92 */                 pc.sendPackets((ServerBasePacket)new S_ServerMessage(403, item.getLogName()));
/*     */               } 
/*  94 */               l++;
/*     */             } 
/*     */           } 
/*  97 */           if ((String)aTempData.get(4) != null) {
/*  98 */             pc.sendPackets((ServerBasePacket)new S_SystemMessage((String)aTempData.get(4)));
/*     */           }
/*     */         }
/*     */       
/* 102 */       } else if (((Integer)aTempData.get(0)).intValue() == 0 && (
/* 103 */         (Integer)aTempData.get(1)).intValue() == 0) {
/* 104 */         if (((Integer)aTempData.get(3)).intValue() != 0 && 
/* 105 */           pc.getLevel() < ((Integer)aTempData.get(3)).intValue()) {
/*     */           return;
/*     */         }
/* 108 */         if (((Integer)aTempData.get(2)).intValue() != 0) {
/* 109 */           byte class_id = 0;
/* 110 */           if (pc.isCrown()) {
/* 111 */             class_id = 1;
/* 112 */           } else if (pc.isKnight()) {
/* 113 */             class_id = 2;
/* 114 */           } else if (pc.isWizard()) {
/* 115 */             class_id = 3;
/* 116 */           } else if (pc.isElf()) {
/* 117 */             class_id = 4;
/* 118 */           } else if (pc.isDarkelf()) {
/* 119 */             class_id = 5;
/* 120 */           } else if (pc.isDragonKnight()) {
/* 121 */             class_id = 6;
/* 122 */           } else if (pc.isIllusionist()) {
/* 123 */             class_id = 7;
/*     */           } 
/* 125 */           if (((Integer)aTempData.get(2)).intValue() != class_id) {
/*     */             return;
/*     */           }
/*     */         } 
/* 129 */         if ((int[])aTempData.get(5) != null && (int[])aTempData.get(6) != null) {
/* 130 */           int[] giveMaterials = (int[])aTempData.get(5);
/* 131 */           int[] giveCounts = (int[])aTempData.get(6);
/* 132 */           int l = 0;
/* 133 */           while (l < giveMaterials.length) {
/* 134 */             L1ItemInstance item = ItemTable.get().createItem(giveMaterials[l]);
/* 135 */             if (item.isStackable()) {
/* 136 */               item.setCount(giveCounts[l]);
/*     */             } else {
/* 138 */               item.setCount(1L);
/*     */             } 
/* 140 */             if (item != null) {
/* 141 */               if (pc.getInventory().checkAddItem(item, giveCounts[l]) == 0) {
/* 142 */                 pc.getInventory().storeItem(item);
/*     */               } else {
/* 144 */                 World.get().getInventory(pc.getX(), pc.getY(), pc.getMapId()).storeItem(item);
/*     */               } 
/* 146 */               pc.sendPackets((ServerBasePacket)new S_ServerMessage(403, item.getLogName()));
/*     */             } 
/* 148 */             l++;
/*     */           } 
/*     */         } 
/* 151 */         if ((String)aTempData.get(4) != null) {
/* 152 */           pc.sendPackets((ServerBasePacket)new S_SystemMessage((String)aTempData.get(4)));
/*     */         }
/*     */       } 
/*     */       
/* 156 */       i++;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void getData15d() {
/* 161 */     PerformanceTimer timer = new PerformanceTimer();
/* 162 */     Connection conn = null;
/*     */     try {
/* 164 */       conn = DatabaseFactory.get().getConnection();
/* 165 */       Statement stat = conn.createStatement();
/* 166 */       ResultSet rset = stat.executeQuery("SELECT * FROM w_節日活動");
/* 167 */       ArrayList<Integer> arraylist = null;
/* 168 */       if (rset != null) {
/* 169 */         while (rset.next()) {
/* 170 */           arraylist = new ArrayList();
/* 171 */           arraylist.add(0, new Integer(rset.getInt("month")));
/* 172 */           arraylist.add(1, new Integer(rset.getInt("day")));
/* 173 */           arraylist.add(2, new Integer(rset.getInt("checkClass")));
/* 174 */           arraylist.add(3, new Integer(rset.getInt("level")));
/* 175 */           arraylist.add(4, rset.getString("message"));
/* 176 */           if (rset.getString("new_item") != null && !rset.getString("new_item").equals("") && 
/* 177 */             !rset.getString("new_item").equals("0")) {
/* 178 */             arraylist.add(5, getArray(rset.getString("new_item"), ",", 1));
/*     */           } else {
/* 180 */             arraylist.add(5, null);
/*     */           } 
/* 182 */           if (rset.getString("new_item_counts") != null && !rset.getString("new_item_counts").equals("") && 
/* 183 */             !rset.getString("new_item_counts").equals("0")) {
/* 184 */             arraylist.add(6, getArray(rset.getString("new_item_counts"), ",", 1));
/*     */           } else {
/* 186 */             arraylist.add(6, null);
/*     */           } 
/* 188 */           array.add(arraylist);
/*     */         } 
/*     */       }
/* 191 */       if (conn != null && !conn.isClosed()) {
/* 192 */         conn.close();
/*     */       }
/* 194 */     } catch (Exception exception) {}
/*     */     
/* 196 */     _log.info("載入節日系統自動送禮: " + _buddyMap.size() + "(" + timer.get() + "ms)");
/*     */   }
/*     */   
/*     */   private static Object getArray(String s, String sToken, int iType) {
/* 200 */     StringTokenizer st = new StringTokenizer(s, sToken);
/* 201 */     int iSize = st.countTokens();
/* 202 */     String sTemp = null;
/* 203 */     if (iType == 1) {
/* 204 */       int[] iReturn = new int[iSize];
/* 205 */       int i = 0;
/* 206 */       while (i < iSize) {
/* 207 */         sTemp = st.nextToken();
/* 208 */         iReturn[i] = Integer.parseInt(sTemp);
/* 209 */         i++;
/*     */       } 
/* 211 */       return iReturn;
/*     */     } 
/* 213 */     if (iType == 2) {
/* 214 */       String[] sReturn = new String[iSize];
/* 215 */       int i = 0;
/* 216 */       while (i < iSize) {
/* 217 */         sTemp = st.nextToken();
/* 218 */         sReturn[i] = sTemp;
/* 219 */         i++;
/*     */       } 
/* 221 */       return sReturn;
/*     */     } 
/* 223 */     if (iType == 3) {
/* 224 */       String sReturn2 = null;
/* 225 */       int i = 0;
/* 226 */       while (i < iSize) {
/* 227 */         sTemp = sReturn2 = st.nextToken();
/* 228 */         i++;
/*     */       } 
/* 230 */       return sReturn2;
/*     */     } 
/* 232 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\L1DayPresent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */