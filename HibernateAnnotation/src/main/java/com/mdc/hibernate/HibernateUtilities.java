package com.mdc.hibernate;

import com.mdc.hibernate.model.Email;
import com.mdc.hibernate.model.Message;
import com.mdc.hibernate.model.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;

import static java.util.logging.Logger.getGlobal;

/**
 * Setup the hibernate
 */
public class HibernateUtilities {
    private static SessionFactory sessionFactory;
    private static Session session;
    private final static Logger LOGGER = Logger.getLogger(HibernateUtilities.class.getName());

    static {
        try {
            System.setProperty("hibernate.dialect.storage_engine", "innodb");
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Person.class);
            configuration.addAnnotatedClass(Email.class);
            configuration.addAnnotatedClass(Message.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException exception) {
            getGlobal().severe("Problem creating session factory");
            getGlobal().severe(exception.getMessage());
            exception.printStackTrace();

        }
    }

    static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    static Session getSession() {
        session = sessionFactory.openSession();
        return session;
    }

    static void close() {
        session.close();
    }


}
