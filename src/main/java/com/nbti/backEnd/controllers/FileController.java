package com.nbti.backEnd.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nbti.backEnd.model.NBTIFile;
import com.nbti.backEnd.services.NBTIFileService;

@RestController
public class FileController {

//	final static String RES_ROUTE = "C:\\dev\\NBTI\\backEnd\\src\\main\\resources\\";

	@Autowired
	NBTIFileService service;

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam MultipartFile file) {
		System.out.println(file.getSize());
		Long imgId = service.saveMultipartFile(file);
		System.out.println(String.format("File name '%s' uploaded successfully.", imgId));

		// File f = new File(RES_ROUTE + file.getOriginalFilename());

//        try {
//        	
//			file.transferTo(f);
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//        
		return ResponseEntity.ok().body(imgId);
	}

	@GetMapping("/download/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable Long id) {
//		File f = new File(RES_ROUTE + fileName);
//		Resource fileRes = new FileSystemResource(f);
		try {
			NBTIFile img = service.FindById(id).get();
			
			Resource r = new ByteArrayResource(img.getData());
			if (img.isImage()) {
				return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(r);
			}else
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + img.getName() + "\"").body(r);
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();

		}
	}
}
