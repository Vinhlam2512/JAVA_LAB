package Controllers;

import Models.Employee;
import java.util.ArrayList;
import Models.Employee;

public class Options {

    Get get = new Get();
    Ultils ultil = new Ultils();

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
        if (ultil.findById(employees) == null) {
            System.out.println("Dont have this id!");
            return;
        } 
        String phone;
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i));
        }
    }
    public void removeEmployees(ArrayList<Employee> employees){
        ArrayList<Employee> check = ultil.findById(employees);
        if (check == null) {
            System.out.println("Dont have this id!");
            return;
        }
        if(employees.contains(check)){
            employees.remove(check);
        }
    }
}
