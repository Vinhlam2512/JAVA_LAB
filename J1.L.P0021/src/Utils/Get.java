/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Models.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Get {
    Validation val = new Validation();

    Scanner sc = new Scanner(System.in);
    private ArrayList<Student> students = new ArrayList();

    public String getName(String inputMsg, String errorMsg) {
        String str;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            if (str.length() == 0 || str.isEmpty() || !val.isNumeric(str)) {
                System.out.println(errorMsg);
            } else {
                return str;
            }
        }
    }

    public String getCourse(String inputMsg, String errorMsg, String coursesName[]) {
        String str;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            if (str.length() == 0 || str.isEmpty() || !val.checkCourse(coursesName, str)) {
                System.out.println(errorMsg);
            } else {
                return str;
            }
        }
    }

    public int getId(String inputMsg, String errorMsg) {
        int id;
        do {
            System.out.print(inputMsg);
            while (!sc.hasNextInt()) {
                System.out.println(errorMsg);
                System.out.print(inputMsg);

                sc.next(); // remove data
            }
            id = sc.nextInt();
        } while (id <= 0);
        return id;
    }

    public int getSemester(String inputMsg, String errorMsg) {
        int semester;
        do {
            System.out.println(inputMsg);
            while (!sc.hasNextInt()) {
                System.out.println(errorMsg);
                System.out.print(inputMsg);
                sc.next();
            }
            semester = sc.nextInt();
        } while (semester < 0 || semester > 9);
        return semester;
    }

    public int getAnInteger(String inputMsg, String errorMsg, int min, int max) {
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
}
