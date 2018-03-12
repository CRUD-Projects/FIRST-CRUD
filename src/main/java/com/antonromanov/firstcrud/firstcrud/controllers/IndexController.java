package com.antonromanov.firstcrud.firstcrud.controllers;

import com.antonromanov.firstcrud.firstcrud.Services.EmployeeService;
import com.antonromanov.firstcrud.firstcrud.model.Employee;
import com.antonromanov.firstcrud.firstcrud.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Date;
import java.time.*;

@Controller
public class IndexController {


    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeservice;


    @RequestMapping("/")
    public ModelAndView doHome() {

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("lists3", employeeservice.failedInSub());

        return mv;

    }

    @RequestMapping(value = "/fire/{id}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("id") int id) {

        Employee employee;

        Instant instant = Instant.now();
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);
        LocalDate localDate = zdt.toLocalDate();

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = Date.valueOf(localDate);


        employee = (Employee) employeeRepository.findOne(id);

        System.out.println("Я зашла и получила ID - " + id);
        System.out.println("Я вытащила по id такого юзера -  " + employee.getName());
        System.out.println("Сегодня =  " + sqlDate);

        ModelAndView mv = new ModelAndView("redirect:/");
        employee.setDateHired(sqlDate);
        employeeRepository.save(employee);


        return mv;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView doEdit(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("lists", employeeRepository.findOne(id));
        return mv;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("id") String id, @RequestParam("name") String EmplName, @RequestParam("phone") String EmpPhone, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("dateHired") LocalDate startDate) {
        ModelAndView mv = new ModelAndView("redirect:/");
        Employee employee;


        if (!id.isEmpty()) {
            employee = (Employee) employeeRepository.findOne(Integer.parseInt(id));
        } else {
            employee = new Employee();
        }


        if (startDate == null) {
            startDate = LocalDate.now();
        }

        employee.setName(EmplName);
        employee.setPhone(EmpPhone);
        Date dateHi = Date.valueOf(startDate);
        employee.setDateHired(dateHi);

        employeeRepository.save(employee);
        return mv;
    }

}
