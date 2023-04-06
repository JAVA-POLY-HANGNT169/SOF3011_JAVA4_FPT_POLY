package com.fpt.poly.lab.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SinhVienResponse {

    private UUID ma;
    private String ten;
    private Long tuoi;
    private String diaChi;
    private Boolean gioiTinh;
    private String tenGV;

}
