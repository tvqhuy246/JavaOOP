package com.fe.repository;

import com.fe.pojo.Student;
import java.util.List;

public interface IStudentRepository {
    public List<Student> findAll();
    public void save(Student student);
    public void delete(int studentID);
    public Student findById(int studentID);
    public void update(Student student);
}
