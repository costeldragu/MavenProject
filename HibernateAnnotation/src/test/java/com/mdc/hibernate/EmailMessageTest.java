package com.mdc.hibernate;

import com.mdc.hibernate.model.Email;
import com.mdc.hibernate.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertNull;
import static org.testng.Assert.assertNotNull;

public class EmailMessageTest {
    SessionFactory factory;

    @BeforeClass
    public void setup() {
        factory = HibernateUtilities.getSessionFactory();
    }

    @Test()
    public void testBrokenInversionCode() {
        Long emailId;
        Long messageId;
        Email email;
        Message message;
        try (Session session = HibernateUtilities.getSession()) {
            Transaction tx = session.beginTransaction();
            email = new Email("Broken");
            message = new Message("Broken");
            email.setMessage(message);
            // message.setEmail(email);
            session.save(email);
            session.save(message);
            emailId = email.getEmailId();
            messageId = message.getMessageId();
            tx.commit();
        }
        assertNotNull(email.getMessage());
        assertNull(message.getEmail());
        try (Session session = HibernateUtilities.getSession()) {
            email = session.get(Email.class, emailId);
            System.out.println(email);
            message = session.get(Message.class, messageId);
            System.out.println(message);
        }
        assertNotNull(email.getMessage());
        assertNull(message.getEmail());
    }

    @Test
    public void testProperSimpleInversionCode() {
        Long emailId;
        Long messageId;
        Email email;
        Message message;
        try (Session session = HibernateUtilities.getSession()) {
            Transaction tx = session.beginTransaction();
            email = new Email("Proper");
            message = new Message("Proper");
            email.setMessage(message);
            message.setEmail(email);
            session.save(email);
            session.save(message);
            emailId = email.getEmailId();
            messageId = message.getMessageId();
            tx.commit();
        }
        assertNotNull(email.getMessage());
        assertNotNull(message.getEmail());
        try (Session session = HibernateUtilities.getSession()) {
            email = session.get(Email.class, emailId);
            System.out.println(email);
            message = session.get(Message.class, messageId);
            System.out.println(message);
        }
        assertNotNull(email.getMessage());
        assertNotNull(message.getEmail());
    }
}
