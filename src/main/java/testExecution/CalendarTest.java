package testExecution;

import calendar.CaculateNextDay;
import exceloperation.ReadExcel;
import triangle.Judge;

public class CalendarTest {
    public final String filePath="src/main/resources/calendarTestCases.xlsx";
    public void executeTestCases(int number){
        int para1=Integer.parseInt(ReadExcel.getDataCell(filePath,2,number+1));
        int para2=Integer.parseInt(ReadExcel.getDataCell(filePath,3,number+1));
        int para3=Integer.parseInt(ReadExcel.getDataCell(filePath,4,number+1));
        CaculateNextDay caculateNextDay = new CaculateNextDay();
        String result = caculateNextDay.getNextDay(para1, para2, para3);
        try{
            ReadExcel.setDataCell(result,filePath,number+1,6);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(result.equals(ReadExcel.getDataCell(filePath, 5, number + 1))){
            try{
                ReadExcel.setDataCell("pass",filePath,number+1,7);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else
        {
            try{
                ReadExcel.setDataCell("fail",filePath,number+1,7);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
