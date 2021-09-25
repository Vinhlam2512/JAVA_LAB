
import Controllers.Options;
import java.util.Scanner;
import Views.View;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        View v = new View();
        Options ops = new Options();
        int choice;
        do {
            v.menu();
            choice = v.inputChoice();
            switch (choice) {
                case 1:
                    ops.addStoreKeeper();
                    break;
                case 2:
                    ops.add();
                    break;
                case 3:
                    ops.updateProduct();
                    break;
                case 4:
                    ops.search();
                    break;
                case 5:
                    ops.sort();
                    break;
                case 6:
                    ops.addMany();
                    break;
                case 7:
                    ops.show();
                    break;
                case 8:
                    return;
            }
        } while (true);

    }
}
