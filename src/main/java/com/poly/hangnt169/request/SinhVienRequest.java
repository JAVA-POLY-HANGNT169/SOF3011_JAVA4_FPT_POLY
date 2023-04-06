package com.poly.hangnt169.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class SinhVienRequest {

    private UUID id;

    private String ma;

    private String ten;

    private Boolean gioiTinh;

    private String email;

    private UUID chuyenNganhID;

    private UUID lopID;

}
