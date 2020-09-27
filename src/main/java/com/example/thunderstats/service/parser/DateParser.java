package com.example.thunderstats.service.parser;

import com.example.thunderstats.model.Email;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class parses a date string and initializes the corresponding fields in the Email object.
 */
public class DateParser {

    public DateParser() {
    }


    public void parse(Email email, String dateString){

        String[] lineArr = dateString.split(",");
        //if the date string doesn't have the day, ie: 23 Jan 2020 12:18:13 +0000
        if(lineArr.length == 1){

            parseDateAndTime(email, lineArr[0]);
            email.setDay(getDayFromDate(email.getDate()));
        }
        //the date string does have the day, ie: Mon, 23 Jan 2020 12:18:13 +0000
        else if(lineArr.length == 2){
            email.setDay(lineArr[0].trim());
            parseDateAndTime(email, lineArr[1]);
        }
    }

    private void parseDateAndTime(Email email, String dateString){
        String[] lineArr2 = dateString.trim().split(" ");
        email.setDate(lineArr2[0] + " " + lineArr2[1] + " " + lineArr2[2]);
        email.setTime(lineArr2[3]);
    }

    private String getDayFromDate(String dateString){
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");

        try {
            Date date = formatter.parse(dateString);
            return new SimpleDateFormat("EE").format(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }


}
