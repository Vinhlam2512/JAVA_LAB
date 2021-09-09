/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

/**
 *
 * @author VINH
 */
public class Validation {

    public boolean isEmpty(String s) {
        if (s.equals("")) {
            return false;
        }
        return true;
    }

    public boolean hasNumber(String s) {
        String[] splited = s.split("\\s++");
        for (int i = 0; i < splited.length; i++) {
            if (!isDigit(splited[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isDigit(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
//hello = > [h,e,class ,]
