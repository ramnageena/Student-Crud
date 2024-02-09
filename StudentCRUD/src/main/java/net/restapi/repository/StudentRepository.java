package net.restapi.repository;

import net.restapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Integer> {

}
//save -> save(),update-> save(), get- findAll(), getById-> findById(), delete- >delete()
