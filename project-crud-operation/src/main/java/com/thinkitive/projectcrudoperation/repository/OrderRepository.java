package com.thinkitive.projectcrudoperation.repository;

import com.thinkitive.projectcrudoperation.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CustomerOrder, Integer> {
}
