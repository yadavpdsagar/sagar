package com.WorkShop.sagar.models.collage;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="jpa_laptops")
public class Laptop {
    @Id
    @GeneratedValue
    private Integer laptopId;
    private  String modelNumber;
    private String brand;

    @OneToOne
    private Student student;
}
