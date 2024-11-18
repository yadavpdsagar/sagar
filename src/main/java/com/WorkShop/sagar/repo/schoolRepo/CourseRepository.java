package com.WorkShop.sagar.repo.schoolRepo;

import com.WorkShop.sagar.models.school.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
