package com.nlb.springbootcache;

import com.nlb.springbootcache.bean.Employee;
import com.nlb.springbootcache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootcacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;//k-v都是字符串的

    @Autowired
    RedisTemplate redisTemplate;//k-v都是对象

    @Resource(name = "EmpRedisTemplate")
    RedisTemplate EmpRedisTemplate;

    @Test
    public void test01(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("nlb");
        employee.setGender(1);
        employee.setdId(1);
        employee.setEmail("nlb@163.com");
        EmpRedisTemplate.opsForValue().set("name",employee);

    }



    @Test
    public void contextLoads() {
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById.toString());
    }

}
