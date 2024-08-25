package com.WorkShop.sagar.models;

 import java.time.LocalDate;
 import java.util.List;

 import jakarta.persistence.*;
 import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
    @Entity
    @Data
    public class Employee {
        @Id
        private String id;
        @Column(
                name="emp_identifier",
                nullable = false,
                unique = true
        )
        private  String Identifier;
        @Column( nullable = false)

        private String firstname;
    @Column( nullable = false)
        private String lastname;
    @Column( nullable = false, unique = true)
        private String email;
    @Column( updatable = false)
        private LocalDate birthdate;
     @Enumerated(EnumType.STRING  )
     @Column(nullable = false)
        private EmployeeRole role;

     @OneToOne
    @JoinColumn(name="address_id")
    private Address address;
     @ManyToOne
     @JoinColumn(name="department_id")
     private  Department department;
     @ManyToMany
     @JoinTable(
             name ="employee_mission",
             joinColumns = @JoinColumn(name="employee_id"),
             inverseJoinColumns = @JoinColumn(name="mission_id")
     )
     private List<Mission> missionList;
    }

