package me.jrmensah.studentcourseinstructor;


import me.jrmensah.studentcourseinstructor.models.Student;
import me.jrmensah.studentcourseinstructor.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class MainController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/")
    public String showIndex(Model model){
        model.addAttribute("studentslist", studentRepository);
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
        return "redirect:/";
        }
    }

    @GetMapping("/addstudent")
    public String addStudent(Model model) {
        Student students = new Student();
        model.addAttribute("students", students);
        return "addstudentform";
    }

    @PostMapping("/addstudent")
    public String processStudent(@Valid@ModelAttribute("students") Student student, BindingResult result){
        {
            if(result.hasErrors()){
                return "addstudentform";
            }
            studentRepository.save(student);
            return "redirect:/";
        }
    }
}
