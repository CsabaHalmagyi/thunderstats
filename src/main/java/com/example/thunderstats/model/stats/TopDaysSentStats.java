package com.example.thunderstats.model.stats;

import com.example.thunderstats.model.Email;

import java.util.List;

public class TopDaysSentStats extends AbstractOneParamStats {


    @Override
    public void create(List<Email> emails, String senderEmailAddress) {
        emails.forEach(email -> {
            if (email != null &&
                    email.getDate() != null &&
                    email.getFrom().equalsIgnoreCase(senderEmailAddress))
                super.increaseStat(email.getDate());
        });
    }
}
