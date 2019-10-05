package com.nlb.springbootcache.service.impl;

import com.nlb.springbootcache.bean.Employee;
import com.nlb.springbootcache.mapper.EmployeeMapper;
import com.nlb.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
//@CacheConfig(cacheNames = "emp")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Cacheable(cacheNames = {"emp"})
    @Override
    public Employee getEmployee(Integer id) {
        System.out.println("进入service");
        return employeeMapper.getEmpById(id);
    }

    @Override
    @CachePut(cacheNames = {"emp"},key = "#result.id")
    public Employee updateEmployee(Employee employee) {
        System.out.println("进入service");
        if(employeeMapper.updateEmp(employee)){
            return employee;
        }else {
            return null;
        }
    }


}
