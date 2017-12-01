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
        System.out.println("All Students:"+studentRepository.count());

        model.addAttribute("allcourses", courseRepository.findAll());
        System.out.println("All Courses:"+courseRepository.count());

        model.addAttribute("allinstructors", instructorRepository.findAll());
        System.out.println("All Instructors:" +instructorRepository.count());
        return "show";
    }

    @GetMapping("/addstudenttocourse/{id}")
    public String addStudentsToCourse(@PathVariable("id")Long studentId, Model model){
        model.addAttribute("allcourses",courseRepository.findAll());
        model.addAttribute("student",studentRepository.findOne(new Long(studentId)));
        return "addstudenttocourse";
    }
    @PostMapping("/addstudenttocourse/")
    public String addStudentsToCourse(@RequestParam("student")String studentId,@RequestParam("courseid")String courseId, Model model){
        Student astudent = studentRepository.findOne(new Long(studentId));
        astudent.addCourse(courseRepository.findOne(new Long(courseId)));
        studentRepository.save(astudent);
        model.addAttribute("allcourses",courseRepository.findAll());
        model.addAttribute("student",studentRepository.findAll());
        return "redirect:/show";
    }
    @GetMapping("/addinstructortocourse/{id}")
    public String addInstuctorsToCourse(@PathVariable("id")Long instructorId, Model model){
        model.addAttribute("allcourses",courseRepository.findAll());
        model.addAttribute("instructor",instructorRepository.findOne(new Long(instructorId)));
        return "addinstructortocourse";
    }
    @PostMapping("/addinstructortocourse/")
    public String addInstructorsToCourse(@RequestParam("instructor")String instructorId,@RequestParam("courseid")String courseId, Model model){
        Instructor instructor = instructorRepository.findOne(new Long(instructorId));
        instructor.addCourse(courseRepository.findOne(new Long(courseId)));
        instructorRepository.save(instructor);
        model.addAttribute("allcourses",courseRepository.findAll());
        model.addAttribute("instructor",instructorRepository.findAll());
        return "redirect:/show";
    }
}





