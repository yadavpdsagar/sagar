package com.WorkShop.sagar.models.collage;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "jpa_table" )
public class Student {
    @Id
    @GeneratedValue
    private  Integer id;
    private String StudentName;
    private String about;

    @OneToOne(mappedBy = "student",  cascade = CascadeType.ALL)
    private  Laptop laptop;

}
