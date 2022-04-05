package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.nbti.backEnd.model.ImageFile;

public interface ImageFileService {

	String saveMultipartFile(MultipartFile file);
	
	Optional<ImageFile> FindById(String id);
	
	List<ImageFile> FindAll();
	
}
