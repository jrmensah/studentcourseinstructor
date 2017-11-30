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
        return "index";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("students", student);
        return "addstudent";
    }
    @PostMapping("/process")
    public String processStudent(@Valid Student student, BindingResult result){
        if (result.hasErrors()) {
            return "addstudent";
        }
        studentRepository.save(student);
        return "redirect:/";
    }
}
