package com.mdc.hibernate;

import com.mdc.hibernate.model.User;
import com.mdc.hibernate.model.UserHistory;
import com.mdc.hibernate.model.UserMail;
import com.mdc.hibernate.model.UserPhone;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Session;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
        //We need to add this as system property .. WTF ?
        System.setProperty("hibernate.dialect.storage_engine", "innodb");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testHibernateConnection() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.close();
    }

    /**
     * User test methods
     */
    public void testTruncateUserTable() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();
        session.createNativeQuery("TRUNCATE TABLE `users`").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void testCreateUser() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        User testUser = new User();
        testUser.setName("Costel");
        testUser.getProteinData().setTotal(97);
        testUser.getProteinData().setGoal(70);
        session.beginTransaction();
        session.save(testUser);
        session.getTransaction().commit();
        session.close();
    }

    public void testLoadUser() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();
        User testUser = (User) session.load(User.class,1);
        System.out.println(testUser);
        session.getTransaction().commit();
        session.close();
    }

    public void testCreateUserWithHistory() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        User testUser = new User();
        testUser.setName("Costel");
        testUser.getProteinData().setTotal(97);
        testUser.getProteinData().setGoal(70);
        testUser.getHistory().add(new UserHistory(new Date(),"Test 1"));
        testUser.getHistory().add(new UserHistory(new Date(),"Test 2"));
        testUser.getHistory().add(new UserHistory(new Date(),"Test 3"));
        testUser.getHistory().add(new UserHistory(new Date(),"Test 4"));
        session.beginTransaction();
        session.save(testUser);
        session.getTransaction().commit();
        session.close();
    }

    public void testCreateUserWithHistoryAndUserMail() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        User testUser = new User();
        testUser.setName("Costel");
        testUser.getProteinData().setTotal(97);
        testUser.getProteinData().setGoal(70);
        testUser.getHistory().add(new UserHistory(new Date(),"Test 2"));
        testUser.getHistory().add(new UserHistory(new Date(),"Test 3"));
        testUser.getHistory().add(new UserHistory(new Date(),"Test 4"));
        testUser.getHistory().add(new UserHistory(new Date(),"Test 5"));
        testUser.getUserMailList().add(new UserMail("email 1"));
        testUser.getUserMailList().add(new UserMail("email 2"));
        testUser.getUserMailList().add(new UserMail("email 3"));
        testUser.getUserMailList().add(new UserMail("email 4"));
        testUser.getUserMailList().add(new UserMail("email 5"));
        session.beginTransaction();
        session.save(testUser);
        session.getTransaction().commit();
        session.close();
    }

    public void testCreateUserWithHistoryAndUserMailAndPhone() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        User testUser = new User();
        testUser.setName("Costel");
        testUser.getProteinData().setTotal(97);
        testUser.getProteinData().setGoal(70);
        testUser.getHistory().add(new UserHistory(new Date(),"Test 12"));
        testUser.getHistory().add(new UserHistory(new Date(),"Test 13"));
        testUser.getHistory().add(new UserHistory(new Date(),"Test 14"));
        testUser.getHistory().add(new UserHistory(new Date(),"Test 15"));
        testUser.getUserMailList().add(new UserMail("email 21"));
        testUser.getUserMailList().add(new UserMail("email 32"));
        testUser.getUserMailList().add(new UserMail("email 43"));
        testUser.getUserMailList().add(new UserMail("email 54"));
        testUser.getUserMailList().add(new UserMail("email 65"));
        testUser.getUserPhoneMap().put("home",new UserPhone(1233456));
        testUser.getUserPhoneMap().put("work",new UserPhone(1334556));
        testUser.getUserPhoneMap().put("work2",new UserPhone(1234556));
        session.beginTransaction();
        session.save(testUser);
        session.getTransaction().commit();
        session.close();
    }
}
