package com.example.firstDemo.RequestObjects;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class SchoolRequestForCreateDateUpdate {

    String date;
    Integer id;
}