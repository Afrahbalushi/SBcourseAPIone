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
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\schools.pdf");
        return "Report generated : " + pathToReports+"\\schools.pdf";
    }

    public String generateReportForStudentSchoolDto() throws FileNotFoundException, JRException {
        List<Student> studentsList = studentRepository.findAll();
        List<StudentSchoolDTO> studentSchoolDTO = new ArrayList<>();

        for (Student studentObject: studentsList) {
            StudentSchoolDTO dto = new StudentSchoolDTO();
            dto.setStudentId(studentObject.getId());
            dto.setSchoolId(studentObject.getSchool().getId());
            dto.setSchoolName(studentObject.getSchool().getName());
            dto.setStudentName(studentObject.getName());

            studentSchoolDTO.add(dto);
        }

        File file = ResourceUtils.getFile("classpath:Student_School.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentSchoolDTO);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\schools.pdf");
        return "Report generated : " + pathToReports+"\\schools.pdf";
    }

    public String generateReportForStudentWithSchoolName() throws Exception{

        List<Student> students = studentRepository.findAll();
        List<StudentWithSchoolNameDTO> studentSchoolNameDtosList = new ArrayList<>();
        for (Student student: students) {

            StudentWithSchoolNameDTO dto = new StudentWithSchoolNameDTO(student.getSchool().getName(),
                    student.getName(),
                    student.getRollNumber());

            studentSchoolNameDtosList.add(dto);
        }

        File file = new File("C:\\Users\\AfrahAlBalushi\\Downloads\\firstDemo\\firstDemo\\src\\main\\resources\\StudentWithSchoolName.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentSchoolNameDtosList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Daniyal");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\studentSchoolReport.pdf");
        return "Report generated : " + pathToReports+"\\studentSchoolReport.pdf";

    }
    public String generateReportForCourseMark() throws Exception{

        List<Mark> mark = markRepository.findAll();
        List<CourseMarkDTO> courseMarkDTOS = new ArrayList<>();
        for (Mark mark1: mark) {

            CourseMarkDTO dto = new CourseMarkDTO(mark1.getCourse().getName(),
                    mark1.getObtainedMarks(),
                    mark1.getGrade());

            courseMarkDTOS.add(dto);
        }

        File file = new File("C:\\Users\\AfrahAlBalushi\\Downloads\\firstDemo\\firstDemo\\src\\main\\resources\\StudentWithSchoolName.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseMarkDTOS);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Daniyal");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\courseMark.pdf");
        return "Report generated : " + pathToReports+"\\courseMark.pdf";

    }
}