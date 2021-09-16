/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Get {

    checkInput check = new checkInput();
    Scanner sc = new Scanner(System.in);
    private String[] courses = {"Java", ".Net", "C", "C++"};

    // validate and get id
    public int getId(String inputMsg, String errMsg) {
        int id;
        while (true) {
            try {
                System.out.print(inputMsg);
                id = Integer.parseInt(sc.nextLine());
                if (id > 0) {
                    return id;
                }
                System.out.println(errMsg);
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }

    // validate and get name
    public String getName(String inputMsg, String errMsg) {
        String name;
        while (true) {
            System.out.print(inputMsg);
            name = sc.nextLine().trim();
            if (name == "" || name.isEmpty() || check.hasNumber(name)) {
                System.out.println(errMsg);
            } else {
                return name;
            }
        }
    }

    // validate and get semester
    public int getSemester(String inputMsg, String errMsg) {
        int semester;
        while (true) {
            try {
                System.out.print(inputMsg);
                semester = Integer.parseInt(sc.nextLine());
                if (semester > 0 && semester < 10) {
                    return semester;
                }
                System.out.println(errMsg);
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }

    // validate and get course name
    public String getCourseName(String inputMsg, String errMsg) {
        String courseName;
        while (true) {
            System.out.print(inputMsg);
            courseName = sc.nextLine();
            if (check.checkCourse(courseName, courses)) {
                return courseName;
            }
            System.out.println(errMsg);
        }
    }
}
