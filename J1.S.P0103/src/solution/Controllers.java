/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Controllers {

    Scanner sc = new Scanner(System.in);

    public void compare(LocalDate date1, LocalDate date2) {
        if (date1.isAfter(date2)) {
            System.out.println("Date1 is after Date2");
        } else if (date1.isAfter(date2)) {
            System.out.println("Date1 is before Date2");
        } else {
            System.out.println("Date1 is same Date2");
        }
    }

    public LocalDate getDate( String inputMsg) {
        while (true) {
            try {
                String s;
                System.out.print(inputMsg);
                s = sc.nextLine();
                String splited[] = s.split("/");
                int day = Integer.parseInt(splited[0]);
                int month = Integer.parseInt(splited[1]);
                int year = Integer.parseInt(splited[2]);
                if (validateYear(year) != 0) {
                    LocalDate date = LocalDate.of(year, month, day);
                    return date;
                }
            } catch (Exception e) {
                System.out.println("Please re input the correct format [dd/mm/yyyy]!");
            }
        }
    }

    public int validateYear(int year) {
        if (1000 > year || year > 9999) {
            System.out.println("Please input year in 1000 to 9999");
            return 0;
        }
        return 1;
    }
}
