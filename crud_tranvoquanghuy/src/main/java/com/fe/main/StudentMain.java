package com.fe.main;

import com.fe.dao.StudentDAO;
import com.fe.pojo.Student;
import com.fe.pojo.Book;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) {
        // Tên persistence-unit được khai báo trong file persistence.xml là "JPAs"
        StudentDAO dao = new StudentDAO("JPAs");

        System.out.println("=== 1. TEST CREATE (THÊM MỚI) ===");
        Student student = new Student("Tran", "Quang Huy", 10);
        
        Book book1 = new Book("Lập trình Java Cơ Bản");
        Book book2 = new Book("Bí kíp Hibernate");
        
        student.addBook(book1);
        student.addBook(book2);
        
        dao.save(student);
        System.out.println("Thêm thành công Sinh viên và Sách!");

        System.out.println("\n=== 2. TEST READ ALL (LẤY DANH SÁCH) ===");
        List<Student> list = dao.getStudents();
        int firstStudentId = -1;
        if (list != null && !list.isEmpty()) {
            for (Student s : list) {
                System.out.println("ID: " + s.getId() + " - Name: " + s.getFirstName() + " " + s.getLastName()
                        + " - Marks: " + s.getMarks());
                if (firstStudentId == -1) firstStudentId = s.getId(); // Lưu lại ID đầu tiên để test Update/Delete
            }
        }

        // Nếu có sinh viên trong Database thì mới test Update và Delete được
        if (firstStudentId != -1) {
            System.out.println("\n=== 3. TEST UPDATE (SỬA SINH VIÊN) ===");
            Student studentToUpdate = dao.findById(firstStudentId);
            System.out.println("Trước khi sửa: Tên = " + studentToUpdate.getFirstName() + ", Điểm = " + studentToUpdate.getMarks());
            
            // Thay đổi thông tin
            studentToUpdate.setFirstName("Huy Đẹp Trai");
            studentToUpdate.setMarks(100);
            dao.update(studentToUpdate); // Gọi hàm update trong DAO
            
            Student afterUpdate = dao.findById(firstStudentId);
            System.out.println("Sau khi sửa: Tên = " + afterUpdate.getFirstName() + ", Điểm = " + afterUpdate.getMarks());

            System.out.println("\n=== 4. TEST DELETE (XÓA SINH VIÊN) ===");
            dao.delete(firstStudentId); // Gọi hàm delete trong DAO
            System.out.println("Đã xóa thành công sinh viên có ID = " + firstStudentId);
            
            System.out.println("\nKiểm tra lại danh sách sau khi xóa:");
            List<Student> listAfterDelete = dao.getStudents();
            if (listAfterDelete != null && !listAfterDelete.isEmpty()) {
                for (Student s : listAfterDelete) {
                    System.out.println("ID: " + s.getId() + " - Name: " + s.getFirstName());
                }
            } else {
                System.out.println("Danh sách trống trơn! Đã xóa sạch.");
            }
        }
    }
}
