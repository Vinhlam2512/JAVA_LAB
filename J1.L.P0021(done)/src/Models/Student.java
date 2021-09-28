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
public class Student {

    private int id;
    private String name;
    private int semester;
    private String courseName;

    public Student() {
    }

    public Student(int id, String name, int semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return  " " +id +"\t\t"  + name  + "\t\t" + semester + "\t\t" + courseName ;
    }
    public String toStringNoId() {
        return "| Name: " + name + "\t\t | Semester: " + semester + "\t\t | Course name:" + courseName ;
    }

}
