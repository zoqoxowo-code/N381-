/*    */ package com.enums;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum MapLimitType
/*    */ {
/*  8 */   LIMIT_USE(Integer.valueOf(1), "限制使用"),
/*  9 */   CAN_USE(Integer.valueOf(2), "只能使用");
/*    */   
/*    */   private Integer code;
/*    */   
/*    */   private String desc;
/*    */   
/*    */   MapLimitType(Integer code, String desc) {
/* 16 */     this.code = code;
/* 17 */     this.desc = desc;
/*    */   }
/*    */   
/*    */   public Integer getCode() {
/* 21 */     return this.code;
/*    */   }
/*    */   
/*    */   public String getDesc() {
/* 25 */     return this.desc;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\enums\MapLimitType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */