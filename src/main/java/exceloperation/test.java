package exceloperation;

import triangle.Judge;

import java.io.FileNotFoundException;

public class test {
    public static void main(String[] args) {
        String para1=ReadExcel.getDataCell("src/main/resources/triangleTestCases.xlsx",2,2);
        String para2=ReadExcel.getDataCell("src/main/resources/triangleTestCases.xlsx",3,2);
        String para3=ReadExcel.getDataCell("src/main/resources/triangleTestCases.xlsx",4,2);
        Judge judge = new Judge();
        String result = judge.judge(Integer.parseInt(para1), Integer.parseInt(para2), Integer.parseInt(para3));
        try {
            ReadExcel.setDataCell(result,"src/main/resources/triangleTestCases.xlsx",2,6);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
