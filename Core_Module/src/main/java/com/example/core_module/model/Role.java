package com.example.core_module.model;

import java.util.Date;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="role")
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="role_id")
private Long role_id;
private String role_name;
private String description;
private Date created_At;
private Date updated_At;


@OneToMany(mappedBy = "role")
private List<Admin_Role> list_admin_role;

@OneToMany(mappedBy = "role")
private List<Customer_Role> list_customer_role;


@PrePersist
protected void onCreate() {
	this.created_At=new Date(System.currentTimeMillis());
}

@PreUpdate
protected void onUpdate() {
	this.updated_At=new Date(System.currentTimeMillis());
}

}
