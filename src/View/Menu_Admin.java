package View;

import Controller.ManageACC;
import Controller.Manage_room;
import Controller.WriteReadRoom;
import Model.ErrorTB;

import java.util.Scanner;

public class Menu_Admin {
    public static void menuAdmin() {
        System.out.println(ManageACC.getHello());
        System.out.println("Hôm nay là " + Manage_room.Datenow()+" ⛅");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Tạo phòng trọ");
            System.out.println("2. Xem thông tin điện nước");
            System.out.println("3. Quản lý phòng trọ");
            System.out.println("20. Logout");
            int Choice = ErrorTB.creatErr(scanner);
            switch (Choice) {
                case 1:
                    Manage_room.Creatwaterelecwifi();
                    Manage_room.addlistVacancy();
                    WriteReadRoom.writetoElecfile();
                    break;
                case 2:
                    WriteReadRoom.readtoElecfile();
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
