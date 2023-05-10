package com.example.firstDemo.Services;


import com.example.firstDemo.DTO.CourseMarkDTO;
import com.example.firstDemo.DTO.StudentSchoolDTO;
import com.example.firstDemo.DTO.StudentWithSchoolNameDTO;
import com.example.firstDemo.Models.Mark;
import com.example.firstDemo.Models.School;
import com.example.firstDemo.Models.Student;
import com.example.firstDemo.Repository.MarkRepository;
import com.example.firstDemo.Repository.SchoolRepository;
import com.example.firstDemo.Repository.StudentRepository;
import com.github.exerrk.engine.*;
import com.github.exerrk.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    public static final String pathToReports = "C:\\Users\\AfrahAlBalushi\\Downloads\\firstDemo";

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    MarkRepository markRepository;

    @Autowired
    StudentRepository studentRepository;

    public String generateReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools();

        File file = ResourceUtils.getFile("classpath:School_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\schools.pdf");
        return "Report generated : " + pathToReports + "\\schools.pdf";
    }




}