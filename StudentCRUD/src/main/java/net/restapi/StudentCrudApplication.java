package net.restapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentCrudApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudentCrudApplication.class, args);
		System.out.println("Spring boot is starting");
	}

	@Bean
	public ModelMapper modelMapper(){
		return  new ModelMapper();
	}

}
// model C >> RepositoryI >> ServiceI >> ServiceImpl C >> controller  C