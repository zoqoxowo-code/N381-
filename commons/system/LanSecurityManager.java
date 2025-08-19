/*     */ package com.lineage.commons.system;
/*     */ 
/*     */ import com.lineage.config.ConfigIpCheck;
/*     */ import com.lineage.server.datatables.lock.IpReading;
/*     */ import com.lineage.server.thread.GeneralThreadPool;
/*     */ import java.io.IOException;
/*     */ import java.security.Permission;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
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
/*     */ public class LanSecurityManager
/*     */   extends SecurityManager
/*     */ {
/*  25 */   private static final Log _log = LogFactory.getLog(LanSecurityManager.class);
/*  26 */   public static final Map<String, Integer> BANIPPACK = new ConcurrentHashMap<>();
/*  27 */   public static final Map<String, Integer> BANIPMAP = new HashMap<>();
/*  28 */   public static final Map<String, Integer> BANNAMEMAP = new HashMap<>();
/*  29 */   public static final Map<String, Integer> ONEIPMAP = new ConcurrentHashMap<>();
/*  30 */   public static final Map<String, Long> ONETIMEMILLISMAP = new ConcurrentHashMap<>();
/*  31 */   public static final Map<String, Integer> Loginer = new HashMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkAccept(String host, int port) {
/*  36 */     IpReading.get().checktime(host);
/*  37 */     if (ConfigIpCheck.IPCHECKPACK) {
/*  38 */       if (BANIPMAP.containsKey(host)) {
/*  39 */         throw new SecurityException();
/*     */       }
/*  41 */       if (BANIPPACK.containsKey(host)) {
/*  42 */         throw new SecurityException();
/*     */       }
/*     */     } else {
/*  45 */       if (BANIPMAP.containsKey(host)) {
/*  46 */         throw new SecurityException();
/*     */       }
/*  48 */       if (ONEIPMAP.containsKey(host)) {
/*  49 */         throw new SecurityException();
/*     */       }
/*  51 */       if (ONETIMEMILLISMAP.containsKey(host)) {
/*  52 */         throw new SecurityException();
/*     */       }
/*  54 */       if (ConfigIpCheck.ONETIMEMILLIS != 0) {
/*  55 */         ONETIMEMILLISMAP.put(host, Long.valueOf(System.currentTimeMillis()));
/*     */       }
/*  57 */       if (ConfigIpCheck.ISONEIP) {
/*  58 */         ONEIPMAP.put(host, Integer.valueOf(port));
/*     */       }
/*  60 */       if (ConfigIpCheck.IPCHECK && !IpAttackCheck.get().check(host)) {
/*  61 */         throw new SecurityException();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkAccess(Thread t) {}
/*     */ 
/*     */   
/*     */   public void checkPermission(Permission perm) {}
/*     */ 
/*     */   
/*     */   public void stsrt_cmd() throws IOException {
/*  75 */     RemoveIp removeIp = new RemoveIp(ConfigIpCheck.ONETIMEMILLIS);
/*  76 */     GeneralThreadPool.get().execute(removeIp);
/*     */   }
/*     */   
/*     */   public void stsrt_cmd_tmp() throws IOException {
/*  80 */     RemoveTmpIp removeIp = new RemoveTmpIp(null);
/*  81 */     GeneralThreadPool.get().execute(removeIp);
/*     */   }
/*     */   
/*     */   private class RemoveTmpIp
/*     */     implements Runnable {
/*     */     public void run() {
/*     */       try {
/*     */         while (true) {
/*  89 */           Thread.sleep(1000L);
/*  90 */           if (!LanSecurityManager.BANIPPACK.isEmpty()) {
/*  91 */             Iterator<String> iterator = LanSecurityManager.BANIPPACK.keySet().iterator();
/*  92 */             while (iterator.hasNext()) {
/*  93 */               String ip = iterator.next();
/*  94 */               int time = ((Integer)LanSecurityManager.BANIPPACK.get(ip)).intValue() - 1;
/*  95 */               if (time <= 0) {
/*  96 */                 LanSecurityManager.BANIPPACK.remove(ip); continue;
/*     */               } 
/*  98 */               LanSecurityManager.BANIPPACK.put(ip, Integer.valueOf(time));
/*     */             }
/*     */           
/*     */           } 
/*     */         } 
/* 103 */       } catch (Exception e) {
/* 104 */         LanSecurityManager._log.error(e.getLocalizedMessage(), e);
/*     */         return;
/*     */       } 
/*     */     }
/*     */     
/*     */     private RemoveTmpIp() {} }
/*     */   
/*     */   private class RemoveIp implements Runnable { public int _time;
/*     */     
/*     */     public RemoveIp(int oNETIMEMILLIS) {
/* 114 */       this._time = 60000;
/* 115 */       this._time = oNETIMEMILLIS;
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/*     */       try {
/*     */         while (true) {
/* 122 */           Thread.sleep(10000L);
/* 123 */           if (!LanSecurityManager.ONETIMEMILLISMAP.isEmpty()) {
/* 124 */             Iterator<String> iterator = LanSecurityManager.ONETIMEMILLISMAP.keySet().iterator();
/* 125 */             while (iterator.hasNext()) {
/* 126 */               String ip = iterator.next();
/* 127 */               long time = ((Long)LanSecurityManager.ONETIMEMILLISMAP.get(ip)).longValue();
/* 128 */               if (System.currentTimeMillis() - time >= this._time) {
/* 129 */                 LanSecurityManager.ONETIMEMILLISMAP.remove(ip);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/* 134 */       } catch (Exception e) {
/* 135 */         LanSecurityManager._log.error(e.getLocalizedMessage(), e);
/*     */         return;
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\commons\system\LanSecurityManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */