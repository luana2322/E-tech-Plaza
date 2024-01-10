package com.example.core_module.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
public class Customer implements UserDetails {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY )
@Column(name="customer_id")
private Long customer_id;
private String customeremail;
private String customerpassword;
private String first_name;
private String last_name;
private String registration_date;
private String verificationCode;
private boolean is_email_verified;
private String customer_image;
private String customer_phone;

private boolean is_activated;
private boolean is_deleted;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="country_id",referencedColumnName = "country_id")
private Country country;

@OneToMany(mappedBy = "customer")
private List<Orders> list_order;

@OneToOne(mappedBy = "customer",cascade =CascadeType.ALL )
private Cart cart;

@OneToMany(mappedBy = "customer")
private List<Bank_Account> list_customer_bank;

@OneToMany(mappedBy = "customer")
private List<Product_Review> list_product_review;

@OneToMany(mappedBy = "customer")
private List<Customer_Role> list_customer_role;

@OneToMany(mappedBy = "customer")
private List<Wishlist> list_wishlist;

@OneToMany(mappedBy = "customer")
private List<Contact> list_contact; 

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return customerpassword;
}

@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return customeremail;
}

@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return true;
}

}
