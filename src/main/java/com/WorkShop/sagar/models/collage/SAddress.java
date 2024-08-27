package com.WorkShop.sagar.models.collage;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="Jpa_address")
public class SAddress {
    @Id
    @GeneratedValue
    private int addressID;
    private String street;
    private String city;
    private String country;

    @ManyToOne
    @JoinColumn(name= "student_id")
    private  Student student;
}
