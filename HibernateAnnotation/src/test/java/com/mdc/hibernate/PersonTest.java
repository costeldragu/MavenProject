package com.mdc.hibernate;

import com.mdc.hibernate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PersonTest {

    SessionFactory factory;

    @BeforeClass
    public void setup() {
        factory = HibernateUtilities.getSessionFactory();
    }

    @Test
    public void testSavePerson() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Person person = new Person();
        person.setName("J. C. Smell");
        session.save(person);
        tx.commit();
        session.close();
    }

    @Test
    public void findPerson() {
        Session session = factory.openSession();
        //The Person is the mapped
        Query<Person> query = session.createQuery("from Person p where p.name=:name", Person.class);
        query.setParameter("name","J. C. Smell");
        Person person = query.uniqueResult();
        System.out.println(person);
    }

}
