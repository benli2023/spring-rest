/*    */ package com.github.springrest.util;
/*    */ 
/*    */ import javax.servlet.ServletContext;
/*    */ import org.springframework.web.context.ContextLoader;
/*    */ import org.springframework.web.context.WebApplicationContext;
/*    */ 
/*    */ public class ContextBase
/*    */ {
/*    */   public WebApplicationContext getWebApplicationContext()
/*    */   {
/* 13 */     return ContextLoader.getCurrentWebApplicationContext();
/*    */   }
/*    */ 
/*    */   public ServletContext getServletContext() {
/* 17 */     return getWebApplicationContext().getServletContext();
/*    */   }
/*    */ 
/*    */   public String getWebRootAbsolutePath() {
/* 21 */     return getServletContext().getRealPath("/");
/*    */   }
/*    */ }

/* Location:           D:\Documents\Desktop\YunweiOrder\Code\backup\ROOT\WEB-INF\classes\
 * Qualified Name:     javacommon.util.ContextBase
 * JD-Core Version:    0.6.2
 */