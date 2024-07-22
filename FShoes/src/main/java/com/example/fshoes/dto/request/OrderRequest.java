package com.example.fshoes.dto.request;

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
public class OrderRequest {
    private Long id;
    private String ten_nguoi_nhan;
    private String dia_chi_nhan;
    private String sdt;
    private String ma_giam_gia;
    private String ghi_chu;
    private String email;
    private Long id_nhan_vien;
    private Long id_khach_hang;
    private String hinh_thuc_thanh_toan;
    private Long id_voucher;
    private Double so_tien_giam;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;
    private Integer status;
}
