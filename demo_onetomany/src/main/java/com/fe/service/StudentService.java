package com.fe.service;

import com.fe.pojo.Student;
import com.fe.repository.IStudentRepository;
import com.fe.repository.StudentRepository;
import java.util.List;

public class StudentService implements IStudentService {
    
    private IStudentRepository iStudentRepo = null;

    public StudentService(String fileName) {
        iStudentRepo = new StudentRepository(fileName);
    }

    @Override
    public void save(Student student) {
        iStudentRepo.save(student);
    }

    @Override
    public List<Student> findAll() {
        return iStudentRepo.findAll();
    }

    @Override
    public void delete(int studentID) {
        iStudentRepo.delete(studentID);
    }

    @Override
    public Student findById(int studentID) {
        return iStudentRepo.findById(studentID);
    }

    @Override
    public void update(Student student) {
        iStudentRepo.update(student);
    }
}
