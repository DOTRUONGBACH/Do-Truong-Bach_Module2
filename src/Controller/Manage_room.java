package Controller;

import Model.*;
import Model.Account.User;
import Model.ErrorTB;

import java.awt.dnd.InvalidDnDOperationException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Manage_room {
    static ArrayList<Room> arrayroom = new ArrayList<>();
    static ArrayList<Bill> bills = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static String codeVC;
    static String typeVC;
    static double costVC;
static int id = 1;

    static double Elec;
    static double Water;
    static double Wifi;
    static String userName;
    static String passWord;
    static String thongBao = "Chưa có thông báo";

    public static String getUserName() {
        return userName;
    }

    static String nameX;

//    public static void setUserName(String userName) {
//        Manage_room.userName = userName;
//    }
//
//    public static String getPassWord() {
//        return passWord;
//    }
//
//    public static void setPassWord(String passWord) {
//        Manage_room.passWord = passWord;
//    }

    //Hiển thị dánh sách
    public static void Show() {
        WriteReadRoom.readtoRoomfile();
        int j = 0;
        for (int i = 0; i < arrayroom.size(); i++) {
            System.out.println(arrayroom.get(i).toString());
            j++;
        }
        if (j == 0) {
            System.out.println("Chưa có phòng nào");
        }
    }

    public static String ghiDiennuoc() {
        String TT = Elec + "\n" + Water + "\n" + Wifi;
        return TT;

    }

    public static void thongbaoBill() {
        int index = findindexbyUser();
        if (index != -1) {
            thongBao = "Bạn có bill đấy, vui lòng thanh toán";
            System.err.println(thongBao);
        } else {
            System.out.println(thongBao);
        }

    }

    public static int findindexbyUser() {
        for (int i = 0; i < bills.size(); i++) {
            if (ManageACC.UUser.equals(bills.get(i).getRoomCode() + bills.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    public static void userReadbill() {//can tao search bill
        int index = findindexbyUser();
        if (index == -1) {
            System.out.println(" Bạn chưa có bill nào");
        } else {
            Manage_room.thongBao = "Bạn có bill đấy,thanh toán đi";
            System.out.println(bills.get(index));
        }


    }

    //Thêm số lượng phòng trống.
    public static void ChangeToVC(int index) {
        WriteReadRoom.readtoRoomfile();
        String code = arrayroom.get(index).getRoomCode();
        String type = arrayroom.get(index).getType();
        double cost = arrayroom.get(index).getCost();
        int id = arrayroom.get(index).getId();
        Vacancy newRoom = new Vacancy(code, type, cost);
        newRoom.setStatus("Vacancy");
        newRoom.setId(id);
        arrayroom.set(index, newRoom);
        WriteReadRoom.writetoRoomfile();
    }

    //Tạo danh sách phòng trống mới.
    public static void addlistVacancy() {
        WriteReadRoom.readtoElefile2();
        WriteReadRoom.readtoRoomfile();
        System.out.println("Nhập số lượng phòng");
        int qttRoomVc = ErrorTB.creatErr(scanner);
        System.out.println("Nhập kiểu phòng");
        typeVC = scanner.nextLine();
        System.out.println("Nhập mã phòng");
        codeVC = scanner.nextLine();
        System.out.println("Nhập giá phòng/tháng");
        costVC = ErrorTB.creatErr2(scanner);
        for (int i = 0; i < qttRoomVc; i++) {
            Vacancy newRoom = new Vacancy(codeVC, typeVC, costVC);
            newRoom.setId(id);
            arrayroom.add(newRoom);
            id++;
        }
        WriteReadRoom.writetoIDfile();
        WriteReadRoom.writetoElecfile();
        WriteReadRoom.writetoRoomfile();
        System.out.println("Tạo phòng thành công.");
    }


    //Tìm kiếm theo tên phòng (Tên = code + id)
    public static int Search() {
        WriteReadRoom.readtoRoomfile();
        while (true) {
            String search = scanner.nextLine();
            String name;
            for (int i = 0; i < arrayroom.size(); i++) {
                name = arrayroom.get(i).getRoomCode() + arrayroom.get(i).getId();
                if (search.equals(name)) {
                    System.out.println(arrayroom.get(i).toString());
                    return i;
                }
            }
            return -1;
        }
    }

    //Tạo giá điên nước wifi
    public static void Creatwaterelecwifi() {
        System.out.println("Nhập tiền điện/Kw");
        Elec = ErrorTB.creatErr2(scanner);
        System.out.println("Nhập tiền nước/M3");
        Water = ErrorTB.creatErr2(scanner);
        System.out.println("Nhập tiền mạng/tháng");
        Wifi = ErrorTB.creatErr2(scanner);
    }

    //check in phòng mới
    public static void Checkin() {
        WriteReadRoom.readtoRoomfile();
        System.out.println("Nhập tên phòng");
        int index = Search();
        if (index != -1) {
            if (arrayroom.get(index).getStatus().equals("OOO")) {
                System.out.println("Phòng này đang sửa");
            }
            if (arrayroom.get(index).getStatus().equals("Occupancy")) {
                System.out.println("Phòng này đang có người ở");
            } else {
                String nameOcc = arrayroom.get(index).getRoomCode();
                int idOcc = arrayroom.get(index).getId();
                String typeOCC = arrayroom.get(index).getType();
                double costOcc = arrayroom.get(index).getCost();
                System.out.println("Nhập ngày tháng năm checkin dạng dd/MM/yyyy");
                Date checkIndate = ErrorTB.creatErrdate(scanner);
                Room newRoom = new Room(nameOcc, idOcc, typeOCC, costOcc, checkIndate, Water, Elec, Wifi);
                arrayroom.set(index, newRoom);
                String username = newRoom.getRoomCode() + newRoom.getId();
                System.out.println("Check in " + username + " thành công");
                String pass = "1";
                User accUser = new User(username, pass);
                ManageACC.account.add(accUser);
                ManageACC.writetofile();
                provideAcc(username, pass);
                WriteReadRoom.writetoRoomfile();
            }
        } else {
            System.out.println("Không có phòng này");
        }
    }

    public static void provideAcc(String user, String password) {
        userName = user;
        passWord = password;
        System.out.println("đã tạo tài khoản mặc định cho user với username là: " + userName + " và mật khẩu là " + passWord);
    }

    public static void Checkout() {
        int index = Search();
        if (arrayroom.get(index).getStatus().equals("Vacancy")) {
            System.out.println("Phòng này trống, không thể check out");
        } else if (arrayroom.get(index).getStatus().equals("Occupancy")) {
            ChangeToVC(index);
            ManageACC.deleteAcc(index);
            System.out.println("Check out thành công");

        } else {
            System.out.println("Phòng này đang sửa");
        }
        WriteReadRoom.writetoRoomfile();
    }

    public static void Lockroom() {
        WriteReadRoom.readtoRoomfile();
        int index = Search();
        if (arrayroom.get(index).getStatus().equals("Vacancy")) {
            String roomCodeO = arrayroom.get(index).getRoomCode();
            int idO = arrayroom.get(index).getId();
            String statusO = "OOO";
            String typeO = arrayroom.get(index).getType();
            double costO = arrayroom.get(index).getCost();
            System.out.println("Nhập nguyên nhân Lock");
            String commentO = scanner.nextLine();

            OOOroom newOOO = new OOOroom(roomCodeO, typeO, costO, statusO, commentO);
            newOOO.setId(idO);
            arrayroom.set(index, newOOO);
            System.out.println("Lock thành công");
            WriteReadRoom.writetoRoomfile();
        }
    }

    public static void Openroom() {
        WriteReadRoom.readtoRoomfile();
        int index = Search();
        if (arrayroom.get(index).getStatus().equals("OOO")) {
            ChangeToVC(index);
            System.out.println("Open thành công");
        } else {
            System.out.println("Phòng này đang không khóa mà");
        }
        WriteReadRoom.writetoRoomfile();
    }
//    public static void Edit() {
//        int index = Search();
//        while (true) {
//            System.out.println("1.Sửa giá phòng");
//            System.out.println("2.Sửa mô tả phòng");
//            if (index != -1) {
//                int choice = Error.creatErr(scanner);
//                switch (choice) {
//                    case 1:
//                        Suagia();
//                        break;
//                    case 2:
//                        Suatype();
//                        break;
//                    default:
//                        System.err.println("Không có lựa chọn này");
//                }
//            }
//        }
//
//    }

    public static void EditCost() {
        WriteReadRoom.readtoRoomfile();
        int index = Search();
        System.out.println("Nhập giá phòng mới");
        double newGia = ErrorTB.creatErr2(scanner);
        arrayroom.get(index).setCost(newGia);
        System.out.println("Sửa thành công");
        WriteReadRoom.writetoRoomfile();
    }

    public static void EditType() {
        WriteReadRoom.readtoRoomfile();
        int index = Search();
        System.out.println("Nhập mô tả mới");
        String newType = scanner.nextLine();
        arrayroom.get(index).setType(newType);
        System.out.println("Sửa thành công");
        WriteReadRoom.writetoRoomfile();
    }

    public static void Delete() {
        WriteReadRoom.readtoRoomfile();
        System.out.println("Nhập phòng cần xóa");
        int index = Search();
        System.out.println("Đã xóa " + arrayroom.remove(index));
        WriteReadRoom.writetoRoomfile();
    }

    public static void deleteBill(String nameX) {
        for (int i = 0; i < bills.size(); i++) {
            if (nameX.equals(bills.get(i).getRoomCode() + bills.get(i).getId())) {
                bills.remove(i);
            }
        }
        WriteReadRoom.writetoBillfile();
    }

    public static void changeRoom() {
        WriteReadRoom.readtoElefile2();
        WriteReadRoom.readtoRoomfile();
        System.out.println("Nhập phòng đang ở");
        int index = Search();
        if (arrayroom.get(index).getStatus().equals("Occupancy")) {
            ChangeToVC(index);
            ManageACC.deleteAcc(index);
            System.out.println("Nhập phòng muốn chuyển sang");
            int index2 = Search();
            if (index2 != -1) {
                if (arrayroom.get(index2).getStatus().equals("OOO")) {
                    System.out.println("Phòng này đang sửa");
                }
                if (arrayroom.get(index2).getStatus().equals("Occupancy")) {
                    System.out.println("Phòng này đang có người ở");
                } else {
                    String code = arrayroom.get(index2).getRoomCode();
                    int id = arrayroom.get(index2).getId();
                    String type = arrayroom.get(index2).getType();
                    double cost = arrayroom.get(index2).getCost();
                    System.out.println("Nhập ngày tháng năm chuyển phòng dạng dd/MM/yyyy");
                    Date checkIndate = ErrorTB.creatErrdate(scanner);
                    Room newRoom = new Room(code, id, type, cost, checkIndate, Water, Elec, Wifi);
                    arrayroom.set(index2, newRoom);
                    String username = newRoom.getRoomCode() + newRoom.getId();
                    System.out.println("Check in " + username + " thành công");
                    String pass = "1";
                    User accUser = new User(username, pass);
                    ManageACC.account.add(accUser);
                    ManageACC.writetofile();
                    provideAcc(username, pass);
                    System.out.println("Chuyển phòng thành công.");

                }
            }

        } else {
            System.out.println("Phòng này đang trống");
        }
        WriteReadRoom.writetoRoomfile();
    }

    public static String Datenow() {
        String dateNow;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        dateNow = formatter.format(new Date());
        return dateNow;
    }

    public static void Paidroom() {
        WriteReadRoom.readtoRoomfile();
        WriteReadRoom.readtoElefile2();
        System.out.println("Nhập phòng");
        int index = Search();
        if (arrayroom.get(index).getStatus().equals("Occupancy")) {
            String name = arrayroom.get(index).getRoomCode();
            nameX = arrayroom.get(index).getRoomCode() + arrayroom.get(index).getId();
            int id = arrayroom.get(index).getId();
            String type = arrayroom.get(index).getType();
            double cost = arrayroom.get(index).getCost();
            Date okdate = arrayroom.get(index).getCheckIndate();
            double water = arrayroom.get(index).getWater();
            double elec = arrayroom.get(index).getElectric();
            double wifi = arrayroom.get(index).getWifi();
            deleteBill(nameX);
            String paid = "Paid";
            paidRoom paidRoom = new paidRoom(name, id, type, cost, okdate, water, elec, wifi, paid);
            arrayroom.set(index, paidRoom);
            System.out.println("Xác nhận thanh toán thành công");
            WriteReadRoom.writetoRoomfile();
            arrayroom.remove(index);
        } else {
            System.out.println("phòng này trống");
        }
    }

    public static void Bill() {

        WriteReadRoom.readtoRoomfile();
        WriteReadRoom.readtoElefile2();
        System.out.println("Nhập phòng");
        int index = Search();
        if (arrayroom.get(index).getStatus().equals("Occupancy")) {
            String roomCode = arrayroom.get(index).getRoomCode();
            double cost = arrayroom.get(index).getCost();
            System.out.println("Nhập số nước tháng này ");
            int waterNum = ErrorTB.creatErr(scanner);
            System.out.println("Nhập số đện tháng này ");
            int elecNum = ErrorTB.creatErr(scanner);
            double water = Water * waterNum;
            double electric = Elec * elecNum;
            double total = cost + water + electric + Wifi;
            int Id = arrayroom.get(index).getId();
            Bill bill = new Bill(roomCode, cost, Wifi, water, electric, total);
            bill.setWifi(Wifi);
            bill.setId(Id);
            bills.add(bill);
            WriteReadRoom.writetoBillfile();
        }
    }

    public static void showBills() {
        WriteReadRoom.readtoElefile2();
        int j = 0;
        WriteReadRoom.readtoBillfile();
        for (int i = 0; i < bills.size(); i++) {
            System.out.println(bills.get(i).toString());
            j++;
        }
        if (j == 0) {
            System.out.println("Chưa có bill nào.");
        }
    }

    public static void vcFilter() {
        WriteReadRoom.readtoElefile2();
        WriteReadRoom.readtoRoomfile();
        int count = 0;
        for (int i = 0; i < arrayroom.size(); i++) {
            if (arrayroom.get(i).getStatus().equals("Vacancy")) {
                System.out.println(arrayroom.get(i));
                count++;
            }
        }
        System.err.println("Hiện có " + count + " phòng trống");
    }

    public static void occFilter() {
        WriteReadRoom.readtoElefile2();
        WriteReadRoom.readtoRoomfile();
        int count = 0;
        for (int i = 0; i < arrayroom.size(); i++) {
            if (arrayroom.get(i).getStatus().equals("Occupancy")) {
                System.out.println(arrayroom.get(i));
                count++;
            }
        }
        System.err.println("Hiện có " + count + " phòng đã checkin ");
    }

    public static void oooFilter() {
        WriteReadRoom.readtoRoomfile();
        int count = 0;
        for (int i = 0; i < arrayroom.size(); i++) {
            if (arrayroom.get(i).getStatus().equals("OOO")) {
                System.out.println(arrayroom.get(i));
                count++;
            }
        }
        System.err.println("Hiện có " + count + " phòng đang khóa ");
    }
    public static void compareBillbytotal (){
        bills.sort(new Compare());
        for (int i = 0; i < bills.size(); i++) {
            System.out.println(bills.get(i));
        }
    }
}
