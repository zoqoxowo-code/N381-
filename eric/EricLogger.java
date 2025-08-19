/*     */ package com.eric;
/*     */ 
/*     */ import com.eric.gui.J_Main;
/*     */ import java.util.Calendar;
/*     */ import java.util.ResourceBundle;
/*     */ import java.util.logging.Filter;
/*     */ import java.util.logging.Handler;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.LogRecord;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EricLogger
/*     */   extends Logger
/*     */ {
/*  17 */   private static String className = null;
/*  18 */   private static String classResourceBundleName = null;
/*     */ 
/*     */   
/*     */   public EricLogger(String name, String resourceBundleName) {
/*  22 */     super(name, resourceBundleName);
/*  23 */     className = name;
/*     */   }
/*     */   
/*     */   public static EricLogger getLogger2(String name) {
/*  27 */     className = name;
/*  28 */     classResourceBundleName = Logger.getLogger(name).getResourceBundleName();
/*  29 */     return new EricLogger(className, classResourceBundleName);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void addHandler(Handler handler) throws SecurityException {
/*  34 */     super.addHandler(handler);
/*     */   }
/*     */ 
/*     */   
/*     */   public void config(String msg) {
/*  39 */     super.config(msg);
/*     */   }
/*     */ 
/*     */   
/*     */   public void entering(String sourceClass, String sourceMethod, Object param1) {
/*  44 */     super.entering(sourceClass, sourceMethod, param1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void entering(String sourceClass, String sourceMethod, Object[] params) {
/*  49 */     super.entering(sourceClass, sourceMethod, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public void entering(String sourceClass, String sourceMethod) {
/*  54 */     super.entering(sourceClass, sourceMethod);
/*     */   }
/*     */ 
/*     */   
/*     */   public void exiting(String sourceClass, String sourceMethod, Object result) {
/*  59 */     super.exiting(sourceClass, sourceMethod, result);
/*     */   }
/*     */ 
/*     */   
/*     */   public void exiting(String sourceClass, String sourceMethod) {
/*  64 */     super.exiting(sourceClass, sourceMethod);
/*     */   }
/*     */ 
/*     */   
/*     */   public void fine(String msg) {
/*  69 */     super.fine(msg);
/*     */   }
/*     */ 
/*     */   
/*     */   public void finer(String msg) {
/*  74 */     super.finer(msg);
/*     */   }
/*     */ 
/*     */   
/*     */   public void finest(String msg) {
/*  79 */     super.finest(msg);
/*     */   }
/*     */ 
/*     */   
/*     */   public Filter getFilter() {
/*  84 */     return super.getFilter();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Handler[] getHandlers() {
/*  89 */     return super.getHandlers();
/*     */   }
/*     */ 
/*     */   
/*     */   public Level getLevel() {
/*  94 */     return super.getLevel();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  99 */     return super.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public Logger getParent() {
/* 104 */     return super.getParent();
/*     */   }
/*     */ 
/*     */   
/*     */   public ResourceBundle getResourceBundle() {
/* 109 */     return super.getResourceBundle();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getResourceBundleName() {
/* 114 */     return super.getResourceBundleName();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized boolean getUseParentHandlers() {
/* 119 */     return super.getUseParentHandlers();
/*     */   }
/*     */ 
/*     */   
/*     */   public void info(String msg) {
/* 124 */     J_Main.getInstance()
/* 125 */       .addConsol(String.valueOf(String.valueOf(Calendar.getInstance().getTime().toString())) + " " + className);
/* 126 */     J_Main.getInstance().addConsol(msg);
/* 127 */     super.info(msg);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLoggable(Level level) {
/* 132 */     return super.isLoggable(level);
/*     */   }
/*     */ 
/*     */   
/*     */   public void log(Level level, String msg, Object param1) {
/* 137 */     super.log(level, msg, param1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void log(Level level, String msg, Object[] params) {
/* 142 */     super.log(level, msg, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public void log(Level level, String msg, Throwable thrown) {
/* 147 */     J_Main.getInstance()
/* 148 */       .addConsol(String.valueOf(String.valueOf(Calendar.getInstance().getTime().toString())) + " " + className);
/* 149 */     J_Main.getInstance().addConsol(level + ": " + msg + "\n" + thrown);
/* 150 */     super.log(level, msg, thrown);
/*     */   }
/*     */ 
/*     */   
/*     */   public void log(Level level, String msg) {
/* 155 */     super.log(level, msg);
/*     */   }
/*     */ 
/*     */   
/*     */   public void log(LogRecord record) {
/* 160 */     super.log(record);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void logp(Level level, String sourceClass, String sourceMethod, String msg, Object param1) {
/* 166 */     super.logp(level, sourceClass, sourceMethod, msg, param1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void logp(Level level, String sourceClass, String sourceMethod, String msg, Object[] params) {
/* 172 */     super.logp(level, sourceClass, sourceMethod, msg, params);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void logp(Level level, String sourceClass, String sourceMethod, String msg, Throwable thrown) {
/* 178 */     super.logp(level, sourceClass, sourceMethod, msg, thrown);
/*     */   }
/*     */ 
/*     */   
/*     */   public void logp(Level level, String sourceClass, String sourceMethod, String msg) {
/* 183 */     super.logp(level, sourceClass, sourceMethod, msg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg, Object param1) {
/* 189 */     super.logrb(level, sourceClass, sourceMethod, bundleName, msg, param1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg, Object[] params) {
/* 195 */     super.logrb(level, sourceClass, sourceMethod, bundleName, msg, params);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg, Throwable thrown) {
/* 201 */     super.logrb(level, sourceClass, sourceMethod, bundleName, msg, thrown);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg) {
/* 207 */     super.logrb(level, sourceClass, sourceMethod, bundleName, msg);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void removeHandler(Handler handler) throws SecurityException {
/* 212 */     super.removeHandler(handler);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFilter(Filter newFilter) throws SecurityException {
/* 217 */     super.setFilter(newFilter);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLevel(Level newLevel) throws SecurityException {
/* 222 */     super.setLevel(newLevel);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setParent(Logger parent) {
/* 227 */     super.setParent(parent);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void setUseParentHandlers(boolean useParentHandlers) {
/* 232 */     super.setUseParentHandlers(useParentHandlers);
/*     */   }
/*     */ 
/*     */   
/*     */   public void severe(String msg) {
/* 237 */     super.severe(msg);
/*     */   }
/*     */ 
/*     */   
/*     */   public void throwing(String sourceClass, String sourceMethod, Throwable thrown) {
/* 242 */     super.throwing(sourceClass, sourceMethod, thrown);
/*     */   }
/*     */ 
/*     */   
/*     */   public void warning(String msg) {
/* 247 */     J_Main.getInstance()
/* 248 */       .addConsol(String.valueOf(String.valueOf(Calendar.getInstance().getTime().toString())) + " " + className);
/* 249 */     J_Main.getInstance().addConsol("Warning: " + msg);
/* 250 */     super.warning(msg);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object clone() throws CloneNotSupportedException {
/* 255 */     return super.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object arg0) {
/* 260 */     return super.equals(arg0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/* 265 */     super.finalize();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 270 */     return super.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 275 */     return super.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\私服資料\新381_伺服器\Server_Game.jar!\com\eric\EricLogger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */