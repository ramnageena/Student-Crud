package net.restapi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {


    private int id;

    @Column(name = "student_name" )
    private String name; //studentName;

    @Column(name = "student_email")
    private String email;

    @Column(name = "student_city")
    private String city;

}
