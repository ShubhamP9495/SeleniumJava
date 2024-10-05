package com.PracticeTest.app.utilities;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelUtilityReader {
    public static XSSFSheet ExcelWSheet;
    public static XSSFWorkbook ExcelWBook;
    public static XSSFCell Cell;
    public static XSSFRow Row;

    public static void setExcelfile(String path , String sheetName) throws Exception
    {
        try
        {
            FileInputStream FIS = new FileInputStream(path);
            ExcelWBook = new XSSFWorkbook(FIS);
            ExcelWSheet = ExcelWBook.getSheet(sheetName);
        }
        catch (Exception e)
        {
            throw (e);
        }
    }

    public static String getStringCellData(int RowNum , int ColNum) throws Exception
    {
        Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
        String cellData="";
        if(Cell != null){
            if (Cell.getCellTypeEnum() == CellType.NUMERIC) {
                cellData = Double.toString(Cell.getNumericCellValue());
                if (cellData.contains("E7")) {
                    BigDecimal bigDecimal = new BigDecimal(cellData);// form to BigDecimal
                    cellData = bigDecimal.toString();// get the String value
                    return cellData;
                }
                else if (DateUtil.isCellDateFormatted(Cell)) {
                    Date CellData = Cell.getDateCellValue();
                    String pattern = "yyyy-MM-dd";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                    String date = simpleDateFormat.format(CellData);
                    return date;
                }
                else {
                    String numericCellData = String.valueOf(Cell.getNumericCellValue());
                    return numericCellData;
                }
            } else if (Cell.getCellTypeEnum() == CellType.STRING) {
                cellData = Cell.getStringCellValue();
                return cellData;
            } else if (Cell.getCellTypeEnum() == CellType.FORMULA) {
                cellData = String.valueOf(Cell.getNumericCellValue());
                return cellData;
            } else {
                return Cell.getStringCellValue();
            }
        }
        else {
            return cellData;
        }
    }

    public static Double getNumericCellDataValue(int RowNum , int ColNum)throws IOException
    {
        Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
        Double numericCellData = 0.0;
        if(Cell != null) {
            numericCellData = (double) Cell.getNumericCellValue();
        }
        else {
            Reporter.log("There is no value in the cell, hence printing the default value");
            numericCellData = 0.0;
        }
        return numericCellData;
    }

    public static Serializable getNumericCellData(int RowNum , int ColNum) throws IOException
    {
        Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
        int cellValue = 0;
        if(Cell != null){
            if (Cell.getCellTypeEnum() == CellType.BLANK) {
                int cellData = Integer.parseInt(Cell.getStringCellValue());
                Reporter.log("There is no value in the cell");
                return cellData;
            } else if (Cell.getCellTypeEnum() == CellType.NUMERIC) {
                if (Cell.getCellStyle().getDataFormatString().contains(".")) {
                    Double value = Cell.getNumericCellValue();
                    return value.intValue();
                }
                else {
                    String numericCellData = Cell.getRawValue();
                    return numericCellData;
                }
            }
        }
        else {
            Reporter.log("There is no value in the cell, hence printing the default value");
            return cellValue;
        }
        return Cell.getNumericCellValue();
    }

    public static void setCellData(String path , String sheetName, String Result, int RowNum, int ColNum) throws Exception
    {
        try
        {
            Row  = ExcelWSheet.getRow(RowNum);
            Cell = Row.getCell(ColNum);
            if (Cell == null)
            {
                Cell = Row.createCell(ColNum);
                Cell.setCellValue(Result);
            }
            else
            {
                Cell.setCellValue(Result);
            }

            FileOutputStream FOS = new FileOutputStream(path);
            ExcelWBook.write(FOS);
            ExcelWSheet = ExcelWBook.getSheet(sheetName);
            FOS.flush();
        }
        catch(Exception e)
        {
            throw (e);
        }
    }
}