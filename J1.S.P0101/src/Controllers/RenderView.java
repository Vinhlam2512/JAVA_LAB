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
        employees.add(new Employee(1, "Nguyen Van", "Z", "1234567890", "a@gmail.com", "123", "12/12/2001", "male", "123233", "asdfghjk"));
        employees.add(new Employee(2, "Nguyen", "B", "1234567890", "ab@gmail.com", "22", "12/12/1999", "female", "bbbbbbbbb", "zxc"));
        employees.add(new Employee(3, "Nguyen", "A", "1234567890", "abc@gmail.com", "44", "12/12/2000", "male", "dasd", "cxz"));
        employees.add(new Employee(5, "Nguyen Van", "F", "1234567890", "abcd@gmail.com", "55", "12/12/1990", "female", "zz", "tkl"));
        employees.add(new Employee(4, "Nguyen Van", "F", "1234567890", "abcd@gmail.com", "55", "12/12/1990", "female", "zz", "tkl"));
        employees.add(new Employee(7, "Nguyen Van", "F", "1234567890", "abcd@gmail.com", "55", "12/12/1990", "female", "zz", "tkl"));
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
                    for (Employee employee : employees) {
                        System.out.println(employee.toString());
                    }
                    break;
                case 7:
                    return;
            }
        } while (true);
    }

}
