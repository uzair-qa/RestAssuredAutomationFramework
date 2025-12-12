package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

    /**
     * Returns a trimmed String representation of the cell.
     * Safely handles numeric/date/boolean/formula/blank cells.
     * Returns empty string if sheet/row/cell is missing or on error.
     */
    public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo) {
        FileInputStream inputStream = null;
        XSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
            XSSFSheet excelSheet = workBook.getSheet(sheetName);
            if (excelSheet == null) {
                // sheet not found
                return "";
            }

            if (excelSheet.getRow(rowNo) == null) {
                // row missing
                return "";
            }

            Cell cell = excelSheet.getRow(rowNo).getCell(cellNo);
            if (cell == null) {
                return "";
            }

            DataFormatter formatter = new DataFormatter();
            String value = formatter.formatCellValue(cell);
            return value == null ? "" : value.trim();

        } catch (Exception e) {
            // replace with proper logger if available
            e.printStackTrace();
            return "";
        } finally {
            try {
                if (workBook != null) workBook.close();
                if (inputStream != null) inputStream.close();
            } catch (IOException ignore) {
            }
        }
    }

    public static int getRowCount(String fileName, String sheetName) {
        FileInputStream inputStream = null;
        XSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
            XSSFSheet excelSheet = workBook.getSheet(sheetName);
            if (excelSheet == null) return 0;
            // lastRowNum is zero-based; add 1 to get count
            int ttlRows = excelSheet.getLastRowNum() + 1;
            return ttlRows;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                if (workBook != null) workBook.close();
                if (inputStream != null) inputStream.close();
            } catch (IOException ignore) {
            }
        }
    }

    public static int getColCount(String fileName, String sheetName) {
        FileInputStream inputStream = null;
        XSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
            XSSFSheet excelSheet = workBook.getSheet(sheetName);
            if (excelSheet == null || excelSheet.getRow(0) == null) return 0;
            int ttlCells = excelSheet.getRow(0).getLastCellNum(); // returns short as int
            return ttlCells;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                if (workBook != null) workBook.close();
                if (inputStream != null) inputStream.close();
            } catch (IOException ignore) {
            }
        }
    }
}
