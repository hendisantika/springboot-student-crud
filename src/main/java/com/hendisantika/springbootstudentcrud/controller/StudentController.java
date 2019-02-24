package com.hendisantika.springbootstudentcrud.controller;

import com.hendisantika.springbootstudentcrud.entity.Guide;
import com.hendisantika.springbootstudentcrud.entity.Student;
import com.hendisantika.springbootstudentcrud.repository.GuideRepository;
import com.hendisantika.springbootstudentcrud.repository.StudentRepository;
import com.hendisantika.springbootstudentcrud.repository.SubjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-student-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-24
 * Time: 14:21
 */
@Controller
public class StudentController {

    private final StudentRepository student;
    private final GuideRepository guide;
    private final SubjectRepository subjectRepository;


    public StudentController(StudentRepository student, GuideRepository guide, SubjectRepository subjectRepository) {
        this.student = student;
        this.guide = guide;
        this.subjectRepository = subjectRepository;
    }


    @GetMapping("/addstudent")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        List<Guide> guides = guide.findAll();
        model.addAttribute("guides", guides);
        model.addAttribute("subjects", subjectRepository.findAll());
        return "addstudent";
    }


    @PostMapping("/addstudent")
    public String addStudent(Student student, BindingResult result, Model model) {

        if (student.getName().equals("") || student.getName().matches(".*\\d+.*")) {
            result.rejectValue("name", "name");
            return "redirect:/addstudent";
        }

        this.student.save(student);
        return "redirect:/allstudents";
    }

    @RequestMapping(value = {"/allstudents", "/"}, method = RequestMethod.GET)
    public String allStudents(ModelMap model) {
        model.put("students", student.findAll());
        model.put("subjects", subjectRepository.findAll());
        return "allstudents";
    }

    @GetMapping("/test")
    public String index(ModelMap model) {
        model.put("students", student.findAll());
        model.put("subjects", subjectRepository.findAll());
        return "index";
    }


}
