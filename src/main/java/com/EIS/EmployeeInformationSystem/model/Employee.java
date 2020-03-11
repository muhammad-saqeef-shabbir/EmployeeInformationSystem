package com.EIS.EmployeeInformationSystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.ebean.config.JsonConfig;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
//@Table(name="Employee")
public class Employee extends BaseModel {
    /*@Id
    UUID id;
    String name;
    String cnic;
    int age;
    Date dob;
    String role;*/

    @Id
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String cnic;
    @NotBlank
    private int age;
    @NotBlank
//    @Temporal(TemporalType.DATE)
//    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;
    @NotBlank
    private String role;
//    @JsonProperty("id") UUID id, @JsonProperty("name") @NotBlank String name, @JsonProperty("role") @NotBlank String role, @JsonProperty("cnic") @NotBlank String cnic, @JsonProperty("age") @NotBlank int age, @JsonProperty("dob") @NotBlank Date dob
    public Employee(@JsonProperty("id") UUID id, @JsonProperty("name") @NotBlank String name, @JsonProperty("role") @NotBlank String role, @JsonProperty("cnic") @NotBlank String cnic, @JsonProperty("age") @NotBlank int age, @JsonProperty("dob") @NotBlank Date dob) {
        super();

        this.id = id;
        this.name = name;
        this.role = role;
        this.cnic = cnic;
        this.age = age;
        this.dob = dob;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getCnic() {
        return cnic;
    }

    public int getAge() {
        return age;
    }

    public Date getDob() {
        return dob;
    }
}
