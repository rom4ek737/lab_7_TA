package com.epam.lab7.hw2.parsers;

import com.epam.lab7.hw2.Parser;
import com.epam.lab7.hw2.PropertySettings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVParser implements Parser {

    private String splitBy = ",";
    private String line = "";
    private String[] userData;
    private static String csvFile = PropertySettings.openPropertyFile("csv-file");

    @Override
        public Iterator<Object []> parse() throws IOException {
        List<Object []> testCases = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                userData = line.split(splitBy);
                testCases.add(userData);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return testCases.iterator();
    }
}
