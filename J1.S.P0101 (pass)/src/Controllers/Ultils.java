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
    int indexFlag;
    Get get = new Get();
    public ArrayList<Employee> findById(ArrayList<Employee> employees) {
        ArrayList<Employee> listEmployeeFindById = new ArrayList<>();
        int i;
        int fId = get.getId("Input id you want to find: ", "You need to input number!");
        int size = employees.size();
        for (i = 0; i < size; i++) {
            if(employees.get(i).getId() == fId){
                indexFlag = i;
                listEmployeeFindById.add(employees.get(i));
            }
        }
        return listEmployeeFindById;
    }

    public boolean checkDuplicateId(ArrayList<Employee> employees, int id) {
        int i;
        for (i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id && employees.get(indexFlag).getId() != id) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<Employee> findByName(ArrayList<Employee> employees, String fName) {
        ArrayList<Employee> listEmployeeFindByName = new ArrayList<>();
        int i;
        String name;
        int size = employees.size();
        for (i = 0; i < size; i++) {
              name = employees.get(i).getFirstName().toUpperCase() + " " + employees.get(i).getLastName().toUpperCase();
            if(name.contains(fName.toUpperCase())){
                indexFlag = i;
                listEmployeeFindByName.add(employees.get(i));
            }
        }
        return listEmployeeFindByName;
    }
  
}
