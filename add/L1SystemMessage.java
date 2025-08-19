/*    */ package com.add;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ 
/*    */ public class L1SystemMessage {
/*    */   private int _id;
/*    */   private String _message;
/*    */   private Calendar _resetmaptime;
/*    */   
/*    */   public L1SystemMessage(int id, String message, Calendar resetmaptime) {
/* 11 */     this._id = id;
/* 12 */     this._message = message;
/* 13 */     this._resetmaptime = resetmaptime;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 17 */     return this._id;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 21 */     return this._message;
/*    */   }
/*    */   
/*    */   public Calendar get_resetmaptime() {
/* 25 */     return this._resetmaptime;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\L1SystemMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */