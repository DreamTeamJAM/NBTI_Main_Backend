package com.nbti.backEnd.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nbti.backEnd.model.ImageFile;
import com.nbti.backEnd.repositories.ImageFileRepository;

@Service
public class ImageFileServiceImpl implements ImageFileService {

	@Autowired
	ImageFileRepository imgRepo;
	@Override
	public String saveMultipartFile(MultipartFile file) {
		ImageFile imgFile = new ImageFile();
		imgFile.setName(file.getOriginalFilename());
		imgFile.setType(file.getContentType());
		System.out.println(file.getName());
		System.out.println(imgFile.getType());
		try {
			imgFile.setData(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageFile savedFile = imgRepo.save(imgFile);
		System.out.println(savedFile.getId());
		return savedFile.getId();
	}

	@Override
	public Optional<ImageFile> FindById(String id) {
		
		return imgRepo.findById(id);
	}

	@Override
	public List<ImageFile> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
