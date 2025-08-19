/*     */ package com.lineage.data.event;
/*     */ 
/*     */ import com.lineage.config.ConfigOther;
/*     */ import com.lineage.data.executor.EventExecutor;
/*     */ import com.lineage.server.datatables.ItemTable;
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.serverpackets.S_ServerMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.templates.L1Event;
/*     */ import com.lineage.server.thread.GeneralThreadPool;
/*     */ import com.lineage.server.utils.PerformanceTimer;
/*     */ import com.lineage.server.world.World;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OnlineGiftSet
/*     */   extends EventExecutor
/*     */ {
/*  32 */   private static final Log _log = LogFactory.getLog(OnlineGiftSet.class);
/*  33 */   private static int _time = 0;
/*  34 */   private static final Map<Integer, ArrayList<GetItemData>> _giftList = new HashMap<>();
/*  35 */   private static final Map<L1PcInstance, Integer> _getMap = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EventExecutor get() {
/*  42 */     return new OnlineGiftSet();
/*     */   }
/*     */   
/*     */   public static void add(L1PcInstance tgpc) {
/*  46 */     if (_time == 0) {
/*     */       return;
/*     */     }
/*  49 */     if (_getMap.get(tgpc) == null) {
/*  50 */       _getMap.put(tgpc, Integer.valueOf(_time));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void remove(L1PcInstance tgpc) {
/*  55 */     if (_time == 0) {
/*     */       return;
/*     */     }
/*  58 */     _getMap.remove(tgpc);
/*     */   }
/*     */   
/*     */   private static void getitem(L1PcInstance tgpc) {
/*     */     try {
/*  63 */       if (check(tgpc)) {
/*  64 */         if (tgpc.getLevel() < ConfigOther.giftset) {
/*     */           return;
/*     */         }
/*  67 */         ArrayList<GetItemData> value = null;
/*  68 */         if (tgpc.isPrivateShop()) {
/*  69 */           value = _giftList.get(new Integer(1));
/*  70 */         } else if (tgpc.isFishing()) {
/*  71 */           value = _giftList.get(new Integer(2));
/*  72 */         } else if (tgpc.getMapId() != 5300) {
/*  73 */           value = _giftList.get(new Integer(3));
/*     */         } 
/*  75 */         if (value == null) {
/*     */           return;
/*     */         }
/*  78 */         Iterator<GetItemData> iterator = value.iterator();
/*  79 */         while (iterator.hasNext()) {
/*  80 */           GetItemData iteminfo = iterator.next();
/*  81 */           if (iteminfo == null) {
/*     */             continue;
/*     */           }
/*  84 */           L1ItemInstance item = ItemTable.get().createItem(iteminfo._getItemId);
/*  85 */           item.setCount(iteminfo._getAmount);
/*  86 */           if (item == null || tgpc.getInventory().checkAddItem(item, 1L) != 0) {
/*     */             continue;
/*     */           }
/*  89 */           tgpc.getInventory().storeItem(item);
/*  90 */           tgpc.sendPackets((ServerBasePacket)new S_ServerMessage("獲得連線獎勵：" + item.getLogName()));
/*     */         } 
/*     */       } 
/*  93 */     } catch (Exception e) {
/*  94 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean check(L1PcInstance tgpc) {
/*     */     try {
/* 100 */       if (tgpc == null) {
/* 101 */         return false;
/*     */       }
/* 103 */       if (tgpc.getOnlineStatus() == 0) {
/* 104 */         return false;
/*     */       }
/* 106 */       if (tgpc.getNetConnection() == null) {
/* 107 */         return false;
/*     */       }
/* 109 */     } catch (Exception e) {
/* 110 */       _log.error(e.getLocalizedMessage(), e);
/* 111 */       return false;
/*     */     } 
/* 113 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void execute(L1Event event) {
/* 118 */     PerformanceTimer timer = new PerformanceTimer();
/* 119 */     boolean isError = false;
/*     */     
/* 121 */     try { String[] set = event.get_eventother().split(",");
/*     */       try {
/* 123 */         _time = Integer.parseInt(set[0]);
/* 124 */         if (_time <= 0) {
/* 125 */           _log.error("設定給予獎勵的時間(分鐘)異常 - 將不啟用本項設置");
/* 126 */           isError = true;
/*     */           return;
/*     */         } 
/* 129 */       } catch (Exception e2) {
/* 130 */         _log.error("設定給予獎勵的時間(分鐘)異常 - 將不啟用本項設置");
/* 131 */         isError = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         return;
/*     */       }  }
/* 180 */     catch (Exception e)
/* 181 */     { _log.error(e.getLocalizedMessage(), e);
/*     */       return; }
/*     */     finally
/* 184 */     { if (!isError)
/* 185 */       { GetItemTimer getItemTimer = new GetItemTimer(null);
/* 186 */         getItemTimer.start();
/* 187 */         _log.info("載入給予獎勵物品: " + _giftList.size() + "(" + timer.get() + "ms)"); }
/*     */       else
/* 189 */       { _time = 0;
/* 190 */         _giftList.clear(); }  }  if (!isError) { GetItemTimer getItemTimer = new GetItemTimer(null); getItemTimer.start(); _log.info("載入給予獎勵物品: " + _giftList.size() + "(" + timer.get() + "ms)"); } else { _time = 0; _giftList.clear(); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   private class GetItemData
/*     */   {
/*     */     private GetItemData() {}
/*     */ 
/*     */     
/* 200 */     public int _getItemId = 40308;
/* 201 */     public int _getAmount = 1; }
/*     */   
/*     */   private class GetItemTimer extends TimerTask {
/*     */     private ScheduledFuture<?> _timer;
/*     */     
/*     */     private GetItemTimer() {}
/*     */     
/*     */     public void start() {
/* 209 */       int timeMillis = 60000;
/* 210 */       this._timer = GeneralThreadPool.get().scheduleAtFixedRate(this, 60000L, 60000L);
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/*     */       try {
/* 216 */         if (!OnlineGiftSet._getMap.isEmpty()) {
/* 217 */           Iterator<L1PcInstance> iterator = OnlineGiftSet._getMap.keySet().iterator();
/* 218 */           while (iterator.hasNext()) {
/* 219 */             L1PcInstance tgpc = iterator.next();
/* 220 */             Thread.sleep(1L);
/* 221 */             if (World.get().getPlayer(tgpc.getName()) == null) {
/* 222 */               OnlineGiftSet._getMap.remove(tgpc); continue;
/*     */             } 
/* 224 */             Integer time = (Integer)OnlineGiftSet._getMap.get(tgpc);
/* 225 */             if (time == null) {
/*     */               continue;
/*     */             }
/* 228 */             time = Integer.valueOf(time.intValue() - 1);
/* 229 */             if (time.intValue() <= 0) {
/* 230 */               OnlineGiftSet.getitem(tgpc);
/* 231 */               OnlineGiftSet._getMap.put(tgpc, Integer.valueOf(OnlineGiftSet._time)); continue;
/*     */             } 
/* 233 */             OnlineGiftSet._getMap.put(tgpc, time);
/*     */           }
/*     */         
/*     */         }
/*     */       
/* 238 */       } catch (Exception e) {
/* 239 */         OnlineGiftSet._log.error("在線獎勵清單時間軸異常重啟", e);
/* 240 */         GeneralThreadPool.get().cancel(this._timer, false);
/* 241 */         GetItemTimer getItemTimer = new GetItemTimer();
/* 242 */         getItemTimer.start();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\OnlineGiftSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */