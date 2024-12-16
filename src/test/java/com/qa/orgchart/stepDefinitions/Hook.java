package com.qa.orgchart.stepDefinitions;

import com.gemini.gemjar.exception.GemException;
import com.gemini.gemjar.utils.ui.DriverManager;
import io.cucumber.java.Before;

public class Hook {
    @Before
    public void setup() throws GemException {
        DriverManager.setUpBrowser();
    }
}
