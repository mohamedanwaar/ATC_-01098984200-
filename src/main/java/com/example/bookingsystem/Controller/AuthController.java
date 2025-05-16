package com.example.bookingsystem.Controller;

import jakarta.servlet.http.HttpSession;
import com.example.bookingsystem.Entitys.Role;
import com.example.bookingsystem.Entitys.UserEntity;
import com.example.bookingsystem.Repository.UserRepo;
import com.example.bookingsystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired
    private UserService userService ;

    @GetMapping("/login")
    public String showLogin() {
        return "login";  /// this is to show login page
    }
    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  /// invalidate the session
        return "redirect:/login";  /// redirect to login page
    }
    @GetMapping("home/card")
    public String showCard() {
        return "myBookings";  /// this is to show card page
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String email, @RequestParam String password, Model model) {
        UserEntity user = new UserEntity(username, email, password, Role.ADMIN);
        UserEntity existingUser = userService.FindUserByEmail(email);
        if (existingUser != null) {
            model.addAttribute("error", "Email already exists");
            return "register";  /// show register page with error message
        }
        else
        {

            if (
                    !password.matches(".*[A-Z].*") ||  /// check if password contains at least one uppercase letter
                    !password.matches(".*[a-z].*") ||  /// check if password contains at least one lowercase letter
                    !password.matches(".*[0-9].*") ||  /// check if password contains at least one digit
                    !password.matches(".*[@#$%^&+=!].*") || /// check if password contains at least one special character
                            password.length()<8    /// check if passed length is less than 8

            )
            {
                model.addAttribute("error", "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character");
                return "register";  /// show register page with error message
            }
            else if(username.isEmpty() || email.isEmpty()||password.isEmpty()  ) {
                model.addAttribute("error", "Please fill all fields");
                return "register";  /// show register page with error message
            }
            else if (username.length() < 3 ) {
                model.addAttribute("error", "Username must be at least 3 characters long");
                return "register";  /// show register page with error message
            }
            else if (!username.matches("^[a-zA-Z]+$")) {
                model.addAttribute("error", "\"error\", \"Username must contain only letters (no numbers or symbols allowed)\"");
                return "register";
            }
            else if (email.length() < 5) {
                model.addAttribute("error", "Email must be at least 5 characters long");
                return "register";  /// show register page with error message
            }
            else if (email.length() > 50) {
                model.addAttribute("error", "Email must be at most 50 characters long");
                return "register";  /// show register page with error message
            }
            userService.registerUser(user);
            model.addAttribute("message", "Registration successful. Please login.");
            return "login";  /// redirect to login page after registration


        }


    }
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password ,HttpSession session,  Model model) {
        UserEntity user= userService.FindUserByEmail(email);
        if (user!= null && user.getPassword().equals(password) && user.getRole().equals(Role.USER))
        {
            session.setAttribute("user", user);  /// store user in session
            return "redirect:/home";/// redirect to home page for user
        }
        else if (user!= null && user.getPassword().equals((password)) && user.getRole().equals(Role.ADMIN)) {
            session.setAttribute("user", user);  /// store user in session
            return "redirect:/admin";  /// redirect to admin page
        }
        else {
            model.addAttribute("error", "Invalid email or password");
            return "login";  /// show login page with error message
        }
    }

}
