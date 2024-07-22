package com.example.fshoes.entities;

import com.example.fshoes.util.Payment;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    private String consignee_name;
    private String address;
    private String phone;
    private String voucher_code;
    private String node;
    private String email;
    @Enumerated(EnumType.STRING)
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "voucher_id",referencedColumnName = "id")
    private Voucher voucher;
    private Double reduced_amount;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Integer status;
}
