/*    */ package com.github.springrest.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.UUID;
/*    */ import org.apache.commons.io.FilenameUtils;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ public class FileUploadUtil
/*    */ {
/*    */   public static final String DEFAULT_FILE_UPLOAD_DIR = "fileupload/files";
/*    */ 
/*    */   public static String saveFileUpload(MultipartFile mFile, String relativeDir)
/*    */   {
/* 29 */     return saveFileUpload(mFile, relativeDir, UUID.randomUUID().toString());
/*    */   }
/*    */ 
/*    */   public static String saveFileUpload(MultipartFile mFile, String relativeDir, String newfileName)
/*    */   {
/*    */     try
/*    */     {
/* 43 */       if (newfileName != null) {
/* 44 */         if (FilenameUtils.getExtension(newfileName) == "")
/* 45 */           newfileName = newfileName.concat(".").concat(FilenameUtils.getExtension(mFile.getOriginalFilename()));
/*    */       }
/*    */       else {
/* 48 */         newfileName = mFile.getOriginalFilename();
/*    */       }
/*    */ 
/* 51 */       if (FileBase.saveFile(mFile, relativeDir, newfileName))
/* 52 */         return relativeDir.concat("/").concat(newfileName);
/*    */     }
/*    */     catch (IllegalStateException e) {
/* 55 */       e.printStackTrace();
/*    */     } catch (IOException e) {
/* 57 */       e.printStackTrace();
/*    */     }
/* 59 */     return null;
/*    */   }
/*    */ }

/* Location:           D:\Documents\Desktop\YunweiOrder\Code\backup\ROOT\WEB-INF\classes\
 * Qualified Name:     javacommon.util.FileUploadUtil
 * JD-Core Version:    0.6.2
 */