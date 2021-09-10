/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.ArrayList;
import java.util.Scanner;
import Models.Student;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author VINH
 */
public class Options {

    private ArrayList<Student> student = new ArrayList();
    Ultils ultil = new Ultils();
    Get get = new Get();
    Scanner sc = new Scanner(System.in);
    int check = 0;

    public void create() {
        int id, semester;
        String name, course;
        int count = 0;
        while (true) {
            id = get.getId("Input id of student: ", "That is not positive number!");
            if (ultil.findById(student, id) != 0) {
                System.out.println("Id is already exist!");
            } else {
                break;
            }
        }
        name = get.getName("Input name of student: ", "Please input correct name of student!");
        semester = get.getSemester("Input semester: ", "Please input semeter form 1 to 9!");
        course = get.getCourseName("Input course: ", "Plesase input (Java or .Net or C or C++)! ");
        student.add(new Student(id, name, semester, course));
        count++;
    }

    public void findAndSort() {
        System.out.print("Input name you want to find: ");
        String fName = sc.nextLine();
        for (int i = 0; i < student.size(); i++) {
            if (ultil.containName(fName, student.get(i).getName())) {
                System.out.println(student.get(i).toString());
                check++;
            }
        }
        ultil.sort(student);
        if (check == 0) {
            System.out.println("No one have name like input!");
        }
    }
    public void findId(){
        int id;
        id = get.getId("Input id of student you want to find: ", "That is not positive number!");
        
    }
}
