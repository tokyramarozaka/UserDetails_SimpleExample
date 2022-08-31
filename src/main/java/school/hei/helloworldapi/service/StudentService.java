package school.hei.helloworldapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.helloworldapi.model.Student;
import school.hei.helloworldapi.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    @Transactional
    public List<Student> saveAll(List<Student> students){
        return studentRepository.saveAll(students);
    }
}
