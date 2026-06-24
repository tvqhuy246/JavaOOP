package com.fe.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.fe.pojo.Student;

public class StudentDAO {

    private static EntityManager em;
    private static EntityManagerFactory emf;

    public StudentDAO(String persistanceName) {
        emf = Persistence.createEntityManagerFactory(persistanceName);
    }

    public void save(Student student) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error in save: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Student findById(int studentID) {
        Student student = null;
        try {
            em = emf.createEntityManager();
            // Đọc dữ liệu (find) KHÔNG cần mở transaction (begin)
            student = em.find(Student.class, studentID);
        } catch (Exception ex) {
            System.out.println("Error in findById: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return student;
    }

    @SuppressWarnings("unchecked")
    public List<Student> getStudents() {
        List<Student> students = null;
        try {
            em = emf.createEntityManager();
            // Đọc dữ liệu (createQuery) KHÔNG cần mở transaction (begin)
            students = em.createQuery("from Student").getResultList();
        } catch (Exception ex) {
            System.out.println("Error in getStudents: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return students;
    }

    public void delete(int studentID) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Student s = em.find(Student.class, studentID);
            if (s != null) {
                em.remove(s);
                em.getTransaction().commit();
            } else {
                System.out.println("Student with ID " + studentID + " not found for deletion.");
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            }
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error in delete: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(Student student) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Student s = em.find(Student.class, student.getId());
            if (s != null) {
                s.setFirstName(student.getFirstName());
                s.setLastName(student.getLastName());
                s.setMarks(student.getMarks());
                em.getTransaction().commit();
            } else {
                System.out.println("Student with ID " + student.getId() + " not found for update.");
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            }
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error in update: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
