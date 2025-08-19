/*    */ package com.add;
/*    */ 
/*    */ import java.sql.Timestamp;
/*    */ 
/*    */ public final class L1ItemTimeadd {
/*    */   private final Timestamp _remain_time;
/*    */   
/*    */   public L1ItemTimeadd(Timestamp next_reset_time) {
/*  9 */     this._remain_time = next_reset_time;
/*    */   }
/*    */   
/*    */   public Timestamp get_remain_time() {
/* 13 */     return this._remain_time;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\L1ItemTimeadd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */