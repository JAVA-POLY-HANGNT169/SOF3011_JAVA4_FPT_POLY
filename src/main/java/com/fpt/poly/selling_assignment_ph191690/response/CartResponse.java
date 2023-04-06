package com.fpt.poly.selling_assignment_ph191690.response;

import com.fpt.poly.selling_assignment_ph191690.entity.ChiTietSanPham;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartResponse {

    private String id;
    private String tenSP;
    private String dongSP;
    private Integer namBH;
    private String tenMauSac;
    private Long soLuong;
    private BigDecimal giaBan;
    private ChiTietSanPham chiTietSanPham;

    public BigDecimal totalMount() {
        return BigDecimal.valueOf(soLuong).multiply(giaBan);
    }
}
