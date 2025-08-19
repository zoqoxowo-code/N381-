/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NetBarSet
/*    */   extends EventExecutor
/*    */ {
/* 15 */   public static final Map<String, Integer> EXIPLIST = new HashMap<>();
/* 16 */   private static final Log _log = LogFactory.getLog(NetBarSet.class);
/*    */ 
/*    */   
/*    */   public static EventExecutor get() {
/* 20 */     return new NetBarSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/* 25 */     String[] set = event.get_eventother().split(",");
/* 26 */     String[] set2 = event.get_eventother2().split("#");
/* 27 */     if (set.length == set2.length) {
/* 28 */       int i = 0;
/* 29 */       while (i < set.length) {
/* 30 */         String ipstring = set[i];
/* 31 */         EXIPLIST.put(ipstring, Integer.valueOf(set2[i]));
/* 32 */         i++;
/*    */       } 
/*    */     } else {
/* 35 */       _log.warn("網咖IP登入設定錯誤");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\NetBarSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */