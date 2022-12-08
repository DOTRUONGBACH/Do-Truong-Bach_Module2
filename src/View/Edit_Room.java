package View;

import Controller.Manage_room;
import Model.ErrorTB;

import java.util.Scanner;

public class Edit_Room {
    public static void editRoom() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Sửa mô tả phòng");
            System.out.println("2. Sửa giá phòng");
            System.out.println("3. Đổi phòng");
            System.out.println("4. Back");
            System.out.println("20. Logout");
            int Choice = ErrorTB.creatErr(scanner);
            switch (Choice) {
                case 1:
                    Manage_room.EditType();
                    break;
                case 2:
                    Manage_room.EditCost();
                    break;
                case 3:
                    Manage_room.changeRoom();
                    break;
                case 4:
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

