package student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import student.management.entities.User;
import student.management.services.UserService;

@Controller
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/signup")
    public String addUser(@ModelAttribute User user) {
        String username = user.getUsername();
        String email = user.getEmail();
        boolean status = service.userExists(username, email);
        
        if (!status) {
            service.addUser(user);
        }
        // Redirect to login after signup
        return "redirect:/login"; // Use redirect to ensure the user is directed properly
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        boolean status = service.validateUser(username, password);
        
        if (status) {
            // Create session for the user
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            // Check if a redirect URL is stored in the session
            String redirectUrl = (String) session.getAttribute("redirectAfterLogin");
            if (redirectUrl != null) {
                session.removeAttribute("redirectAfterLogin"); // Clear the stored URL
                return "redirect:" + redirectUrl; // Redirect to the original page
            }
            return "home"; // Default page after successful login
        } else {
            // Invalid login, return to signup or login page with an error message
            return "signup"; // You can use a login page here instead if needed
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate the session to log out the user
        }
        return "redirect:/login"; // Redirect to the login page after logout
    }
}
