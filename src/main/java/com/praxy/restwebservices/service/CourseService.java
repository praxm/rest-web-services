package com.praxy.restwebservices.service;

import com.praxy.restwebservices.model.Course;
import com.praxy.restwebservices.repo.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private CourseRepository courseRepository;
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public void createCourse(Course course) {
        courseRepository.save(course);
    }
}
