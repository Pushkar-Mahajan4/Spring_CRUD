package com.spring_CRUD.demo.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="courses")
public class Course {

    // Define the fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name="description")
    private String description;

    public Course(){

    }

    public Course(long id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getID(){
        return id;
    }

    public void setID(long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
