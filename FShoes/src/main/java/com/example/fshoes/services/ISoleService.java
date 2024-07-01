package com.example.fshoes.services;

import com.example.fshoes.entities.Color;
import com.example.fshoes.entities.Sole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISoleService {
    List<Sole> getAll();

    Page<Sole> pagination(Pageable pageable);

    void add(String soleName);

    void delete(Long id);

    void update( Sole sole);

   Sole findById(Long id);
}
