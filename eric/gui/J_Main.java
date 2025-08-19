/*      */ package com.eric.gui;
/*      */ 
/*      */ import com.lineage.commons.system.LanSecurityManager;
/*      */ import com.lineage.config.ConfigRate;
/*      */ import com.lineage.echo.ClientExecutor;
/*      */ import com.lineage.server.Shutdown;
/*      */ import com.lineage.server.clientpackets.C_LoginToServer;
/*      */ import com.lineage.server.datatables.SkillsTable;
/*      */ import com.lineage.server.datatables.lock.IpReading;
/*      */ import com.lineage.server.model.Instance.L1ItemInstance;
/*      */ import com.lineage.server.model.Instance.L1PcInstance;
/*      */ import com.lineage.server.model.L1DwarfForClanInventory;
/*      */ import com.lineage.server.model.L1DwarfForElfInventory;
/*      */ import com.lineage.server.model.L1DwarfInventory;
/*      */ import com.lineage.server.model.L1Inventory;
/*      */ import com.lineage.server.model.L1PcInventory;
/*      */ import com.lineage.server.model.skill.L1BuffUtil;
/*      */ import com.lineage.server.model.skill.L1SkillUse;
/*      */ import com.lineage.server.serverpackets.S_Disconnect;
/*      */ import com.lineage.server.serverpackets.S_Message_YN;
/*      */ import com.lineage.server.serverpackets.S_ServerMessage;
/*      */ import com.lineage.server.serverpackets.S_SkillBrave;
/*      */ import com.lineage.server.serverpackets.S_SkillHaste;
/*      */ import com.lineage.server.serverpackets.S_SkillSound;
/*      */ import com.lineage.server.serverpackets.S_SystemMessage;
/*      */ import com.lineage.server.serverpackets.ServerBasePacket;
/*      */ import com.lineage.server.templates.L1Skills;
/*      */ import com.lineage.server.world.World;
/*      */ import java.awt.Color;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.EventQueue;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.WindowAdapter;
/*      */ import java.awt.event.WindowEvent;
/*      */ import java.io.FileOutputStream;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JMenu;
/*      */ import javax.swing.JMenuBar;
/*      */ import javax.swing.JMenuItem;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JPopupMenu;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JSplitPane;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.KeyStroke;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class J_Main
/*      */   extends JFrame
/*      */   implements ActionListener
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*      */   private static J_Main instance;
/*      */   private int select;
/*      */   SimpleDateFormat sdf;
/*      */   ImageIcon img;
/*      */   private DefaultTableModel DTM;
/*      */   private DefaultTableModel DTM_Item;
/*      */   private JButton B_Item;
/*      */   private JButton B_Submit;
/*      */   private JComboBox<?> CB_Channel;
/*      */   private JComboBox CB_Item;
/*      */   private JDialog D_Item;
/*      */   private JFrame F_Player;
/*      */   private JLabel L_AccessLevel;
/*      */   private JLabel L_AccessLevel7;
/*      */   private JLabel L_Account;
/*      */   private JLabel L_Cha;
/*      */   private JLabel L_Clan;
/*      */   private JLabel L_Con;
/*      */   private JLabel L_Dex;
/*      */   private JLabel L_Exp;
/*      */   private JLabel L_Hp;
/*      */   private JLabel L_Image;
/*      */   private JLabel L_Int;
/*      */   private JLabel L_Leavl;
/*      */   private JLabel L_Map;
/*      */   private JLabel L_Mp;
/*      */   private JLabel L_Mp1;
/*      */   private JLabel L_Name;
/*      */   private JLabel L_Str;
/*      */   private JLabel L_Title;
/*      */   private JLabel L_Wis;
/*      */   private JLabel L_X;
/*      */   private JLabel L_Y;
/*      */   private JMenuBar MB;
/*      */   private JMenuItem MI_LA;
/*      */   private JMenuItem MI_ATTR_ENCHANT_CHANCE;
/*      */   private JMenuItem MI_CHANCE_ARMOR;
/*      */   private JMenuItem MI_CHANCE_WEAPON;
/*      */   private JMenuItem MI_XP_PET;
/*      */   private JMenuItem MI_Exp;
/*      */   private JMenuItem MI_Drop;
/*      */   private JMenuItem MI_Adena;
/*      */   private JMenuItem MI_AllBuff;
/*      */   private JMenuItem MI_AllRess;
/*      */   private JMenuItem MI_Angel;
/*      */   private JMenuItem MI_BanIP;
/*      */   private JMenuItem MI_Close;
/*      */   private JMenuItem MI_Kill;
/*      */   private JMenuItem MI_Save;
/*      */   private JMenuItem MI_SetClose;
/*      */   private JMenuItem MI_ShowPlayer;
/*      */   private JMenuItem MI_Whisper;
/*      */   private JMenu M_Edit;
/*      */   private JMenu M_File;
/*      */   private JMenu M_Special;
/*      */   private JPopupMenu PM_Player;
/*      */   private JScrollPane SP_;
/*      */   private JScrollPane SP_AllChat;
/*      */   private JScrollPane SP_Clan;
/*      */   private JScrollPane SP_Consol;
/*      */   private JScrollPane SP_Normal;
/*      */   private JSplitPane SP_Split;
/*      */   private JScrollPane SP_Team;
/*      */   private JScrollPane SP_World;
/*      */   private JScrollPane SP_player;
/*      */   private JTextArea TA_AllChat;
/*      */   private JTextArea TA_Clan;
/*      */   private JTextArea TA_Consol;
/*      */   private JTextArea TA_Normal;
/*      */   private JTextArea TA_Private;
/*      */   private JTextArea TA_Team;
/*      */   private JTextArea TA_World;
/*      */   private JTextField TF_Ac;
/*      */   private JTextField TF_AccessLevel;
/*      */   private JTextField TF_Account;
/*      */   private JTextField TF_Cha;
/*      */   private JTextField TF_Clan;
/*      */   private JTextField TF_Con;
/*      */   private JTextField TF_Dex;
/*      */   private JTextField TF_Exp;
/*      */   private JTextField TF_Hp;
/*      */   private JTextField TF_Int;
/*      */   private JTextField TF_Level;
/*      */   private JTextField TF_Map;
/*      */   private JTextField TF_Mp;
/*      */   private JTextField TF_Msg;
/*      */   private JTextField TF_Name;
/*      */   private JTextField TF_Sex;
/*      */   private JTextField TF_Str;
/*      */   private JTextField TF_Target;
/*      */   private JTextField TF_Title;
/*      */   private JTextField TF_Wis;
/*      */   private JTextField TF_X;
/*      */   private JTextField TF_Y;
/*      */   private JTabbedPane TP;
/*      */   private JTable T_Item;
/*      */   private JTable T_Player;
/*      */   private JLabel jLabel1;
/*      */   private JPanel jPanel1;
/*      */   private JPanel jPanel2;
/*      */   private JScrollPane jScrollPane1;
/*      */   private JSeparator jSeparator1;
/*      */   private JSeparator jSeparator2;
/*      */   private JSeparator jSeparator3;
/*      */   
/*      */   public J_Main() {
/*  186 */     this.select = 0;
/*  187 */     this.sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
/*  188 */     this.img = new ImageIcon("img/icon.png");
/*  189 */     this.DTM = new DefaultTableModel()
/*      */       {
/*      */         private static final long serialVersionUID = 1L;
/*      */         
/*      */         public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  194 */           return false;
/*      */         }
/*      */       };
/*  197 */     this.DTM_Item = new DefaultTableModel()
/*      */       {
/*      */         private static final long serialVersionUID = 1L;
/*      */         
/*      */         public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  202 */           return false;
/*      */         }
/*      */       };
/*  205 */     iniPlayerTable();
/*  206 */     initComponents();
/*  207 */     this.TA_Consol.setForeground(new Color(150, 205, 205));
/*  208 */     this.TA_AllChat.setForeground(new Color(150, 205, 205));
/*  209 */     this.TA_Clan.setForeground(new Color(150, 205, 205));
/*  210 */     this.TA_Normal.setForeground(new Color(150, 205, 205));
/*  211 */     this.TA_Private.setForeground(new Color(150, 205, 205));
/*  212 */     this.TA_Team.setForeground(new Color(150, 205, 205));
/*  213 */     this.TA_World.setForeground(new Color(150, 205, 205));
/*  214 */     this.TA_Consol.setBackground(new Color(0, 0, 120));
/*  215 */     this.TA_AllChat.setBackground(new Color(0, 0, 120));
/*  216 */     this.TA_Clan.setBackground(new Color(0, 0, 120));
/*  217 */     this.TA_Normal.setBackground(new Color(0, 0, 120));
/*  218 */     this.TA_Private.setBackground(new Color(0, 0, 120));
/*  219 */     this.TA_Team.setBackground(new Color(0, 0, 120));
/*  220 */     this.TA_World.setBackground(new Color(0, 0, 120));
/*  221 */     setIconImage(this.img.getImage());
/*  222 */     iniAction();
/*  223 */     this.T_Item.setSize(300, 400);
/*  224 */     this.D_Item.pack();
/*  225 */     String[] s = { "物品名稱", "物品數量", "物品ID" };
/*  226 */     this.DTM_Item.setColumnIdentifiers((Object[])s);
/*      */   }
/*      */   
/*      */   private void iniAction() {
/*  230 */     this.MI_Kill.addActionListener(this);
/*  231 */     this.MI_BanIP.addActionListener(this);
/*  232 */     this.MI_ShowPlayer.addActionListener(this);
/*  233 */     this.MI_Whisper.addActionListener(this);
/*  234 */     this.MI_Save.addActionListener(this);
/*  235 */     this.MI_Close.addActionListener(this);
/*  236 */     this.MI_Angel.addActionListener(this);
/*  237 */     this.MI_SetClose.addActionListener(this);
/*  238 */     this.MI_AllBuff.addActionListener(this);
/*  239 */     this.MI_AllRess.addActionListener(this);
/*  240 */     this.MI_XP_PET.addActionListener(this);
/*  241 */     this.MI_CHANCE_WEAPON.addActionListener(this);
/*  242 */     this.MI_CHANCE_ARMOR.addActionListener(this);
/*  243 */     this.MI_ATTR_ENCHANT_CHANCE.addActionListener(this);
/*  244 */     this.MI_LA.addActionListener(this);
/*  245 */     this.MI_Adena.addActionListener(this);
/*  246 */     this.MI_Exp.addActionListener(this);
/*  247 */     this.MI_Drop.addActionListener(this);
/*      */   }
/*      */   
/*      */   public static J_Main getInstance() {
/*  251 */     if (instance == null) {
/*  252 */       instance = new J_Main();
/*      */     }
/*  254 */     return instance;
/*      */   }
/*      */   
/*      */   public void addWorldChat(String from, String text) {
/*  258 */     Calendar cal = Calendar.getInstance();
/*  259 */     AllChat(String.valueOf(String.valueOf(this.sdf.format(cal.getTime()))) + "公頻『" + from + "』:" + text + "\r\n");
/*  260 */     this.TA_World.append(String.valueOf(String.valueOf(from)) + " : " + text + "\r\n");
/*  261 */     this.TA_World.setCaretPosition(this.TA_World.getDocument().getLength());
/*      */   }
/*      */   
/*      */   public void addClanChat(String from, String text) {
/*  265 */     Calendar cal = Calendar.getInstance();
/*  266 */     AllChat(String.valueOf(String.valueOf(this.sdf.format(cal.getTime()))) + "血盟『" + from + "』:" + text + "\r\n");
/*  267 */     this.TA_Clan.append(String.valueOf(String.valueOf(from)) + " : " + text + "\r\n");
/*  268 */     this.TA_Clan.setCaretPosition(this.TA_Clan.getDocument().getLength());
/*      */   }
/*      */   
/*      */   public void addNormalChat(String from, String text) {
/*  272 */     Calendar cal = Calendar.getInstance();
/*  273 */     AllChat(String.valueOf(String.valueOf(this.sdf.format(cal.getTime()))) + "一般『" + from + "』:" + text + "\r\n");
/*  274 */     this.TA_Normal.append(String.valueOf(String.valueOf(from)) + " : " + text + "\r\n");
/*  275 */     this.TA_Normal.setCaretPosition(this.TA_Normal.getDocument().getLength());
/*      */   }
/*      */   
/*      */   public void addTeamChat(String from, String text) {
/*  279 */     Calendar cal = Calendar.getInstance();
/*  280 */     AllChat(String.valueOf(String.valueOf(this.sdf.format(cal.getTime()))) + "隊伍『" + from + "』:" + text + "\r\n");
/*  281 */     this.TA_Team.append(String.valueOf(String.valueOf(from)) + " : " + text + "\r\n");
/*  282 */     this.TA_Team.setCaretPosition(this.TA_Team.getDocument().getLength());
/*      */   }
/*      */   
/*      */   public void addConsol(String text) {
/*  286 */     this.TA_Consol.append(String.valueOf(String.valueOf(text)) + "\r\n");
/*  287 */     this.TA_Consol.setCaretPosition(this.TA_Consol.getDocument().getLength());
/*      */   }
/*      */   
/*      */   public void addConsolPost(String text) {
/*  291 */     this.TA_Consol.append(String.valueOf(String.valueOf(text)) + "\r\n");
/*  292 */     this.TA_Consol.setCaretPosition(this.TA_Consol.getDocument().getLength());
/*      */   }
/*      */   
/*      */   public void addConsolNoLR(String text) {
/*  296 */     this.TA_Consol.append(text);
/*  297 */     this.TA_Consol.setCaretPosition(this.TA_Consol.getDocument().getLength());
/*      */   }
/*      */   
/*      */   public void AllChat(String text) {
/*  301 */     this.TA_AllChat.append(String.valueOf(String.valueOf(text)) + "\r\n");
/*  302 */     this.TA_AllChat.setCaretPosition(this.TA_AllChat.getDocument().getLength());
/*      */   }
/*      */   
/*      */   public void addPrivateChat(String from, String to, String text) {
/*  306 */     Calendar cal = Calendar.getInstance();
/*  307 */     AllChat(String.valueOf(String.valueOf(this.sdf.format(cal.getTime()))) + "密語『" + from + "->" + to + "』:" + text + "\r\n");
/*  308 */     this.TA_Private.append(String.valueOf(String.valueOf(from)) + "->" + to + " : " + text + "\r\n");
/*  309 */     this.TA_Private.setCaretPosition(this.TA_Private.getDocument().getLength());
/*      */   }
/*      */   
/*      */   public void addItemTable(String itemname, long l, long id) {
/*  313 */     Object[] o = { itemname, Long.valueOf(l), Long.valueOf(id) };
/*  314 */     this.DTM_Item.addRow(o);
/*      */   }
/*      */   
/*      */   public void iniTable() {
/*  318 */     int cont = this.DTM_Item.getRowCount();
/*  319 */     while (cont > 1) {
/*  320 */       this.DTM_Item.removeRow(cont - 1);
/*  321 */       cont--;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addPlayerTable(String account, String name, StringBuilder IP) {
/*  326 */     Object[] o = { account, name, IP };
/*  327 */     this.DTM.addRow(o);
/*      */   }
/*      */   
/*      */   private int findPlayer(String name) {
/*      */     try {
/*  332 */       int j = 0;
/*  333 */       while (j < this.DTM.getRowCount()) {
/*  334 */         if (name.equals(this.DTM.getValueAt(j, 1).toString())) {
/*  335 */           return j;
/*      */         }
/*  337 */         j++;
/*      */       } 
/*  339 */       return -1;
/*  340 */     } catch (ArrayIndexOutOfBoundsException e) {
/*  341 */       e.printStackTrace();
/*  342 */       return -1;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void delPlayerTable(String name) {
/*  347 */     int findNum = 0;
/*  348 */     if ((findNum = findPlayer(name)) != -1) {
/*  349 */       this.DTM.removeRow(findNum);
/*      */     }
/*      */   }
/*      */   
/*      */   private void iniPlayerTable() {
/*  354 */     String[] s = { "帳號", "角色名稱", "IP" };
/*  355 */     this.DTM.setColumnIdentifiers((Object[])s);
/*      */   }
/*      */   
/*      */   private void initComponents() {
/*  359 */     this.F_Player = new JFrame();
/*  360 */     this.L_Name = new JLabel();
/*  361 */     this.L_Title = new JLabel();
/*  362 */     this.L_Account = new JLabel();
/*  363 */     this.L_Leavl = new JLabel();
/*  364 */     this.L_AccessLevel = new JLabel();
/*  365 */     this.L_Exp = new JLabel();
/*  366 */     this.L_Hp = new JLabel();
/*  367 */     this.L_Mp = new JLabel();
/*  368 */     this.L_Int = new JLabel();
/*  369 */     this.L_Str = new JLabel();
/*  370 */     this.L_Con = new JLabel();
/*  371 */     this.L_Dex = new JLabel();
/*  372 */     this.L_Wis = new JLabel();
/*  373 */     this.L_Cha = new JLabel();
/*  374 */     this.jPanel1 = new JPanel();
/*  375 */     this.L_Image = new JLabel();
/*  376 */     this.L_Clan = new JLabel();
/*  377 */     this.L_AccessLevel7 = new JLabel();
/*  378 */     this.L_Mp1 = new JLabel();
/*  379 */     this.L_Map = new JLabel();
/*  380 */     this.L_X = new JLabel();
/*  381 */     this.L_Y = new JLabel();
/*  382 */     this.TF_Account = new JTextField();
/*  383 */     this.TF_Name = new JTextField();
/*  384 */     this.TF_Title = new JTextField();
/*  385 */     this.TF_Level = new JTextField();
/*  386 */     this.TF_AccessLevel = new JTextField();
/*  387 */     this.TF_Clan = new JTextField();
/*  388 */     this.TF_Exp = new JTextField();
/*  389 */     this.TF_Hp = new JTextField();
/*  390 */     this.TF_Mp = new JTextField();
/*  391 */     this.TF_Sex = new JTextField();
/*  392 */     this.TF_Str = new JTextField();
/*  393 */     this.TF_Con = new JTextField();
/*  394 */     this.TF_Dex = new JTextField();
/*  395 */     this.TF_Wis = new JTextField();
/*  396 */     this.TF_Int = new JTextField();
/*  397 */     this.TF_Cha = new JTextField();
/*  398 */     this.TF_Ac = new JTextField();
/*  399 */     this.TF_Map = new JTextField();
/*  400 */     this.TF_X = new JTextField();
/*  401 */     this.TF_Y = new JTextField();
/*  402 */     this.B_Item = new JButton();
/*  403 */     this.CB_Item = new JComboBox();
/*  404 */     this.PM_Player = new JPopupMenu();
/*  405 */     this.MI_Kill = new JMenuItem();
/*  406 */     this.MI_BanIP = new JMenuItem();
/*  407 */     this.jSeparator1 = new JSeparator();
/*  408 */     this.MI_ShowPlayer = new JMenuItem();
/*  409 */     this.jSeparator2 = new JSeparator();
/*  410 */     this.MI_Whisper = new JMenuItem();
/*  411 */     this.jLabel1 = new JLabel();
/*  412 */     this.D_Item = new JDialog();
/*  413 */     this.jScrollPane1 = new JScrollPane();
/*  414 */     this.T_Item = new JTable(this.DTM_Item);
/*  415 */     this.SP_Split = new JSplitPane();
/*  416 */     this.TP = new JTabbedPane();
/*  417 */     this.SP_Consol = new JScrollPane();
/*  418 */     this.TA_Consol = new JTextArea();
/*  419 */     this.SP_AllChat = new JScrollPane();
/*  420 */     this.TA_AllChat = new JTextArea();
/*  421 */     this.SP_World = new JScrollPane();
/*  422 */     this.TA_World = new JTextArea();
/*  423 */     this.SP_Normal = new JScrollPane();
/*  424 */     this.TA_Normal = new JTextArea();
/*  425 */     this.SP_ = new JScrollPane();
/*  426 */     this.TA_Private = new JTextArea();
/*  427 */     this.SP_Clan = new JScrollPane();
/*  428 */     this.TA_Clan = new JTextArea();
/*  429 */     this.SP_Team = new JScrollPane();
/*  430 */     this.TA_Team = new JTextArea();
/*  431 */     this.SP_player = new JScrollPane();
/*  432 */     this.T_Player = new JTable(this.DTM);
/*  433 */     this.jPanel2 = new JPanel();
/*  434 */     this.CB_Channel = new JComboBox();
/*  435 */     this.TF_Target = new JTextField();
/*  436 */     this.B_Submit = new JButton();
/*  437 */     this.TF_Msg = new JTextField();
/*  438 */     this.MB = new JMenuBar();
/*  439 */     this.M_File = new JMenu();
/*  440 */     this.MI_Save = new JMenuItem();
/*  441 */     this.jSeparator3 = new JSeparator();
/*  442 */     this.MI_SetClose = new JMenuItem();
/*  443 */     this.MI_Close = new JMenuItem();
/*  444 */     this.M_Edit = new JMenu();
/*  445 */     this.M_Special = new JMenu();
/*  446 */     this.MI_LA = new JMenuItem();
/*  447 */     this.MI_ATTR_ENCHANT_CHANCE = new JMenuItem();
/*  448 */     this.MI_CHANCE_ARMOR = new JMenuItem();
/*  449 */     this.MI_CHANCE_WEAPON = new JMenuItem();
/*  450 */     this.MI_XP_PET = new JMenuItem();
/*  451 */     this.MI_Exp = new JMenuItem();
/*  452 */     this.MI_Drop = new JMenuItem();
/*  453 */     this.MI_Adena = new JMenuItem();
/*  454 */     this.MI_Angel = new JMenuItem();
/*  455 */     this.MI_AllBuff = new JMenuItem();
/*  456 */     this.MI_AllRess = new JMenuItem();
/*  457 */     this.L_Name.setText("名字:");
/*  458 */     this.L_Title.setText("稱號:");
/*  459 */     this.L_Account.setText("帳號:");
/*  460 */     this.L_Leavl.setText("等級:");
/*  461 */     this.L_AccessLevel.setText("權限:");
/*  462 */     this.L_Exp.setText(" Exp:");
/*  463 */     this.L_Hp.setText("Hp:");
/*  464 */     this.L_Mp.setText("Mp:");
/*  465 */     this.L_Int.setText("智力:");
/*  466 */     this.L_Str.setText("力量:");
/*  467 */     this.L_Con.setText("體質:");
/*  468 */     this.L_Dex.setText("敏捷:");
/*  469 */     this.L_Wis.setText("精神:");
/*  470 */     this.L_Cha.setText("魅力:");
/*  471 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  472 */     this.jPanel1.setLayout(jPanel1Layout);
/*  473 */     jPanel1Layout.setHorizontalGroup(
/*  474 */         jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup()
/*  475 */           .addContainerGap().addComponent(this.L_Image, -1, 108, 32767).addContainerGap()));
/*  476 */     jPanel1Layout.setVerticalGroup(
/*  477 */         jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup()
/*  478 */           .addContainerGap().addComponent(this.L_Image, -1, 180, 32767).addContainerGap()));
/*  479 */     this.L_Clan.setText("血盟:");
/*  480 */     this.L_AccessLevel7.setText("防禦力:");
/*  481 */     this.L_Mp1.setText("性別:");
/*  482 */     this.L_Map.setText("Map:");
/*  483 */     this.L_X.setText("X:");
/*  484 */     this.L_Y.setText("Y:");
/*  485 */     this.TF_Account.setEditable(false);
/*  486 */     this.TF_Name.setEditable(false);
/*  487 */     this.TF_Title.setEditable(false);
/*  488 */     this.TF_Level.setEditable(false);
/*  489 */     this.TF_AccessLevel.setEditable(false);
/*  490 */     this.TF_Clan.setEditable(false);
/*  491 */     this.TF_Exp.setEditable(false);
/*  492 */     this.TF_Hp.setEditable(false);
/*  493 */     this.TF_Mp.setEditable(false);
/*  494 */     this.TF_Sex.setEditable(false);
/*  495 */     this.TF_Str.setEditable(false);
/*  496 */     this.TF_Con.setEditable(false);
/*  497 */     this.TF_Dex.setEditable(false);
/*  498 */     this.TF_Wis.setEditable(false);
/*  499 */     this.TF_Int.setEditable(false);
/*  500 */     this.TF_Cha.setEditable(false);
/*  501 */     this.TF_Ac.setEditable(false);
/*  502 */     this.TF_Map.setEditable(false);
/*  503 */     this.TF_X.setEditable(false);
/*  504 */     this.TF_Y.setEditable(false);
/*  505 */     this.B_Item.setText("物品欄顯示");
/*  506 */     this.B_Item.addActionListener(new ActionListener()
/*      */         {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  509 */             J_Main.this.B_ItemActionPerformed(evt);
/*      */           }
/*      */         });
/*  512 */     this.CB_Item.setModel(new DefaultComboBoxModel<>(new String[] { "0,身上物品", "1,倉庫", "2,血盟倉庫", "3,妖森倉庫" }));
/*  513 */     GroupLayout F_PlayerLayout = new GroupLayout(this.F_Player.getContentPane());
/*  514 */     this.F_Player.getContentPane().setLayout(F_PlayerLayout);
/*  515 */     F_PlayerLayout
/*  516 */       .setHorizontalGroup(
/*  517 */         F_PlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(F_PlayerLayout
/*  518 */           .createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 
/*  519 */             18)
/*  520 */           .addGroup(F_PlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  521 */             .addGroup(F_PlayerLayout.createSequentialGroup().addComponent(this.L_Account)
/*  522 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(
/*  523 */                 this.TF_Account, -2, 108, -2))
/*  524 */             .addGroup(F_PlayerLayout.createSequentialGroup()
/*  525 */               .addGroup(F_PlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  526 */                 .addComponent(this.L_Name).addComponent(this.L_Title)
/*  527 */                 .addComponent(this.L_Leavl).addComponent(this.L_AccessLevel)
/*  528 */                 .addComponent(this.L_Clan)
/*  529 */                 .addComponent(this.L_Exp, GroupLayout.Alignment.TRAILING, -1, 27, 32767)
/*  530 */                 .addComponent(this.L_Hp, GroupLayout.Alignment.TRAILING)
/*  531 */                 .addComponent(this.L_Mp, GroupLayout.Alignment.TRAILING)
/*  532 */                 .addComponent(this.L_Mp1, GroupLayout.Alignment.TRAILING))
/*  533 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  534 */               .addGroup(F_PlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  535 */                 .addComponent(this.TF_Mp, -1, 108, 32767)
/*  536 */                 .addComponent(this.TF_Sex, -1, 108, 32767)
/*  537 */                 .addComponent(this.TF_Hp, -1, 108, 32767)
/*  538 */                 .addComponent(this.TF_Exp, -1, 108, 32767)
/*  539 */                 .addComponent(this.TF_Clan, -1, 108, 32767)
/*  540 */                 .addComponent(this.TF_AccessLevel, -1, 108, 32767)
/*  541 */                 .addComponent(this.TF_Level, -1, 108, 32767)
/*  542 */                 .addComponent(this.TF_Title, -1, 108, 32767)
/*  543 */                 .addComponent(this.TF_Name, -1, 108, 32767)
/*  544 */                 .addComponent(this.CB_Item, 0, -1, 32767))))
/*  545 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  546 */           .addGroup(F_PlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  547 */             .addGroup(
/*  548 */               F_PlayerLayout
/*  549 */               .createParallelGroup(
/*  550 */                 GroupLayout.Alignment.TRAILING)
/*  551 */               .addGroup(
/*  552 */                 F_PlayerLayout.createSequentialGroup()
/*  553 */                 .addGroup(
/*  554 */                   F_PlayerLayout
/*  555 */                   .createParallelGroup(
/*  556 */                     GroupLayout.Alignment.TRAILING)
/*  557 */                   .addComponent(this.L_Int)
/*  558 */                   .addComponent(this.L_Wis)
/*  559 */                   .addComponent(this.L_Dex)
/*  560 */                   .addComponent(this.L_Cha)
/*  561 */                   .addComponent(
/*  562 */                     this.L_AccessLevel7)
/*  563 */                   .addComponent(this.L_Con)
/*  564 */                   .addComponent(this.L_Str)
/*  565 */                   .addComponent(this.L_Map)
/*  566 */                   .addComponent(this.L_X))
/*  567 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  568 */                 .addGroup(F_PlayerLayout
/*  569 */                   .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  570 */                   .addComponent(this.TF_Str, -2, 108, -2)
/*  571 */                   .addComponent(this.TF_Con, -2, 108, -2)
/*  572 */                   .addComponent(this.TF_Dex, -2, 108, -2)
/*  573 */                   .addComponent(this.TF_Wis, -2, 108, -2)
/*  574 */                   .addComponent(this.TF_Int, -2, 108, -2)
/*  575 */                   .addComponent(this.TF_Cha, -2, 108, -2)
/*  576 */                   .addComponent(this.TF_Ac, -2, 108, -2)
/*  577 */                   .addComponent(this.TF_Map, -2, 108, -2)
/*  578 */                   .addComponent(this.TF_X, -2, 108, -2)))
/*  579 */               .addGroup(F_PlayerLayout.createSequentialGroup()
/*  580 */                 .addComponent(this.L_Y)
/*  581 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  582 */                 .addComponent(this.TF_Y, -2, 108, -2)))
/*  583 */             .addComponent(this.B_Item))
/*  584 */           .addContainerGap(52, 32767)));
/*  585 */     F_PlayerLayout
/*  586 */       .setVerticalGroup(
/*  587 */         F_PlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  588 */         .addGroup(
/*  589 */           F_PlayerLayout
/*  590 */           .createSequentialGroup().addGroup(F_PlayerLayout
/*  591 */             .createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(F_PlayerLayout
/*  592 */               .createSequentialGroup().addContainerGap()
/*  593 */               .addGroup(F_PlayerLayout
/*  594 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  595 */                 .addComponent(this.L_Account)
/*  596 */                 .addComponent(this.TF_Account, -2, 18, -2))
/*  597 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  598 */               .addGroup(F_PlayerLayout
/*  599 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  600 */                 .addComponent(this.L_Name)
/*  601 */                 .addComponent(this.TF_Name, -2, 18, -2))
/*  602 */               .addGap(5, 5, 5)
/*  603 */               .addGroup(F_PlayerLayout
/*  604 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  605 */                 .addComponent(this.L_Title)
/*  606 */                 .addComponent(this.TF_Title, -2, 18, -2))
/*  607 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  608 */               .addGroup(F_PlayerLayout
/*  609 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  610 */                 .addComponent(this.L_Leavl)
/*  611 */                 .addComponent(this.TF_Level, -2, 18, -2))
/*  612 */               .addGap(5, 5, 5)
/*  613 */               .addGroup(F_PlayerLayout
/*  614 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  615 */                 .addComponent(this.L_AccessLevel)
/*  616 */                 .addComponent(this.TF_AccessLevel, -2, 18, -2))
/*  617 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  618 */               .addGroup(F_PlayerLayout
/*  619 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  620 */                 .addComponent(this.L_Clan)
/*  621 */                 .addComponent(this.TF_Clan, -2, 18, -2))
/*  622 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  623 */               .addGroup(F_PlayerLayout
/*  624 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  625 */                 .addComponent(this.L_Exp)
/*  626 */                 .addComponent(this.TF_Exp, -2, 18, -2))
/*  627 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  628 */               .addGroup(F_PlayerLayout
/*  629 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  630 */                 .addComponent(this.L_Hp)
/*  631 */                 .addComponent(this.TF_Hp, -2, 18, -2))
/*  632 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  633 */               .addGroup(F_PlayerLayout
/*  634 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  635 */                 .addComponent(this.L_Mp)
/*  636 */                 .addComponent(this.TF_Mp, -2, 18, -2))
/*  637 */               .addPreferredGap(
/*  638 */                 LayoutStyle.ComponentPlacement.RELATED)
/*  639 */               .addGroup(F_PlayerLayout
/*  640 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  641 */                 .addComponent(this.L_Mp1)
/*  642 */                 .addComponent(this.TF_Sex, -2, 18, -2)
/*  643 */                 .addComponent(this.L_Y)
/*  644 */                 .addComponent(this.TF_Y, -2, 18, -2)))
/*  645 */             .addGroup(F_PlayerLayout.createSequentialGroup()
/*  646 */               .addGap(26, 26, 26)
/*  647 */               .addComponent(this.jPanel1, -2, -1, -2))
/*  648 */             .addGroup(
/*  649 */               F_PlayerLayout.createSequentialGroup().addContainerGap()
/*  650 */               .addGroup(F_PlayerLayout
/*  651 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  652 */                 .addComponent(this.L_Str)
/*  653 */                 .addComponent(this.TF_Str, -2, 18, -2))
/*  654 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  655 */               .addGroup(F_PlayerLayout
/*  656 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  657 */                 .addComponent(this.L_Con)
/*  658 */                 .addComponent(this.TF_Con, -2, 18, -2))
/*  659 */               .addGap(5, 5, 5)
/*  660 */               .addGroup(F_PlayerLayout
/*  661 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  662 */                 .addComponent(this.L_Dex)
/*  663 */                 .addComponent(this.TF_Dex, -2, 18, -2))
/*  664 */               .addGap(5, 5, 5)
/*  665 */               .addGroup(F_PlayerLayout
/*  666 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  667 */                 .addComponent(this.L_Wis)
/*  668 */                 .addComponent(this.TF_Wis, -2, 18, -2))
/*  669 */               .addGap(5, 5, 5)
/*  670 */               .addGroup(F_PlayerLayout
/*  671 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  672 */                 .addComponent(this.L_Int)
/*  673 */                 .addComponent(this.TF_Int, -2, 18, -2))
/*  674 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  675 */               .addGroup(F_PlayerLayout
/*  676 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  677 */                 .addComponent(this.L_Cha)
/*  678 */                 .addComponent(this.TF_Cha, -2, 18, -2))
/*  679 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  680 */               .addGroup(F_PlayerLayout
/*  681 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  682 */                 .addComponent(this.L_AccessLevel7)
/*  683 */                 .addComponent(this.TF_Ac, -2, 18, -2))
/*  684 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  685 */               .addGroup(F_PlayerLayout
/*  686 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  687 */                 .addComponent(this.L_Map)
/*  688 */                 .addComponent(this.TF_Map, -2, 18, -2))
/*  689 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  690 */               .addGroup(F_PlayerLayout
/*  691 */                 .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  692 */                 .addComponent(this.L_X)
/*  693 */                 .addComponent(this.TF_X, -2, 18, -2))))
/*  694 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  695 */           .addGroup(F_PlayerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  696 */             .addComponent(this.CB_Item, -2, -1, -2)
/*  697 */             .addComponent(this.B_Item))
/*  698 */           .addContainerGap(27, 32767)));
/*  699 */     this.MI_Kill.setMnemonic('K');
/*  700 */     this.MI_Kill.setText("強制踢除(K)");
/*  701 */     this.PM_Player.add(this.MI_Kill);
/*  702 */     this.MI_BanIP.setMnemonic('B');
/*  703 */     this.MI_BanIP.setText("封鎖IP(B)");
/*  704 */     this.PM_Player.add(this.MI_BanIP);
/*  705 */     this.PM_Player.add(this.jSeparator1);
/*  706 */     this.MI_ShowPlayer.setMnemonic('P');
/*  707 */     this.MI_ShowPlayer.setText("玩家資料(P)");
/*  708 */     this.PM_Player.add(this.MI_ShowPlayer);
/*  709 */     this.PM_Player.add(this.jSeparator2);
/*  710 */     this.MI_Whisper.setMnemonic('W');
/*  711 */     this.MI_Whisper.setText("密語(W)");
/*  712 */     this.PM_Player.add(this.MI_Whisper);
/*  713 */     this.jLabel1.setText("jLabel1");
/*  714 */     this.D_Item.getContentPane().setLayout(new GridLayout(1, 0));
/*  715 */     this.jScrollPane1.setViewportView(this.T_Item);
/*  716 */     this.D_Item.getContentPane().add(this.jScrollPane1);
/*  717 */     setDefaultCloseOperation(3);
/*  718 */     setTitle("天堂管理介面");
/*  719 */     setLocationByPlatform(true);
/*  720 */     setMinimumSize(new Dimension(1024, 768));
/*  721 */     addWindowListener(new WindowAdapter()
/*      */         {
/*      */           public void windowClosed(WindowEvent evt) {
/*  724 */             J_Main.this.formWindowClosed(evt);
/*      */           }
/*      */         });
/*  727 */     this.SP_Split.setDividerLocation(550);
/*  728 */     this.SP_Consol.setAutoscrolls(true);
/*  729 */     this.TA_Consol.setBackground(new Color(174, 238, 238));
/*  730 */     this.TA_Consol.setColumns(20);
/*  731 */     this.TA_Consol.setEditable(false);
/*  732 */     this.TA_Consol.setForeground(new Color(174, 238, 238));
/*  733 */     this.TA_Consol.setRows(5);
/*  734 */     this.TA_Consol.setEnabled(false);
/*  735 */     this.SP_Consol.setViewportView(this.TA_Consol);
/*  736 */     this.TP.addTab("管理器", this.SP_Consol);
/*  737 */     this.SP_AllChat.setAutoscrolls(true);
/*  738 */     this.TA_AllChat.setBackground(new Color(174, 238, 238));
/*  739 */     this.TA_AllChat.setColumns(20);
/*  740 */     this.TA_AllChat.setEditable(false);
/*  741 */     this.TA_AllChat.setForeground(new Color(174, 238, 238));
/*  742 */     this.TA_AllChat.setRows(5);
/*  743 */     this.SP_AllChat.setViewportView(this.TA_AllChat);
/*  744 */     this.TP.addTab("全部頻道", this.SP_AllChat);
/*  745 */     this.SP_World.setAutoscrolls(true);
/*  746 */     this.TA_World.setColumns(20);
/*  747 */     this.TA_World.setEditable(false);
/*  748 */     this.TA_World.setForeground(new Color(174, 238, 238));
/*  749 */     this.TA_World.setRows(5);
/*  750 */     this.TA_World.setEnabled(false);
/*  751 */     this.SP_World.setViewportView(this.TA_World);
/*  752 */     this.TP.addTab("世界 ", this.SP_World);
/*  753 */     this.SP_Normal.setAutoscrolls(true);
/*  754 */     this.TA_Normal.setColumns(20);
/*  755 */     this.TA_Normal.setEditable(false);
/*  756 */     this.TA_Normal.setRows(5);
/*  757 */     this.TA_Normal.setEnabled(false);
/*  758 */     this.SP_Normal.setViewportView(this.TA_Normal);
/*  759 */     this.TP.addTab("一般", this.SP_Normal);
/*  760 */     this.SP_.setAutoscrolls(true);
/*  761 */     this.TA_Private.setColumns(20);
/*  762 */     this.TA_Private.setEditable(false);
/*  763 */     this.TA_Private.setForeground(new Color(174, 238, 238));
/*  764 */     this.TA_Private.setRows(5);
/*  765 */     this.TA_Private.setEnabled(false);
/*  766 */     this.SP_.setViewportView(this.TA_Private);
/*  767 */     this.TP.addTab("密語", this.SP_);
/*  768 */     this.SP_Clan.setAutoscrolls(true);
/*  769 */     this.TA_Clan.setColumns(20);
/*  770 */     this.TA_Clan.setEditable(false);
/*  771 */     this.TA_Clan.setForeground(new Color(174, 238, 238));
/*  772 */     this.TA_Clan.setRows(5);
/*  773 */     this.TA_Clan.setEnabled(false);
/*  774 */     this.SP_Clan.setViewportView(this.TA_Clan);
/*  775 */     this.TP.addTab("血盟", this.SP_Clan);
/*  776 */     this.SP_Team.setAutoscrolls(true);
/*  777 */     this.TA_Team.setColumns(20);
/*  778 */     this.TA_Team.setEditable(false);
/*  779 */     this.TA_Team.setForeground(new Color(174, 238, 238));
/*  780 */     this.TA_Team.setRows(5);
/*  781 */     this.TA_Team.setEnabled(false);
/*  782 */     this.SP_Team.setViewportView(this.TA_Team);
/*  783 */     this.TP.addTab("組隊", this.SP_Team);
/*  784 */     this.SP_Split.setLeftComponent(this.TP);
/*  785 */     this.T_Player.addMouseListener(new MouseAdapter()
/*      */         {
/*      */           public void mousePressed(MouseEvent evt) {
/*  788 */             J_Main.this.T_PlayerMousePressed(evt);
/*      */           }
/*      */ 
/*      */           
/*      */           public void mouseReleased(MouseEvent evt) {
/*  793 */             J_Main.this.T_PlayerMouseReleased(evt);
/*      */           }
/*      */         });
/*  796 */     this.SP_player.setViewportView(this.T_Player);
/*  797 */     this.SP_Split.setRightComponent(this.SP_player);
/*  798 */     getContentPane().add(this.SP_Split, "Center");
/*  799 */     this.CB_Channel.setModel(new DefaultComboBoxModel((Object[])new String[] { "訊息頻道", "密語" }));
/*  800 */     this.B_Submit.setText("發送");
/*  801 */     this.B_Submit.addActionListener(new ActionListener()
/*      */         {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  804 */             J_Main.this.B_SubmitActionPerformed(evt);
/*      */           }
/*      */         });
/*  807 */     this.TF_Msg.addKeyListener(new KeyAdapter()
/*      */         {
/*      */           public void keyPressed(KeyEvent evt) {
/*  810 */             J_Main.this.TF_MsgKeyPressed(evt);
/*      */           }
/*      */         });
/*  813 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  814 */     this.jPanel2.setLayout(jPanel2Layout);
/*  815 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  816 */         .addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.CB_Channel, -2, -1, -2)
/*  817 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.TF_Target, -2, 68, -2)
/*  818 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.TF_Msg, -2, 310, -2)
/*  819 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.B_Submit)
/*  820 */           .addGap(175, 175, 175)));
/*  821 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  822 */         .addGroup(jPanel2Layout.createSequentialGroup().addGap(6, 6, 6)
/*  823 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  824 */             .addComponent(this.CB_Channel, -2, -1, -2).addComponent(this.TF_Target, -2, -1, -2)
/*  825 */             .addComponent(this.TF_Msg, -2, -1, -2).addComponent(this.B_Submit))));
/*  826 */     getContentPane().add(this.jPanel2, "South");
/*  827 */     this.M_File.setMnemonic('F');
/*  828 */     this.M_File.setText("檔案(F)");
/*  829 */     this.MI_Save.setAccelerator(KeyStroke.getKeyStroke(83, 2));
/*  830 */     this.MI_Save.setMnemonic('S');
/*  831 */     this.MI_Save.setText("儲存訊息(S)");
/*  832 */     this.M_File.add(this.MI_Save);
/*  833 */     this.M_File.add(this.jSeparator3);
/*  834 */     this.MI_SetClose.setAccelerator(KeyStroke.getKeyStroke(69, 2));
/*  835 */     this.MI_SetClose.setMnemonic('E');
/*  836 */     this.MI_SetClose.setText("設定關閉伺服器(E)...");
/*  837 */     this.M_File.add(this.MI_SetClose);
/*  838 */     this.MI_Close.setMnemonic('C');
/*  839 */     this.MI_Close.setText("關閉伺服器(C)");
/*  840 */     this.M_File.add(this.MI_Close);
/*  841 */     this.MB.add(this.M_File);
/*  842 */     this.M_Edit.setMnemonic('E');
/*  843 */     this.M_Edit.setText("編輯(E)");
/*  844 */     this.MI_LA.setMnemonic('W');
/*  845 */     this.MI_LA.setText("正義倍率(W)");
/*  846 */     this.M_Edit.add(this.MI_LA);
/*  847 */     this.MI_ATTR_ENCHANT_CHANCE.setMnemonic('X');
/*  848 */     this.MI_ATTR_ENCHANT_CHANCE.setText("屬性強化倍率(X)");
/*  849 */     this.M_Edit.add(this.MI_ATTR_ENCHANT_CHANCE);
/*  850 */     this.MI_CHANCE_ARMOR.setMnemonic('S');
/*  851 */     this.MI_CHANCE_ARMOR.setText("防具強化倍率(S)");
/*  852 */     this.M_Edit.add(this.MI_CHANCE_ARMOR);
/*  853 */     this.MI_CHANCE_WEAPON.setMnemonic('Q');
/*  854 */     this.MI_CHANCE_WEAPON.setText("武器強化倍率(Q)");
/*  855 */     this.M_Edit.add(this.MI_CHANCE_WEAPON);
/*  856 */     this.MI_XP_PET.setMnemonic('G');
/*  857 */     this.MI_XP_PET.setText("寵物經驗倍率(G)");
/*  858 */     this.M_Edit.add(this.MI_XP_PET);
/*  859 */     this.MI_Exp.setMnemonic('F');
/*  860 */     this.MI_Exp.setText("經驗倍率(F)");
/*  861 */     this.M_Edit.add(this.MI_Exp);
/*  862 */     this.MI_Exp.setMnemonic('F');
/*  863 */     this.MI_Exp.setText("經驗倍率(F)");
/*  864 */     this.MI_Drop.setMnemonic('D');
/*  865 */     this.MI_Drop.setText("掉寶率(D)");
/*  866 */     this.MI_Adena.setMnemonic('M');
/*  867 */     this.MI_Adena.setText("掉錢倍率(M)");
/*  868 */     this.M_Edit.add(this.MI_Exp);
/*  869 */     this.M_Edit.add(this.MI_Drop);
/*  870 */     this.M_Edit.add(this.MI_Adena);
/*  871 */     this.MB.add(this.M_Edit);
/*  872 */     this.M_Special.setMnemonic('S');
/*  873 */     this.M_Special.setText("特殊功能(S)");
/*  874 */     this.MI_Angel.setMnemonic('A');
/*  875 */     this.MI_Angel.setText("大天使祝福(A)");
/*  876 */     this.M_Special.add(this.MI_Angel);
/*  877 */     this.MI_AllBuff.setMnemonic('B');
/*  878 */     this.MI_AllBuff.setText("終極祝福(B)");
/*  879 */     this.M_Special.add(this.MI_AllBuff);
/*  880 */     this.MI_AllRess.setMnemonic('R');
/*  881 */     this.MI_AllRess.setText("全體復活補血魔(R)");
/*  882 */     this.M_Special.add(this.MI_AllRess);
/*  883 */     this.MB.add(this.M_Special);
/*  884 */     setJMenuBar(this.MB);
/*  885 */     pack();
/*      */   }
/*      */   
/*      */   private void T_PlayerMouseReleased(MouseEvent evt) {
/*  889 */     if (evt.getClickCount() == 2 && evt.getButton() == 1) {
/*  890 */       this.select = this.T_Player.getSelectedRow();
/*  891 */       setPlayerView((String)this.DTM.getValueAt(this.select, 1));
/*  892 */       this.F_Player.pack();
/*  893 */       this.F_Player.setVisible(true);
/*      */     } 
/*  895 */     if (evt.isPopupTrigger()) {
/*  896 */       this.select = this.T_Player.getSelectedRow();
/*  897 */       this.PM_Player.show(this.T_Player, evt.getX(), evt.getY());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void formWindowClosed(WindowEvent evt) {
/*  902 */     closeServer();
/*      */   }
/*      */   
/*      */   private void closeServer() {
/*  906 */     saveChatData(false);
/*  907 */     System.exit(0);
/*      */   }
/*      */   
/*      */   private void T_PlayerMousePressed(MouseEvent evt) {
/*  911 */     processEvent(evt);
/*      */   }
/*      */   
/*      */   private void B_SubmitActionPerformed(ActionEvent evt) {
/*  915 */     submitMsg(this.CB_Channel.getSelectedIndex());
/*      */   }
/*      */   
/*      */   private void TF_MsgKeyPressed(KeyEvent evt) {
/*  919 */     if (evt.getKeyCode() == 10)
/*  920 */       submitMsg(this.CB_Channel.getSelectedIndex()); 
/*      */   }
/*      */   
/*      */   private void submitMsg(int select) {
/*      */     L1PcInstance target;
/*  925 */     if (this.TF_Msg.getText().equals("")) {
/*      */       return;
/*      */     }
/*  928 */     switch (select) {
/*      */       case 0:
/*  930 */         World.get().broadcastServerMessage("【管理器訊息】:" + this.TF_Msg.getText());
/*  931 */         addWorldChat("【管理器】", this.TF_Msg.getText());
/*      */         break;
/*      */       
/*      */       case 1:
/*  935 */         if (World.get().getPlayer(this.TF_Target.getText()) == null) {
/*      */           return;
/*      */         }
/*  938 */         target = World.get().getPlayer(this.TF_Target.getText());
/*  939 */         target.sendPackets((ServerBasePacket)new S_SystemMessage("【管理器密語】:" + this.TF_Msg.getText()));
/*  940 */         addPrivateChat("【管理器】", this.TF_Target.getText(), this.TF_Msg.getText());
/*      */         break;
/*      */     } 
/*      */     
/*  944 */     this.TF_Msg.setText(""); } private void showItemTable(int num) { L1PcInventory l1PcInventory; L1DwarfInventory l1DwarfInventory;
/*      */     L1DwarfForClanInventory l1DwarfForClanInventory;
/*      */     L1DwarfForElfInventory l1DwarfForElfInventory;
/*      */     Iterator<L1ItemInstance> iterator, iterator2, iterator3, iterator4;
/*  948 */     iniTable();
/*  949 */     L1PcInstance pc = L1PcInstance.load(this.TF_Name.getText());
/*  950 */     if (pc.getInventory().getSize() == 0) {
/*  951 */       C_LoginToServer.items(pc);
/*      */     }
/*  953 */     L1Inventory inv = null;
/*  954 */     switch (num) {
/*      */       case 0:
/*  956 */         if (pc.getInventory() == null) {
/*      */           return;
/*      */         }
/*  959 */         l1PcInventory = pc.getInventory();
/*  960 */         this.D_Item.setTitle("身上物品");
/*  961 */         iterator = l1PcInventory.getItems().iterator();
/*  962 */         while (iterator.hasNext()) {
/*  963 */           L1ItemInstance item = iterator.next();
/*  964 */           addItemTable(item.getName(), item.getCount(), item.getItemId());
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 1:
/*  969 */         if (pc.getDwarfInventory() == null) {
/*      */           return;
/*      */         }
/*  972 */         this.D_Item.setTitle("倉庫物品");
/*  973 */         l1DwarfInventory = pc.getDwarfInventory();
/*  974 */         iterator2 = l1DwarfInventory.getItems().iterator();
/*  975 */         while (iterator2.hasNext()) {
/*  976 */           L1ItemInstance item = iterator2.next();
/*  977 */           addItemTable(item.getName(), item.getCount(), item.getItemId());
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 2:
/*  982 */         if (pc.getClan().getDwarfForClanInventory() == null) {
/*      */           return;
/*      */         }
/*  985 */         this.D_Item.setTitle("血盟倉庫物品");
/*  986 */         l1DwarfForClanInventory = pc.getClan().getDwarfForClanInventory();
/*  987 */         iterator3 = l1DwarfForClanInventory.getItems().iterator();
/*  988 */         while (iterator3.hasNext()) {
/*  989 */           L1ItemInstance item = iterator3.next();
/*  990 */           addItemTable(item.getName(), item.getCount(), item.getItemId());
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 3:
/*  995 */         if (pc.getDwarfForElfInventory() == null) {
/*      */           return;
/*      */         }
/*  998 */         this.D_Item.setTitle("妖森倉庫物品");
/*  999 */         l1DwarfForElfInventory = pc.getDwarfForElfInventory();
/* 1000 */         iterator4 = l1DwarfForElfInventory.getItems().iterator();
/* 1001 */         while (iterator4.hasNext()) {
/* 1002 */           L1ItemInstance item = iterator4.next();
/* 1003 */           addItemTable(item.getName(), item.getCount(), item.getItemId());
/*      */         } 
/*      */         break;
/*      */     } 
/*      */     
/* 1008 */     this.D_Item.setVisible(true); }
/*      */ 
/*      */   
/*      */   private void B_ItemActionPerformed(ActionEvent evt) {
/* 1012 */     showItemTable(this.CB_Item.getSelectedIndex());
/*      */   }
/*      */   
/*      */   private void setPlayerView(String name) {
/* 1016 */     L1PcInstance pc = L1PcInstance.load(name);
/* 1017 */     int job = 0;
/* 1018 */     switch (pc.getClassId()) {
/*      */       case 0:
/* 1020 */         job = 715;
/*      */         break;
/*      */       
/*      */       case 1:
/* 1024 */         job = 647;
/*      */         break;
/*      */       
/*      */       case 61:
/* 1028 */         job = 384;
/*      */         break;
/*      */       
/*      */       case 48:
/* 1032 */         job = 317;
/*      */         break;
/*      */       
/*      */       case 138:
/* 1036 */         job = 247;
/*      */         break;
/*      */       
/*      */       case 37:
/* 1040 */         job = 198;
/*      */         break;
/*      */       
/*      */       case 734:
/* 1044 */         job = 532;
/*      */         break;
/*      */       
/*      */       case 1186:
/* 1048 */         job = 452;
/*      */         break;
/*      */       
/*      */       case 2786:
/* 1052 */         job = 145;
/*      */         break;
/*      */       
/*      */       case 2796:
/* 1056 */         job = 25;
/*      */         break;
/*      */       
/*      */       case 6658:
/* 1060 */         job = 903;
/*      */         break;
/*      */       
/*      */       case 6661:
/* 1064 */         job = 930;
/*      */         break;
/*      */       
/*      */       case 6671:
/* 1068 */         job = 1029;
/*      */         break;
/*      */       
/*      */       case 6650:
/* 1072 */         job = 1056;
/*      */         break;
/*      */     } 
/*      */     
/*      */     Icon icon;
/* 1077 */     ImageIcon imageIcon = (ImageIcon)(icon = new ImageIcon("img/" + job + ".png"));
/* 1078 */     this.L_Image.setIcon(icon);
/* 1079 */     this.TF_Account.setText(pc.getAccountName());
/* 1080 */     this.TF_Name.setText(pc.getName());
/* 1081 */     this.TF_Title.setText(pc.getTitle());
/* 1082 */     this.TF_AccessLevel.setText(pc.getAccessLevel());
/* 1083 */     this.TF_Sex.setText((pc.get_sex() == 1) ? "女" : "男");
/* 1084 */     this.TF_Ac.setText((new StringBuilder(String.valueOf(pc.getAc()))).toString());
/* 1085 */     this.TF_Cha.setText((new StringBuilder(String.valueOf(pc.getCha()))).toString());
/* 1086 */     this.TF_Int.setText((new StringBuilder(String.valueOf(pc.getInt()))).toString());
/* 1087 */     this.TF_Str.setText((new StringBuilder(String.valueOf(pc.getStr()))).toString());
/* 1088 */     this.TF_Con.setText((new StringBuilder(String.valueOf(pc.getCon()))).toString());
/* 1089 */     this.TF_Wis.setText((new StringBuilder(String.valueOf(pc.getWis()))).toString());
/* 1090 */     this.TF_Dex.setText((new StringBuilder(String.valueOf(pc.getDex()))).toString());
/* 1091 */     this.TF_Exp.setText((new StringBuilder(String.valueOf(pc.getExp()))).toString());
/* 1092 */     this.TF_Map.setText((new StringBuilder(String.valueOf(pc.getMapId()))).toString());
/* 1093 */     this.TF_X.setText((new StringBuilder(String.valueOf(pc.getX()))).toString());
/* 1094 */     this.TF_Y.setText((new StringBuilder(String.valueOf(pc.getY()))).toString());
/* 1095 */     this.TF_Clan.setText(pc.getClanname());
/* 1096 */     this.TF_Level.setText((new StringBuilder(String.valueOf(pc.getLevel()))).toString());
/* 1097 */     this.TF_Hp.setText(String.valueOf(String.valueOf(pc.getCurrentHp())) + " / " + pc.getMaxHp());
/* 1098 */     this.TF_Mp.setText(String.valueOf(String.valueOf(pc.getCurrentMp())) + " / " + pc.getMaxMp());
/*      */   }
/*      */   
/*      */   public static void main(String[] args) {
/* 1102 */     EventQueue.invokeLater(new Runnable()
/*      */         {
/*      */           public void run() {
/* 1105 */             (new J_Main()).setVisible(true);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */   
/*      */   public void actionPerformed(ActionEvent e) {
/* 1112 */     String command = e.getActionCommand();
/* 1113 */     if ((e.getModifiers() & 0x10) == 0L && ((e.getModifiers() & 0x4) != 0 || (e.getModifiers() & 0x8) != 0)) {
/*      */       return;
/*      */     }
/* 1116 */     if (command.equals("強制踢除(K)")) {
/* 1117 */       L1PcInstance target = World.get().getPlayer((String)this.DTM.getValueAt(this.select, 1));
/* 1118 */       if (target != null) {
/* 1119 */         addConsol("您把玩家：" + (String)this.DTM.getValueAt(this.select, 1) + "強制剔除遊戲。");
/* 1120 */         target.sendPackets((ServerBasePacket)new S_Disconnect());
/*      */       } else {
/* 1122 */         addConsol("此玩家不在線上。");
/*      */       } 
/* 1124 */     } else if (command.equals("封鎖IP(B)")) {
/* 1125 */       L1PcInstance target = World.get().getPlayer((String)this.DTM.getValueAt(this.select, 2));
/* 1126 */       if (target != null) {
/* 1127 */         ClientExecutor targetClient = target.getNetConnection();
/* 1128 */         String ipaddr = targetClient.getIp().toString();
/* 1129 */         if (ipaddr != null && !LanSecurityManager.BANIPMAP.containsKey(ipaddr)) {
/* 1130 */           IpReading.get().add(ipaddr.toString(), String.valueOf(String.valueOf(getName())) + ":L1PowerKick 封鎖IP");
/*      */         }
/* 1132 */         targetClient.kick();
/*      */       } 
/* 1134 */       addConsol("已封鎖" + target.getName() + "的IP");
/* 1135 */     } else if (command.equals("玩家資料(P)")) {
/* 1136 */       setPlayerView((String)this.DTM.getValueAt(this.select, 1));
/* 1137 */       this.F_Player.pack();
/* 1138 */       this.F_Player.setVisible(true);
/* 1139 */     } else if (command.equals("密語(W)")) {
/* 1140 */       this.TF_Target.setText((String)this.DTM.getValueAt(this.select, 1));
/* 1141 */       this.CB_Channel.setSelectedIndex(1);
/* 1142 */     } else if (command.equals("儲存訊息(S)")) {
/* 1143 */       saveChatData(false);
/* 1144 */     } else if (command.equals("大天使祝福(A)")) {
/* 1145 */       angel();
/* 1146 */     } else if (command.equals("關閉伺服器(C)")) {
/* 1147 */       closeServer();
/* 1148 */     } else if (command.equals("正義倍率(W)")) {
/* 1149 */       String temp = "";
/*      */       try {
/* 1151 */         temp = JOptionPane.showInputDialog("當前服務正義倍率：" + ConfigRate.RATE_LA + " 請輸入新倍率：");
/* 1152 */         if (temp == null || temp.equals("")) {
/*      */           return;
/*      */         }
/* 1155 */         int second = Integer.valueOf(temp).intValue();
/* 1156 */         ConfigRate.RATE_LA = second;
/* 1157 */         World.get().broadcastServerMessage("正義倍率變更為：" + ConfigRate.RATE_LA + "倍。");
/* 1158 */         addConsol(" 正義率變更為：" + ConfigRate.RATE_LA + "倍。");
/* 1159 */       } catch (NumberFormatException e2) {
/* 1160 */         JOptionPane.showMessageDialog(this, "請輸入整數!");
/*      */       } 
/* 1162 */     } else if (command.equals("屬性強化倍率(X)")) {
/* 1163 */       String temp = "";
/*      */       try {
/* 1165 */         temp = JOptionPane.showInputDialog("當前服務屬性強化%：" + ConfigRate.ATTR_ENCHANT_CHANCE + " 請輸入新倍率：");
/* 1166 */         if (temp == null || temp.equals("")) {
/*      */           return;
/*      */         }
/* 1169 */         int second = ConfigRate.ATTR_ENCHANT_CHANCE = Integer.valueOf(temp).intValue();
/* 1170 */         World.get().broadcastServerMessage("屬性強化%變更為：" + ConfigRate.ATTR_ENCHANT_CHANCE + "%。");
/* 1171 */         addConsol(" 屬性強化%變更為：" + ConfigRate.ATTR_ENCHANT_CHANCE + "%。");
/* 1172 */       } catch (NumberFormatException e2) {
/* 1173 */         JOptionPane.showMessageDialog(this, "請輸入整數!");
/*      */       } 
/* 1175 */     } else if (command.equals("防具強化倍率(S)")) {
/* 1176 */       String temp = "";
/*      */       try {
/* 1178 */         temp = JOptionPane.showInputDialog("當前服務防具強化倍率：" + ConfigRate.ENCHANT_CHANCE_ARMOR + " 請輸入新倍率：");
/* 1179 */         if (temp == null || temp.equals("")) {
/*      */           return;
/*      */         }
/* 1182 */         int second = ConfigRate.ENCHANT_CHANCE_ARMOR = Integer.valueOf(temp).intValue();
/* 1183 */         World.get().broadcastServerMessage("防具強化%變更為：" + ConfigRate.ENCHANT_CHANCE_ARMOR + "%。");
/* 1184 */         addConsol(" 防具強化率變更為：" + ConfigRate.ENCHANT_CHANCE_ARMOR + "%。");
/* 1185 */       } catch (NumberFormatException e2) {
/* 1186 */         JOptionPane.showMessageDialog(this, "請輸入整數!");
/*      */       } 
/* 1188 */     } else if (command.equals("武器強化倍率(Q)")) {
/* 1189 */       String temp = "";
/*      */       try {
/* 1191 */         temp = JOptionPane.showInputDialog("當前服務武器強化%：" + ConfigRate.ENCHANT_CHANCE_WEAPON + " 請輸入新倍率：");
/* 1192 */         if (temp == null || temp.equals("")) {
/*      */           return;
/*      */         }
/* 1195 */         int second = ConfigRate.ENCHANT_CHANCE_WEAPON = Integer.valueOf(temp).intValue();
/* 1196 */         World.get().broadcastServerMessage("武器強化%變更為：" + ConfigRate.ENCHANT_CHANCE_WEAPON + "%。");
/* 1197 */         addConsol(" 武器強化%變更為：" + ConfigRate.ENCHANT_CHANCE_WEAPON + "%。");
/* 1198 */       } catch (NumberFormatException e2) {
/* 1199 */         JOptionPane.showMessageDialog(this, "請輸入整數!");
/*      */       } 
/* 1201 */     } else if (command.equals("寵物經驗倍率(G)")) {
/* 1202 */       String temp = "";
/*      */       try {
/* 1204 */         temp = JOptionPane.showInputDialog("當前服務器寵物經驗倍率：" + ConfigRate.RATE_XP + " 請輸入新倍率：");
/* 1205 */         if (temp == null || temp.equals("")) {
/*      */           return;
/*      */         }
/* 1208 */         int second = Integer.valueOf(temp).intValue();
/* 1209 */         ConfigRate.RATE_XP = second;
/* 1210 */         World.get().broadcastServerMessage("遊戲寵物經驗倍率變更為：" + ConfigRate.RATE_XP + "倍。");
/* 1211 */         addConsol(" 遊戲寵物經驗倍率變更為：" + ConfigRate.RATE_XP + "倍。");
/* 1212 */       } catch (NumberFormatException e2) {
/* 1213 */         JOptionPane.showMessageDialog(this, "請輸入整數!");
/*      */       } 
/* 1215 */     } else if (command.equals("經驗倍率(F)")) {
/* 1216 */       String temp = "";
/*      */       try {
/* 1218 */         temp = JOptionPane.showInputDialog("當前服務器經驗倍率：" + ConfigRate.RATE_XP + " 請輸入新倍率：");
/* 1219 */         if (temp == null || temp.equals("")) {
/*      */           return;
/*      */         }
/* 1222 */         int second = Integer.valueOf(temp).intValue();
/* 1223 */         ConfigRate.RATE_XP = second;
/* 1224 */         World.get().broadcastServerMessage("遊戲經驗倍率變更為：" + ConfigRate.RATE_XP);
/* 1225 */         addConsol(" 遊戲經驗倍率變更為：" + ConfigRate.RATE_XP);
/* 1226 */       } catch (NumberFormatException e2) {
/* 1227 */         JOptionPane.showMessageDialog(this, "請輸入整數!");
/*      */       } 
/* 1229 */     } else if (command.equals("掉錢倍率(M)")) {
/* 1230 */       String temp = "";
/*      */       try {
/* 1232 */         temp = JOptionPane.showInputDialog("當前服務器掉錢率：" + ConfigRate.RATE_DROP_ADENA + " 請輸入新倍率：");
/* 1233 */         if (temp == null || temp.equals("")) {
/*      */           return;
/*      */         }
/* 1236 */         int second = Integer.valueOf(temp).intValue();
/* 1237 */         ConfigRate.RATE_DROP_ADENA = second;
/* 1238 */         World.get().broadcastServerMessage("掉錢倍率變更為：" + ConfigRate.RATE_DROP_ADENA);
/* 1239 */         addConsol(" 掉錢倍率變更為：" + ConfigRate.RATE_DROP_ADENA);
/* 1240 */       } catch (NumberFormatException e2) {
/* 1241 */         JOptionPane.showMessageDialog(this, "請輸入整數!");
/*      */       } 
/* 1243 */     } else if (command.equals("掉寶率(D)")) {
/* 1244 */       String temp = "";
/*      */       try {
/* 1246 */         temp = JOptionPane.showInputDialog("當前服務器掉寶倍率：" + ConfigRate.RATE_DROP_ITEMS + " 請輸入新倍率：");
/* 1247 */         if (temp == null || temp.equals("")) {
/*      */           return;
/*      */         }
/* 1250 */         int second = Integer.valueOf(temp).intValue();
/* 1251 */         ConfigRate.RATE_DROP_ITEMS = second;
/* 1252 */         World.get().broadcastServerMessage("掉寶率變更為：" + ConfigRate.RATE_DROP_ITEMS);
/* 1253 */         addConsol(" 掉寶率變更為：" + ConfigRate.RATE_DROP_ITEMS);
/* 1254 */       } catch (NumberFormatException e2) {
/* 1255 */         JOptionPane.showMessageDialog(this, "請輸入整數!");
/*      */       } 
/* 1257 */     } else if (command.equals("設定關閉伺服器(E)...")) {
/* 1258 */       String temp = "";
/*      */       try {
/* 1260 */         temp = JOptionPane.showInputDialog("請輸入幾秒重後重開!");
/* 1261 */         if (temp == null || temp.equals("")) {
/*      */           return;
/*      */         }
/* 1264 */         int second = Integer.valueOf(temp).intValue();
/* 1265 */         if (second == 0) {
/* 1266 */           closeServer();
/*      */         }
/* 1268 */         Shutdown.getInstance().startShutdown(null, second, true);
/* 1269 */         World.get().broadcastServerMessage("伺服器將於(" + second + ")秒鐘後關閉伺服器!");
/* 1270 */         addWorldChat("管理器", "伺服器將於(" + second + ")秒鐘後關閉伺服器!");
/* 1271 */       } catch (NumberFormatException e2) {
/* 1272 */         JOptionPane.showMessageDialog(this, "請輸入整數!");
/*      */       } 
/* 1274 */     } else if (command.equals("終極祝福(B)")) {
/* 1275 */       int[] allBuffSkill = { 14, 26, 42, 48, 55, 68, 79, 88, 89, 90, 98, 102, 104, 105, 106, 111, 114, 117, 
/* 1276 */           129, 137, 147, 160, 163, 168, 169, 170, 171, 175, 176 };
/* 1277 */       Iterator<L1PcInstance> localIterator = World.get().getAllPlayers().iterator();
/* 1278 */       while (localIterator.hasNext()) {
/* 1279 */         L1PcInstance targetpc = localIterator.next();
/* 1280 */         L1BuffUtil.haste(targetpc, 3600000);
/* 1281 */         L1BuffUtil.brave(targetpc, 3600000);
/*      */         
/* 1283 */         int array[], length = (array = allBuffSkill).length;
/* 1284 */         int i = 0;
/* 1285 */         while (i < length) {
/* 1286 */           int element = array[i];
/* 1287 */           if (element == 26 || element == 42) {
/* 1288 */             L1Skills skill = SkillsTable.get().getTemplate(element);
/* 1289 */             (new L1SkillUse()).handleCommands(targetpc, element, targetpc.getId(), targetpc.getX(), 
/* 1290 */                 targetpc.getY(), skill.getBuffDuration(), 4);
/*      */           } else {
/* 1292 */             L1Skills skill = SkillsTable.get().getTemplate(element);
/* 1293 */             (new L1SkillUse()).handleCommands(targetpc, element, targetpc.getId(), targetpc.getX(), 
/* 1294 */                 targetpc.getY(), skill.getBuffDuration(), 4);
/*      */           } 
/* 1296 */           i++;
/*      */         } 
/* 1298 */         targetpc.sendPackets((ServerBasePacket)new S_ServerMessage(166, "祝福降臨人世,全體玩家得到祝福GM是個大好人"));
/*      */       } 
/* 1300 */     } else if (command.equals("全體復活補血魔(R)")) {
/* 1301 */       Iterator<L1PcInstance> iterator = World.get().getAllPlayers().iterator();
/* 1302 */       while (iterator.hasNext()) {
/* 1303 */         L1PcInstance tg = iterator.next();
/* 1304 */         if (tg.getCurrentHp() == 0 && tg.isDead()) {
/* 1305 */           tg.sendPackets((ServerBasePacket)new S_SystemMessage("GM幫你復活嚕。"));
/* 1306 */           tg.broadcastPacketX10((ServerBasePacket)new S_SkillSound(tg.getId(), 3944));
/* 1307 */           tg.sendPackets((ServerBasePacket)new S_SkillSound(tg.getId(), 3944));
/* 1308 */           tg.setTempID(tg.getId());
/* 1309 */           tg.sendPackets((ServerBasePacket)new S_Message_YN(322, "")); continue;
/*      */         } 
/* 1311 */         tg.sendPackets((ServerBasePacket)new S_SystemMessage("GM幫你治癒嚕。"));
/* 1312 */         tg.broadcastPacketX10((ServerBasePacket)new S_SkillSound(tg.getId(), 832));
/* 1313 */         tg.sendPackets((ServerBasePacket)new S_SkillSound(tg.getId(), 832));
/* 1314 */         tg.setCurrentHp(tg.getMaxHp());
/* 1315 */         tg.setCurrentMp(tg.getMaxMp());
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void angel() {
/* 1322 */     Iterator<L1PcInstance> iterator = World.get().getAllPlayers().iterator();
/* 1323 */     while (iterator.hasNext()) {
/* 1324 */       L1PcInstance pc = iterator.next();
/* 1325 */       if (pc.hasSkillEffect(71)) {
/* 1326 */         pc.sendPackets((ServerBasePacket)new S_ServerMessage(698));
/*      */         return;
/*      */       } 
/* 1329 */       int time = 3600;
/* 1330 */       if (pc.hasSkillEffect(78)) {
/* 1331 */         pc.killSkillEffectTimer(78);
/* 1332 */         pc.startHpRegeneration();
/* 1333 */         pc.startMpRegeneration();
/* 1334 */         pc.startMpRegeneration();
/*      */       } 
/* 1336 */       if (pc.hasSkillEffect(1016)) {
/* 1337 */         pc.killSkillEffectTimer(1016);
/* 1338 */         pc.sendPackets((ServerBasePacket)new S_SkillBrave(pc.getId(), 0, 0));
/* 1339 */         pc.broadcastPacketX10((ServerBasePacket)new S_SkillBrave(pc.getId(), 0, 0));
/* 1340 */         pc.setBraveSpeed(0);
/*      */       } 
/* 1342 */       if (pc.hasSkillEffect(52)) {
/* 1343 */         pc.killSkillEffectTimer(52);
/* 1344 */         pc.sendPackets((ServerBasePacket)new S_SkillBrave(pc.getId(), 0, 0));
/* 1345 */         pc.broadcastPacketX10((ServerBasePacket)new S_SkillBrave(pc.getId(), 0, 0));
/* 1346 */         pc.setBraveSpeed(0);
/*      */       } 
/* 1348 */       if (pc.hasSkillEffect(101)) {
/* 1349 */         pc.killSkillEffectTimer(101);
/* 1350 */         pc.sendPackets((ServerBasePacket)new S_SkillBrave(pc.getId(), 0, 0));
/* 1351 */         pc.broadcastPacketX10((ServerBasePacket)new S_SkillBrave(pc.getId(), 0, 0));
/* 1352 */         pc.setBraveSpeed(0);
/*      */       } 
/* 1354 */       if (pc.hasSkillEffect(150)) {
/* 1355 */         pc.killSkillEffectTimer(150);
/* 1356 */         pc.sendPackets((ServerBasePacket)new S_SkillBrave(pc.getId(), 0, 0));
/* 1357 */         pc.broadcastPacketX10((ServerBasePacket)new S_SkillBrave(pc.getId(), 0, 0));
/* 1358 */         pc.setBraveSpeed(0);
/*      */       } 
/* 1360 */       if (pc.hasSkillEffect(1017)) {
/* 1361 */         pc.killSkillEffectTimer(1017);
/* 1362 */         pc.setBraveSpeed(0);
/*      */       } 
/* 1364 */       pc.sendPackets((ServerBasePacket)new S_SkillBrave(pc.getId(), 1, 3600));
/* 1365 */       pc.broadcastPacketX10((ServerBasePacket)new S_SkillBrave(pc.getId(), 1, 0));
/* 1366 */       pc.sendPackets((ServerBasePacket)new S_SkillSound(pc.getId(), 751));
/* 1367 */       pc.broadcastPacketX10((ServerBasePacket)new S_SkillSound(pc.getId(), 751));
/* 1368 */       pc.setSkillEffect(1000, 3600000);
/* 1369 */       pc.setBraveSpeed(1);
/* 1370 */       pc.setDrink(false);
/* 1371 */       if (pc.hasSkillEffect(43)) {
/* 1372 */         pc.killSkillEffectTimer(43);
/* 1373 */         pc.sendPackets((ServerBasePacket)new S_SkillHaste(pc.getId(), 0, 0));
/* 1374 */         pc.broadcastPacketX10((ServerBasePacket)new S_SkillHaste(pc.getId(), 0, 0));
/* 1375 */         pc.setMoveSpeed(0);
/* 1376 */       } else if (pc.hasSkillEffect(54)) {
/* 1377 */         pc.killSkillEffectTimer(54);
/* 1378 */         pc.sendPackets((ServerBasePacket)new S_SkillHaste(pc.getId(), 0, 0));
/* 1379 */         pc.broadcastPacketX10((ServerBasePacket)new S_SkillHaste(pc.getId(), 0, 0));
/* 1380 */         pc.setMoveSpeed(0);
/* 1381 */       } else if (pc.hasSkillEffect(1001)) {
/* 1382 */         pc.killSkillEffectTimer(1001);
/* 1383 */         pc.sendPackets((ServerBasePacket)new S_SkillHaste(pc.getId(), 0, 0));
/* 1384 */         pc.broadcastPacketX10((ServerBasePacket)new S_SkillHaste(pc.getId(), 0, 0));
/* 1385 */         pc.setMoveSpeed(0);
/*      */       } 
/* 1387 */       if (pc.hasSkillEffect(29)) {
/* 1388 */         pc.killSkillEffectTimer(29);
/* 1389 */         pc.sendPackets((ServerBasePacket)new S_SkillHaste(pc.getId(), 0, 0));
/* 1390 */         pc.broadcastPacketX10((ServerBasePacket)new S_SkillHaste(pc.getId(), 0, 0));
/* 1391 */       } else if (pc.hasSkillEffect(76)) {
/* 1392 */         pc.killSkillEffectTimer(76);
/* 1393 */         pc.sendPackets((ServerBasePacket)new S_SkillHaste(pc.getId(), 0, 0));
/* 1394 */         pc.broadcastPacketX10((ServerBasePacket)new S_SkillHaste(pc.getId(), 0, 0));
/* 1395 */       } else if (pc.hasSkillEffect(152)) {
/* 1396 */         pc.killSkillEffectTimer(152);
/* 1397 */         pc.sendPackets((ServerBasePacket)new S_SkillHaste(pc.getId(), 0, 0));
/* 1398 */         pc.broadcastPacketX10((ServerBasePacket)new S_SkillHaste(pc.getId(), 0, 0));
/*      */       } else {
/* 1400 */         pc.sendPackets((ServerBasePacket)new S_SkillHaste(pc.getId(), 1, 3600));
/* 1401 */         pc.broadcastPacketX10((ServerBasePacket)new S_SkillHaste(pc.getId(), 1, 0));
/* 1402 */         pc.setMoveSpeed(1);
/* 1403 */         pc.setSkillEffect(1001, 3600000);
/*      */       } 
/* 1405 */       (new L1SkillUse()).handleCommands(pc, 42, pc.getId(), pc.getX(), pc.getY(), 3600, 4);
/* 1406 */       (new L1SkillUse()).handleCommands(pc, 26, pc.getId(), pc.getX(), pc.getY(), 3600, 4);
/* 1407 */       (new L1SkillUse()).handleCommands(pc, 79, pc.getId(), pc.getX(), pc.getY(), 3600, 4);
/* 1408 */       pc.setCurrentHp(pc.getMaxHp());
/* 1409 */       pc.setCurrentMp(pc.getMaxMp());
/*      */     } 
/* 1411 */     World.get().broadcastServerMessage("大天使祝福降臨!所有玩家獲得狀態1小時!");
/*      */   }
/*      */   
/*      */   private void saveChatData(boolean bool) {
/* 1415 */     SimpleDateFormat sdfmt = new SimpleDateFormat("yyyy-MM-dd");
/* 1416 */     Date d = Calendar.getInstance().getTime();
/* 1417 */     String date = " " + sdfmt.format(d);
/*      */     try {
/* 1419 */       FileOutputStream fos = new FileOutputStream("chatLog/Consol" + date + ".txt");
/* 1420 */       fos.write(this.TA_Consol.getText().getBytes());
/* 1421 */       fos.close();
/* 1422 */       fos = new FileOutputStream("chatLog/AllChat" + date + ".txt");
/* 1423 */       fos.write(this.TA_AllChat.getText().getBytes());
/* 1424 */       fos.close();
/* 1425 */       fos = new FileOutputStream("chatLog/World" + date + ".txt");
/* 1426 */       fos.write(this.TA_World.getText().getBytes());
/* 1427 */       fos.close();
/* 1428 */       fos = new FileOutputStream("chatLog/Clan" + date + ".txt");
/* 1429 */       fos.write(this.TA_Clan.getText().getBytes());
/* 1430 */       fos.close();
/* 1431 */       fos = new FileOutputStream("chatLog/Normal" + date + ".txt");
/* 1432 */       fos.write(this.TA_Normal.getText().getBytes());
/* 1433 */       fos.close();
/* 1434 */       fos = new FileOutputStream("chatLog/Team" + date + ".txt");
/* 1435 */       fos.write(this.TA_Team.getText().getBytes());
/* 1436 */       fos.close();
/* 1437 */       fos = new FileOutputStream("chatLog/Whisper" + date + ".txt");
/* 1438 */       fos.write(this.TA_Private.getText().getBytes());
/* 1439 */       fos.close();
/* 1440 */     } catch (Exception e1) {
/* 1441 */       e1.printStackTrace();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void processEvent(MouseEvent e) {
/* 1446 */     if ((e.getModifiers() & 0x4) != 0) {
/* 1447 */       int modifiers = e.getModifiers();
/* 1448 */       modifiers -= 4;
/* 1449 */       modifiers |= 0x10;
/* 1450 */       MouseEvent ne = new MouseEvent(e.getComponent(), e.getID(), e.getWhen(), modifiers, e.getX(), 
/* 1451 */           e.getY(), e.getClickCount(), false);
/* 1452 */       this.T_Player.dispatchEvent(ne);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\eric\gui\J_Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */