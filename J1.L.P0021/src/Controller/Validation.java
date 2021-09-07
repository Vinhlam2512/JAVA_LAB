/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Validation {

    static ArrayList<Student> students = new ArrayList();

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
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            if (str.length() == 0 || str.isEmpty() || !isNumeric(str)) {
                System.out.println(errorMsg);
            } else {
                return str;
            }
        }
    }

    public static int getId(String inputMsg, String errorMsg) {
        int id;
        while (true) {
            try {
                System.out.print(inputMsg);
                id = sc.nextInt();
                
                return id;
            } catch (Exception e) {
//                System.out.println(errorMsg);
            }
        }
    }

    public static int checkId(int id) {
        if (students.isEmpty()) {
            return 1;
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                System.out.println("Id is already exist!");
                return -1;
            }
        }
        return 1;
    }

    public static String getName(String inputMsg, String errorMsg) {
        String str;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            if (str.length() == 0 || str.isEmpty() || !isNumeric(str)) {
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
            if (Character.isDigit(c)) {
                return false;
            }
        }

        return true;

    }

    public static String getCourse(String inputMsg, String errorMsg, String coursesName[]) {
        String str;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            if (str.length() == 0 || str.isEmpty() || !checkCourse(coursesName, str)) {
                System.out.println(errorMsg);
            } else {
                return str;
            }
        }
    }

    public static Boolean checkCourse(String coursesName[], String courseName) {
        for (String course : coursesName) {
            if (courseName.equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }

}
