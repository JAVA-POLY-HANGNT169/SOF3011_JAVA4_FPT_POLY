package com.fpt.poly.lab.service;

import com.fpt.poly.lab.entity.SinhVien;

import java.util.List;
import java.util.UUID;

public interface SinhVienService {

    List<SinhVien> getAll();

    List<SinhVien> search(String name);

    SinhVien getOne(UUID code);

    Boolean save(SinhVien sinhVien);

    Boolean update(SinhVien sinhVien);

    Boolean delete(SinhVien sinhVien);
}
