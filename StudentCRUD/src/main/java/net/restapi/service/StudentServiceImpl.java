package net.restapi.service;

import net.restapi.dto.StudentDto;
import net.restapi.model.Student;
import net.restapi.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements  StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ModelMapper modelMapper;
    //studentDto -> student
    //studtent -> studentDto

    //Convert StudentDto to Student
    public  Student studentDtoToStudent(StudentDto studentDto){
        Student student= modelMapper.map(studentDto,Student.class);
        return student;
    }
    //convert Student to StudentDto
    public  StudentDto studentToStudentDto(Student student){
        StudentDto studentDto=modelMapper.map(student,StudentDto.class);
        return  studentDto;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = studentDtoToStudent(studentDto);
        Student student1 = studentRepository.save(student);
        StudentDto createStudent = studentToStudentDto(student1);
        return createStudent;
    }

    @Override
    public StudentDto getStudentById(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id:"+ id));
        StudentDto studentDto = studentToStudentDto(student);
        return  studentDto;
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> allStudents = students.stream()
                .map(student -> studentToStudentDto(student))
                .collect(Collectors.toList());
        return  allStudents;
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto, int id) {
        Student existStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id:"+ id));
        existStudent.setName(studentDto.getName());
        existStudent.setEmail(studentDto.getEmail());
        existStudent.setCity(studentDto.getCity());
        Student updateStudent = studentRepository.save(existStudent);
        StudentDto studentDto1 = studentToStudentDto(updateStudent);
        return studentDto1;
    }

    @Override
    public void deleteStudentById(int id) {
        StudentDto studentById = getStudentById(id);
        Student student = studentDtoToStudent(studentById);
        studentRepository.delete(student);
    }
}
