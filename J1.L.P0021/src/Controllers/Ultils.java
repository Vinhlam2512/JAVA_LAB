/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Student;
import java.util.ArrayList;

/**
 *
 * @author VINH
 */
public class Ultils {

    public boolean containName(String fName, String studentName) {
        String[] splited = studentName.split("\\s++");
        for (int i = 0; i < splited.length; i++) {
            if (fName.equalsIgnoreCase(splited[i])) {
                return true;
            }
        }
        return false;
    }

    public void sort(ArrayList<Student> student) {
        for (int i = 0; i < student.size() - 1; i++) {
            for (int j = 0; j < student.size() - i - 1; j++) {
                if (student.get(j).getName().compareTo(student.get(j + 1).getName()) > 0) {
                    Student temp = student.get(j);
                    student.set(j, student.get(j + 1));
                    student.set(j + 1, temp);
                }
            }
        }
    }
    public int findById(ArrayList<Student> student, int id){
        if(student.isEmpty()){
            return 0;
        }
        for (int i = 0; i < student.size(); i++) {
            if(student.get(i).getId() == id){
                return id;
            }
        }
        return 0;
    }
}
