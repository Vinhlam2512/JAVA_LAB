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
public class Controller {

    Ultils ultil = new Ultils();
    Get get = new Get();
    checkInput checkInput = new checkInput();
    Scanner sc = new Scanner(System.in);
    private ArrayList<Student> students = new ArrayList();

    public void create() {
        System.out.println(students.isEmpty());
        int id, semester;
        int check;
        String name, course;
        int count = 1;
        while (count != 2) {
            id = get.getId("Input id of student: ", "That is not positive number!");
            if (checkInput.idIsExist(students, id) != null) {
                name = checkInput.idIsExist(students, id);
                System.out.println("Name of student: " + name);
            } else {
                name = get.getName("Input name of student: ", "Please input correct name of student!");
            }
            semester = get.getSemester("Input semester: ", "Please input semeter form 1 to 9!");
            course = get.getCourseName("Input course: ", "Plesase input (Java or .Net or C or C++)! ").toUpperCase();
            if (!ultil.checkStudentExist(students, name, course, id, semester)) {
                students.add(new Student(id, name, semester, course));
            }

            System.out.println("-------------------------------------------------");
            System.out.println("");
            count++;
            if (count == 2 || count == 1) {
                String choice = checkInput.isContinue();
                if (choice == "Y") {
                    count = 0;
                    System.out.println("Continue!");
                } else {
                    System.out.println("Stop!");
                    break;
                }
            }
        }
    }

    public void findAndSort() {
        if (students.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        ArrayList<Student> listStudentFindByName = ultil.listStudentFindByName(students);
        if (listStudentFindByName.isEmpty()) {
            System.out.println("This name does not exist");
            return;
        }
        Collections.sort(listStudentFindByName, (Student o1, Student o2) -> {
            if (o1.getName().compareTo(o2.getName()) > 0) {
                return 1;
            } else if (o1.getName().compareTo(o2.getName()) < 0) {
                return -1;
            } else {
                return (o1.getSemester() - o2.getSemester());
            }
        });
        for (Student student : listStudentFindByName) {
            System.out.println(student.toStringNoId());
        }
    }

    public void updateOrDelete() {
        if (students.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        int i = 1;
        ArrayList<Student> listStudentFindById = ultil.listStudentFindById(students);
        for (Student student : listStudentFindById) {
            System.out.println(i +"| " + student);
            i++;
        }
        int index;
        if (listStudentFindById.isEmpty()) {
            System.out.println("This id does not exist");
            return;
        }
        int choice = ultil.uOrD();
        if (choice == 1) {
            ultil.delete(students, listStudentFindById);
        }
        if (choice == 2) {
            ultil.update(students, listStudentFindById);
        }
    }

    public void report() {
        int i;
        if (students.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        ArrayList<Report> reports = new ArrayList<>();
        String courseName, name;
        int id, semester;
        int size = students.size();
        for (Student student : students) {
            int total = 0;
            id = student.getId();
            semester = student.getSemester();
            courseName = student.getCourseName();
            name = student.getName();
            for (Student studentCountTotal : students) {
                if (name.equalsIgnoreCase(studentCountTotal.getName())
                        && courseName.equalsIgnoreCase(studentCountTotal.getCourseName())
                        && id == studentCountTotal.getId()) {
                    total++;
                }
            }
            if (ultil.checkReportExist(reports, name, courseName, id) == true) {
                reports.add(new Report(name, courseName, total, id));
            }
        }
        //print report
        System.out.println("-------------- The Report --------------");
        System.out.println("| Name \t\t      | Course name   | Total course");
        for (i = 0; i < reports.size(); i++) {
            System.out.println(" " + reports.get(i).toString());
        }
    }

    public void demo() {
        System.out.println("|Student id    | Name \t\t      | Semester      | Course name");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
    }

    public void test() {
        students.add(new Student(1, "Nguyen Van A", 1, "C"));
        students.add(new Student(5, "Nguyen Van K", 2, ".NET"));
        students.add(new Student(5, "Nguyen Van K", 2, "C"));
        students.add(new Student(5, "Nguyen Van K", 2, "C++"));
        students.add(new Student(5, "Nguyen Van K", 2, "Java"));
        students.add(new Student(7, "Nguyen Van Z", 2, "C"));
        students.add(new Student(8, "Nguyen Van B", 7, "JAVA"));
        students.add(new Student(9, "Nguyen Van F", 8, "C"));
    }
}
