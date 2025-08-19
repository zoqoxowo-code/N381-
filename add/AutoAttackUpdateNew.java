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
/*      */ public class AutoAttackUpdateNew
/*      */ {
/*      */   private static final int[] _autoskill_buff;
/*      */   private static final int[] _autoskill_attack;
/*   27 */   private static final Logger _log = Logger.getLogger(AutoAttackUpdateNew.class.getName()); static {
/*   28 */     _autoskill_buff = new int[] { 114, 115, 117, 88, 91, 3, 14, 26, 42, 48, 54, 68, 79, 129, 137, 138, 147, 148, 
/*   29 */         155, 163, 171, 149, 156, 166, 151, 159, 168, 160, 98, 99, 102, 106, 109, 110, 111, 105, 181, 191, 201, 
/*   30 */         206, 211, 216 };
/*   31 */     _autoskill_attack = new int[] { 87, 4, 6, 7, 10, 15, 16, 22, 25, 28, 34, 38, 45, 46, 53, 59, 65, 70, 74, 77, 
/*   32 */         132, 108, 184, 187, 192, 194, 218 };
/*      */   }
/*      */   private static AutoAttackUpdateNew _instance;
/*      */   public static AutoAttackUpdateNew getInstance() {
/*   36 */     if (_instance == null) {
/*   37 */       _instance = new AutoAttackUpdateNew();
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
/*  107 */         _pc.setActived(true);
/*  108 */         _pc.startAI();
/*  109 */         _pc.setSkillEffect(99666, 15000);
/*      */       } 
/*  111 */     } else if (cmd.equalsIgnoreCase("fanwei_01")) {
/*  112 */       if (_pc.isActived()) {
/*  113 */         _pc.sendPackets((ServerBasePacket)new S_ServerMessage("內掛中,無法進行此操作。"));
/*  114 */         return false;
/*      */       } 
/*  116 */       _pc.setlslocx(_pc.getX());
/*  117 */       _pc.setlslocy(_pc.getY());
/*  118 */       _pc.setgo_guajitele(false);
/*  119 */       _pc.set_fwgj(_pc.get_fwgj() + 10);
/*  120 */       guaji(_pc);
/*  121 */     } else if (cmd.equalsIgnoreCase("fanwei_02")) {
/*  122 */       if (_pc.isActived()) {
/*  123 */         _pc.sendPackets((ServerBasePacket)new S_ServerMessage("內掛中,無法進行此操作。"));
/*  124 */         return false;
/*      */       } 
/*  126 */       _pc.setlslocx(_pc.getX());
/*  127 */       _pc.setlslocy(_pc.getY());
/*  128 */       _pc.setgo_guajitele(false);
/*  129 */       _pc.set_fwgj(_pc.get_fwgj() - 10);
/*  130 */       if (_pc.get_fwgj() <= 0) {
/*  131 */         _pc.set_fwgj(0);
/*  132 */         _pc.setlslocx(0);
/*  133 */         _pc.setlslocy(0);
/*      */       } 
/*  135 */       guaji(_pc);
/*  136 */     } else if (cmd.equalsIgnoreCase("buy_00")) {
/*  137 */       _pc.setitempotion(0);
/*  138 */       _pc.setitemitemid(0);
/*  139 */       _pc.setitemadena(0);
/*  140 */       _pc.setitempotion1(0);
/*  141 */       _pc.setitemitemid1(0);
/*  142 */       _pc.setitemadena1(0);
/*  143 */       _pc.setpotioncount(0);
/*  144 */       _pc.setpotioncount1(0);
/*  145 */       _pc.setitempotion2(0);
/*  146 */       _pc.setitemitemid2(0);
/*  147 */       _pc.setitemadena2(0);
/*  148 */       _pc.setpotioncount2(0);
/*  149 */       guaji_ai03(_pc);
/*  150 */     } else if (cmd.equalsIgnoreCase("buy_01")) {
/*  151 */       if (_pc.getitempotion() == 0) {
/*  152 */         _pc.setitempotion(1);
/*  153 */         _pc.setitemitemid(40010);
/*  154 */         _pc.setitemadena(ConfigGuaji.itemadena1);
/*  155 */       } else if (_pc.getitempotion() == 1) {
/*  156 */         _pc.setitempotion(2);
/*  157 */         _pc.setitemitemid(40011);
/*  158 */         _pc.setitemadena(ConfigGuaji.itemadena2);
/*  159 */       } else if (_pc.getitempotion() == 2) {
/*  160 */         _pc.setitempotion(3);
/*  161 */         _pc.setitemitemid(40012);
/*  162 */         _pc.setitemadena(ConfigGuaji.itemadena3);
/*  163 */       } else if (_pc.getitempotion() == 3) {
/*  164 */         _pc.setitempotion(4);
/*  165 */         _pc.setitemitemid(40019);
/*  166 */         _pc.setitemadena(ConfigGuaji.itemadena4);
/*  167 */       } else if (_pc.getitempotion() == 4) {
/*  168 */         _pc.setitempotion(5);
/*  169 */         _pc.setitemitemid(40020);
/*  170 */         _pc.setitemadena(ConfigGuaji.itemadena5);
/*  171 */       } else if (_pc.getitempotion() == 5) {
/*  172 */         _pc.setitempotion(6);
/*  173 */         _pc.setitemitemid(40021);
/*  174 */         _pc.setitemadena(ConfigGuaji.itemadena6);
/*  175 */       } else if (_pc.getitempotion() == 6) {
/*  176 */         _pc.setitempotion(7);
/*  177 */         _pc.setitemitemid(40022);
/*  178 */         _pc.setitemadena(ConfigGuaji.itemadena7);
/*  179 */       } else if (_pc.getitempotion() == 7) {
/*  180 */         _pc.setitempotion(8);
/*  181 */         _pc.setitemitemid(40023);
/*  182 */         _pc.setitemadena(ConfigGuaji.itemadena8);
/*  183 */       } else if (_pc.getitempotion() == 8) {
/*  184 */         _pc.setitempotion(9);
/*  185 */         _pc.setitemitemid(40024);
/*  186 */         _pc.setitemadena(ConfigGuaji.itemadena9);
/*  187 */       } else if (_pc.getitempotion() == 9) {
/*  188 */         _pc.setitempotion(0);
/*  189 */         _pc.setitemitemid(0);
/*  190 */         _pc.setitemadena(0);
/*      */       } 
/*  192 */       guaji_ai03(_pc);
/*  193 */     } else if (cmd.equalsIgnoreCase("buy_02")) {
/*  194 */       if (_pc.getitempotion1() == 0) {
/*  195 */         _pc.setitempotion1(1);
/*  196 */         _pc.setitemitemid1(40010);
/*  197 */         _pc.setitemadena1(ConfigGuaji.itemadena1);
/*  198 */       } else if (_pc.getitempotion1() == 1) {
/*  199 */         _pc.setitempotion1(2);
/*  200 */         _pc.setitemitemid1(40011);
/*  201 */         _pc.setitemadena1(ConfigGuaji.itemadena2);
/*  202 */       } else if (_pc.getitempotion1() == 2) {
/*  203 */         _pc.setitempotion1(3);
/*  204 */         _pc.setitemitemid1(40012);
/*  205 */         _pc.setitemadena1(ConfigGuaji.itemadena3);
/*  206 */       } else if (_pc.getitempotion1() == 3) {
/*  207 */         _pc.setitempotion1(4);
/*  208 */         _pc.setitemitemid1(40019);
/*  209 */         _pc.setitemadena1(ConfigGuaji.itemadena4);
/*  210 */       } else if (_pc.getitempotion1() == 4) {
/*  211 */         _pc.setitempotion1(5);
/*  212 */         _pc.setitemitemid1(40020);
/*  213 */         _pc.setitemadena1(ConfigGuaji.itemadena5);
/*  214 */       } else if (_pc.getitempotion1() == 5) {
/*  215 */         _pc.setitempotion1(6);
/*  216 */         _pc.setitemitemid1(40021);
/*  217 */         _pc.setitemadena1(ConfigGuaji.itemadena6);
/*  218 */       } else if (_pc.getitempotion1() == 6) {
/*  219 */         _pc.setitempotion1(7);
/*  220 */         _pc.setitemitemid1(40022);
/*  221 */         _pc.setitemadena1(ConfigGuaji.itemadena7);
/*  222 */       } else if (_pc.getitempotion1() == 7) {
/*  223 */         _pc.setitempotion1(8);
/*  224 */         _pc.setitemitemid1(40023);
/*  225 */         _pc.setitemadena1(ConfigGuaji.itemadena8);
/*  226 */       } else if (_pc.getitempotion1() == 8) {
/*  227 */         _pc.setitempotion1(9);
/*  228 */         _pc.setitemitemid1(40024);
/*  229 */         _pc.setitemadena1(ConfigGuaji.itemadena9);
/*  230 */       } else if (_pc.getitempotion1() == 9) {
/*  231 */         _pc.setitempotion1(0);
/*  232 */         _pc.setitemitemid1(0);
/*  233 */         _pc.setitemadena1(0);
/*      */       } 
/*  235 */       guaji_ai03(_pc);
/*  236 */     } else if (cmd.equalsIgnoreCase("buy_03")) {
/*  237 */       if (_pc.getitempotion2() == 0) {
/*  238 */         _pc.setitempotion2(1);
/*  239 */         _pc.setitemitemid2(40743);
/*  240 */         _pc.setitemadena2(ConfigGuaji.itemadena21);
/*  241 */       } else if (_pc.getitempotion2() == 1) {
/*  242 */         _pc.setitempotion2(2);
/*  243 */         _pc.setitemitemid2(40744);
/*  244 */         _pc.setitemadena2(ConfigGuaji.itemadena22);
/*  245 */       } else if (_pc.getitempotion2() == 2) {
/*  246 */         _pc.setitempotion2(0);
/*  247 */         _pc.setitemitemid2(0);
/*  248 */         _pc.setitemadena2(0);
/*      */       } 
/*  250 */       guaji_ai03(_pc);
/*  251 */     } else if (cmd.equalsIgnoreCase("buy_04")) {
/*  252 */       _pc.setpotioncount(_pc.getpotioncount() + 50);
/*  253 */       guaji_ai03(_pc);
/*  254 */     } else if (cmd.equalsIgnoreCase("buy_05")) {
/*  255 */       _pc.setpotioncount1(_pc.getpotioncount1() + 50);
/*  256 */       guaji_ai03(_pc);
/*  257 */     } else if (cmd.equalsIgnoreCase("buy_06")) {
/*  258 */       _pc.setpotioncount2(_pc.getpotioncount2() + 1000);
/*  259 */       guaji_ai03(_pc);
/*  260 */     } else if (cmd.equalsIgnoreCase("shunyi_01")) {
/*  261 */       if (_pc.getgo_guajitele()) {
/*  262 */         _pc.setgo_guajitele(false);
/*  263 */         _pc.get_other1().set_type24(0);
/*  264 */         guaji_ai04(_pc);
/*      */       } else {
/*  266 */         _pc.setgo_guajitele(true);
/*  267 */         _pc.get_other1().set_type24(1);
/*  268 */         if (_pc.get_fwgj() > 0) {
/*  269 */           _pc.setlslocx(0);
/*  270 */           _pc.setlslocy(0);
/*  271 */           _pc.set_fwgj(0);
/*      */         } 
/*  273 */         guaji_ai04(_pc);
/*      */       } 
/*  275 */     } else if (cmd.equalsIgnoreCase("red_01")) {
/*  276 */       if (_pc.getgo_guajired()) {
/*  277 */         _pc.setgo_guajired(false);
/*  278 */         _pc.get_other1().set_type25(0);
/*  279 */         guaji_ai04(_pc);
/*      */       } else {
/*  281 */         _pc.setgo_guajired(true);
/*  282 */         _pc.get_other1().set_type25(1);
/*  283 */         guaji_ai04(_pc);
/*      */       } 
/*  285 */     } else if (cmd.equalsIgnoreCase("moliang_01")) {
/*  286 */       _pc.setma1(_pc.getma1() + 5);
/*  287 */       guaji_ai01(_pc);
/*  288 */     } else if (cmd.equalsIgnoreCase("moliang_02")) {
/*  289 */       _pc.setma1(_pc.getma1() - 5);
/*  290 */       guaji_ai01(_pc);
/*  291 */     } else if (cmd.equalsIgnoreCase("attacktel_01")) {
/*  292 */       if (_pc.IsAttackTeleport()) {
/*  293 */         _pc.setIsAttackTeleport(false);
/*  294 */         _pc.get_other1().set_type12(0);
/*      */       } else {
/*  296 */         _pc.setIsAttackTeleport(true);
/*  297 */         _pc.get_other1().set_type12(1);
/*      */       } 
/*  299 */       guaji_ai04(_pc);
/*  300 */     } else if (cmd.equalsIgnoreCase("attacktel_02")) {
/*  301 */       if (_pc.IsEnemyTeleport()) {
/*  302 */         _pc.setIsEnemyTeleport(false);
/*  303 */         _pc.get_other1().set_type13(0);
/*      */       } else {
/*  305 */         _pc.setIsEnemyTeleport(true);
/*  306 */         _pc.get_other1().set_type13(1);
/*      */       } 
/*  308 */       guaji_ai04(_pc);
/*  309 */     } else if (cmd.equalsIgnoreCase("attacktel_03")) {
/*  310 */       _pc.setKeyInEnemy(true);
/*  311 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU請輸入玩家名稱。"));
/*  312 */     } else if (cmd.equalsIgnoreCase("attacktel_04")) {
/*  313 */       _pc.setKeyOutEnemy(true);
/*  314 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU請輸入玩家名稱。"));
/*  315 */     } else if (cmd.equalsIgnoreCase("attacktel_05")) {
/*  316 */       EnemyList(_pc);
/*  317 */     } else if (cmd.equalsIgnoreCase("attacktel_06")) {
/*  318 */       NewAutoPractice.get().SearchAutoLog(_pc);
/*  319 */     } else if (cmd.equalsIgnoreCase("skill_05")) {
/*  320 */       CanSkillList(_pc, 2);
/*  321 */     } else if (cmd.equalsIgnoreCase("skill_04")) {
/*  322 */       SkillList(_pc, 2);
/*  323 */     } else if (cmd.equalsIgnoreCase("skill_01")) {
/*  324 */       if (_pc.IsAttackSkill()) {
/*  325 */         _pc.setAttackSkill(false);
/*  326 */         _pc.sendPackets((ServerBasePacket)new S_SystemMessage("取消登錄自動執行[攻擊]技能"));
/*      */       } else {
/*  328 */         _pc.setAttackSkill(true);
/*  329 */         _pc.sendPackets((ServerBasePacket)new S_SystemMessage("請手動施放一次欲新增的攻擊技能"));
/*      */       } 
/*  331 */     } else if (cmd.equalsIgnoreCase("skill_02")) {
/*  332 */       NewAutoPractice.get().ClearAutoLog(_pc.getId());
/*  333 */       _pc.sendPackets((ServerBasePacket)new S_CloseList(_pc.getId()));
/*  334 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU紀錄已刪除。"));
/*  335 */     } else if (cmd.equalsIgnoreCase("skill_03")) {
/*  336 */       _pc.clearAttackSkillList();
/*  337 */       if (_pc.get_other1().get_type46() > 0) {
/*  338 */         _pc.get_other1().set_type46(0);
/*      */       }
/*  340 */       if (_pc.get_other1().get_type47() > 0) {
/*  341 */         _pc.get_other1().set_type47(0);
/*      */       }
/*  343 */       if (_pc.get_other1().get_type48() > 0) {
/*  344 */         _pc.get_other1().set_type48(0);
/*      */       }
/*  346 */       if (_pc.get_other1().get_type49() > 0) {
/*  347 */         _pc.get_other1().set_type49(0);
/*      */       }
/*  349 */       if (_pc.get_other1().get_type50() > 0) {
/*  350 */         _pc.get_other1().set_type50(0);
/*      */       }
/*  352 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU紀錄已刪除。"));
/*  353 */     } else if (cmd.equalsIgnoreCase("Au_60")) {
/*  354 */       if (_pc.getmobatk()) {
/*  355 */         _pc.setmobatk(false);
/*      */       } else {
/*  357 */         _pc.setmobatk(true);
/*      */       } 
/*  359 */       guaji(_pc);
/*  360 */     } else if (cmd.equalsIgnoreCase("summon_01")) {
/*  361 */       if (!CharSkillReading.get().spellCheck(_pc.getId(), 51)) {
/*  362 */         _pc.sendPackets((ServerBasePacket)new S_SystemMessage("您尚未學習召喚術"));
/*  363 */         return false;
/*      */       } 
/*  365 */       if (_pc.getInventory().checkEquipped(20284) && _pc.getSummon_npcid() == null) {
/*  366 */         _pc.sendPackets((ServerBasePacket)new S_SystemMessage("攜帶召戒,請先設定要召喚的怪物"));
/*  367 */         return false;
/*      */       } 
/*  369 */       if (_pc.getchecksummid()) {
/*  370 */         _pc.setchecksummid(false);
/*      */       } else {
/*  372 */         _pc.setchecksummid(true);
/*      */       } 
/*  374 */       guaji_ai02(_pc);
/*  375 */     } else if (cmd.equalsIgnoreCase("summon_02")) {
/*  376 */       if (_pc.getsummon_skillid() == 1) {
/*  377 */         if (!CharSkillReading.get().spellCheck(_pc.getId(), 19)) {
/*  378 */           _pc.sendPackets((ServerBasePacket)new S_SystemMessage("您尚未學習中治"));
/*  379 */           return false;
/*      */         } 
/*  381 */         _pc.setsummon_skillid(19);
/*  382 */         _pc.setsummon_skillidmp(15);
/*  383 */       } else if (_pc.getsummon_skillid() == 19) {
/*  384 */         if (!CharSkillReading.get().spellCheck(_pc.getId(), 35)) {
/*  385 */           _pc.sendPackets((ServerBasePacket)new S_SystemMessage("您尚未學習高治"));
/*  386 */           return false;
/*      */         } 
/*  388 */         _pc.setsummon_skillid(35);
/*  389 */         _pc.setsummon_skillidmp(20);
/*  390 */       } else if (_pc.getsummon_skillid() == 35) {
/*  391 */         if (!CharSkillReading.get().spellCheck(_pc.getId(), 57)) {
/*  392 */           _pc.sendPackets((ServerBasePacket)new S_SystemMessage("您尚未學習全治"));
/*  393 */           return false;
/*      */         } 
/*  395 */         _pc.setsummon_skillid(57);
/*  396 */         _pc.setsummon_skillidmp(48);
/*  397 */       } else if (_pc.getsummon_skillid() == 57) {
/*  398 */         _pc.setsummon_skillid(1);
/*  399 */         _pc.setsummon_skillidmp(4);
/*  400 */       } else if (_pc.getsummon_skillid() == 0) {
/*  401 */         if (!CharSkillReading.get().spellCheck(_pc.getId(), 1)) {
/*  402 */           _pc.sendPackets((ServerBasePacket)new S_SystemMessage("您尚未學習初治"));
/*  403 */           return false;
/*      */         } 
/*  405 */         _pc.setsummon_skillid(1);
/*  406 */         _pc.setsummon_skillidmp(4);
/*      */       } 
/*  408 */       guaji_ai02(_pc);
/*  409 */     } else if (cmd.equalsIgnoreCase("summon_03")) {
/*  410 */       if (_pc.getchecksummidhp()) {
/*  411 */         _pc.setchecksummidhp(false);
/*      */       } else {
/*  413 */         _pc.setchecksummidhp(true);
/*      */       } 
/*  415 */       guaji_ai02(_pc);
/*  416 */     } else if (cmd.equalsIgnoreCase("summon_04")) {
/*  417 */       if (!_pc.getInventory().checkEquipped(20284)) {
/*  418 */         _pc.sendPackets((ServerBasePacket)new S_SystemMessage("未裝備[召喚控制戒指]"));
/*  419 */         return false;
/*      */       } 
/*  421 */       _pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(_pc.getId(), "guajisummon"));
/*  422 */     } else if (cmd.equalsIgnoreCase("sum_7")) {
/*  423 */       _pc.setSummon_npcid("7");
/*  424 */       guaji_ai02(_pc);
/*  425 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  426 */     } else if (cmd.equalsIgnoreCase("sum_263")) {
/*  427 */       _pc.setSummon_npcid("263");
/*  428 */       guaji_ai02(_pc);
/*  429 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  430 */     } else if (cmd.equalsIgnoreCase("sum_519")) {
/*  431 */       _pc.setSummon_npcid("519");
/*  432 */       guaji_ai02(_pc);
/*  433 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  434 */     } else if (cmd.equalsIgnoreCase("sum_8")) {
/*  435 */       _pc.setSummon_npcid("8");
/*  436 */       guaji_ai02(_pc);
/*  437 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  438 */     } else if (cmd.equalsIgnoreCase("sum_264")) {
/*  439 */       _pc.setSummon_npcid("264");
/*  440 */       guaji_ai02(_pc);
/*  441 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  442 */     } else if (cmd.equalsIgnoreCase("sum_520")) {
/*  443 */       _pc.setSummon_npcid("520");
/*  444 */       guaji_ai02(_pc);
/*  445 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  446 */     } else if (cmd.equalsIgnoreCase("sum_9")) {
/*  447 */       _pc.setSummon_npcid("9");
/*  448 */       guaji_ai02(_pc);
/*  449 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  450 */     } else if (cmd.equalsIgnoreCase("sum_265")) {
/*  451 */       _pc.setSummon_npcid("265");
/*  452 */       guaji_ai02(_pc);
/*  453 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  454 */     } else if (cmd.equalsIgnoreCase("sum_521")) {
/*  455 */       _pc.setSummon_npcid("521");
/*  456 */       guaji_ai02(_pc);
/*  457 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  458 */     } else if (cmd.equalsIgnoreCase("sum_10")) {
/*  459 */       _pc.setSummon_npcid("10");
/*  460 */       guaji_ai02(_pc);
/*  461 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  462 */     } else if (cmd.equalsIgnoreCase("sum_266")) {
/*  463 */       _pc.setSummon_npcid("266");
/*  464 */       guaji_ai02(_pc);
/*  465 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  466 */     } else if (cmd.equalsIgnoreCase("sum_522")) {
/*  467 */       _pc.setSummon_npcid("522");
/*  468 */       guaji_ai02(_pc);
/*  469 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  470 */     } else if (cmd.equalsIgnoreCase("sum_11")) {
/*  471 */       _pc.setSummon_npcid("11");
/*  472 */       guaji_ai02(_pc);
/*  473 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  474 */     } else if (cmd.equalsIgnoreCase("sum_267")) {
/*  475 */       _pc.setSummon_npcid("267");
/*  476 */       guaji_ai02(_pc);
/*  477 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  478 */     } else if (cmd.equalsIgnoreCase("sum_523")) {
/*  479 */       _pc.setSummon_npcid("523");
/*  480 */       guaji_ai02(_pc);
/*  481 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  482 */     } else if (cmd.equalsIgnoreCase("sum_12")) {
/*  483 */       _pc.setSummon_npcid("12");
/*  484 */       guaji_ai02(_pc);
/*  485 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  486 */     } else if (cmd.equalsIgnoreCase("sum_268")) {
/*  487 */       _pc.setSummon_npcid("268");
/*  488 */       guaji_ai02(_pc);
/*  489 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  490 */     } else if (cmd.equalsIgnoreCase("sum_524")) {
/*  491 */       _pc.setSummon_npcid("524");
/*  492 */       guaji_ai02(_pc);
/*  493 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  494 */     } else if (cmd.equalsIgnoreCase("sum_13")) {
/*  495 */       _pc.setSummon_npcid("13");
/*  496 */       guaji_ai02(_pc);
/*  497 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  498 */     } else if (cmd.equalsIgnoreCase("sum_269")) {
/*  499 */       _pc.setSummon_npcid("269");
/*  500 */       guaji_ai02(_pc);
/*  501 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  502 */     } else if (cmd.equalsIgnoreCase("sum_525")) {
/*  503 */       _pc.setSummon_npcid("525");
/*  504 */       guaji_ai02(_pc);
/*  505 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  506 */     } else if (cmd.equalsIgnoreCase("sum_14")) {
/*  507 */       _pc.setSummon_npcid("14");
/*  508 */       guaji_ai02(_pc);
/*  509 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  510 */     } else if (cmd.equalsIgnoreCase("sum_270")) {
/*  511 */       _pc.setSummon_npcid("270");
/*  512 */       guaji_ai02(_pc);
/*  513 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  514 */     } else if (cmd.equalsIgnoreCase("sum_526")) {
/*  515 */       _pc.setSummon_npcid("526");
/*  516 */       guaji_ai02(_pc);
/*  517 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  518 */     } else if (cmd.equalsIgnoreCase("sum_15")) {
/*  519 */       _pc.setSummon_npcid("15");
/*  520 */       guaji_ai02(_pc);
/*  521 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  522 */     } else if (cmd.equalsIgnoreCase("sum_271")) {
/*  523 */       _pc.setSummon_npcid("271");
/*  524 */       guaji_ai02(_pc);
/*  525 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  526 */     } else if (cmd.equalsIgnoreCase("sum_527")) {
/*  527 */       _pc.setSummon_npcid("527");
/*  528 */       guaji_ai02(_pc);
/*  529 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  530 */     } else if (cmd.equalsIgnoreCase("sum_16")) {
/*  531 */       _pc.setSummon_npcid("16");
/*  532 */       guaji_ai02(_pc);
/*  533 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  534 */     } else if (cmd.equalsIgnoreCase("sum_17")) {
/*  535 */       _pc.setSummon_npcid("17");
/*  536 */       guaji_ai02(_pc);
/*  537 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*  538 */     } else if (cmd.equalsIgnoreCase("sum_18")) {
/*  539 */       _pc.setSummon_npcid("18");
/*  540 */       guaji_ai02(_pc);
/*  541 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*      */     } else {
/*  543 */       if (!cmd.equalsIgnoreCase("sum_274")) {
/*  544 */         return false;
/*      */       }
/*  546 */       _pc.setSummon_npcid("274");
/*  547 */       guaji_ai02(_pc);
/*  548 */       _pc.sendPackets((ServerBasePacket)new S_ServerMessage("\\fU設定召戒召喚怪物完成。"));
/*      */     } 
/*  550 */     return true;
/*      */   }
/*      */   
/*      */   public void CanSkillList(L1PcInstance pc, int mode) {
/*  554 */     StringBuilder msg = new StringBuilder();
/*  555 */     if (mode == 1) {
/*  556 */       int i = 0;
/*  557 */       while (i < _autoskill_buff.length) {
/*  558 */         if (CharSkillReading.get().spellCheck(pc.getId(), _autoskill_buff[i])) {
/*  559 */           L1Skills skill = SkillsTable.get().getTemplate(_autoskill_buff[i]);
/*  560 */           msg.append(String.valueOf(String.valueOf(skill.getName())) + ",");
/*      */         } 
/*  562 */         i++;
/*      */       } 
/*      */     } else {
/*  565 */       int i = 0;
/*  566 */       while (i < _autoskill_attack.length) {
/*  567 */         if (CharSkillReading.get().spellCheck(pc.getId(), _autoskill_attack[i])) {
/*  568 */           L1Skills skill = SkillsTable.get().getTemplate(_autoskill_attack[i]);
/*  569 */           msg.append(String.valueOf(String.valueOf(skill.getName())) + ",");
/*      */         } 
/*  571 */         i++;
/*      */       } 
/*      */     } 
/*  574 */     String[] clientStrAry = msg.toString().split(",");
/*  575 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "x_autolist3", clientStrAry));
/*      */   }
/*      */   
/*      */   public void SkillList(L1PcInstance pc, int mode) {
/*  579 */     StringBuilder msg = new StringBuilder();
/*  580 */     if (mode == 1) {
/*  581 */       Iterator<Integer> iterator = pc.BuffSkillList().iterator();
/*  582 */       while (iterator.hasNext()) {
/*  583 */         Integer id = iterator.next();
/*  584 */         L1Skills skill = SkillsTable.get().getTemplate(id.intValue());
/*  585 */         msg.append(String.valueOf(String.valueOf(skill.getName())) + ",");
/*      */       } 
/*      */     } else {
/*  588 */       Iterator<Integer> iterator2 = pc.AttackSkillList().iterator();
/*  589 */       while (iterator2.hasNext()) {
/*  590 */         Integer id = iterator2.next();
/*  591 */         L1Skills skill = SkillsTable.get().getTemplate(id.intValue());
/*  592 */         msg.append(String.valueOf(String.valueOf(skill.getName())) + ",");
/*      */       } 
/*      */     } 
/*  595 */     String[] clientStrAry = msg.toString().split(",");
/*  596 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "x_autolist3", clientStrAry));
/*      */   }
/*      */   
/*      */   public void EnemyList(L1PcInstance pc) {
/*  600 */     StringBuilder msg = new StringBuilder();
/*  601 */     Iterator<String> iterator = pc.InEnemyList().iterator();
/*  602 */     while (iterator.hasNext()) {
/*  603 */       String name = iterator.next();
/*  604 */       msg.append(String.valueOf(String.valueOf(name)) + ",");
/*      */     } 
/*  606 */     String[] clientStrAry = msg.toString().split(",");
/*  607 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "x_autolist2", clientStrAry));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isBuffSkill(int Skillid) {
/*  612 */     int autoskill_buff[], length = (autoskill_buff = _autoskill_buff).length;
/*  613 */     int i = 0;
/*  614 */     while (i < length) {
/*  615 */       int skillId = autoskill_buff[i];
/*  616 */       if (skillId == Skillid) {
/*  617 */         return true;
/*      */       }
/*  619 */       i++;
/*      */     } 
/*  621 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isAttackSkill(int Skillid) {
/*  626 */     int autoskill_attack[], length = (autoskill_attack = _autoskill_attack).length;
/*  627 */     int i = 0;
/*  628 */     while (i < length) {
/*  629 */       int skillId = autoskill_attack[i];
/*  630 */       if (skillId == Skillid) {
/*  631 */         return true;
/*      */       }
/*  633 */       i++;
/*      */     } 
/*  635 */     return false;
/*      */   }
/*      */   
/*      */   public void guaji_ai01(L1PcInstance pc) {
/*  639 */     String type1 = "";
/*  640 */     String type2 = "";
/*  641 */     String type3 = "";
/*  642 */     String type4 = "";
/*  643 */     String type5 = "";
/*  644 */     String type6 = "";
/*  645 */     String type7 = "";
/*  646 */     String type8 = "";
/*  647 */     String type9 = "";
/*  648 */     String type10 = "";
/*  649 */     String type11 = "";
/*  650 */     String type12 = "";
/*  651 */     String type13 = "";
/*  652 */     String type14 = "";
/*  653 */     String type15 = "";
/*  654 */     String type16 = "";
/*  655 */     String type17 = "";
/*  656 */     int time = pc.get_other().get_Auto_Points();
/*  657 */     if (time > 0) {
/*  658 */       type17 = String.valueOf(time / 60) + "分鐘";
/*      */     } else {
/*  660 */       type17 = "0";
/*      */     } 
/*      */     
/*  663 */     if (pc.get_fwgj() > 0) {
/*  664 */       int i = pc.get_fwgj();
/*      */     } else {
/*  666 */       type1 = "0";
/*      */     } 
/*  668 */     if (pc.getitempotion() > 0) {
/*  669 */       if (pc.getitempotion() == 1) {
/*  670 */         type2 = "紅色藥水";
/*  671 */       } else if (pc.getitempotion() == 2) {
/*  672 */         type2 = "橙色藥水";
/*  673 */       } else if (pc.getitempotion() == 3) {
/*  674 */         type2 = "白色藥水";
/*  675 */       } else if (pc.getitempotion() == 4) {
/*  676 */         type2 = "濃縮紅水";
/*  677 */       } else if (pc.getitempotion() == 5) {
/*  678 */         type2 = "濃縮橙水";
/*  679 */       } else if (pc.getitempotion() == 6) {
/*  680 */         type2 = "濃縮白水";
/*  681 */       } else if (pc.getitempotion() == 7) {
/*  682 */         type2 = "古代紅水";
/*  683 */       } else if (pc.getitempotion() == 8) {
/*  684 */         type2 = "古代橙水";
/*  685 */       } else if (pc.getitempotion() == 9) {
/*  686 */         type2 = "古代白水";
/*      */       } 
/*      */     } else {
/*  689 */       type2 = "尚未設定";
/*      */     } 
/*  691 */     if (pc.getpotioncount() > 0) {
/*  692 */       int i = pc.getpotioncount();
/*      */     } else {
/*  694 */       type3 = "0";
/*      */     } 
/*  696 */     if (pc.getitempotion1() > 0) {
/*  697 */       if (pc.getitempotion1() == 1) {
/*  698 */         type4 = "紅色藥水";
/*  699 */       } else if (pc.getitempotion1() == 2) {
/*  700 */         type4 = "橙色藥水";
/*  701 */       } else if (pc.getitempotion1() == 3) {
/*  702 */         type4 = "白色藥水";
/*  703 */       } else if (pc.getitempotion1() == 4) {
/*  704 */         type4 = "濃縮紅水";
/*  705 */       } else if (pc.getitempotion1() == 5) {
/*  706 */         type4 = "濃縮橙水";
/*  707 */       } else if (pc.getitempotion1() == 6) {
/*  708 */         type4 = "濃縮白水";
/*  709 */       } else if (pc.getitempotion1() == 7) {
/*  710 */         type4 = "古代紅水";
/*  711 */       } else if (pc.getitempotion1() == 8) {
/*  712 */         type4 = "古代橙水";
/*  713 */       } else if (pc.getitempotion1() == 9) {
/*  714 */         type4 = "古代白水";
/*      */       } 
/*      */     } else {
/*  717 */       type4 = "尚未設定";
/*      */     } 
/*  719 */     if (pc.getpotioncount1() > 0) {
/*  720 */       int i = pc.getpotioncount1();
/*      */     } else {
/*  722 */       type5 = "0";
/*      */     } 
/*  724 */     if (pc.getitempotion2() > 0) {
/*  725 */       if (pc.getitempotion2() == 1) {
/*  726 */         type6 = "箭";
/*  727 */       } else if (pc.getitempotion2() == 2) {
/*  728 */         type6 = "銀箭";
/*      */       } 
/*  730 */     } else if (pc.getitempotion2() == 0) {
/*  731 */       type6 = "尚未設定";
/*      */     } 
/*  733 */     if (pc.getpotioncount2() > 0) {
/*  734 */       int i = pc.getpotioncount2();
/*      */     } else {
/*  736 */       type7 = "0";
/*      */     } 
/*  738 */     if (pc.getgo_guajitele()) {
/*  739 */       type8 = "[開啟]";
/*      */     } else {
/*  741 */       type8 = "[關閉]";
/*      */     } 
/*  743 */     if (pc.getgo_guajired()) {
/*  744 */       type9 = "[開啟]";
/*      */     } else {
/*  746 */       type9 = "[關閉]";
/*      */     } 
/*  748 */     if (pc.IsAttackTeleport()) {
/*  749 */       type10 = "[開啟]";
/*      */     } else {
/*  751 */       type10 = "[關閉]";
/*      */     } 
/*  753 */     if (pc.IsEnemyTeleport()) {
/*  754 */       type11 = "[開啟]";
/*      */     } else {
/*  756 */       type11 = "[關閉]";
/*      */     } 
/*  758 */     if (pc.getma1() > 0) {
/*  759 */       int i = pc.getma1();
/*      */     } else {
/*  761 */       type12 = "未設置";
/*      */     } 
/*  763 */     if (pc.getchecksummid()) {
/*  764 */       type13 = "[開啟]";
/*      */     } else {
/*  766 */       type13 = "[關閉]";
/*      */     } 
/*  768 */     if (pc.getsummon_skillid() > 0) {
/*  769 */       if (pc.getsummon_skillid() == 1) {
/*  770 */         type14 = "[初治癒]";
/*  771 */       } else if (pc.getsummon_skillid() == 19) {
/*  772 */         type14 = "[中治癒]";
/*  773 */       } else if (pc.getsummon_skillid() == 35) {
/*  774 */         type14 = "[高治癒]";
/*  775 */       } else if (pc.getsummon_skillid() == 57) {
/*  776 */         type14 = "[全治癒]";
/*      */       } 
/*      */     } else {
/*  779 */       type14 = "[尚未設置]";
/*      */     } 
/*  781 */     if (pc.getchecksummidhp()) {
/*  782 */       type15 = "[開啟]";
/*      */     } else {
/*  784 */       type15 = "[關閉]";
/*      */     } 
/*  786 */     if (pc.getmobatk()) {
/*  787 */       type16 = "[開啟]";
/*      */     } else {
/*  789 */       type16 = "[關閉]";
/*      */     } 
/*  791 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "guaiji", new String[] { type1, type2, type3, type4, type5, type6, 
/*  792 */             type7, type8, type9, type10, type11, type12, type13, type14, type15, type16, type17 }));
/*      */   }
/*      */   
/*      */   public void guaji_ai02(L1PcInstance pc) {
/*  796 */     String type1 = "";
/*  797 */     String type2 = "";
/*  798 */     String type3 = "";
/*  799 */     String type4 = "";
/*  800 */     String type5 = "";
/*  801 */     String type6 = "";
/*  802 */     String type7 = "";
/*  803 */     String type8 = "";
/*  804 */     String type9 = "";
/*  805 */     String type10 = "";
/*  806 */     String type11 = "";
/*  807 */     String type12 = "";
/*  808 */     String type13 = "";
/*  809 */     String type14 = "";
/*  810 */     String type15 = "";
/*  811 */     String type16 = "";
/*  812 */     String type17 = "";
/*  813 */     int time = pc.get_other().get_Auto_Points();
/*  814 */     if (time > 0) {
/*  815 */       type17 = String.valueOf(time / 60) + "分鐘";
/*      */     } else {
/*  817 */       type17 = "0";
/*      */     } 
/*  819 */     if (pc.get_fwgj() > 0) {
/*  820 */       int i = pc.get_fwgj();
/*      */     } else {
/*  822 */       type1 = "0";
/*      */     } 
/*  824 */     if (pc.getitempotion() > 0) {
/*  825 */       if (pc.getitempotion() == 1) {
/*  826 */         type2 = "紅色藥水";
/*  827 */       } else if (pc.getitempotion() == 2) {
/*  828 */         type2 = "橙色藥水";
/*  829 */       } else if (pc.getitempotion() == 3) {
/*  830 */         type2 = "白色藥水";
/*  831 */       } else if (pc.getitempotion() == 4) {
/*  832 */         type2 = "濃縮紅水";
/*  833 */       } else if (pc.getitempotion() == 5) {
/*  834 */         type2 = "濃縮橙水";
/*  835 */       } else if (pc.getitempotion() == 6) {
/*  836 */         type2 = "濃縮白水";
/*  837 */       } else if (pc.getitempotion() == 7) {
/*  838 */         type2 = "古代紅水";
/*  839 */       } else if (pc.getitempotion() == 8) {
/*  840 */         type2 = "古代橙水";
/*  841 */       } else if (pc.getitempotion() == 9) {
/*  842 */         type2 = "古代白水";
/*      */       } 
/*      */     } else {
/*  845 */       type2 = "尚未設定";
/*      */     } 
/*  847 */     if (pc.getpotioncount() > 0) {
/*  848 */       int i = pc.getpotioncount();
/*      */     } else {
/*  850 */       type3 = "0";
/*      */     } 
/*  852 */     if (pc.getitempotion1() > 0) {
/*  853 */       if (pc.getitempotion1() == 1) {
/*  854 */         type4 = "紅色藥水";
/*  855 */       } else if (pc.getitempotion1() == 2) {
/*  856 */         type4 = "橙色藥水";
/*  857 */       } else if (pc.getitempotion1() == 3) {
/*  858 */         type4 = "白色藥水";
/*  859 */       } else if (pc.getitempotion1() == 4) {
/*  860 */         type4 = "濃縮紅水";
/*  861 */       } else if (pc.getitempotion1() == 5) {
/*  862 */         type4 = "濃縮橙水";
/*  863 */       } else if (pc.getitempotion1() == 6) {
/*  864 */         type4 = "濃縮白水";
/*  865 */       } else if (pc.getitempotion1() == 7) {
/*  866 */         type4 = "古代紅水";
/*  867 */       } else if (pc.getitempotion1() == 8) {
/*  868 */         type4 = "古代橙水";
/*  869 */       } else if (pc.getitempotion1() == 9) {
/*  870 */         type4 = "古代白水";
/*      */       } 
/*      */     } else {
/*  873 */       type4 = "尚未設定";
/*      */     } 
/*  875 */     if (pc.getpotioncount1() > 0) {
/*  876 */       int i = pc.getpotioncount1();
/*      */     } else {
/*  878 */       type5 = "0";
/*      */     } 
/*  880 */     if (pc.getitempotion2() > 0) {
/*  881 */       if (pc.getitempotion2() == 1) {
/*  882 */         type6 = "箭";
/*  883 */       } else if (pc.getitempotion2() == 2) {
/*  884 */         type6 = "銀箭";
/*      */       } 
/*  886 */     } else if (pc.getitempotion2() == 0) {
/*  887 */       type6 = "尚未設定";
/*      */     } 
/*  889 */     if (pc.getpotioncount2() > 0) {
/*  890 */       int i = pc.getpotioncount2();
/*      */     } else {
/*  892 */       type7 = "0";
/*      */     } 
/*  894 */     if (pc.getgo_guajitele()) {
/*  895 */       type8 = "[開啟]";
/*      */     } else {
/*  897 */       type8 = "[關閉]";
/*      */     } 
/*  899 */     if (pc.getgo_guajired()) {
/*  900 */       type9 = "[開啟]";
/*      */     } else {
/*  902 */       type9 = "[關閉]";
/*      */     } 
/*  904 */     if (pc.IsAttackTeleport()) {
/*  905 */       type10 = "[開啟]";
/*      */     } else {
/*  907 */       type10 = "[關閉]";
/*      */     } 
/*  909 */     if (pc.IsEnemyTeleport()) {
/*  910 */       type11 = "[開啟]";
/*      */     } else {
/*  912 */       type11 = "[關閉]";
/*      */     } 
/*  914 */     if (pc.getma1() > 0) {
/*  915 */       int i = pc.getma1();
/*      */     } else {
/*  917 */       type12 = "未設置";
/*      */     } 
/*  919 */     if (pc.getchecksummid()) {
/*  920 */       type13 = "[開啟]";
/*      */     } else {
/*  922 */       type13 = "[關閉]";
/*      */     } 
/*  924 */     if (pc.getsummon_skillid() > 0) {
/*  925 */       if (pc.getsummon_skillid() == 1) {
/*  926 */         type14 = "[初治癒]";
/*  927 */       } else if (pc.getsummon_skillid() == 19) {
/*  928 */         type14 = "[中治癒]";
/*  929 */       } else if (pc.getsummon_skillid() == 35) {
/*  930 */         type14 = "[高治癒]";
/*  931 */       } else if (pc.getsummon_skillid() == 57) {
/*  932 */         type14 = "[全治癒]";
/*      */       } 
/*      */     } else {
/*  935 */       type14 = "[尚未設置]";
/*      */     } 
/*  937 */     if (pc.getchecksummidhp()) {
/*  938 */       type15 = "[開啟]";
/*      */     } else {
/*  940 */       type15 = "[關閉]";
/*      */     } 
/*  942 */     if (pc.getmobatk()) {
/*  943 */       type16 = "[開啟]";
/*      */     } else {
/*  945 */       type16 = "[關閉]";
/*      */     } 
/*  947 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "guaiji", new String[] { type1, type2, type3, type4, type5, type6, 
/*  948 */             type7, type8, type9, type10, type11, type12, type13, type14, type15, type16, type17 }));
/*      */   }
/*      */   
/*      */   public void guaji_ai03(L1PcInstance pc) {
/*  952 */     String type1 = "";
/*  953 */     String type2 = "";
/*  954 */     String type3 = "";
/*  955 */     String type4 = "";
/*  956 */     String type5 = "";
/*  957 */     String type6 = "";
/*  958 */     String type7 = "";
/*  959 */     String type8 = "";
/*  960 */     String type9 = "";
/*  961 */     String type10 = "";
/*  962 */     String type11 = "";
/*  963 */     String type12 = "";
/*  964 */     String type13 = "";
/*  965 */     String type14 = "";
/*  966 */     String type15 = "";
/*  967 */     String type16 = "";
/*  968 */     String type17 = "";
/*  969 */     int time = pc.get_other().get_Auto_Points();
/*  970 */     if (time > 0) {
/*  971 */       type17 = String.valueOf(time / 60) + "分鐘";
/*      */     } else {
/*  973 */       type17 = "0";
/*      */     } 
/*  975 */     if (pc.get_fwgj() > 0) {
/*  976 */       int i = pc.get_fwgj();
/*      */     } else {
/*  978 */       type1 = "0";
/*      */     } 
/*  980 */     if (pc.getitempotion() > 0) {
/*  981 */       if (pc.getitempotion() == 1) {
/*  982 */         type2 = "紅色藥水";
/*  983 */       } else if (pc.getitempotion() == 2) {
/*  984 */         type2 = "橙色藥水";
/*  985 */       } else if (pc.getitempotion() == 3) {
/*  986 */         type2 = "白色藥水";
/*  987 */       } else if (pc.getitempotion() == 4) {
/*  988 */         type2 = "濃縮紅水";
/*  989 */       } else if (pc.getitempotion() == 5) {
/*  990 */         type2 = "濃縮橙水";
/*  991 */       } else if (pc.getitempotion() == 6) {
/*  992 */         type2 = "濃縮白水";
/*  993 */       } else if (pc.getitempotion() == 7) {
/*  994 */         type2 = "古代紅水";
/*  995 */       } else if (pc.getitempotion() == 8) {
/*  996 */         type2 = "古代橙水";
/*  997 */       } else if (pc.getitempotion() == 9) {
/*  998 */         type2 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1001 */       type2 = "尚未設定";
/*      */     } 
/* 1003 */     if (pc.getpotioncount() > 0) {
/* 1004 */       int i = pc.getpotioncount();
/*      */     } else {
/* 1006 */       type3 = "0";
/*      */     } 
/* 1008 */     if (pc.getitempotion1() > 0) {
/* 1009 */       if (pc.getitempotion1() == 1) {
/* 1010 */         type4 = "紅色藥水";
/* 1011 */       } else if (pc.getitempotion1() == 2) {
/* 1012 */         type4 = "橙色藥水";
/* 1013 */       } else if (pc.getitempotion1() == 3) {
/* 1014 */         type4 = "白色藥水";
/* 1015 */       } else if (pc.getitempotion1() == 4) {
/* 1016 */         type4 = "濃縮紅水";
/* 1017 */       } else if (pc.getitempotion1() == 5) {
/* 1018 */         type4 = "濃縮橙水";
/* 1019 */       } else if (pc.getitempotion1() == 6) {
/* 1020 */         type4 = "濃縮白水";
/* 1021 */       } else if (pc.getitempotion1() == 7) {
/* 1022 */         type4 = "古代紅水";
/* 1023 */       } else if (pc.getitempotion1() == 8) {
/* 1024 */         type4 = "古代橙水";
/* 1025 */       } else if (pc.getitempotion1() == 9) {
/* 1026 */         type4 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1029 */       type4 = "尚未設定";
/*      */     } 
/* 1031 */     if (pc.getpotioncount1() > 0) {
/* 1032 */       int i = pc.getpotioncount1();
/*      */     } else {
/* 1034 */       type5 = "0";
/*      */     } 
/* 1036 */     if (pc.getitempotion2() > 0) {
/* 1037 */       if (pc.getitempotion2() == 1) {
/* 1038 */         type6 = "箭";
/* 1039 */       } else if (pc.getitempotion2() == 2) {
/* 1040 */         type6 = "銀箭";
/*      */       } 
/* 1042 */     } else if (pc.getitempotion2() == 0) {
/* 1043 */       type6 = "尚未設定";
/*      */     } 
/* 1045 */     if (pc.getpotioncount2() > 0) {
/* 1046 */       int i = pc.getpotioncount2();
/*      */     } else {
/* 1048 */       type7 = "0";
/*      */     } 
/* 1050 */     if (pc.getgo_guajitele()) {
/* 1051 */       type8 = "[開啟]";
/*      */     } else {
/* 1053 */       type8 = "[關閉]";
/*      */     } 
/* 1055 */     if (pc.getgo_guajired()) {
/* 1056 */       type9 = "[開啟]";
/*      */     } else {
/* 1058 */       type9 = "[關閉]";
/*      */     } 
/* 1060 */     if (pc.IsAttackTeleport()) {
/* 1061 */       type10 = "[開啟]";
/*      */     } else {
/* 1063 */       type10 = "[關閉]";
/*      */     } 
/* 1065 */     if (pc.IsEnemyTeleport()) {
/* 1066 */       type11 = "[開啟]";
/*      */     } else {
/* 1068 */       type11 = "[關閉]";
/*      */     } 
/* 1070 */     if (pc.getma1() > 0) {
/* 1071 */       int i = pc.getma1();
/*      */     } else {
/* 1073 */       type12 = "未設置";
/*      */     } 
/* 1075 */     if (pc.getchecksummid()) {
/* 1076 */       type13 = "[開啟]";
/*      */     } else {
/* 1078 */       type13 = "[關閉]";
/*      */     } 
/* 1080 */     if (pc.getsummon_skillid() > 0) {
/* 1081 */       if (pc.getsummon_skillid() == 1) {
/* 1082 */         type14 = "[初治癒]";
/* 1083 */       } else if (pc.getsummon_skillid() == 19) {
/* 1084 */         type14 = "[中治癒]";
/* 1085 */       } else if (pc.getsummon_skillid() == 35) {
/* 1086 */         type14 = "[高治癒]";
/* 1087 */       } else if (pc.getsummon_skillid() == 57) {
/* 1088 */         type14 = "[全治癒]";
/*      */       } 
/*      */     } else {
/* 1091 */       type14 = "[尚未設置]";
/*      */     } 
/* 1093 */     if (pc.getchecksummidhp()) {
/* 1094 */       type15 = "[開啟]";
/*      */     } else {
/* 1096 */       type15 = "[關閉]";
/*      */     } 
/* 1098 */     if (pc.getmobatk()) {
/* 1099 */       type16 = "[開啟]";
/*      */     } else {
/* 1101 */       type16 = "[關閉]";
/*      */     } 
/* 1103 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "guaiji", new String[] { type1, type2, type3, type4, type5, type6, 
/* 1104 */             type7, type8, type9, type10, type11, type12, type13, type14, type15, type16, type17 }));
/*      */   }
/*      */   
/*      */   public void guaji_ai04(L1PcInstance pc) {
/* 1108 */     String type1 = "";
/* 1109 */     String type2 = "";
/* 1110 */     String type3 = "";
/* 1111 */     String type4 = "";
/* 1112 */     String type5 = "";
/* 1113 */     String type6 = "";
/* 1114 */     String type7 = "";
/* 1115 */     String type8 = "";
/* 1116 */     String type9 = "";
/* 1117 */     String type10 = "";
/* 1118 */     String type11 = "";
/* 1119 */     String type12 = "";
/* 1120 */     String type13 = "";
/* 1121 */     String type14 = "";
/* 1122 */     String type15 = "";
/* 1123 */     String type16 = "";
/* 1124 */     String type17 = "";
/* 1125 */     int time = pc.get_other().get_Auto_Points();
/* 1126 */     if (time > 0) {
/* 1127 */       type17 = String.valueOf(time / 60) + "分鐘";
/*      */     } else {
/* 1129 */       type17 = "0";
/*      */     } 
/* 1131 */     if (pc.get_fwgj() > 0) {
/* 1132 */       int i = pc.get_fwgj();
/*      */     } else {
/* 1134 */       type1 = "0";
/*      */     } 
/* 1136 */     if (pc.getitempotion() > 0) {
/* 1137 */       if (pc.getitempotion() == 1) {
/* 1138 */         type2 = "紅色藥水";
/* 1139 */       } else if (pc.getitempotion() == 2) {
/* 1140 */         type2 = "橙色藥水";
/* 1141 */       } else if (pc.getitempotion() == 3) {
/* 1142 */         type2 = "白色藥水";
/* 1143 */       } else if (pc.getitempotion() == 4) {
/* 1144 */         type2 = "濃縮紅水";
/* 1145 */       } else if (pc.getitempotion() == 5) {
/* 1146 */         type2 = "濃縮橙水";
/* 1147 */       } else if (pc.getitempotion() == 6) {
/* 1148 */         type2 = "濃縮白水";
/* 1149 */       } else if (pc.getitempotion() == 7) {
/* 1150 */         type2 = "古代紅水";
/* 1151 */       } else if (pc.getitempotion() == 8) {
/* 1152 */         type2 = "古代橙水";
/* 1153 */       } else if (pc.getitempotion() == 9) {
/* 1154 */         type2 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1157 */       type2 = "尚未設定";
/*      */     } 
/* 1159 */     if (pc.getpotioncount() > 0) {
/* 1160 */       int i = pc.getpotioncount();
/*      */     } else {
/* 1162 */       type3 = "0";
/*      */     } 
/* 1164 */     if (pc.getitempotion1() > 0) {
/* 1165 */       if (pc.getitempotion1() == 1) {
/* 1166 */         type4 = "紅色藥水";
/* 1167 */       } else if (pc.getitempotion1() == 2) {
/* 1168 */         type4 = "橙色藥水";
/* 1169 */       } else if (pc.getitempotion1() == 3) {
/* 1170 */         type4 = "白色藥水";
/* 1171 */       } else if (pc.getitempotion1() == 4) {
/* 1172 */         type4 = "濃縮紅水";
/* 1173 */       } else if (pc.getitempotion1() == 5) {
/* 1174 */         type4 = "濃縮橙水";
/* 1175 */       } else if (pc.getitempotion1() == 6) {
/* 1176 */         type4 = "濃縮白水";
/* 1177 */       } else if (pc.getitempotion1() == 7) {
/* 1178 */         type4 = "古代紅水";
/* 1179 */       } else if (pc.getitempotion1() == 8) {
/* 1180 */         type4 = "古代橙水";
/* 1181 */       } else if (pc.getitempotion1() == 9) {
/* 1182 */         type4 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1185 */       type4 = "尚未設定";
/*      */     } 
/* 1187 */     if (pc.getpotioncount1() > 0) {
/* 1188 */       int i = pc.getpotioncount1();
/*      */     } else {
/* 1190 */       type5 = "0";
/*      */     } 
/* 1192 */     if (pc.getitempotion2() > 0) {
/* 1193 */       if (pc.getitempotion2() == 1) {
/* 1194 */         type6 = "箭";
/* 1195 */       } else if (pc.getitempotion2() == 2) {
/* 1196 */         type6 = "銀箭";
/*      */       } 
/* 1198 */     } else if (pc.getitempotion2() == 0) {
/* 1199 */       type6 = "尚未設定";
/*      */     } 
/* 1201 */     if (pc.getpotioncount2() > 0) {
/* 1202 */       int i = pc.getpotioncount2();
/*      */     } else {
/* 1204 */       type7 = "0";
/*      */     } 
/* 1206 */     if (pc.getgo_guajitele()) {
/* 1207 */       type8 = "[開啟]";
/*      */     } else {
/* 1209 */       type8 = "[關閉]";
/*      */     } 
/* 1211 */     if (pc.getgo_guajired()) {
/* 1212 */       type9 = "[開啟]";
/*      */     } else {
/* 1214 */       type9 = "[關閉]";
/*      */     } 
/* 1216 */     if (pc.IsAttackTeleport()) {
/* 1217 */       type10 = "[開啟]";
/*      */     } else {
/* 1219 */       type10 = "[關閉]";
/*      */     } 
/* 1221 */     if (pc.IsEnemyTeleport()) {
/* 1222 */       type11 = "[開啟]";
/*      */     } else {
/* 1224 */       type11 = "[關閉]";
/*      */     } 
/* 1226 */     if (pc.getma1() > 0) {
/* 1227 */       int i = pc.getma1();
/*      */     } else {
/* 1229 */       type12 = "未設置";
/*      */     } 
/* 1231 */     if (pc.getchecksummid()) {
/* 1232 */       type13 = "[開啟]";
/*      */     } else {
/* 1234 */       type13 = "[關閉]";
/*      */     } 
/* 1236 */     if (pc.getsummon_skillid() > 0) {
/* 1237 */       if (pc.getsummon_skillid() == 1) {
/* 1238 */         type14 = "[初治癒]";
/* 1239 */       } else if (pc.getsummon_skillid() == 19) {
/* 1240 */         type14 = "[中治癒]";
/* 1241 */       } else if (pc.getsummon_skillid() == 35) {
/* 1242 */         type14 = "[高治癒]";
/* 1243 */       } else if (pc.getsummon_skillid() == 57) {
/* 1244 */         type14 = "[全治癒]";
/*      */       } 
/*      */     } else {
/* 1247 */       type14 = "[尚未設置]";
/*      */     } 
/* 1249 */     if (pc.getchecksummidhp()) {
/* 1250 */       type15 = "[開啟]";
/*      */     } else {
/* 1252 */       type15 = "[關閉]";
/*      */     } 
/* 1254 */     if (pc.getmobatk()) {
/* 1255 */       type16 = "[開啟]";
/*      */     } else {
/* 1257 */       type16 = "[關閉]";
/*      */     } 
/* 1259 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "guaiji", new String[] { type1, type2, type3, type4, type5, type6, 
/* 1260 */             type7, type8, type9, type10, type11, type12, type13, type14, type15, type16, type17 }));
/*      */   }
/*      */   
/*      */   public void guaji_ai05(L1PcInstance pc) {
/* 1264 */     String type1 = "";
/* 1265 */     String type2 = "";
/* 1266 */     String type3 = "";
/* 1267 */     String type4 = "";
/* 1268 */     String type5 = "";
/* 1269 */     String type6 = "";
/* 1270 */     String type7 = "";
/* 1271 */     String type8 = "";
/* 1272 */     String type9 = "";
/* 1273 */     String type10 = "";
/* 1274 */     String type11 = "";
/* 1275 */     String type12 = "";
/* 1276 */     String type13 = "";
/* 1277 */     String type14 = "";
/* 1278 */     String type15 = "";
/* 1279 */     String type16 = "";
/* 1280 */     String type17 = "";
/* 1281 */     int time = pc.get_other().get_Auto_Points();
/* 1282 */     if (time > 0) {
/* 1283 */       type17 = String.valueOf(time / 60) + "分鐘";
/*      */     } else {
/* 1285 */       type17 = "0";
/*      */     } 
/* 1287 */     if (pc.get_fwgj() > 0) {
/* 1288 */       int i = pc.get_fwgj();
/*      */     } else {
/* 1290 */       type1 = "0";
/*      */     } 
/* 1292 */     if (pc.getitempotion() > 0) {
/* 1293 */       if (pc.getitempotion() == 1) {
/* 1294 */         type2 = "紅色藥水";
/* 1295 */       } else if (pc.getitempotion() == 2) {
/* 1296 */         type2 = "橙色藥水";
/* 1297 */       } else if (pc.getitempotion() == 3) {
/* 1298 */         type2 = "白色藥水";
/* 1299 */       } else if (pc.getitempotion() == 4) {
/* 1300 */         type2 = "濃縮紅水";
/* 1301 */       } else if (pc.getitempotion() == 5) {
/* 1302 */         type2 = "濃縮橙水";
/* 1303 */       } else if (pc.getitempotion() == 6) {
/* 1304 */         type2 = "濃縮白水";
/* 1305 */       } else if (pc.getitempotion() == 7) {
/* 1306 */         type2 = "古代紅水";
/* 1307 */       } else if (pc.getitempotion() == 8) {
/* 1308 */         type2 = "古代橙水";
/* 1309 */       } else if (pc.getitempotion() == 9) {
/* 1310 */         type2 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1313 */       type2 = "尚未設定";
/*      */     } 
/* 1315 */     if (pc.getpotioncount() > 0) {
/* 1316 */       int i = pc.getpotioncount();
/*      */     } else {
/* 1318 */       type3 = "0";
/*      */     } 
/* 1320 */     if (pc.getitempotion1() > 0) {
/* 1321 */       if (pc.getitempotion1() == 1) {
/* 1322 */         type4 = "紅色藥水";
/* 1323 */       } else if (pc.getitempotion1() == 2) {
/* 1324 */         type4 = "橙色藥水";
/* 1325 */       } else if (pc.getitempotion1() == 3) {
/* 1326 */         type4 = "白色藥水";
/* 1327 */       } else if (pc.getitempotion1() == 4) {
/* 1328 */         type4 = "濃縮紅水";
/* 1329 */       } else if (pc.getitempotion1() == 5) {
/* 1330 */         type4 = "濃縮橙水";
/* 1331 */       } else if (pc.getitempotion1() == 6) {
/* 1332 */         type4 = "濃縮白水";
/* 1333 */       } else if (pc.getitempotion1() == 7) {
/* 1334 */         type4 = "古代紅水";
/* 1335 */       } else if (pc.getitempotion1() == 8) {
/* 1336 */         type4 = "古代橙水";
/* 1337 */       } else if (pc.getitempotion1() == 9) {
/* 1338 */         type4 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1341 */       type4 = "尚未設定";
/*      */     } 
/* 1343 */     if (pc.getpotioncount1() > 0) {
/* 1344 */       int i = pc.getpotioncount1();
/*      */     } else {
/* 1346 */       type5 = "0";
/*      */     } 
/* 1348 */     if (pc.getitempotion2() > 0) {
/* 1349 */       if (pc.getitempotion2() == 1) {
/* 1350 */         type6 = "箭";
/* 1351 */       } else if (pc.getitempotion2() == 2) {
/* 1352 */         type6 = "銀箭";
/*      */       } 
/* 1354 */     } else if (pc.getitempotion2() == 0) {
/* 1355 */       type6 = "尚未設定";
/*      */     } 
/* 1357 */     if (pc.getpotioncount2() > 0) {
/* 1358 */       int i = pc.getpotioncount2();
/*      */     } else {
/* 1360 */       type7 = "0";
/*      */     } 
/* 1362 */     if (pc.getgo_guajitele()) {
/* 1363 */       type8 = "[開啟]";
/*      */     } else {
/* 1365 */       type8 = "[關閉]";
/*      */     } 
/* 1367 */     if (pc.getgo_guajired()) {
/* 1368 */       type9 = "[開啟]";
/*      */     } else {
/* 1370 */       type9 = "[關閉]";
/*      */     } 
/* 1372 */     if (pc.IsAttackTeleport()) {
/* 1373 */       type10 = "[開啟]";
/*      */     } else {
/* 1375 */       type10 = "[關閉]";
/*      */     } 
/* 1377 */     if (pc.IsEnemyTeleport()) {
/* 1378 */       type11 = "[開啟]";
/*      */     } else {
/* 1380 */       type11 = "[關閉]";
/*      */     } 
/* 1382 */     if (pc.getma1() > 0) {
/* 1383 */       int i = pc.getma1();
/*      */     } else {
/* 1385 */       type12 = "未設置";
/*      */     } 
/* 1387 */     if (pc.getchecksummid()) {
/* 1388 */       type13 = "[開啟]";
/*      */     } else {
/* 1390 */       type13 = "[關閉]";
/*      */     } 
/* 1392 */     if (pc.getsummon_skillid() > 0) {
/* 1393 */       if (pc.getsummon_skillid() == 1) {
/* 1394 */         type14 = "[初治癒]";
/* 1395 */       } else if (pc.getsummon_skillid() == 19) {
/* 1396 */         type14 = "[中治癒]";
/* 1397 */       } else if (pc.getsummon_skillid() == 35) {
/* 1398 */         type14 = "[高治癒]";
/* 1399 */       } else if (pc.getsummon_skillid() == 57) {
/* 1400 */         type14 = "[全治癒]";
/*      */       } 
/*      */     } else {
/* 1403 */       type14 = "[尚未設置]";
/*      */     } 
/* 1405 */     if (pc.getchecksummidhp()) {
/* 1406 */       type15 = "[開啟]";
/*      */     } else {
/* 1408 */       type15 = "[關閉]";
/*      */     } 
/* 1410 */     if (pc.getmobatk()) {
/* 1411 */       type16 = "[開啟]";
/*      */     } else {
/* 1413 */       type16 = "[關閉]";
/*      */     } 
/* 1415 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "guaiji", new String[] { type1, type2, type3, type4, type5, type6, 
/* 1416 */             type7, type8, type9, type10, type11, type12, type13, type14, type15, type16, type17 }));
/*      */   }
/*      */   
/*      */   public void guaji(L1PcInstance pc) {
/* 1420 */     String type1 = "";
/* 1421 */     String type2 = "";
/* 1422 */     String type3 = "";
/* 1423 */     String type4 = "";
/* 1424 */     String type5 = "";
/* 1425 */     String type6 = "";
/* 1426 */     String type7 = "";
/* 1427 */     String type8 = "";
/* 1428 */     String type9 = "";
/* 1429 */     String type10 = "";
/* 1430 */     String type11 = "";
/* 1431 */     String type12 = "";
/* 1432 */     String type13 = "";
/* 1433 */     String type14 = "";
/* 1434 */     String type15 = "";
/* 1435 */     String type16 = "";
/* 1436 */     String type17 = "";
/* 1437 */     int time = pc.get_other().get_Auto_Points();
/* 1438 */     if (time > 0) {
/* 1439 */       type17 = String.valueOf(time / 60) + "分鐘";
/*      */     } else {
/* 1441 */       type17 = "0";
/*      */     } 
/* 1443 */     if (pc.get_fwgj() > 0) {
/* 1444 */       int i = pc.get_fwgj();
/*      */     } else {
/* 1446 */       type1 = "0";
/*      */     } 
/* 1448 */     if (pc.getitempotion() > 0) {
/* 1449 */       if (pc.getitempotion() == 1) {
/* 1450 */         type2 = "紅色藥水";
/* 1451 */       } else if (pc.getitempotion() == 2) {
/* 1452 */         type2 = "橙色藥水";
/* 1453 */       } else if (pc.getitempotion() == 3) {
/* 1454 */         type2 = "白色藥水";
/* 1455 */       } else if (pc.getitempotion() == 4) {
/* 1456 */         type2 = "濃縮紅水";
/* 1457 */       } else if (pc.getitempotion() == 5) {
/* 1458 */         type2 = "濃縮橙水";
/* 1459 */       } else if (pc.getitempotion() == 6) {
/* 1460 */         type2 = "濃縮白水";
/* 1461 */       } else if (pc.getitempotion() == 7) {
/* 1462 */         type2 = "古代紅水";
/* 1463 */       } else if (pc.getitempotion() == 8) {
/* 1464 */         type2 = "古代橙水";
/* 1465 */       } else if (pc.getitempotion() == 9) {
/* 1466 */         type2 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1469 */       type2 = "尚未設定";
/*      */     } 
/* 1471 */     if (pc.getpotioncount() > 0) {
/* 1472 */       int i = pc.getpotioncount();
/*      */     } else {
/* 1474 */       type3 = "0";
/*      */     } 
/* 1476 */     if (pc.getitempotion1() > 0) {
/* 1477 */       if (pc.getitempotion1() == 1) {
/* 1478 */         type4 = "紅色藥水";
/* 1479 */       } else if (pc.getitempotion1() == 2) {
/* 1480 */         type4 = "橙色藥水";
/* 1481 */       } else if (pc.getitempotion1() == 3) {
/* 1482 */         type4 = "白色藥水";
/* 1483 */       } else if (pc.getitempotion1() == 4) {
/* 1484 */         type4 = "濃縮紅水";
/* 1485 */       } else if (pc.getitempotion1() == 5) {
/* 1486 */         type4 = "濃縮橙水";
/* 1487 */       } else if (pc.getitempotion1() == 6) {
/* 1488 */         type4 = "濃縮白水";
/* 1489 */       } else if (pc.getitempotion1() == 7) {
/* 1490 */         type4 = "古代紅水";
/* 1491 */       } else if (pc.getitempotion1() == 8) {
/* 1492 */         type4 = "古代橙水";
/* 1493 */       } else if (pc.getitempotion1() == 9) {
/* 1494 */         type4 = "古代白水";
/*      */       } 
/*      */     } else {
/* 1497 */       type4 = "尚未設定";
/*      */     } 
/* 1499 */     if (pc.getpotioncount1() > 0) {
/* 1500 */       int i = pc.getpotioncount1();
/*      */     } else {
/* 1502 */       type5 = "0";
/*      */     } 
/* 1504 */     if (pc.getitempotion2() > 0) {
/* 1505 */       if (pc.getitempotion2() == 1) {
/* 1506 */         type6 = "箭";
/* 1507 */       } else if (pc.getitempotion2() == 2) {
/* 1508 */         type6 = "銀箭";
/*      */       } 
/* 1510 */     } else if (pc.getitempotion2() == 0) {
/* 1511 */       type6 = "尚未設定";
/*      */     } 
/* 1513 */     if (pc.getpotioncount2() > 0) {
/* 1514 */       int i = pc.getpotioncount2();
/*      */     } else {
/* 1516 */       type7 = "0";
/*      */     } 
/* 1518 */     if (pc.getgo_guajitele()) {
/* 1519 */       type8 = "[開啟]";
/*      */     } else {
/* 1521 */       type8 = "[關閉]";
/*      */     } 
/* 1523 */     if (pc.getgo_guajired()) {
/* 1524 */       type9 = "[開啟]";
/*      */     } else {
/* 1526 */       type9 = "[關閉]";
/*      */     } 
/* 1528 */     if (pc.IsAttackTeleport()) {
/* 1529 */       type10 = "[開啟]";
/*      */     } else {
/* 1531 */       type10 = "[關閉]";
/*      */     } 
/* 1533 */     if (pc.IsEnemyTeleport()) {
/* 1534 */       type11 = "[開啟]";
/*      */     } else {
/* 1536 */       type11 = "[關閉]";
/*      */     } 
/* 1538 */     if (pc.getma1() > 0) {
/* 1539 */       int i = pc.getma1();
/*      */     } else {
/* 1541 */       type12 = "未設置";
/*      */     } 
/* 1543 */     if (pc.getchecksummid()) {
/* 1544 */       type13 = "[開啟]";
/*      */     } else {
/* 1546 */       type13 = "[關閉]";
/*      */     } 
/* 1548 */     if (pc.getsummon_skillid() > 0) {
/* 1549 */       if (pc.getsummon_skillid() == 1) {
/* 1550 */         type14 = "[初治癒]";
/* 1551 */       } else if (pc.getsummon_skillid() == 19) {
/* 1552 */         type14 = "[中治癒]";
/* 1553 */       } else if (pc.getsummon_skillid() == 35) {
/* 1554 */         type14 = "[高治癒]";
/* 1555 */       } else if (pc.getsummon_skillid() == 57) {
/* 1556 */         type14 = "[全治癒]";
/*      */       } 
/*      */     } else {
/* 1559 */       type14 = "[尚未設置]";
/*      */     } 
/* 1561 */     if (pc.getchecksummidhp()) {
/* 1562 */       type15 = "[開啟]";
/*      */     } else {
/* 1564 */       type15 = "[關閉]";
/*      */     } 
/* 1566 */     if (pc.getmobatk()) {
/* 1567 */       type16 = "[開啟]";
/*      */     } else {
/* 1569 */       type16 = "[關閉]";
/*      */     } 
/* 1571 */     pc.sendPackets((ServerBasePacket)new S_NPCTalkReturn(pc.getId(), "guaiji", new String[] { type1, type2, type3, type4, type5, type6, 
/* 1572 */             type7, type8, type9, type10, type11, type12, type13, type14, type15, type16, type17 }));
/*      */   }
/*      */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\AutoAttackUpdateNew.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */