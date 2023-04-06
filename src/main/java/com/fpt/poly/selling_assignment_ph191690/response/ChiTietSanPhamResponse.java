package com.fpt.poly.selling_assignment_ph191690.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ChiTietSanPhamResponse {

    private String id;
    private String tenSP;
    private String tenNSX;
    private String tenMauSac;
    private String dongSP;
    private Integer namBH;
    private String moTa;
    private Integer soLuong;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;

}
