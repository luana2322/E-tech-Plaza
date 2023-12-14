package com.example.core_module.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.core_module.dto.ProductDto;
import com.example.core_module.dto.Product_CategoryDto;
import com.example.core_module.model.Color;
import com.example.core_module.model.Product;
import com.example.core_module.model.Product_Category;
import com.example.core_module.model.Product_Image;
import com.example.core_module.repository.ProductRepository;
import com.example.core_module.repository.Product_CategoryRepository;
import com.example.core_module.repository.Product_ImageRepository;
import com.example.core_module.service.FilesStorageService;
import com.example.core_module.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
@Autowired
private ProductRepository productRepository;
@Autowired
private FilesStorageServiceImpl filesStorageServiceImpl;
@Autowired
private Product_CategoryServiceImpl product_CategoryServiceImpl;
@Autowired
private ColorServiceImpl colorServiceImpl;
@Autowired
private Product_ImageServiceImpl product_ImageServiceImpl;
@Autowired
private FilesStorageService filesStorageService;
@Autowired
private Product_CategoryRepository product_CategoryRepository;
@Autowired
private Product_ImageRepository product_ImageRepository;
	@Override
	public List<Product> findAll() {
		List<Product> list1=new ArrayList<>();
		list1=productRepository.findAll();
		return list1;
	}

	@Override
	public Product findById(Long id) {
		Product pro =productRepository.findById(id).get();
		return pro;
	}

	@Override
	public Product deleteById(Long id) {
		Product pro=productRepository.findById(id).get();
		pro.set_activated(false);
		pro.set_deleted(true);
		return productRepository.save(pro);
	}

	@Override
	public Page<Product> getProductPagination(Integer pageNumber, Integer pageSize) {
		Pageable pageable=PageRequest.of(pageNumber, pageSize,Sort.by("description"));
		return productRepository.findAll(pageable);
	}

	@Override
	public Product save(ProductDto productDto,List<MultipartFile> listfile) {
		
		Product pro=new Product();
		pro.setProduct_name(productDto.getProduct_name());
		pro.setProduct_sku(productDto.getProduct_sku());
		pro.setCost_price(productDto.getCost_price());
		pro.setSale_price(productDto.getSale_price());
		pro.setCpu(productDto.getCpu());
		pro.setRam(productDto.getRam());
		pro.setRom(productDto.getRom());
		pro.setCamera(productDto.getCamera()+"MP");
		pro.setPin(productDto.getPin());
		pro.setWeight(productDto.getWeight());
		pro.setWidth(productDto.getWidth());
		pro.setHeight(productDto.getHeight());
		pro.setThick(productDto.getThick());
		pro.setCurrent_quantity(productDto.getCurrent_quantity());
		pro.set_activated(true);
		pro.set_deleted(false);
		pro.setDescription(productDto.getDescription());
		pro.setCreate_At(new Date(System.currentTimeMillis()));
		pro.setUpdate_At(new Date(System.currentTimeMillis()));
		
	//*first time save product
		Product prosave=productRepository.save(pro);
		
		//work with category
		List<Product_Category> listprocate=new ArrayList<>();
		
		Product_Category product_Category=new Product_Category();
		product_Category.setProduct(prosave);
		product_Category.setCategory(productDto.getCategory());
		Product_Category procate= product_CategoryServiceImpl.save(product_Category);
		
		listprocate.add(procate);
		
	//*Start work with image
		//get list color for each file to database
		List<Long> listlong=new ArrayList<>();
		listlong.add(productDto.getColor_id1());
		listlong.add(productDto.getColor_id2());
		listlong.add(productDto.getColor_id3());
		List<Color> listcolor=getlistColor(listlong);
		
		List<String> abc=new ArrayList<>();
		abc.add("a");
		abc.add("b");
		abc.add("c");
		int num_filename=0;
		// mục đích là đưa các kí tự vào filename để không bị trùng
		// vì mỗi product chỉ có môt id nên không thể đặt cho 3 file
		Product_Image product_Imagesave;
		List<Product_Image> listpro_img=new ArrayList<>() ;
		int sort_order=1;
		for (MultipartFile file : listfile) {
			//save file to folder
			
			//save file to database
		Product_Image product_Image=new Product_Image();
	      product_Image.setColor(listcolor.get(sort_order-1));
	      product_Image.setProduct(prosave);
	      product_Image.setSort_order(sort_order);
	      
	      //Sửa tên file
	  	String input=file.getOriginalFilename();
    	// Tìm vị trí của dấu chấm cuối cùng
    			int lastDotIndex = input.lastIndexOf(".");

    			// Kiểm tra xem có dấu chấm trong chuỗi hay không
    		
    			    // Cắt lấy phần đuôi (extension) từ dấu chấm cuối cùng
    			    String extension = input.substring(lastDotIndex);

    			    // In ra phần đuôi (extension)
    			    System.out.println("Phần đuôi: " + extension);
    			String filenamedatabase="image"+prosave.getProduct_id()+abc.get(num_filename)+extension;
	      System.out.println("file name"+filenamedatabase);
	      num_filename++;
    			filesStorageService.save(file,filenamedatabase);
    			
    			
	      String path="../../../../../image/product/"+filenamedatabase;
	      product_Image.setProduct_image_path(path);
	      
	      product_Imagesave= product_ImageServiceImpl.save(product_Image);
	      listpro_img.add(product_Imagesave);
		sort_order++;
		}
		//end work with image
		prosave.setUpdate_At(new Date(System.currentTimeMillis()));
		prosave.setList_product_image(listpro_img);
		prosave.setList_product_category(listprocate);
		
		return productRepository.save(prosave);
	}

	public List<Color> getlistColor(List<Long> list){
		List<Color> listcolor=new  ArrayList<>();
		for (Long long1 : list) {
			listcolor.add(colorServiceImpl.findById(long1));
		}
		return listcolor;
	}

	@Override
	public Product update(ProductDto productDto, List<MultipartFile> listfile, Long product_id) {
		//product_CategoryRepository.deleteByProduct_id(product_id);
		// product_ImageRepository.deleteByProduct_id(product_id);
		 product_CategoryServiceImpl.deleteByProduct_id(product_id);
		 
		Product pro=new Product();
		pro.setProduct_id(product_id);
		pro.setProduct_name(productDto.getProduct_name());
		pro.setProduct_sku(productDto.getProduct_sku());
		pro.setCost_price(productDto.getCost_price());
		pro.setSale_price(productDto.getSale_price());
		pro.setCpu(productDto.getCpu());
		pro.setRam(productDto.getRam());
		pro.setRom(productDto.getRom());
		pro.setCamera(productDto.getCamera()+"MP");
		pro.setPin(productDto.getPin());
		pro.setWeight(productDto.getWeight());
		pro.setWidth(productDto.getWidth());
		pro.setHeight(productDto.getHeight());
		pro.setThick(productDto.getThick());
		pro.setCurrent_quantity(productDto.getCurrent_quantity());
		pro.set_activated(true);
		pro.set_deleted(false);
		pro.setDescription(productDto.getDescription());
		pro.setUpdate_At(new Date(System.currentTimeMillis()));
		
	//*first time save product
		Product prosave=productRepository.save(pro);
		
		//work with category
		List<Product_Category> listprocate=new ArrayList<>();
		
		Product_Category product_Category=new Product_Category();
		product_Category.setProduct(prosave);
		product_Category.setCategory(productDto.getCategory());
		Product_Category procate= product_CategoryServiceImpl.save(product_Category);
		
		listprocate.add(procate);
		
//	//*Start work with image
//		//get list color for each file to database
//		List<Long> listlong=new ArrayList<>();
//		listlong.add(productDto.getColor_id1());
//		listlong.add(productDto.getColor_id2());
//		listlong.add(productDto.getColor_id3());
//		List<Color> listcolor=getlistColor(listlong);
//		
//		List<String> abc=new ArrayList<>();
//		abc.add("a");
//		abc.add("b");
//		abc.add("c");
//		int num_filename=0;
//		// mục đích là đưa các kí tự vào filename để không bị trùng
//		// vì mỗi product chỉ có môt id nên không thể đặt cho 3 file
//		Product_Image product_Imagesave;
//		List<Product_Image> listpro_img=new ArrayList<>() ;
//		int sort_order=1;
//		for (MultipartFile file : listfile) {
//			//save file to folder
//			
//			//save file to database
//		Product_Image product_Image=new Product_Image();
//	      product_Image.setColor(listcolor.get(sort_order-1));
//	      product_Image.setProduct(prosave);
//	      product_Image.setSort_order(sort_order);
//	      
//	      //Sửa tên file
//	  	String input=file.getOriginalFilename();
//    	// Tìm vị trí của dấu chấm cuối cùng
//    			int lastDotIndex = input.lastIndexOf(".");
//
//    			// Kiểm tra xem có dấu chấm trong chuỗi hay không
//    		
//    			    // Cắt lấy phần đuôi (extension) từ dấu chấm cuối cùng
//    			    String extension = input.substring(lastDotIndex);
//
//    			    // In ra phần đuôi (extension)
//    			    System.out.println("Phần đuôi: " + extension);
//    			String filenamedatabase="image"+prosave.getProduct_id()+abc.get(num_filename)+extension;
//	      System.out.println("file name"+filenamedatabase);
//	      num_filename++;
//    			filesStorageService.save(file,filenamedatabase);
//    			
//    			
//	      String path="../../../../../image/product/"+filenamedatabase;
//	      product_Image.setProduct_image_path(path);
//	      
//	      product_Imagesave= product_ImageServiceImpl.save(product_Image);
//	      listpro_img.add(product_Imagesave);
//		sort_order++;
//		}
//		//end work with image
		
	//	prosave.setList_product_image(listpro_img);
		
		prosave.setList_product_category(listprocate);
		
		return productRepository.save(prosave);
		
	}

	@Override
	public void deleteByCategory_Id(Long category_id) {
		List<Product> listpro=productRepository.getProductByCategory(category_id);
		
		for (Product product : listpro) {
			product.set_activated(false);
			product.set_deleted(true);
			product.setUpdate_At(new Date(System.currentTimeMillis()));
			productRepository.save(product);
		}
		
	}

	@Override
	public void backByCategory_Id(Long category_id) {
	List<Product> listpro=productRepository.getProductByCategory(category_id);
		
		for (Product product : listpro) {
			product.set_activated(true);
			product.set_deleted(false);
			product.setUpdate_At(new Date(System.currentTimeMillis()));
			productRepository.save(product);
		}
	}

	@Override
	public Product increas_view_product(Long product_id) {
		Product pro=findById(product_id);
		pro.setView(pro.getView()+1);
		return productRepository.save(pro);
	}
		
}
