package com.edu.qst.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentAndScoreVO {
    private int id;
    private int stuId;
    private String name;
    private String sex;
    private Date birth;
    private String department;
    private String address;
    private String cName;
    private int grade;
}
