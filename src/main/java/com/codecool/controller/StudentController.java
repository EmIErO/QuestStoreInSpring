package com.codecool.controller;

import com.codecool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/students")
@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @RequestMapping("/{classroom}")
    public String getStudentsByClassroom(Model model, @PathVariable("classroom") String classroom) {
        model.addAttribute("students", studentService.getStudentsByClassroom(classroom));
        return "students";
    }
}
