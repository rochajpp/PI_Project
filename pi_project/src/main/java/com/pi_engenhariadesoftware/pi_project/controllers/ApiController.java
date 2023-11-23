package com.pi_engenhariadesoftware.pi_project.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi_engenhariadesoftware.pi_project.entities.Car;
import com.pi_engenhariadesoftware.pi_project.entities.Report;
import com.pi_engenhariadesoftware.pi_project.entities.User;
import com.pi_engenhariadesoftware.pi_project.repositories.CarRepository;
import com.pi_engenhariadesoftware.pi_project.repositories.ReportRepository;
import com.pi_engenhariadesoftware.pi_project.repositories.UserRepository;

@RestController
@RequestMapping("/api")
public class ApiController {

    private CarRepository carRepository;
    private UserRepository userRepository;
    private ReportRepository reportRepository;

    public ApiController(CarRepository carRepository, UserRepository userRepository, ReportRepository reportRepository){
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.reportRepository = reportRepository;
    }
    
    @GetMapping("/getCars")
    public List<Car> listCars(){
        return carRepository.findAll();
    }

    @GetMapping("/getUsers")
    public List<User> listUsers(){
        return userRepository.findAll();
    }
}

