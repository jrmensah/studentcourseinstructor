package me.jrmensah.studentcourseinstructor.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Instructor {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @Size(min = 3)
    private String firstName;
    @NotNull
    @Size(min = 3)
    private String lastName;
    @NotNull
    @Size(min = 3)
    private String contactNum;
    @NotNull
    @Size(min = 3)
    private String email;
    @NotNull
    @Size(min=3)
    private String courseTaught;

    @ManyToMany()
    private Set<Course> courses;


    public Instructor(String firstName, String lastName, String contactNum, String email, String courseTaught) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNum = contactNum;
        this.email = email;
        this.courseTaught = courseTaught;
        this.courses = new HashSet<Course>();
    }

    public Instructor() {
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

    public void addCourse (Course c){
        this.courses.add(c);
    }

    public String getCourseTaught() {
        return courseTaught;
    }

    public void setCourseTaught(String courseTaught) {
        this.courseTaught = courseTaught;
    }
}
