package com.thinkitive.projectcrudoperation.repository;

import com.thinkitive.projectcrudoperation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Customer, Long> {
}
