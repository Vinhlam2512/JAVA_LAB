
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author VINH
 */
public class test {

    public static void main(String[] args) throws ParseException {
        String date1 = "6/8/2000";
        String date2 = "2/3/2000";
        Date d1 = sdformat.parse(date1);
        Date d2 = sdformat.parse(date2);
        System.out.println(d1.compareTo(d2));

    }

    static boolean isDateValid(String date) {
        try {
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
