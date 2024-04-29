package com.thinkitive.projectcrudoperation.service;

import com.thinkitive.projectcrudoperation.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllData();

    Product getOneData(int pdoduct_id);

    Product saveData(Product product);

    void deleteByOne(int pdoduct_id);

    Product updateData(int pdoduct_id);

//    void uploadProductImage(int productId, MultipartFile file) throws IOException;
}