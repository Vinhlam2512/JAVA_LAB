/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Get {

    Scanner sc = new Scanner(System.in);
    checkInput check = new checkInput();

    public int getId(String inputMsg, String errMsg) {
        int id;
        while (true) {
            try {
                System.out.print(inputMsg);
                id = Integer.parseInt(sc.nextLine().trim());
                if (id > 0) {
                    return id;
                }
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }

    public String getName(String inputMsg, String errMsg) {
        String name;
        while (true) {
            System.out.print(inputMsg);
            name = sc.nextLine().trim();
            if (!check.hasNumber(name)) {
                System.out.println(errMsg);
            } else {
                return name;
            }
        }
    }

    public String getPhone(String inputMsg, String errMsg) {
        String phone;
        do {
            System.out.print(inputMsg);
            phone = sc.nextLine();
            int length = phone.length();
            if (length != 10 || !check.isAllNumber(phone)) {
                System.out.println(errMsg);
            }
        } while (!check.isAllNumber(phone));
        return phone;
    }

    public String getEmail(String inputMsg, String errMsg) {
        String email;
        do {
            System.out.print(inputMsg);
            email = sc.nextLine();
            int length = email.length();
            if (!check.isEmail(email)) {
                System.out.println(errMsg);
            }
        } while (!check.isEmail(email));

        return email;
    }

    public String getString(String inputMsg) {
        String str;
        System.out.print(inputMsg);
        str = sc.nextLine().trim();
        return str;
    }

    public String getDateOfBirth(String inputMsg, String errMsg) {
        String dob;
        String splited[];
        while (true) {
            try {
                System.out.print(inputMsg);
                dob = sc.nextLine().trim();
                splited = dob.split("/");
                int month = Integer.parseInt(splited[1]);
                int day = Integer.parseInt(splited[0]);
                int year = Integer.parseInt(splited[2]);
                if (check.validateYear(year) != 0) {
                    LocalDate date = LocalDate.of(year, month, day); // check day and month adn year
                    break;
                }
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
        return dob;
    }
//    25/12/2001

    public String getSex(String inputMsg, String errMsg) {
        String[] sexs = {"male", "female"};
        String sex;
        int i;
        while (true) {
            System.out.print(inputMsg);
            sex = sc.nextLine();
            for (i = 0; i < sexs.length; i++) {
                if (sex.equalsIgnoreCase(sexs[i])) {
                    return sex;
                }
            }
            System.out.println(errMsg);
        }
    }

    public String getSalary(String inputMsg, String errMsg) {
        String salary;
        do {
            System.out.print(inputMsg);
            salary = sc.nextLine();
            if(check.validateSalary(salary)){
                break;
            }
            System.out.println(errMsg);
        } while (!check.validateSalary(salary));
        return salary;
    }
}
