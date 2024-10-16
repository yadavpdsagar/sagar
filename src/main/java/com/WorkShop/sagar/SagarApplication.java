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


@SpringBootApplication
public class SagarApplication   {

	public static void main(String[] args) {
		SpringApplication.run(SagarApplication.class, args);
	}



}