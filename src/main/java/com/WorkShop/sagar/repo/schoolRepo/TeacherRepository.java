package com.WorkShop.sagar.repo.schoolRepo;

import com.WorkShop.sagar.models.school.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
