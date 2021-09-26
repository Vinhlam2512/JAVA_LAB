
import Controllers.Options;
import Controllers.Validation;
import java.util.Scanner;
import Views.View;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        View v = new View();
        Options ops = new Options();
        Validation val = new Validation();
        int choice, size, n;
        String name;
        do {
            v.menu();
            choice = v.inputChoice();
            switch (choice) {
                case 1:
                    size = val.getId("Input number of storeKeeper you want to add: ", "You need to input integer!");
                    for (int i = 0; i < size; i++) {
                        n = i + 1;
                        name = val.getName("Input name of stor keeper " + n +" : ", "You need to input name of stor keeper!");
                        ops.addStoreKeeper(name);
                    }
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
                    ops.showNameStoreKeeper();
                    break;
            }
        } while (true);

    }
}
