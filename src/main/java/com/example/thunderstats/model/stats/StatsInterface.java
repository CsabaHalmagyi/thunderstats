package com.example.thunderstats.model.stats;

import com.example.thunderstats.model.Email;
import java.util.List;

public interface StatsInterface {
    void create(List<Email> emails, String senderEmailAddress);
}
