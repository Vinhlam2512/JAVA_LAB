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
public class Controllers {

    public String printReverse(String s) {
        int i;
        String[] splited = s.split("\\s++");
        String result = toUpperCase(splited[splited.length - 1]);
        for (i = splited.length - 2; i >= 0; i--) {
            result = result + " " + splited[i];
        }
        return result;
    }

    public String toUpperCase(String s) {
        String[] splited = s.split("");
        String result = splited[0].toUpperCase();
        for (int i = 1; i < splited.length; i++) {
            result = result + splited[i];
        }
        return result;
    }
}

// hello there abc xyz
//splited = [hello, there, abc, xyz] length = 4
// result = splited[3]
// 2
