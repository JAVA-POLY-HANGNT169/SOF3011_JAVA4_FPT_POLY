package com.fpt.poly.selling_assignment_ph191690.repository;

import com.fpt.poly.selling_assignment_ph191690.entity.ChiTietSanPham;
import com.fpt.poly.selling_assignment_ph191690.entity.HoaDon;
import com.fpt.poly.selling_assignment_ph191690.entity.HoaDonChiTiet;
import com.fpt.poly.selling_assignment_ph191690.entity.HoaDonChiTietID;
import com.fpt.poly.selling_assignment_ph191690.response.CartResponse;
import com.fpt.poly.selling_assignment_ph191690.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTietRepository {

    public List<HoaDonChiTiet> getAll() {
        List<HoaDonChiTiet> hoaDonChiTiets = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("SELECT hd FROM HoaDonChiTiet hd", HoaDonChiTiet.class);
            hoaDonChiTiets = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDonChiTiets;
    }

    public boolean addListHoaDonChiTiet(List<CartResponse> carts, HoaDon hoaDon) {
        Transaction transaction = null;
        int batchSize = 50;
        int size = carts.size();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            for (int i = 0; i < size; i++) {
                CartResponse cart = carts.get(i);
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                // Hoa don chi tiet ID
                HoaDonChiTietID hoaDonChiTietID = new HoaDonChiTietID();
                hoaDonChiTietID.setHoaDon(hoaDon);
                hoaDonChiTietID.setChiTietSanPham(cart.getChiTietSanPham());
                hoaDonChiTiet.setHoaDonChiTietID(hoaDonChiTietID);
                // So luong
                hoaDonChiTiet.setSoLuong(cart.getSoLuong());
                // don gia
                hoaDonChiTiet.setDonGia(cart.totalMount());
                session.persist(hoaDonChiTiet);
                if (i % batchSize == 0 && i > 0) {
                    session.flush();
                    session.clear();
                }
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction == null) {
                transaction.commit();
            }
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        new HoaDonChiTietRepository().getAll().forEach(s -> System.out.println(s));
        List<CartResponse> carts = new ArrayList<>();
        CartResponse cart = new CartResponse();
        ChiTietSanPham chiTietSanPham = new ChiTietSanPhamRepository().getOne("65ED8D2D-1623-446C-BF34-2C99FA6774FB");
        cart.setChiTietSanPham(chiTietSanPham);
        cart.setGiaBan(chiTietSanPham.getGiaBan());
        cart.setSoLuong(2L);
        carts.add(cart);

        CartResponse cart1 = new CartResponse();
        ChiTietSanPham chiTietSanPham1 = new ChiTietSanPhamRepository().getOne("10D96F64-5CAB-4534-9659-3C91038B0D5D");
        cart1.setChiTietSanPham(chiTietSanPham1);
        cart1.setGiaBan(chiTietSanPham1.getGiaBan());
        cart1.setSoLuong(3L);
        carts.add(cart1);

        HoaDon hoaDon = new HoaDonRepository().getOne("F9164ED3-F351-40CA-BEDF-F5E2797117DF");
        System.out.println(new HoaDonChiTietRepository().addListHoaDonChiTiet(carts, hoaDon));
    }

}
