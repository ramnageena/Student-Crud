package net.restapi.controller;

import net.restapi.dto.StudentDto;
import net.restapi.model.Student;
import net.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping
    public ResponseEntity<List<StudentDto>> getALlStudents(){
        List<StudentDto> allStudent = studentService.getAllStudent();
        return  new ResponseEntity<>(allStudent, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable int id){
        StudentDto studentById = studentService.getStudentById(id);
        return  new ResponseEntity<>(studentById, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto student1 = studentService.createStudent(studentDto);
        return  new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable int id){
        StudentDto student1 = studentService.updateStudent(studentDto, id);
        return  new ResponseEntity<>(student1, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<StudentDto> deleteStudent(@PathVariable int id){
       studentService.deleteStudentById(id);
        return  new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

}
