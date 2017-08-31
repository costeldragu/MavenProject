package com.mdc.hibernate;

import com.mdc.hibernate.model.User;
import com.mdc.hibernate.model.UserHistory;
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

    }
}
