package com.WorkShop.sagar.models.collage;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "jpa_product" )
public class Product {
    @Id
    private String pId;

    private String productName;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)

    private List<Category> categories = new ArrayList<>();


}
