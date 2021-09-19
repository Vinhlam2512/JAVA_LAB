package Controllers;

import Controllers.Options;
import Controllers.checkInput;
import Models.Employee;
import java.util.ArrayList;
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
public class RenderView {

    public void render() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(6, "Nguyen Van", "    Z    ", "1234567890", "abcd@gmail.com", "   HN  ", "12/12/2001", "male  ", "888888888", "  SE"));
        employees.add(new Employee(2, "Nguyen Duy", "    B    ", "1234567890", "abcd@gmail.com", "   BG  ", "12/12/1999", "female", "222222222", "  AI"));
        employees.add(new Employee(3, "Nguyen Duy", "    B    ", "1234567890", "abcd@gmail.com", "   SG  ", "12/12/1967", "male  ", "999999999", "  IA"));
        employees.add(new Employee(5, "Nguyen Duy", "    C    ", "1234567890", "abcd@gmail.com", "   HT  ", "12/12/1990", "female", "666666666", "  AI"));
        employees.add(new Employee(4, "Nguyen Van", "    F    ", "1234567890", "abcd@gmail.com", "   QN  ", "12/12/1970", "male  ", "444444444", "  IA"));
        employees.add(new Employee(7, "Nguyen Van", "    D    ", "1234567890", "abcd@gmail.com", "   HL  ", "12/12/1980", "male  ", "777777777", "  SE"));
        employees.add(new Employee(1, "Nguyen Duy", "    F    ", "1234567890", "abcd@gmail.com", "   LC  ", "12/12/1990", "female", "888888888", "  AI"));
        employees.add(new Employee(8, "Nguyen Van", "    K    ", "1234567890", "abcd@gmail.com", "   BG  ", "12/12/1985", "female", "333333333", "  SE"));
        Options ops = new Options();
        checkInput check = new checkInput();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("    1.	Add employees ");
            System.out.println("    2.	Update employees");
            System.out.println("    3.	Remove employees");
            System.out.println("    4.	Search employees");
            System.out.println("    5.	Sort employees by salary");
            System.out.println("    6.	Exit");
            choice = check.choiceInput();
            switch (choice) {
                case 1:
                    ops.addEmployees(employees);
                    break;
                case 2:
                    ops.updateEmployees(employees);
                    break;
                case 3:
                    ops.removeEmployees(employees);
                    break;
                case 4:
                    ops.searchEmployees(employees);
                    break;
                case 5:
                    ops.sortEmployees(employees);
                    break;
                case 6:
                    System.out.println(" ID | FIRST NAME | LAST NAME |    PHONE   |      EMAIL     | ADDRESS |     DOB    |   SEX  |   SALARY  | EGENCY |");
                    for (Employee employee : employees) {
                        System.out.println("----+------------+-----------+------------+----------------+---------+------------+--------+-----------+---------");

                        System.out.println(employee.toString());
                    }
                    break;
                case 7:
                    return;
            }
        } while (true);
    }

}
