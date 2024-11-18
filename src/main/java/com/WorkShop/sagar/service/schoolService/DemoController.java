package com.WorkShop.sagar.service.schoolService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/triggerError")
    public String triggerError() {
        // Trigger a custom exception
        throw new CustomException("This is a custom error");
    }
}
