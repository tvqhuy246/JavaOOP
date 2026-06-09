package com.fe.main;

import com.fe.dao.StudentDAO;
import com.fe.pojo.Student;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) {
        // Tên persistence-unit được khai báo trong file persistence.xml là "JPAs"
        StudentDAO dao = new StudentDAO("JPAs");

        System.out.println("=== 1. TEST THÊM STUDENT ===");
        Student student = new Student("Tran", "Quang Huy", 10);
        dao.save(student);
        System.out.println("Thêm thành công!");

        System.out.println("\n=== 2. TEST LẤY DANH SÁCH STUDENT ===");
        List<Student> list = dao.getStudents();
        if (list != null) {
            for (Student s : list) {
                System.out.println("ID: " + s.getId() + " - Name: " + s.getFirstName() + " " + s.getLastName()
                        + " - Marks: " + s.getMarks());
            }
        }
    }
}
