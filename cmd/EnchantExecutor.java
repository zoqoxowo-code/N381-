/*     */ package com.lineage.data.cmd;
/*     */ 
/*     */ import com.lineage.config.ConfigRate;
/*     */ import com.lineage.server.model.Instance.L1ItemInstance;
/*     */ import com.lineage.server.model.Instance.L1PcInstance;
/*     */ import java.util.Random;
/*     */ 
/*     */ public abstract class EnchantExecutor
/*     */ {
/*     */   public abstract void failureEnchant(L1PcInstance paramL1PcInstance, L1ItemInstance paramL1ItemInstance);
/*     */   
/*     */   public abstract void successEnchant(L1PcInstance paramL1PcInstance, L1ItemInstance paramL1ItemInstance, int paramInt);
/*     */   
/*     */   public int randomELevel(L1ItemInstance item, int bless) {
/*     */     Random random;
/*  16 */     int i, level = 0;
/*  17 */     switch (bless) {
/*     */       case 0:
/*     */       case 128:
/*  20 */         if (item.getBless() >= 3) {
/*     */           break;
/*     */         }
/*  23 */         random = new Random();
/*  24 */         i = random.nextInt(100) + 1;
/*  25 */         if (item.getItem().getType2() == 1) {
/*  26 */           if (item.getEnchantLevel() == 6) {
/*  27 */             if (i < ConfigRate.ran15) {
/*  28 */               level = 3;
/*     */               break;
/*     */             } 
/*  31 */             if (i < ConfigRate.ran16) {
/*  32 */               level = 2;
/*     */               break;
/*     */             } 
/*  35 */             if (i < ConfigRate.ran17) {
/*  36 */               level = 1;
/*     */               break;
/*     */             } 
/*  39 */             level = 1;
/*     */             break;
/*     */           } 
/*  42 */           if (item.getEnchantLevel() == 7) {
/*  43 */             if (i < ConfigRate.ran18) {
/*  44 */               level = 2;
/*     */               break;
/*     */             } 
/*  47 */             if (i < ConfigRate.ran19) {
/*  48 */               level = 1;
/*     */               break;
/*     */             } 
/*  51 */             level = 1;
/*     */             break;
/*     */           } 
/*  54 */           if (item.getEnchantLevel() == 5) {
/*  55 */             if (i < ConfigRate.ran3) {
/*  56 */               level = 3;
/*     */               break;
/*     */             } 
/*  59 */             if (i < ConfigRate.ran2) {
/*  60 */               level = 2;
/*     */               break;
/*     */             } 
/*  63 */             if (i < ConfigRate.ran1) {
/*  64 */               level = 1;
/*     */               break;
/*     */             } 
/*  67 */             level = 1;
/*     */             break;
/*     */           } 
/*  70 */           if (item.getEnchantLevel() != -1) {
/*  71 */             level = 1;
/*     */             break;
/*     */           } 
/*  74 */           if (i < ConfigRate.ran14) {
/*  75 */             level = 3;
/*     */             break;
/*     */           } 
/*  78 */           if (i < ConfigRate.ran5) {
/*  79 */             level = 2;
/*     */             break;
/*     */           } 
/*  82 */           if (i < ConfigRate.ran4) {
/*  83 */             level = 1;
/*     */             break;
/*     */           } 
/*  86 */           level = 1;
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */         
/*  92 */         if (item.getItem().getType2() != 2) {
/*     */           break;
/*     */         }
/*     */         
/*  96 */         if (item.getEnchantLevel() == 4) {
/*  97 */           if (i < ConfigRate.ran20) {
/*  98 */             level = 3;
/*     */             break;
/*     */           } 
/* 101 */           if (i < ConfigRate.ran21) {
/* 102 */             level = 2;
/*     */             break;
/*     */           } 
/* 105 */           if (i < ConfigRate.ran22) {
/* 106 */             level = 1;
/*     */             break;
/*     */           } 
/* 109 */           level = 1;
/*     */           
/*     */           break;
/*     */         } 
/* 113 */         if (item.getEnchantLevel() == 6) {
/* 114 */           if (i < ConfigRate.ran23) {
/* 115 */             level = 3;
/*     */             break;
/*     */           } 
/* 118 */           if (i < ConfigRate.ran24) {
/* 119 */             level = 2;
/*     */             break;
/*     */           } 
/* 122 */           if (i < ConfigRate.ran25) {
/* 123 */             level = 1;
/*     */             break;
/*     */           } 
/* 126 */           level = 1;
/*     */           
/*     */           break;
/*     */         } 
/* 130 */         if (item.getEnchantLevel() == 7) {
/* 131 */           if (i < ConfigRate.ran26) {
/* 132 */             level = 3;
/*     */             break;
/*     */           } 
/* 135 */           if (i < ConfigRate.ran27) {
/* 136 */             level = 2;
/*     */             break;
/*     */           } 
/* 139 */           if (i < ConfigRate.ran28) {
/* 140 */             level = 1;
/*     */             break;
/*     */           } 
/* 143 */           level = 1;
/*     */           
/*     */           break;
/*     */         } 
/* 147 */         if (item.getEnchantLevel() == 3) {
/* 148 */           if (i < ConfigRate.ran8) {
/* 149 */             level = 3;
/*     */             break;
/*     */           } 
/* 152 */           if (i < ConfigRate.ran7) {
/* 153 */             level = 2;
/*     */             break;
/*     */           } 
/* 156 */           if (i < ConfigRate.ran6) {
/* 157 */             level = 1;
/*     */             break;
/*     */           } 
/* 160 */           level = 1; break;
/*     */         } 
/* 162 */         if (item.getEnchantLevel() == 5) {
/* 163 */           if (i < ConfigRate.ran10) {
/* 164 */             level = 2;
/*     */             break;
/*     */           } 
/* 167 */           if (i < ConfigRate.ran9) {
/* 168 */             level = 1;
/*     */             break;
/*     */           } 
/* 171 */           level = 1;
/*     */           break;
/*     */         } 
/* 174 */         if (item.getEnchantLevel() != -1) {
/* 175 */           level = 1;
/*     */           break;
/*     */         } 
/* 178 */         if (i < ConfigRate.ran13) {
/* 179 */           level = 3;
/*     */           break;
/*     */         } 
/* 182 */         if (i < ConfigRate.ran12) {
/* 183 */           level = 2;
/*     */           break;
/*     */         } 
/* 186 */         if (i < ConfigRate.ran11) {
/* 187 */           level = 1;
/*     */           break;
/*     */         } 
/* 190 */         level = 1;
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 1:
/*     */       case 129:
/* 197 */         if (item.getBless() < 3) {
/* 198 */           level = 1;
/*     */         }
/*     */         break;
/*     */ 
/*     */       
/*     */       case 2:
/*     */       case 130:
/* 205 */         if (item.getBless() < 3) {
/* 206 */           level = -1;
/*     */         }
/*     */         break;
/*     */ 
/*     */       
/*     */       case 3:
/*     */       case 131:
/* 213 */         if (item.getBless() == 3) {
/* 214 */           level = 1;
/*     */         }
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 220 */     return level;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\lineage\data\cmd\EnchantExecutor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */