package com.nlb.springbootcache.service.impl;

import com.nlb.springbootcache.bean.Department;
import com.nlb.springbootcache.mapper.DepartmentMapper;
import com.nlb.springbootcache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DepartmentMapper departmentMapper;


    @Cacheable(value = "dept")
    @Override
    public Department getDept(Integer id) {
        System.out.println("进入service");
        Department dept = departmentMapper.getDept(id);

        if(dept!=null){
            return dept;
        }else {
            return null;
        }


    }
}
