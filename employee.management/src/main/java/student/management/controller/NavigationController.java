package student.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
@GetMapping("/openAddStudentPage")
public String openAddStudentPage() {
	return "addStudent";
}
@GetMapping("/openDeleteStudentPage")
public String openDeleteStudentPage() {
	return "deleteStudent";
}
@GetMapping("/openUpdateStudentPage")
public String openUpdateStudentPage() {
	return "updateStudent";
}
@GetMapping("/openUpdateProfile")
public String openUpdateProfile() {
	return "updateProfile";
}
@GetMapping("/openHome")
public String openHome() {
	return "home";
}

@GetMapping("/")
public String openLogin() {
	return "login";
}
@GetMapping("/openSignUp")
public String openSignUp() {
	return "signup";
}
@GetMapping("/openLogout")
public String openLogout() {
	return "login";
}
@GetMapping("/openStudentRegistration")
public String openStudentRegistration() {
	return "StudentRegistration";
}
}
