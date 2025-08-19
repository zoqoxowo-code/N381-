/*    */ package com.add;
/*    */ 
/*    */ public class dr_name_message {
/*    */   private int _id;
/*    */   private String _message;
/*    */   
/*    */   public dr_name_message(int id, String message) {
/*  8 */     this._id = id;
/*  9 */     this._message = message;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 13 */     return this._id;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 17 */     return this._message;
/*    */   }
/*    */   
/*    */   public static String ShowMessage(int id) {
/* 21 */     dr_name_message System_Message = dr_nametable.getInstance().getTemplate(id);
/* 22 */     if (System_Message == null) {
/* 23 */       return "";
/*    */     }
/* 25 */     String Message = System_Message.getMessage();
/* 26 */     return Message;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\dr_name_message.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */