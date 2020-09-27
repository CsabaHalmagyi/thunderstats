package com.example.thunderstats.service;

import com.example.thunderstats.model.Email;
import com.example.thunderstats.service.parser.DateParser;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * This service parses an .eml file line by line and initializes an Email object.
 */
@Service
public class MailParserService {

    private DateParser dateParser;

    public MailParserService() {
        dateParser = new DateParser();
    }



    public void parse(Email email, String line) {

        if(email == null) email = new Email();

        if(line.startsWith("From:") && StringUtils.isEmpty(email.getFrom())){
            String[] lineArr = line.split(":");
            email.setFrom(getEmailFromString(lineArr[1]));
        }
        else if(line.startsWith("To:") && StringUtils.isEmpty(email.getTo())){
            String[] lineArr = line.split(":");
            email.setTo(getEmailFromString(lineArr[1]));
        }
        else if(line.startsWith("Date:") && StringUtils.isEmpty(email.getDate())){
            String date = line.substring(6);

            dateParser.parse(email, date);
        }
    }


    private String getEmailFromString(String emailString){

        if(StringUtils.isEmpty(emailString)) return "";

        emailString = emailString.toLowerCase();
        String s = "";
        if(emailString.contains("<") && emailString.contains(">")){
            s = emailString.substring(emailString.indexOf("<") + 1);
            s = s.substring(0, s.indexOf(">"));
        }


        if(StringUtils.isEmpty(s)) return emailString.trim();
        return s.trim();

    }

}
