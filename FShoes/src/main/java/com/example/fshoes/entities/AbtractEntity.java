package com.example.fshoes.entities;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class AbtractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "created_At")
    @CreationTimestamp
    private LocalDateTime created_At;
    @UpdateTimestamp
    @Column(name = "updated_At")
    private LocalDateTime update_dAt;
    private Integer status;
}
