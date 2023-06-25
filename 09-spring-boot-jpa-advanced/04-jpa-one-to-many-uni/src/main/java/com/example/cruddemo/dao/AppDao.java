package com.example.cruddemo.dao;

import com.example.cruddemo.entities.Course;
import com.example.cruddemo.entities.Instructor;
import com.example.cruddemo.entities.InstructorDetail;
import com.example.cruddemo.entities.Student;

import java.util.List;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    Course findCourseById(int id);
    void updateCourse(Course course);

    void deleteCourseById(int id);

    void saveCourse(Course course);

    Course findCourseAndReviewByCourseId(int id);

    Course findCourseAndStudentsByCourseId(int id);
    Student findStudentAndCoursesByStudentId(int id);

    void updateStudent(Student student);

    void deleteStudentById(int id);
}
