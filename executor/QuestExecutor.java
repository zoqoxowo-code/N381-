package com.lineage.data.executor;

import com.lineage.server.model.Instance.L1PcInstance;
import com.lineage.server.templates.L1Quest;

public abstract class QuestExecutor {
  public abstract void execute(L1Quest paramL1Quest);
  
  public abstract void startQuest(L1PcInstance paramL1PcInstance);
  
  public abstract void endQuest(L1PcInstance paramL1PcInstance);
  
  public abstract void showQuest(L1PcInstance paramL1PcInstance);
  
  public abstract void stopQuest(L1PcInstance paramL1PcInstance);
}


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\executor\QuestExecutor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */