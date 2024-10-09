package student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import student.management.entities.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
    void deleteByName(String name);
}

