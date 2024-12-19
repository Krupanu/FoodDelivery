package com.example.fooddelivery.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.fooddelivery.dao.AdminDao;
import com.example.fooddelivery.model.Admin;

@Controller
public class AdminController {

    private final AdminDao adminDao;

    public AdminController(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @GetMapping("/")
    public String goToHomeDuringStart() {
        return "index";
    }

    @GetMapping("/home")
    public String goToHome() {
        return "index";
    }

    @GetMapping("/admindashboard")
    public String goToAdminPage() {
        return "admin";
    }

    @GetMapping("/adminlogin")
    public String goToAdminLoginPage() {
        return "adminlogin";
    }

    @GetMapping("/adminregister")
    public String goToAdminRegisterPage() {

        return "adminregister";
    }

    @PostMapping("/adminregister")
    public ModelAndView registerAdmin(@ModelAttribute Admin admin) {
        ModelAndView mv = new ModelAndView();
        if(this.adminDao.save(admin)!= null) {
            mv.addObject("status", admin.getFirstname()+" Successfully Registered as ADMIN");
            mv.setViewName("adminlogin");
        }

        else {
            mv.addObject("status", admin.getFirstname()+" Failed to Registered as ADMIN");
            mv.setViewName("adminregister");

        }

        return mv;
    }

    @PostMapping("/adminlogin")
    public ModelAndView loginAdmin(HttpServletRequest request, @RequestParam("emailid") String emailId, @RequestParam("password") String password ) {
        ModelAndView mv = new ModelAndView();

        Admin admin = adminDao.findByEmailidAndPassword(emailId, password);

        if(admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("active-user", admin);
            session.setAttribute("user-login","admin");
            mv.addObject("status", admin.getFirstname()+" Successfully Logged in as ADMIN!");
            mv.setViewName("index");
        }

        else {
            mv.addObject("status","Failed to login as Admin!");
            mv.setViewName("index");
        }

        return mv;
    }

}
