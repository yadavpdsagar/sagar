package com.WorkShop.sagar.service.schoolService;

import com.WorkShop.sagar.models.school.ErrorLog;
import com.WorkShop.sagar.repo.schoolRepo.ErrorLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ErrorLogService {

    @Autowired
    private ErrorLogRepository errorLogRepository;

    public void logError(String errorMessage, String stackTrace, String endpoint) {
        ErrorLog errorLog = new ErrorLog(errorMessage, stackTrace, LocalDateTime.now(), endpoint);
        errorLogRepository.save(errorLog);
    }
}
