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
        String result;
        int resultYear;
        int resultMonth;
        int resultDay;
        //定义该程序的年份适用范围为1900-2100
        if(year<1900||year>2100){
            return "年份超出适用范围";
        }
        //如果该日期在该月份中不存在或者月份不在1-12中，那么该日期就不存在
        if(getDaysNumber(year,month)==0||day<0||day> getDaysNumber(year,month)){
            return "不存在该日期";
        }
        //当日期存在时，根据情况计算下一日的日期
        //如果是该月最后一天
        if(day== getDaysNumber(year,month)){
            //则下一日为下一月第一天
            resultDay=1;
            //如果是一年最后一月
            if(month==12){
                //那么下一月为1月，年份+1
                resultMonth=1;
                year++;
            }
            else {
                month++;
                resultMonth=month;
            }
            resultYear=year;
        }
        else
        {
            resultYear=year;
            resultMonth=month;
            day++;
            resultDay=day;
        }
        //返回格式为****年*(*)月*(*)日
        result=resultYear+"年"+resultMonth+"月"+resultDay+'日';
        return result;
    }

    /**
     *
     * @param year 年份
     * @param month 月份
     * @return 该月含有的天数
     */
    public int getDaysNumber(int year, int month){
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

}
