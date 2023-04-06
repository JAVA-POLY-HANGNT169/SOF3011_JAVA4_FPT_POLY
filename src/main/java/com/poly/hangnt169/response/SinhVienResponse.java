package com.poly.hangnt169.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author hangnt169
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SinhVienResponse {

    private UUID id;

    private String maSV;

    private String tenSV;

    private String email;

    private Boolean gioiTinh;

    private String tenLop;

    private String tenChuyenNganh;

    private UUID lopID;

    private UUID chuyenNganhID;

}
