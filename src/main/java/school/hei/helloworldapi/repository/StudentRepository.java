package school.hei.helloworldapi.repository;

import school.hei.helloworldapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByNameContainingIgnoreCase(String wanted);
}
