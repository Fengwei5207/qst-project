package com.edu.qst;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.qst.bean.Student;
import com.edu.qst.mapper.ScoreMapper;
import com.edu.qst.mapper.StudentMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class ClassMysqlBoot02ApplicationTests {

    @Resource
    StudentMapper studentMapper;
    @Resource
    ScoreMapper scoreMapper;
    @Test
    void contextLoads() {
    }
    void printList(List<?> objs){
        for (Object obj: objs){
            System.out.println(obj.toString());
        }
    }

//    1. # 查询Student表中所有记录
    @Test
    void getAllStudent(){
        List<Student> students = studentMapper.selectList(new QueryWrapper<>());
        for (Student stu: students){
            System.out.println(stu.toString());
        }
    }
//    2. # 查询Student表中，所有学生的姓名和院系
    @Test
    void getAllStudentNameAndDept(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.select("name","department");
        List<Student> students = studentMapper.selectList(qw);
        printList(students);
    }
//    3. # 查询Student表的信息，按照学生的年龄从大到小排序
    @Test
    void getAllStudentOrderByAgeDesc(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("birth");
        printList(studentMapper.selectList(queryWrapper));
    }

//    4. # 查询Student表的信息，按照学生的年龄从小到大排序
    @Test
    void getAllStudentOrderByAgeAsc(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("birth");
        printList(studentMapper.selectList(queryWrapper));
    }
//    5. 查询Student表中， 叫王五的学生的信息
    @Test
    void getStudentNameWangWu(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.eq("name","王五");
        log.info(studentMapper.selectOne(qw).toString());
    }
//    6. 查询Student表中，来自北京的学生
    @Test
    void getStudentAddressLikeBeijing(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.like("address","北京");
        log.info("京✌️");
        printList(studentMapper.selectList(qw));
    }
//    7. 查询Student表中，来自厦门的学生
    @Test
    void getStudentAddressLikeShaMen(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.like("address","厦门");
        printList(studentMapper.selectList(qw));
    }


//    8. # 查询所有计算机系和英语系的学生的信息
    @Test
    void getStudentFromComputerAndEnglish(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.eq("department","计算机系").or().eq("department","英语系");
        List<Student> students = studentMapper.selectList(qw);
        printList(students);
    }
//    9. # 查询所有计算机系和英语系和化学系的学生的信息


//    10. 查询Student表中， 年龄排第二，第三，第四。 的三个人的信息
    @Test
    void getStudentAge234(){
        List<Student> stu234 = studentMapper.getStu234();
        printList(stu234);
    }
//    11. 查询每个院系有多少人
    @Test
    void getDeptCount(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.select("department","COUNT(*)").groupBy("department");
        List<Map<String, Object>> students = studentMapper.selectMaps(qw);
        printList(students);
    }
//    12. 查询李四的考试科目和考试成绩 13. 用连接的方式查询所有学生的信息和考试信息 14. 计算每个学生的总成绩 15. 计算每个考试科目的平均成绩 16. 查询计算机成绩低于95的学生信息 17. 查询同事参加计算机和英语考试的学生信息 18. 将计算机考试成绩按从高到低进行排序 19. 查询姓张的同学的姓名院系和考试科目及成绩 20. 查询湖南的学生的姓名，年龄，院系和考试科目及成绩




}
