package com.poly.hangnt169.repository;

import com.poly.hangnt169.entity.MayTinh;
import com.poly.hangnt169.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MayTinhRepository {

    public List<MayTinh> getALl() {
        List<MayTinh> listMT = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MayTinh", MayTinh.class);
            listMT = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMT;
    }

    public MayTinh getOne(UUID ma) {
        MayTinh mayTinh = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MayTinh WHERE ma = :ma", MayTinh.class);
            query.setParameter("ma", ma);
            mayTinh = (MayTinh) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mayTinh;
    }

    public Boolean remove(MayTinh sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean add(MayTinh sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(MayTinh sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void main(String[] args) {
        MayTinh mayTinh = new MayTinhRepository().getOne(UUID.fromString("0e005cc2-c72a-461d-ad45-5919b0e50f6d"));
        System.out.println(mayTinh);
    }
}
