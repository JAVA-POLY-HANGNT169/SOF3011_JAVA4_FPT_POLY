package com.poly.hangnt169.service;

import com.poly.hangnt169.request.SinhVienRequest;
import com.poly.hangnt169.response.SinhVienResponse;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author hangnt169
 */
public interface SinhVienService {

    List<SinhVienResponse> hienThiSinhVien();

    SinhVienResponse detailSinhVien(UUID id);

    void removeSinhVien(UUID id);

    HashMap<String, String> addOrUpdateSinhVien(SinhVienRequest request);

}
