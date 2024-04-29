package com.thinkitive.projectcrudoperation.serviceimpl;

import com.thinkitive.projectcrudoperation.entity.Category;
import com.thinkitive.projectcrudoperation.entity.Product;
import com.thinkitive.projectcrudoperation.repository.ProductRepository;
import com.thinkitive.projectcrudoperation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllData() {
        return productRepository.findAll();
    }

    @Override
    public Product getOneData(int pdoduct_id) {
        return productRepository.findById(pdoduct_id).get();
    }

    @Override
    public Product saveData(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteByOne(int pdoduct_id) {
        productRepository.deleteById(pdoduct_id);
    }

    @Override
    public Product updateData(int pdoduct_id) {
        Product product = productRepository.findById(pdoduct_id).get();
        if (product != null) {
            return productRepository.save(product);
        }
        return null;
    }

//    @Override
//    public void uploadProductImage(int productId, MultipartFile file) throws IOException {
//        Optional<Product> optionalProduct = productRepository.findById(productId);
//        if (optionalProduct.isPresent()) {
//            Product product = optionalProduct.get();
//            product.setImage(file.getBytes());
//            productRepository.save(product);
//        } else {
//            throw new IllegalArgumentException("Product with ID " + productId + " not found");
//        }
//
//    }

    public Product createProduct(String name, String description, double price, MultipartFile image) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImage(image.getBytes());
        product.setPrice(price);
        product.setImage1(image.getBytes());
        product.setImage2(image.getBytes());
        return productRepository.save(product);
    }
}