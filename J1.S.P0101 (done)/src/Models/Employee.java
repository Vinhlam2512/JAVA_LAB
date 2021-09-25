/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author VINH
 */
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String dateOfBirth;
    private String sex;
    private String salary;
    private String egency;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String phone, String email, String address, String dateOfBirth, String sex, String salary, String egency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.salary = salary;
        this.egency = egency;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public String getSalary() {
        return salary;
    }

    public String getEgency() {
        return egency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setEgency(String egency) {
        this.egency = egency;
    }

    @Override
    public String toString() {
        return  "| " + id + " | " + firstName + " | " + lastName + " | " + phone + " | " + email + " | " + address + " | " + dateOfBirth + " | " + sex + " | " + salary + " | " + egency +"   |";
    }

}
