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
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            createMultipleStudents(studentDAO);
            // readStudent(studentDAO);
            //queryForStudents(studentDAO);
            //queryForStudentsByLastName(studentDAO);
            //updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students...");
        int rowsDeleted = studentDAO.deleteAll();
        System.out.println("Records deleted: " + rowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 5;
        System.out.println("Deleting student id: " + studentId);
        studentDAO.deleteById(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student based on the id: primary Key
        int studentId = 1;
        System.out.println("Getting student iwth id: " + studentId);
        Student myStudent = studentDAO.findByID(1);

        // change first name to "Scooby"
        System.out.println("Updating student ...");
        myStudent.setFirstName("Scooby");

        // update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // get a list of students
        List<Student> students = studentDAO.findByLastName("Apple");

        // display list of students
        students.forEach(System.out::println);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> students = studentDAO.findAll();

        // display list of students
        students.forEach(System.out::println);
    }

    private void readStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("sam", "sepiol", "sam@gmail.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student. generated id: " + theId);

        // retrieve student based on the id: primary key
        System.out.println("\n Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findByID(theId);

        // display student
        System.out.println("Found the student: " + myStudent);

    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating 3 student objects ...");
        Student tempStudent1 = new Student("John", "Doe", "paul@gmail.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com");
        Student tempStudent3 = new Student("Bonita", "Apple", "bonnie@gmail.com");

        // save the student object
        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        // display id of the saved student
        System.out.println("Saved student nº1. Generated id: " + tempStudent1.getId());
        System.out.println("Saved student nº2. Generated id: " + tempStudent2.getId());
        System.out.println("Saved student nº3. Generated id: " + tempStudent3.getId());
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("paul", "Doe", "paul@gmail.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

}
