package com.nunesesports.desafioeverymind.domain;

import com.nunesesports.desafioeverymind.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "product")
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer code;
    private String description;
    private Float price;

    public Product(ProductDTO data){
        this.name = data.name();
        this.code = data.code();
        this.description = data.description();
        this.price = data.price();
    }
}