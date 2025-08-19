/*    */ package com.lineage.data.executor;
/*    */ 
/*    */ import com.lineage.server.model.Instance.L1ItemInstance;
/*    */ import com.lineage.server.model.Instance.L1PcInstance;
/*    */ import com.lineage.server.utils.BinaryOutputStream;
/*    */ 
/*    */ public abstract class ItemExecutor {
/*    */   private String[] as;
/*    */   
/*    */   public abstract void execute(int[] paramArrayOfint, L1PcInstance paramL1PcInstance, L1ItemInstance paramL1ItemInstance);
/*    */   
/*    */   public String[] get_set() {
/* 13 */     return this.as;
/*    */   }
/*    */   
/*    */   public void set_set(String[] set) {
/* 17 */     this.as = set;
/*    */   }
/*    */   
/*    */   public BinaryOutputStream itemStatus(L1ItemInstance item) {
/* 21 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\executor\ItemExecutor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */