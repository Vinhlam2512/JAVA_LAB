/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
    int indexFlag = 0;
    
    // check has fname is in studentName
    public boolean containName(String fName, String studentName) {
        int i;
        String[] splited = studentName.split("\\s++");
        for ( i = 0; i < splited.length; i++) {
            if (fName.equalsIgnoreCase(splited[i])) {
                return true;
            }
        }
        return false;
    }
    
    // bubblue sort
    public void sort(ArrayList<Student> student) {
        int i, j;
        for ( i = 0; i < student.size() - 1; i++) {
            for ( j = 0; j < student.size() - i - 1; j++) {
                if (student.get(j).getName().compareTo(student.get(j + 1).getName()) > 0) {
                    Student temp = student.get(j);
                    student.set(j, student.get(j + 1));
                    student.set(j + 1, temp);
                }
            }
        }
    }

    // Get list student find by id
    public ArrayList<Student> listStudentFindById(ArrayList<Student> student) {
        ArrayList<Student> listStudentFindById = new ArrayList<Student>();
        int i;
        int fId = checkInput.getFindId("Input your id: ");
        for (i = 0; i < student.size(); i++) {
            if (student.get(i).getId() == fId) {
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
        for ( i = 0; i < student.size(); i++) {
            if (containName(fName, student.get(i).getName())) {
                indexFlag = i;
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
            System.out.print("You must be choose U or D! ");
        } while (true);
    }
}
