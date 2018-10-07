package com.epam.lab7.hw2.parsers;

import com.epam.lab7.hw2.Parser;
import com.epam.lab7.hw2.PropertySettings;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XLSParser implements Parser {

    private static String xlsFile = PropertySettings.openPropertyFile("xls-file");
    private static String sheet = PropertySettings.openPropertyFile("sheet");

    @Override
    public Iterator<Object[]> parse() throws IOException, BiffException {
        List<Object[]> testCases = new ArrayList<>();
        try (FileInputStream fs = new FileInputStream(xlsFile)) {
            Workbook wb = Workbook.getWorkbook(fs);
            Sheet sh = wb.getSheet(sheet);
            int totalNoOfRows = sh.getRows();
            for (int i = 0; i < totalNoOfRows; i++) {
                String[] userData = new String[2];
                userData[0] = sh.getCell(0, i).getContents();
                userData[1] = sh.getCell(1, i).getContents();
                testCases.add(userData);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return testCases.iterator();
    }
}
