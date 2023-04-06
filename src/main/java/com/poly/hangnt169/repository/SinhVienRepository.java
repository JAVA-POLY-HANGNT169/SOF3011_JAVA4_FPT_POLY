package com.poly.hangnt169.repository;

import com.poly.hangnt169.entity.SinhVien;
import com.poly.hangnt169.response.SinhVienResponse;
import com.poly.hangnt169.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author hangnt
 */
public class SinhVienRepository {

    private SessionFactory sessionFactory;

    private String fromTable ="FROM SinhVien";

    public SinhVienRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
//    public List<SinhVien> getAll() {
        List<SinhVien> lists = new ArrayList<>();
//        try (Session session = sessionFactory.openSession()) {
//            String hql = "SELECT sv FROM SinhVien sv JOIN FETCH sv.giangVien";
////            String hql = "SELECT e FROM SinhVien e";
//            Query query = session.createQuery(hql, SinhVien.class);
//            lists = query.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return lists;
//        Session session = HibernateUtil.getFACTORY().openSession();
//        Query query = session.createQuery("FROM SinhVien ", SinhVien.class);
//        List<SinhVien> products = query.getResultList();
//        return products == null ? new ArrayList<>() : products;
//    }
    public List<SinhVien> getAll() {
        Query query = sessionFactory.openSession().createQuery(fromTable, SinhVien.class);
        List<SinhVien> categorys = query.getResultList();
        return categorys == null ? new ArrayList<>() : categorys;
    }
    public List<SinhVienResponse> getAll1() {
        List<SinhVienResponse> responses = new ArrayList<>();
        String sql = "SELECT new com.poly.hangnt169.response.SinhVienResponse "
                + " ( sv.ma ,sv.ten, sv.tuoi,sv.diaChi,sv.gioiTinh,sv.giangVien.ten )"
                + " FROM SinhVien sv JOIN GiangVien gv "
                + " ON  sv.giangVien.ma = gv.ma ";
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery(sql);
            responses = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return responses;
    }

    public SinhVien findByID(UUID id) {
        SinhVien sinhVien = null;
        try (Session session = sessionFactory.openSession()) {
            String sql = fromTable + " WHERE id =:id";
            Query query = session.createQuery(sql, SinhVien.class);
            query.setParameter("id", id);
            sinhVien = (SinhVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sinhVien;
    }

    public Boolean addOrUpdateSinhVien(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(sinhVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction == null) {
                transaction.rollback();
                e.printStackTrace(System.out);
            }
        }
        return false;
    }

    public Boolean delete(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(sinhVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction == null) {
                transaction.rollback();
                e.printStackTrace(System.out);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SinhVienRepository().getAll());
    }
}
