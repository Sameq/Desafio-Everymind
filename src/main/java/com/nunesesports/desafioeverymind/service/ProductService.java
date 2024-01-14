package com.nunesesports.desafioeverymind.service;

import com.nunesesports.desafioeverymind.domain.Product;
import com.nunesesports.desafioeverymind.dtos.ProductDTO;
import com.nunesesports.desafioeverymind.repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRespository productRespository;

    public Product createProduct(ProductDTO data){
        Product newProduct = new Product(data);
        this.saveProduct(newProduct);
        return newProduct;
    }

    public void saveProduct(Product product){
        this.productRespository.save(product);
    }
}
