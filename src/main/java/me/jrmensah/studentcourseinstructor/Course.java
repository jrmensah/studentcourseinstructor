package me.jrmensah.studentcourseinstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String courseNum;
    private String description;
}
