package com.spring_CRUD.demo.Controller;
import com.spring_CRUD.demo.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring_CRUD.demo.Entities.Course;
import java.util.List;


@RestController
public class Controller {
    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String home(){
        return "This is home pitch";
    }

    @GetMapping("/courses")
    public List<Course> getCourse(){
        return this.courseService.getCourses();
    }

    @GetMapping("/courses/{courseID}")
    public Course getCourse(@PathVariable String courseID){
        return this.courseService.getCourse(Long.parseLong(courseID));
    }

    @PostMapping("/courses")

    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }
}
