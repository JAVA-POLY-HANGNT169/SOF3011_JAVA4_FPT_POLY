package com.fpt.poly.selling_assignment_ph191690.repository;

import com.fpt.poly.selling_assignment_ph191690.entity.HoaDon;
import com.fpt.poly.selling_assignment_ph191690.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class HoaDonRepository {
    public List<HoaDon> getAll() {
        List<HoaDon> hoaDonList = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("SELECT hd FROM HoaDon hd", HoaDon.class);
            hoaDonList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDonList;
    }

    public HoaDon getOne(String id) {
        String sql = "SELECT hd FROM HoaDon hd WHERE hd.id = ?1";
        HoaDon hoaDon = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(sql, HoaDon.class);
            query.setParameter(1, id);
            hoaDon = (HoaDon) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDon;

    }

}
