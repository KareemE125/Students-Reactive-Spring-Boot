package com.ke.backend.controllers;

import com.ke.backend.services.StudentService;
import com.ke.backend.tables.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public String homeCall() {
        return "Welcome to Students API.";
    }

    @GetMapping("all")
    public Flux<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("{id}")
    public Mono<Student> getById(@PathVariable Integer id) {
        return studentService.getById(id);
    }

    @GetMapping("firstname/{firstname}")
    public Flux<Student> getAllByFirstname(@PathVariable String firstname) {
        return studentService.getAllByFirstname(firstname);
    }

    @GetMapping("email/{email}")
    public Flux<Student> getByEmail(@PathVariable String email) {
        return studentService.getAllByEmail(email);
    }

    @PostMapping("add")
    public Mono<Student> add(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("{id}")
    public Mono<Student> updateById(@PathVariable Integer id, @RequestBody Student newStudent) {
        return studentService.updateById(id, newStudent);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteById(@PathVariable Integer id) {
        return studentService.deleteById(id);
    }

}
