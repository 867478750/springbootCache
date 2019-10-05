package com.nlb.springbootcache.controller;

import com.nlb.springbootcache.bean.Employee;
import com.nlb.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @ResponseBody
    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @ResponseBody
    @PostMapping("/emp/{id}")
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestParam("did") Integer did){
        Employee emp = new Employee();
        emp.setId(id);
        emp.setdId(did);
        emp.setEmail("ttt");
        emp.setGender(1);
        emp.setLastName("dd");
        return employeeService.updateEmployee(emp);

    }
}
