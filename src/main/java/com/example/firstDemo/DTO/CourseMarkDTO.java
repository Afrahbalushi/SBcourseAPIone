package com.example.firstDemo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class CourseMarkDTO {

    String courseName;
    Integer obtainedMarks;
    String grade;



}
