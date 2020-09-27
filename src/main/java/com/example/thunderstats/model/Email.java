package com.example.thunderstats.model;

import org.springframework.util.StringUtils;

public class Email {

    private String from;
    private String to;
    private String date;
    private String day;
    private String time;
    private String subject;
    private String body;


    public Email() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isComplete(){

        if(!StringUtils.isEmpty(from) &&
                !StringUtils.isEmpty(to) &&
                !StringUtils.isEmpty(date) &&
                !StringUtils.isEmpty(day) &&
                !StringUtils.isEmpty(time)
        ) return true;
        return false;
    }

    @Override
    public String toString() {
        return "{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date='" + date + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
