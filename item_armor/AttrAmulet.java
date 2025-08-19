/*    */ package com.lineage.data.item_armor;
/*    */ 
/*    */ import com.lineage.data.executor.ItemExecutor;
/*    */ import com.lineage.server.model.Instance.L1ItemInstance;
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AttrAmulet
/*    */   extends ItemExecutor
/*    */ {
/* 16 */   private static final Log _log = LogFactory.getLog(AttrAmulet.class);
/*    */   private int _AttrAmulet_rnd;
/*    */   
/*    */   public static ItemExecutor get() {
/* 20 */     return new AttrAmulet();
/*    */   }
/*    */   private int _AttrAmulet_dmg; private int _AttrAmulet_gfxid;
/*    */   
/*    */   public void execute(int[] data, L1PcInstance pc, L1ItemInstance item) {
/*    */     try {
/* 26 */       if (item == null) {
/*    */         return;
/*    */       }
/* 29 */       if (pc == null) {
/*    */         return;
/*    */       }
/* 32 */       switch (data[0]) {
/*    */         case 0:
/* 34 */           pc.set_AttrAmulet(0, 0, 0);
/*    */           break;
/*    */         
/*    */         case 1:
/* 38 */           pc.set_AttrAmulet(this._AttrAmulet_rnd, this._AttrAmulet_dmg, this._AttrAmulet_gfxid);
/*    */           break;
/*    */       } 
/*    */     
/* 42 */     } catch (Exception e) {
/* 43 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void set_set(String[] set) {
/*    */     try {
/* 50 */       this._AttrAmulet_rnd = Integer.parseInt(set[1]);
/* 51 */     } catch (Exception exception) {}
/*    */     
/*    */     try {
/* 54 */       this._AttrAmulet_dmg = Integer.parseInt(set[2]);
/* 55 */     } catch (Exception exception) {}
/*    */     
/*    */     try {
/* 58 */       this._AttrAmulet_gfxid = Integer.parseInt(set[3]);
/* 59 */     } catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\AttrAmulet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */