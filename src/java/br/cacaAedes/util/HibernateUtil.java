/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cacaAedes.util;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author André
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory; 
    private static final ThreadLocal sessionThread = new ThreadLocal();  
    private static final ThreadLocal transactionThread = new ThreadLocal(); 
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession() {  
        Session session = (Session) sessionThread.get();  
        if ((session == null) || (!(session.isOpen()))) {  
            session = sessionFactory.openSession();  
            sessionThread.set(session);  
        }  
        return ((Session) sessionThread.get());  
    }  
  
    public static void closeSession() {  
        Session session = (Session) sessionThread.get();  
        if ((session != null) && (session.isOpen())) {  
            sessionThread.set(null);  
            session.close();  
        }  
    }  
  
    public static void beginTransaction() {  
        Transaction transaction = getSession().beginTransaction();  
        transactionThread.set(transaction);  
    }  
  
    public static void commitTransaction() {  
        Transaction transaction = (Transaction) transactionThread.get();  
        if ((transaction != null) && (!(transaction.wasCommitted())) && (!(transaction.wasRolledBack()))) {  
            transaction.commit();  
            transactionThread.set(null);  
        }  
    }  
  
    public static void rollbackTransaction() {  
        Transaction transaction = (Transaction) transactionThread.get();  
        if ((transaction != null) && (!(transaction.wasCommitted())) && (!(transaction.wasRolledBack()))) {  
            transaction.rollback();  
            transactionThread.set(null);  
        }  
    } 
}
