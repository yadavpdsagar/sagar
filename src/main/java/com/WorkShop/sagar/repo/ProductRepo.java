package com.WorkShop.sagar.repo;

import com.WorkShop.sagar.models.collage.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product , String> {

}
