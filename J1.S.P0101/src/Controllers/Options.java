package Controllers;

import java.util.Scanner;
import Models.Employee;
import java.util.ArrayList;
import Models.Employee;
import java.util.Collections;

public class Options {

    Get get = new Get();
    checkInput check = new checkInput();
    Ultils ultil = new Ultils();
    Scanner sc = new Scanner(System.in);

    public void addEmployees(ArrayList<Employee> employees) {
        int id;
        String firstName, lastName, phone, email, address, dateOfBirth, sex, salary, egency;
        do {
            id = get.getId("Input id: ", "That is not number!");
            if (!ultil.checkDuplicateId(employees, id)) {
                System.out.println("This id is already exsit!");
            }
        } while (!ultil.checkDuplicateId(employees, id));
        firstName = get.getName("Input first name: ", "Please input first name!");
        lastName = get.getName("Input last name: ", "Please input last name!");
        phone = get.getPhone("Input phone: ", "That is not phone number!");
        email = get.getEmail("Input emai: ", "That is not email!");
        address = get.getString("Input address: ");
        dateOfBirth = get.getDateOfBirth("Input date of birth: ", "Please enter date with format [dd/mm/yyyy]!");
        sex = get.getSex("Input sex: ", "Please input male or female!");
        salary = get.getSalary("Input salary: ", "Please input salary!");
        egency = get.getString("Input egency: ");
        employees.add(new Employee(id, firstName, lastName, phone, email, address, dateOfBirth, sex, salary, egency));
    }

    public void updateEmployees(ArrayList<Employee> employees) {
        ArrayList<Employee> listEmployeeFindById = ultil.findById(employees);
        if (listEmployeeFindById.isEmpty()) {
            System.out.println("---------------------- List is Empty! ----------------------");
            return;
        }
        System.out.println(listEmployeeFindById);
        System.out.println("---------------------- Input infor you want to update! ----------------------");
        int id;
        String firstName, lastName, phone, email, address, dateOfBirth, sex, salary, egency;
        do {
            id = get.getId("Input id: ", "That is not number!");
            if (!ultil.checkDuplicateId(employees, id)) {
                System.out.println("This id is already exsit!");
            }
        } while (!ultil.checkDuplicateId(employees, id));
        firstName = get.getName("Input first name: ", "Please input first name!");
        lastName = get.getName("Input last name: ", "Please input last name!");
        phone = get.getPhone("Input phone: ", "That is not phone number!");
        email = get.getEmail("Input emai: ", "That is not email!");
        address = get.getString("Input address: ");
        dateOfBirth = get.getDateOfBirth("Input date of birth: ", "Please enter date with format [dd/mm/yyyy]!");
        sex = get.getSex("Input sex: ", "Please input male or female!");
        salary = get.getSalary("Input salary: ", "Please input salary!");
        egency = get.getString("Input egency: ");
        employees.set(ultil.indexFlag, new Employee(id, firstName, lastName, phone, email, address, dateOfBirth, sex, salary, egency));
        System.out.println("------------------------ Update Success! ------------------------");
    }

    public void removeEmployees(ArrayList<Employee> employees) {
        ArrayList<Employee> listEmployeeFindById = ultil.findById(employees);
        if (listEmployeeFindById.isEmpty()) {
            System.out.println("---------------------- ID does not exist! ----------------------");
            return;
        }
        System.out.println(" ID | FIRST NAME | LAST NAME |    PHONE   |      EMAIL     | ADDRESS |     DOB    |   SEX  |   SALARY  | EGENCY |");
        for (Employee employee : listEmployeeFindById) {
            System.out.println("----+------------+-----------+------------+----------------+---------+------------+--------+-----------+---------");
            System.out.println(employee);
        }
        System.out.println("");
        System.out.println("------------------------------------------- Remove Success! --------------------------------------------------------");
    }

    public void searchEmployees(ArrayList<Employee> employees) {
        String firstName;
        firstName = get.getName("Input name you want find: ", "Please input name!");
        ArrayList<Employee> listEmployeeFindByName = ultil.findByName(employees, firstName);
        if (listEmployeeFindByName.isEmpty()) {
            System.out.println("---------------------- NAME does not exist! ----------------------");
            return;
        }
        System.out.println(" ID | FIRST NAME | LAST NAME |    PHONE   |      EMAIL     | ADDRESS |     DOB    |   SEX  |   SALARY  | EGENCY |");

        for (Employee employee : listEmployeeFindByName) {
            System.out.println("----+------------+-----------+------------+----------------+---------+------------+--------+-----------+---------");
            System.out.println(employee);
        }
    }

    public void sortEmployees(ArrayList<Employee> employees) {
        Collections.sort(employees, (Employee e1, Employee e2) -> {
            if (e1.getSalary().compareTo(e2.getSalary()) > 0) {
                return 1;
            } else if (e1.getSalary().compareTo(e2.getSalary()) < 0) {
                return -1;
            } else {
                return e1.getId() - e2.getId();
            }
        });
        System.out.println(" ID | FIRST NAME | LAST NAME |    PHONE   |      EMAIL     | ADDRESS |     DOB    |   SEX  |   SALARY  | EGENCY |");
        for (Employee employee : employees) {
            System.out.println("----+------------+-----------+------------+----------------+---------+------------+--------+-----------+---------");
            System.out.println(employee);
        }
    }
}
