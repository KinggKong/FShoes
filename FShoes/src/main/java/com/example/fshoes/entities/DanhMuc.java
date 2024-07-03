package com.example.fshoes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "danh_muc")
public class DanhMuc extends AbtractEntity{
}
