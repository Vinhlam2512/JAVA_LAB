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

    ArrayList<Student> students = new ArrayList();
    Scanner sc = new Scanner(System.in);

    public static void create() {
        int id, semester;
        String name, courseName;
        name = Validation.getString("Input name of student", "The student name is required!");
        courseName = Validation.getString("Input name of course", "The course name is required!");
        id = Validation.getId("Input id", "The id is required!");
        semester = Validation.getId("Input semester", "The semester is required!");
        students.add(new Student(id, name, semester, courseName));
    }

    
    public void find() {

    }

    public void sort() {

    }

    public void update() {

    }

    public void delete() {

    }

    public void report() {

    }
    
}
