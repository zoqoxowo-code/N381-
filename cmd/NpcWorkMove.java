/*    */ package com.lineage.data.cmd;
/*    */ 
/*    */ import com.lineage.server.model.Instance.L1NpcInstance;
/*    */ import com.lineage.server.model.L1Character;
/*    */ import com.lineage.server.serverpackets.S_MoveCharPacket;
/*    */ import com.lineage.server.serverpackets.ServerBasePacket;
/*    */ import com.lineage.server.types.Point;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NpcWorkMove
/*    */ {
/* 18 */   private static final Log _log = LogFactory.getLog(NpcWorkMove.class);
/* 19 */   private static final byte[] HEADING_TABLE_X = new byte[] { 0, 1, 1, 1, -1, -1, -1 };
/* 20 */   private static final byte[] HEADING_TABLE_Y = new byte[] { -1, -1, 1, 1, 1, -1 };
/*    */   private L1NpcInstance _npc;
/*    */   
/*    */   public NpcWorkMove(L1NpcInstance npc) {
/* 24 */     this._npc = npc;
/*    */   }
/*    */   
/*    */   public boolean actionStart(Point point) {
/* 28 */     int x = point.getX();
/* 29 */     int y = point.getY();
/*    */     try {
/* 31 */       int dir = this._npc.targetDirection(x, y);
/* 32 */       setDirectionMove(dir);
/* 33 */       if (this._npc.getLocation().getTileLineDistance(point) == 0) {
/* 34 */         return false;
/*    */       }
/* 36 */     } catch (Exception e) {
/* 37 */       _log.error(e.getLocalizedMessage(), e);
/*    */     } 
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   private void setDirectionMove(int heading) {
/* 43 */     int locx = this._npc.getX();
/* 44 */     int locy = this._npc.getY();
/* 45 */     locx += HEADING_TABLE_X[heading];
/* 46 */     locy += HEADING_TABLE_Y[heading];
/* 47 */     this._npc.setHeading(heading);
/* 48 */     this._npc.setX(locx);
/* 49 */     this._npc.setY(locy);
/* 50 */     this._npc.broadcastPacketAll((ServerBasePacket)new S_MoveCharPacket((L1Character)this._npc));
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\cmd\NpcWorkMove.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */