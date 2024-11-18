package com.WorkShop.sagar.repo.schoolRepo;

import com.WorkShop.sagar.models.school.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
}

