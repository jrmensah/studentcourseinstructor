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
public class Course {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min = 3)
    private String title;
    @NotNull
    @Size(min = 3)
    private String courseNum;
    @NotNull
    @Size(min = 3)
    private String description;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    @ManyToMany(mappedBy = "courses")
    private Set<Instructor> instructors;


    public Course(String title, String courseNum, String description) {
        this.title = title;
        this.courseNum = courseNum;
        this.description = description;
        instructors=new HashSet<Instructor>();
        students = new HashSet<Student>();
    }

    public Course() {
        students = new HashSet<Student>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

//    public void addStudent(Student s){
//        students.add(s);
//    }
}
