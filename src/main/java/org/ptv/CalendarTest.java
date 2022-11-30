package org.ptv;
import java.time.*;

public class CalendarTest {
        public LocalDate date, first_date;
        public DayOfWeek  first_date_WDay;
        public int month,today;
    CalendarTest(){
        date = LocalDate.now();
        month =  date.getMonthValue(); //месяц
        today = date.getDayOfMonth();  //число месяца
        first_date = date.minusDays(today -1);
        first_date_WDay = date.getDayOfWeek();
    }
    public LocalDate get_date1(){
        return date;
    }
    public LocalDate get_first_date(){
        return first_date;
    }
    public DayOfWeek get_first_date_WDay(){
        return first_date_WDay;
    }

    /**
     * Дополнение слева строки  пробелами до заданной длины
     * @param s - Строка
     * @param n - Длина новой строки
     * @return
     */
    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
    public String PrintMonth(){
        String S1 ="";
        System.out.println("  Пн  Вт  Ср  Чт  Пт  СБ  ВС");
        for(int i = 1; i< first_date_WDay.getValue();i++){
            S1 = S1+"  ";
        }
        while (first_date.getMonth().getValue() == month){
            if(first_date.equals(date)){
                System.out.println("*");
            }
            //тернарый оператор
            S1 = S1+ padLeft(String.valueOf(!first_date.equals(date) ? first_date.getDayOfMonth(): first_date.getDayOfMonth()+"*"),4);
            if(first_date.getDayOfWeek().getValue()==7){
                S1 = S1+"\n";
            }
            first_date = first_date.plusDays(1);
        }
        return S1;
    }

}
