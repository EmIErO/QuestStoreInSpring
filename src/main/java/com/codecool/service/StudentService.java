package com.codecool.service;

import com.codecool.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    List<Student> getStudentsByClassroom(String classroom);
}
