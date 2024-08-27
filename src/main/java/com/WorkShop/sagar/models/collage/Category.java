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
@Table(name ="Jpa_category")
public class Category {
    @Id

    private  String  CId;

    private String title;

    @ManyToMany(cascade =  CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();


}
