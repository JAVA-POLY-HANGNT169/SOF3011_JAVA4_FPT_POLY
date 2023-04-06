package com.fpt.poly.selling_assignment_ph191690.service;

import com.fpt.poly.selling_assignment_ph191690.response.ChiTietSanPhamResponse;

import java.util.List;

public interface ChiTietSanPhamService {

    List<ChiTietSanPhamResponse> getAll();

    ChiTietSanPhamResponse getOne(String id);

}
