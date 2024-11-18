package com.WorkShop.sagar.repo.schoolRepo;

import com.WorkShop.sagar.models.school.StudentScho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentScho, Long> {
}
