package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.model.Student;
import com.thoughtworks.capacity.gtb.mvc.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
// 抛出异常 throw Exception的用法
// steam的用法是咋
// 为啥我用了@Data注解后没有效果
//GET http://localhost:8080/login?username=foo&password=bar
@RestController
public class studentController {

    @Autowired
    private studentService studentservice;

    @RequestMapping("/login")
    public ResponseEntity<Student> login(@RequestParam @Valid String username, @RequestParam String password) {
        Student foundStudent = studentservice.login(username, password);
        return ResponseEntity.status(HttpStatus.OK).body(foundStudent);

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid Student student) {
        studentservice.register(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
