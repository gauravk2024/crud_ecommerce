package com.thinkitive.projectcrudoperation.service;

import com.thinkitive.projectcrudoperation.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceRegister {
    public List<Customer> getAllData();
    public Customer getOneData(Long id);
    public Customer saveData(Customer customer);
    public void deleteByOne(Long id);
    public Customer updateData(Long id);
}
