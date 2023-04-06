package com.fpt.poly.selling_assignment_ph191690.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "HoaDon")
public class HoaDon {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id", updatable = false, nullable = false)
    private String id;

    @Column(name = "IdKH")
    private String idKH;

    @Column(name = "IdNV")
    private String idNV;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "NgayShip")
    private Date ngayShip;

    @Column(name = "NgayNhan")
    private Date ngayNhan;

    @Column(name = "TinhTrang")
    private Long tinhTrang;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

}
