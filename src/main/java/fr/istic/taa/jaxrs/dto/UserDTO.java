package fr.istic.taa.jaxrs.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate registrationDate;
}
