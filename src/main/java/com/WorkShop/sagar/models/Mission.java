package com.WorkShop.sagar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Mission {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private  int duration;
    @ManyToMany(mappedBy = "missionList")
    private List<Employee> employees;



}
