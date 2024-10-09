package student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import student.management.entities.Student;
import student.management.services.StudentService;

@Controller
public class StudentController {
    
    @Autowired
    StudentService service;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot";
    }

    @GetMapping("/bye")
    public String sayBye() {
        return "Bye from Spring Boot";
    }

    @GetMapping("/data/{data}")
    public String acceptData(@PathVariable String data) {
        return "Data received: " + data;
    }

    @GetMapping("/data2")
    public String acceptValues(@RequestParam String d1, @RequestParam String d2) {
        return "Data received: " + d1 + ", " + d2;
    }

    // Accepting individual student fields
    @GetMapping("/acceptStudent")
    public String acceptStudent(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String mobile,
        @RequestParam String designation,
        @RequestParam String gender,
        @RequestParam String courses,
        @RequestParam String image) {

        // Create a new Student object
        Student st = new Student(name, email, mobile, designation, gender, courses, image);
        System.out.print(st);
        return "student data received"; // Changed spelling to "received"
    }

    // Accepting the entire student object from a form
    @PostMapping("/addStudent")
    public String acceptStudentObject(@ModelAttribute Student st) {
        service.addStudent(st);
        return "StudentRegistration"; // Redirect to a confirmation or list page
    }


    @PostMapping("/updateStudent")
    public String updateStudentObject(@ModelAttribute Student st) {
        service.addStudent(st); // Presumably the same method for both add and update
        return "StudentRegistration"; // You might want to redirect to a confirmation page
    }

    @GetMapping("/fetchAllStudents")
    public String fetchAllStudents(Model model) {
        List<Student> st = service.fetchAllStudents();
        model.addAttribute("studentList", st);
        return "displayAllStudent"; // Returns view for displaying all students
    }
    @GetMapping("/deleteStudent/{name}")
    public String deleteStudent(@PathVariable String name) {
        service.deleteStudentByName(name);
        return "redirect:/fetchAllStudents";  // Redirect to the list of students after deletion
    }

    
    @GetMapping("/updateProfile")
    public String updateProfile() {
        return "updateProfile"; // Returns view for updating the profile
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Returns view for the login page
    }
}
