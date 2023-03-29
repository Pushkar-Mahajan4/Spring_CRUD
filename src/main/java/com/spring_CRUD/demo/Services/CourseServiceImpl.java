package com.spring_CRUD.demo.Services;

import com.spring_CRUD.demo.Entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService{
    List<Course> list;
    private EntityManager entityManager;

    @Autowired
    public CourseServiceImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course(13, "Java Core course", "This course covers basics of Java"));
        list.add(new Course(64, "Spring Boot course", "Creating CRUD rest api using Spring boot"));
    }


    @Override
    public List<Course> getCourses(){
        TypedQuery<Course> theQuery = entityManager.createQuery("FROM Course", Course.class);
        return theQuery.getResultList();
    }

    @Override
    public Course getCourse(long courseID) {
        Course searchCourse = null;
        for(Course course: list){
            if(course.getID() == courseID){
                searchCourse = course;
                break;
            }
        }
        return searchCourse;
    }

    @Override
    public Course addCourse(Course course){
        list.add(course);
        entityManager.merge(course);
        return course;
    }

    @Override
    public List updateCourse(Course course){
        for(Course search: list){
            if(search.getID() == course.getID()){
                search.setTitle(course.getTitle());
                search.setDescription(course.getDescription());
                break;
            }
        }

        return list;
    }

    @Override
    public List deleteCourse(long courseID){
        for( Course course: list){
            if(course.getID() == courseID){
                list.remove(course);
            }
        }

        return list;
    }
}
