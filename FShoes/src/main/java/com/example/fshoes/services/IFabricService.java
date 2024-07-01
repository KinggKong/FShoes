package com.example.fshoes.services;

import com.example.fshoes.entities.Fabric;
import com.example.fshoes.entities.Sole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFabricService {

    List<Fabric> getAll();

    Page<Fabric> pagination(Pageable pageable);

    void add(String fabrcName);

    void delete(Long id);

    void update( Fabric fabric);

    Fabric findById(Long id);
}
