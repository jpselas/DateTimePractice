/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author John
 */
public class FirstDateTime {
    
    
    public static void main(String[] args) {
        Calendar date2 = Calendar.getInstance();
        date2.set(2052, Calendar.SEPTEMBER,23);
        date2.add(Calendar.YEAR,-5);
        
        Date date1 = date2.getTime();
        
        System.out.println(date1);
        
        Date date3 = new Date();
        
        long diff = Math.abs(date1.getTime()-date3.getTime());
        long minutes = diff/1000/60;
        
        System.out.println(minutes + " minutes");
        
        
        boolean isAfter = date1.after(date3);
        
        System.out.println("Date3 is after date1: " + isAfter);
        SimpleDateFormat sdf= new SimpleDateFormat("MMM d, yyyy");
        
        String fDate = sdf.format(date1);
        System.out.println(fDate);
        
        
        
        String date3String = "Jul 11, 1999";
        
        try{
            date1 = sdf.parse(date3String);
            
        }catch(ParseException pe){
            System.out.println("Cannot parse date string");
        }
        System.out.println(date1);
    }
}
