package exceloperation;

import java.io.FileNotFoundException;

public class test {
    public static void main(String[] args) {
        String dataCell = ReadExcel.getDataCell("src/main/resources/test.xlsx", 1, 1);
        System.out.println(dataCell);
        try {
            ReadExcel.setDataCell("2","src/main/resources/test.xlsx",1,2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int data=Integer.parseInt(ReadExcel.getDataCell("src/main/resources/test.xlsx", 2, 1));
        System.out.println(data);

    }
}
