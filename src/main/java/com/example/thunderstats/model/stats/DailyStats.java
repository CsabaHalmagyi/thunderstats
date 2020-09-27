package com.example.thunderstats.model.stats;

import com.example.thunderstats.model.Email;

import java.util.List;
import java.util.Map;

public class DailyStats extends AbstractTwoParamStats {


    public DailyStats() {
    }

    public Map<String, Map<String, Integer>> getStats() {
        return super.getStats();
    }

    @Override
    public void create(List<Email> emails, String senderEmailAddress){
        emails.forEach(email -> {
            String sentOrReceived = "Received";
            if(email.getFrom().equalsIgnoreCase(senderEmailAddress)) sentOrReceived = "Sent";
            super.increaseStat(email.getDay(), sentOrReceived);
        });
    }



}
