package dev.muneer.movies.Controllers;

import ch.qos.logback.core.model.Model;
import dev.muneer.movies.Models.User;
import dev.muneer.movies.Repository.UserRepository;
import dev.muneer.movies.Services.UserService;
import dev.muneer.movies.helper.DebugUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService,UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody Map<String, String> payload) {
        String password = payload.get("password");
        String username = payload.get("username");
        String confirmPassword = payload.get("confirm_password");
        User existingUser = userService.findUserByUsername(username);
        if (!password.equals(confirmPassword)) {
            return ResponseEntity.badRequest().body("Passwords do not match");
        } else if (existingUser != null) {
            return ResponseEntity.badRequest().body("Username already exists:");
        } else {
            User user = new User();
            user.setUsername(payload.get("username"));
            user.setPassword(payload.get("password"));
            return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
        }
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> processLogin(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userRepository.findByUsername(username);
        Map<String, String> response = new HashMap<>();
        if (user != null && user.getPassword().equals(password)) {
            response.put("result", String.valueOf(true));
            response.put("username", user.getUsername());
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", username);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Login failed");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/logout")
    public static String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return String.valueOf(session.getAttribute("loggedInUser"));
            //session.invalidate();
        }
        return "null";

    }



}
