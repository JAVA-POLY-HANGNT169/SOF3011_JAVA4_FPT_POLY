package com.poly.hangnt169.service.impl;

import com.poly.hangnt169.entity.SinhVien;
import com.poly.hangnt169.repository.SinhVienRepository;
import com.poly.hangnt169.request.SinhVienRequest;
import com.poly.hangnt169.response.SinhVienResponse;
import com.poly.hangnt169.service.SinhVienService;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author hangnt169
 */
public class SinhVienServiceImpl implements SinhVienService {

    private SinhVienRepository sinhVienRepository = new SinhVienRepository();

    @Override
    public List<SinhVienResponse> hienThiSinhVien() {
        return null;
    }

    @Override
    public SinhVienResponse detailSinhVien(UUID id) {
        return null;
    }

    @Override
    public void removeSinhVien(UUID id) {
        SinhVien sv = sinhVienRepository.findByID(id);
        sinhVienRepository.delete(sv);
    }

    /**
     * Add hoặc Update đối tượng Sinh Viên
     *
     * @param request: Các giá trị lấy từ ô input của 1 đối tượng Sinh Viên bên view
     * @return list lỗi => Nếu không thoả mãn validate => List lỗi có size >0 và ngược lại
     */
    @Override
    public HashMap<String, String> addOrUpdateSinhVien(SinhVienRequest request) {
        HashMap<String, String> lists = new HashMap<>();
        // Check validate
        if (StringUtils.isEmpty(request.getMa())) {
            lists.put("MSSV_EMPTY", "MSSV không được để trống");
        }
        if (StringUtils.isEmpty(request.getTen())) {
            lists.put("TEN_EMPTY", "Tên SV không được để trống");
        }
        if (StringUtils.isEmpty(request.getEmail())) {
            lists.put("EMAIL_EMPTY", "Email không được để trống");
        }

        // Thoả mãn validate
        if (lists.isEmpty()) {
//            SinhVien sinhVien = new SinhVien();
//            sinhVien.setId(request.getId());
//            sinhVien.setMaSV(request.getMa());
//            sinhVien.setTen(request.getTen());
////            sinhVien.setGioiTinh(request.isGioiTinh());
//            sinhVien.setEmail(request.getEmail());
//            Lop lop = lopRepository.findByID(request.getLopID());
//            ChuyenNganh chuyenNganh = chuyenNganhRepository.findByID(request.getChuyenNganhID());
//            sinhVien.setLop(lop);
//            sinhVien.setChuyenNganh(chuyenNganh);
//            sinhVienRepository.addOrUpdateSinhVien(sinhVien);
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new SinhVienServiceImpl().hienThiSinhVien());
    }
}
