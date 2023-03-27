package com.spring_CRUD.demo.Services;
import com.spring_CRUD.demo.Entities.Course;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface CourseService {

    public List<Course> getCourses();

    public Course getCourse(long courseID);

    public Course addCourse(Course course);
}
