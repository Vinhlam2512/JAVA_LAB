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
public class Report {
    private String name;
    private String courseName;
    private int totalCourse;
    private int id;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Report() {
    }
    
    public Report(String name, String courseName, int totalCourse, int id) {
        this.name = name;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    @Override
    public String toString() {
        return  " "  + name  + "\t\t" + courseName + "\t\t" + totalCourse ;
    }

}
