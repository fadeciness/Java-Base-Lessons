package com.github.fadeciness.lesson11.homework.service;

import com.github.fadeciness.lesson11.homework.entity.Person;
import com.github.fadeciness.lesson11.homework.entity.Product;
import com.github.fadeciness.lesson11.homework.entity.Purchase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class ShopService {

    private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Person.class)
            .addAnnotatedClass(Product.class)
            .addAnnotatedClass(Purchase.class)
            .buildSessionFactory();

    public static List<Purchase> showProductsByPerson(String personName) {
        Session session = null;
        List<Purchase> products = Collections.emptyList();
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            products = session.createQuery("FROM Purchase pu WHERE pu.person.name = :name")
                    .setParameter("name", personName)
                    .getResultList();
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;
    }

    public static List<Person> findPersonsByProductTitle(String productName) {
        Session session = null;
        List<Person> persons = Collections.emptyList();
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            persons = session.createQuery("FROM Purchase pu WHERE pu.product.name = :name")
                    .setParameter("name", productName)
                    .getResultList();
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return persons;
    }

    public static void buy(String personName, String productName) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Person person = (Person) session.createQuery("FROM Person pe WHERE pe.name = :name")
                    .setParameter("name", personName)
                    .getSingleResult();
            Product product = (Product) session.createQuery("FROM Product pr WHERE pr.name = :name")
                    .setParameter("name", productName)
                    .getSingleResult();

            Purchase purchase = new Purchase();
            purchase.setPurchased(LocalDateTime.now());
            purchase.setProduct(product);
            purchase.setPerson(person);
            purchase.setPrice(product.getPrice());
            session.persist(purchase);

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void removePerson(String personName) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Person person = (Person) session.createQuery("FROM Person pe WHERE pe.name = :name")
                    .setParameter("name", personName)
                    .getSingleResult();
            session.remove(person);

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void removeProduct(String productName) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Product product = (Product) session.createQuery("FROM Product pr WHERE pr.name = :name")
                    .setParameter("name", productName)
                    .getSingleResult();
            session.remove(product);

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // Одна из целей использования hibernate - вынести логику из БД/запросов на уровень java-кода
    // данную задачу можно было бы решить через java-объекты
    public static Double avgPrice(String personName, String productName) {
        Double avgPrice = null;
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            avgPrice = (Double) session.createQuery("SELECT avg(pu.price) FROM Purchase pu WHERE pu.person.name = :personName AND pu.product.name = :productName")
                    .setParameter("personName", personName)
                    .setParameter("productName", productName)
                    .getSingleResult();

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return avgPrice;
    }

    public static void terminate() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

}
