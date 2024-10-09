package student.management.services;

import java.util.List;

import student.management.entities.Student;

public interface StudentService {
 String addStudent(Student st);
String updateStudent(Student st);
List<Student> fetchAllStudents();
String updateProfile();
String login();
String delete(String name);
void deleteStudentByName(String name);
}
