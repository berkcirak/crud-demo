package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("deleting all students...");
		int allStudents=studentDAO.deleteAll();
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId=2;
		System.out.println("getting student with id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId=1;
		System.out.println("getting student with id: "+studentId);
		Student myStudent=studentDAO.findById(studentId);

		System.out.println("updating student...");
		myStudent.setFirstName("Atalay");

		studentDAO.update(myStudent);

		System.out.println("updated student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> theStudents=studentDAO.findByLastName("cakir");

		for(Student theStudent:theStudents){
			System.out.println(theStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		List<Student> thestudents=studentDAO.findAll();

		for(Student students:thestudents){
			System.out.println(students);
		}
	}

	private void readStudent(StudentDAO studentDAO) {


		System.out.println("creating a new student object...");
		Student st1=new Student("ugurcan","cakir","ucakir@gmail.com");

		System.out.println("saving the student...");
		studentDAO.save(st1);

		int theId=st1.getId();
		System.out.println("saved student. generated id:"+theId);

		System.out.println("retrieving student with id: "+theId);
		Student myStudent=studentDAO.findById(theId);

		System.out.println("found the student: "+myStudent);
	}


	private void createMultipleStudents(StudentDAO studentDAO) {


		System.out.println("creating new student object...");
		Student student1=new Student("zeynep","guven","zguven@gmail.com");
		Student student2=new Student("buse","yilmaz","byilmaz@gmail.com");
		Student student3=new Student("ugurcan","cakir","ucakir@gmail.com");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {


		System.out.println("creating new student object...");
		Student student1=new Student("berk","cirak","atalayberkcrak@gmail.com");

		System.out.println("saving the student...");
		studentDAO.save(student1);


		System.out.println("saved student. Generated id: "+student1.getId());

	}
}
