package com.example.core_module.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer_bank")
public class Bank_Account {
@Id
@GeneratedValue
@Column(name="customer_bank_id")
private Long customer_bank_id;
private String  bank_account_number;
private Date created_At;
private Date updated_At;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="bank_id",referencedColumnName = "bank_id")
private Bank bank;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="customer_id",referencedColumnName = "customer_id")
private Customer customer;

}
