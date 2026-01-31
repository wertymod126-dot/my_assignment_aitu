package com.aitu.university;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long dbId; //  database primary key

    protected int id;    // Student/Prof ID
    protected String name;
    protected int age;

    public Person() {} // Empty constructor needed for Spring/JPA

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void displayInfo();

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}