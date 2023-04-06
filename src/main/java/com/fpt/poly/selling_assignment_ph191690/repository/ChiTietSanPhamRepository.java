package com.fpt.poly.selling_assignment_ph191690.repository;

import com.fpt.poly.selling_assignment_ph191690.entity.ChiTietSanPham;
import com.fpt.poly.selling_assignment_ph191690.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPhamRepository {

    public List<ChiTietSanPham> getAll() {
        List<ChiTietSanPham> lists = new ArrayList<>();
        String sql = "SELECT ct FROM ChiTietSanPham ct JOIN FETCH ct.sanPham " +
                "JOIN FETCH ct.nhaSanXuat JOIN FETCH ct.dongSanPham JOIN FETCH ct.mauSac ";
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(sql, ChiTietSanPham.class);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public ChiTietSanPham getOne(String id) {
        String sql = "SELECT ct FROM ChiTietSanPham ct JOIN FETCH ct.sanPham JOIN FETCH " +
                " ct.nhaSanXuat JOIN FETCH " +
                " ct.dongSanPham JOIN FETCH ct.mauSac  WHERE ct.id =: reID";
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(sql, ChiTietSanPham.class);
            query.setParameter("reID", id);
            chiTietSanPham = (ChiTietSanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chiTietSanPham;
    }

}
