/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utils.Get;
import Utils.Validation;
import Models.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Options {

    private String coursesName[] = {"Java", ".Net", "C", "C++"};
    private ArrayList<Student> students = new ArrayList();
    private Scanner sc = new Scanner(System.in);
    Student student = new Student();
    Get get = new Get();
    Validation val = new Validation();

    public void create() {
        String choice;
        boolean check;
        int stt = 1;
        int count = 0;
        int id, semester;
        String name, courseName;
        while (count < 2) {
            name = get.getName("Input name of student " + stt + " : ", "The student name is required!");
            courseName = get.getCourse("Input name of course: ", "The course name is required!", coursesName);
            id = get.getId("Input id is positive integer: ", "That's not a number!");

            semester = get.getSemester("Input semester : ", "That's not a number!");
            students.add(new Student(id, name, semester, courseName));
            count++;
            if (count == 2) {
                System.out.println("Do you want to continue (Y/N)? ");
                choice = sc.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    count = 0;
                } else {
                    break;
                }
            }
            stt = stt + 1;
        }
    }

    public void find() {

    }

    public void sort() {

    }

    public void update() {

    }

    public void delete() {

    }

    public static void report() {
        for (Student student : students) {
            System.out.println(student.getCourseName());
            System.out.println(student.getId());
            System.out.println(student.getName());
            System.out.println(student.getSemester());
        }
    }

}
