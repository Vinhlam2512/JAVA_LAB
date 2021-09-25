package Controllers;

import java.util.Scanner;
import Models.Employee;
import java.util.ArrayList;
import Models.Employee;
import java.util.Collections;

public class Controllers {

    Get get = new Get();
    checkInput check = new checkInput();
    Ultils ultil = new Ultils();
    Scanner sc = new Scanner(System.in);
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployees() {
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

    public void updateEmployees() {
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

    public void removeEmployees() {
        ArrayList<Employee> listEmployeeFindById = ultil.findById(employees);
        if (listEmployeeFindById.isEmpty()) {
            System.out.println("---------------------- ID does not exist! ----------------------");
            return;
        }
        System.out.println(" ID | FIRST NAME | LAST NAME |    PHONE   |      EMAIL     | ADDRESS |     DOB    |   SEX  |   SALARY  | EGENCY |");
        for (Employee employee : listEmployeeFindById) {
            System.out.println("----+------------+-----------+------------+----------------+---------+------------+--------+-----------+---------");
            System.out.println(employee);
            employees.remove(employee);
        }
        System.out.println("");
        System.out.println("------------------------------------------- Remove Success! --------------------------------------------------------");
    }

    public void searchEmployees() {
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

    public void sortEmployees() {
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

    public void test() {
        System.out.println(" ID | FIRST NAME | LAST NAME |    PHONE   |      EMAIL     | ADDRESS |     DOB    |   SEX  |   SALARY  | EGENCY |");
        for (Employee employee : employees) {
            System.out.println("----+------------+-----------+------------+----------------+---------+------------+--------+-----------+---------");

            System.out.println(employee.toString());
        }
    }
    public void add(){
        employees.add(new Employee(6, "Nguyen Van", "Z", "1234567890", "abcd@gmail.com", "   HN  ", "12/12/2001", "male  ", "888888888", "  SE"));
        employees.add(new Employee(2, "Nguyen Duy", "    B    ", "1234567890", "abcd@gmail.com", "   BG  ", "12/12/1999", "female", "222222222", "  AI"));
        employees.add(new Employee(3, "Nguyen Duy", "    B    ", "1234567890", "abcd@gmail.com", "   SG  ", "12/12/1967", "male  ", "999999999", "  IA"));
        employees.add(new Employee(5, "Nguyen Duy", "    C    ", "1234567890", "abcd@gmail.com", "   HT  ", "12/12/1990", "female", "666666666", "  AI"));
        employees.add(new Employee(4, "Nguyen Van", "    F    ", "1234567890", "abcd@gmail.com", "   QN  ", "12/12/1970", "male  ", "444444444", "  IA"));
        employees.add(new Employee(7, "Nguyen Van", "    D    ", "1234567890", "abcd@gmail.com", "   HL  ", "12/12/1980", "male  ", "777777777", "  SE"));
        employees.add(new Employee(1, "Nguyen Duy", "    F    ", "1234567890", "abcd@gmail.com", "   LC  ", "12/12/1990", "female", "888888888", "  AI"));
        employees.add(new Employee(8, "Nguyen Van", "    K    ", "1234567890", "abcd@gmail.com", "   BG  ", "12/12/1985", "female", "333333333", "  SE"));
    }
}
