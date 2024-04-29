package com.thinkitive.projectcrudoperation.controller;

import com.thinkitive.projectcrudoperation.entity.Customer;
import com.thinkitive.projectcrudoperation.serviceimpl.ServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.util.List;

@RestController
public class ResgistrationController {



    @Autowired
    private ServiceImplementation serviceImplementation;

    @GetMapping("/user/get/{id}")
    public ResponseEntity<?> getData(@PathVariable Long id){
        Customer getUser = serviceImplementation.getOneData(id);
        if (getUser != null) {
            return ResponseEntity.ok().body(getUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + id + " not found");
        }
    }

    @GetMapping("/user/getall")
    public ResponseEntity<?> getAllData(){
        List<Customer> getAll = serviceImplementation.getAllData();
       return ResponseEntity.ok(getAll);
    }

    @PostMapping("/user/create")
    public ResponseEntity<?> createEmpData(@RequestBody Customer customer) {
        Customer create = serviceImplementation.saveData(customer);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Created Successfully");
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<?> deleteMyUser(@PathVariable Long id){
        serviceImplementation.deleteByOne(id);
        return ResponseEntity.ok().body("delete");
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id){
        Customer updateStatus = serviceImplementation.updateData(id);
        return ResponseEntity.ok().body("update");
    }

    @GetMapping("customer/totalcount/{id}")
    public ResponseEntity<?> getTotalCountOrder(@PathVariable Long id){
        double getUser = serviceImplementation.getTotalPriceAndAddressForCustomer(id);

        return ResponseEntity.ok(getUser);
    }

//    @PostMapping("/uploadImage")
//    public ResponseEntity<String> uploadImage(@RequestBody byte[] imageData) {
//        try {
//            if (imageData == null || imageData.length == 0) {
//                return ResponseEntity.badRequest().body("Image data is empty");
//            }
//
//            serviceImplementation.saveProductImage(imageData);
//            return ResponseEntity.ok("Image uploaded successfully");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
//        }
//    }
}