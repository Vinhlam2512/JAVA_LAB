
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VINH
 */
public class Views {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);

    void printMenu() {
        System.out.println("Welcome to Tien Phong Bank’s!");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }

    void login(Ebank e) throws IOException {
        while (true) {
            String str;
            System.out.print(e.getBundle().getString("account"));
            str = sc.nextLine();
            if (e.checkAccountNumber(str).equals("")) {
                break;
            } else {
                System.out.println(e.getBundle().getString("accountErr"));
            }
        }
        while (true) {

            System.out.print(e.getBundle().getString("password"));
            String password = sc.nextLine();
            if (e.checkPassword(password).equals("")) {
                break;
            } else {
                System.out.println(e.checkPassword(password));
            }
        }
        while (true) {
            String captcha = e.generateCaptcha();
            System.out.println("Captcha: " + captcha);
            System.out.println(e.getBundle().getString("captchaInput"));
            String recaptcha = sc.nextLine();
            if (e.checkCaptcha(captcha, recaptcha).equals("")) {
                System.out.println(e.getBundle().getString("success"));
                break;
            } else {
                System.out.println(e.checkCaptcha(captcha, recaptcha));
            }

        }
    }
}
