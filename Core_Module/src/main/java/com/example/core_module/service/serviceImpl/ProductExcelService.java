package com.example.core_module.service.serviceImpl;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.model.Product;
import com.example.core_module.repository.ProductExcelRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ProductExcelService {
@Autowired
private ProductExcelRepository productExcelRepository;



public void generateExcel(HttpServletResponse response) throws Exception {

	List<Product> listpro = productExcelRepository.findAll();
System.out.println("excel sixe"+listpro.size());
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet("Courses Info");
	HSSFRow row = sheet.createRow(0);

	row.createCell(0).setCellValue("ID");
	row.createCell(1).setCellValue("Name");
	row.createCell(2).setCellValue("Camera");
	row.createCell(3).setCellValue("Cost_Price");
	row.createCell(4).setCellValue("CPU");
	row.createCell(5).setCellValue("Curren Quantity");
	row.createCell(6).setCellValue("Height");
	row.createCell(7).setCellValue("Pin");
	row.createCell(8).setCellValue("Code");
	row.createCell(9).setCellValue("RAM");
	row.createCell(10).setCellValue("ROM");
	row.createCell(11).setCellValue("Sale Price");
	row.createCell(12).setCellValue("Thick");
	row.createCell(13).setCellValue("Weight");
	row.createCell(14).setCellValue("Wight");
	row.createCell(15).setCellValue("Description");
	row.createCell(16).setCellValue("Created_At");

	int dataRowIndex = 1;

	for (Product pro : listpro) {
		HSSFRow dataRow = sheet.createRow(dataRowIndex);
		
		dataRow.createCell(0).setCellValue(pro.getProduct_id());
		dataRow.createCell(1).setCellValue(pro.getProduct_name());
		dataRow.createCell(2).setCellValue(pro.getCamera());
		dataRow.createCell(3).setCellValue(pro.getCost_price());
		dataRow.createCell(4).setCellValue(pro.getCpu());
		dataRow.createCell(5).setCellValue(pro.getCurrent_quantity());
		dataRow.createCell(6).setCellValue(pro.getHeight());
		dataRow.createCell(7).setCellValue(pro.getPin());
		dataRow.createCell(8).setCellValue(pro.getProduct_sku());
		dataRow.createCell(9).setCellValue(pro.getRam());
		dataRow.createCell(10).setCellValue(pro.getRom());
		dataRow.createCell(11).setCellValue(pro.getSale_price());
		dataRow.createCell(12).setCellValue(pro.getThick());
		dataRow.createCell(13).setCellValue(pro.getWeight());
		dataRow.createCell(14).setCellValue(pro.getWidth());
		dataRow.createCell(15).setCellValue(pro.getDescription());
		dataRow.createCell(16).setCellValue(pro.getCreate_At());
		
		
		dataRowIndex++;
	}

	ServletOutputStream ops = response.getOutputStream();
	workbook.write(ops);
	workbook.close();
	ops.close();

}
}
