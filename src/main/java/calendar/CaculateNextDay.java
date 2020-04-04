package calendar;

/**
 * @author PC
 */
public class CaculateNextDay {
    /***
     *
     * @param year 年份，范围为1900-2100
     * @param month 月份
     * @param day 日期
     * @return 由年份、月份、日期拼接而成的字符串，如"20000124"
     */
    public String getNextDay(int year, int month, int day){
        String result="";
        int resultYear=0;
        int resultMonth=0;
        int resultDay=0;
        if(year<1900||year>2100){
            return "年份超出适用范围";
        }
        if(getDaysNumebr(year,month)==0||day<0||day>getDaysNumebr(year,month)){
            return "不存在该日期";
        }
        if(day==getDaysNumebr(year,month)){
            resultDay=1;
            if(month==12){
                resultMonth=1;
                year++;
                resultYear=year;
            }
            else {
                month++;
                resultMonth=month;
                resultYear=year;
            }
        }
        else
        {
            resultYear=year;
            resultMonth=month;
            day++;
            resultDay=day;
        }
        result=resultYear+"年"+resultMonth+"月"+resultDay+'日';
        return result;
    }
    public int getDaysNumebr(int year,int month){
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if(year%4==0) {
                    return 29;
                } else {
                    return 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 0;
        }
    }
    public String format(int month){
        if(month<10){
            return "0"+month;
        }
        else{
            return month+"";
        }
    }

}
