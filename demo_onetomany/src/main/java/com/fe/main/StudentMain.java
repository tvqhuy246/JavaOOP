package com.fe.main;

import com.fe.service.IStudentService;
import com.fe.service.StudentService;
import com.fe.pojo.Student;
import java.util.Scanner;

public class StudentMain {

    public static void main(String[] args) {
        System.out.println("+++++++++MENU+++++++++");
        System.out.println("+ 1. Add Student     +");
        System.out.println("+ 2. Delete Student  +");
        System.out.println("+ 3. Update Student  +");
        System.out.println("+ 4. Get a Student   +");
        System.out.println("+ 0. QUIT            +");
        System.out.println("+++++++++END++++++++++");

        int inputKey = -1;
        while (inputKey != 0) {
            Scanner console = new Scanner(System.in);
            System.out.println("Please enter a number !");
            inputKey = console.nextInt();

            IStudentService studentService = new StudentService("JPAs");
            Student student = new Student("Huy", "Tran", 9);

            switch (inputKey) {
                case 0:
                    break;
                case 1:
                    com.fe.pojo.Book b1 = new com.fe.pojo.Book("Catalin Tudose", "9781617299186",
                            "Java Persistence with Spring");
                    student.addBook(b1);
                    studentService.save(student);
                    break;
                case 2:
                    studentService.delete(1);
                    break;
                case 3:
                    student = new Student(1, "Luyen", "Huynh", 9);
                    studentService.update(student);
                    break;
                case 4:
                    studentService.findById(1);
                    break;
                default:
                    System.out.println("Please choice menu !");
            }
        }
    }
}
