package school.hei.helloworldapi.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import school.hei.helloworldapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import school.hei.helloworldapi.repository.StudentRepository;
import school.hei.helloworldapi.service.StudentService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class StudentController {
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAll();
    }

    @PostMapping("/students")
    public List<Student> saveAllStudents(@RequestBody List<Student> students){
        return studentService.saveAll(students);
    }
}
