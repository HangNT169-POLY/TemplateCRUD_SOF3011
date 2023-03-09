package com.poly.template.repository;

import com.poly.template.entity.DongVat;
import com.poly.template.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hangnt169
 */
public class DongVatRepository {

    public List<DongVat> getAll() {
        List<DongVat> dongVats = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM DongVat", DongVat.class);
            dongVats = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return dongVats;
    }

    public DongVat getOne(Long id) {
        DongVat dongVat = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM DongVat WHERE id=:id", DongVat.class);
            query.setParameter("id", id);
            dongVat = (DongVat) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return dongVat;
    }

    public Boolean add(DongVat dongVat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(dongVat);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(DongVat dongVat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(dongVat);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean delete(DongVat dongVat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(dongVat);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new DongVatRepository().getOne(0L).toString());
    }
}
