package com.example.cruddemo;

import com.example.cruddemo.dao.AppDao;
import com.example.cruddemo.entities.Instructor;
import com.example.cruddemo.entities.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {
            //createInstructor(appDao);
            //findInstructor(appDao);
            deleteInstructor(appDao);
        };
    }

    private void deleteInstructor(AppDao appDao) {
        int id = 1;
        System.out.println("Deleting instructor id: " + id);
        appDao.deleteInstructorById(id);
        System.out.println("Done");
    }

    private void findInstructor(AppDao appDao) {
        int id = 2;
        System.out.println("Finding instructor id: " + id);

        Instructor instructor = appDao.findInstructorById(id);
        System.out.println("instructor: " + instructor);
        System.out.println("instructor details: " + instructor.getInstructorDetail());
    }

    private void createInstructor(AppDao appDao) {
        /*// create instructor
            Instructor instructor =
                    new Instructor("john", "wick", "john_wick@hotmail.com");

            // create instructor detail
            InstructorDetail instructorDetail =
                    new InstructorDetail("https://www.jonhwick45.com/youtube", "kill");

            // set instructor detail in instructor
            instructor.setInstructorDetail(instructorDetail);
*/
        // create instructor
        Instructor instructor =
                new Instructor("Madhu", "Patel", "madhu@hotmail.com");

        // create instructor detail
        InstructorDetail instructorDetail =
                new InstructorDetail("https://www.madhu.com/youtube", "Guitar");

        instructor.setInstructorDetail(instructorDetail);

        // save the instructor
        //
        // NOTE: this will ALSO save the details object
        // because of CascadeType.ALL
        //
        System.out.println("Saving instructor: " + instructor);
        appDao.save(instructor);
    }
}
