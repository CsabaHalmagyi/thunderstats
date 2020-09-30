package com.example.thunderstats.model.stats;

import com.example.thunderstats.model.Email;

import java.util.List;

public class SentToStats extends AbstractOneParamStats {


    @Override
    public void create(List<Email> emails, String senderEmailAddress) {
        emails.forEach(email -> {
            if (email != null &&
                    email.getTo() != null &&
                    !email.getTo().equalsIgnoreCase(senderEmailAddress) &&
                    email.getFrom().equalsIgnoreCase(senderEmailAddress))
            super.increaseStat(email.getTo());
        });
    }
}
