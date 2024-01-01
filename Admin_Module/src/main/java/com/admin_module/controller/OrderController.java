package com.admin_module.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.core_module.exportExcel.OrderExcelService;
import com.example.core_module.model.Order_Detail;
import com.example.core_module.model.Orders;
import com.example.core_module.repository.OrderRepository;
import com.example.core_module.service.OrderService;
import com.example.core_module.service.serviceImpl.OrderServiceImpl;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
@Autowired
private OrderRepository orderRepository;
@Autowired
private OrderService orderService;
@Autowired
private OrderExcelService orderExcelService;
	
@RequestMapping(value="/list-approve",method=RequestMethod.GET)
public String order(Principal principal,
					ModelMap modelMap,
					HttpSession session) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	Object a=session.getAttribute("pen");


	List<Orders> listorder=orderRepository.getListAllApproved();
	modelMap.addAttribute("listapprove",listorder);
	return "orderapprove";
}

@RequestMapping(value="/list-reject",method=RequestMethod.GET)
public String reject(Principal principal,
					ModelMap modelMap,
					HttpSession session) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	Object a=session.getAttribute("pen");


	List<Orders> listorder=orderRepository.getListAllRejected();
	modelMap.addAttribute("listreject",listorder);
	return "orderreject";
}

@RequestMapping(value="/list-pending",method=RequestMethod.GET)
public String pending(Principal principal,
					ModelMap modelMap,
					HttpSession session) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	Object a=session.getAttribute("pen");


	List<Orders> listorder=orderRepository.getListAllPending();

	modelMap.addAttribute("listpending",listorder);
	session.setAttribute("numpending",listorder.size());
	return "orderpending";
}

@RequestMapping(value="/list-cancel",method=RequestMethod.GET)
public String cancel(Principal principal,
					ModelMap modelMap,
					HttpSession session) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	Object a=session.getAttribute("pen");


	List<Orders> listorder=orderRepository.getListAllCancel();
	modelMap.addAttribute("listcancel",listorder);
	return "ordercancel";
}

@RequestMapping(value="/approve",method=RequestMethod.GET)
public String approve(@RequestParam("order_id")Long order_Id,
					  ModelMap modelMap,
					  Principal principal) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	
	orderService.approveOrder(order_Id);
	
	List<Orders> listorder=orderRepository.getListAllPending();
	modelMap.addAttribute("listpending",listorder);
	
	return "orderpending";
}
@RequestMapping(value="/reject",method=RequestMethod.GET)
public String reject(@RequestParam("order_id")Long order_Id,
					  ModelMap modelMap,
					  Principal principal) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	
	orderService.rejectOrder(order_Id);
	
	List<Orders> listorder=orderRepository.getListAllPending();
	modelMap.addAttribute("listpending",listorder);
	
	return "orderpending";
}

@RequestMapping(value="/view-order",method=RequestMethod.GET)	
public String view_order(@RequestParam("order_id")Long order_id,
						 Principal principal,
						 ModelMap modelMap) {
	if(principal ==null) {
		return "redirect:/pages/samples/login";
	}
	
	Orders order=orderService.findById(order_id);
	
	modelMap.addAttribute("order",order);
	return "view-order";
}

//excel product
@GetMapping("/order-excel")
public void generateExcelReport(HttpServletResponse response) throws Exception{
	
	response.setContentType("application/octet-stream");
	
	String headerKey = "Content-Disposition";
	String headerValue = "attachment;filename=order.xls";

	response.setHeader(headerKey, headerValue);
	
	orderExcelService.generateExcel(response);
	
	response.flushBuffer();
}
	
}
