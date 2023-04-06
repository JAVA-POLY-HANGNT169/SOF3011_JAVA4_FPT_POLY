package com.fpt.poly.selling_assignment_ph191690.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSanPham {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id", updatable = false, nullable = false)
    private String id;

    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP", referencedColumnName = "id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNsx", referencedColumnName = "id")
    private NhaSanXuat nhaSanXuat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "id")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "id")
    private DongSanPham dongSanPham;

}
