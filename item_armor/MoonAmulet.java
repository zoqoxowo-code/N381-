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
/*    */ 
/*    */ public class MoonAmulet
/*    */   extends ItemExecutor
/*    */ {
/* 17 */   private static final Log _log = LogFactory.getLog(MoonAmulet.class); private int _MoonAmulet_rnd;
/*    */   private int _MoonAmulet_dmg_min;
/*    */   
/*    */   public static ItemExecutor get() {
/* 21 */     return new MoonAmulet();
/*    */   }
/*    */   private int _MoonAmulet_dmg_max; private int _MoonAmulet_gfxid;
/*    */   
/*    */   public void execute(int[] data, L1PcInstance pc, L1ItemInstance item) {
/*    */     try {
/* 27 */       if (item == null) {
/*    */         return;
/*    */       }
/* 30 */       if (pc == null) {
/*    */         return;
/*    */       }
/* 33 */       switch (data[0]) {
/*    */         case 0:
/* 35 */           pc.set_MoonAmulet(0, 0, 0, 0);
/*    */           break;
/*    */         
/*    */         case 1:
/* 39 */           pc.set_MoonAmulet(this._MoonAmulet_rnd, this._MoonAmulet_dmg_min, this._MoonAmulet_dmg_max, 
/* 40 */               this._MoonAmulet_gfxid);
/*    */           break;
/*    */       } 
/*    */     
/* 44 */     } catch (Exception e) {
/* 45 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void set_set(String[] set) {
/*    */     try {
/* 52 */       this._MoonAmulet_rnd = Integer.parseInt(set[1]);
/* 53 */     } catch (Exception exception) {}
/*    */     
/*    */     try {
/* 56 */       this._MoonAmulet_dmg_min = Integer.parseInt(set[2]);
/* 57 */     } catch (Exception exception) {}
/*    */     
/*    */     try {
/* 60 */       this._MoonAmulet_dmg_max = Integer.parseInt(set[3]);
/* 61 */     } catch (Exception exception) {}
/*    */     
/*    */     try {
/* 64 */       this._MoonAmulet_gfxid = Integer.parseInt(set[4]);
/* 65 */     } catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\MoonAmulet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */