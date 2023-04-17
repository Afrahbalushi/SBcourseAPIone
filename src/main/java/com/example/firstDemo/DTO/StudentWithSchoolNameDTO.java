package com.example.firstDemo.DTO;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithSchoolNameDTO {

    String schoolName;
    String studentName;
    String rollNumber;
}
