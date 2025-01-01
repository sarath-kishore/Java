package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.controller;

import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model.User;
import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.service.JwtService;
import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class LoginController {

    private AuthenticationManager authenticationManager;

    private UserDetailsService userDetailsService;

    private BCryptPasswordEncoder passwordEncoder;
    private UserService userService;

    private JwtService jwtService;

    public LoginController(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, BCryptPasswordEncoder passwordEncoder, UserService userService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        System.out.println("inside get mapping LoginC");
        // Show your custom login form (index.html or login.html)
        return "login"; // Returns the login.html template
    }


    @PostMapping("/login")
    public String authenticateUser(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        System.out.println("inside post mapping loginC");
        return login(username, password);
    }

    @PostMapping("/register")
    public String addUser(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User temp = userService.createUser(user);

        return login(username, password);
    }

    public String login(String username, String password) throws BadCredentialsException{
        //        try {
        System.out.println("Logging user in LoginC : " + username);

        // Manually authenticate the user with the provided username and password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        System.out.println(authentication);
        System.out.println(authentication.getName());

        if(!authentication.isAuthenticated()) {
            // user invalid
            System.out.println("User not found LoginC");
            throw new UsernameNotFoundException("");
        }

        System.out.println("authenticated LoginC");
        // authentication is successful, set the authentication in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Create a new session and store the authentication object -> for session based auth
//        HttpSession session = ((ServletRequestAttributes) RequestContextHolder
//                .getRequestAttributes()).getRequest().getSession(true);
//        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
//                SecurityContextHolder.getContext());
//  enable above section for session-based auth. disable session state for JWT usage.



        // generate jwt
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        String jwt = jwtService.generateToken(user);

        System.out.println("new JWT generated : " + jwt);



        // Redirect or forward to another page after successful login
        return "redirect:/"; // Redirect to the home page after successful login
//        } catch (BadCredentialsException e) {
//            // If authentication fails, handle the error
//            System.out.println("Invalid credentials in LoginC bad cred exception thrown");
//            model.addAttribute("error", "Invalid credentials");
//            return "login"; // Show the login page again with error message
//        } catch (Exception e){
//            System.out.println("exception thrown: " + e.getMessage());
//            return "login";
//        }
    }

    @GetMapping("/check-session")
    public ResponseEntity<String> checkSession() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            return ResponseEntity.ok("Authenticated user: " + auth.getName());
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not authenticated");
        }
    }

}
