package com.example.fshoes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String productName;

    @Column(name = "description", length = 50)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;


    @ManyToOne
    @JoinColumn(name = "fabric_id", referencedColumnName = "id")
    private Fabric material;

    @ManyToOne
    @JoinColumn(name = "sole_id", referencedColumnName = "id")
    private Sole soleMaterial;

    @Column(name = "status")
    private int status;

}
