package com.example.core_module.service.serviceImpl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.example.core_module.config.RandomStringGenerator;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.core_module.dto.AccountDto;
import com.example.core_module.dto.CustomerDto;
import com.example.core_module.model.Customer;
import com.example.core_module.repository.CustomerRepository;
import com.example.core_module.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private Customer_RoleServiceImpl customer_RoleServiceImpl;
	@Autowired
	private JavaMailSender javaMailSender;

	private RandomStringGenerator randomStringGenerator;

	@Override
	public List<Customer> findAll() {
		List<Customer> listcus=new ArrayList<>();
		listcus=customerRepository.findAll();
		return listcus;
	}

	@Override
	public Customer findById(Long customer_id) {
		Customer cus=customerRepository.findById(customer_id).get();
		return cus;
	}

	@Override
	public Customer save(CustomerDto customerDto,String siteURL) throws UnsupportedEncodingException, MessagingException {
		
		Customer customer=new Customer();
		customer.setCustomeremail(customerDto.getCustomeremail());
		customer.setRegistration_date(new Date(System.currentTimeMillis()).toString());
		customer.setCustomerpassword(passwordEncoder.encode(customerDto.getCustomerpassword()));
		customer.set_activated(true);
		customer.set_deleted(false);

		String randomCode = RandomStringGenerator.randomString(64);
		customer.setVerificationCode(randomCode);
		sendVerificationEmail(customer, siteURL);

		Customer cus1=customerRepository.save(customer);
		customer_RoleServiceImpl.save(cus1);
		
		 
		return customerRepository.save(cus1);	
	}

	@Override
	public Customer adminsave(AccountDto accountDto) {
		Customer customer=new Customer();
		customer.setCustomeremail(accountDto.getEmail());
		customer.setFirst_name(accountDto.getFirstname());
		customer.setLast_name(accountDto.getLastname());
		customer.setCustomerpassword(passwordEncoder.encode(accountDto.getPass()));
		customer.set_activated(true);
		customer.set_deleted(false);
				
		Customer cus1=customerRepository.save(customer);
		customer_RoleServiceImpl.save(cus1);
		
		return customerRepository.save(cus1);	
	}

	@Override
	public void deleteById(Long customer_id) {
		Customer cus=findById(customer_id);
		cus.set_activated(false);
		cus.set_deleted(true);
		customerRepository.save(cus);
		
	}

	@Override
	public Customer update(AccountDto accountDto, Long customer_id) {
		customer_RoleServiceImpl.deleteByCustomer_id(customer_id);
		Customer customer=findById(customer_id);
		customer.setCustomer_id(customer_id);
		customer.setCustomeremail(accountDto.getEmail());
		customer.setFirst_name(accountDto.getFirstname());
		customer.setLast_name(accountDto.getLastname());
	//	customer.setCustomerpassword(passwordEncoder.encode(accountDto.getPass()));
		customer.set_activated(true);
		customer.set_deleted(false);
				
		Customer cus1=customerRepository.save(customer);
		customer_RoleServiceImpl.save(cus1);
		
		return customerRepository.save(cus1);	
	}

	@Override
	public void sendVerificationEmail(Customer customer, String siteURL)
			throws MessagingException, UnsupportedEncodingException {
		String toAddress = customer.getCustomeremail();
		String fromAddress = "thailuanpy1234@gmail.com";
		String senderName = "Your company name";
		String subject = "Please verify your registration";
		String content = "Dear [[name]],<br>"
				+ "Please click the link below to verify your registration:<br>"
				+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
				+ "Thank you,<br>"
				+ "Your company name.";

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom(fromAddress, senderName);
		helper.setTo(toAddress);
		helper.setSubject(subject);

		content = content.replace("[[name]]", customer.getFirst_name()+customer.getLast_name());
		String verifyURL = siteURL + "/verify?code=" +customer.getVerificationCode();

		content = content.replace("[[URL]]", verifyURL);

		helper.setText(content, true);

		javaMailSender.send(message);

	}

	@Override
	public boolean verify(String verificationCode) {
	    Customer user = customerRepository.findByVerificationCode(verificationCode);
	     
	    if (user == null || user.isEnabled()) {
	        return false;
	    } else {
	        user.setVerificationCode(null);
	        user.set_activated(false);
	        customerRepository.save(user);
	         
	        return true;
	    }
	     
	}

}
