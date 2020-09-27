package com.example.thunderstats.controller;

import com.example.thunderstats.model.chart.BarData;
import com.example.thunderstats.model.stats.DailyStats;
import com.example.thunderstats.model.stats.HourlyStats;
import com.example.thunderstats.model.stats.MonthlyStats;
import com.example.thunderstats.model.stats.YearlyStats;
import com.example.thunderstats.service.MailService;
import com.example.thunderstats.service.StatsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AjaxController {


    private StatsDataService statsDataService;
    private MailService mailService;

    @Autowired
    public AjaxController(StatsDataService statsDataService, MailService mailService) {
        this.statsDataService = statsDataService;
        this.mailService = mailService;
    }

    @PostMapping(value = "/init")
    public int initStats(@RequestParam("dir") String dir, @RequestParam("email") String email){
        mailService.init(dir, email);
        return mailService.getEmails().size();
    }


    @RequestMapping(value = "/dailystats")
    public BarData getDailyStats(){
        DailyStats dailyStats = new DailyStats();
        dailyStats.create(mailService.getEmails(), mailService.getSenderEmailAddress());
        return statsDataService.convertToChartData(dailyStats);
    }

    @RequestMapping(value = "/monthlystats")
    public BarData getMonthlyStats(){
        MonthlyStats monthlyStats = new MonthlyStats();

        monthlyStats.create(mailService.getEmails(), mailService.getSenderEmailAddress());
        return statsDataService.convertToChartData(monthlyStats);
    }

    @RequestMapping(value = "/monthlystats_")
    public MonthlyStats getMonthlyStats_(){
        MonthlyStats monthlyStats = new MonthlyStats();

        monthlyStats.create(mailService.getEmails(), mailService.getSenderEmailAddress());
        return monthlyStats;
    }

    @RequestMapping(value = "/yearlystats")
    public BarData getYearlyStats(){
        YearlyStats yearlyStats = new YearlyStats();

        yearlyStats.create(mailService.getEmails(), mailService.getSenderEmailAddress());
        return statsDataService.convertToChartData(yearlyStats);
    }

    @RequestMapping(value = "/yearlystats_")
    public YearlyStats getYearlyStats_(){
        YearlyStats yearlyStats = new YearlyStats();

        yearlyStats.create(mailService.getEmails(), mailService.getSenderEmailAddress());
        return yearlyStats;
    }

    @RequestMapping(value = "/hourlystats")
    public BarData getHourlyStats(){
        HourlyStats hourlyStats = new HourlyStats();

        hourlyStats.create(mailService.getEmails(), mailService.getSenderEmailAddress());
        return statsDataService.convertToChartData(hourlyStats);
    }

}
