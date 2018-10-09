package com.epam.lab7.hw3;

import jxl.read.biff.BiffException;

import java.io.IOException;
import java.util.Iterator;

public interface Parser {
    public Iterator<Object []> parse() throws IOException, BiffException;
}
