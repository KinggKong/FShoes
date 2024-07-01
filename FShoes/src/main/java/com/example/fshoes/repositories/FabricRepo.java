package com.example.fshoes.repositories;

import com.example.fshoes.entities.Fabric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricRepo extends JpaRepository<Fabric,Long> {
}
