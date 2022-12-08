package View;

import Controller.ManageACC;
import Controller.Manage_room;
import Model.ErrorTB;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Menu_Admin_manager {
    public static void menuAdminmanager() {
        System.out.println(ManageACC.getHello());
        System.out.println("Hôm nay là " + Manage_room.Datenow());
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Change password");
            System.out.println("2. Xem phòng");
            System.out.println("3. Sửa phòng");
            System.out.println("4. Xóa phòng");
            System.out.println("5. Checkin");
            System.out.println("6. Checkout");
            System.out.println("7. Khóa phòng");
            System.out.println("8. Mở phòng");
            System.out.println("9. Quản lý bill");
            System.out.println("10.Xem tài khoản");
            System.out.println("11.Back");
            System.out.println("20.Logout");
            int Choice = ErrorTB.creatErr(scanner);
            switch (Choice) {
                case 1:
                    ManageACC.ChangePass();
                    break;
                case 2:
                    Menu_Showroom.showRoom();
                    break;
                case 3:
                    Edit_Room.editRoom();
                    break;
                case 4:
                    Manage_room.Delete();
                    break;
                case 5:
                    Menu_Checkin.menuCheckin();
                    break;
                case 6:
                    Menu_Checkout.menuCheckout();
                    break;
                case 7:
                    Manage_room.Lockroom();
                    break;
                case 8:
                    Manage_room.Openroom();
                    break;
                case 9:
                    menu_Bill_admin.menuBilladmin();
                    break;
                case 10:
                    ManageACC.show();
                    break;
                case 11:
                    Menu_Admin.menuAdmin();
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