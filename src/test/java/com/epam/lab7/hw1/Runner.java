package com.epam.lab7.hw1;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src\\test\\resources",
        format = {"pretty", "html:target/cucumber"}
)

public class Runner {
}
