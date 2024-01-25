package com.nunesesports.desafioeverymind.repository;

import com.nunesesports.desafioeverymind.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRespository extends JpaRepository<Product, Long> {
    Product findProductByName(String name);
    Product findProductByCode(Integer code);
}
