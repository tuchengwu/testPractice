package testExecution;

import commission.CaculateCommission;
import exceloperation.ReadExcel;
import triangle.Judge;

/**
 * @author PC
 */
public class CommissionTest {
    public final String filePath="src/main/resources/commissionTestCases.xlsx";
    public void executeTestCases(int number){
        int para1=Integer.parseInt(ReadExcel.getDataCell(filePath,2,number+1));
        int para2=Integer.parseInt(ReadExcel.getDataCell(filePath,3,number+1));
        int para3=Integer.parseInt(ReadExcel.getDataCell(filePath,4,number+1));
        CaculateCommission caculateCommission = new CaculateCommission();
        String result=caculateCommission.caculateCommission(para1,para2,para3)+"";
        System.out.println(result);
        try{
            ReadExcel.setDataCell(result,this.filePath,number+1,6);
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
