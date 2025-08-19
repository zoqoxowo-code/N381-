/*    */ package com.lineage.config;
/*    */ 
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class ConfigErrorException extends Exception {
/*  7 */   private static final Log _log = LogFactory.getLog(ConfigErrorException.class);
/*    */   
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public ConfigErrorException() {}
/*    */   
/*    */   public ConfigErrorException(String string) {
/* 14 */     _log.error(string);
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigErrorException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */