/*    */ package com.lineage.data.event;
/*    */ 
/*    */ import com.lineage.data.executor.EventExecutor;
/*    */ import com.lineage.server.templates.L1Event;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class SkillTeacherSet
/*    */   extends EventExecutor
/*    */ {
/* 12 */   public static final Map<Integer, Integer> RESKILLLIST = new HashMap<>();
/*    */ 
/*    */   
/*    */   public static EventExecutor get() {
/* 16 */     return new SkillTeacherSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(L1Event event) {
/* 21 */     String[] set = event.get_eventother().split(",");
/*    */     String[] array;
/* 23 */     int length = (array = set).length;
/* 24 */     int i = 0;
/* 25 */     while (i < length) {
/* 26 */       String string = array[i];
/* 27 */       RESKILLLIST.put(Integer.valueOf(Integer.parseInt(string) - 1), 
/* 28 */           Integer.valueOf(Integer.parseInt(string)));
/* 29 */       i++;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\event\SkillTeacherSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */