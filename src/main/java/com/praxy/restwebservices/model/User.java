package com.praxy.restwebservices.model;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    @Size(min = 2, message = "Minimum side should of 2 character")
    private String name;
    @Past(message = "Only Past dates are allowed")
    private LocalDate localDate;

    //@Size and @Past are library coming as part of Spring-boot-validation dependency (Jakarta validation). To validate Input. Use @Valid annotation.
}
