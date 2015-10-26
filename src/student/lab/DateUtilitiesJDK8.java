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
    /**Allows you to use the utility methods in the main
     * creates instance of DateUtilitiesJDK8
     * @return instance 
     */
    public static DateUtilitiesJDK8 getInstance() {
        if (instance == null) {
            instance = new DateUtilitiesJDK8();
        }

        return instance;
    }
    /**Gets the local time 
     * 
     * @return the time now in the LocalTime format
     */
    public LocalTime now() {
        return LocalTime.now();
    }
    
    
    /**
     * Takes in LocalDate object and prints out the date
     * @param date
     * @return date as a string
     * @throws IllegalArgumentException 
     */
    public String toString(LocalDate date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Error: date argument cannot be null");
        }
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
        return dtf.format(date);
    }
    
    
    /**
     * Takes in LocalDateTime object and prints out the date
     * @param date
     * @return date as a string
     * @throws IllegalArgumentException 
     */
    public String toString(LocalDateTime date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Error: date argument cannot be null");
        }
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return dtf.format(date);
    }
    
    
    /**
     * Takes in a date in string format and a pattern to format the string 
     * @param stringDate - string of a date 
     * @param pattern - String of the pattern you want the date to formatted to ex) MM-dd-yyyy
     * @return date object formatted into new pattern
     * @throws IllegalArgumentException 
     */
    public LocalDate formatLocalDateFromPattern(String stringDate,String pattern) throws IllegalArgumentException {
      
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDate localdate = LocalDate.parse(stringDate,dtf);
        return localdate;
    }
    
    /**
     * Takes in a date in string format and a pattern to format the string 
     * @param stringDate - string of a date 
     * @param pattern - String of the pattern you want the date to formatted to ex) MM-dd-yyyy
     * @return date object formatted into new pattern
     * @throws IllegalArgumentException 
     */
    public LocalDateTime formatLocalDateTimeFromPattern(String stringDate,String pattern) throws IllegalArgumentException {
      
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localdate = LocalDateTime.parse(stringDate,dtf);
        return localdate;
    }
    
    
    
    /**
     * Method takes two dates and finds the amount of days,hours,minutes,seconds between them
     * @param unit - enum of either  DAY,HOUR,MINUTE,SECOND
     * @param firstDate - the first date 
     * @param secondDate - the second date
     * @return amount of days,hours,minutes,seconds between them
     * @throws IllegalArgumentException 
     */
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
