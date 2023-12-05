package com.example.core_module.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name="contact")
public class Contact {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long contact_id;
private String name;
private String email;
private String subject;
private String message;

@ManyToOne(fetch =FetchType.EAGER )
@JoinColumn(name="customer_id",referencedColumnName = "customer_id")
private Customer customer;

}
