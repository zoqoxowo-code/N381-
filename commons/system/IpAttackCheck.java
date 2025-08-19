/*    */ package com.lineage.commons.system;
/*    */ 
/*    */ import com.lineage.config.ConfigIpCheck;
/*    */ import com.lineage.echo.ClientExecutor;
/*    */ import com.lineage.server.datatables.lock.IpReading;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IpAttackCheck
/*    */ {
/*    */   public static final Map<ClientExecutor, String> SOCKETLIST;
/* 21 */   private static final Log _log = LogFactory.getLog(IpAttackCheck.class); private static final HashMap<String, IpTemp> _ipList; static {
/* 22 */     SOCKETLIST = new ConcurrentHashMap<>();
/* 23 */     _ipList = new HashMap<>();
/*    */   }
/*    */   private static IpAttackCheck _instance;
/*    */   private IpAttackCheck() {
/* 27 */     _ipList.clear();
/*    */   }
/*    */   
/*    */   public static IpAttackCheck get() {
/* 31 */     if (_instance == null) {
/* 32 */       _instance = new IpAttackCheck();
/*    */     }
/* 34 */     return _instance;
/*    */   }
/*    */   
/*    */   public boolean check(String key) {
/*    */     try {
/* 39 */       long nowtime = System.currentTimeMillis();
/* 40 */       IpTemp value = _ipList.get(key);
/* 41 */       if (value == null) {
/* 42 */         value = new IpTemp(null);
/* 43 */         value._time = nowtime;
/* 44 */         value._count = 1;
/* 45 */         _ipList.put(key, value);
/* 46 */         _log.warn("初始連接次數: " + value._count);
/* 47 */       } else if (nowtime - value._time <= ConfigIpCheck.TIMEMILLIS) {
/* 48 */         IpTemp ipTemp = value;
/* 49 */         ipTemp._count++;
/* 50 */         _log.warn("IP: " + key + " 連接間隔不正常 錯誤次數為: " + value._count);
/* 51 */         if (value._count >= ConfigIpCheck.COUNT) {
/* 52 */           _log.warn("連接間隔不正常 錯誤次數為: " + value._count + " 封鎖IP: " + key);
/* 53 */           kick(key);
/* 54 */           if (ConfigIpCheck.SETDB) {
/* 55 */             IpReading.get().add(key, "IP類似攻擊行為");
/* 56 */             System.out.println("IP類似攻擊行為" + key);
/* 57 */             return false;
/*    */           } 
/*    */         } 
/*    */       } else {
/* 61 */         value._time = nowtime;
/* 62 */         value._count = 1;
/*    */       } 
/* 64 */     } catch (Exception e) {
/* 65 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/* 67 */     return true;
/*    */   }
/*    */   
/*    */   private void kick(String key) {
/*    */     try {
/* 72 */       Iterator<ClientExecutor> iterator = SOCKETLIST.keySet().iterator();
/* 73 */       while (iterator.hasNext()) {
/* 74 */         ClientExecutor socket = iterator.next();
/* 75 */         String ip = SOCKETLIST.get(socket);
/* 76 */         if (ip != null && ip.equals(key)) {
/* 77 */           socket.close();
/*    */         }
/*    */       } 
/* 80 */     } catch (Exception e) {
/* 81 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */   
/*    */   private class IpTemp {
/*    */     long _time;
/*    */     int _count;
/*    */     
/*    */     private IpTemp() {}
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\commons\system\IpAttackCheck.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */