package com.praxy.restwebservices.repo;

import com.praxy.restwebservices.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
