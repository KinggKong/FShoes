package com.example.fshoes.repositories;

import com.example.fshoes.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangRepository extends JpaRepository<Customer,Long> {
}
