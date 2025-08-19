/*     */ package com.lineage.data.event;
/*     */ 
/*     */ import com.lineage.data.executor.EventExecutor;
/*     */ import com.lineage.server.datatables.lock.AccountBankReading;
/*     */ import com.lineage.server.templates.L1Bank;
/*     */ import com.lineage.server.templates.L1Event;
/*     */ import com.lineage.server.thread.GeneralThreadPool;
/*     */ import com.lineage.server.utils.RangeLong;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
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
/*     */ public class BankSet
/*     */   extends EventExecutor
/*     */ {
/*  25 */   private static final Log _log = LogFactory.getLog(BankSet.class); public static long BANKMAX;
/*  26 */   public static int BANK_TIME = 1; public static long BANK_INTEREST_OVER; public static int BANK_ITEMID;
/*  27 */   public static double BANK_INTEREST = 0.01D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EventExecutor get() {
/*  34 */     return new BankSet();
/*     */   }
/*     */ 
/*     */   
/*     */   public void execute(L1Event event) {
/*     */     try {
/*  40 */       String[] set = event.get_eventother().split(",");
/*     */       try {
/*  42 */         BANKMAX = Long.parseLong(set[0]);
/*  43 */       } catch (Exception e2) {
/*  44 */         BANKMAX = 1900000000L;
/*  45 */         _log.error("未設定銀行儲蓄上限(使用預設19億)");
/*     */       } 
/*     */       try {
/*  48 */         BANK_INTEREST_OVER = Long.parseLong(set[1]);
/*  49 */       } catch (Exception e2) {
/*  50 */         BANK_INTEREST_OVER = 2000000000L;
/*  51 */         _log.error("未設定利息及現存款總額(使用預設20億)");
/*     */       } 
/*     */       try {
/*  54 */         BANK_ITEMID = Integer.parseInt(set[2]);
/*  55 */       } catch (Exception e2) {
/*  56 */         BANK_ITEMID = 40308;
/*  57 */         _log.error("未設定存款物品編號(使用預設40308)");
/*     */       } 
/*     */       try {
/*  60 */         BANK_TIME = Integer.parseInt(set[3]);
/*  61 */       } catch (Exception e2) {
/*  62 */         BANK_TIME = 60;
/*  63 */         _log.error("未設銀行計算利息時間(使用預設60分鐘)");
/*     */       } 
/*     */       try {
/*  66 */         BANK_INTEREST = Double.parseDouble(set[4]);
/*  67 */       } catch (Exception e2) {
/*  68 */         BANK_INTEREST = 0.01D;
/*  69 */         _log.error("未設銀行利息比率(使用預設0.01%)");
/*     */       } 
/*  71 */       _log.info("銀行設置\n 帳戶儲蓄上限: " + RangeLong.scount(BANKMAX) + " \n 存款總額限制: " + 
/*  72 */           RangeLong.scount(BANK_INTEREST_OVER) + "\n 存款物品編號: " + 
/*  73 */           RangeLong.scount(BANK_INTEREST_OVER) + "\n 利息計算時間: " + BANK_TIME + "\n 利息比率: " + 
/*  74 */           BANK_INTEREST);
/*  75 */       AccountBankReading.get().load();
/*  76 */       BankTimer bankTime = new BankTimer(null);
/*  77 */       bankTime.start();
/*  78 */     } catch (Exception e) {
/*  79 */       _log.error(e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */   private class BankTimer extends TimerTask { private ScheduledFuture<?> _timer;
/*     */     
/*     */     private BankTimer() {}
/*     */     
/*     */     public void start() {
/*  87 */       int timeMillis = BankSet.BANK_TIME * 60 * 1000;
/*  88 */       this._timer = GeneralThreadPool.get().scheduleAtFixedRate(this, timeMillis, timeMillis);
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/*     */       try {
/*  94 */         Map<String, L1Bank> map = AccountBankReading.get().map();
/*  95 */         if (map.isEmpty()) {
/*     */           return;
/*     */         }
/*  98 */         Iterator<String> iterator = map.keySet().iterator();
/*  99 */         while (iterator.hasNext()) {
/* 100 */           String key = iterator.next();
/* 101 */           L1Bank bank = map.get(key);
/* 102 */           if (bank.isLan() && !bank.isEmpty()) {
/* 103 */             long nwecount = bank.get_adena_count() + 
/* 104 */               Math.round(bank.get_adena_count() * BankSet.BANK_INTEREST);
/* 105 */             bank.set_adena_count(nwecount);
/* 106 */             AccountBankReading.get().updateAdena(bank.get_account_name(), nwecount);
/* 107 */             Thread.sleep(5L);
/*     */           } 
/*     */         } 
/* 110 */       } catch (Exception e) {
/* 111 */         BankSet._log.error("銀行管理員時間軸異常重啟", e);
/* 112 */         GeneralThreadPool.get().cancel(this._timer, false);
/* 113 */         BankTimer bankTime = new BankTimer();
/* 114 */         bankTime.start();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\BankSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */