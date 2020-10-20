package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.model.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class studentService {

    ArrayList<Student> studentList = new ArrayList<>();

    public void register(Student student) {
        studentList.add(student);
    }

    public Student login(String username, String password) {
        // steam的用法是咋
        Student foundStudent = studentList.stream().filter(student -> student.getUsername().equals(username)).findAny().get();
        if(foundStudent.getPassword().equals(password)) {
            return foundStudent;
        } else {
            throw new RuntimeException();
        }
    }
}
