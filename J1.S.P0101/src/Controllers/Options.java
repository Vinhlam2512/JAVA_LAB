package Controllers;

import Models.Employee;
import java.util.ArrayList;

public class Options {
    ArrayList<Employee> employees = new ArrayList<>();
    Get get = new Get();
    
    public void addEmployees() {
        int id;
        String firstName, lastName, phone, email, address, dateOfBirth, sex, salary, egency;
        id = get.getId("Input id: ", "That is not number!");
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
    public void updateEmployees(){
        for (int i = 0; i < 2; i++) {
                        System.out.println(employees.get(i).toString());
                    }
    }
}
