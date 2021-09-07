/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Options {

    static String coursesName[] = {"Java", ".Net", "C", "C++"};
    static ArrayList<Student> students = new ArrayList();
    static Scanner sc = new Scanner(System.in);

    public static void create() {
        String choice;
        int check;
        int stt = 1;
        int count = 0;
        int id, semester;
        String name, courseName;
        while (count < 2) {
            name = Validation.getName("Input name of student " + stt + " : ", "The student name is required!");
            courseName = Validation.getCourse("Input name of course: ", "The course name is required!", coursesName);
                            id = Validation.getId("Input id: ", "The id is required!");

            semester = Validation.getId("Input semester: ", "The semester is required!");
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

    public static void find() {

    }

    public static void sort() {

    }

    public static void update() {

    }

    public static void delete() {

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
