package com.WorkShop.sagar;

import com.WorkShop.sagar.models.collage.Laptop;
import com.WorkShop.sagar.models.collage.Student;
import com.WorkShop.sagar.repo.StudentRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SagarApplication implements CommandLineRunner {

	@Autowired
	private StudentRepo studentRepo;

Logger logger = LogManager.getLogger(SagarApplication.class);;
	public static void main(String[] args) {
		SpringApplication.run(SagarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



//		Student student = new Student();
//		student.setStudentName("sagar test yadav");
//		student.setAbout("thshisdemoest");
//
//		Laptop laptop =new Laptop();
//		laptop.setModelNumber("12544Werew");
//		laptop.setBrand("dell");
//
//		//setting student inside laptop
//		laptop.setStudent(student);
//		//setting lapop inside student
//		student.setLaptop(laptop);
//
//
//
//		Student savedStudent = studentRepo.save(student);
//		System.out.println("Student saved: " + savedStudent);


//		Student student=  studentRepo.findById(1).get();
//		logger.info("name is {}" , student.getStudentName());
//
//		Laptop laptop = student.getLaptop();
//		logger.info("laptop{},{}" , laptop.getBrand(), laptop.getModelNumber() );

		Student student = studentRepo.findById(1).orElse(null);

		if (student != null) {
			logger.info("Name is: {}", student.getStudentName());

			Laptop laptop = student.getLaptop();
			if (laptop != null) {
				logger.info("Laptop brand: {}, Model number: {}", laptop.getBrand(), laptop.getModelNumber());
			} else {
				logger.warn("No laptop associated with this student.");
			}
		} else {
			logger.warn("Student with ID 1 not found.");
		}
	}
}