package me.jrmensah.studentcourseinstructor.repositories;

import me.jrmensah.studentcourseinstructor.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
