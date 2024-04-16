package com.qa.orgchart.stepDefinitions;

import com.gemini.generic.exception.GemException;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import net.serenitybdd.core.annotations.events.BeforeExample;
import net.serenitybdd.core.annotations.events.BeforeScenario;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;

public class Hook {
//    @BeforeAll
//    public static void beforeAll() throws GemException {
//        System.out.println("Before Suite");
//        DriverManager.setUpBrowser();
//        DriverAction.waitSec(5);
//        DriverManager.closeDriver();
//    }


    @Before
    public void setup() throws GemException {
        DriverManager.setUpBrowser();
    }


}
