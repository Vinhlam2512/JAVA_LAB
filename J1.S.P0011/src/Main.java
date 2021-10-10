/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VINH
 */
import java.util.*;

public class Main {
     ChangeBase cb = new ChangeBase();
    public void changeBase(String iBase, String oBase, String value) {
        // Nếu cơ số 10 thì gọi hàm chuyển cơ số 10 về cơ số khác
        if (iBase.equals("10"))
        {
            System.out.println(cb.convertDectoOther(value, oBase));
        } //Ngược lại thì chuyển về cơ số 10 xong chuyển về cơ số cần chuyển
        else {
            String dec = cb.convertOtherToDec(value, iBase);
            System.out.println(cb.convertDectoOther(dec, oBase));
        }
    }

    public boolean chooseYesNo() {
        Validation getInput = new Validation();
        String yesNo;
        yesNo = getInput.inputYesNo("Do you want to continue ?",
                "Enter Y/y for yes,N/n for no !");
        if (yesNo.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Validation v = new Validation();
        Main m = new Main();
        boolean loop = true;
        while (loop) {
            // Cơ số nhập vào :
            String inBase = v.inputBase("Choose the base number input:"
                    + "( Bin, Dec, Hex )",
                    "Please choose Bin, Dec or Hex");
            // Cơ số cần chuyển đổi :
            String outBase = v.inputBase("Choose the base number out:"
                    + "( Bin, Dec, Hex )",
                    "Please choose Bin, Dec or Hex");
            // Giá trị cần chuyển đổi :
            String value = v.inputValue("Enter the input value:",
                    "Invalid value,please input again", inBase).toUpperCase();
            System.out.println("Output Value: ");
            m.changeBase(inBase, outBase, value);
            loop = m.chooseYesNo();
        }
    }
}
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
////Creating Stack object. Since stack is a class in Java
//        Stack stk = new Stack();
//        System.out.println("Enter a decimal number:");
//        int num = sc.nextInt();
//        while (num != 0) {
//            int d = num % 2;
//            stk.push(d); //pushing the remainder into the stack using the stack object
//            num /= 2;
//        }
//        System.out.print("Equivalent binary number: ");
//        while (!(stk.isEmpty())) {
//            System.out.print(stk.pop());
//        }
//        System.out.println();
//    }
//}
