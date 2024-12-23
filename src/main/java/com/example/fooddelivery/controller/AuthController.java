package com.example.fooddelivery.controller;

import com.example.fooddelivery.dto.RoleDto;
import com.example.fooddelivery.model.Role;
import jakarta.validation.Valid;
import com.example.fooddelivery.dto.UserDto;
import com.example.fooddelivery.model.User;
import com.example.fooddelivery.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("index")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        List<RoleDto> availableRoles = new ArrayList<>() {{
            add(new RoleDto(Role.ADMIN, "ADMIN"));
            add(new RoleDto(Role.USER, "USER"));
        }};
        model.addAttribute("user", user);
        model.addAttribute("availableRoles", availableRoles);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }
}