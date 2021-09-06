package solution;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Controllers {

    static Scanner sc = new Scanner(System.in);

    public static void findDay(int month, int day, int year) {
        String result;
        LocalDate date = LocalDate.of(year, month, day);
        result = date.getDayOfWeek().toString();         // toString to get the result
        System.out.println(result);
        // getDayOfWeek return enum
        // enum là 1 lớp đặc biệt đại diện cho hằng số
    }

    public static void getDate() {
        while (true) {
            try {
                System.out.print("Please enter date with format [dd/mm/yyyy]: ");
                String splited[] = sc.nextLine().split("/");
                int month = Integer.parseInt(splited[1]);
                int day = Integer.parseInt(splited[0]);
                int year = Integer.parseInt(splited[2]);
                if (validateYear(year) != 0) {
                    findDay(month, day, year);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please re input the correct format");
            }
        }
    }

    public static int validateYear(int year) {
        if (1000 > year || year > 9999) {
            System.out.println("Please input year in 1000 to 9999");
            return 0;
        }
        return 1;
    }
}
}
