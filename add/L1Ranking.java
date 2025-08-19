/*      */ package com.add;
/*      */ 
/*      */ import com.lineage.DatabaseFactory;
/*      */ import com.lineage.server.utils.SQLUtil;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ 
/*      */ public class L1Ranking
/*      */ {
/*      */   public static String[] All() throws SQLException {
/*   13 */     String no1 = "空缺";
/*   14 */     String no2 = "空缺";
/*   15 */     String no3 = "空缺";
/*   16 */     String no4 = "空缺";
/*   17 */     String no5 = "空缺";
/*   18 */     String no6 = "";
/*   19 */     String no7 = "";
/*   20 */     String no8 = "";
/*   21 */     String no9 = "";
/*   22 */     String no10 = "";
/*   23 */     String no11 = "";
/*   24 */     String no12 = "";
/*   25 */     String no13 = "";
/*   26 */     String no14 = "";
/*   27 */     String no15 = "";
/*   28 */     String no16 = "空缺";
/*   29 */     String no17 = "空缺";
/*   30 */     String no18 = "空缺";
/*   31 */     String no19 = "空缺";
/*   32 */     String no20 = "空缺";
/*   33 */     String no21 = "";
/*   34 */     String no22 = "";
/*   35 */     String no23 = "";
/*   36 */     String no24 = "";
/*   37 */     String no25 = "";
/*   38 */     String no26 = "";
/*   39 */     String no27 = "";
/*   40 */     String no28 = "";
/*   41 */     String no29 = "";
/*   42 */     String no30 = "";
/*   43 */     PreparedStatement pstm1 = null;
/*   44 */     PreparedStatement pstm2 = null;
/*   45 */     PreparedStatement pstm3 = null;
/*   46 */     PreparedStatement pstm4 = null;
/*   47 */     PreparedStatement pstm5 = null;
/*   48 */     PreparedStatement pstm6 = null;
/*   49 */     PreparedStatement pstm7 = null;
/*   50 */     PreparedStatement pstm8 = null;
/*   51 */     PreparedStatement pstm9 = null;
/*   52 */     PreparedStatement pstm10 = null;
/*   53 */     ResultSet rs1 = null;
/*   54 */     ResultSet rs2 = null;
/*   55 */     ResultSet rs3 = null;
/*   56 */     ResultSet rs4 = null;
/*   57 */     ResultSet rs5 = null;
/*   58 */     ResultSet rs6 = null;
/*   59 */     ResultSet rs7 = null;
/*   60 */     ResultSet rs8 = null;
/*   61 */     ResultSet rs9 = null;
/*   62 */     ResultSet rs10 = null;
/*   63 */     Connection con = null;
/*   64 */     String[] levelresult = null;
/*   65 */     con = DatabaseFactory.get().getConnection();
/*   66 */     pstm1 = con.prepareStatement(
/*   67 */         "select char_name,level,metelevel from characters where accesslevel = 0  order by (metelevel*1800000000+exp) DESC limit 0,1;");
/*   68 */     pstm2 = con.prepareStatement(
/*   69 */         "select char_name,level,metelevel from characters where accesslevel = 0  order by (metelevel*1800000000+exp) DESC limit 1,1;");
/*   70 */     pstm3 = con.prepareStatement(
/*   71 */         "select char_name,level,metelevel from characters where accesslevel = 0  order by (metelevel*1800000000+exp) DESC limit 2,1;");
/*   72 */     pstm4 = con.prepareStatement(
/*   73 */         "select char_name,level,metelevel from characters where accesslevel = 0  order by (metelevel*1800000000+exp) DESC limit 3,1;");
/*   74 */     pstm5 = con.prepareStatement(
/*   75 */         "select char_name,level,metelevel from characters where accesslevel = 0  order by (metelevel*1800000000+exp) DESC limit 4,1;");
/*   76 */     pstm6 = con.prepareStatement(
/*   77 */         "select char_name,level,metelevel from characters where accesslevel = 0  order by (metelevel*1800000000+exp) DESC limit 5,1;");
/*   78 */     pstm7 = con.prepareStatement(
/*   79 */         "select char_name,level,metelevel from characters where accesslevel = 0  order by (metelevel*1800000000+exp) DESC limit 6,1;");
/*   80 */     pstm8 = con.prepareStatement(
/*   81 */         "select char_name,level,metelevel from characters where accesslevel = 0  order by (metelevel*1800000000+exp) DESC limit 7,1;");
/*   82 */     pstm9 = con.prepareStatement(
/*   83 */         "select char_name,level,metelevel from characters where accesslevel = 0  order by (metelevel*1800000000+exp) DESC limit 8,1;");
/*   84 */     pstm10 = con.prepareStatement(
/*   85 */         "select char_name,level,metelevel from characters where accesslevel = 0  order by (metelevel*1800000000+exp) DESC limit 9,1;");
/*   86 */     rs1 = pstm1.executeQuery();
/*   87 */     if (rs1.next()) {
/*   88 */       no1 = rs1.getString("char_name");
/*   89 */       no6 = rs1.getString("level");
/*   90 */       no11 = rs1.getString("metelevel");
/*      */     } 
/*   92 */     rs2 = pstm2.executeQuery();
/*   93 */     if (rs2.next()) {
/*   94 */       no2 = rs2.getString("char_name");
/*   95 */       no7 = rs2.getString("level");
/*   96 */       no12 = rs2.getString("metelevel");
/*      */     } 
/*   98 */     rs3 = pstm3.executeQuery();
/*   99 */     if (rs3.next()) {
/*  100 */       no3 = rs3.getString("char_name");
/*  101 */       no8 = rs3.getString("level");
/*  102 */       no13 = rs3.getString("metelevel");
/*      */     } 
/*  104 */     rs4 = pstm4.executeQuery();
/*  105 */     if (rs4.next()) {
/*  106 */       no4 = rs4.getString("char_name");
/*  107 */       no9 = rs4.getString("level");
/*  108 */       no14 = rs4.getString("metelevel");
/*      */     } 
/*  110 */     rs5 = pstm5.executeQuery();
/*  111 */     if (rs5.next()) {
/*  112 */       no5 = rs5.getString("char_name");
/*  113 */       no10 = rs5.getString("level");
/*  114 */       no15 = rs5.getString("metelevel");
/*      */     } 
/*  116 */     rs6 = pstm6.executeQuery();
/*  117 */     if (rs6.next()) {
/*  118 */       no16 = rs6.getString("char_name");
/*  119 */       no21 = rs6.getString("level");
/*  120 */       no26 = rs6.getString("metelevel");
/*      */     } 
/*  122 */     rs7 = pstm7.executeQuery();
/*  123 */     if (rs7.next()) {
/*  124 */       no17 = rs7.getString("char_name");
/*  125 */       no22 = rs7.getString("level");
/*  126 */       no27 = rs7.getString("metelevel");
/*      */     } 
/*  128 */     rs8 = pstm8.executeQuery();
/*  129 */     if (rs8.next()) {
/*  130 */       no18 = rs8.getString("char_name");
/*  131 */       no23 = rs8.getString("level");
/*  132 */       no28 = rs8.getString("metelevel");
/*      */     } 
/*  134 */     rs9 = pstm9.executeQuery();
/*  135 */     if (rs9.next()) {
/*  136 */       no19 = rs9.getString("char_name");
/*  137 */       no24 = rs9.getString("level");
/*  138 */       no29 = rs9.getString("metelevel");
/*      */     } 
/*  140 */     rs10 = pstm10.executeQuery();
/*  141 */     if (rs10.next()) {
/*  142 */       no20 = rs10.getString("char_name");
/*  143 */       no25 = rs10.getString("level");
/*  144 */       no30 = rs10.getString("metelevel");
/*      */     } 
/*  146 */     levelresult = new String[] { "", String.valueOf(no1), String.valueOf(no2), String.valueOf(no3), 
/*  147 */         String.valueOf(no4), String.valueOf(no5), String.valueOf(no6), String.valueOf(no7), String.valueOf(no8), 
/*  148 */         String.valueOf(no9), String.valueOf(no10), String.valueOf(no11), String.valueOf(no12), 
/*  149 */         String.valueOf(no13), String.valueOf(no14), String.valueOf(no15), String.valueOf(no16), 
/*  150 */         String.valueOf(no17), String.valueOf(no18), String.valueOf(no19), String.valueOf(no20), 
/*  151 */         String.valueOf(no21), String.valueOf(no22), String.valueOf(no23), String.valueOf(no24), 
/*  152 */         String.valueOf(no25), String.valueOf(no26), String.valueOf(no27), String.valueOf(no28), 
/*  153 */         String.valueOf(no29), String.valueOf(no30) };
/*  154 */     SQLUtil.close(rs1);
/*  155 */     SQLUtil.close(rs2);
/*  156 */     SQLUtil.close(rs3);
/*  157 */     SQLUtil.close(rs4);
/*  158 */     SQLUtil.close(rs5);
/*  159 */     SQLUtil.close(rs6);
/*  160 */     SQLUtil.close(rs7);
/*  161 */     SQLUtil.close(rs8);
/*  162 */     SQLUtil.close(rs9);
/*  163 */     SQLUtil.close(rs10);
/*  164 */     SQLUtil.close(pstm1);
/*  165 */     SQLUtil.close(pstm2);
/*  166 */     SQLUtil.close(pstm3);
/*  167 */     SQLUtil.close(pstm4);
/*  168 */     SQLUtil.close(pstm5);
/*  169 */     SQLUtil.close(pstm6);
/*  170 */     SQLUtil.close(pstm7);
/*  171 */     SQLUtil.close(pstm8);
/*  172 */     SQLUtil.close(pstm9);
/*  173 */     SQLUtil.close(pstm10);
/*  174 */     SQLUtil.close(con);
/*  175 */     return levelresult;
/*      */   }
/*      */   
/*      */   public static String[] Crown() throws SQLException {
/*  179 */     String no1 = "空缺";
/*  180 */     String no2 = "空缺";
/*  181 */     String no3 = "空缺";
/*  182 */     String no4 = "空缺";
/*  183 */     String no5 = "空缺";
/*  184 */     String no6 = "";
/*  185 */     String no7 = "";
/*  186 */     String no8 = "";
/*  187 */     String no9 = "";
/*  188 */     String no10 = "";
/*  189 */     String no11 = "";
/*  190 */     String no12 = "";
/*  191 */     String no13 = "";
/*  192 */     String no14 = "";
/*  193 */     String no15 = "";
/*  194 */     String no16 = "空缺";
/*  195 */     String no17 = "空缺";
/*  196 */     String no18 = "空缺";
/*  197 */     String no19 = "空缺";
/*  198 */     String no20 = "空缺";
/*  199 */     String no21 = "";
/*  200 */     String no22 = "";
/*  201 */     String no23 = "";
/*  202 */     String no24 = "";
/*  203 */     String no25 = "";
/*  204 */     String no26 = "";
/*  205 */     String no27 = "";
/*  206 */     String no28 = "";
/*  207 */     String no29 = "";
/*  208 */     String no30 = "";
/*  209 */     PreparedStatement pstm1 = null;
/*  210 */     PreparedStatement pstm2 = null;
/*  211 */     PreparedStatement pstm3 = null;
/*  212 */     PreparedStatement pstm4 = null;
/*  213 */     PreparedStatement pstm5 = null;
/*  214 */     PreparedStatement pstm6 = null;
/*  215 */     PreparedStatement pstm7 = null;
/*  216 */     PreparedStatement pstm8 = null;
/*  217 */     PreparedStatement pstm9 = null;
/*  218 */     PreparedStatement pstm10 = null;
/*  219 */     ResultSet rs1 = null;
/*  220 */     ResultSet rs2 = null;
/*  221 */     ResultSet rs3 = null;
/*  222 */     ResultSet rs4 = null;
/*  223 */     ResultSet rs5 = null;
/*  224 */     ResultSet rs6 = null;
/*  225 */     ResultSet rs7 = null;
/*  226 */     ResultSet rs8 = null;
/*  227 */     ResultSet rs9 = null;
/*  228 */     ResultSet rs10 = null;
/*  229 */     Connection con = null;
/*  230 */     String[] levelresult = null;
/*  231 */     con = DatabaseFactory.get().getConnection();
/*  232 */     pstm1 = con.prepareStatement(
/*  233 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 0 || class = 1) order by (metelevel*1800000000+exp) DESC limit 0,1;");
/*  234 */     pstm2 = con.prepareStatement(
/*  235 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 0 || class = 1) order by (metelevel*1800000000+exp) DESC limit 1,1;");
/*  236 */     pstm3 = con.prepareStatement(
/*  237 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 0 || class = 1) order by (metelevel*1800000000+exp) DESC limit 2,1;");
/*  238 */     pstm4 = con.prepareStatement(
/*  239 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 0 || class = 1) order by (metelevel*1800000000+exp) DESC limit 3,1;");
/*  240 */     pstm5 = con.prepareStatement(
/*  241 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 0 || class = 1) order by (metelevel*1800000000+exp) DESC limit 4,1;");
/*  242 */     pstm6 = con.prepareStatement(
/*  243 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 0 || class = 1) order by (metelevel*1800000000+exp) DESC limit 5,1;");
/*  244 */     pstm7 = con.prepareStatement(
/*  245 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 0 || class = 1) order by (metelevel*1800000000+exp) DESC limit 6,1;");
/*  246 */     pstm8 = con.prepareStatement(
/*  247 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 0 || class = 1) order by (metelevel*1800000000+exp) DESC limit 7,1;");
/*  248 */     pstm9 = con.prepareStatement(
/*  249 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 0 || class = 1) order by (metelevel*1800000000+exp) DESC limit 8,1;");
/*  250 */     pstm10 = con.prepareStatement(
/*  251 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 0 || class = 1) order by (metelevel*1800000000+exp) DESC limit 9,1;");
/*  252 */     rs1 = pstm1.executeQuery();
/*  253 */     if (rs1.next()) {
/*  254 */       no1 = rs1.getString("char_name");
/*  255 */       no6 = rs1.getString("level");
/*  256 */       no11 = rs1.getString("metelevel");
/*      */     } 
/*  258 */     rs2 = pstm2.executeQuery();
/*  259 */     if (rs2.next()) {
/*  260 */       no2 = rs2.getString("char_name");
/*  261 */       no7 = rs2.getString("level");
/*  262 */       no12 = rs2.getString("metelevel");
/*      */     } 
/*  264 */     rs3 = pstm3.executeQuery();
/*  265 */     if (rs3.next()) {
/*  266 */       no3 = rs3.getString("char_name");
/*  267 */       no8 = rs3.getString("level");
/*  268 */       no13 = rs3.getString("metelevel");
/*      */     } 
/*  270 */     rs4 = pstm4.executeQuery();
/*  271 */     if (rs4.next()) {
/*  272 */       no4 = rs4.getString("char_name");
/*  273 */       no9 = rs4.getString("level");
/*  274 */       no14 = rs4.getString("metelevel");
/*      */     } 
/*  276 */     rs5 = pstm5.executeQuery();
/*  277 */     if (rs5.next()) {
/*  278 */       no5 = rs5.getString("char_name");
/*  279 */       no10 = rs5.getString("level");
/*  280 */       no15 = rs5.getString("metelevel");
/*      */     } 
/*  282 */     rs6 = pstm6.executeQuery();
/*  283 */     if (rs6.next()) {
/*  284 */       no16 = rs6.getString("char_name");
/*  285 */       no21 = rs6.getString("level");
/*  286 */       no26 = rs6.getString("metelevel");
/*      */     } 
/*  288 */     rs7 = pstm7.executeQuery();
/*  289 */     if (rs7.next()) {
/*  290 */       no17 = rs7.getString("char_name");
/*  291 */       no22 = rs7.getString("level");
/*  292 */       no27 = rs7.getString("metelevel");
/*      */     } 
/*  294 */     rs8 = pstm8.executeQuery();
/*  295 */     if (rs8.next()) {
/*  296 */       no18 = rs8.getString("char_name");
/*  297 */       no23 = rs8.getString("level");
/*  298 */       no28 = rs8.getString("metelevel");
/*      */     } 
/*  300 */     rs9 = pstm9.executeQuery();
/*  301 */     if (rs9.next()) {
/*  302 */       no19 = rs9.getString("char_name");
/*  303 */       no24 = rs9.getString("level");
/*  304 */       no29 = rs9.getString("metelevel");
/*      */     } 
/*  306 */     rs10 = pstm10.executeQuery();
/*  307 */     if (rs10.next()) {
/*  308 */       no20 = rs10.getString("char_name");
/*  309 */       no25 = rs10.getString("level");
/*  310 */       no30 = rs10.getString("metelevel");
/*      */     } 
/*  312 */     levelresult = new String[] { "", String.valueOf(no1), String.valueOf(no2), String.valueOf(no3), 
/*  313 */         String.valueOf(no4), String.valueOf(no5), String.valueOf(no6), String.valueOf(no7), String.valueOf(no8), 
/*  314 */         String.valueOf(no9), String.valueOf(no10), String.valueOf(no11), String.valueOf(no12), 
/*  315 */         String.valueOf(no13), String.valueOf(no14), String.valueOf(no15), String.valueOf(no16), 
/*  316 */         String.valueOf(no17), String.valueOf(no18), String.valueOf(no19), String.valueOf(no20), 
/*  317 */         String.valueOf(no21), String.valueOf(no22), String.valueOf(no23), String.valueOf(no24), 
/*  318 */         String.valueOf(no25), String.valueOf(no26), String.valueOf(no27), String.valueOf(no28), 
/*  319 */         String.valueOf(no29), String.valueOf(no30) };
/*  320 */     SQLUtil.close(rs1);
/*  321 */     SQLUtil.close(rs2);
/*  322 */     SQLUtil.close(rs3);
/*  323 */     SQLUtil.close(rs4);
/*  324 */     SQLUtil.close(rs5);
/*  325 */     SQLUtil.close(rs6);
/*  326 */     SQLUtil.close(rs7);
/*  327 */     SQLUtil.close(rs8);
/*  328 */     SQLUtil.close(rs9);
/*  329 */     SQLUtil.close(rs10);
/*  330 */     SQLUtil.close(pstm1);
/*  331 */     SQLUtil.close(pstm2);
/*  332 */     SQLUtil.close(pstm3);
/*  333 */     SQLUtil.close(pstm4);
/*  334 */     SQLUtil.close(pstm5);
/*  335 */     SQLUtil.close(pstm6);
/*  336 */     SQLUtil.close(pstm7);
/*  337 */     SQLUtil.close(pstm8);
/*  338 */     SQLUtil.close(pstm9);
/*  339 */     SQLUtil.close(pstm10);
/*  340 */     SQLUtil.close(con);
/*  341 */     return levelresult;
/*      */   }
/*      */   
/*      */   public static String[] Elf() throws SQLException {
/*  345 */     String no1 = "空缺";
/*  346 */     String no2 = "空缺";
/*  347 */     String no3 = "空缺";
/*  348 */     String no4 = "空缺";
/*  349 */     String no5 = "空缺";
/*  350 */     String no6 = "";
/*  351 */     String no7 = "";
/*  352 */     String no8 = "";
/*  353 */     String no9 = "";
/*  354 */     String no10 = "";
/*  355 */     String no11 = "";
/*  356 */     String no12 = "";
/*  357 */     String no13 = "";
/*  358 */     String no14 = "";
/*  359 */     String no15 = "";
/*  360 */     String no16 = "空缺";
/*  361 */     String no17 = "空缺";
/*  362 */     String no18 = "空缺";
/*  363 */     String no19 = "空缺";
/*  364 */     String no20 = "空缺";
/*  365 */     String no21 = "";
/*  366 */     String no22 = "";
/*  367 */     String no23 = "";
/*  368 */     String no24 = "";
/*  369 */     String no25 = "";
/*  370 */     String no26 = "";
/*  371 */     String no27 = "";
/*  372 */     String no28 = "";
/*  373 */     String no29 = "";
/*  374 */     String no30 = "";
/*  375 */     PreparedStatement pstm1 = null;
/*  376 */     PreparedStatement pstm2 = null;
/*  377 */     PreparedStatement pstm3 = null;
/*  378 */     PreparedStatement pstm4 = null;
/*  379 */     PreparedStatement pstm5 = null;
/*  380 */     PreparedStatement pstm6 = null;
/*  381 */     PreparedStatement pstm7 = null;
/*  382 */     PreparedStatement pstm8 = null;
/*  383 */     PreparedStatement pstm9 = null;
/*  384 */     PreparedStatement pstm10 = null;
/*  385 */     ResultSet rs1 = null;
/*  386 */     ResultSet rs2 = null;
/*  387 */     ResultSet rs3 = null;
/*  388 */     ResultSet rs4 = null;
/*  389 */     ResultSet rs5 = null;
/*  390 */     ResultSet rs6 = null;
/*  391 */     ResultSet rs7 = null;
/*  392 */     ResultSet rs8 = null;
/*  393 */     ResultSet rs9 = null;
/*  394 */     ResultSet rs10 = null;
/*  395 */     Connection con = null;
/*  396 */     String[] levelresult = null;
/*  397 */     con = DatabaseFactory.get().getConnection();
/*  398 */     pstm1 = con.prepareStatement(
/*  399 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 138 || class = 37) order by (metelevel*1800000000+exp) DESC limit 0,1;");
/*  400 */     pstm2 = con.prepareStatement(
/*  401 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 138 || class = 37) order by (metelevel*1800000000+exp) DESC limit 1,1;");
/*  402 */     pstm3 = con.prepareStatement(
/*  403 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 138 || class = 37) order by (metelevel*1800000000+exp) DESC limit 2,1;");
/*  404 */     pstm4 = con.prepareStatement(
/*  405 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 138 || class = 37) order by (metelevel*1800000000+exp) DESC limit 3,1;");
/*  406 */     pstm5 = con.prepareStatement(
/*  407 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 138 || class = 37) order by (metelevel*1800000000+exp) DESC limit 4,1;");
/*  408 */     pstm6 = con.prepareStatement(
/*  409 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 138 || class = 37) order by (metelevel*1800000000+exp) DESC limit 5,1;");
/*  410 */     pstm7 = con.prepareStatement(
/*  411 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 138 || class = 37) order by (metelevel*1800000000+exp) DESC limit 6,1;");
/*  412 */     pstm8 = con.prepareStatement(
/*  413 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 138 || class = 37) order by (metelevel*1800000000+exp) DESC limit 7,1;");
/*  414 */     pstm9 = con.prepareStatement(
/*  415 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 138 || class = 37) order by (metelevel*1800000000+exp) DESC limit 8,1;");
/*  416 */     pstm10 = con.prepareStatement(
/*  417 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 138 || class = 37) order by (metelevel*1800000000+exp) DESC limit 9,1;");
/*  418 */     rs1 = pstm1.executeQuery();
/*  419 */     if (rs1.next()) {
/*  420 */       no1 = rs1.getString("char_name");
/*  421 */       no6 = rs1.getString("level");
/*  422 */       no11 = rs1.getString("metelevel");
/*      */     } 
/*  424 */     rs2 = pstm2.executeQuery();
/*  425 */     if (rs2.next()) {
/*  426 */       no2 = rs2.getString("char_name");
/*  427 */       no7 = rs2.getString("level");
/*  428 */       no12 = rs2.getString("metelevel");
/*      */     } 
/*  430 */     rs3 = pstm3.executeQuery();
/*  431 */     if (rs3.next()) {
/*  432 */       no3 = rs3.getString("char_name");
/*  433 */       no8 = rs3.getString("level");
/*  434 */       no13 = rs3.getString("metelevel");
/*      */     } 
/*  436 */     rs4 = pstm4.executeQuery();
/*  437 */     if (rs4.next()) {
/*  438 */       no4 = rs4.getString("char_name");
/*  439 */       no9 = rs4.getString("level");
/*  440 */       no14 = rs4.getString("metelevel");
/*      */     } 
/*  442 */     rs5 = pstm5.executeQuery();
/*  443 */     if (rs5.next()) {
/*  444 */       no5 = rs5.getString("char_name");
/*  445 */       no10 = rs5.getString("level");
/*  446 */       no15 = rs5.getString("metelevel");
/*      */     } 
/*  448 */     rs6 = pstm6.executeQuery();
/*  449 */     if (rs6.next()) {
/*  450 */       no16 = rs6.getString("char_name");
/*  451 */       no21 = rs6.getString("level");
/*  452 */       no26 = rs6.getString("metelevel");
/*      */     } 
/*  454 */     rs7 = pstm7.executeQuery();
/*  455 */     if (rs7.next()) {
/*  456 */       no17 = rs7.getString("char_name");
/*  457 */       no22 = rs7.getString("level");
/*  458 */       no27 = rs7.getString("metelevel");
/*      */     } 
/*  460 */     rs8 = pstm8.executeQuery();
/*  461 */     if (rs8.next()) {
/*  462 */       no18 = rs8.getString("char_name");
/*  463 */       no23 = rs8.getString("level");
/*  464 */       no28 = rs8.getString("metelevel");
/*      */     } 
/*  466 */     rs9 = pstm9.executeQuery();
/*  467 */     if (rs9.next()) {
/*  468 */       no19 = rs9.getString("char_name");
/*  469 */       no24 = rs9.getString("level");
/*  470 */       no29 = rs9.getString("metelevel");
/*      */     } 
/*  472 */     rs10 = pstm10.executeQuery();
/*  473 */     if (rs10.next()) {
/*  474 */       no20 = rs10.getString("char_name");
/*  475 */       no25 = rs10.getString("level");
/*  476 */       no30 = rs10.getString("metelevel");
/*      */     } 
/*  478 */     levelresult = new String[] { "", String.valueOf(no1), String.valueOf(no2), String.valueOf(no3), 
/*  479 */         String.valueOf(no4), String.valueOf(no5), String.valueOf(no6), String.valueOf(no7), String.valueOf(no8), 
/*  480 */         String.valueOf(no9), String.valueOf(no10), String.valueOf(no11), String.valueOf(no12), 
/*  481 */         String.valueOf(no13), String.valueOf(no14), String.valueOf(no15), String.valueOf(no16), 
/*  482 */         String.valueOf(no17), String.valueOf(no18), String.valueOf(no19), String.valueOf(no20), 
/*  483 */         String.valueOf(no21), String.valueOf(no22), String.valueOf(no23), String.valueOf(no24), 
/*  484 */         String.valueOf(no25), String.valueOf(no26), String.valueOf(no27), String.valueOf(no28), 
/*  485 */         String.valueOf(no29), String.valueOf(no30) };
/*  486 */     SQLUtil.close(rs1);
/*  487 */     SQLUtil.close(rs2);
/*  488 */     SQLUtil.close(rs3);
/*  489 */     SQLUtil.close(rs4);
/*  490 */     SQLUtil.close(rs5);
/*  491 */     SQLUtil.close(rs6);
/*  492 */     SQLUtil.close(rs7);
/*  493 */     SQLUtil.close(rs8);
/*  494 */     SQLUtil.close(rs9);
/*  495 */     SQLUtil.close(rs10);
/*  496 */     SQLUtil.close(pstm1);
/*  497 */     SQLUtil.close(pstm2);
/*  498 */     SQLUtil.close(pstm3);
/*  499 */     SQLUtil.close(pstm4);
/*  500 */     SQLUtil.close(pstm5);
/*  501 */     SQLUtil.close(pstm6);
/*  502 */     SQLUtil.close(pstm7);
/*  503 */     SQLUtil.close(pstm8);
/*  504 */     SQLUtil.close(pstm9);
/*  505 */     SQLUtil.close(pstm10);
/*  506 */     SQLUtil.close(con);
/*  507 */     return levelresult;
/*      */   }
/*      */   
/*      */   public static String[] Wizard() throws SQLException {
/*  511 */     String no1 = "空缺";
/*  512 */     String no2 = "空缺";
/*  513 */     String no3 = "空缺";
/*  514 */     String no4 = "空缺";
/*  515 */     String no5 = "空缺";
/*  516 */     String no6 = "";
/*  517 */     String no7 = "";
/*  518 */     String no8 = "";
/*  519 */     String no9 = "";
/*  520 */     String no10 = "";
/*  521 */     String no11 = "";
/*  522 */     String no12 = "";
/*  523 */     String no13 = "";
/*  524 */     String no14 = "";
/*  525 */     String no15 = "";
/*  526 */     String no16 = "空缺";
/*  527 */     String no17 = "空缺";
/*  528 */     String no18 = "空缺";
/*  529 */     String no19 = "空缺";
/*  530 */     String no20 = "空缺";
/*  531 */     String no21 = "";
/*  532 */     String no22 = "";
/*  533 */     String no23 = "";
/*  534 */     String no24 = "";
/*  535 */     String no25 = "";
/*  536 */     String no26 = "";
/*  537 */     String no27 = "";
/*  538 */     String no28 = "";
/*  539 */     String no29 = "";
/*  540 */     String no30 = "";
/*  541 */     PreparedStatement pstm1 = null;
/*  542 */     PreparedStatement pstm2 = null;
/*  543 */     PreparedStatement pstm3 = null;
/*  544 */     PreparedStatement pstm4 = null;
/*  545 */     PreparedStatement pstm5 = null;
/*  546 */     PreparedStatement pstm6 = null;
/*  547 */     PreparedStatement pstm7 = null;
/*  548 */     PreparedStatement pstm8 = null;
/*  549 */     PreparedStatement pstm9 = null;
/*  550 */     PreparedStatement pstm10 = null;
/*  551 */     ResultSet rs1 = null;
/*  552 */     ResultSet rs2 = null;
/*  553 */     ResultSet rs3 = null;
/*  554 */     ResultSet rs4 = null;
/*  555 */     ResultSet rs5 = null;
/*  556 */     ResultSet rs6 = null;
/*  557 */     ResultSet rs7 = null;
/*  558 */     ResultSet rs8 = null;
/*  559 */     ResultSet rs9 = null;
/*  560 */     ResultSet rs10 = null;
/*  561 */     Connection con = null;
/*  562 */     String[] levelresult = null;
/*  563 */     con = DatabaseFactory.get().getConnection();
/*  564 */     pstm1 = con.prepareStatement(
/*  565 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 1186 || class = 734) order by (metelevel*1800000000+exp) DESC limit 0,1;");
/*  566 */     pstm2 = con.prepareStatement(
/*  567 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 1186 || class = 734) order by (metelevel*1800000000+exp) DESC limit 1,1;");
/*  568 */     pstm3 = con.prepareStatement(
/*  569 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 1186 || class = 734) order by (metelevel*1800000000+exp) DESC limit 2,1;");
/*  570 */     pstm4 = con.prepareStatement(
/*  571 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 1186 || class = 734) order by (metelevel*1800000000+exp) DESC limit 3,1;");
/*  572 */     pstm5 = con.prepareStatement(
/*  573 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 1186 || class = 734) order by (metelevel*1800000000+exp) DESC limit 4,1;");
/*  574 */     pstm6 = con.prepareStatement(
/*  575 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 1186 || class = 734) order by (metelevel*1800000000+exp) DESC limit 5,1;");
/*  576 */     pstm7 = con.prepareStatement(
/*  577 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 1186 || class = 734) order by (metelevel*1800000000+exp) DESC limit 6,1;");
/*  578 */     pstm8 = con.prepareStatement(
/*  579 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 1186 || class = 734) order by (metelevel*1800000000+exp) DESC limit 7,1;");
/*  580 */     pstm9 = con.prepareStatement(
/*  581 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 1186 || class = 734) order by (metelevel*1800000000+exp) DESC limit 8,1;");
/*  582 */     pstm10 = con.prepareStatement(
/*  583 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 1186 || class = 734) order by (metelevel*1800000000+exp) DESC limit 9,1;");
/*  584 */     rs1 = pstm1.executeQuery();
/*  585 */     if (rs1.next()) {
/*  586 */       no1 = rs1.getString("char_name");
/*  587 */       no6 = rs1.getString("level");
/*  588 */       no11 = rs1.getString("metelevel");
/*      */     } 
/*  590 */     rs2 = pstm2.executeQuery();
/*  591 */     if (rs2.next()) {
/*  592 */       no2 = rs2.getString("char_name");
/*  593 */       no7 = rs2.getString("level");
/*  594 */       no12 = rs2.getString("metelevel");
/*      */     } 
/*  596 */     rs3 = pstm3.executeQuery();
/*  597 */     if (rs3.next()) {
/*  598 */       no3 = rs3.getString("char_name");
/*  599 */       no8 = rs3.getString("level");
/*  600 */       no13 = rs3.getString("metelevel");
/*      */     } 
/*  602 */     rs4 = pstm4.executeQuery();
/*  603 */     if (rs4.next()) {
/*  604 */       no4 = rs4.getString("char_name");
/*  605 */       no9 = rs4.getString("level");
/*  606 */       no14 = rs4.getString("metelevel");
/*      */     } 
/*  608 */     rs5 = pstm5.executeQuery();
/*  609 */     if (rs5.next()) {
/*  610 */       no5 = rs5.getString("char_name");
/*  611 */       no10 = rs5.getString("level");
/*  612 */       no15 = rs5.getString("metelevel");
/*      */     } 
/*  614 */     rs6 = pstm6.executeQuery();
/*  615 */     if (rs6.next()) {
/*  616 */       no16 = rs6.getString("char_name");
/*  617 */       no21 = rs6.getString("level");
/*  618 */       no26 = rs6.getString("metelevel");
/*      */     } 
/*  620 */     rs7 = pstm7.executeQuery();
/*  621 */     if (rs7.next()) {
/*  622 */       no17 = rs7.getString("char_name");
/*  623 */       no22 = rs7.getString("level");
/*  624 */       no27 = rs7.getString("metelevel");
/*      */     } 
/*  626 */     rs8 = pstm8.executeQuery();
/*  627 */     if (rs8.next()) {
/*  628 */       no18 = rs8.getString("char_name");
/*  629 */       no23 = rs8.getString("level");
/*  630 */       no28 = rs8.getString("metelevel");
/*      */     } 
/*  632 */     rs9 = pstm9.executeQuery();
/*  633 */     if (rs9.next()) {
/*  634 */       no19 = rs9.getString("char_name");
/*  635 */       no24 = rs9.getString("level");
/*  636 */       no29 = rs9.getString("metelevel");
/*      */     } 
/*  638 */     rs10 = pstm10.executeQuery();
/*  639 */     if (rs10.next()) {
/*  640 */       no20 = rs10.getString("char_name");
/*  641 */       no25 = rs10.getString("level");
/*  642 */       no30 = rs10.getString("metelevel");
/*      */     } 
/*  644 */     levelresult = new String[] { "", String.valueOf(no1), String.valueOf(no2), String.valueOf(no3), 
/*  645 */         String.valueOf(no4), String.valueOf(no5), String.valueOf(no6), String.valueOf(no7), String.valueOf(no8), 
/*  646 */         String.valueOf(no9), String.valueOf(no10), String.valueOf(no11), String.valueOf(no12), 
/*  647 */         String.valueOf(no13), String.valueOf(no14), String.valueOf(no15), String.valueOf(no16), 
/*  648 */         String.valueOf(no17), String.valueOf(no18), String.valueOf(no19), String.valueOf(no20), 
/*  649 */         String.valueOf(no21), String.valueOf(no22), String.valueOf(no23), String.valueOf(no24), 
/*  650 */         String.valueOf(no25), String.valueOf(no26), String.valueOf(no27), String.valueOf(no28), 
/*  651 */         String.valueOf(no29), String.valueOf(no30) };
/*  652 */     SQLUtil.close(rs1);
/*  653 */     SQLUtil.close(rs2);
/*  654 */     SQLUtil.close(rs3);
/*  655 */     SQLUtil.close(rs4);
/*  656 */     SQLUtil.close(rs5);
/*  657 */     SQLUtil.close(rs6);
/*  658 */     SQLUtil.close(rs7);
/*  659 */     SQLUtil.close(rs8);
/*  660 */     SQLUtil.close(rs9);
/*  661 */     SQLUtil.close(rs10);
/*  662 */     SQLUtil.close(pstm1);
/*  663 */     SQLUtil.close(pstm2);
/*  664 */     SQLUtil.close(pstm3);
/*  665 */     SQLUtil.close(pstm4);
/*  666 */     SQLUtil.close(pstm5);
/*  667 */     SQLUtil.close(pstm6);
/*  668 */     SQLUtil.close(pstm7);
/*  669 */     SQLUtil.close(pstm8);
/*  670 */     SQLUtil.close(pstm9);
/*  671 */     SQLUtil.close(pstm10);
/*  672 */     SQLUtil.close(con);
/*  673 */     return levelresult;
/*      */   }
/*      */   
/*      */   public static String[] Knight() throws SQLException {
/*  677 */     String no1 = "空缺";
/*  678 */     String no2 = "空缺";
/*  679 */     String no3 = "空缺";
/*  680 */     String no4 = "空缺";
/*  681 */     String no5 = "空缺";
/*  682 */     String no6 = "";
/*  683 */     String no7 = "";
/*  684 */     String no8 = "";
/*  685 */     String no9 = "";
/*  686 */     String no10 = "";
/*  687 */     String no11 = "";
/*  688 */     String no12 = "";
/*  689 */     String no13 = "";
/*  690 */     String no14 = "";
/*  691 */     String no15 = "";
/*  692 */     String no16 = "空缺";
/*  693 */     String no17 = "空缺";
/*  694 */     String no18 = "空缺";
/*  695 */     String no19 = "空缺";
/*  696 */     String no20 = "空缺";
/*  697 */     String no21 = "";
/*  698 */     String no22 = "";
/*  699 */     String no23 = "";
/*  700 */     String no24 = "";
/*  701 */     String no25 = "";
/*  702 */     String no26 = "";
/*  703 */     String no27 = "";
/*  704 */     String no28 = "";
/*  705 */     String no29 = "";
/*  706 */     String no30 = "";
/*  707 */     PreparedStatement pstm1 = null;
/*  708 */     PreparedStatement pstm2 = null;
/*  709 */     PreparedStatement pstm3 = null;
/*  710 */     PreparedStatement pstm4 = null;
/*  711 */     PreparedStatement pstm5 = null;
/*  712 */     PreparedStatement pstm6 = null;
/*  713 */     PreparedStatement pstm7 = null;
/*  714 */     PreparedStatement pstm8 = null;
/*  715 */     PreparedStatement pstm9 = null;
/*  716 */     PreparedStatement pstm10 = null;
/*  717 */     ResultSet rs1 = null;
/*  718 */     ResultSet rs2 = null;
/*  719 */     ResultSet rs3 = null;
/*  720 */     ResultSet rs4 = null;
/*  721 */     ResultSet rs5 = null;
/*  722 */     ResultSet rs6 = null;
/*  723 */     ResultSet rs7 = null;
/*  724 */     ResultSet rs8 = null;
/*  725 */     ResultSet rs9 = null;
/*  726 */     ResultSet rs10 = null;
/*  727 */     Connection con = null;
/*  728 */     String[] levelresult = null;
/*  729 */     con = DatabaseFactory.get().getConnection();
/*  730 */     pstm1 = con.prepareStatement(
/*  731 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 61 || class = 48) order by (metelevel*1800000000+exp) DESC limit 0,1;");
/*  732 */     pstm2 = con.prepareStatement(
/*  733 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 61 || class = 48) order by (metelevel*1800000000+exp) DESC limit 1,1;");
/*  734 */     pstm3 = con.prepareStatement(
/*  735 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 61 || class = 48) order by (metelevel*1800000000+exp) DESC limit 2,1;");
/*  736 */     pstm4 = con.prepareStatement(
/*  737 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 61 || class = 48) order by (metelevel*1800000000+exp) DESC limit 3,1;");
/*  738 */     pstm5 = con.prepareStatement(
/*  739 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 61 || class = 48) order by (metelevel*1800000000+exp) DESC limit 4,1;");
/*  740 */     pstm6 = con.prepareStatement(
/*  741 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 61 || class = 48) order by (metelevel*1800000000+exp) DESC limit 5,1;");
/*  742 */     pstm7 = con.prepareStatement(
/*  743 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 61 || class = 48) order by (metelevel*1800000000+exp) DESC limit 6,1;");
/*  744 */     pstm8 = con.prepareStatement(
/*  745 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 61 || class = 48) order by (metelevel*1800000000+exp) DESC limit 7,1;");
/*  746 */     pstm9 = con.prepareStatement(
/*  747 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 61 || class = 48) order by (metelevel*1800000000+exp) DESC limit 8,1;");
/*  748 */     pstm10 = con.prepareStatement(
/*  749 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 61 || class = 48) order by (metelevel*1800000000+exp) DESC limit 9,1;");
/*  750 */     rs1 = pstm1.executeQuery();
/*  751 */     if (rs1.next()) {
/*  752 */       no1 = rs1.getString("char_name");
/*  753 */       no6 = rs1.getString("level");
/*  754 */       no11 = rs1.getString("metelevel");
/*      */     } 
/*  756 */     rs2 = pstm2.executeQuery();
/*  757 */     if (rs2.next()) {
/*  758 */       no2 = rs2.getString("char_name");
/*  759 */       no7 = rs2.getString("level");
/*  760 */       no12 = rs2.getString("metelevel");
/*      */     } 
/*  762 */     rs3 = pstm3.executeQuery();
/*  763 */     if (rs3.next()) {
/*  764 */       no3 = rs3.getString("char_name");
/*  765 */       no8 = rs3.getString("level");
/*  766 */       no13 = rs3.getString("metelevel");
/*      */     } 
/*  768 */     rs4 = pstm4.executeQuery();
/*  769 */     if (rs4.next()) {
/*  770 */       no4 = rs4.getString("char_name");
/*  771 */       no9 = rs4.getString("level");
/*  772 */       no14 = rs4.getString("metelevel");
/*      */     } 
/*  774 */     rs5 = pstm5.executeQuery();
/*  775 */     if (rs5.next()) {
/*  776 */       no5 = rs5.getString("char_name");
/*  777 */       no10 = rs5.getString("level");
/*  778 */       no15 = rs5.getString("metelevel");
/*      */     } 
/*  780 */     rs6 = pstm6.executeQuery();
/*  781 */     if (rs6.next()) {
/*  782 */       no16 = rs6.getString("char_name");
/*  783 */       no21 = rs6.getString("level");
/*  784 */       no26 = rs6.getString("metelevel");
/*      */     } 
/*  786 */     rs7 = pstm7.executeQuery();
/*  787 */     if (rs7.next()) {
/*  788 */       no17 = rs7.getString("char_name");
/*  789 */       no22 = rs7.getString("level");
/*  790 */       no27 = rs7.getString("metelevel");
/*      */     } 
/*  792 */     rs8 = pstm8.executeQuery();
/*  793 */     if (rs8.next()) {
/*  794 */       no18 = rs8.getString("char_name");
/*  795 */       no23 = rs8.getString("level");
/*  796 */       no28 = rs8.getString("metelevel");
/*      */     } 
/*  798 */     rs9 = pstm9.executeQuery();
/*  799 */     if (rs9.next()) {
/*  800 */       no19 = rs9.getString("char_name");
/*  801 */       no24 = rs9.getString("level");
/*  802 */       no29 = rs9.getString("metelevel");
/*      */     } 
/*  804 */     rs10 = pstm10.executeQuery();
/*  805 */     if (rs10.next()) {
/*  806 */       no20 = rs10.getString("char_name");
/*  807 */       no25 = rs10.getString("level");
/*  808 */       no30 = rs10.getString("metelevel");
/*      */     } 
/*  810 */     levelresult = new String[] { "", String.valueOf(no1), String.valueOf(no2), String.valueOf(no3), 
/*  811 */         String.valueOf(no4), String.valueOf(no5), String.valueOf(no6), String.valueOf(no7), String.valueOf(no8), 
/*  812 */         String.valueOf(no9), String.valueOf(no10), String.valueOf(no11), String.valueOf(no12), 
/*  813 */         String.valueOf(no13), String.valueOf(no14), String.valueOf(no15), String.valueOf(no16), 
/*  814 */         String.valueOf(no17), String.valueOf(no18), String.valueOf(no19), String.valueOf(no20), 
/*  815 */         String.valueOf(no21), String.valueOf(no22), String.valueOf(no23), String.valueOf(no24), 
/*  816 */         String.valueOf(no25), String.valueOf(no26), String.valueOf(no27), String.valueOf(no28), 
/*  817 */         String.valueOf(no29), String.valueOf(no30) };
/*  818 */     SQLUtil.close(rs1);
/*  819 */     SQLUtil.close(rs2);
/*  820 */     SQLUtil.close(rs3);
/*  821 */     SQLUtil.close(rs4);
/*  822 */     SQLUtil.close(rs5);
/*  823 */     SQLUtil.close(rs6);
/*  824 */     SQLUtil.close(rs7);
/*  825 */     SQLUtil.close(rs8);
/*  826 */     SQLUtil.close(rs9);
/*  827 */     SQLUtil.close(rs10);
/*  828 */     SQLUtil.close(pstm1);
/*  829 */     SQLUtil.close(pstm2);
/*  830 */     SQLUtil.close(pstm3);
/*  831 */     SQLUtil.close(pstm4);
/*  832 */     SQLUtil.close(pstm5);
/*  833 */     SQLUtil.close(pstm6);
/*  834 */     SQLUtil.close(pstm7);
/*  835 */     SQLUtil.close(pstm8);
/*  836 */     SQLUtil.close(pstm9);
/*  837 */     SQLUtil.close(pstm10);
/*  838 */     SQLUtil.close(con);
/*  839 */     return levelresult;
/*      */   }
/*      */   
/*      */   public static String[] Darkelf() throws SQLException {
/*  843 */     String no1 = "空缺";
/*  844 */     String no2 = "空缺";
/*  845 */     String no3 = "空缺";
/*  846 */     String no4 = "空缺";
/*  847 */     String no5 = "空缺";
/*  848 */     String no6 = "";
/*  849 */     String no7 = "";
/*  850 */     String no8 = "";
/*  851 */     String no9 = "";
/*  852 */     String no10 = "";
/*  853 */     String no11 = "";
/*  854 */     String no12 = "";
/*  855 */     String no13 = "";
/*  856 */     String no14 = "";
/*  857 */     String no15 = "";
/*  858 */     String no16 = "空缺";
/*  859 */     String no17 = "空缺";
/*  860 */     String no18 = "空缺";
/*  861 */     String no19 = "空缺";
/*  862 */     String no20 = "空缺";
/*  863 */     String no21 = "";
/*  864 */     String no22 = "";
/*  865 */     String no23 = "";
/*  866 */     String no24 = "";
/*  867 */     String no25 = "";
/*  868 */     String no26 = "";
/*  869 */     String no27 = "";
/*  870 */     String no28 = "";
/*  871 */     String no29 = "";
/*  872 */     String no30 = "";
/*  873 */     PreparedStatement pstm1 = null;
/*  874 */     PreparedStatement pstm2 = null;
/*  875 */     PreparedStatement pstm3 = null;
/*  876 */     PreparedStatement pstm4 = null;
/*  877 */     PreparedStatement pstm5 = null;
/*  878 */     PreparedStatement pstm6 = null;
/*  879 */     PreparedStatement pstm7 = null;
/*  880 */     PreparedStatement pstm8 = null;
/*  881 */     PreparedStatement pstm9 = null;
/*  882 */     PreparedStatement pstm10 = null;
/*  883 */     ResultSet rs1 = null;
/*  884 */     ResultSet rs2 = null;
/*  885 */     ResultSet rs3 = null;
/*  886 */     ResultSet rs4 = null;
/*  887 */     ResultSet rs5 = null;
/*  888 */     ResultSet rs6 = null;
/*  889 */     ResultSet rs7 = null;
/*  890 */     ResultSet rs8 = null;
/*  891 */     ResultSet rs9 = null;
/*  892 */     ResultSet rs10 = null;
/*  893 */     Connection con = null;
/*  894 */     String[] levelresult = null;
/*  895 */     con = DatabaseFactory.get().getConnection();
/*  896 */     pstm1 = con.prepareStatement(
/*  897 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 2786 || class = 2796) order by (metelevel*1800000000+exp) DESC limit 0,1;");
/*  898 */     pstm2 = con.prepareStatement(
/*  899 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 2786 || class = 2796) order by (metelevel*1800000000+exp) DESC limit 1,1;");
/*  900 */     pstm3 = con.prepareStatement(
/*  901 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 2786 || class = 2796) order by (metelevel*1800000000+exp) DESC limit 2,1;");
/*  902 */     pstm4 = con.prepareStatement(
/*  903 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 2786 || class = 2796) order by (metelevel*1800000000+exp) DESC limit 3,1;");
/*  904 */     pstm5 = con.prepareStatement(
/*  905 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 2786 || class = 2796) order by (metelevel*1800000000+exp) DESC limit 4,1;");
/*  906 */     pstm6 = con.prepareStatement(
/*  907 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 2786 || class = 2796) order by (metelevel*1800000000+exp) DESC limit 5,1;");
/*  908 */     pstm7 = con.prepareStatement(
/*  909 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 2786 || class = 2796) order by (metelevel*1800000000+exp) DESC limit 6,1;");
/*  910 */     pstm8 = con.prepareStatement(
/*  911 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 2786 || class = 2796) order by (metelevel*1800000000+exp) DESC limit 7,1;");
/*  912 */     pstm9 = con.prepareStatement(
/*  913 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 2786 || class = 2796) order by (metelevel*1800000000+exp) DESC limit 8,1;");
/*  914 */     pstm10 = con.prepareStatement(
/*  915 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 2786 || class = 2796) order by (metelevel*1800000000+exp) DESC limit 9,1;");
/*  916 */     rs1 = pstm1.executeQuery();
/*  917 */     if (rs1.next()) {
/*  918 */       no1 = rs1.getString("char_name");
/*  919 */       no6 = rs1.getString("level");
/*  920 */       no11 = rs1.getString("metelevel");
/*      */     } 
/*  922 */     rs2 = pstm2.executeQuery();
/*  923 */     if (rs2.next()) {
/*  924 */       no2 = rs2.getString("char_name");
/*  925 */       no7 = rs2.getString("level");
/*  926 */       no12 = rs2.getString("metelevel");
/*      */     } 
/*  928 */     rs3 = pstm3.executeQuery();
/*  929 */     if (rs3.next()) {
/*  930 */       no3 = rs3.getString("char_name");
/*  931 */       no8 = rs3.getString("level");
/*  932 */       no13 = rs3.getString("metelevel");
/*      */     } 
/*  934 */     rs4 = pstm4.executeQuery();
/*  935 */     if (rs4.next()) {
/*  936 */       no4 = rs4.getString("char_name");
/*  937 */       no9 = rs4.getString("level");
/*  938 */       no14 = rs4.getString("metelevel");
/*      */     } 
/*  940 */     rs5 = pstm5.executeQuery();
/*  941 */     if (rs5.next()) {
/*  942 */       no5 = rs5.getString("char_name");
/*  943 */       no10 = rs5.getString("level");
/*  944 */       no15 = rs5.getString("metelevel");
/*      */     } 
/*  946 */     rs6 = pstm6.executeQuery();
/*  947 */     if (rs6.next()) {
/*  948 */       no16 = rs6.getString("char_name");
/*  949 */       no21 = rs6.getString("level");
/*  950 */       no26 = rs6.getString("metelevel");
/*      */     } 
/*  952 */     rs7 = pstm7.executeQuery();
/*  953 */     if (rs7.next()) {
/*  954 */       no17 = rs7.getString("char_name");
/*  955 */       no22 = rs7.getString("level");
/*  956 */       no27 = rs7.getString("metelevel");
/*      */     } 
/*  958 */     rs8 = pstm8.executeQuery();
/*  959 */     if (rs8.next()) {
/*  960 */       no18 = rs8.getString("char_name");
/*  961 */       no23 = rs8.getString("level");
/*  962 */       no28 = rs8.getString("metelevel");
/*      */     } 
/*  964 */     rs9 = pstm9.executeQuery();
/*  965 */     if (rs9.next()) {
/*  966 */       no19 = rs9.getString("char_name");
/*  967 */       no24 = rs9.getString("level");
/*  968 */       no29 = rs9.getString("metelevel");
/*      */     } 
/*  970 */     rs10 = pstm10.executeQuery();
/*  971 */     if (rs10.next()) {
/*  972 */       no20 = rs10.getString("char_name");
/*  973 */       no25 = rs10.getString("level");
/*  974 */       no30 = rs10.getString("metelevel");
/*      */     } 
/*  976 */     levelresult = new String[] { "", String.valueOf(no1), String.valueOf(no2), String.valueOf(no3), 
/*  977 */         String.valueOf(no4), String.valueOf(no5), String.valueOf(no6), String.valueOf(no7), String.valueOf(no8), 
/*  978 */         String.valueOf(no9), String.valueOf(no10), String.valueOf(no11), String.valueOf(no12), 
/*  979 */         String.valueOf(no13), String.valueOf(no14), String.valueOf(no15), String.valueOf(no16), 
/*  980 */         String.valueOf(no17), String.valueOf(no18), String.valueOf(no19), String.valueOf(no20), 
/*  981 */         String.valueOf(no21), String.valueOf(no22), String.valueOf(no23), String.valueOf(no24), 
/*  982 */         String.valueOf(no25), String.valueOf(no26), String.valueOf(no27), String.valueOf(no28), 
/*  983 */         String.valueOf(no29), String.valueOf(no30) };
/*  984 */     SQLUtil.close(rs1);
/*  985 */     SQLUtil.close(rs2);
/*  986 */     SQLUtil.close(rs3);
/*  987 */     SQLUtil.close(rs4);
/*  988 */     SQLUtil.close(rs5);
/*  989 */     SQLUtil.close(rs6);
/*  990 */     SQLUtil.close(rs7);
/*  991 */     SQLUtil.close(rs8);
/*  992 */     SQLUtil.close(rs9);
/*  993 */     SQLUtil.close(rs10);
/*  994 */     SQLUtil.close(pstm1);
/*  995 */     SQLUtil.close(pstm2);
/*  996 */     SQLUtil.close(pstm3);
/*  997 */     SQLUtil.close(pstm4);
/*  998 */     SQLUtil.close(pstm5);
/*  999 */     SQLUtil.close(pstm6);
/* 1000 */     SQLUtil.close(pstm7);
/* 1001 */     SQLUtil.close(pstm8);
/* 1002 */     SQLUtil.close(pstm9);
/* 1003 */     SQLUtil.close(pstm10);
/* 1004 */     SQLUtil.close(con);
/* 1005 */     return levelresult;
/*      */   }
/*      */   
/*      */   public static String[] Dragon() throws SQLException {
/* 1009 */     String no1 = "空缺";
/* 1010 */     String no2 = "空缺";
/* 1011 */     String no3 = "空缺";
/* 1012 */     String no4 = "空缺";
/* 1013 */     String no5 = "空缺";
/* 1014 */     String no6 = "";
/* 1015 */     String no7 = "";
/* 1016 */     String no8 = "";
/* 1017 */     String no9 = "";
/* 1018 */     String no10 = "";
/* 1019 */     String no11 = "";
/* 1020 */     String no12 = "";
/* 1021 */     String no13 = "";
/* 1022 */     String no14 = "";
/* 1023 */     String no15 = "";
/* 1024 */     String no16 = "空缺";
/* 1025 */     String no17 = "空缺";
/* 1026 */     String no18 = "空缺";
/* 1027 */     String no19 = "空缺";
/* 1028 */     String no20 = "空缺";
/* 1029 */     String no21 = "";
/* 1030 */     String no22 = "";
/* 1031 */     String no23 = "";
/* 1032 */     String no24 = "";
/* 1033 */     String no25 = "";
/* 1034 */     String no26 = "";
/* 1035 */     String no27 = "";
/* 1036 */     String no28 = "";
/* 1037 */     String no29 = "";
/* 1038 */     String no30 = "";
/* 1039 */     PreparedStatement pstm1 = null;
/* 1040 */     PreparedStatement pstm2 = null;
/* 1041 */     PreparedStatement pstm3 = null;
/* 1042 */     PreparedStatement pstm4 = null;
/* 1043 */     PreparedStatement pstm5 = null;
/* 1044 */     PreparedStatement pstm6 = null;
/* 1045 */     PreparedStatement pstm7 = null;
/* 1046 */     PreparedStatement pstm8 = null;
/* 1047 */     PreparedStatement pstm9 = null;
/* 1048 */     PreparedStatement pstm10 = null;
/* 1049 */     ResultSet rs1 = null;
/* 1050 */     ResultSet rs2 = null;
/* 1051 */     ResultSet rs3 = null;
/* 1052 */     ResultSet rs4 = null;
/* 1053 */     ResultSet rs5 = null;
/* 1054 */     ResultSet rs6 = null;
/* 1055 */     ResultSet rs7 = null;
/* 1056 */     ResultSet rs8 = null;
/* 1057 */     ResultSet rs9 = null;
/* 1058 */     ResultSet rs10 = null;
/* 1059 */     Connection con = null;
/* 1060 */     String[] levelresult = null;
/* 1061 */     con = DatabaseFactory.get().getConnection();
/* 1062 */     pstm1 = con.prepareStatement(
/* 1063 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6658 || class = 6661) order by (metelevel*1800000000+exp) DESC limit 0,1;");
/* 1064 */     pstm2 = con.prepareStatement(
/* 1065 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6658 || class = 6661) order by (metelevel*1800000000+exp) DESC limit 1,1;");
/* 1066 */     pstm3 = con.prepareStatement(
/* 1067 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6658 || class = 6661) order by (metelevel*1800000000+exp) DESC limit 2,1;");
/* 1068 */     pstm4 = con.prepareStatement(
/* 1069 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6658 || class = 6661) order by (metelevel*1800000000+exp) DESC limit 3,1;");
/* 1070 */     pstm5 = con.prepareStatement(
/* 1071 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6658 || class = 6661) order by (metelevel*1800000000+exp) DESC limit 4,1;");
/* 1072 */     pstm6 = con.prepareStatement(
/* 1073 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6658 || class = 6661) order by (metelevel*1800000000+exp) DESC limit 5,1;");
/* 1074 */     pstm7 = con.prepareStatement(
/* 1075 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6658 || class = 6661) order by (metelevel*1800000000+exp) DESC limit 6,1;");
/* 1076 */     pstm8 = con.prepareStatement(
/* 1077 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6658 || class = 6661) order by (metelevel*1800000000+exp) DESC limit 7,1;");
/* 1078 */     pstm9 = con.prepareStatement(
/* 1079 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6658 || class = 6661) order by (metelevel*1800000000+exp) DESC limit 8,1;");
/* 1080 */     pstm10 = con.prepareStatement(
/* 1081 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6658 || class = 6661) order by (metelevel*1800000000+exp) DESC limit 9,1;");
/* 1082 */     rs1 = pstm1.executeQuery();
/* 1083 */     if (rs1.next()) {
/* 1084 */       no1 = rs1.getString("char_name");
/* 1085 */       no6 = rs1.getString("level");
/* 1086 */       no11 = rs1.getString("metelevel");
/*      */     } 
/* 1088 */     rs2 = pstm2.executeQuery();
/* 1089 */     if (rs2.next()) {
/* 1090 */       no2 = rs2.getString("char_name");
/* 1091 */       no7 = rs2.getString("level");
/* 1092 */       no12 = rs2.getString("metelevel");
/*      */     } 
/* 1094 */     rs3 = pstm3.executeQuery();
/* 1095 */     if (rs3.next()) {
/* 1096 */       no3 = rs3.getString("char_name");
/* 1097 */       no8 = rs3.getString("level");
/* 1098 */       no13 = rs3.getString("metelevel");
/*      */     } 
/* 1100 */     rs4 = pstm4.executeQuery();
/* 1101 */     if (rs4.next()) {
/* 1102 */       no4 = rs4.getString("char_name");
/* 1103 */       no9 = rs4.getString("level");
/* 1104 */       no14 = rs4.getString("metelevel");
/*      */     } 
/* 1106 */     rs5 = pstm5.executeQuery();
/* 1107 */     if (rs5.next()) {
/* 1108 */       no5 = rs5.getString("char_name");
/* 1109 */       no10 = rs5.getString("level");
/* 1110 */       no15 = rs5.getString("metelevel");
/*      */     } 
/* 1112 */     rs6 = pstm6.executeQuery();
/* 1113 */     if (rs6.next()) {
/* 1114 */       no16 = rs6.getString("char_name");
/* 1115 */       no21 = rs6.getString("level");
/* 1116 */       no26 = rs6.getString("metelevel");
/*      */     } 
/* 1118 */     rs7 = pstm7.executeQuery();
/* 1119 */     if (rs7.next()) {
/* 1120 */       no17 = rs7.getString("char_name");
/* 1121 */       no22 = rs7.getString("level");
/* 1122 */       no27 = rs7.getString("metelevel");
/*      */     } 
/* 1124 */     rs8 = pstm8.executeQuery();
/* 1125 */     if (rs8.next()) {
/* 1126 */       no18 = rs8.getString("char_name");
/* 1127 */       no23 = rs8.getString("level");
/* 1128 */       no28 = rs8.getString("metelevel");
/*      */     } 
/* 1130 */     rs9 = pstm9.executeQuery();
/* 1131 */     if (rs9.next()) {
/* 1132 */       no19 = rs9.getString("char_name");
/* 1133 */       no24 = rs9.getString("level");
/* 1134 */       no29 = rs9.getString("metelevel");
/*      */     } 
/* 1136 */     rs10 = pstm10.executeQuery();
/* 1137 */     if (rs10.next()) {
/* 1138 */       no20 = rs10.getString("char_name");
/* 1139 */       no25 = rs10.getString("level");
/* 1140 */       no30 = rs10.getString("metelevel");
/*      */     } 
/* 1142 */     levelresult = new String[] { "", String.valueOf(no1), String.valueOf(no2), String.valueOf(no3), 
/* 1143 */         String.valueOf(no4), String.valueOf(no5), String.valueOf(no6), String.valueOf(no7), String.valueOf(no8), 
/* 1144 */         String.valueOf(no9), String.valueOf(no10), String.valueOf(no11), String.valueOf(no12), 
/* 1145 */         String.valueOf(no13), String.valueOf(no14), String.valueOf(no15), String.valueOf(no16), 
/* 1146 */         String.valueOf(no17), String.valueOf(no18), String.valueOf(no19), String.valueOf(no20), 
/* 1147 */         String.valueOf(no21), String.valueOf(no22), String.valueOf(no23), String.valueOf(no24), 
/* 1148 */         String.valueOf(no25), String.valueOf(no26), String.valueOf(no27), String.valueOf(no28), 
/* 1149 */         String.valueOf(no29), String.valueOf(no30) };
/* 1150 */     SQLUtil.close(rs1);
/* 1151 */     SQLUtil.close(rs2);
/* 1152 */     SQLUtil.close(rs3);
/* 1153 */     SQLUtil.close(rs4);
/* 1154 */     SQLUtil.close(rs5);
/* 1155 */     SQLUtil.close(rs6);
/* 1156 */     SQLUtil.close(rs7);
/* 1157 */     SQLUtil.close(rs8);
/* 1158 */     SQLUtil.close(rs9);
/* 1159 */     SQLUtil.close(rs10);
/* 1160 */     SQLUtil.close(pstm1);
/* 1161 */     SQLUtil.close(pstm2);
/* 1162 */     SQLUtil.close(pstm3);
/* 1163 */     SQLUtil.close(pstm4);
/* 1164 */     SQLUtil.close(pstm5);
/* 1165 */     SQLUtil.close(pstm6);
/* 1166 */     SQLUtil.close(pstm7);
/* 1167 */     SQLUtil.close(pstm8);
/* 1168 */     SQLUtil.close(pstm9);
/* 1169 */     SQLUtil.close(pstm10);
/* 1170 */     SQLUtil.close(con);
/* 1171 */     return levelresult;
/*      */   }
/*      */   
/*      */   public static String[] Illusionist() throws SQLException {
/* 1175 */     String no1 = "空缺";
/* 1176 */     String no2 = "空缺";
/* 1177 */     String no3 = "空缺";
/* 1178 */     String no4 = "空缺";
/* 1179 */     String no5 = "空缺";
/* 1180 */     String no6 = "";
/* 1181 */     String no7 = "";
/* 1182 */     String no8 = "";
/* 1183 */     String no9 = "";
/* 1184 */     String no10 = "";
/* 1185 */     String no11 = "";
/* 1186 */     String no12 = "";
/* 1187 */     String no13 = "";
/* 1188 */     String no14 = "";
/* 1189 */     String no15 = "";
/* 1190 */     String no16 = "空缺";
/* 1191 */     String no17 = "空缺";
/* 1192 */     String no18 = "空缺";
/* 1193 */     String no19 = "空缺";
/* 1194 */     String no20 = "空缺";
/* 1195 */     String no21 = "";
/* 1196 */     String no22 = "";
/* 1197 */     String no23 = "";
/* 1198 */     String no24 = "";
/* 1199 */     String no25 = "";
/* 1200 */     String no26 = "";
/* 1201 */     String no27 = "";
/* 1202 */     String no28 = "";
/* 1203 */     String no29 = "";
/* 1204 */     String no30 = "";
/* 1205 */     PreparedStatement pstm1 = null;
/* 1206 */     PreparedStatement pstm2 = null;
/* 1207 */     PreparedStatement pstm3 = null;
/* 1208 */     PreparedStatement pstm4 = null;
/* 1209 */     PreparedStatement pstm5 = null;
/* 1210 */     PreparedStatement pstm6 = null;
/* 1211 */     PreparedStatement pstm7 = null;
/* 1212 */     PreparedStatement pstm8 = null;
/* 1213 */     PreparedStatement pstm9 = null;
/* 1214 */     PreparedStatement pstm10 = null;
/* 1215 */     ResultSet rs1 = null;
/* 1216 */     ResultSet rs2 = null;
/* 1217 */     ResultSet rs3 = null;
/* 1218 */     ResultSet rs4 = null;
/* 1219 */     ResultSet rs5 = null;
/* 1220 */     ResultSet rs6 = null;
/* 1221 */     ResultSet rs7 = null;
/* 1222 */     ResultSet rs8 = null;
/* 1223 */     ResultSet rs9 = null;
/* 1224 */     ResultSet rs10 = null;
/* 1225 */     Connection con = null;
/* 1226 */     String[] levelresult = null;
/* 1227 */     con = DatabaseFactory.get().getConnection();
/* 1228 */     pstm1 = con.prepareStatement(
/* 1229 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6671 || class = 6650) order by (metelevel*1800000000+exp) DESC limit 0,1;");
/* 1230 */     pstm2 = con.prepareStatement(
/* 1231 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6671 || class = 6650) order by (metelevel*1800000000+exp) DESC limit 1,1;");
/* 1232 */     pstm3 = con.prepareStatement(
/* 1233 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6671 || class = 6650) order by (metelevel*1800000000+exp) DESC limit 2,1;");
/* 1234 */     pstm4 = con.prepareStatement(
/* 1235 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6671 || class = 6650) order by (metelevel*1800000000+exp) DESC limit 3,1;");
/* 1236 */     pstm5 = con.prepareStatement(
/* 1237 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6671 || class = 6650) order by (metelevel*1800000000+exp) DESC limit 4,1;");
/* 1238 */     pstm6 = con.prepareStatement(
/* 1239 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6671 || class = 6650) order by (metelevel*1800000000+exp) DESC limit 5,1;");
/* 1240 */     pstm7 = con.prepareStatement(
/* 1241 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6671 || class = 6650) order by (metelevel*1800000000+exp) DESC limit 6,1;");
/* 1242 */     pstm8 = con.prepareStatement(
/* 1243 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6671 || class = 6650) order by (metelevel*1800000000+exp) DESC limit 7,1;");
/* 1244 */     pstm9 = con.prepareStatement(
/* 1245 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6671 || class = 6650) order by (metelevel*1800000000+exp) DESC limit 8,1;");
/* 1246 */     pstm10 = con.prepareStatement(
/* 1247 */         "select char_name,level,metelevel from characters where accesslevel = 0 && (class = 6671 || class = 6650) order by (metelevel*1800000000+exp) DESC limit 9,1;");
/* 1248 */     rs1 = pstm1.executeQuery();
/* 1249 */     if (rs1.next()) {
/* 1250 */       no1 = rs1.getString("char_name");
/* 1251 */       no6 = rs1.getString("level");
/* 1252 */       no11 = rs1.getString("metelevel");
/*      */     } 
/* 1254 */     rs2 = pstm2.executeQuery();
/* 1255 */     if (rs2.next()) {
/* 1256 */       no2 = rs2.getString("char_name");
/* 1257 */       no7 = rs2.getString("level");
/* 1258 */       no12 = rs2.getString("metelevel");
/*      */     } 
/* 1260 */     rs3 = pstm3.executeQuery();
/* 1261 */     if (rs3.next()) {
/* 1262 */       no3 = rs3.getString("char_name");
/* 1263 */       no8 = rs3.getString("level");
/* 1264 */       no13 = rs3.getString("metelevel");
/*      */     } 
/* 1266 */     rs4 = pstm4.executeQuery();
/* 1267 */     if (rs4.next()) {
/* 1268 */       no4 = rs4.getString("char_name");
/* 1269 */       no9 = rs4.getString("level");
/* 1270 */       no14 = rs4.getString("metelevel");
/*      */     } 
/* 1272 */     rs5 = pstm5.executeQuery();
/* 1273 */     if (rs5.next()) {
/* 1274 */       no5 = rs5.getString("char_name");
/* 1275 */       no10 = rs5.getString("level");
/* 1276 */       no15 = rs5.getString("metelevel");
/*      */     } 
/* 1278 */     rs6 = pstm6.executeQuery();
/* 1279 */     if (rs6.next()) {
/* 1280 */       no16 = rs6.getString("char_name");
/* 1281 */       no21 = rs6.getString("level");
/* 1282 */       no26 = rs6.getString("metelevel");
/*      */     } 
/* 1284 */     rs7 = pstm7.executeQuery();
/* 1285 */     if (rs7.next()) {
/* 1286 */       no17 = rs7.getString("char_name");
/* 1287 */       no22 = rs7.getString("level");
/* 1288 */       no27 = rs7.getString("metelevel");
/*      */     } 
/* 1290 */     rs8 = pstm8.executeQuery();
/* 1291 */     if (rs8.next()) {
/* 1292 */       no18 = rs8.getString("char_name");
/* 1293 */       no23 = rs8.getString("level");
/* 1294 */       no28 = rs8.getString("metelevel");
/*      */     } 
/* 1296 */     rs9 = pstm9.executeQuery();
/* 1297 */     if (rs9.next()) {
/* 1298 */       no19 = rs9.getString("char_name");
/* 1299 */       no24 = rs9.getString("level");
/* 1300 */       no29 = rs9.getString("metelevel");
/*      */     } 
/* 1302 */     rs10 = pstm10.executeQuery();
/* 1303 */     if (rs10.next()) {
/* 1304 */       no20 = rs10.getString("char_name");
/* 1305 */       no25 = rs10.getString("level");
/* 1306 */       no30 = rs10.getString("metelevel");
/*      */     } 
/* 1308 */     levelresult = new String[] { "", String.valueOf(no1), String.valueOf(no2), String.valueOf(no3), 
/* 1309 */         String.valueOf(no4), String.valueOf(no5), String.valueOf(no6), String.valueOf(no7), String.valueOf(no8), 
/* 1310 */         String.valueOf(no9), String.valueOf(no10), String.valueOf(no11), String.valueOf(no12), 
/* 1311 */         String.valueOf(no13), String.valueOf(no14), String.valueOf(no15), String.valueOf(no16), 
/* 1312 */         String.valueOf(no17), String.valueOf(no18), String.valueOf(no19), String.valueOf(no20), 
/* 1313 */         String.valueOf(no21), String.valueOf(no22), String.valueOf(no23), String.valueOf(no24), 
/* 1314 */         String.valueOf(no25), String.valueOf(no26), String.valueOf(no27), String.valueOf(no28), 
/* 1315 */         String.valueOf(no29), String.valueOf(no30) };
/* 1316 */     SQLUtil.close(rs1);
/* 1317 */     SQLUtil.close(rs2);
/* 1318 */     SQLUtil.close(rs3);
/* 1319 */     SQLUtil.close(rs4);
/* 1320 */     SQLUtil.close(rs5);
/* 1321 */     SQLUtil.close(rs6);
/* 1322 */     SQLUtil.close(rs7);
/* 1323 */     SQLUtil.close(rs8);
/* 1324 */     SQLUtil.close(rs9);
/* 1325 */     SQLUtil.close(rs10);
/* 1326 */     SQLUtil.close(pstm1);
/* 1327 */     SQLUtil.close(pstm2);
/* 1328 */     SQLUtil.close(pstm3);
/* 1329 */     SQLUtil.close(pstm4);
/* 1330 */     SQLUtil.close(pstm5);
/* 1331 */     SQLUtil.close(pstm6);
/* 1332 */     SQLUtil.close(pstm7);
/* 1333 */     SQLUtil.close(pstm8);
/* 1334 */     SQLUtil.close(pstm9);
/* 1335 */     SQLUtil.close(pstm10);
/* 1336 */     SQLUtil.close(con);
/* 1337 */     return levelresult;
/*      */   }
/*      */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\add\L1Ranking.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */