package com.example.cruddemo.dao;

import com.example.cruddemo.entities.Instructor;
import com.example.cruddemo.entities.InstructorDetail;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
