package com.nbti.backEnd.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nbti.backEnd.model.NBTIFile;
import com.nbti.backEnd.repositories.NBTIFileRepository;
import com.nbti.backEnd.utils.Reflect;

@Service
public class NBTIFileServiceImpl implements NBTIFileService {

	@Autowired
	NBTIFileRepository imgRepo;
	@Override
	public Long saveMultipartFile(MultipartFile file) {
		NBTIFile imgFile = new NBTIFile();
		imgFile.setName(file.getOriginalFilename());
		imgFile.setType(file.getContentType());
		System.out.println(file.getName());
		System.out.println(imgFile.getType());
		try {
			imgFile.setData(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reflect.UpdateDates(imgFile);
		NBTIFile savedFile = imgRepo.save(imgFile);
		System.out.println(savedFile.getId());
		return savedFile.getId();
	}

	@Override
	public Optional<NBTIFile> FindById(Long id) {
		
		return imgRepo.findById(id);
	}

	@Override
	public List<NBTIFile> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
