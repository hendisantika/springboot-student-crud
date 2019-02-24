package com.hendisantika.springbootstudentcrud.controller;

import com.hendisantika.springbootstudentcrud.entity.Guide;
import com.hendisantika.springbootstudentcrud.repository.GuideRepository;
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
 * Time: 14:19
 */
@Controller
public class GuideController {

    private final GuideRepository guideRepository;

    public GuideController(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    @GetMapping("/addguide")
    public String addGuide(Model model) {
        Guide guide = new Guide();
        model.addAttribute("guide", guide);
        return "addguide";
    }

    @PostMapping("/addguide")
    public String addGuide(Guide guide, BindingResult result) {

        if (guide.getName().equals("") || guide.getName().matches(".*\\d+.*") || guide.getSalary() < 1000) {
            result.rejectValue("name", "name");
            return "addguide";
        }

        this.guideRepository.save(guide);
        return "redirect:/allstudents";
    }

}