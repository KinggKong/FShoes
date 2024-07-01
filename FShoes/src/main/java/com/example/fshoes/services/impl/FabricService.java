package com.example.fshoes.services.impl;

import com.example.fshoes.entities.Fabric;
import com.example.fshoes.entities.Sole;
import com.example.fshoes.repositories.FabricRepo;
import com.example.fshoes.services.IFabricService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class FabricService implements IFabricService {
    FabricRepo fabricRepo;
    @Override
    public List<Fabric> getAll() {
        return fabricRepo.findAll();
    }

    @Override
    public Page<Fabric> pagination(Pageable pageable) {
        return fabricRepo.findAll(pageable);
    }

    @Override
    public void add(String fabrcName) {
        Fabric fabric = new Fabric();
        fabric.setName(fabrcName);
        fabric.setStatus(1);
        fabricRepo.save(fabric);
    }

    @Override
    public void delete(Long id) {
        fabricRepo.deleteById(id);
    }

    @Override
    public void update(Fabric fabric) {
        fabricRepo.save(fabric);
    }

    @Override
    public Fabric findById(Long id) {
        return fabricRepo.findById(id).orElse(null);
    }
}
