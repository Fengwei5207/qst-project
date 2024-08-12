package com.edu.qst.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    private int id;
    private int stuId;
    private String cName;
    private int grade;
}
