package View;

import Controller.Manage_room;
import Model.ErrorTB;

import java.util.Scanner;

public class menu_Bill_admin {
    public static void menuBilladmin(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Tạo bill");
            System.out.println("2. Xem bill");
            System.out.println("3. Sắp xếp bill");
            System.out.println("4. Xác nhận bill");
            System.out.println("5. Back");
            System.out.println("20. Logout");
            int Choice = ErrorTB.creatErr(scanner);
            switch (Choice){
                case 1: Manage_room.Bill();
                break;
                case 2: Manage_room.showBills();
                break;
                case 3: Manage_room.compareBillbytotal();
                break;
                case 4: Manage_room.Paidroom();
                break;
                case 5: Menu_Admin_manager.menuAdminmanager();
                    break;
                case 20: MenuLogin.menuLoin();
                break;
                default:
                    System.out.println("Vui lòng nhập đúng");
            }
        }
    }
}
