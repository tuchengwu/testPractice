package calendar;

public class testCalendar {
    public static void main(String[] args) {
        CaculateNextDay caculateNextDay = new CaculateNextDay();
        System.out.println(caculateNextDay.getNextDay(2001, 12, 31));
    }
}
