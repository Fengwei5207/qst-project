package com.edu.qst.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.qst.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> getStu234();
}
