package me.jrmensah.studentcourseinstructor.repositories;

import me.jrmensah.studentcourseinstructor.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long>{
}
