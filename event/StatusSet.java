/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import java.util.ArrayList;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StatusSet
/*    */   extends EventExecutor
/*    */ {
/* 19 */   private static final Log _log = LogFactory.getLog(StatusSet.class);
/* 20 */   public static final ArrayList<Integer> SKILLLIST = new ArrayList<>();
/*    */   
/*    */   public static EventExecutor get() {
/* 23 */     return new StatusSet();
/*    */   }
/*    */   
/*    */   public void execute(L1Event event) {
/* 27 */     String[] set = event.get_eventother().split(","); byte b; int i; String[] arrayOfString1;
/* 28 */     for (i = (arrayOfString1 = set).length, b = 0; b < i; ) { String string = arrayOfString1[b];
/* 29 */       SKILLLIST.add(Integer.valueOf(Integer.parseInt(string)));
/*    */       b++; }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\StatusSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */