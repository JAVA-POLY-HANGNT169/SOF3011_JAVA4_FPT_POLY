package com.fpt.poly.selling_assignment_ph191690.service.impl;

import com.fpt.poly.selling_assignment_ph191690.entity.ChiTietSanPham;
import com.fpt.poly.selling_assignment_ph191690.repository.ChiTietSanPhamRepository;
import com.fpt.poly.selling_assignment_ph191690.response.ChiTietSanPhamResponse;
import com.fpt.poly.selling_assignment_ph191690.service.ChiTietSanPhamService;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    private ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();

    @Override
    public List<ChiTietSanPhamResponse> getAll() {
        List<ChiTietSanPham> chiTietSanPhams = this.chiTietSanPhamRepository.getAll();
        List<ChiTietSanPhamResponse> chiTietSanPhamRespons = new ArrayList<>();
        chiTietSanPhams.forEach(s -> chiTietSanPhamRespons.add(convertChiTietSanPhamToResponse(s)));
        return chiTietSanPhamRespons;
    }

    @Override
    public ChiTietSanPhamResponse getOne(String id) {
        ChiTietSanPham chiTietSanPham = this.chiTietSanPhamRepository.getOne(id);
        return convertChiTietSanPhamToResponse(chiTietSanPham);
    }

    private ChiTietSanPhamResponse convertChiTietSanPhamToResponse(ChiTietSanPham chiTietSanPham) {
        return ChiTietSanPhamResponse.builder()
                .giaNhap(chiTietSanPham.getGiaNhap())
                .giaBan(chiTietSanPham.getGiaBan())
                .soLuong(chiTietSanPham.getSoLuongTon())
                .tenMauSac(chiTietSanPham.getMauSac().getTen())
                .namBH(chiTietSanPham.getNamBH())
                .dongSP(chiTietSanPham.getDongSanPham().getTen())
                .id(chiTietSanPham.getId())
                .moTa(chiTietSanPham.getMoTa())
                .tenNSX(chiTietSanPham.getNhaSanXuat().getTen())
                .tenSP(chiTietSanPham.getSanPham().getTen())
                .build();
    }
}
