/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.lab;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author John
 */
public class DateUtilitiesJDK8 {
    
    private static DateUtilitiesJDK8 instance;
    
     private DateUtilitiesJDK8() {
    }
    public enum DateUnit {

        DAY(1000L * 60L * 60L * 24L),
        HOUR(1000L * 60L * 60L),
        MINUTE(1000L * 60L),
        SECOND(1000L);

        DateUnit(long ms) {
            milliseconds = ms;
        }

        private final long milliseconds;

        public long getMilliseconds() {
            return milliseconds;
        }
    }
    public static DateUtilitiesJDK8 getInstance() {
        if (instance == null) {
            instance = new DateUtilitiesJDK8();
        }

        return instance;
    }
    
    public LocalTime now() {
        return LocalTime.now();
    }
    
    
    
    public String toString(LocalDate date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Error: date argument cannot be null");
        }
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
        return dtf.format(date);
    }
    
    
    
    public String toString(LocalDateTime date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Error: date argument cannot be null");
        }
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return dtf.format(date);
    }
    
    
    
    public LocalDate formatLocalDateFromPattern(String stringDate,String pattern) throws IllegalArgumentException {
      
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDate localdate = LocalDate.parse(stringDate,dtf);
        return localdate;
    }
    
    public LocalDateTime formatLocalDateTimeFromPattern(String stringDate,String pattern) throws IllegalArgumentException {
      
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localdate = LocalDateTime.parse(stringDate,dtf);
        return localdate;
    }
    
    
    
    
    public int dateDiff(DateUnit unit,LocalDateTime firstDate, LocalDateTime secondDate)
            throws IllegalArgumentException {
        
        Duration diff = Duration.between(firstDate, secondDate);
        int value;
        switch (unit) {
            case DAY:
                value = (int) diff.toDays();
                break;

            case HOUR:
                value = (int) diff.toHours();
                break;

            case MINUTE:
                value = (int) diff.toMinutes();
                break;

            case SECOND:
                value = (int) (diff.toMillis() / 1000L);
                break;

            default:
                value = (int) diff.toHours();
        }

        return value;
    }
    
    
    
    
    public static void main(String[] args) {
        
        DateUtilitiesJDK8 dateUtilities = DateUtilitiesJDK8.getInstance();
        LocalDateTime firstDate = LocalDateTime.now();
        
        
      
        LocalDateTime secondDate = LocalDateTime.now();
        secondDate = dateUtilities.formatLocalDateTimeFromPattern("10-27-2015 16:00","M-dd-yyyy HH:mm");
        
        System.out.println(dateUtilities.dateDiff(DateUnit.HOUR, firstDate, secondDate)+ " Hours");
        
    }
}
