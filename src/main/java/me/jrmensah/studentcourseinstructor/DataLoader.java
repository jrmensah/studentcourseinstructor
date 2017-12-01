package me.jrmensah.studentcourseinstructor;

import me.jrmensah.studentcourseinstructor.models.Course;
import me.jrmensah.studentcourseinstructor.models.Instructor;
import me.jrmensah.studentcourseinstructor.models.Student;
import me.jrmensah.studentcourseinstructor.repositories.CourseRepository;
import me.jrmensah.studentcourseinstructor.repositories.InstructorRepository;
import me.jrmensah.studentcourseinstructor.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String...strings)throws Exception{
        System.out.println("Loading Data...");

        Course course = new Course("Java","101","Core Java");
        courseRepository.save(course);

        Course course2 = new Course("SpringBoot","101","IntelliJ");
        courseRepository.save(course2);

        Student student = new Student("Jerilyn","Mensah","301-908-9841","jm@gmail.com");
        student.addCourse(course);
        studentRepository.save(student);

        Student student2 = new Student("Lisa","Simpson","555-123-1234","lisa@fox.net");
        student2.addCourse(course2);
        studentRepository.save(student2);

        Instructor instructor = new Instructor("Dave","Wolf","555-876-8726","dave45678@gmail.com");
        instructor.addCourse(course);
        instructorRepository.save(instructor);

        Instructor instructor2 = new Instructor("Afua","Anokmah","555-867-4923","afua@gmail.com");
        instructor.addCourse(course);
        instructorRepository.save(instructor2);



    }
}
