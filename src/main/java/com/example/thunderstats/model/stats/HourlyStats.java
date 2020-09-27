package com.example.thunderstats.model.stats;

import com.example.thunderstats.model.Email;

import java.util.List;
import java.util.Map;

public class HourlyStats extends AbstractTwoParamStats {


    public Map<String, Map<String, Integer>> getStats() {
        return super.getStats();
    }

    @Override
    public void create(List<Email> emails, String senderEmailAddress) {

        emails.forEach(email -> {
            String sentOrReceived = "Received";
            if(email.getFrom().equalsIgnoreCase(senderEmailAddress)) sentOrReceived = "Sent";
            super.increaseStat(getHour(email.getTime()), sentOrReceived);
        });
    }

    private String getHour(String s){
        String[] time = s.trim().split(":");
        if(time.length == 3) return time[0];
        return s;
    }
}
