package com.lineage.data.item_armor.set;

import com.lineage.server.model.Instance.L1PcInstance;

public interface ArmorSetEffect {
  void giveEffect(L1PcInstance paramL1PcInstance);
  
  void cancelEffect(L1PcInstance paramL1PcInstance);
  
  int get_mode();
}


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\item_armor\set\ArmorSetEffect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */