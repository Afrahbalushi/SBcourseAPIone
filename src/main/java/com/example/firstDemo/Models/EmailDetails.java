package com.example.firstDemo.Models;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailDetails {
    private List<String> recipient;
    private String msgBody;
    private String subject;
    private String attachment;

}