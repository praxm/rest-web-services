package com.praxy.restwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "USER_DETAILS")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Size(min = 2, message = "Minimum side should of 2 character")
    private String name;

    @Past(message = "Only Past dates are allowed")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @ToString.Exclude
    private List<Post> posts;

    //@Size and @Past are library coming as part of Spring-boot-validation dependency (Jakarta validation). To validate Input. Use @Valid annotation.
}
