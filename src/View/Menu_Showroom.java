package View;

import Controller.Manage_room;
import Controller.WriteReadRoom;
import Model.ErrorTB;

import java.util.Scanner;

public class Menu_Showroom {
    public static void showRoom() {
        WriteReadRoom.readtoRoomfile();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.Xem phòng trống");
            System.out.println("2.Xem phòng đã checkin");
            System.out.println("3.Xem phòng đang khóa");
            System.out.println("4.Xem tất cả các phòng");
            System.out.println("5.Back");
            System.out.println("20.Logout");
            int Choice = ErrorTB.creatErr(scanner);
            switch (Choice) {
                case 1:
                    Manage_room.vcFilter();
                    break;
                case 2:
                    Manage_room.occFilter();
                    break;
                case 3:
                    Manage_room.oooFilter();
                    break;
                case 4:
                    Manage_room.Show();
                    break;
                case 5:
                    Menu_Admin_manager.menuAdminmanager();
                    break;
                case 20:
                    MenuLogin.menuLoin();
                    break;
                default:
                    System.err.println("Vui lòng chọn đúng số");
            }
        }
    }
}
