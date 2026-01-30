package com.AutomationDemosite.utils;

import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ExcelUtil {
    private static Workbook workbook = new XSSFWorkbook();
    private static Sheet sheet = workbook.createSheet("TestResults");
    private static int rowCount = 0;
    private static final Logger log = LoggerUtil.getLogger(ExcelUtil.class);

    public static void writeResult(String step, String message) {
        log.info("Writing result - Step: {}, Message: {}", step, message);
        Row row = sheet.createRow(rowCount++);
        row.createCell(0).setCellValue(step);
        row.createCell(1).setCellValue(message);
    }

    public static void saveExcel(Properties prop) {
        String filePath = prop.getProperty("excel.output.path", "TestResults.xlsx");
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            workbook.close();
            log.info("Excel saved to: {}", filePath);
        } catch (IOException e) {
            log.error("Error saving Excel file", e);
        }
    }
}

