/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Validation {

    static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inputMsg, String errorMsg, int min, int max) {
        int n, tmp;
        //nếu đầu vào lower > upper thì đổi chỗ
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new Exception(); // custom Exception
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg) {
        String str;
        while (true) {
            System.out.println(inputMsg);
            str = sc.nextLine().trim();
            if (str.length() == 0 || str.isEmpty() || isNumeric(str)) {
                System.out.println(errorMsg);
            } else {
                return str;
            }
        }
    }

    public static boolean isNumeric(String str) {

        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;

    }

    public static int getId(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.println(inputMsg);
            id = sc.nextLine();
            if (isNumeric(id)) {
                return Integer.parseInt(id);
            } else {
                System.out.println(errorMsg);
            }
        }
    }

}
