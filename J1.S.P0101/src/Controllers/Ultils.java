/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Employee;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Ultils {

    Scanner sc = new Scanner(System.in);

    public ArrayList<Employee> findById(ArrayList<Employee> employees) {
        ArrayList<Employee> listEmployeeFindById = new ArrayList<>();
        System.out.print("Input id you want to find: ");
        int fId = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == fId) {
                listEmployeeFindById.add(employees.get(i));
            }
        }
        if (listEmployeeFindById == null || listEmployeeFindById.isEmpty()) {
            return null;
        }
        return listEmployeeFindById;
    }

    public boolean checkDuplicateId(ArrayList<Employee> employees, int id) {
        int i;
        for (i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                return false;
            }
        }
        return true;
    }
}
