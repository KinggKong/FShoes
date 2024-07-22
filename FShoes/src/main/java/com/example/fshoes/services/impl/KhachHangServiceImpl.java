package com.example.fshoes.services.impl;

import com.example.fshoes.entities.Customer;
import com.example.fshoes.repositories.KhachHangRepository;
import com.example.fshoes.services.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KhachHangServiceImpl implements KhachHangService {
    private final KhachHangRepository khachHangRepository;
    @Override
    public List<Customer> getAllKhachHang() {
        return khachHangRepository.findAll();
    }
}
