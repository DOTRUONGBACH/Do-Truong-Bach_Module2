package View;

import Controller.ManageACC;
import Controller.Manage_room;
import Controller.WriteReadRoom;
import Model.ErrorTB;

import java.util.Scanner;

public class Menu_Checkin {
    public static void menuCheckin() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Xem phòng trống");
            System.out.println("2. Checkin");
            System.out.println("3. Back");
            System.out.println("20. Logout");
            int Choice = ErrorTB.creatErr(scanner);
            switch (Choice) {
                case 1:
                    Manage_room.vcFilter();
                    break;
                case 2:
                    Manage_room.Checkin();
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
