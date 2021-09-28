package dateExam;

import java.sql.Date;
import java.util.Calendar;

public class Ex1 {
  public static void main(String[] args) {
    Calendar today = Calendar.getInstance();
    today.set(Calendar.HOUR_OF_DAY, 22);
    System.out.println(toDate(today));
    System.out.println(toTimeString(today));
    System.out.println(toYoil(today));

    int zoneOffset = today.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000);
    System.out.println("zone: " + zoneOffset);

    // add
    // today.add(Calendar.HOUR_OF_DAY, -9);
    today.set(2020, 5, 28);
    System.err.println("====================변경===================");
    System.out.println(toDate(today));
    System.out.println(toTimeString(today));
  }

  public static String toDate(Calendar date) {
    return date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH) + 1) + "-" + date.get(Calendar.DATE);
  }

  public static String toTimeString(Calendar date) {
    String amPm = (date.get(Calendar.AM_PM) == 0) ? "오전" : "오후";
    System.out.println(amPm);
    return date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND) + " (" + amPm
        + ")";
  }

  public static String toYoil(Calendar date) {
    // 1~7, 일(1),월(2),.....토(7)
    String[] yoils = { "", "일", "월", "화", "수", "목", "금", "토" };
    int yoil = date.get(Calendar.DAY_OF_WEEK);
    return yoils[yoil];
  }
}
