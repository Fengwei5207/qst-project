package com.edu.qst.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.qst.bean.Student;
import com.edu.qst.bean.StudentAndScoreVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> getStu234();
    List<Map<String, Object>> getScoreAndGradeByName(@Param("name") String name);


    List<Map<String, Object>> getAllStuInfoAndScoreInfo();

    List<Map<String, Object>> getAllStuScore();
}
