package com.example.core_module.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageServiceCategory {
	  public void init();

	  public void save(MultipartFile file,String filename);

	  public Resource load(String filename);

	  public boolean delete(String filename);
	  
	  public void deleteAll();

	  public Stream<Path> loadAll();
}
