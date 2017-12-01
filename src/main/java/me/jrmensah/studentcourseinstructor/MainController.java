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
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    InstructorRepository instructorRepository;

    @RequestMapping("/")
    public String showIndex(Model model){
        model.addAttribute("allstudents", studentRepository.findAll());
        model.addAttribute("allcourses", courseRepository.findAll());
        model.addAttribute("allinstructors", instructorRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addRecordForm(Model model){
        model.addAttribute("students", new Student());
        model.addAttribute("courses", new Course());
        model.addAttribute("instructors", new Instructor());
        return "addstudentlist";
    }
    @PostMapping("/process")
    public String processRecordForm(@Valid Student student, Course course, Instructor instructor, BindingResult result){
    {
        if(result.hasErrors()){
            return "index";
        }
        studentRepository.save(student);
        courseRepository.save(course);
        instructorRepository.save(instructor);
        return "recordlist";
        }
    }
    @GetMapping("/addstudent")
    public String addStudentForm(Model model){
        model.addAttribute("students", new Student());
        return "addstudentform";
    }
    @PostMapping("/addstudent")
    public String processStudentForm(@Valid Student student, BindingResult result, Model model){
        {
            if(result.hasErrors()){
                return "addstudentform";
            }
            studentRepository.save(student);
            model.addAttribute("allstudents",studentRepository.findAll());
            return "studentlist";
        }
    }
    @GetMapping("/addcourse")
    public String addCourseForm(Model model){
        model.addAttribute("courses", new Course());
        return "addcourseform";
    }
    @PostMapping("/addcourse")
    public String processCourseForm(@Valid Course course, BindingResult result, Model model){
        {
            if(result.hasErrors()){
                return "addcourseform";
            }
            courseRepository.save(course);
            model.addAttribute("allcourses",courseRepository.findAll());
            return "courselist";
        }
    }

    @GetMapping("/addinstructor")
    public String addInstructorForm(Model model){
        model.addAttribute("instructors", new Instructor());
        return "addinstructorform";
    }
    @PostMapping("/addinstructor")
    public String processInstructorForm(@Valid Instructor instructor, BindingResult result, Model model){
        {
            if(result.hasErrors()){
                return "addinstructorform";
            }
            instructorRepository.save(instructor);
            model.addAttribute("allinstructors", instructorRepository.findAll());
            return "instructorlist";
        }
    }
    @RequestMapping("/show")
    public String showAllRecords(Model model){
        model.addAttribute("allstudents", studentRepository.findAll());
        model.addAttribute("allcourses", courseRepository.findAll());
        model.addAttribute("allinstructors", instructorRepository.findAll());
        return "show";
    }
//    @PostMapping("/show")
//    public String processAllRecords(@Valid Student student, Course course, Instructor instructor, BindingResult result, Model model){
//        model.addAttribute("allstudents", studentRepository.findAll());
//        model.addAttribute("allcourses", courseRepository.findAll());
//        model.addAttribute("allinstructors", instructorRepository.findAll());
//        return "show";
//    }

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



