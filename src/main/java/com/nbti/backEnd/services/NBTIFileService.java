package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.nbti.backEnd.model.NBTIFile;

public interface NBTIFileService {

	Long saveMultipartFile(MultipartFile file);
	
	Optional<NBTIFile> FindById(Long id);
	
	List<NBTIFile> FindAll();
	
}
