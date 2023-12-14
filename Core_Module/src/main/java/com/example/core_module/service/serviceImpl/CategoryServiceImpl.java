package com.example.core_module.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.core_module.dto.CategoryDto;
import com.example.core_module.model.Category;
import com.example.core_module.repository.CategoryRepository;
import com.example.core_module.service.CategoryService;
import com.example.core_module.service.FilesStorageServiceCategory;
@Service
public class CategoryServiceImpl implements CategoryService {
@Autowired
private CategoryRepository categoryRepository;
@Autowired
private ProductServiceImpl productServiceImpl;
@Autowired
private FilesStorageServiceCategory filesStorageServiceCategory;
	@Override
	public List<Category> findAll() {
		List<Category> list1=new ArrayList<>();
		list1=categoryRepository.findAll();
		return list1;
	}

	@Override
	public Category save(CategoryDto categoryDto,MultipartFile file) {
		Category cate=new Category();
		cate.setParent_id(0);
		cate.setCategory_name(categoryDto.getCategory_name());
		cate.setDescription(categoryDto.getDescription());
		cate.setCategory_status("Active");
		cate.setCreated_At(new Date(System.currentTimeMillis()));
		cate.setUpdate_At(new Date(System.currentTimeMillis()));
		cate.set_activated(true);
		cate.set_deleted(false);
		
		Category catesave=categoryRepository.save(cate);
		
		   //Sửa tên file
	  	String input=file.getOriginalFilename();
    	// Tìm vị trí của dấu chấm cuối cùng
    			int lastDotIndex = input.lastIndexOf(".");

    			// Kiểm tra xem có dấu chấm trong chuỗi hay không
    		
    			    // Cắt lấy phần đuôi (extension) từ dấu chấm cuối cùng
    			    String extension = input.substring(lastDotIndex);

    			    // In ra phần đuôi (extension)
    			    System.out.println("Phần đuôi: " + extension);
    			String filenamedatabase="image"+catesave.getCategory_id()+extension;
	      System.out.println("file name cate"+filenamedatabase);
    			filesStorageServiceCategory.save(file,filenamedatabase);
    			
    			
	      String path="../../../../../image/category/"+filenamedatabase;
		
	      catesave.setCategory_image_path(path);
		return categoryRepository.save(catesave);
	}

	@Override
	public Category findById(Long id) {
		Category cate=categoryRepository.findById(id).get();
		return cate;
	}

	@Override
	public Category deleteById(Long id) {
		
		Category cate=findById(id);
		cate.set_activated(false);
		cate.set_deleted(true);
		cate.setUpdate_At(new Date(System.currentTimeMillis()));
	productServiceImpl.deleteByCategory_Id(id);
		return categoryRepository.save(cate);
	}

	@Override
	public Category backById(Long id) {

		Category cate=findById(id);
		cate.set_activated(true);
		cate.set_deleted(false);
		cate.setUpdate_At(new Date(System.currentTimeMillis()));
	productServiceImpl.backByCategory_Id(id);
		return categoryRepository.save(cate);
	}

	@Override
	public Category update(CategoryDto categoryDto, Long cate_id) {
		Category cate=findById(cate_id);
		cate.setCategory_name(categoryDto.getCategory_name());
		cate.setDescription(categoryDto.getDescription());
		cate.setUpdate_At(new Date(System.currentTimeMillis()));
		return categoryRepository.save(cate);
	}

}
