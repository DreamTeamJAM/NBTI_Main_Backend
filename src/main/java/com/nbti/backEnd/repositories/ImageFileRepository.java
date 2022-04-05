package com.nbti.backEnd.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nbti.backEnd.model.ImageFile;

public interface ImageFileRepository extends MongoRepository<ImageFile, String> {

}
