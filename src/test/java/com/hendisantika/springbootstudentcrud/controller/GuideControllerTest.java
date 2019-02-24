package com.hendisantika.springbootstudentcrud.controller;

import com.hendisantika.springbootstudentcrud.repository.GuideRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-student-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-24
 * Time: 15:30
 */
@RunWith(SpringRunner.class)
@WebMvcTest(GuideController.class)
public class GuideControllerTest {
    @MockBean
    GuideRepository guideRepository;
    @Autowired
    private MockMvc mockMvc;

    //posts to /addguide redirect to /allstudents if params are allowed.
    //if not they will return the /addguide page for resubmission.

    @Test
    public void testAddGuidePostMethodWorks() throws Exception {
        mockMvc.perform(post("/addguide")
                .param("name", "Uchiha Sasuke")
                .param("salary", "50000"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/allstudents"));
    }

    @Test
    public void testAddGuidePostNameConstraint() throws Exception {
        mockMvc.perform(post("/addguide")
                .param("name", "")
                .param("salary", "10000"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("addguide"));
    }

    @Test
    public void testAddGuideSalaryConstraint() throws Exception {
        mockMvc.perform(post("/addguide")
                .param("name", "Jon")
                .param("salary", "100"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("addguide"));
    }
}