package com.pi_engenhariadesoftware.pi_project.controllers;

import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;


import com.pi_engenhariadesoftware.pi_project.Services.CookieService;
import com.pi_engenhariadesoftware.pi_project.entities.User;
import com.pi_engenhariadesoftware.pi_project.repositories.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

   @PostMapping("/checkLogin")
   public String checkLogin(Model model, User userParam, HttpServletResponse response) throws IOException{
        User user = this.userRepository.login(userParam.getLogin(), userParam.getPassword());
        if(!user.getActive()){
          model.addAttribute("disabled", "User disabled, contact your administrator!");
          return "login";
        }

        if(user != null){
            CookieService.setCookie(response, "userId", Integer.toString(user.getId()), 3600);
            CookieService.setCookie(response,"userName", user.getName(), 3600 );
            return "redirect:/admin";
        }
        model.addAttribute("error", "Invalid credentials");

        return "login";
   }

   @GetMapping("/exit")
   public String exit(HttpServletResponse response) throws IOException{
        CookieService.setCookie(response, "userId", "", 0);
        CookieService.setCookie(response, "userName", "", 0);
        return "redirect:/";
   }



   @GetMapping("/recover")
   public String recover(){
        return "recover";
   }

   @PostMapping("/checkReset")
   public String checkReset(String login, @RequestParam("birthdate") LocalDate birthDate, Model model, HttpServletResponse response) throws IOException{

        login = login.replaceAll("\\s", "");

        User user = userRepository.reset(login, birthDate);

        if(user != null){
            model.addAttribute("id", user.getId());
            CookieService.setCookie(response, "idUser", Integer.toString((user.getId())), 60);
            return "redirect:/setPassForm";
        }

        model.addAttribute("error", "Invalid credentials");
        return "recover";
   }

   @GetMapping("/setPassForm")
   public String passForm(){
         return "resetPassForm";
   }

   @PostMapping("/setPass")
   public String setPass(String pass, String passConfirm, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
     String idUser = CookieService.getCookie(request, "idUser");

     if(idUser == null){
          model.addAttribute("overflow", "Time exceeded");
          return "recover";
     }

     if(!pass.equals(passConfirm)){
          model.addAttribute("passNotEquals", "The passwords do not match");
          return "resetPassForm";
     }

     int id = Integer.parseInt(idUser);

     User user = userRepository.getUser(id);

     user.setPassword(pass);

     userRepository.save(user);

     model.addAttribute("sucess", "The password was changed sucessfully");
     CookieService.setCookie(response, "idUser", "", 0);
     return "login";

   }
}
