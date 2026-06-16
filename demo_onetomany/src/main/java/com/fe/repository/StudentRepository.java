package com.fe.repository;

import com.fe.pojo.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private static EntityManager em;
    private static EntityManagerFactory emf;

    public StudentRepository(String persistanceName) {
        emf = Persistence.createEntityManagerFactory(persistanceName);
    }

    @Override
    public void save(Student student) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Error " + ex.getMessage());
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public Student findById(int studentID) {
        Student student = null;
        try {
            em = emf.createEntityManager();
            student = em.find(Student.class, studentID);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            if (em != null) em.close();
        }
        return student;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> findAll() {
        List<Student> students = null;
        try {
            em = emf.createEntityManager();
            students = em.createQuery("from Student").getResultList();
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            if (em != null) em.close();
        }
        return students;
    }

    @Override
    public void update(Student student) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Student s = em.find(Student.class, student.getId());
            if (s != null) {
                s.setFirstName(student.getFirstName());
                s.setLastName(student.getLastName());
                em.getTransaction().commit();
            }
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Error " + ex.getMessage());
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public void delete(int studentID) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Student s = em.find(Student.class, studentID);
            if (s != null) {
                em.remove(s);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Error " + ex.getMessage());
        } finally {
            if (em != null) em.close();
        }
    }
}
