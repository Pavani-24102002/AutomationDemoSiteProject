package com.AutomationDemosite.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.FileWriter;
import java.io.IOException;

public class CustomReportListener implements ITestListener {
    private FileWriter writer;

    public CustomReportListener() {
        try {
            writer = new FileWriter("test-summary.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        write("PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        write("FAILED: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        write("Total tests run: " + context.getAllTestMethods().length +
              ", Passed: " + context.getPassedTests().size() +
              ", Failed: " + context.getFailedTests().size() +
              ", Skipped: " + context.getSkippedTests().size());
        try { writer.close(); } catch (IOException e) { e.printStackTrace(); }
    }

    private void write(String line) {
        try {
            writer.write(line + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
