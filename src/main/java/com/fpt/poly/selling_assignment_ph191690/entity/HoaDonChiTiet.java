package com.fpt.poly.selling_assignment_ph191690.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {

    @Id
    private HoaDonChiTietID hoaDonChiTietID;

    @Column(name = "SoLuong")
    private Long soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

}

