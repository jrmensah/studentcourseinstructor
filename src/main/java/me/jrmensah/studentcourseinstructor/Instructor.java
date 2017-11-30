package me.jrmensah.studentcourseinstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Instructor {

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String contactNum;
    private String email;
}
