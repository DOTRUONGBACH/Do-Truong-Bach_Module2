package View;

import Controller.Manage_room;
import Model.ErrorTB;

import java.util.Scanner;

public class Menu_Checkout {
    public static void menuCheckout() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Xem phòng đã checkin");
            System.out.println("2. Checkout");
            System.out.println("3. Back");
            System.out.println("20. Logout");
            int Choice = ErrorTB.creatErr(scanner);
            switch (Choice) {
                case 1:
                    Manage_room.occFilter();
                    break;
                case 2:
                    Manage_room.Checkout();
                    break;
                case 3:
                    Menu_Admin_manager.menuAdminmanager();
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
