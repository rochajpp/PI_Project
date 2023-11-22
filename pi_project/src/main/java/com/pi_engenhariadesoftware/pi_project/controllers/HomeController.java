package com.pi_engenhariadesoftware.pi_project.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pi_engenhariadesoftware.pi_project.entities.Car;
import com.pi_engenhariadesoftware.pi_project.entities.Report;
import com.pi_engenhariadesoftware.pi_project.entities.User;
import com.pi_engenhariadesoftware.pi_project.repositories.CarRepository;
import com.pi_engenhariadesoftware.pi_project.repositories.ReportRepository;
import com.pi_engenhariadesoftware.pi_project.repositories.UserRepository;

import ch.qos.logback.core.model.Model;


@Controller
public class HomeController {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final ReportRepository reportRepository;

    public HomeController(CarRepository carRepository, UserRepository userRepository, ReportRepository reportRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.reportRepository = reportRepository;
    }


    @GetMapping("/")
    public String home(){      
        return "home";
    }


    @PostMapping("/interest")
    public ModelAndView interest(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("phone") String phone){
        
        // Adicionando true para interresse do carro
        Car car = carRepository.getReferenceById(id);
        car.setInterest();
        carRepository.save(car);
        
        Report report = new Report(Long.parseLong(Integer.toString(car.getID())), name, phone);
        reportRepository.save(report);

        ModelAndView modelAndView = new ModelAndView("interest");
        return modelAndView;
    }
    
}

