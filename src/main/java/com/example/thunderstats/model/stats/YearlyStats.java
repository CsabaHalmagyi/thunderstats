package com.example.thunderstats.model.stats;

import com.example.thunderstats.model.Email;

import java.util.List;
import java.util.Map;

public class YearlyStats extends AbstractTwoParamStats {


    public Map<String, Map<String, Integer>> getStats() {
        return super.getStats();
    }

    @Override
    public void create(List<Email> emails, String senderEmailAddress) {

        emails.forEach(email -> {
            String sentOrReceived = "Received";
            if(email.getFrom().equalsIgnoreCase(senderEmailAddress)) sentOrReceived = "Sent";
            super.increaseStat(getYear(email.getDate()), sentOrReceived);
        });
    }

    private String getYear(String s){
        String[] date = s.trim().split(" ");
        if(date.length == 3) return date[2];
        return s;
    }
}
