package com.example.firstDemo.Controller;


import com.example.firstDemo.Models.School;
import com.example.firstDemo.RequestObjects.SchoolRequestForCreateDateUpdate;
import com.example.firstDemo.Services.ReportService;
import com.example.firstDemo.Services.SchoolService;
import com.example.firstDemo.Slack.SlackClient;
import com.github.exerrk.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {


    @Autowired
    SchoolService schoolService;

    @Autowired
    SlackClient slackClient;

    @Autowired
    ReportService reportService;

    //localhost:8080/school/getAll

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> schools = new ArrayList<>();
        schools = schoolService.getAllSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
        return schools;
    }


    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());

        return school;
    }

    @RequestMapping(value = "getByName")
    public School getSchoolByName(@RequestParam String schoolName) {
        School school = schoolService.getSchoolByName(schoolName);
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
        return school;
    }

    @RequestMapping(value = "getAllSchoolByIsActive")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(activeSchoolsList).toString());
        return activeSchoolsList;
    }

    @RequestMapping(value = "updateCreatedDateByUserInput")
    public void setCreatedDateByUserInput(@RequestBody SchoolRequestForCreateDateUpdate data)
            throws ParseException {
        schoolService.setCreatedDateByUserInput(data.getDate(), data.getId());

    }

    @RequestMapping(value = "getSchoolByNumberOfStudent")
    public List<School> getSchoolByNumberOfStudent(@RequestParam Integer numberOfStudent) {
        List<School> schoolList=schoolService.getSchoolByNumberOfStudent(numberOfStudent);
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schoolList).toString());
        return schoolList;
    }

    @RequestMapping(value = "report")
    public String generateSchoolsReport() throws JRException, FileNotFoundException {
        return reportService.generateReport();
    }


}
