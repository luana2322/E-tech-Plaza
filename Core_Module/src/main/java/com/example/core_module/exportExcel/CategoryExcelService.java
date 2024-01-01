package com.example.core_module.exportExcel;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.model.Category;
import com.example.core_module.repository.CategoryExcelRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
@Service
public class CategoryExcelService {
@Autowired
private CategoryExcelRepository categoryExcelRepository;


public void generateExcel(HttpServletResponse response) throws Exception {

	List<Category> listcate= categoryExcelRepository.findAll();

	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet("Courses Info");
	HSSFRow row = sheet.createRow(0);

	row.createCell(0).setCellValue("ID");
	row.createCell(1).setCellValue("Path Image");
	row.createCell(2).setCellValue("Name");
	row.createCell(3).setCellValue("Created At");
	row.createCell(4).setCellValue("Description");
	row.createCell(5).setCellValue("Is_activated");
	row.createCell(6).setCellValue("Is_deleted");
	row.createCell(7).setCellValue("Update_At");


	int dataRowIndex = 1;

	for (Category pro : listcate) {
		HSSFRow dataRow = sheet.createRow(dataRowIndex);
		
		dataRow.createCell(0).setCellValue(pro.getCategory_id());
		dataRow.createCell(1).setCellValue(pro.getCategory_image_path());
		dataRow.createCell(2).setCellValue(pro.getCategory_name());
		dataRow.createCell(3).setCellValue(pro.getCreated_At());
		dataRow.createCell(4).setCellValue(pro.is_activated());
		dataRow.createCell(5).setCellValue(pro.is_deleted());
		dataRow.createCell(6).setCellValue(pro.getUpdate_At());

		
		
		dataRowIndex++;
	}

	ServletOutputStream ops = response.getOutputStream();
	workbook.write(ops);
	workbook.close();
	ops.close();

}
}
