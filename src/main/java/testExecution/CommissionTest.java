package testExecution;

import commission.CalculateCommission;
import exceloperation.ReadExcel;

/**
 * @author PC
 */
public class CommissionTest {
    public final String filePath="src/main/resources/commissionTestCases.xlsx";

    /**
     * 执行佣金问题测试用例
     * @param number 测试用例编号
     */
    public void executeTestCases(int number){
        //获取参数
        int para1=Integer.parseInt(ReadExcel.getDataCell(filePath,2,number+1));
        int para2=Integer.parseInt(ReadExcel.getDataCell(filePath,3,number+1));
        int para3=Integer.parseInt(ReadExcel.getDataCell(filePath,4,number+1));
        //执行测试用例
        CalculateCommission calculateCommission = new CalculateCommission();
        String result= calculateCommission.calculateCommission(para1,para2,para3)+"";
        //写入实际执行结果
        try{
            ReadExcel.setDataCell(result,this.filePath,number+1,6);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //判断该测试用例是否pass
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

    /**
     * 执行佣金问题所有测试用例并写入
     */
    public void executeAll(){
        //获取测试用例数量
        int number=ReadExcel.getNumberOfRow(this.filePath);
        //循环执行所有测试用例
        for(int i=1;i<number;i++){
            executeTestCases(i);
        }
    }
}
