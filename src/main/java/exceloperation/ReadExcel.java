package exceloperation;

/**
 * @author PC
 */

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public static String getDataCell(String filePath,int column, int row){
        Workbook wb= readExcel(filePath);
        Sheet sheet=wb.getSheetAt(0);
        int rowNum=sheet.getPhysicalNumberOfRows();
        Row row1 = null;
        String result=null;
        if(wb!=null){
            row1=sheet.getRow(row-1);
            if(row1!=null){
                result=(String) getCellFormatValue(row1.getCell(column-1));
            }
        }
        return result;

    }
    public static void setDataCell(String data,String filePath,int row,int col) throws FileNotFoundException {
        Workbook wb =readExcel(filePath);
        Sheet sheet=wb.getSheetAt(0);
        Row row1 = sheet.getRow(row - 1);
        Cell cell = row1.getCell(col - 1);
        if(cell==null){
            cell=row1.createCell(col-1);
        }
        cell.setCellValue(data);

        try {
            File file=new File("src/main/resources/test.xlsx");
            FileOutputStream fos =new FileOutputStream(file);
            wb.write(fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }
    public static Object getCellFormatValue(Cell cell){
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
                case NUMERIC:{
                    //将数值型cell设置为string型
                    cell.setCellType(CellType.STRING);
                    cellValue = cell.getStringCellValue();
                    break;
                }
                case FORMULA:{
                    //判断cell是否为日期格式
                    if(DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }
}
