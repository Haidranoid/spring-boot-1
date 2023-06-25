package com.example.cruddemo;

import com.example.cruddemo.dao.AppDao;
import com.example.cruddemo.entities.*;
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
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {
            //createCourseAndStudents(appDao);
            //findCourseAndStudents(appDao);
            //findStudentAndCourses(appDao);
            //addMoreCoursesForStudent(appDao);
            //deleteCourse(appDao);
            deleteStudent(appDao);
        };
    }

    private void deleteStudent(AppDao appDao){
        int id = 2;

        appDao.deleteStudentById(id);
    }

    private void addMoreCoursesForStudent(AppDao appDao){
        int id = 2;
        Student student = appDao.findStudentAndCoursesByStudentId(id);

        Course course1 = new Course("Rubik's Cube-  How to speed run");
        Course course2 = new Course("Atari 2600 - Game development");

        student.addCourse(course1);
        student.addCourse(course2);

        System.out.println("student: " + student);
        System.out.println("courses: " + student.getCourses());

        appDao.updateStudent(student);
    }

    private void findStudentAndCourses(AppDao appDao) {
        int id = 1;

        Student student = appDao.findStudentAndCoursesByStudentId(id);

        System.out.println("student: " + student);
        System.out.println("courses: " + student.getCourses());
    }

    private void findCourseAndStudents(AppDao appDao) {
        int id = 10;
        Course course = appDao.findCourseAndStudentsByCourseId(id);

        System.out.println("course: " + course);
        System.out.println("students: " + course.getStudents());
    }

    private void createCourseAndStudents(AppDao appDao) {
        Course course = new Course("Pacman - how to score one million points");
        Student student1 = new Student("John", "Doe", "John@luv2code.com");
        Student student2 = new Student("Mary", "Public", "mary@luv2code.com");

        course.addStudent(student1);
        course.addStudent(student2);

        System.out.println("course: " + course);
        System.out.println("students: " + course.getStudents());

        appDao.saveCourse(course);
    }

    private void deleteCourseAndReviews(AppDao appDao) {
        int id = 10;
        appDao.deleteCourseById(id);
    }

    private void retrieveCourseAndReviews(AppDao appDao) {
        int id = 10;
        Course course = appDao.findCourseAndReviewByCourseId(id);

        System.out.println("course: " + course);
        System.out.println("reviews: " + course.getReviews());
    }

    private void saveCourseAndReviews(AppDao appDao) {
        Course course = new Course("Pacman - How to score one million points");

        course.addReview(new Review("Great course ... loved it"));
        course.addReview(new Review("Cool course, job well done"));
        course.addReview(new Review("What a dumb course, you are an idiot"));

        appDao.saveCourse(course);
    }

    private void deleteCourse(AppDao appDao) {
        int id = 10;
        appDao.deleteCourseById(id);
    }

    private void updateCourse(AppDao appDao) {
        int id = 10;

        Course course = appDao.findCourseById(id);

        course.setTitle("Enjoy the simple things");

        appDao.updateCourse(course);
        System.out.println("Done");
    }

    private void updateInstructor(AppDao appDao) {
        int id = 1;

        Instructor instructor = appDao.findInstructorById(id);

        instructor.setLastName("TESTER");

        appDao.update(instructor);
        System.out.println("done");
    }

    private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
        int id = 1;

        Instructor instructor = appDao.findInstructorByIdJoinFetch(id);

        System.out.println("instructor: " + instructor);
        System.out.println("courses: " + instructor.getCourses());
    }

    private void findCoursesForInstructor(AppDao appDao) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);

        Instructor instructor = appDao.findInstructorById(id);

        List<Course> courses = appDao.findCoursesByInstructorId(instructor.getId());

        // associate objects
        instructor.setCourses(courses);

        System.out.println("instructor: " + instructor);
        System.out.println("courses: " + instructor.getCourses());

        System.out.println("Done");
    }

    private void findInstructorWithCourses(AppDao appDao) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);

        Instructor instructor = appDao.findInstructorById(id);

        System.out.println("instructor: " + instructor);
        System.out.println("courses: " + instructor.getCourses());

        System.out.println("Done");
    }

    private void createInstructorWithCourses(AppDao appDao) {
        // create instructor
        Instructor instructor =
                new Instructor("Susan", "Piazza", "susan@hotmail.com");

        // create instructor detail
        InstructorDetail instructorDetail =
                new InstructorDetail("https://www.youtube.com/susan", "Video Games");

        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        // create some courses
        Course course1 = new Course("Air guitar - The ultimate guide");
        Course course2 = new Course("The pinball Masterclass");

        // add courses to instructor
        instructor.add(course1);
        instructor.add(course2);

        // save the instructor
        // NOTe: this will ALSO save the courses because of CascadeType.PERSIST
        System.out.println("Saving instructor: " + instructor);
        System.out.println("courses: " + instructor.getCourses());

        appDao.save(instructor);

        System.out.println("Done");
    }

    private void deleteInstructorDetail(AppDao appDao) {
        int id = 3;

        System.out.println("Deleting instructor detail id: " + id);
        appDao.deleteInstructorDetailById(id);

        System.out.println("Done");
    }

    private void findInstructorDetail(AppDao appDao) {
        // get the instructor detail object
        int id = 2;
        InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);
        // print the instructor detail
        System.out.println("Instructor Detail: " + instructorDetail);
        // print the associated instructor
        System.out.println("Instructor: " + instructorDetail.getInstructor());
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
