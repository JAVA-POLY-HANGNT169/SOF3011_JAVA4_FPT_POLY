package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.SinhVien;
import com.fpt.poly.lab.repository.SinhVienRepository;
import com.fpt.poly.lab.response.SinhVienResponse;
import com.fpt.poly.lab.service.SinhVienService;

import java.util.ArrayList;
import java.util.List;

public class SinhVienServiceImpl implements SinhVienService {

    private SinhVienRepository sinhVienRepository = new SinhVienRepository();

    public List<SinhVienResponse> getAll() {
        List<SinhVienResponse> responses = new ArrayList<>();
        List<SinhVien> lists = sinhVienRepository.getAll();
        lists.forEach(s -> responses.add(convertToResponse(s)));
        return responses;
    }

    @Override
    public List<SinhVienResponse> getAll1() {
        return sinhVienRepository.getAll1();
    }

    private SinhVienResponse convertToResponse(SinhVien sinhVien) {
        SinhVienResponse response = new SinhVienResponse();
        response.setDiaChi(sinhVien.getDiaChi());
        response.setGioiTinh(sinhVien.getGioiTinh());
        response.setMa(sinhVien.getMa());
        response.setTen(sinhVien.getTen());
        response.setTuoi(sinhVien.getTuoi());
        response.setTenGV(sinhVien.getGiangVien().getTen());
        return response;
    }

    public static void main(String[] args) {
        new SinhVienServiceImpl().getAll().forEach(o -> System.out.println(o.toString()));
        new SinhVienServiceImpl().getAll1().forEach(o -> System.out.println(o.toString()));
    }

}
