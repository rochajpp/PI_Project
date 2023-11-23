package com.pi_engenhariadesoftware.pi_project.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.pi_engenhariadesoftware.pi_project.Services.CookieService;
import com.pi_engenhariadesoftware.pi_project.entities.Car;
import com.pi_engenhariadesoftware.pi_project.entities.Report;
import com.pi_engenhariadesoftware.pi_project.entities.User;
import com.pi_engenhariadesoftware.pi_project.repositories.CarRepository;
import com.pi_engenhariadesoftware.pi_project.repositories.ReportRepository;
import com.pi_engenhariadesoftware.pi_project.repositories.UserRepository;

import org.springframework.ui.Model;

import jakarta.persistence.criteria.Path;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AdminController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReportRepository reportRepository;


    
    @GetMapping("/admin")
    public String admin(HttpServletRequest request, Model model) throws UnsupportedEncodingException{
        String id = CookieService.getCookie(request, "userId");
        model.addAttribute("id", id);

        return "admin";
    }

    @GetMapping("/backCar")
    public String backCar(String idCar){
        Long id = Long.parseLong(idCar);
        Car car = carRepository.getReferenceById(id);

        car.setInterest();

        carRepository.save(car);

        return "redirect:/admin";
    }

    @GetMapping("/rmCar")
    public String rmCar(String idCar){

        Long id = Long.parseLong(idCar);

        carRepository.deleteById(id);

        return "redirect:/admin";
    }

    @GetMapping("/setCar")
    public String setCar(String idCar, Model model){
        Car car = carRepository.getReferenceById(Long.parseLong(idCar));

        model.addAttribute("id", idCar);
        model.addAttribute("brand", car.getBrand());
        model.addAttribute("model", car.getModel());
        model.addAttribute("value", car.getValue());
        model.addAttribute("description", car.getDescription());
        model.addAttribute("image", car.getImage());
        model.addAttribute("manufactureYear", car.getManufactureYear());
        model.addAttribute("modelYear", car.getModelYear());

        return "setCar";
    }
    
    @PostMapping("/setCarSys")
    public String setCarSys(Car car, @RequestParam("id") String id, @RequestParam("file") MultipartFile file, Model model){
        Car carUp = carRepository.getReferenceById(Long.parseLong(id));
        
        carUp.setBrand(car.getBrand());
        carUp.setModel(car.getModel());
        carUp.setValue(car.getValue());
        carUp.setDescription(car.getDescription());
        carUp.setManufactureYear(car.getManufactureYear());
        carUp.setModelYear(car.getModelYear());

        if(!file.isEmpty()){
            String fileName = file.getOriginalFilename();        
            String dirProject = System.getProperty("user.dir");

            try{
                String dirUploadImage = dirProject + "\\pi_project\\src\\main\\resources\\static\\img";
                File dir = new File(dirUploadImage);
                if(!dir.exists()){
                    dir.mkdirs();
                }

                File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

                stream.write(file.getBytes());
                stream.close();

                carUp.setImage("/img/" + fileName);             

            } catch(Exception e){   
                model.addAttribute("error", "Image error!");  
                return "setCar?idCar=" + car.getID();
            }         
        }    
        carRepository.save(carUp);
        return "redirect:/admin";
    }

    @GetMapping("/addCar")
    public String addCar(){
        return "addCar";
    }

    @PostMapping("/saveCar")
    public String saveCar(Car car, @RequestParam("file") MultipartFile file, Model model){
        System.out.println(car.getManufactureYear());
         if(!file.isEmpty()){
            String fileName = file.getOriginalFilename();        
            String dirProject = System.getProperty("user.dir");

            try{
                String dirUploadImage = dirProject + "\\pi_project\\src\\main\\resources\\static\\img";
                File dir = new File(dirUploadImage);
                if(!dir.exists()){
                    dir.mkdirs();
                }

                File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

                stream.write(file.getBytes());
                stream.close();            

            } catch(Exception e){   
                model.addAttribute("error", "Image error!");  
                return "/addCar";     
            }

            car.setImage("/img/" + fileName);
            car.setRegisterDate(LocalDate.now());

            carRepository.save(car);

            return "redirect:/admin";
        }

        return "/addCar";
    }

    @GetMapping("/alterUser")
    public String alterUser(String id, Model model){
        User user = userRepository.getReferenceById(Long.parseLong(id));
        String active = null;

        if(user.getActive()){
            active = "true";
        }

        model.addAttribute("id", id);
        model.addAttribute("login", user.getLogin());
        model.addAttribute("name", user.getName());
        model.addAttribute("active", user.getActive());
        model.addAttribute("birthdate", user.getBirthDate());
        model.addAttribute("registerdate", user.getRegisterDate());

        return "alterUser";
    }

    @PostMapping("/setUser")
    public String setUser(User user, @RequestParam("id") String id, Model model){
        User userUp = userRepository.getReferenceById(Long.parseLong(id));

        userUp.setLogin(user.getLogin());
        userUp.setName(user.getName());;
        if(user.getActive() != null){
            userUp.setActive(true);
        }else{
            userUp.setActive(false);
        }
        userUp.setBirthDate(user.getBirthDate());
        userUp.setRegisterDate(user.getBirthDate());

        userRepository.save(userUp);
    
        return "redirect:/admin";
    }

    @GetMapping("/addUser")
    public String addUser(){
        return "addUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(User userParam, Model model){
        User existUser = userRepository.checkLogin(userParam.getLogin());

        if(existUser != null){
            model.addAttribute("error", "Login already exists!");
            return "addUser";
        }

        userParam.setActive(true);
        userParam.setRegisterDate(LocalDate.now());

        userRepository.save(userParam);

        return "redirect:/admin";
    }

    @GetMapping("/removeUser")
    public String removeUser(Long id){
        
        userRepository.deleteById(id);

        return "redirect:/admin";
    }

    @GetMapping("/report")
    protected void repor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Document document = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "report.pdf");
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			document.add(new Paragraph("Interest List:"));
			document.add(new Paragraph(" "));
			PdfPTable table = new PdfPTable(5);
            PdfPCell col = new PdfPCell(new Paragraph("Id Car"));
			PdfPCell col1 = new PdfPCell(new Paragraph("Car"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Client"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Phone"));
            PdfPCell col4 = new PdfPCell(new Paragraph("Date"));
            table.addCell(col);
			table.addCell(col1);
			table.addCell(col2);
			table.addCell(col3);
            table.addCell(col4);
			List<Report> list = reportRepository.findAll();
       
			for (int i = 0; i < list.size(); i++) {       
                table.addCell(Long.toString(list.get(i).getIdCar()));
				table.addCell(carRepository.getReferenceById(list.get(i).getIdCar()).getBrand() + " - " + carRepository.getReferenceById(list.get(i).getIdCar()).getModel());
				table.addCell(list.get(i).getNameClient());
				table.addCell(list.get(i).getPhoneClient());
                table.addCell((list.get(i).getRegisterDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
			}
			document.add(table);
			document.close();
		} catch (Exception e) {
			System.out.println(e);
			document.close();
		}
	}
    
}
