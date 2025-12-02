package Utilities;

import com.sun.rowset.internal.Row;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {


    public static List<Map<String, String>> readSheetAsMap(String filePath, String sheetName) {

        List<Map<String, String>> rows = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook wb = new XSSFWorkbook(fis)) {

            Sheet sheet = wb.getSheet(sheetName);
            if (sheet == null) return rows;

            Row header = sheet.getRow(0);
            if (header == null) return rows;

            int lastCol = header.getLastCellNum();
            DataFormatter formatter = new DataFormatter();

            for (int r = 1; r <= sheet.getLastRowNum(); r++) {

                Row row = sheet.getRow(r);
                if (row == null) continue;

                Map<String, String> map = new HashMap<>();

                for (int c = 0; c < lastCol; c++) {

                    String key = formatter.formatCellValue(header.getCell(c));
                    String val = formatter.formatCellValue(row.getCell(c));

                    map.put(key, val);
                }

                rows.add(map);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read excel file: " + filePath, e);
        }

        return rows;
    }
}