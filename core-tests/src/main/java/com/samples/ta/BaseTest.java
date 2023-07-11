package com.samples.ta;

import org.testng.ITest;

public class BaseTest implements ITest {
    protected String testName;

    @Override
    public String getTestName() {
        return testName;
    }
}
