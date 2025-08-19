/*     */ package com.lineage.data.event;
/*     */ 
/*     */ import com.lineage.data.EventClass;
/*     */ import com.lineage.data.cmd.CreateNewItem;
/*     */ import com.lineage.data.executor.EventExecutor;
/*     */ import com.lineage.server.datatables.ItemTable;
/*     */ import com.lineage.server.datatables.RecordTable;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import com.lineage.server.serverpackets.S_SystemMessage;
/*     */ import com.lineage.server.serverpackets.ServerBasePacket;
/*     */ import com.lineage.server.templates.L1Event;
/*     */ import com.lineage.server.thread.GeneralThreadPool;
/*     */ import com.lineage.server.world.World;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
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
/*     */ public class RandomGiftSet
/*     */   extends EventExecutor
/*     */ {
/*  35 */   private static final Log _log = LogFactory.getLog(RandomGiftSet.class);
/*  36 */   private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
/*     */   
/*     */   public static int TIME_DELAY;
/*     */   public static int BROADCAST_TIME_DELAY;
/*     */   public static int TOTAL_COUNT;
/*     */   
/*     */   public static EventExecutor get() {
/*  43 */     return new RandomGiftSet();
/*     */   }
/*     */   public static int GIFT_ID; public static int GIFT_COUNT; public static int Level;
/*     */   
/*     */   public void execute(L1Event event) {
/*     */     try {
/*  49 */       String[] set = event.get_eventother().split(",");
/*  50 */       TIME_DELAY = Integer.parseInt(set[0]);
/*  51 */       BROADCAST_TIME_DELAY = Integer.parseInt(set[1]);
/*  52 */       TOTAL_COUNT = Integer.parseInt(set[2]);
/*  53 */       GIFT_ID = Integer.parseInt(set[3]);
/*  54 */       GIFT_COUNT = Integer.parseInt(set[4]);
/*  55 */       Level = Integer.parseInt(set[5]);
/*  56 */       long now_time = System.currentTimeMillis();
/*  57 */       if (event.get_next_time() == null) {
/*  58 */         event.set_next_time(new Timestamp(now_time + (TIME_DELAY * 60 * 1000)));
/*  59 */         EventClass.get().updateEventNextTime(event.get_eventid(), event.get_next_time());
/*     */       } else {
/*  61 */         while (event.get_next_time().getTime() < now_time) {
/*  62 */           event.set_next_time(
/*  63 */               new Timestamp(event.get_next_time().getTime() + (TIME_DELAY * 60 * 1000)));
/*     */         }
/*  65 */         EventClass.get().updateEventNextTime(event.get_eventid(), event.get_next_time());
/*     */       } 
/*  67 */       GetItemTimer getItemTimer = new GetItemTimer(event, null, null);
/*  68 */       getItemTimer.start();
/*  69 */     } catch (Exception e) {
/*  70 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private class GetItemTimer extends TimerTask {
/*     */     private ScheduledFuture<?> _timer;
/*     */     private L1Event _event;
/*     */     private List<L1PcInstance> _allPc;
/*     */     
/*     */     private GetItemTimer(L1Event event) {
/*  80 */       this._event = event;
/*     */     }
/*     */     
/*     */     private GetItemTimer(L1Event event, List<L1PcInstance> allPc) {
/*  84 */       this._event = event;
/*  85 */       this._allPc = allPc;
/*     */     }
/*     */     
/*     */     private void start() {
/*  89 */       int timeMillis = 60000;
/*  90 */       this._timer = GeneralThreadPool.get().scheduleAtFixedRate(this, 60000L, 60000L);
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/*     */       try {
/*  96 */         if (this._allPc != null) {
/*  97 */           Iterator<L1PcInstance> iterator = this._allPc.iterator();
/*  98 */           while (iterator.hasNext()) {
/*  99 */             L1PcInstance pc = iterator.next();
/* 100 */             if (pc.getLevel() >= RandomGiftSet.Level && !pc.isGm()) {
/* 101 */               Thread.sleep(5000L);
/* 102 */               World.get()
/* 103 */                 .broadcastPacketToAll((ServerBasePacket)new S_SystemMessage("\\aE恭喜玩家[" + pc.getName() + "]獲得" + 
/* 104 */                     ItemTable.get().getTemplate(RandomGiftSet.GIFT_ID).getNameId() + "x" + 
/* 105 */                     RandomGiftSet.GIFT_COUNT));
/* 106 */               RecordTable.get().rangiveitem(pc.getName());
/* 107 */               CreateNewItem.createNewItem(pc, RandomGiftSet.GIFT_ID, RandomGiftSet.GIFT_COUNT);
/*     */             } 
/*     */           } 
/* 110 */           this._allPc = null;
/*     */         } 
/* 112 */         long now_time = System.currentTimeMillis();
/* 113 */         if (this._event.get_next_time().getTime() < now_time) {
/* 114 */           this._allPc = World.get().getRandomPlayers(RandomGiftSet.TOTAL_COUNT);
/* 115 */           if (this._allPc == null || this._allPc.size() < RandomGiftSet.TOTAL_COUNT) {
/*     */             return;
/*     */           }
/* 118 */           this._event.set_next_time(new Timestamp(
/* 119 */                 this._event.get_next_time().getTime() + (RandomGiftSet.TIME_DELAY * 60 * 1000)));
/* 120 */           EventClass.get().updateEventNextTime(this._event.get_eventid(), this._event.get_next_time());
/* 121 */           World.get().broadcastPacketToAll(
/* 122 */               (ServerBasePacket)new S_SystemMessage("\\aD即將隨機抽獎，將隨機抽出線上玩家獲得獎勵"));
/* 123 */         } else if ((this._event.get_next_time().getTime() - now_time) / 
/* 124 */           60000L <= RandomGiftSet.BROADCAST_TIME_DELAY && (
/* 125 */           this._event.get_next_time().getTime() - now_time) % 3600000L == 0L) {
/* 126 */           World.get().broadcastPacketToAll((ServerBasePacket)new S_SystemMessage("\\aD下次送禮抽獎時間為[" + RandomGiftSet
/* 127 */                 .sdf.format(this._event.get_next_time()) + "]\n隨機抽出線上玩家獲得獎勵"));
/*     */         } 
/* 129 */       } catch (Exception e) {
/* 130 */         RandomGiftSet._log.error("隨機送禮系統時間軸異常重啟", e);
/* 131 */         GeneralThreadPool.get().cancel(this._timer, false);
/* 132 */         GetItemTimer getItemTimer = new GetItemTimer(this._event, this._allPc);
/* 133 */         getItemTimer.start();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\RandomGiftSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */