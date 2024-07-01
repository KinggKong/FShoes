package com.example.fshoes.services.impl;

import com.example.fshoes.entities.Color;
import com.example.fshoes.entities.Sole;
import com.example.fshoes.repositories.SoleRepo;
import com.example.fshoes.services.ISoleService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class SoleService implements ISoleService {

    SoleRepo soleRepo;
    @Override
    public List<Sole> getAll() {
        return soleRepo.findAll();
    }

    @Override
    public Page<Sole> pagination(Pageable pageable) {
        return soleRepo.findAll(pageable);
    }

    @Override
    public void add(String soleName) {
        Sole sole = new Sole();
        sole.setName(soleName);
        sole.setStatus(1);
        soleRepo.save(sole);
    }

    @Override
    public void delete(Long id) {
        soleRepo.deleteById(id);
    }

    @Override
    public void update(Sole sole) {
        soleRepo.save(sole);
    }

    @Override
    public Sole findById(Long id) {
        return soleRepo.findById(id).orElse(null);
    }
}
