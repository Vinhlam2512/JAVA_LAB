/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Report;
import Models.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Ultils {

    checkInput checkInput = new checkInput();
    Get get = new Get();
    Scanner sc = new Scanner(System.in);
    int indexFlag;

    // check has fname is in studentName
    public boolean containName(String fName, String studentName) {
        int i;
        String[] splited = studentName.split("\\s++");
        for (i = 0; i < splited.length; i++) {
            if (fName.equalsIgnoreCase(splited[i])) {
                return true;
            }
        }
        return false;
    }

    // Get list student find by id
    public ArrayList<Student> listStudentFindById(ArrayList<Student> student) {
        ArrayList<Student> listStudentFindById = new ArrayList<Student>();
        int i;
        int fId = checkInput.getFindId("Input your id: ");
        for (i = 0; i < student.size(); i++) {
            if (student.get(i).getId() == fId) {
                indexFlag = i;
                listStudentFindById.add(student.get(i));
            }
        }
        return listStudentFindById;
    }

    // Get list student find by name
    public ArrayList<Student> listStudentFindByName(ArrayList<Student> student) {
        ArrayList<Student> listStudentFindByName = new ArrayList<Student>();
        int i;
        System.out.print("Input name you want to find: ");
        String fName = sc.nextLine();
        for (i = 0; i < student.size(); i++) {
            if (containName(fName, student.get(i).getName())) {
                listStudentFindByName.add(student.get(i));
            }
        }
        return listStudentFindByName;
    }

    // update or delete
    public int uOrD() {
        String chocie;
        do {
            System.out.print("Do you want to update (U) or delete (D) student? ");
            chocie = sc.nextLine();
            if (chocie.equalsIgnoreCase("d")) {
                return 1;
            }
            if (chocie.equalsIgnoreCase("u")) {
                return 2;
            }
            System.out.println("You must be choose U or D! ");
        } while (true);
    }

    public void delete(ArrayList<Student> students, ArrayList<Student> listStudentFindById) {
        int size = listStudentFindById.size();
        if (size == 1) {
            students.remove(listStudentFindById.get(0));
        }
        int index = checkInput.index("Input index of record you want to delete: ", "You need to input 1 - " + size, size);
        for (int i = 0; i < size; i++) {
            if (i == index - 1) {
                students.remove(listStudentFindById.get(i));
            }
        }
        System.out.println("Delete success!");

    }

    public void updateInfor(ArrayList<Student> students) {
        int id, semester;
        String name, courseName;
        id = get.getId("Input id of student: ", "That is not positive number!");
        do {
            name = get.getName("Input name of student: ", "Please input correct name of student!");
            if (checkInput.checkName(students, id, name) == -1) {
                System.out.println(name);
                System.out.println(checkInput.checkName(students, id, name));
                System.out.println("Please input correct name of student!");
            }
        } while (checkInput.checkName(students, id, name) == -1);

        semester = get.getSemester("Input semester: ", "Please input semeter form 1 to 9!");
        courseName = get.getCourseName("Input course: ", "Plesase input (Java or .Net or C or C++)! ").toUpperCase();

        students.set(indexFlag, new Student(id, name, semester, courseName));
    }

    public void updateInfors(ArrayList<Student> students, int idUpdate) {
        int id, semester;
        String name, courseName;
        int size = students.size();
        int check;
        id = get.getId("Input id of student: ", "That is not positive number!");
        do {
            name = get.getName("Input name of student: ", "Please input correct name of student!");
            check = checkInput.checkName(students, id, name);
            for (Student student : students) {
                if (student.getId() != id) {
                    check = 1;
                }
            }
            if (check == -1) {
                System.out.println(checkInput.checkName(students, id, name));
                System.out.println("Please input correct name of student!");
            }
        } while (check == -1);

        semester = get.getSemester("Input semester: ", "Please input semeter form 1 to 9!");
        courseName = get.getCourseName("Input course: ", "Plesase input (Java or .Net or C or C++)! ").toUpperCase();

        students.set(idUpdate, new Student(id, name, semester, courseName));
    }

    public int getIdToUpdate(ArrayList<Student> students, ArrayList<Student> listStudentFindById, int index) {
        int size = students.size();
        int i;
        for (i = 0; i < size; i++) {
            if (listStudentFindById.get(index - 1).equals(students.get(i))) {
                return i;
            }
        }
        return 0;
    }

    public void update(ArrayList<Student> students, ArrayList<Student> listStudentFindById) {
        int size = listStudentFindById.size();

        if (size != 1) {
            int index = checkInput.index("Input index of record you want to update: ", "You need to input 1 - " + size, size);
            int idUpdate = getIdToUpdate(students, listStudentFindById, index);
            updateInfors(students, idUpdate);
        } else {
            updateInfor(students);
        }
        System.out.println("Update success!");
    }

    public boolean checkReportExist(ArrayList<Report> reports, String name, String courseName, int total) {
        for (Report report : reports) {
            if (name.equalsIgnoreCase(report.getName())
                    && courseName.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }
}
