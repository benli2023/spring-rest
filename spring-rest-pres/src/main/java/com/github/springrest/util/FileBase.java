/*     */ package com.github.springrest.util;
/*     */ 
/*     */ import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ public class FileBase
/*     */ {
/*     */   public static boolean saveFile(MultipartFile mFile, String relativeDir, String newfileName)
/*     */     throws IllegalStateException, IOException
/*     */   {
/*  28 */     String fileDir = createDir(relativeDir);
/*     */ 
/*  30 */     if (newfileName != null) {
/*  31 */       if (FilenameUtils.getExtension(newfileName) == "")
/*  32 */         newfileName = newfileName.concat(".").concat(FilenameUtils.getExtension(mFile.getOriginalFilename()));
/*     */     }
/*     */     else {
/*  35 */       newfileName = mFile.getOriginalFilename();
/*     */     }
/*     */ 
/*  38 */     String newFileFullName = FilenameUtils.concat(fileDir, newfileName);
/*  39 */     mFile.transferTo(new File(newFileFullName));
/*  40 */     return true;
/*     */   }
/*     */ 
/*     */   public static void saveFile(String sourceFileFullPath, String targetFileFullPath)
/*     */     throws IOException
/*     */   {
/*  54 */     FileInputStream input = new FileInputStream(new File(sourceFileFullPath));
/*  55 */     OutputStream output = new FileOutputStream(new File(targetFileFullPath));
/*  56 */     saveFile(input, output);
/*     */   }
/*     */ 
/*     */   public static boolean saveFile(InputStream input, String relativeDir, String newfileName)
/*     */     throws IOException
/*     */   {
/*  68 */     String fileDir = createDir(relativeDir);
/*  69 */     String newFileFullName = FilenameUtils.concat(fileDir, newfileName);
/*  70 */     saveFile(input, newFileFullName);
/*  71 */     return true;
/*     */   }
/*     */ 
/*     */   public static void saveFile(InputStream input, String fileFullPath)
/*     */     throws IOException
/*     */   {
/*  82 */     OutputStream output = new FileOutputStream(new File(fileFullPath));
/*  83 */     saveFile(input, output);
/*     */   }
/*     */ 
/*     */   public static void saveFile(InputStream input, OutputStream output)
/*     */     throws IOException
/*     */   {
/*  93 */     IOUtils.copy(input, output);
/*     */   }
/*     */ 
/*     */   public static String createDir(String dir)
/*     */     throws IOException
/*     */   {
/* 103 */     String webRootPath = new ContextBase().getWebRootAbsolutePath();
/*     */ 
/* 105 */     File dirPath = new File(webRootPath + "static/" + dir);
/* 106 */     if (!dirPath.exists()) {
/* 107 */       dirPath.mkdirs(); 
/*     */     }
/*     */ 
/* 110 */     return dirPath.getCanonicalPath();
/*     */   }
/*     */ }

/* Location:           D:\Documents\Desktop\YunweiOrder\Code\backup\ROOT\WEB-INF\classes\
 * Qualified Name:     javacommon.util.FileBase
 * JD-Core Version:    0.6.2
 */