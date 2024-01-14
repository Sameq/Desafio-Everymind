package com.nunesesports.desafioeverymind.repository;

import com.nunesesports.desafioeverymind.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<Product, Long> {
    Product findByName(String name);
    Product findByCode(Integer code);
}
