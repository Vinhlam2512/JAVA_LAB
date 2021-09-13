/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Report;
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

    Ultils ultil = new Ultils();
    Get get = new Get();
    checkInput checkInput = new checkInput();
    Scanner sc = new Scanner(System.in);
    int check = 0;

    public void create(ArrayList<Student> students) {
        int id, semester;
        String name, course;
        int count = 0;
        while (count != 1) {
            while (true) {
                id = get.getId("Input id of student: ", "That is not positive number!");
                if (checkInput.checkId(students, id) != 0) {
                    System.out.println("Id is already exist!");
                } else {
                    break;
                }
            }
            name = get.getName("Input name of student: ", "Please input correct name of student!");
            semester = get.getSemester("Input semester: ", "Please input semeter form 1 to 9!");
            course = get.getCourseName("Input course: ", "Plesase input (Java or .Net or C or C++)! ").toUpperCase();
            students.add(new Student(id, name, semester, course));
            count++;
            if (count == 1) {
                String choice = checkInput.isContinue();
                if (choice == "Y") {
                    count = 0;
                    System.out.println("tiep");
                } else {
                    System.out.println("dung");
                    break;
                }
            }
        }
    }

    public void findAndSort(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        ArrayList<Student> listStudentFindByName = ultil.listStudentFindByName(students);
        if (listStudentFindByName.isEmpty()) {
            System.out.println("This name does not exist");
            return;
        }
        ultil.sort(listStudentFindByName);
        for (Student student : listStudentFindByName) {
            System.out.println(student.toString());
        }
    }

    public void updateOrDelete(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        ArrayList<Student> listStudentFindById = ultil.listStudentFindById(students);
        System.out.println(listStudentFindById);
        if (listStudentFindById.isEmpty()) {
            System.out.println("This id does not exist");
            return;
        }
        int choice = ultil.uOrD();
        if (choice == 1) {
            students.remove(listStudentFindById.get(0));
            System.out.println("Delete success!");
        }
        if (choice == 2) {
            int id, semester;
            String name, course;
            while (true) {
                id = get.getId("Input id of student: ", "That is not positive number!");
                if (checkInput.checkId(students, id) != 0) {
                    System.out.println("Id is already exist!");
                } else {
                    break;
                }
            }
            name = get.getName("Input name of student: ", "Please input correct name of student!");
            semester = get.getSemester("Input semester: ", "Please input semeter form 1 to 9!");
            course = get.getCourseName("Input course: ", "Plesase input (Java or .Net or C or C++)! ");
            students.set(ultil.indexFlag, new Student(id, name, semester, course));
            System.out.println("Update success!");
        }
    }

    public void report(ArrayList<Student> students) {
        int i;
        int total[] = new int[students.size()];
        if (students.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        ArrayList<Report> reports = new ArrayList<>();
        String courseName, name;
        int size = students.size();
        for (i = 0; i < students.size(); i++) {
            total[i] = 1;
            courseName = students.get(i).getCourseName();
            name = students.get(i).getName();
            if (courseName.equalsIgnoreCase(students.get(i).getCourseName())) {
                total[i]++;
            }
            reports.add(new Report(name, courseName, total[i]));
        }
        //print report
        for (i = 0; i < reports.size(); i++) {
            System.out.println(reports.get(i).toString());
        }
    }
}
