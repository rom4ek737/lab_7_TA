package com.epam.lab7.hw3;

import com.epam.lab7.hw3.parsers.XLSParser;
import jxl.read.biff.BiffException;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Iterator;

public class DataproviderClass {

    @DataProvider(name = "provider-data", parallel = true)
    public static Iterator<Object []> userData() throws IOException, BiffException{
//        CSVParser csvParser = new CSVParser();
//        return csvParser.parse();
        XLSParser xlsParser = new XLSParser();
        return xlsParser.parse();
    }
}
