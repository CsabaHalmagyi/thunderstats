package com.example.thunderstats.model.stats;

import com.example.thunderstats.model.Email;

import java.util.List;

public class ReceivedFromStats extends AbstractOneParamStats {


    @Override
    public void create(List<Email> emails, String senderEmailAddress) {
        emails.forEach(email -> super.increaseStat(email.getFrom())
        );
    }
}
