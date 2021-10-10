




import java.util.Scanner;

public class Validation {

    Scanner sc = new Scanner(System.in);

    public String inputBase(String msg, String err) {
        String base;

        while (true) {
            try {
                System.out.println(msg);
                base = sc.nextLine();
                if (base.equals("10") || base.equals("2") || base.equals("16")) {
                    return base;
                }
            } catch (Exception e) {
                System.out.println(err);
            }

            System.out.println(err);
        }
    }

    public String inputValue(String msg, String err, String inBase) {

        while (true) {
            try {
                System.out.println(msg);
                String value = sc.nextLine();
                // Binary
                if (inBase.equals("2")) {
                    if (value.matches("[0-1]+")) {
                        return value;
                    }
                }
                // Decimal
                if (inBase.equals("10")) {
                    if (inBase.matches("[0-9]+")) {
                        return value;
                    }
                }
                // Hexadecimal
                if (inBase.equals("16")) {
                    if (inBase.matches("[0-9A-F]+")) {
                        return value;
                    }
                }
            } catch (Exception e) {
                System.out.println(err);
            }

            System.out.println(err);
        }
    }

    // Continue
    public String inputYesNo(String msg, String err) {

        while (true) {
            try {
                System.out.println(msg);
                String yesNo = sc.nextLine();
                if (yesNo.matches("[yYNn]")) {
                    return yesNo;
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
            System.out.println(err);

        }
    }

}
