package student.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import student.management.entities.Student;
import student.management.repository.StudentRepository;
@Service
@Controller
public class StudentServiceImplementation implements StudentService {
	@Autowired
	StudentRepository repo;
public String addStudent(Student st) {
	repo.save(st);
	return "home";
}

public String updateStudent(Student st) {
	repo.save(st);
	return "home";
}

public List<Student> fetchAllStudents(){
	return repo.findAll();
}

@Override
public String updateProfile() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String login() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String delete(String name) {
	// TODO Auto-generated method stub
	repo.deleteByName(name);
	return name;
}

@Override
public void deleteStudentByName(String name) {
	// TODO Auto-generated method stub
	
}

}
