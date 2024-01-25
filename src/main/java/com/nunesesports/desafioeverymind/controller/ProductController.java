package com.nunesesports.desafioeverymind.controller;

import com.nunesesports.desafioeverymind.domain.Product;
import com.nunesesports.desafioeverymind.dtos.ProductDTO;
import com.nunesesports.desafioeverymind.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    private Long id;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/product")
    public ResponseEntity<?> creatProduct(@RequestBody ProductDTO product){
        Product newProduct = productService.createProduct(product);
        return ResponseEntity.ok().body(newProduct);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listProduct")
    public List<Product> listProduct( ){
        return this.productService.listProduct();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") Long id){
        this.id = id;
        this.productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDTO product){
        try {
            Product updateProduct = this.productService.updateProduct(product, id);
            return ResponseEntity.ok().body(updateProduct);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{nameOrcode}")
    public ResponseEntity<?> findByNameOrCode(@PathVariable(name = "nameOrcode") String nameOrcode){
        try {
            Product product = this.productService.findByNameOrCode(nameOrcode);
            if(product != null){
                return ResponseEntity.ok().body(product);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
