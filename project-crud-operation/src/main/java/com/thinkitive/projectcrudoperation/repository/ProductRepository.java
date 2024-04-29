package com.thinkitive.projectcrudoperation.repository;

import com.thinkitive.projectcrudoperation.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
