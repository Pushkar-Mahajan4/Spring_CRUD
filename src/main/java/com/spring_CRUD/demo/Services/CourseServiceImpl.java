package com.spring_CRUD.demo.Services;

import com.spring_CRUD.demo.Entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
//        Course searchCourse = null;
//        TypedQuery<Course> theQuery = entityManager.createQuery("FROM Course", Course.class);
//        List<Course> resultList = theQuery.getResultList();
//        for(Course course: resultList){
//            if(course.getID() == courseID){
//                searchCourse = course;
//                break;
//            }
//        }
        Course searchCourse = entityManager.find(Course.class, courseID);
        return searchCourse;
    }

    @Override
    @Transactional
    public Course addCourse(Course course){
        entityManager.merge(course);
        return course;
    }

    @Override
    @Transactional
    public List updateCourse(Course course){
        TypedQuery<Course> theQuery = entityManager.createQuery("FROM Course", Course.class);
        List<Course> searchList = theQuery.getResultList();
        for(Course searchCourse: searchList){
            if(searchCourse.getID() == course.getID()){
                searchCourse.setTitle(course.getTitle());
                searchCourse.setDescription(course.getDescription());
                entityManager.merge(searchCourse);
                break;
            }
        }
        return searchList;
    }

    @Override
    @Transactional
    public List deleteCourse(long courseID){
        Course course = entityManager.find(Course.class, courseID);
        entityManager.remove(course);
        TypedQuery<Course> theQuery = entityManager.createQuery("FROM Course", Course.class);
        List<Course> list = theQuery.getResultList();
        return list;
    }
}
