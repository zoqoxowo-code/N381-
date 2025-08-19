/*      */ package com.add;
/*      */ 
/*      */ import com.lineage.config.ConfigAi;
/*      */ import com.lineage.config.ConfigGuaji;
/*      */ import com.lineage.data.event.AutoBot;
/*      */ import com.lineage.server.datatables.RecordTable;
/*      */ import com.lineage.server.datatables.SkillsTable;
/*      */ import com.lineage.server.datatables.lock.CharSkillReading;
/*      */ import com.lineage.server.model.Instance.L1PcInstance;
/*      */ import com.lineage.server.serverpackets.S_CloseList;
/*      */ import com.lineage.server.serverpackets.S_NPCTalkReturn;
/*      */ import com.lineage.server.serverpackets.S_ServerMessage;
/*      */ import com.lineage.server.serverpackets.S_SystemMessage;
/*      */ import com.lineage.server.serverpackets.ServerBasePacket;
/*      */ import com.lineage.server.templates.L1Skills;
/*      */ import java.util.Calendar;
/*      */ import java.util.Iterator;
/*      */ import java.util.logging.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class AutoAttackUpdate
/*      */ {
/*      */   private static final int[] _autoskill_buff;
/*      */   private static final int[] _autoskill_attack;
/*   27 */   private static final Logger _log = Logger.getLogger(AutoAttackUpdate.class.getName()); static {
/*   28 */     _autoskill_buff = new int[] { 114, 115, 117, 88, 91, 3, 14, 26, 42, 48, 54, 68, 79, 129, 137, 138, 147, 148, 
/*   29 */         155, 163, 171, 149, 156, 166, 151, 159, 168, 160, 98, 99, 102, 106, 109, 110, 111, 105, 181, 191, 201, 
/*   30 */         206, 211, 216 };
/*   31 */     _autoskill_attack = new int[] { 87, 4, 6, 7, 10, 15, 16, 22, 25, 28, 34, 38, 45, 46, 53, 59, 65, 70, 74, 77, 
/*   32 */         132, 108, 184, 187, 192, 194, 218 };
/*      */   }
/*      */   private static AutoAttackUpdate _instance;
/*      */   public static AutoAttackUpdate getInstance() {
/*   36 */     if (_instance == null) {
/*   37 */       _instance = new AutoAttackUpdate();
/*      */     }
/*   39 */     return _instance;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean PcCommand(L1PcInstance _pc, String cmd) {
/*   44 */     if (!AutoBot.START)
/*      */     {
/*   46 */       return false;
/*      */     }
/*      */ 
/*      */     
/*   50 */     if (cmd.equalsIgnoreCase("go_guajiok")) {
/*   51 */       Calendar date = Calendar.getInstance();
/*   52 */       int nowHour = date.get(11);
/*   53 */       if (ConfigGuaji.checktimeguaji) {
/*   54 */         int[] GUAJI_TIME = ConfigGuaji.GUAJI_ITEM;
/*      */         
/*   56 */         int array[], length = (array = GUAJI_TIME).length;
/*   57 */         int i = 0;
/*   58 */         while (i < length) {
/*   59 */           int guajitimme = array[i];
/*   60 */           if (nowHour == guajitimme) {
/*   61 */             _pc.sendPackets((ServerBasePacket)new S_ServerMessage("此時間未開放使用掛機"));
/*   62 */             return false;
/*      */           } 
/*   64 */           i++;
/*      */         } 
/*      */       } 
/*   67 */       if (ConfigGuaji.Guaji_action && !_pc.getMap().isGuaji()) {
/*   68 */         _pc.sendPackets((ServerBasePacket)new S_ServerMessage("此地圖無法掛機.."));
/*   69 */         return false;
/*      */       } 
/*   71 */       if (_pc.isActived()) {
/*   72 */         _pc.setActived(false);
/*   73 */         _pc.sendPackets((ServerBasePacket)new S_ServerMessage(" 自動狩獵已停止。"));
/*   74 */         L1PcUnlock.Pc_Unlock(_pc);
/*   75 */         if (_pc.get_fwgj() > 0) {
/*   76 */           _pc.setlslocx(0);
/*   77 */           _pc.setlslocy(0);
/*   78 */           _pc.set_fwgj(0);
/*      */         } 
/*   80 */         _pc.killSkillEffectTimer(8853);
/*   81 */         _pc.killSkillEffectTimer(6930);
/*   82 */         _pc.killSkillEffectTimer(6931);
/*   83 */         _pc.killSkillEffectTimer(6932);
/*   84 */         if (ConfigAi.longntimeai_3) {
/*   85 */           _pc.setSkillEffect(6930, 300000);
/*      */         }
/*   87 */         return false;
/*      */       } 
/*   89 */       if (!_pc.isActived()) {
/*   90 */         if (_pc.hasSkillEffect(99666)) {
/*   91 */           _pc.sendPackets((ServerBasePacket)new S_ServerMessage("該道具使用延遲中請稍候再執行"));
/*   92 */           return false;
/*      */         } 
/*   94 */         L1PcUnlock.Pc_Unlock(_pc);
/*   95 */         _pc.sendPackets((ServerBasePacket)new S_ServerMessage("自動狩獵已開始。"));
/*   96 */         _pc.sendPackets((ServerBasePacket)new S_ServerMessage("請勿在自動狩獵點擊物品.消失物品一概不負責"));
/*   97 */         RecordTable.get().guaji(_pc.getName(), "道具啟動");
/*   98 */         _pc.killSkillEffectTimer(6930);
/*   99 */         _pc.killSkillEffectTimer(6931);
/*  100 */         _pc.killSkillEffectTimer(6932);
/*  101 */         if (ConfigAi.longntimeai_3) {
/*  102 */           _pc.setSkillEffect(6930, 300000);
/*      */         }
/*  104 */         if (_pc.get_fwgj() == 0) {
/*  105 */           _pc.setSkillEffect(8853, 60000);
/*      */         }
/*  107 */         _pc.startAI();
/*  108 */         _pc.setSkillEffect(99666, 15000);
/*      */       } 
/*  110 */     } else if (cmd.equalsIgnoreCase("Au_30")) {
/*  111 */       if (_pc.isActived()) {
/*  112 */         _pc.sendPackets((ServerBasePacket)new S_ServerMessage("內掛中,無法進行此操作。"));
/*  113 */         return false;
/*      */       } 
/*  115 */       _pc.setlslocx(_pc.getX());
/*  116 */       _pc.setlslocy(_pc.getY());
/*  117 */       _pc.setgo_guajitele(false);
/*  118 */       _pc.set_fwgj(_pc.get_fwgj() + 5);
/*  119 */       guaji(_pc);
/*  120 */     } else if (cmd.equalsIgnoreCase("Au_31")) {
/*  121 */       if (_pc.isActived()) {
/*  122 */         _pc.sendPackets((ServerBasePacket)new S_ServerMessage("內掛中,無法進行此操作。"));
/*  123 */         return false;
/*      */       } 
/*  125 */       _pc.setlslocx(_pc.getX());
/*  126 */       _pc.setlslocy(_pc.getY());
/*  127 */       _pc.setgo_guajitele(false);
/*  128 */       _pc.set_fwgj(_pc.get_fwgj() - 5);
/*  129 */       if (_pc.get_fwgj() <= 0) {
/*  130 */         _pc.set_fwgj(0);
/*  131 */         _pc.setlslocx(0);
/*  132 */         _pc.setlslocy(0);
/*      */       } 
/*  134 */       guaji(_pc);
/*  135 */     } else if (cmd.equalsIgnoreCase("Au_32")) {
/*  136 */       _pc.setitempotion(0);
/*  137 */       _pc.setitemitemid(0);
/*  138 */       _pc.setitemadena(0);
/*  139 */       _pc.setitempotion1(0);
/*  140 */       _pc.setitemitemid1(0);
/*  141 */       _pc.setitemadena1(0);
/*  142 */       _pc.setpotioncount(0);
/*  143 */       _pc.setpotioncount1(0);
/*  144 */       _pc.setitempotion2(0);
/*  145 */       _pc.setitemitemid2(0);
/*  146 */       _pc.setitemadena2(0);
/*  147 */       _pc.setpotioncount2(0);
/*  148 */       guaji_ai03(_pc);
/*  149 */     } else if (cmd.equalsIgnoreCase("Au_33")) {
/*  150 */       if (_pc.getitempotion() == 0) {
/*  151 */         _pc.setitempotion(1);
/*  152 */         _pc.setitemitemid(40010);
/*  153 */         _pc.setitemadena(ConfigGuaji.itemadena1);
/*  154 */       } else if (_pc.getitempotion() == 1) {
/*  155 */         _pc.setitempotion(2);
/*  156 */         _pc.setitemitemid(40011);
/*  157 */         _pc.setitemadena(ConfigGuaji.itemadena2);
/*  158 */       } else if (_pc.getitempotion() == 2) {
/*  159 */         _pc.setitempotion(3);
/*  160 */         _pc.setitemitemid(40012);
/*  161 */         _pc.setitemadena(ConfigGuaji.itemadena3);
/*  162 */       } else if (_pc.getitempotion() == 3) {
/*  163 */         _pc.setitempotion(4);
/*  164 */         _pc.setitemitemid(40019);
/*  165 */         _pc.setitemadena(ConfigGuaji.itemadena4);
/*  166 */       } else if (_pc.getitempotion() == 4) {
/*  167 */         _pc.setitempotion(5);
/*  168 */         _pc.setitemitemid(40020);
/*  169 */         _pc.setitemadena(ConfigGuaji.itemadena5);
/*  170 */       } else if (_pc.getitempotion() == 5) {
/*  171 */         _pc.setitempotion(6);
/*  172 */         _pc.setitemitemid(40021);
/*  173 */         _pc.setitemadena(ConfigGuaji.itemadena6);
/*  174 */       } else if (_pc.getitempotion() == 6) {
/*  175 */         _pc.setitempotion(7);
/*  176 */         _pc.setitemitemid(40022);
/*  177 */         _pc.setitemadena(ConfigGuaji.itemadena7);
/*  178 */       } else if (_pc.getitempotion() == 7) {
/*  179 */         _pc.setitempotion(8);
/*  180 */         _pc.setitemitemid(40023);
/*  181 */         _pc.setitemadena(ConfigGuaji.itemadena8);
/*  182 */       } else if (_pc.getitempotion() == 8) {
/*  183 */         _pc.setitempotion(9);
/*  184 */         _pc.setitemitemid(40024);
/*  185 */         _pc.setitemadena(ConfigGuaji.itemadena9);
/*  186 */       } else if (_pc.getitempotion() == 9) {
/*  187 */         _pc.setitempotion(0);
/*  188 */         _pc.setitemitemid(0);
/*  189 */         _pc.setitemadena(0);
/*      */       } 
/*  191 */       guaji_ai03(_pc);
/*  192 */     } else if (cmd.equalsIgnoreCase("Au_34")) {
/*  193 */       if (_pc.getitempotion1() == 0) {
/*  194 */         _pc.setitempotion1(1);
/*  195 */         _pc.setitemitemid1(40010);
/*  196 */         _pc.setitemadena1(ConfigGuaji.itemadena1);
/*  197 */       } else if (_pc.getitempotion1() == 1) {
/*  198 */         _pc.setitempotion1(2);
/*  199 */         _pc.setitemitemid1(40011);
/*  200 */         _pc.setitemadena1(ConfigGuaji.itemadena2);
/*  201 */       } else if (_pc.getitempotion1() == 2) {
/*  202 */         _pc.setitempotion1(3);
/*  203 */         _pc.setitemitemid1(40012);
/*  204 */         _pc.setitemadena1(ConfigGuaji.itemadena3);
/*  205 */       } else if (_pc.getitempotion1() == 3) {
/*  206 */         _pc.setitempotion1(4);
/*  207 */         _pc.setitemitemid1(40019);
/*  208 */         _pc.setitemadena1(ConfigGuaji.itemadena4);
/*  209 */       } else if (_pc.getitempotion1() == 4) {
/*  210 */         _pc.setitempotion1(5);
/*  211 */         _pc.setitemitemid1(40020);
/*  212 */         _pc.setitemadena1(ConfigGuaji.itemadena5);
/*  213 */       } else if (_pc.getitempotion1() == 5) {
/*  214 */         _pc.setitempotion1(6);
/*  215 */         _pc.setitemitemid1(40021);
/*  216 */         _pc.setitemadena1(ConfigGuaji.itemadena6);
/*  217 */       } else if (_pc.getitempotion1() == 6) {
/*  218 */         _pc.setitempotion1(7);
/*  219 */         _pc.setitemitemid1(40022);
/*  220 */         _pc.setitemadena1(ConfigGuaji.itemadena7);
/*  221 */       } else if (_pc.getitempotion1() == 7) {
/*  222 */         _pc.setitempotion1(8);
/*  223 */         _pc.setitemitemid1(40023);
/*  224 */         _pc.setitemadena1(ConfigGuaji.itemadena8);
/*  225 */       } else if (_pc.getitempotion1() == 8) {
/*  226 */         _pc.setitempotion1(9);
/*  227 */         _pc.setitemitemid1(40024);
/*  228 */         _pc.setitemadena1(ConfigGuaji.itemadena9);
/*  229 */       } else if (_pc.getitempotion1() == 9) {
/*  230 */         _pc.setitempotion1(0);
/*  231 */         _pc.setitemitemid1(0);
/*  232 */         _pc.setitemadena1(0);
/*      */       } 
/*  234 */       guaji_ai03(_pc);
/*  235 */     } else if (cmd.equalsIgnoreCase("Au_35")) {
/*  236 */       if (_pc.getitempotion2() == 0) {
/*  237 */         _pc.setitempotion2(1);
/*  238 */         _pc.setitemitemid2(40743);
/*  239 */         _pc.setitemadena2(ConfigGuaji.itemadena21);
/*  240 */       } else if (_pc.getitempotion2() == 1) {
/*  241 */         _pc.setitempotion2(2);
/*  242 */         _pc.setitemitemid2(40744);
/*  243 */         _pc.setitemadena2(ConfigGuaji.itemadena22);
/*  244 */       } else if (_pc.getitempotion2() == 2) {
/*  245 */         _pc.setitempotion2(0);
/*  246 */         _pc.setitemitemid2(0);
/*  247 */         _pc.setitemadena2(0);
/*      */       } 
/*  249 */       guaji_ai03(_pc);
/*  250 */     } else if (cmd.equalsIgnoreCase("Au_36")) {
/*  251 */       _pc.setpotioncount(_pc.getpotioncount() + 50);
/*  252 */       guaji_ai03(_pc);
/*  253 */     } else if (cmd.equalsIgnoreCase("Au_37")) {
/*  254 */       _pc.setpotioncount1(_pc.getpotioncount1() + 50);
/*  255 */       guaji_ai03(_pc);
/*  256 */     } else if (cmd.equalsIgnoreCase("Au_38")) {
/*  257 */       _pc.setpotioncount2(_pc.getpotioncount2() + 1000);
/*  258 */       guaji_ai03(_pc);
/*  259 */     } else if (cmd.equalsIgnoreCase("Au_29")) {
/*  260 */       if (_pc.getgo_guajitele()) {
/*  261 */         _pc.setgo_guajitele(false);
/*  262 */         _pc.get_other1().set_type24(0);
/*  263 */         guaji_ai04(_pc);
/*      */       } else {
/*  265 */         _pc.setgo_guajitele(true);
/*  266 */         _pc.get_other1().set_type24(1);
/*  267 */         if (_pc.get_fwgj() > 0) {
/*  268 */           _pc.setlslocx(0);
/*  269 */           _pc.setlslocy(0);
/*  270 */           _pc.set_fwgj(0);
/*      */         } 
/*  272 */         guaji_ai04(_pc);
/*      */       } 
/*  274 */     } else if (cmd.equalsIgnoreCase("Au_39")) {
/*  275 */       if (_pc.getgo_guajired()) {
/*  276 */         _pc.setgo_guajired(false);
/*  277 */         _pc.get_other1().set_type25(0);
/*  278 */         guaji_ai04(_pc);
/*      */       } else {
/*  280 */         _pc.setgo_guajired(true);
/*  281 */         _pc.get_other1().set_type25(1);
/*  282 */         guaji_ai04(_pc);
/*      */       } 
/*  284 */     } else if (cmd.equalsIgnoreCase("Au_40")) {
/*  285 */       _pc.setma1(_pc.getma1() + 5);
/*  286 */       guaji_ai01(_pc);
/*  287 */     } else if (cmd.equalsIgnoreCase("Au_41")) {
/*  288 */       _pc.setma1(_pc.getma1() - 5);
/*  289 */       guaji_ai01(_pc);
/*  290 */     } else if (cmd.equalsIgnoreCase("Au_1")) {
/*  291 */       if (_pc.IsAttackTeleport()) {
/*  292 */         _pc.setIsAttackTeleport(false);
/*  293 */         _pc.get_other1().set_type12(0);
/*      */       } else {
/*  295 */         _pc.setIsAttackTeleport(true);
/*  296 */         _pc.get_other1().set_type12(1);
/*      */       } 
/*  298 */       guaji_ai04(_pc);
/*  299 */     } else if (cmd.equalsIgnoreCase("Au_2")) {
/*  300 */       if (_pc.IsEnemyTeleport()) {
/*  301 */         _pc.setIsEnemyTeleport(false);
/*  302 */         _pc.get_other1().set_type13(0);
/*      */       } else {
/*  304 */         _pc.setIsEnemyTeleport(true);
/*  305 */         _pc.get_other1().set_type13(1);
/*      */       } 
/*  307 */       guaji_ai04(_pc);
/*  308 */     } else if (cmd.equalsIgnoreCase("Au_3")) {
/*  309 */       _pc.setKeyInEnemy(true);
/*  310 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU請輸入玩家名稱。"));
/*  311 */     } else if (cmd.equalsIgnoreCase("Au_4")) {
/*  312 */       _pc.setKeyOutEnemy(true);
/*  313 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU請輸入玩家名稱。"));
/*  314 */     } else if (cmd.equalsIgnoreCase("Au_5")) {
/*  315 */       EnemyList(_pc);
/*  316 */     } else if (cmd.equalsIgnoreCase("Au_6")) {
/*  317 */       NewAutoPractice.get().SearchAutoLog(_pc);
/*  318 */     } else if (cmd.equalsIgnoreCase("Au_14")) {
/*  319 */       CanSkillList(_pc, 2);
/*  320 */     } else if (cmd.equalsIgnoreCase("Au_15")) {
/*  321 */       SkillList(_pc, 2);
/*  322 */     } else if (cmd.equalsIgnoreCase("Au_16")) {
/*  323 */       if (_pc.IsAttackSkill()) {
/*  324 */         _pc.setAttackSkill(false);
/*  325 */         _pc.sendPackets((ServerBasePacket)new S_SystemMessage("取消登錄自動執行[攻擊]技能"));
/*      */       } else {
/*  327 */         _pc.setAttackSkill(true);
/*  328 */         _pc.sendPackets((ServerBasePacket)new S_SystemMessage("請手動施放一次欲新增的攻擊技能"));
/*      */       } 
/*  330 */     } else if (cmd.equalsIgnoreCase("Au_19")) {
/*  331 */       NewAutoPractice.get().ClearAutoLog(_pc.getId());
/*  332 */       _pc.sendPackets((ServerBasePacket)new S_CloseList(_pc.getId()));
/*  333 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU紀錄已刪除。"));
/*  334 */     } else if (cmd.equalsIgnoreCase("Au_21")) {
/*  335 */       _pc.clearAttackSkillList();
/*  336 */       if (_pc.get_other1().get_type46() > 0) {
/*  337 */         _pc.get_other1().set_type46(0);
/*      */       }
/*  339 */       if (_pc.get_other1().get_type47() > 0) {
/*  340 */         _pc.get_other1().set_type47(0);
/*      */       }
/*  342 */       if (_pc.get_other1().get_type48() > 0) {
/*  343 */         _pc.get_other1().set_type48(0);
/*      */       }
/*  345 */       if (_pc.get_other1().get_type49() > 0) {
/*  346 */         _pc.get_other1().set_type49(0);
/*      */       }
/*  348 */       if (_pc.get_other1().get_type50() > 0) {
/*  349 */         _pc.get_other1().set_type50(0);
/*      */       }
/*  351 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU紀錄已刪除。"));
/*  352 */     } else if (cmd.equalsIgnoreCase("Au_60")) {
/*  353 */       if (_pc.getmobatk()) {
/*  354 */         _pc.setmobatk(false);
/*      */       } else {
/*  356 */         _pc.setmobatk(true);
/*      */       } 
/*  358 */       guaji(_pc);
/*  359 */     } else if (cmd.equalsIgnoreCase("Au_43")) {
/*  360 */       if (!CharSkillReading.get().spellCheck(_pc.getId(), 51)) {
/*  361 */         _pc.sendPackets((ServerBasePacket)new S_SystemMessage("您尚未學習召喚術"));
/*  362 */         return false;
/*      */       } 
/*  364 */       if (_pc.getInventory().checkEquipped(20284) && _pc.getSummon_npcid() == null) {
/*  365 */         _pc.sendPackets((ServerBasePacket)new S_SystemMessage("攜帶召戒,請先設定要召喚的怪物"));
/*  366 */         return false;
/*      */       } 
/*  368 */       if (_pc.getchecksummid()) {
/*  369 */         _pc.setchecksummid(false);
/*      */       } else {
/*  371 */         _pc.setchecksummid(true);
/*      */       } 
/*  373 */       guaji_ai02(_pc);
/*  374 */     } else if (cmd.equalsIgnoreCase("Au_44")) {
/*  375 */       if (_pc.getsummon_skillid() == 1) {
/*  376 */         if (!CharSkillReading.get().spellCheck(_pc.getId(), 19)) {
/*  377 */           _pc.sendPackets((ServerBasePacket)new S_SystemMessage("您尚未學習中治"));
/*  378 */           return false;
/*      */         } 
/*  380 */         _pc.setsummon_skillid(19);
/*  381 */         _pc.setsummon_skillidmp(15);
/*  382 */       } else if (_pc.getsummon_skillid() == 19) {
/*  383 */         if (!CharSkillReading.get().spellCheck(_pc.getId(), 35)) {
/*  384 */           _pc.sendPackets((ServerBasePacket)new S_SystemMessage("您尚未學習高治"));
/*  385 */           return false;
/*      */         } 
/*  387 */         _pc.setsummon_skillid(35);
/*  388 */         _pc.setsummon_skillidmp(20);
/*  389 */       } else if (_pc.getsummon_skillid() == 35) {
/*  390 */         if (!CharSkillReading.get().spellCheck(_pc.getId(), 57)) {
/*  391 */           _pc.sendPackets((ServerBasePacket)new S_SystemMessage("您尚未學習全治"));
/*  392 */           return false;
/*      */         } 
/*  394 */         _pc.setsummon_skillid(57);
/*  395 */         _pc.setsummon_skillidmp(48);
/*  396 */       } else if (_pc.getsummon_skillid() == 57) {
/*  397 */         _pc.setsummon_skillid(1);
/*  398 */         _pc.setsummon_skillidmp(4);
/*  399 */       } else if (_pc.getsummon_skillid() == 0) {
/*  400 */         if (!CharSkillReading.get().spellCheck(_pc.getId(), 1)) {
/*  401 */           _pc.sendPackets((ServerBasePacket)new S_SystemMessage("您尚未學習初治"));
/*  402 */           return false;
/*      */         } 
/*  404 */         _pc.setsummon_skillid(1);
/*  405 */         _pc.setsummon_skillidmp(4);
/*      */       } 
/*  407 */       guaji_ai02(_pc);
/*  408 */     } else if (cmd.equalsIgnoreCase("Au_45")) {
/*  409 */       if (_pc.getchecksummidhp()) {
/*  410 */         _pc.setchecksummidhp(false);
/*      */       } else {
/*  412 */         _pc.setchecksummidhp(true);
/*      */       } 
/*  414 */       guaji_ai02(_pc);
/*  415 */     } else if (cmd.equalsIgnoreCase("Au_46")) {
/*  416 */       if (!_pc.getInventory().checkEquipped(20284)) {
/*  417 */         _pc.sendPackets((ServerBasePacket)new S_SystemMessage("未裝備[召喚控制戒指]"));
/*  418 */         return false;
/*      */       } 
/*  420 */       _pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(_pc.getId(), "guajisummon"));
/*  421 */     } else if (cmd.equalsIgnoreCase("summ_7")) {
/*  422 */       _pc.setSummon_npcid("7");
/*  423 */       guaji_ai02(_pc);
/*  424 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  425 */     } else if (cmd.equalsIgnoreCase("summ_263")) {
/*  426 */       _pc.setSummon_npcid("263");
/*  427 */       guaji_ai02(_pc);
/*  428 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  429 */     } else if (cmd.equalsIgnoreCase("summ_519")) {
/*  430 */       _pc.setSummon_npcid("519");
/*  431 */       guaji_ai02(_pc);
/*  432 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  433 */     } else if (cmd.equalsIgnoreCase("summ_8")) {
/*  434 */       _pc.setSummon_npcid("8");
/*  435 */       guaji_ai02(_pc);
/*  436 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  437 */     } else if (cmd.equalsIgnoreCase("summ_264")) {
/*  438 */       _pc.setSummon_npcid("264");
/*  439 */       guaji_ai02(_pc);
/*  440 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  441 */     } else if (cmd.equalsIgnoreCase("summ_520")) {
/*  442 */       _pc.setSummon_npcid("520");
/*  443 */       guaji_ai02(_pc);
/*  444 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  445 */     } else if (cmd.equalsIgnoreCase("summ_9")) {
/*  446 */       _pc.setSummon_npcid("9");
/*  447 */       guaji_ai02(_pc);
/*  448 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  449 */     } else if (cmd.equalsIgnoreCase("summ_265")) {
/*  450 */       _pc.setSummon_npcid("265");
/*  451 */       guaji_ai02(_pc);
/*  452 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  453 */     } else if (cmd.equalsIgnoreCase("summ_521")) {
/*  454 */       _pc.setSummon_npcid("521");
/*  455 */       guaji_ai02(_pc);
/*  456 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  457 */     } else if (cmd.equalsIgnoreCase("summ_10")) {
/*  458 */       _pc.setSummon_npcid("10");
/*  459 */       guaji_ai02(_pc);
/*  460 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  461 */     } else if (cmd.equalsIgnoreCase("summ_266")) {
/*  462 */       _pc.setSummon_npcid("266");
/*  463 */       guaji_ai02(_pc);
/*  464 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  465 */     } else if (cmd.equalsIgnoreCase("summ_522")) {
/*  466 */       _pc.setSummon_npcid("522");
/*  467 */       guaji_ai02(_pc);
/*  468 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  469 */     } else if (cmd.equalsIgnoreCase("summ_11")) {
/*  470 */       _pc.setSummon_npcid("11");
/*  471 */       guaji_ai02(_pc);
/*  472 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  473 */     } else if (cmd.equalsIgnoreCase("summ_267")) {
/*  474 */       _pc.setSummon_npcid("267");
/*  475 */       guaji_ai02(_pc);
/*  476 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  477 */     } else if (cmd.equalsIgnoreCase("summ_523")) {
/*  478 */       _pc.setSummon_npcid("523");
/*  479 */       guaji_ai02(_pc);
/*  480 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  481 */     } else if (cmd.equalsIgnoreCase("summ_12")) {
/*  482 */       _pc.setSummon_npcid("12");
/*  483 */       guaji_ai02(_pc);
/*  484 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  485 */     } else if (cmd.equalsIgnoreCase("summ_268")) {
/*  486 */       _pc.setSummon_npcid("268");
/*  487 */       guaji_ai02(_pc);
/*  488 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  489 */     } else if (cmd.equalsIgnoreCase("summ_524")) {
/*  490 */       _pc.setSummon_npcid("524");
/*  491 */       guaji_ai02(_pc);
/*  492 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  493 */     } else if (cmd.equalsIgnoreCase("summ_13")) {
/*  494 */       _pc.setSummon_npcid("13");
/*  495 */       guaji_ai02(_pc);
/*  496 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  497 */     } else if (cmd.equalsIgnoreCase("summ_269")) {
/*  498 */       _pc.setSummon_npcid("269");
/*  499 */       guaji_ai02(_pc);
/*  500 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  501 */     } else if (cmd.equalsIgnoreCase("summ_525")) {
/*  502 */       _pc.setSummon_npcid("525");
/*  503 */       guaji_ai02(_pc);
/*  504 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  505 */     } else if (cmd.equalsIgnoreCase("summ_14")) {
/*  506 */       _pc.setSummon_npcid("14");
/*  507 */       guaji_ai02(_pc);
/*  508 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  509 */     } else if (cmd.equalsIgnoreCase("summ_270")) {
/*  510 */       _pc.setSummon_npcid("270");
/*  511 */       guaji_ai02(_pc);
/*  512 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  513 */     } else if (cmd.equalsIgnoreCase("summ_526")) {
/*  514 */       _pc.setSummon_npcid("526");
/*  515 */       guaji_ai02(_pc);
/*  516 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  517 */     } else if (cmd.equalsIgnoreCase("summ_15")) {
/*  518 */       _pc.setSummon_npcid("15");
/*  519 */       guaji_ai02(_pc);
/*  520 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  521 */     } else if (cmd.equalsIgnoreCase("summ_271")) {
/*  522 */       _pc.setSummon_npcid("271");
/*  523 */       guaji_ai02(_pc);
/*  524 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  525 */     } else if (cmd.equalsIgnoreCase("summ_527")) {
/*  526 */       _pc.setSummon_npcid("527");
/*  527 */       guaji_ai02(_pc);
/*  528 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  529 */     } else if (cmd.equalsIgnoreCase("summ_16")) {
/*  530 */       _pc.setSummon_npcid("16");
/*  531 */       guaji_ai02(_pc);
/*  532 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  533 */     } else if (cmd.equalsIgnoreCase("summ_17")) {
/*  534 */       _pc.setSummon_npcid("17");
/*  535 */       guaji_ai02(_pc);
/*  536 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  537 */     } else if (cmd.equalsIgnoreCase("summ_18")) {
/*  538 */       _pc.setSummon_npcid("18");
/*  539 */       guaji_ai02(_pc);
/*  540 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*      */     } else {
/*  542 */       if (!cmd.equalsIgnoreCase("summ_274")) {
/*  543 */         return false;
/*      */       }
/*  545 */       _pc.setSummon_npcid("274");
/*  546 */       guaji_ai02(_pc);
/*  547 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*      */     } 
/*  549 */     return true;
/*      */   }
/*      */   
/*      */   public void CanSkillList(L1PcInstance pc, int mode) {
/*  553 */     StringBuilder msg = new StringBuilder();
/*  554 */     if (mode == 1) {
/*  555 */       int i = 0;
/*  556 */       while (i < _autoskill_buff.length) {
/*  557 */         if (CharSkillReading.get().spellCheck(pc.getId(), _autoskill_buff[i])) {
/*  558 */           L1Skills skill = SkillsTable.get().getTemplate(_autoskill_buff[i]);
/*  559 */           msg.append(String.valueOf(String.valueOf(skill.getName())) + ",");
/*      */         } 
/*  561 */         i++;
/*      */       } 
/*      */     } else {
/*  564 */       int i = 0;
/*  565 */       while (i < _autoskill_attack.length) {
/*  566 */         if (CharSkillReading.get().spellCheck(pc.getId(), _autoskill_attack[i])) {
/*  567 */           L1Skills skill = SkillsTable.get().getTemplate(_autoskill_attack[i]);
/*  568 */           msg.append(String.valueOf(String.valueOf(skill.getName())) + ",");
/*      */         } 
/*  570 */         i++;
/*      */       } 
/*      */     } 
/*  573 */     String[] clientStrAry = msg.toString().split(",");
/*  574 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "x_autolist3", clientStrAry));
/*      */   }
/*      */   
/*      */   public void SkillList(L1PcInstance pc, int mode) {
/*  578 */     StringBuilder msg = new StringBuilder();
/*  579 */     if (mode == 1) {
/*  580 */       Iterator<Integer> iterator = pc.BuffSkillList().iterator();
/*  581 */       while (iterator.hasNext()) {
/*  582 */         Integer id = iterator.next();
/*  583 */         L1Skills skill = SkillsTable.get().getTemplate(id.intValue());
/*  584 */         msg.append(String.valueOf(String.valueOf(skill.getName())) + ",");
/*      */       } 
/*      */     } else {
/*  587 */       Iterator<Integer> iterator2 = pc.AttackSkillList().iterator();
/*  588 */       while (iterator2.hasNext()) {
/*  589 */         Integer id = iterator2.next();
/*  590 */         L1Skills skill = SkillsTable.get().getTemplate(id.intValue());
/*  591 */         msg.append(String.valueOf(String.valueOf(skill.getName())) + ",");
/*      */       } 
/*      */     } 
/*  594 */     String[] clientStrAry = msg.toString().split(",");
/*  595 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "x_autolist3", clientStrAry));
/*      */   }
/*      */   
/*      */   public void EnemyList(L1PcInstance pc) {
/*  599 */     StringBuilder msg = new StringBuilder();
/*  600 */     Iterator<String> iterator = pc.InEnemyList().iterator();
/*  601 */     while (iterator.hasNext()) {
/*  602 */       String name = iterator.next();
/*  603 */       msg.append(String.valueOf(String.valueOf(name)) + ",");
/*      */     } 
/*  605 */     String[] clientStrAry = msg.toString().split(",");
/*  606 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "x_autolist2", clientStrAry));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isBuffSkill(int Skillid) {
/*  611 */     int autoskill_buff[], length = (autoskill_buff = _autoskill_buff).length;
/*  612 */     int i = 0;
/*  613 */     while (i < length) {
/*  614 */       int skillId = autoskill_buff[i];
/*  615 */       if (skillId == Skillid) {
/*  616 */         return true;
/*      */       }
/*  618 */       i++;
/*      */     } 
/*  620 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isAttackSkill(int Skillid) {
/*  625 */     int autoskill_attack[], length = (autoskill_attack = _autoskill_attack).length;
/*  626 */     int i = 0;
/*  627 */     while (i < length) {
/*  628 */       int skillId = autoskill_attack[i];
/*  629 */       if (skillId == Skillid) {
/*  630 */         return true;
/*      */       }
/*  632 */       i++;
/*      */     } 
/*  634 */     return false;
/*      */   }
/*      */   
/*      */   public void guaji_ai01(L1PcInstance pc) {
/*  638 */     String type1 = "";
/*  639 */     String type2 = "";
/*  640 */     String type3 = "";
/*  641 */     String type4 = "";
/*  642 */     String type5 = "";
/*  643 */     String type6 = "";
/*  644 */     String type7 = "";
/*  645 */     String type8 = "";
/*  646 */     String type9 = "";
/*  647 */     String type10 = "";
/*  648 */     String type11 = "";
/*  649 */     String type12 = "";
/*  650 */     String type13 = "";
/*  651 */     String type14 = "";
/*  652 */     String type15 = "";
/*  653 */     String type16 = "";
/*  654 */     String type17 = "";
/*  655 */     if (pc.get_fwgj() > 0) {
/*  656 */       int i = pc.get_fwgj();
/*      */     } else {
/*  658 */       type1 = "0";
/*      */     } 
/*  660 */     if (pc.getitempotion() > 0) {
/*  661 */       if (pc.getitempotion() == 1) {
/*  662 */         type2 = "紅色藥水";
/*  663 */       } else if (pc.getitempotion() == 2) {
/*  664 */         type2 = "橙色藥水";
/*  665 */       } else if (pc.getitempotion() == 3) {
/*  666 */         type2 = "白色藥水";
/*  667 */       } else if (pc.getitempotion() == 4) {
/*  668 */         type2 = "濃縮紅水";
/*  669 */       } else if (pc.getitempotion() == 5) {
/*  670 */         type2 = "濃縮橙水";
/*  671 */       } else if (pc.getitempotion() == 6) {
/*  672 */         type2 = "濃縮白水";
/*  673 */       } else if (pc.getitempotion() == 7) {
/*  674 */         type2 = "古代紅水";
/*  675 */       } else if (pc.getitempotion() == 8) {
/*  676 */         type2 = "古代橙水";
/*  677 */       } else if (pc.getitempotion() == 9) {
/*  678 */         type2 = "古代白水";
/*      */       } 
/*      */     } else {
/*  681 */       type2 = "尚未設定";
/*      */     } 
/*  683 */     if (pc.getpotioncount() > 0) {
/*  684 */       int i = pc.getpotioncount();
/*      */     } else {
/*  686 */       type3 = "0";
/*      */     } 
/*  688 */     if (pc.getitempotion1() > 0) {
/*  689 */       if (pc.getitempotion1() == 1) {
/*  690 */         type4 = "紅色藥水";
/*  691 */       } else if (pc.getitempotion1() == 2) {
/*  692 */         type4 = "橙色藥水";
/*  693 */       } else if (pc.getitempotion1() == 3) {
/*  694 */         type4 = "白色藥水";
/*  695 */       } else if (pc.getitempotion1() == 4) {
/*  696 */         type4 = "濃縮紅水";
/*  697 */       } else if (pc.getitempotion1() == 5) {
/*  698 */         type4 = "濃縮橙水";
/*  699 */       } else if (pc.getitempotion1() == 6) {
/*  700 */         type4 = "濃縮白水";
/*  701 */       } else if (pc.getitempotion1() == 7) {
/*  702 */         type4 = "古代紅水";
/*  703 */       } else if (pc.getitempotion1() == 8) {
/*  704 */         type4 = "古代橙水";
/*  705 */       } else if (pc.getitempotion1() == 9) {
/*  706 */         type4 = "古代白水";
/*      */       } 
/*      */     } else {
/*  709 */       type4 = "尚未設定";
/*      */     } 
/*  711 */     if (pc.getpotioncount1() > 0) {
/*  712 */       int i = pc.getpotioncount1();
/*      */     } else {
/*  714 */       type5 = "0";
/*      */     } 
/*  716 */     if (pc.getitempotion2() > 0) {
/*  717 */       if (pc.getitempotion2() == 1) {
/*  718 */         type6 = "箭";
/*  719 */       } else if (pc.getitempotion2() == 2) {
/*  720 */         type6 = "銀箭";
/*      */       } 
/*  722 */     } else if (pc.getitempotion2() == 0) {
/*  723 */       type6 = "尚未設定";
/*      */     } 
/*  725 */     if (pc.getpotioncount2() > 0) {
/*  726 */       int i = pc.getpotioncount2();
/*      */     } else {
/*  728 */       type7 = "0";
/*      */     } 
/*  730 */     if (pc.getgo_guajitele()) {
/*  731 */       type8 = "[開啟]";
/*      */     } else {
/*  733 */       type8 = "[關閉]";
/*      */     } 
/*  735 */     if (pc.getgo_guajired()) {
/*  736 */       type9 = "[開啟]";
/*      */     } else {
/*  738 */       type9 = "[關閉]";
/*      */     } 
/*  740 */     if (pc.IsAttackTeleport()) {
/*  741 */       type10 = "[開啟]";
/*      */     } else {
/*  743 */       type10 = "[關閉]";
/*      */     } 
/*  745 */     if (pc.IsEnemyTeleport()) {
/*  746 */       type11 = "[開啟]";
/*      */     } else {
/*  748 */       type11 = "[關閉]";
/*      */     } 
/*  750 */     if (pc.getma1() > 0) {
/*  751 */       int i = pc.getma1();
/*      */     } else {
/*  753 */       type12 = "未設置";
/*      */     } 
/*  755 */     if (pc.getchecksummid()) {
/*  756 */       type13 = "[開啟]";
/*      */     } else {
/*  758 */       type13 = "[關閉]";
/*      */     } 
/*  760 */     if (pc.getsummon_skillid() > 0) {
/*  761 */       if (pc.getsummon_skillid() == 1) {
/*  762 */         type14 = "[初治癒]";
/*  763 */       } else if (pc.getsummon_skillid() == 19) {
/*  764 */         type14 = "[中治癒]";
/*  765 */       } else if (pc.getsummon_skillid() == 35) {
/*  766 */         type14 = "[高治癒]";
/*  767 */       } else if (pc.getsummon_skillid() == 57) {
/*  768 */         type14 = "[全治癒]";
/*      */       } 
/*      */     } else {
/*  771 */       type14 = "[尚未設置]";
/*      */     } 
/*  773 */     if (pc.getchecksummidhp()) {
/*  774 */       type15 = "[開啟]";
/*      */     } else {
/*  776 */       type15 = "[關閉]";
/*      */     } 
/*  778 */     if (pc.getmobatk()) {
/*  779 */       type16 = "[開啟]";
/*      */     } else {
/*  781 */       type16 = "[關閉]";
/*      */     } 
/*  783 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "AI", new String[] { type1, type2, type3, type4, type5, type6, 
/*  784 */             type7, type8, type9, type10, type11, type12, type13, type14, type15, type16 }));
/*      */   }
/*      */   
/*      */   public void guaji_ai02(L1PcInstance pc) {
/*  788 */     String type1 = "";
/*  789 */     String type2 = "";
/*  790 */     String type3 = "";
/*  791 */     String type4 = "";
/*  792 */     String type5 = "";
/*  793 */     String type6 = "";
/*  794 */     String type7 = "";
/*  795 */     String type8 = "";
/*  796 */     String type9 = "";
/*  797 */     String type10 = "";
/*  798 */     String type11 = "";
/*  799 */     String type12 = "";
/*  800 */     String type13 = "";
/*  801 */     String type14 = "";
/*  802 */     String type15 = "";
/*  803 */     String type16 = "";
/*  804 */     String type17 = "";
/*  805 */     if (pc.get_fwgj() > 0) {
/*  806 */       int i = pc.get_fwgj();
/*      */     } else {
/*  808 */       type1 = "0";
/*      */     } 
/*  810 */     if (pc.getitempotion() > 0) {
/*  811 */       if (pc.getitempotion() == 1) {
/*  812 */         type2 = "紅色藥水";
/*  813 */       } else if (pc.getitempotion() == 2) {
/*  814 */         type2 = "橙色藥水";
/*  815 */       } else if (pc.getitempotion() == 3) {
/*  816 */         type2 = "白色藥水";
/*  817 */       } else if (pc.getitempotion() == 4) {
/*  818 */         type2 = "濃縮紅水";
/*  819 */       } else if (pc.getitempotion() == 5) {
/*  820 */         type2 = "濃縮橙水";
/*  821 */       } else if (pc.getitempotion() == 6) {
/*  822 */         type2 = "濃縮白水";
/*  823 */       } else if (pc.getitempotion() == 7) {
/*  824 */         type2 = "古代紅水";
/*  825 */       } else if (pc.getitempotion() == 8) {
/*  826 */         type2 = "古代橙水";
/*  827 */       } else if (pc.getitempotion() == 9) {
/*  828 */         type2 = "古代白水";
/*      */       } 
/*      */     } else {
/*  831 */       type2 = "尚未設定";
/*      */     } 
/*  833 */     if (pc.getpotioncount() > 0) {
/*  834 */       int i = pc.getpotioncount();
/*      */     } else {
/*  836 */       type3 = "0";
/*      */     } 
/*  838 */     if (pc.getitempotion1() > 0) {
/*  839 */       if (pc.getitempotion1() == 1) {
/*  840 */         type4 = "紅色藥水";
/*  841 */       } else if (pc.getitempotion1() == 2) {
/*  842 */         type4 = "橙色藥水";
/*  843 */       } else if (pc.getitempotion1() == 3) {
/*  844 */         type4 = "白色藥水";
/*  845 */       } else if (pc.getitempotion1() == 4) {
/*  846 */         type4 = "濃縮紅水";
/*  847 */       } else if (pc.getitempotion1() == 5) {
/*  848 */         type4 = "濃縮橙水";
/*  849 */       } else if (pc.getitempotion1() == 6) {
/*  850 */         type4 = "濃縮白水";
/*  851 */       } else if (pc.getitempotion1() == 7) {
/*  852 */         type4 = "古代紅水";
/*  853 */       } else if (pc.getitempotion1() == 8) {
/*  854 */         type4 = "古代橙水";
/*  855 */       } else if (pc.getitempotion1() == 9) {
/*  856 */         type4 = "古代白水";
/*      */       } 
/*      */     } else {
/*  859 */       type4 = "尚未設定";
/*      */     } 
/*  861 */     if (pc.getpotioncount1() > 0) {
/*  862 */       int i = pc.getpotioncount1();
/*      */     } else {
/*  864 */       type5 = "0";
/*      */     } 
/*  866 */     if (pc.getitempotion2() > 0) {
/*  867 */       if (pc.getitempotion2() == 1) {
/*  868 */         type6 = "箭";
/*  869 */       } else if (pc.getitempotion2() == 2) {
/*  870 */         type6 = "銀箭";
/*      */       } 
/*  872 */     } else if (pc.getitempotion2() == 0) {
/*  873 */       type6 = "尚未設定";
/*      */     } 
/*  875 */     if (pc.getpotioncount2() > 0) {
/*  876 */       int i = pc.getpotioncount2();
/*      */     } else {
/*  878 */       type7 = "0";
/*      */     } 
/*  880 */     if (pc.getgo_guajitele()) {
/*  881 */       type8 = "[開啟]";
/*      */     } else {
/*  883 */       type8 = "[關閉]";
/*      */     } 
/*  885 */     if (pc.getgo_guajired()) {
/*  886 */       type9 = "[開啟]";
/*      */     } else {
/*  888 */       type9 = "[關閉]";
/*      */     } 
/*  890 */     if (pc.IsAttackTeleport()) {
/*  891 */       type10 = "[開啟]";
/*      */     } else {
/*  893 */       type10 = "[關閉]";
/*      */     } 
/*  895 */     if (pc.IsEnemyTeleport()) {
/*  896 */       type11 = "[開啟]";
/*      */     } else {
/*  898 */       type11 = "[關閉]";
/*      */     } 
/*  900 */     if (pc.getma1() > 0) {
/*  901 */       int i = pc.getma1();
/*      */     } else {
/*  903 */       type12 = "未設置";
/*      */     } 
/*  905 */     if (pc.getchecksummid()) {
/*  906 */       type13 = "[開啟]";
/*      */     } else {
/*  908 */       type13 = "[關閉]";
/*      */     } 
/*  910 */     if (pc.getsummon_skillid() > 0) {
/*  911 */       if (pc.getsummon_skillid() == 1) {
/*  912 */         type14 = "[初治癒]";
/*  913 */       } else if (pc.getsummon_skillid() == 19) {
/*  914 */         type14 = "[中治癒]";
/*  915 */       } else if (pc.getsummon_skillid() == 35) {
/*  916 */         type14 = "[高治癒]";
/*  917 */       } else if (pc.getsummon_skillid() == 57) {
/*  918 */         type14 = "[全治癒]";
/*      */       } 
/*      */     } else {
/*  921 */       type14 = "[尚未設置]";
/*      */     } 
/*  923 */     if (pc.getchecksummidhp()) {
/*  924 */       type15 = "[開啟]";
/*      */     } else {
/*  926 */       type15 = "[關閉]";
/*      */     } 
/*  928 */     if (pc.getmobatk()) {
/*  929 */       type16 = "[開啟]";
/*      */     } else {
/*  931 */       type16 = "[關閉]";
/*      */     } 
/*  933 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "AI", new String[] { type1, type2, type3, type4, type5, type6, 
/*  934 */             type7, type8, type9, type10, type11, type12, type13, type14, type15, type16 }));
/*      */   }
/*      */   
/*      */   public void guaji_ai03(L1PcInstance pc) {
/*  938 */     String type1 = "";
/*  939 */     String type2 = "";
/*  940 */     String type3 = "";
/*  941 */     String type4 = "";
/*  942 */     String type5 = "";
/*  943 */     String type6 = "";
/*  944 */     String type7 = "";
/*  945 */     String type8 = "";
/*  946 */     String type9 = "";
/*  947 */     String type10 = "";
/*  948 */     String type11 = "";
/*  949 */     String type12 = "";
/*  950 */     String type13 = "";
/*  951 */     String type14 = "";
/*  952 */     String type15 = "";
/*  953 */     String type16 = "";
/*  954 */     String type17 = "";
/*  955 */     if (pc.get_fwgj() > 0) {
/*  956 */       int i = pc.get_fwgj();
/*      */     } else {
/*  958 */       type1 = "0";
/*      */     } 
/*  960 */     if (pc.getitempotion() > 0) {
/*  961 */       if (pc.getitempotion() == 1) {
/*  962 */         type2 = "紅色藥水";
/*  963 */       } else if (pc.getitempotion() == 2) {
/*  964 */         type2 = "橙色藥水";
/*  965 */       } else if (pc.getitempotion() == 3) {
/*  966 */         type2 = "白色藥水";
/*  967 */       } else if (pc.getitempotion() == 4) {
/*  968 */         type2 = "濃縮紅水";
/*  969 */       } else if (pc.getitempotion() == 5) {
/*  970 */         type2 = "濃縮橙水";
/*  971 */       } else if (pc.getitempotion() == 6) {
/*  972 */         type2 = "濃縮白水";
/*  973 */       } else if (pc.getitempotion() == 7) {
/*  974 */         type2 = "古代紅水";
/*  975 */       } else if (pc.getitempotion() == 8) {
/*  976 */         type2 = "古代橙水";
/*  977 */       } else if (pc.getitempotion() == 9) {
/*  978 */         type2 = "古代白水";
/*      */       } 
/*      */     } else {
/*  981 */       type2 = "尚未設定";
/*      */     } 
/*  983 */     if (pc.getpotioncount() > 0) {
/*  984 */       int i = pc.getpotioncount();
/*      */     } else {
/*  986 */       type3 = "0";
/*      */     } 
/*  988 */     if (pc.getitempotion1() > 0) {
/*  989 */       if (pc.getitempotion1() == 1) {
/*  990 */         type4 = "紅色藥水";
/*  991 */       } else if (pc.getitempotion1() == 2) {
/*  992 */         type4 = "橙色藥水";
/*  993 */       } else if (pc.getitempotion1() == 3) {
/*  994 */         type4 = "白色藥水";
/*  995 */       } else if (pc.getitempotion1() == 4) {
/*  996 */         type4 = "濃縮紅水";
/*  997 */       } else if (pc.getitempotion1() == 5) {
/*  998 */         type4 = "濃縮橙水";
/*  999 */       } else if (pc.getitempotion1() == 6) {
/* 1000 */         type4 = "濃縮白水";
/* 1001 */       } else if (pc.getitempotion1() == 7) {
/* 1002 */         type4 = "古代紅水";
/* 1003 */       } else if (pc.getitempotion1() == 8) {
/* 1004 */         type4 = "古代橙水";
/* 1005 */       } else if (pc.getitempotion1() == 9) {
/* 1006 */         type4 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1009 */       type4 = "尚未設定";
/*      */     } 
/* 1011 */     if (pc.getpotioncount1() > 0) {
/* 1012 */       int i = pc.getpotioncount1();
/*      */     } else {
/* 1014 */       type5 = "0";
/*      */     } 
/* 1016 */     if (pc.getitempotion2() > 0) {
/* 1017 */       if (pc.getitempotion2() == 1) {
/* 1018 */         type6 = "箭";
/* 1019 */       } else if (pc.getitempotion2() == 2) {
/* 1020 */         type6 = "銀箭";
/*      */       } 
/* 1022 */     } else if (pc.getitempotion2() == 0) {
/* 1023 */       type6 = "尚未設定";
/*      */     } 
/* 1025 */     if (pc.getpotioncount2() > 0) {
/* 1026 */       int i = pc.getpotioncount2();
/*      */     } else {
/* 1028 */       type7 = "0";
/*      */     } 
/* 1030 */     if (pc.getgo_guajitele()) {
/* 1031 */       type8 = "[開啟]";
/*      */     } else {
/* 1033 */       type8 = "[關閉]";
/*      */     } 
/* 1035 */     if (pc.getgo_guajired()) {
/* 1036 */       type9 = "[開啟]";
/*      */     } else {
/* 1038 */       type9 = "[關閉]";
/*      */     } 
/* 1040 */     if (pc.IsAttackTeleport()) {
/* 1041 */       type10 = "[開啟]";
/*      */     } else {
/* 1043 */       type10 = "[關閉]";
/*      */     } 
/* 1045 */     if (pc.IsEnemyTeleport()) {
/* 1046 */       type11 = "[開啟]";
/*      */     } else {
/* 1048 */       type11 = "[關閉]";
/*      */     } 
/* 1050 */     if (pc.getma1() > 0) {
/* 1051 */       int i = pc.getma1();
/*      */     } else {
/* 1053 */       type12 = "未設置";
/*      */     } 
/* 1055 */     if (pc.getchecksummid()) {
/* 1056 */       type13 = "[開啟]";
/*      */     } else {
/* 1058 */       type13 = "[關閉]";
/*      */     } 
/* 1060 */     if (pc.getsummon_skillid() > 0) {
/* 1061 */       if (pc.getsummon_skillid() == 1) {
/* 1062 */         type14 = "[初治癒]";
/* 1063 */       } else if (pc.getsummon_skillid() == 19) {
/* 1064 */         type14 = "[中治癒]";
/* 1065 */       } else if (pc.getsummon_skillid() == 35) {
/* 1066 */         type14 = "[高治癒]";
/* 1067 */       } else if (pc.getsummon_skillid() == 57) {
/* 1068 */         type14 = "[全治癒]";
/*      */       } 
/*      */     } else {
/* 1071 */       type14 = "[尚未設置]";
/*      */     } 
/* 1073 */     if (pc.getchecksummidhp()) {
/* 1074 */       type15 = "[開啟]";
/*      */     } else {
/* 1076 */       type15 = "[關閉]";
/*      */     } 
/* 1078 */     if (pc.getmobatk()) {
/* 1079 */       type16 = "[開啟]";
/*      */     } else {
/* 1081 */       type16 = "[關閉]";
/*      */     } 
/* 1083 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "AI", new String[] { type1, type2, type3, type4, type5, type6, 
/* 1084 */             type7, type8, type9, type10, type11, type12, type13, type14, type15, type16 }));
/*      */   }
/*      */   
/*      */   public void guaji_ai04(L1PcInstance pc) {
/* 1088 */     String type1 = "";
/* 1089 */     String type2 = "";
/* 1090 */     String type3 = "";
/* 1091 */     String type4 = "";
/* 1092 */     String type5 = "";
/* 1093 */     String type6 = "";
/* 1094 */     String type7 = "";
/* 1095 */     String type8 = "";
/* 1096 */     String type9 = "";
/* 1097 */     String type10 = "";
/* 1098 */     String type11 = "";
/* 1099 */     String type12 = "";
/* 1100 */     String type13 = "";
/* 1101 */     String type14 = "";
/* 1102 */     String type15 = "";
/* 1103 */     String type16 = "";
/* 1104 */     String type17 = "";
/* 1105 */     if (pc.get_fwgj() > 0) {
/* 1106 */       int i = pc.get_fwgj();
/*      */     } else {
/* 1108 */       type1 = "0";
/*      */     } 
/* 1110 */     if (pc.getitempotion() > 0) {
/* 1111 */       if (pc.getitempotion() == 1) {
/* 1112 */         type2 = "紅色藥水";
/* 1113 */       } else if (pc.getitempotion() == 2) {
/* 1114 */         type2 = "橙色藥水";
/* 1115 */       } else if (pc.getitempotion() == 3) {
/* 1116 */         type2 = "白色藥水";
/* 1117 */       } else if (pc.getitempotion() == 4) {
/* 1118 */         type2 = "濃縮紅水";
/* 1119 */       } else if (pc.getitempotion() == 5) {
/* 1120 */         type2 = "濃縮橙水";
/* 1121 */       } else if (pc.getitempotion() == 6) {
/* 1122 */         type2 = "濃縮白水";
/* 1123 */       } else if (pc.getitempotion() == 7) {
/* 1124 */         type2 = "古代紅水";
/* 1125 */       } else if (pc.getitempotion() == 8) {
/* 1126 */         type2 = "古代橙水";
/* 1127 */       } else if (pc.getitempotion() == 9) {
/* 1128 */         type2 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1131 */       type2 = "尚未設定";
/*      */     } 
/* 1133 */     if (pc.getpotioncount() > 0) {
/* 1134 */       int i = pc.getpotioncount();
/*      */     } else {
/* 1136 */       type3 = "0";
/*      */     } 
/* 1138 */     if (pc.getitempotion1() > 0) {
/* 1139 */       if (pc.getitempotion1() == 1) {
/* 1140 */         type4 = "紅色藥水";
/* 1141 */       } else if (pc.getitempotion1() == 2) {
/* 1142 */         type4 = "橙色藥水";
/* 1143 */       } else if (pc.getitempotion1() == 3) {
/* 1144 */         type4 = "白色藥水";
/* 1145 */       } else if (pc.getitempotion1() == 4) {
/* 1146 */         type4 = "濃縮紅水";
/* 1147 */       } else if (pc.getitempotion1() == 5) {
/* 1148 */         type4 = "濃縮橙水";
/* 1149 */       } else if (pc.getitempotion1() == 6) {
/* 1150 */         type4 = "濃縮白水";
/* 1151 */       } else if (pc.getitempotion1() == 7) {
/* 1152 */         type4 = "古代紅水";
/* 1153 */       } else if (pc.getitempotion1() == 8) {
/* 1154 */         type4 = "古代橙水";
/* 1155 */       } else if (pc.getitempotion1() == 9) {
/* 1156 */         type4 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1159 */       type4 = "尚未設定";
/*      */     } 
/* 1161 */     if (pc.getpotioncount1() > 0) {
/* 1162 */       int i = pc.getpotioncount1();
/*      */     } else {
/* 1164 */       type5 = "0";
/*      */     } 
/* 1166 */     if (pc.getitempotion2() > 0) {
/* 1167 */       if (pc.getitempotion2() == 1) {
/* 1168 */         type6 = "箭";
/* 1169 */       } else if (pc.getitempotion2() == 2) {
/* 1170 */         type6 = "銀箭";
/*      */       } 
/* 1172 */     } else if (pc.getitempotion2() == 0) {
/* 1173 */       type6 = "尚未設定";
/*      */     } 
/* 1175 */     if (pc.getpotioncount2() > 0) {
/* 1176 */       int i = pc.getpotioncount2();
/*      */     } else {
/* 1178 */       type7 = "0";
/*      */     } 
/* 1180 */     if (pc.getgo_guajitele()) {
/* 1181 */       type8 = "[開啟]";
/*      */     } else {
/* 1183 */       type8 = "[關閉]";
/*      */     } 
/* 1185 */     if (pc.getgo_guajired()) {
/* 1186 */       type9 = "[開啟]";
/*      */     } else {
/* 1188 */       type9 = "[關閉]";
/*      */     } 
/* 1190 */     if (pc.IsAttackTeleport()) {
/* 1191 */       type10 = "[開啟]";
/*      */     } else {
/* 1193 */       type10 = "[關閉]";
/*      */     } 
/* 1195 */     if (pc.IsEnemyTeleport()) {
/* 1196 */       type11 = "[開啟]";
/*      */     } else {
/* 1198 */       type11 = "[關閉]";
/*      */     } 
/* 1200 */     if (pc.getma1() > 0) {
/* 1201 */       int i = pc.getma1();
/*      */     } else {
/* 1203 */       type12 = "未設置";
/*      */     } 
/* 1205 */     if (pc.getchecksummid()) {
/* 1206 */       type13 = "[開啟]";
/*      */     } else {
/* 1208 */       type13 = "[關閉]";
/*      */     } 
/* 1210 */     if (pc.getsummon_skillid() > 0) {
/* 1211 */       if (pc.getsummon_skillid() == 1) {
/* 1212 */         type14 = "[初治癒]";
/* 1213 */       } else if (pc.getsummon_skillid() == 19) {
/* 1214 */         type14 = "[中治癒]";
/* 1215 */       } else if (pc.getsummon_skillid() == 35) {
/* 1216 */         type14 = "[高治癒]";
/* 1217 */       } else if (pc.getsummon_skillid() == 57) {
/* 1218 */         type14 = "[全治癒]";
/*      */       } 
/*      */     } else {
/* 1221 */       type14 = "[尚未設置]";
/*      */     } 
/* 1223 */     if (pc.getchecksummidhp()) {
/* 1224 */       type15 = "[開啟]";
/*      */     } else {
/* 1226 */       type15 = "[關閉]";
/*      */     } 
/* 1228 */     if (pc.getmobatk()) {
/* 1229 */       type16 = "[開啟]";
/*      */     } else {
/* 1231 */       type16 = "[關閉]";
/*      */     } 
/* 1233 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "AI", new String[] { type1, type2, type3, type4, type5, type6, 
/* 1234 */             type7, type8, type9, type10, type11, type12, type13, type14, type15, type16 }));
/*      */   }
/*      */   
/*      */   public void guaji_ai05(L1PcInstance pc) {
/* 1238 */     String type1 = "";
/* 1239 */     String type2 = "";
/* 1240 */     String type3 = "";
/* 1241 */     String type4 = "";
/* 1242 */     String type5 = "";
/* 1243 */     String type6 = "";
/* 1244 */     String type7 = "";
/* 1245 */     String type8 = "";
/* 1246 */     String type9 = "";
/* 1247 */     String type10 = "";
/* 1248 */     String type11 = "";
/* 1249 */     String type12 = "";
/* 1250 */     String type13 = "";
/* 1251 */     String type14 = "";
/* 1252 */     String type15 = "";
/* 1253 */     String type16 = "";
/* 1254 */     String type17 = "";
/* 1255 */     if (pc.get_fwgj() > 0) {
/* 1256 */       int i = pc.get_fwgj();
/*      */     } else {
/* 1258 */       type1 = "0";
/*      */     } 
/* 1260 */     if (pc.getitempotion() > 0) {
/* 1261 */       if (pc.getitempotion() == 1) {
/* 1262 */         type2 = "紅色藥水";
/* 1263 */       } else if (pc.getitempotion() == 2) {
/* 1264 */         type2 = "橙色藥水";
/* 1265 */       } else if (pc.getitempotion() == 3) {
/* 1266 */         type2 = "白色藥水";
/* 1267 */       } else if (pc.getitempotion() == 4) {
/* 1268 */         type2 = "濃縮紅水";
/* 1269 */       } else if (pc.getitempotion() == 5) {
/* 1270 */         type2 = "濃縮橙水";
/* 1271 */       } else if (pc.getitempotion() == 6) {
/* 1272 */         type2 = "濃縮白水";
/* 1273 */       } else if (pc.getitempotion() == 7) {
/* 1274 */         type2 = "古代紅水";
/* 1275 */       } else if (pc.getitempotion() == 8) {
/* 1276 */         type2 = "古代橙水";
/* 1277 */       } else if (pc.getitempotion() == 9) {
/* 1278 */         type2 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1281 */       type2 = "尚未設定";
/*      */     } 
/* 1283 */     if (pc.getpotioncount() > 0) {
/* 1284 */       int i = pc.getpotioncount();
/*      */     } else {
/* 1286 */       type3 = "0";
/*      */     } 
/* 1288 */     if (pc.getitempotion1() > 0) {
/* 1289 */       if (pc.getitempotion1() == 1) {
/* 1290 */         type4 = "紅色藥水";
/* 1291 */       } else if (pc.getitempotion1() == 2) {
/* 1292 */         type4 = "橙色藥水";
/* 1293 */       } else if (pc.getitempotion1() == 3) {
/* 1294 */         type4 = "白色藥水";
/* 1295 */       } else if (pc.getitempotion1() == 4) {
/* 1296 */         type4 = "濃縮紅水";
/* 1297 */       } else if (pc.getitempotion1() == 5) {
/* 1298 */         type4 = "濃縮橙水";
/* 1299 */       } else if (pc.getitempotion1() == 6) {
/* 1300 */         type4 = "濃縮白水";
/* 1301 */       } else if (pc.getitempotion1() == 7) {
/* 1302 */         type4 = "古代紅水";
/* 1303 */       } else if (pc.getitempotion1() == 8) {
/* 1304 */         type4 = "古代橙水";
/* 1305 */       } else if (pc.getitempotion1() == 9) {
/* 1306 */         type4 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1309 */       type4 = "尚未設定";
/*      */     } 
/* 1311 */     if (pc.getpotioncount1() > 0) {
/* 1312 */       int i = pc.getpotioncount1();
/*      */     } else {
/* 1314 */       type5 = "0";
/*      */     } 
/* 1316 */     if (pc.getitempotion2() > 0) {
/* 1317 */       if (pc.getitempotion2() == 1) {
/* 1318 */         type6 = "箭";
/* 1319 */       } else if (pc.getitempotion2() == 2) {
/* 1320 */         type6 = "銀箭";
/*      */       } 
/* 1322 */     } else if (pc.getitempotion2() == 0) {
/* 1323 */       type6 = "尚未設定";
/*      */     } 
/* 1325 */     if (pc.getpotioncount2() > 0) {
/* 1326 */       int i = pc.getpotioncount2();
/*      */     } else {
/* 1328 */       type7 = "0";
/*      */     } 
/* 1330 */     if (pc.getgo_guajitele()) {
/* 1331 */       type8 = "[開啟]";
/*      */     } else {
/* 1333 */       type8 = "[關閉]";
/*      */     } 
/* 1335 */     if (pc.getgo_guajired()) {
/* 1336 */       type9 = "[開啟]";
/*      */     } else {
/* 1338 */       type9 = "[關閉]";
/*      */     } 
/* 1340 */     if (pc.IsAttackTeleport()) {
/* 1341 */       type10 = "[開啟]";
/*      */     } else {
/* 1343 */       type10 = "[關閉]";
/*      */     } 
/* 1345 */     if (pc.IsEnemyTeleport()) {
/* 1346 */       type11 = "[開啟]";
/*      */     } else {
/* 1348 */       type11 = "[關閉]";
/*      */     } 
/* 1350 */     if (pc.getma1() > 0) {
/* 1351 */       int i = pc.getma1();
/*      */     } else {
/* 1353 */       type12 = "未設置";
/*      */     } 
/* 1355 */     if (pc.getchecksummid()) {
/* 1356 */       type13 = "[開啟]";
/*      */     } else {
/* 1358 */       type13 = "[關閉]";
/*      */     } 
/* 1360 */     if (pc.getsummon_skillid() > 0) {
/* 1361 */       if (pc.getsummon_skillid() == 1) {
/* 1362 */         type14 = "[初治癒]";
/* 1363 */       } else if (pc.getsummon_skillid() == 19) {
/* 1364 */         type14 = "[中治癒]";
/* 1365 */       } else if (pc.getsummon_skillid() == 35) {
/* 1366 */         type14 = "[高治癒]";
/* 1367 */       } else if (pc.getsummon_skillid() == 57) {
/* 1368 */         type14 = "[全治癒]";
/*      */       } 
/*      */     } else {
/* 1371 */       type14 = "[尚未設置]";
/*      */     } 
/* 1373 */     if (pc.getchecksummidhp()) {
/* 1374 */       type15 = "[開啟]";
/*      */     } else {
/* 1376 */       type15 = "[關閉]";
/*      */     } 
/* 1378 */     if (pc.getmobatk()) {
/* 1379 */       type16 = "[開啟]";
/*      */     } else {
/* 1381 */       type16 = "[關閉]";
/*      */     } 
/* 1383 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "AI", new String[] { type1, type2, type3, type4, type5, type6, 
/* 1384 */             type7, type8, type9, type10, type11, type12, type13, type14, type15, type16 }));
/*      */   }
/*      */   
/*      */   public void guaji(L1PcInstance pc) {
/* 1388 */     String type1 = "";
/* 1389 */     String type2 = "";
/* 1390 */     String type3 = "";
/* 1391 */     String type4 = "";
/* 1392 */     String type5 = "";
/* 1393 */     String type6 = "";
/* 1394 */     String type7 = "";
/* 1395 */     String type8 = "";
/* 1396 */     String type9 = "";
/* 1397 */     String type10 = "";
/* 1398 */     String type11 = "";
/* 1399 */     String type12 = "";
/* 1400 */     String type13 = "";
/* 1401 */     String type14 = "";
/* 1402 */     String type15 = "";
/* 1403 */     String type16 = "";
/* 1404 */     String type17 = "";
/* 1405 */     String type18 = "";
/* 1406 */     if (pc.get_fwgj() > 0) {
/* 1407 */       int i = pc.get_fwgj();
/*      */     } else {
/* 1409 */       type1 = "0";
/*      */     } 
/* 1411 */     if (pc.getitempotion() > 0) {
/* 1412 */       if (pc.getitempotion() == 1) {
/* 1413 */         type2 = "紅色藥水";
/* 1414 */       } else if (pc.getitempotion() == 2) {
/* 1415 */         type2 = "橙色藥水";
/* 1416 */       } else if (pc.getitempotion() == 3) {
/* 1417 */         type2 = "白色藥水";
/* 1418 */       } else if (pc.getitempotion() == 4) {
/* 1419 */         type2 = "濃縮紅水";
/* 1420 */       } else if (pc.getitempotion() == 5) {
/* 1421 */         type2 = "濃縮橙水";
/* 1422 */       } else if (pc.getitempotion() == 6) {
/* 1423 */         type2 = "濃縮白水";
/* 1424 */       } else if (pc.getitempotion() == 7) {
/* 1425 */         type2 = "古代紅水";
/* 1426 */       } else if (pc.getitempotion() == 8) {
/* 1427 */         type2 = "古代橙水";
/* 1428 */       } else if (pc.getitempotion() == 9) {
/* 1429 */         type2 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1432 */       type2 = "尚未設定";
/*      */     } 
/* 1434 */     if (pc.getpotioncount() > 0) {
/* 1435 */       int i = pc.getpotioncount();
/*      */     } else {
/* 1437 */       type3 = "0";
/*      */     } 
/* 1439 */     if (pc.getitempotion1() > 0) {
/* 1440 */       if (pc.getitempotion1() == 1) {
/* 1441 */         type4 = "紅色藥水";
/* 1442 */       } else if (pc.getitempotion1() == 2) {
/* 1443 */         type4 = "橙色藥水";
/* 1444 */       } else if (pc.getitempotion1() == 3) {
/* 1445 */         type4 = "白色藥水";
/* 1446 */       } else if (pc.getitempotion1() == 4) {
/* 1447 */         type4 = "濃縮紅水";
/* 1448 */       } else if (pc.getitempotion1() == 5) {
/* 1449 */         type4 = "濃縮橙水";
/* 1450 */       } else if (pc.getitempotion1() == 6) {
/* 1451 */         type4 = "濃縮白水";
/* 1452 */       } else if (pc.getitempotion1() == 7) {
/* 1453 */         type4 = "古代紅水";
/* 1454 */       } else if (pc.getitempotion1() == 8) {
/* 1455 */         type4 = "古代橙水";
/* 1456 */       } else if (pc.getitempotion1() == 9) {
/* 1457 */         type4 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1460 */       type4 = "尚未設定";
/*      */     } 
/* 1462 */     if (pc.getpotioncount1() > 0) {
/* 1463 */       int i = pc.getpotioncount1();
/*      */     } else {
/* 1465 */       type5 = "0";
/*      */     } 
/* 1467 */     if (pc.getitempotion2() > 0) {
/* 1468 */       if (pc.getitempotion2() == 1) {
/* 1469 */         type6 = "箭";
/* 1470 */       } else if (pc.getitempotion2() == 2) {
/* 1471 */         type6 = "銀箭";
/*      */       } 
/* 1473 */     } else if (pc.getitempotion2() == 0) {
/* 1474 */       type6 = "尚未設定";
/*      */     } 
/* 1476 */     if (pc.getpotioncount2() > 0) {
/* 1477 */       int i = pc.getpotioncount2();
/*      */     } else {
/* 1479 */       type7 = "0";
/*      */     } 
/* 1481 */     if (pc.getgo_guajitele()) {
/* 1482 */       type8 = "[開啟]";
/*      */     } else {
/* 1484 */       type8 = "[關閉]";
/*      */     } 
/* 1486 */     if (pc.getgo_guajired()) {
/* 1487 */       type9 = "[開啟]";
/*      */     } else {
/* 1489 */       type9 = "[關閉]";
/*      */     } 
/* 1491 */     if (pc.IsAttackTeleport()) {
/* 1492 */       type10 = "[開啟]";
/*      */     } else {
/* 1494 */       type10 = "[關閉]";
/*      */     } 
/* 1496 */     if (pc.IsEnemyTeleport()) {
/* 1497 */       type11 = "[開啟]";
/*      */     } else {
/* 1499 */       type11 = "[關閉]";
/*      */     } 
/* 1501 */     if (pc.getma1() > 0) {
/* 1502 */       int i = pc.getma1();
/*      */     } else {
/* 1504 */       type12 = "未設置";
/*      */     } 
/* 1506 */     if (pc.getchecksummid()) {
/* 1507 */       type13 = "[開啟]";
/*      */     } else {
/* 1509 */       type13 = "[關閉]";
/*      */     } 
/* 1511 */     if (pc.getsummon_skillid() > 0) {
/* 1512 */       if (pc.getsummon_skillid() == 1) {
/* 1513 */         type14 = "[初治癒]";
/* 1514 */       } else if (pc.getsummon_skillid() == 19) {
/* 1515 */         type14 = "[中治癒]";
/* 1516 */       } else if (pc.getsummon_skillid() == 35) {
/* 1517 */         type14 = "[高治癒]";
/* 1518 */       } else if (pc.getsummon_skillid() == 57) {
/* 1519 */         type14 = "[全治癒]";
/*      */       } 
/*      */     } else {
/* 1522 */       type14 = "[尚未設置]";
/*      */     } 
/* 1524 */     if (pc.getchecksummidhp()) {
/* 1525 */       type15 = "[開啟]";
/*      */     } else {
/* 1527 */       type15 = "[關閉]";
/*      */     } 
/* 1529 */     if (pc.getmobatk()) {
/* 1530 */       type16 = "[開啟]";
/*      */     } else {
/* 1532 */       type16 = "[關閉]";
/*      */     } 
/* 1534 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "AI", new String[] { type1, type2, type3, type4, type5, type6, 
/* 1535 */             type7, type8, type9, type10, type11, type12, type13, type14, type15, type16, "" }));
/*      */   }
/*      */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\AutoAttackUpdate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */