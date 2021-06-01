package com.example.upload.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
 
import com.example.upload.form.MyUploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileController {
	@RequestMapping(value = "/")
	   public String homePage() {
	 
	      return "index";
	   }
	 
	   // 단일 파일 업로드 화면 보여주기
	   @RequestMapping(value = "/uploadOneFile", method = RequestMethod.GET)
	   public String uploadOneFileHandler(Model model) {
	 
	      MyUploadForm myUploadForm = new MyUploadForm();
	      model.addAttribute("myUploadForm", myUploadForm);
	 
	      return "uploadOneFile";
	   }
	 
	   // 포스트형식으로 파일 전송하기
	   @RequestMapping(value = "/uploadOneFile", method = RequestMethod.POST)
	   public String uploadOneFileHandlerPOST(HttpServletRequest request, //
	         Model model, //
	         @ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {
	 
	      return this.doUpload(request, model, myUploadForm);
	 
	   }
	 
	   // 다중파일 화면 보여주기
	   @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.GET)
	   public String uploadMultiFileHandler(Model model) {
	 
	      MyUploadForm myUploadForm = new MyUploadForm();
	      model.addAttribute("myUploadForm", myUploadForm);
	 
	      return "uploadMultiFile";
	   }
	 
	   // 파일 전송하기
	   @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
	   public String uploadMultiFileHandlerPOST(HttpServletRequest request, //
	         Model model, //
	         @ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {
	 
	      return this.doUpload(request, model, myUploadForm);
	 
	   }
	 
	   private String doUpload(HttpServletRequest request, Model model, //
	         MyUploadForm myUploadForm) {
	 
	      String description = myUploadForm.getDescription();
	      System.out.println("Description: " + description);
	 
	      
	      String uploadRootPath = request.getServletContext().getRealPath("upload");
	      System.out.println("uploadRootPath=" + uploadRootPath);
	 
	      File uploadRootDir = new File(uploadRootPath);
	      //  디렉토리가 없을경우
	      if (!uploadRootDir.exists()) {
	         uploadRootDir.mkdirs();
	      }
	      MultipartFile[] fileDatas = myUploadForm.getFileDatas();
	      //
	      List<File> uploadedFiles = new ArrayList<File>();
	      List<String> failedFiles = new ArrayList<String>();
	 
	      for (MultipartFile fileData : fileDatas) {
	 
	        
	         String name = fileData.getOriginalFilename();
	         System.out.println("Client File Name = " + name);
	 
	         if (name != null && name.length() > 0) {
	            try {
	               // Create the file at server
	               File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
	 
	               BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
	               stream.write(fileData.getBytes());
	               stream.close();
	               //
	               uploadedFiles.add(serverFile);
	               System.out.println("Write file: " + serverFile);
	            } catch (Exception e) {
	               System.out.println("Error Write file: " + name);
	               failedFiles.add(name);
	            }
	         }
	      }
	      model.addAttribute("description", description);
	      model.addAttribute("uploadedFiles", uploadedFiles);
	      model.addAttribute("failedFiles", failedFiles);
	      return "uploadResult";
	   }
	 
	}
