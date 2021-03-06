package com.mdc.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.logging.Logger;
import static java.util.logging.Logger.getGlobal;

/**
 * Setup the hibernate
 */
public class HibernateUtilities {
    private static SessionFactory sessionFactory;
    private final static Logger LOGGER = Logger.getLogger(HibernateUtilities.class.getName());
    static {
        try {
            Configuration configuration = new Configuration().configure();
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
}
