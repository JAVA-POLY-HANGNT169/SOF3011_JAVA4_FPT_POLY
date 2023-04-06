package com.fpt.poly.lab.repository;

import com.fpt.poly.lab.entity.SinhVien;
import com.fpt.poly.lab.response.SinhVienResponse;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class SinhVienRepository {

    public List<SinhVien> getAll() {
        List<SinhVien> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT sv FROM SinhVien sv JOIN FETCH sv.giangVien";
//            String hql = "SELECT e FROM SinhVien e";
            Query query = session.createQuery(hql, SinhVien.class);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
//        Session session = HibernateUtil.getFACTORY().openSession();
//        Query query = session.createQuery("FROM SinhVien ", SinhVien.class);
//        List<SinhVien> products = query.getResultList();
//        return products == null ? new ArrayList<>() : products;
    }

    public List<SinhVienResponse> getAll1() {
        List<SinhVienResponse> responses = new ArrayList<>();
        String sql = "SELECT new com.fpt.poly.lab.response.SinhVienResponse "
                + " ( sv.ma ,sv.ten, sv.tuoi,sv.diaChi,sv.gioiTinh,sv.giangVien.ten )"
                + " FROM SinhVien sv JOIN GiangVien gv "
                + " ON  sv.giangVien.ma = gv.ma ";
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(sql);
            responses = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return responses;
    }
}
