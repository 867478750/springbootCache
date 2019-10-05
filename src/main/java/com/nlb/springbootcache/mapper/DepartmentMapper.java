package com.nlb.springbootcache.mapper;

import com.nlb.springbootcache.bean.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id= #{id}")
    public Department getDept(Integer id);
}
