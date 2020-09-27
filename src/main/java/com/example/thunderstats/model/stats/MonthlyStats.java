package com.example.thunderstats.model.stats;

import com.example.thunderstats.model.Email;

import java.util.List;
import java.util.Map;

public class MonthlyStats extends AbstractTwoParamStats {

    public Map<String, Map<String, Integer>> getStats() {
        return super.getStats();
    }
    @Override
    public void create(List<Email> emails, String senderEmailAddress) {

        emails.forEach(email -> {
            String sentOrReceived = "Received";
            if(email.getFrom().equalsIgnoreCase(senderEmailAddress)) sentOrReceived = "Sent";
            super.increaseStat(getMonth(email.getDate()), sentOrReceived);
        });
    }

    private String getMonth(String s){
        String[] date = s.trim().split(" ");
        if(date.length == 3) return date[1];
        return s;
    }
}
