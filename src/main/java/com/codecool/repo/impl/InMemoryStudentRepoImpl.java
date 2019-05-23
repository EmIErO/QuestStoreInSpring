package com.codecool.repo.impl;

import com.codecool.model.Classroom;
import com.codecool.model.Student;
import com.codecool.repo.StudentRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryStudentRepoImpl implements StudentRepo {

    private List<Student> listOfStudents = new ArrayList<>();

    public InMemoryStudentRepoImpl() {
        Student ann = new Student("Anna", "Idzi", "idzia@gmail.com");
        ann.setClassroom(Classroom.ADVANCED);
        Student przemek = new Student("Przem", "Polczak", "ppolczak@gmail.com");
        Student michu = new Student("Michał", "Wiśniewski", "wisnia@wp.pl");
        Student tam = new Student("Tymon", "Burz", "burz@op.pl");
        tam.setClassroom(Classroom.JAVA);

        listOfStudents.add(ann);
        listOfStudents.add(przemek);
        listOfStudents.add(michu);
        listOfStudents.add(tam);
    }

    @Override
    public List<Student> getAllStudents() {
        return listOfStudents;
    }

    @Override
    public List<Student> getStudentsByClassroom(String classroom) {
        List<Student> studentsFromClassroom = new ArrayList<>();

        for (Student student : listOfStudents) {
            if (student.isWithdrawn() == false && student.getClassroom().toString().equalsIgnoreCase(classroom)) {
                studentsFromClassroom.add(student);
            }
        }
        return studentsFromClassroom;
    }


}
