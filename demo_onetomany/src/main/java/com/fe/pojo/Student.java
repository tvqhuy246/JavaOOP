package com.fe.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDENTS")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "fistName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "marks")
    private int marks;

    // Một Sinh viên có nhiều Sách (1-N)
    // Bảng Book làm chủ mối quan hệ (vì có khóa ngoại)
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public Student() {
    }

    public Student(String firstName, String lastName, int marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = marks;
    }

    public Student(int id, String firstName, String lastName, int marks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = marks;
    }

    // Helper method đồng bộ 2 chiều
    public void addBook(Book book) {
        this.books.add(book);
        book.setStudent(this); // Set ngược lại cho sách biết chủ là ai
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }
    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}
