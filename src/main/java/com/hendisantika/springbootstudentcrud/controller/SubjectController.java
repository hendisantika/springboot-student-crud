package com.hendisantika.springbootstudentcrud.controller;

import com.hendisantika.springbootstudentcrud.entity.Subject;
import com.hendisantika.springbootstudentcrud.repository.SubjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
public class SubjectController {

    private final SubjectRepository subjectRepository;

    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/addsubject")
    public String addSubject(Model model) {
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "addsubject";
    }

    @PostMapping("/addsubject")
    public String addSubject(Subject subject, BindingResult result) {

        if (subject.getName().equals("") || subject.getName().matches(".*\\d+.*")) {
            result.rejectValue("name", "name");
            return "addsubject";
        }

        this.subjectRepository.save(subject);
        return "redirect:/allstudents";
    }

}