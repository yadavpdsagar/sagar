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
public class SagarApplication implements CommandLineRunner {

	@Autowired
	private StudentRepo studentRepo;

Logger logger = LogManager.getLogger(SagarApplication.class);;
	public static void main(String[] args) {
		SpringApplication.run(SagarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

 //one to many---------------------------------
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

// get data

//		Student student=  studentRepo.findById(1).get();
//		logger.info("name is {}" , student.getStudentName());
//
//		Laptop laptop = student.getLaptop();
//		logger.info("laptop{},{}" , laptop.getBrand(), laptop.getModelNumber() );

//		Student student = studentRepo.findById(1).orElse(null);
//
//		if (student != null) {
//			logger.info("Name is: {}", student.getStudentName());
//
//			Laptop laptop = student.getLaptop();
//			if (laptop != null) {
//				logger.info("Laptop brand: {}, Model number: {}", laptop.getBrand(), laptop.getModelNumber());
//			} else {
//				logger.warn("No laptop associated with this student.");
//			}
//		} else {
//			logger.warn("Student with ID 1 not found.");
//		}



//		one to many--------------------------------------------------
//		Student student= new Student();
//		student.setStudentName("ravi");
//		student.setAbout("i am programer");
//
//		SAddress a1= new SAddress();
//		a1.setStreet("235/235");
//		a1.setCity("LOK");
//		a1.setCountry("IND");
//		a1.setStudent(student);
//
//		SAddress a2= new SAddress();
//		a2.setStreet("233/233");
//		a2.setCity("LOKNATH");
//		a2.setCountry("NEP");
//		a2.setStudent(student);
//
//		List<SAddress> sAddressList= new ArrayList<>();
//		sAddressList.add(a1);
//		sAddressList.add(a2);
//
//		student.setSAddressList(sAddressList);
//
//		Student save = studentRepo.save(student);
//		logger.info("Student has been created : with address ");



		//many to many-------------------------------------------------------------

// Product product1= new Product();
// product1.setPId("Pid1");
// product1.setProductName("Iphone14");
//
//		Product product2 = new Product();
//		product2.setPId("Pid2");
//		product2.setProductName("Samung s22 ultra ");
//
//		Product product3 = new Product();
//		product3.setPId("Pid3");
//		product3.setProductName("samung tv ");
//
//		Product product4 = new Product();
//		product4.setPId("Pid4");
//		product4.setProductName("LG tv");
//
//
//		Category category1= new Category();
//		category1.setCId("Cid1");
//		category1.setTitle("eletronics");
//
//		Category category2 = new Category();
//		category2.setCId("Cid2");
//		category2.setTitle("mobile phone");
//
//
//		List<Product> category1Products =category1.getProducts();
//		category1Products.add(product1);
//		category1Products.add(product2);
//		category1Products.add(product3);
//		category1Products.add(product4);
//
//
//		List<Product> category2Products =category2.getProducts();
//		category2Products.add(product1);
//		category2Products.add(product2);
//
//
//		categoryRepo.save(category1);
//		categoryRepo.save(category2);


//		Category category1 =categoryRepo.findById("cid1").get();
//		System.out.println(category1.getProducts().size());
//
//		Category category2 =categoryRepo.findById("cid2").get();
//		System.out.println(category2.getProducts().size());

		Product product1= productRepo.findById("Pid3").get();
		System.out.println();










	}

	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ProductRepo productRepo;
}