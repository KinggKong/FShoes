package com.example.fshoes.repositories;

import com.example.fshoes.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepo extends JpaRepository<Color, Long> {
}
