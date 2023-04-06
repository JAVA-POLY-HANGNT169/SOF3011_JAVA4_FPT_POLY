package com.fpt.poly.selling_assignment_ph191690.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hangnt169
 */
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoaDonChiTietID {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDon", referencedColumnName = "Id", insertable = false, updatable = false)
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChiTietSP", referencedColumnName = "Id", insertable = false, updatable = false)
    private ChiTietSanPham chiTietSanPham;

}
