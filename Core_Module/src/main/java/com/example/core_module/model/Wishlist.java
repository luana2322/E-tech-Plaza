package com.example.core_module.model;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="wishlist")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="wishlist_id")
    private Long wishlist_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id",referencedColumnName = "product_id")
    private Product product;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id",referencedColumnName = "customer_id")
    private Customer customer;


}
