package com.fpt.poly.selling_assignment_ph191690.util;

import com.fpt.poly.selling_assignment_ph191690.entity.ChiTietSanPham;
import com.fpt.poly.selling_assignment_ph191690.entity.DongSanPham;
import com.fpt.poly.selling_assignment_ph191690.entity.HoaDon;
import com.fpt.poly.selling_assignment_ph191690.entity.HoaDonChiTiet;
import com.fpt.poly.selling_assignment_ph191690.entity.MauSac;
import com.fpt.poly.selling_assignment_ph191690.entity.NhaSanXuat;
import com.fpt.poly.selling_assignment_ph191690.entity.SanPham;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

/**
 * @author hangnt169
 */
public class HibernateUtil {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "Password.1");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(ChiTietSanPham.class);
        conf.addAnnotatedClass(DongSanPham.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(NhaSanXuat.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

}
