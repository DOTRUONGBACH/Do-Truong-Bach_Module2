package View;

import Controller.ManageACC;
import Controller.Manage_room;
import Controller.WriteReadRoom;
import Model.ErrorTB;

import java.util.Scanner;

public class User_menu {
    public static void userMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("⛹" + ManageACC.getHello());
            System.out.println("1. Change Password");
            System.out.println("2. Xem phòng trống");
            System.out.println("3. Xem bill ");
            System.out.println("20. Logout");
            int Choice = ErrorTB.creatErr(scanner);
            switch (Choice) {
                case 1:
                    ManageACC.ChangePass();
                    break;
                case 2:
                    Manage_room.vcFilter();
                    break;
                case 3:
                    Manage_room.userReadbill();
                    break;
                case 20:
                    MenuLogin.menuLoin();
                    break;
                default:
                    System.out.println("Vui lòng nhập đúng");
            }
        }
    }
}
