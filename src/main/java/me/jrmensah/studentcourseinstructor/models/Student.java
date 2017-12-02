package me.jrmensah.studentcourseinstructor.models;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 2)
    private String firstName;
    @NotNull
    @Size(min = 3)
    private String lastName;
    @NotNull
    @Size(min=3)
    private String contactNum;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Size(min=3)
    private String courseTaken;

    @ManyToMany()
    private Set<Course> courses;


    public Student(String firstName, String lastName, String contactNum, String email, String courseTaken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNum = contactNum;
        this.email = email;
        this.courseTaken = courseTaken;
        this.courses = new HashSet<Course>();
    }


    public Student() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course c){
        this.courses.add(c);
    }

    public String getCourseTaken() {
        return courseTaken;
    }

    public void setCourseTaken(String courseTaken) {
        this.courseTaken = courseTaken;
    }
}
