package com.codecool.service.impl;

import com.codecool.model.Student;
import com.codecool.repo.StudentRepo;
import com.codecool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    @Override
    public List<Student> getStudentsByClassroom(String classroom) {
        return studentRepo.getStudentsByClassroom(classroom);
    }
}
