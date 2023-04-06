package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.SinhVien;
import com.fpt.poly.lab.repository.SinhVienRepository;
import com.fpt.poly.lab.service.SinhVienService;

import java.util.List;
import java.util.UUID;

public class SinhVienServiceImpl implements SinhVienService {

    private SinhVienRepository repository = new SinhVienRepository();

    @Override
    public List<SinhVien> getAll() {
        return repository.getAll();
    }

    @Override
    public List<SinhVien> search(String name) {
        return repository.search(name);
    }

    @Override
    public SinhVien getOne(UUID code) {
        return repository.getOne(code);
    }

    @Override
    public Boolean save(SinhVien sinhVien) {
        return repository.save(sinhVien);
    }

    @Override
    public Boolean update(SinhVien sinhVien) {
        return repository.update(sinhVien);
    }

    @Override
    public Boolean delete(SinhVien sinhVien) {
        return repository.remove(sinhVien);
    }
}
