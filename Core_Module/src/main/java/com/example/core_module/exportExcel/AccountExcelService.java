package com.example.core_module.exportExcel;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.model.Admin;
import com.example.core_module.model.Category;
import com.example.core_module.model.Customer;
import com.example.core_module.repository.AdminExcelRepository;
import com.example.core_module.repository.CustomerExcelRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AccountExcelService {
@Autowired
private AdminExcelRepository adminExcelRepository;
@Autowired
private CustomerExcelRepository customerExcelRepository;

public void generateExcel(HttpServletResponse response) throws Exception {

	List<Customer> listcus= customerExcelRepository.findAll();
	
	List<Admin> listadmin=adminExcelRepository.findAll();

	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet("Courses Info");
	HSSFRow row = sheet.createRow(0);

	row.createCell(0).setCellValue("ID");
	row.createCell(1).setCellValue("Email");
	row.createCell(2).setCellValue("Image Path");
	row.createCell(3).setCellValue("Phone");
	row.createCell(4).setCellValue("Full Name");
	row.createCell(5).setCellValue("Registration date");
	row.createCell(6).setCellValue("Is_Activated");
	row.createCell(7).setCellValue("Is_Deleted");
	row.createCell(8).setCellValue("Roled");


	int dataRowIndex = 1;

	for (Customer pro : listcus) {
		HSSFRow dataRow = sheet.createRow(dataRowIndex);
		
		dataRow.createCell(0).setCellValue(pro.getCustomer_id());
		dataRow.createCell(1).setCellValue(pro.getCustomeremail());
		dataRow.createCell(2).setCellValue(pro.getCustomer_image());
		dataRow.createCell(3).setCellValue(pro.getCustomer_phone());
		dataRow.createCell(4).setCellValue(pro.getFirst_name()+" "+pro.getLast_name());
		dataRow.createCell(5).setCellValue(pro.getRegistration_date());
		dataRow.createCell(6).setCellValue(pro.is_activated());
		dataRow.createCell(7).setCellValue(pro.is_deleted());
		dataRow.createCell(8).setCellValue(pro.getList_customer_role().get(0).getRole().getRole_name());

		dataRowIndex++;
	}

	for (Admin pro : listadmin) {
		HSSFRow dataRow = sheet.createRow(dataRowIndex);
		
		dataRow.createCell(0).setCellValue(pro.getAdmin_id());
		dataRow.createCell(1).setCellValue(pro.getEmail());
		dataRow.createCell(2).setCellValue(pro.getImage());
		dataRow.createCell(3).setCellValue("NULL");
		dataRow.createCell(4).setCellValue(pro.getFirst_name()+" "+pro.getLast_name());
		dataRow.createCell(5).setCellValue(pro.getRegistration_date());
		dataRow.createCell(6).setCellValue(pro.is_activated());
		dataRow.createCell(7).setCellValue(pro.is_deleted());
		dataRow.createCell(8).setCellValue(pro.getList_admin_role().get(0).getRole().getRole_name());

		dataRowIndex++;
	}

	
	ServletOutputStream ops = response.getOutputStream();
	workbook.write(ops);
	workbook.close();
	ops.close();

}

}
