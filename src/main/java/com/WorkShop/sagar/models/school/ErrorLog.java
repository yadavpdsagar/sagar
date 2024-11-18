package com.WorkShop.sagar.models.school;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ErrorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String errorMessage;
    private String stackTrace;
    private LocalDateTime timestamp;
    private String endpoint;

    public ErrorLog(String errorMessage, String stackTrace, LocalDateTime timestamp, String endpoint) {
        this.errorMessage = errorMessage;
        this.stackTrace = stackTrace;
        this.timestamp = timestamp;
        this.endpoint = endpoint;
    }
}
