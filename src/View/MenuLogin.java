package View;

import Controller.ManageACC;
import Model.ErrorTB;

import java.io.Serializable;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MenuLogin{
    public static void menuLoin() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Register(only Admin)");
            System.out.println("2. Login");
            System.out.println("20. Exit");
            int choice = ErrorTB.creatErr(scanner);
            switch (choice) {
                case 1:
                    ManageACC.Register();
                    ManageACC.writetofile();
                    break;
                case 2:
                    ManageACC.Login();
                    break;
                case 20:
                    System.exit(parseInt("Bạn đã thoát chương trình"));
                    break;
                default:
                    System.out.println("Vui lòng nhập đúng");
            }
        }
    }
}

