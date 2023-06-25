package com.example.cruddemo.dao;

import com.example.cruddemo.entities.Instructor;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
