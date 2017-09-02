package com.mdc.hibernate;

import com.mdc.hibernate.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


public class PersistenceTest {

    SessionFactory factory;

    @BeforeSuite
    public void setup() {
        factory = HibernateUtilities.getSessionFactory();
    }

    @Test
    public void saveMessage() {
        Message message = new Message("Hello, world");
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(message);
        tx.commit();
        session.close();
    }

    @Test(dependsOnMethods = "saveMessage")
    public void readMessage() {
        Session session = factory.openSession();
        List<Message> list = session.createQuery("from Message", Message.class).list();
        assertEquals(list.size(), 1);
        for (Message m : list) {
            System.out.println(m);
        }
        session.close();

    }
}
