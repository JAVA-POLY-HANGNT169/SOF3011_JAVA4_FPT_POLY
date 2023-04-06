package com.poly.hangnt169.repository;

import com.poly.hangnt169.entity.ChuyenNganh;
import com.poly.hangnt169.response.ChuyenNganhResponse;
import com.poly.hangnt169.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author hangnt169
 */
public class ChuyenNganhRepository {

    private SessionFactory sessionFactory;

    public ChuyenNganhRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<ChuyenNganhResponse> getAll() {
        String sql = "SELECT new com.poly.hangnt169.response.ChuyenNganhResponse "
                + " ( l.id ,l.tenChuyenNganh) "
                + " FROM ChuyenNganh l";
        List<ChuyenNganhResponse> chuyenNganhs = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery(sql, ChuyenNganhResponse.class);
            chuyenNganhs = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chuyenNganhs;
    }

    public ChuyenNganh findByID(UUID id) {
        ChuyenNganh chuyenNganh = null;
        try (Session session = sessionFactory.openSession()) {
            String sql = "FROM ChuyenNganh WHERE id = ?1";
            Query query = session.createQuery(sql, ChuyenNganhResponse.class);
            query.setParameter(1, id);
            chuyenNganh = (ChuyenNganh) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chuyenNganh;
    }
}
