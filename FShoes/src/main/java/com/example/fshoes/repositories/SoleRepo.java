package com.example.fshoes.repositories;

import com.example.fshoes.entities.Sole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoleRepo extends JpaRepository<Sole,Long> {
}
