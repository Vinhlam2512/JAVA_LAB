
import java.util.ResourceBundle;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VINH
 */
public class Main {

    public static void main(String[] args) {
        Locale localeEn = new Locale("en");
        System.out.println(Locale.ENGLISH);
        ResourceBundle labels = ResourceBundle.getBundle("", localeEn);
        System.out.println("Xin chào trong tiếng anh: " + labels.getString("hello"));
//
        Locale localeVi = new Locale("vi");
        labels = ResourceBundle.getBundle("", localeVi);
        System.out.println("Xin chào trong tiếng việt: " + labels.getString("hello"));
    }
}
