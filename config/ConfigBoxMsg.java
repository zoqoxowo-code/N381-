/*    */ package com.lineage.config;
/*    */ import com.lineage.server.serverpackets.S_PacketBoxGree;
/*    */ import com.lineage.server.serverpackets.ServerBasePacket;
/*    */ import com.lineage.server.world.World;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.LineNumberReader;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Random;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class ConfigBoxMsg {
/* 17 */   private static final Log _log = LogFactory.getLog(ConfigBoxMsg.class);
/* 18 */   private static final Map<Integer, String> _box_msg_list = new HashMap<>();
/* 19 */   private static final Random _random = new Random();
/*    */   public static boolean ISMSG = false;
/*    */   private static final String _box_text = "./config/box_desc.txt";
/*    */   
/*    */   public static void load() throws ConfigErrorException {
/*    */     try {
/* 25 */       InputStream is = new FileInputStream(new File("./config/box_desc.txt"));
/* 26 */       InputStreamReader isr = new InputStreamReader(is, "utf-8");
/* 27 */       LineNumberReader lnr = new LineNumberReader(isr);
/* 28 */       boolean isWhile = false;
/* 29 */       int i = 1;
/* 30 */       String desc = null;
/* 31 */       while ((desc = lnr.readLine()) != null) {
/* 32 */         if (!isWhile) {
/* 33 */           isWhile = true; continue;
/* 34 */         }  if (desc.trim().length() != 0 && !desc.startsWith("#")) {
/* 35 */           if (desc.startsWith("ISMSG")) {
/* 36 */             desc = desc.replaceAll(" ", "");
/* 37 */             ISMSG = Boolean.parseBoolean(desc.substring(6)); continue;
/*    */           } 
/* 39 */           _box_msg_list.put(new Integer(i++), desc);
/*    */         } 
/*    */       } 
/*    */       
/* 43 */       is.close();
/* 44 */       isr.close();
/* 45 */       lnr.close();
/* 46 */     } catch (Exception e) {
/* 47 */       _log.error("設置檔案遺失: ./config/box_desc.txt");
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void msg(String string1, String string2) {
/*    */     try {
/* 53 */       String msg = _box_msg_list.get(Integer.valueOf(_random.nextInt(_box_msg_list.size()) + 1));
/* 54 */       if (msg != null) {
/* 55 */         String out = String.format(msg, new Object[] { string1, string2 });
/* 56 */         World.get().broadcastPacketToAll((ServerBasePacket)new S_PacketBoxGree(2, out));
/*    */       } 
/* 58 */     } catch (Exception e) {
/* 59 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\config\ConfigBoxMsg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */