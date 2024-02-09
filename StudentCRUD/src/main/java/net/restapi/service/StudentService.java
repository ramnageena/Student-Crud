package net.restapi.service;

import net.restapi.dto.StudentDto;
import net.restapi.model.Student;

import java.util.List;

public interface StudentService {
    //create student
    StudentDto createStudent(StudentDto studentDto);

    //get student by Id
    StudentDto getStudentById(int id);

    //get ALl Students
    List<StudentDto> getAllStudent();

    //update Student
    StudentDto updateStudent(StudentDto studentDto ,int id);

    //delete Student
    void deleteStudentById(int id);
}
