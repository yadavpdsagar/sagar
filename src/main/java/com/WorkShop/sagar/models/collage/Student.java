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
@Table(name = "jpa_student" )
public class Student {
    @Id
    @GeneratedValue
    private  Integer student_id;
    private String StudentName;
    private String about;

    @OneToOne(mappedBy = "student",  cascade = CascadeType.ALL)
    private  Laptop laptop;


    //many address of one student
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<SAddress> sAddressList=new ArrayList<>();
}
