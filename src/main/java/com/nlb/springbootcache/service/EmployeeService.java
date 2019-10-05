package com.nlb.springbootcache.service;

import com.nlb.springbootcache.bean.Employee;

public interface EmployeeService {
    Employee getEmployee(Integer id);

    Employee updateEmployee(Employee employee);
}
