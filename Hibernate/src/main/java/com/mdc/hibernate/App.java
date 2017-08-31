package com.mdc.hibernate;

import org.hibernate.Session;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int[] smallPrimes = new int[] { 17, 19, 23, 29, 31, 37 };
        int[] second = smallPrimes;

        second[5] = 12;
        System.out.println(smallPrimes[5]);
        System.out.println(smallPrimes);


//        Session session = HibernateUtilities.getSessionFactory().openSession();
//        session.beginTransaction();
    }
}
