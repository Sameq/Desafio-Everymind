package com.nunesesports.desafioeverymind.controller;

import com.nunesesports.desafioeverymind.domain.Product;
import com.nunesesports.desafioeverymind.dtos.ProductDTO;
import com.nunesesports.desafioeverymind.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/product")
    public ResponseEntity<?> creatProduct(@RequestBody ProductDTO product){
        Product newProduct = productService.createProduct(product);
        return ResponseEntity.ok().body(product);
    }
}
