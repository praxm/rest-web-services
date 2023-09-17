package com.praxy.restwebservices.resource;

import com.praxy.restwebservices.model.Course;
import com.praxy.restwebservices.service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {

    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @PostMapping("/courses")
    public void createCourse(@Valid @RequestBody Course course) {
        courseService.createCourse(course);
    }
}
