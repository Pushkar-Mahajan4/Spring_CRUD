package com.spring_CRUD.demo.Controller;
import com.spring_CRUD.demo.Services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring_CRUD.demo.Entities.Course;
import java.util.List;


@RestController
public class Controller {
    private CourseService courseService;

    public Controller(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public String home(){
        return "This is home pitch";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }

    @GetMapping("/courses/{courseID}")
    public Course getCourse(@PathVariable String courseID){
        return courseService.getCourse(Long.parseLong(courseID));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public List updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }


    // Adding Http status code along with the response
    @DeleteMapping("/courses/{courseID}")
    public ResponseEntity<?> deleteCourse(@PathVariable String courseID){
        try{
            List list = courseService.deleteCourse(Long.parseLong(courseID));
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Galat bhejta hai Madarchod", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
