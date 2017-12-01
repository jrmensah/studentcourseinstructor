package me.jrmensah.studentcourseinstructor;


import me.jrmensah.studentcourseinstructor.models.Course;
import me.jrmensah.studentcourseinstructor.models.Instructor;
import me.jrmensah.studentcourseinstructor.models.Student;
import me.jrmensah.studentcourseinstructor.repositories.CourseRepository;
import me.jrmensah.studentcourseinstructor.repositories.InstructorRepository;
import me.jrmensah.studentcourseinstructor.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class MainController {

    @Autowired
    StudentRepository studentRepository;
    CourseRepository courseRepository;
    InstructorRepository instructorRepository;

    @RequestMapping("/")
    public String showIndex(Model model){
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addStudentForm(Model model){
        model.addAttribute("students", new Student());
        return "addstudentform";
    }
    @PostMapping("/process")
    public String processStudentForm(@Valid Student student, BindingResult result){
    {
        if(result.hasErrors()){
            return "addstudentform";
        }
        studentRepository.save(student);
        return "studentslist";
        }
    }


    @GetMapping("/addstudent")
    public String addStudent(Model model) {
        Student students = new Student();
        model.addAttribute("students", students);
        return "addstudentform";
    }

    @PostMapping("/addstudent")
    public String processStudent(@Valid@ModelAttribute("students") Student student, BindingResult result, Model model)
        {
            if(result.hasErrors()){
                return "addstudentform";
            }
            studentRepository.save(student);
            model.addAttribute("allstudents", studentRepository.findAll());
            return "recordlist";
        }

    @GetMapping("/addcourse")
    public String addCourse(Model model){
        Course courses = new Course();
        model.addAttribute("courses", courses);
        return "addcourseform";
    }
    @PostMapping("/addcourse")
    public String processCourse(@Valid@ModelAttribute("courses") Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addcourseform";
        }
        courseRepository.save(course);
        model.addAttribute("allcourses", courseRepository.findAll());
        return "recordlist";
    }
    @GetMapping("/addinstructor")
    public String addInstructor(Model model){
        Course courses = new Course();
        model.addAttribute("instructors", courses);
        return "addinstructorform";
    }
    @PostMapping("/addinstructor")
    public String processInstructor(@Valid@ModelAttribute("instructors") Instructor instructor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addinstructorform";
        }
        instructorRepository.save(instructor);
        model.addAttribute("allinstructors", instructorRepository.findAll());
        return "recordlist";
    }


//    @RequestMapping("/detail/{id}")
//    public String showStudent(@PathVariable("id") long id, Model model){
//        model.addAttribute("students", studentRepository.findOne(id));
//        return "show";
//    }
//    @RequestMapping("/update/{id}")
//    public String updatePet(@PathVariable("id") long id, Model model){
//        model.addAttribute("students", studentRepository.findOne(id));
//        return "addstudentform";
//    }
//    @RequestMapping("/delete/{id}")
//    public String delPet(@PathVariable("id") long id){
//        studentRepository.delete(id);
//        return "redirect:/";
//    }

    }

