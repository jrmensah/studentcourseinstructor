package me.jrmensah.studentcourseinstructor.repositories;

import me.jrmensah.studentcourseinstructor.models.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, Long> {
}
