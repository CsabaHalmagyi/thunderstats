package com.example.thunderstats.service;

import com.example.thunderstats.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {


    private MailReaderService mailReaderService;

    private List<Email> emails;
    private String senderEmailAddress;
    private String mailDir;

    private boolean initialized;


    @Autowired
    public MailService(MailReaderService mailReaderService) {
        this.mailReaderService = mailReaderService;
        this.initialized = false;
    }

    public boolean init(String mailDir, String senderEmailAddress){
        this.mailDir = mailDir;
        this.senderEmailAddress = senderEmailAddress;
        emails = mailReaderService.read(mailDir);
        initialized = true;
        return true;
    }








    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public String getSenderEmailAddress() {
        return senderEmailAddress;
    }

    public void setSenderEmailAddress(String senderEmailAddress) {
        this.senderEmailAddress = senderEmailAddress;
    }

    public String getMailDir() {
        return mailDir;
    }

    public void setMailDir(String mailDir) {
        this.mailDir = mailDir;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }
}
