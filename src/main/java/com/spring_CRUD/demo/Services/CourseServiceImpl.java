package com.spring_CRUD.demo.Services;

import com.spring_CRUD.demo.Entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService{
    List<Course> list;

    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course(13, "Java Core course", "This course covers basics of Java"));
        list.add(new Course(64, "Spring Boot course", "Creating CRUD rest api using Spring boot"));

    }


    @Override
    public List<Course> getCourses(){
        return list;
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
        return course;
    }
}
