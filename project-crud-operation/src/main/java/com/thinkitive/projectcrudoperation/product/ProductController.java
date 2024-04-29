package com.thinkitive.projectcrudoperation.product;

import com.thinkitive.projectcrudoperation.entity.Category;
import com.thinkitive.projectcrudoperation.entity.Product;
import com.thinkitive.projectcrudoperation.serviceimpl.ProductImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductImplementation productImplementation;

    @GetMapping("/product/get/{pdoduct_id}")
    public ResponseEntity<?> getProductById(@PathVariable int pdoduct_id){
        Product getProduct = productImplementation.getOneData(pdoduct_id);
        if (getProduct != null) {
            return ResponseEntity.ok().body(getProduct);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID " + pdoduct_id + " not found");
        }
    }

    @GetMapping("/product/getall")
    public ResponseEntity<?> getAllProducts(){
        List<Product> allProducts = productImplementation.getAllData();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping("/product/create")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        Product createdProduct = productImplementation.saveData(product);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Product created successfully");
    }

    @DeleteMapping("/product/delete/{pdoduct_id}")
    public ResponseEntity<?> deleteProductById(@RequestParam int pdoduct_id){
        productImplementation.deleteByOne(pdoduct_id);
        return ResponseEntity.ok().body("Product deleted successfully");
    }

    @PutMapping("/product/update/{pdoduct_id}")
    public ResponseEntity<?> updateProduct(@RequestParam int pdoduct_id){
        Product updatedProduct = productImplementation.updateData(pdoduct_id);
        return ResponseEntity.ok().body("Product updated successfully");
    }

    @PostMapping("/product/create/new")
    public ResponseEntity<Product> createProduct(@RequestParam("name") String name,
                                                 @RequestParam("description") String description,
                                                 @RequestParam("price") double price,
                                                 @RequestParam("image") MultipartFile image) throws IOException {
        Product product = productImplementation.createProduct(name, description, price, image);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
