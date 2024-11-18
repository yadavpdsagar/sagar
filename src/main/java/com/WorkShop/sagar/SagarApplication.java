package com.WorkShop.sagar;

import com.WorkShop.sagar.models.collage.Category;
import com.WorkShop.sagar.models.collage.Product;
import com.WorkShop.sagar.repo.CategoryRepo;
import com.WorkShop.sagar.repo.ProductRepo;
import com.WorkShop.sagar.repo.StudentRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.WorkShop.sagar.repo")
public class SagarApplication   {

	public static void main(String[] args) {
		SpringApplication.run(SagarApplication.class, args);
	}



}