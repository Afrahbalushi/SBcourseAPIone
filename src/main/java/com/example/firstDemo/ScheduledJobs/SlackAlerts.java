package com.example.firstDemo.ScheduledJobs;

import com.example.firstDemo.Models.School;
import com.example.firstDemo.Services.SchoolService;
import com.example.firstDemo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class SlackAlerts {

    @Autowired
    SlackClient slackClient;

    @Autowired
    SchoolService schoolService;

    @Scheduled(cron = "* * * * 1 *")
    public void alertSlack() {
        slackClient.sendMessage("<!here> *Technical Session @ 1, Lunch will be there* + time:" + new Date());
    }

    @Scheduled(cron = "* * * * 1 *")
    public void getSchoolByNameAlert() {
        List<School> schoolList = schoolService.getAllSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schoolList).toString());
    }

    @Scheduled(cron = "* * * * 1 *")
    public void getSchoolByIdAlert(){
        School school = schoolService.getSchoolById(1);
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
    }
}
