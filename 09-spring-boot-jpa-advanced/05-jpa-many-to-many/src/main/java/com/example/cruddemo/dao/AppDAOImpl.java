package com.example.cruddemo.dao;

import com.example.cruddemo.entities.Course;
import com.example.cruddemo.entities.Instructor;
import com.example.cruddemo.entities.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDao {
    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        // retrieve the instructor
        Instructor instructor = entityManager.find(Instructor.class, id);

        // get the courses
        List<Course> courses = instructor.getCourses();

        // break association of all courses for the instructor
        for (Course course : courses) {
            course.setInstructor(null);
        }

        // delete the instructor
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        // retrieve the instructor detail
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        // remove the associated object reference
        // break bi-directional link
        //
        instructorDetail.getInstructor().setInstructorDetail(null);

        // delete the instructor detail
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c where instructor.id = :id", Course.class);

        query.setParameter("id", id);

        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i "
                        + " JOIN FETCH i.courses "
                        + " JOIN FETCH i.instructorDetail "
                        + " WHERE i.id = :id"
                , Instructor.class);

        query.setParameter("id", id);

        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);

        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                        + " JOIN FETCH c.reviews "
                        + " where c.id = :id "
                , Course.class);

        query.setParameter("id", id);

        Course course = query.getSingleResult();

        return course;
    }
}
