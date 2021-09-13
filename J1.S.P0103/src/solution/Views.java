/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Views {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1, s2;
        Controllers ctl = new Controllers();
        LocalDate date1 = ctl.getDate("Please enter the first date: ");
        LocalDate date2 = ctl.getDate("Please enter the second date: ");
        ctl.compare(date1, date2);
        
        
//        LocalDate date = LocalDate.of(2000, 12, 122);
//        System.out.println(date);

    }
}
