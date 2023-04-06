package com.poly.hangnt169.repository;

import com.poly.hangnt169.entity.Lop;
import com.poly.hangnt169.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author hangnt169
 */
public class LopRepository {

    private SessionFactory sessionFactory;

    private String fromTable = " FROM Lop ";

    public LopRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Lop> getAll() {
        Query query = sessionFactory.openSession().createQuery(fromTable, Lop.class);
        List<Lop> categorys = query.getResultList();
        return categorys == null ? new ArrayList<>() : categorys;
    }

    public Lop getOne(UUID id) {
        String sql = fromTable + " WHERE id = :id";
        Query query = sessionFactory.openSession().createQuery(sql, Lop.class);
        query.setParameter("id", id);
        Lop category = (Lop) query.getSingleResult();
        return category == null ? null : category;
    }

    public Boolean add(Lop category) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(category);
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

    public Boolean update(Lop category) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(category);
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

    public Boolean delete(Lop category) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(category);
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
        System.out.println(new LopRepository().getAll());
    }
}
