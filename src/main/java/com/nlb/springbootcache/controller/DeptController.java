package com.nlb.springbootcache.controller;

import com.nlb.springbootcache.bean.Department;
import com.nlb.springbootcache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.cache.CacheManager;

@Controller
public class DeptController {
    @Autowired
    DeptService deptService;

    @Resource(name = "CacheEmp")
    RedisCacheManager cacheManager;
    @ResponseBody
    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        Department dept = deptService.getDept(id);
        Cache dept1 = cacheManager.getCache("dept");
        Cache.ValueWrapper valueWrapper = dept1.get("1");
        System.out.println(valueWrapper.get());
        return dept;
    }

}
