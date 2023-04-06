package com.poly.hangnt169.util;

import com.poly.hangnt169.entity.ChuyenNganh;
import com.poly.hangnt169.entity.Lop;
import com.poly.hangnt169.entity.SinhVien;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            Properties properties = new Properties();
            properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
            properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=PTPM_JAVA_SQLSERVER");
            properties.put(Environment.USER, "sa");
            properties.put(Environment.PASS, "Password.1");
            properties.put(Environment.SHOW_SQL, "true");

            configuration.setProperties(properties);
            configuration.addAnnotatedClass(Lop.class);
            configuration.addAnnotatedClass(ChuyenNganh.class);
            configuration.addAnnotatedClass(SinhVien.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            SESSION_FACTORY = configuration.buildSessionFactory(builder.build());
            addShutdownHook(SESSION_FACTORY);
            return SESSION_FACTORY;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    private static void addShutdownHook(SessionFactory sessionFactory) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (sessionFactory != null && !sessionFactory.isClosed()) {
                sessionFactory.close();
            }
        }));
    }

    public static void main(String[] args) {
        System.out.println(getSessionFactory());
    }
}