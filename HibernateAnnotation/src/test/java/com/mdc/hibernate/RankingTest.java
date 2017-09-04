package com.mdc.hibernate;

import com.mdc.hibernate.model.Person;
import com.mdc.hibernate.model.Ranking;
import com.mdc.hibernate.model.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RankingTest {

    SessionFactory factory;

    @BeforeClass
    public void setup() {
        factory = HibernateUtilities.getSessionFactory();
    }

    @Test
    public void testSaveRanking() {
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        Person subject = savePerson(session, "J. C. Smell");
        Person observer = savePerson(session, "Drew Lombardo");
       // Skill skill = saveSkill(session, "Java");
        Ranking ranking = new Ranking();
        ranking.setSubject(subject);
        ranking.setObserver(observer);
     //   ranking.setSkill(skill);
        ranking.setRanking(8);
        session.save(ranking);
        tx.commit();
    }

    private Person savePerson(Session session, String name) {
        Person person = findPerson(session, name);
        if(person==null) {
            person=new Person();
            person.setName(name);
            session.save(person);
        }
        return person;
    }

    private Person findPerson(Session session, String name) {
        Query<Person> query = session.createQuery("from Person p where p.name=:name",
                Person.class);
        query.setParameter("name", name);
        Person person = query.uniqueResult();
        return person;
    }

}
