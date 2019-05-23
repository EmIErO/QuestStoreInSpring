package com.codecool.repo;

import com.codecool.model.Student;

import java.util.List;

public interface StudentRepo {
    public List<Student> getAllStudents();

    public List<Student> getStudentsByClassroom(String classroom);
}
