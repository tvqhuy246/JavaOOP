package com.fe.pojo;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "author")
    private String author;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title", nullable = false)
    private String title;

    // Nhiều cuốn sách thuộc về 1 sinh viên (Khóa ngoại nằm ở bảng này)
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Book() {
    }

    public Book(String author, String isbn, String title) {
        this.author = author;
        this.isbn = isbn;
        this.title = title;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}
