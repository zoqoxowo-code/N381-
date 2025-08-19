/*    */ package com.lineage.config;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.LineNumberReader;
/*    */ import java.util.ArrayList;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class ConfigBad {
/* 13 */   private static final Log _log = LogFactory.getLog(ConfigBad.class);
/* 14 */   public static final ArrayList<String> BAD_TEXT_LIST = new ArrayList<>();
/*    */   private static final String _bad_text = "./data/badtext.txt";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/*    */     try {
/* 19 */       InputStream is = new FileInputStream(new File("./data/badtext.txt"));
/* 20 */       InputStreamReader isr = new InputStreamReader(is, "utf-8");
/* 21 */       LineNumberReader lnr = new LineNumberReader(isr);
/* 22 */       boolean isWhile = false;
/* 23 */       String desc = null;
/* 24 */       while ((desc = lnr.readLine()) != null) {
/* 25 */         if (!isWhile) {
/* 26 */           isWhile = true; continue;
/* 27 */         }  if (desc.trim().length() != 0 && !desc.startsWith("#") && !BAD_TEXT_LIST.contains(desc)) {
/* 28 */           BAD_TEXT_LIST.add(desc);
/*    */         }
/*    */       } 
/* 31 */       is.close();
/* 32 */       isr.close();
/* 33 */       lnr.close();
/* 34 */     } catch (Exception e) {
/* 35 */       _log.error("設置檔案遺失: ./data/badtext.txt");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigBad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */