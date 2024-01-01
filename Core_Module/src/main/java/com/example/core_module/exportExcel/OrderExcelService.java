package com.example.core_module.exportExcel;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.model.Orders;
import com.example.core_module.repository.OrderExcelRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class OrderExcelService {
@Autowired
private OrderExcelRepository orderExcelRepository;




public void generateExcel(HttpServletResponse response) throws Exception {

	List<Orders> listorder= orderExcelRepository.findAll();
System.out.println("excel sixe"+listorder.size());
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet("Courses Info");
	HSSFRow row = sheet.createRow(0);

	row.createCell(0).setCellValue("ID");
	row.createCell(1).setCellValue("Address 1");
	row.createCell(2).setCellValue("Address 2");
	row.createCell(3).setCellValue("Company Name");
	row.createCell(4).setCellValue("Email");
	row.createCell(5).setCellValue("Full Name");
	row.createCell(6).setCellValue("Order Date");
	row.createCell(7).setCellValue("Order Note");
	row.createCell(8).setCellValue("Order Status");
	row.createCell(9).setCellValue("Phone");
	row.createCell(10).setCellValue("Total Amount");
	row.createCell(11).setCellValue("ZipCode");
	row.createCell(12).setCellValue("City");
	row.createCell(13).setCellValue("CustomerId");

	int dataRowIndex = 1;

	for (Orders pro : listorder) {
		HSSFRow dataRow = sheet.createRow(dataRowIndex);
		
		dataRow.createCell(0).setCellValue(pro.getOrder_id());
		dataRow.createCell(1).setCellValue(pro.getAddress_1());
		dataRow.createCell(2).setCellValue(pro.getAddress_2());
		dataRow.createCell(3).setCellValue(pro.getCompany_name());
		dataRow.createCell(4).setCellValue(pro.getEmail());
		dataRow.createCell(5).setCellValue(pro.getFirst_name()+" "+pro.getLast_name());
		dataRow.createCell(6).setCellValue(pro.getOrder_date());
		dataRow.createCell(7).setCellValue(pro.getOrder_note());
		dataRow.createCell(8).setCellValue(pro.getOrder_status());
		dataRow.createCell(9).setCellValue(pro.getPhone());
		dataRow.createCell(10).setCellValue(pro.getTotal_amount());
		dataRow.createCell(11).setCellValue(pro.getZipcode());
		dataRow.createCell(12).setCellValue(pro.getCity().getCity_name());
		dataRow.createCell(13).setCellValue(pro.getCustomer().getCustomer_id());
		
		dataRowIndex++;
	}

	ServletOutputStream ops = response.getOutputStream();
	workbook.write(ops);
	workbook.close();
	ops.close();

}
}
