/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Controllers {
    Validation val = new Validation();
    Scanner sc = new Scanner(System.in);
    public void printReverse(String s){
         while (!val.isEmpty(s)){// || !val.hasNumber(s)
            System.out.print("Input string: ");
            s = sc.nextLine().trim();
         }
        System.out.println(reverse(s));
    }

    public String reverse(String s) {
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
