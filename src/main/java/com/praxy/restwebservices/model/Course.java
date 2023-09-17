package com.praxy.restwebservices.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Course {
    @Id
    private int id;
    @NotNull
    private String name;
    @NotNull
    @Size(min = 2, max = 2, message = "code length is of 2 character")
    private String code;
}
