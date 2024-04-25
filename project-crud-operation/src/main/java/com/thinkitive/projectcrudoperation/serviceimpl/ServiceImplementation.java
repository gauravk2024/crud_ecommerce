package com.thinkitive.projectcrudoperation.serviceimpl;

import com.thinkitive.projectcrudoperation.entity.Customer;
import com.thinkitive.projectcrudoperation.repository.RegistrationRepository;
import com.thinkitive.projectcrudoperation.service.ServiceRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ServiceImplementation implements ServiceRegister {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public List<Customer> getAllData() {
        return registrationRepository.findAll();
    }

    @Override
    public Customer getOneData(Long id) {
        Customer customerOptional = registrationRepository.findById(id).get();
        return customerOptional;
    }

    @Override
    public Customer saveData(Customer customer) {
        Customer status = registrationRepository.save(customer);
        return status;
    }

    @Override
    public void deleteByOne(Long id) {
        Customer deleteId = registrationRepository.findById(id).get();
        registrationRepository.delete(deleteId);
    }

    @Override
    public Customer updateData(Long id) {
        Customer update = registrationRepository.findById(id).get();
        Customer updateStatus = registrationRepository.save(update);
        return updateStatus;
    }
}
