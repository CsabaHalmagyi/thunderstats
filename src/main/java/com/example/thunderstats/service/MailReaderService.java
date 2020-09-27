package com.example.thunderstats.service;

import com.example.thunderstats.model.Email;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * This service is responsible for reading the .eml files from the given directory and pass them to the eml file parser.
 */
@Service
public class MailReaderService {

    private MailParserService mailParserService;
    private List<Email> emailList = null;


    public MailReaderService() {
        this.mailParserService = new MailParserService();

    }

    public List<Email> read(String emlDirUri) {

        this.emailList = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get(emlDirUri))) {
            List<Path> result = paths.filter(f->f.toString().endsWith(".eml")).collect(Collectors.toList());
            result
            .forEach(path-> readEmlFile(path));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return emailList;
    }


    private void readEmlFile(Path path){
        File file = new File(String.valueOf(path.toFile()));
        Email email = new Email();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                mailParserService.parse(email, line);
                if(email.isComplete()) break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        emailList.add(email);
    }

}
