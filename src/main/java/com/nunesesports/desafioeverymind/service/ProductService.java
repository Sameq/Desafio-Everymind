package com.nunesesports.desafioeverymind.service;

import com.nunesesports.desafioeverymind.domain.Product;
import com.nunesesports.desafioeverymind.dtos.ProductDTO;
import com.nunesesports.desafioeverymind.repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRespository productRespository;

    public Product createProduct(ProductDTO data) {
        Product newProduct = new Product(data);
        this.saveProduct(newProduct);
        return newProduct;
    }

    public void saveProduct(Product product) {
        this.productRespository.save(product);
    }

    public List<Product> listProduct() {
        return this.productRespository.findAll();
    }

    public void deleteProduct(Long id) {
        this.productRespository.deleteById(id);
    }

    public Product updateProduct(ProductDTO product, Long id) throws Exception {
        Optional<Product> existingProduct = this.productRespository.findById(id);
        if (existingProduct.isPresent()) {
            Product updateProduct = existingProduct.get();
            updateProduct.setCode(product.code());
            updateProduct.setName(product.name());
            updateProduct.setPrice(product.price());
            updateProduct.setDescription(product.description());
            return this.productRespository.save(updateProduct);
        }
        throw new RuntimeException("Produto não econtrado");
    }


    public Product findByNameOrCode(String nameOrcode) throws  Exception {
        if(nameOrcode.matches("\\d+")){
            Product existingProductByCode = this.productRespository.findProductByCode(Integer.parseInt(nameOrcode));
            return existingProductByCode;
        }
        Product existingProductByName = this.productRespository.findProductByName(nameOrcode);
        if(existingProductByName != null){
            return existingProductByName;
        }
        throw new RuntimeException("Produto não econtrado");
    }
}