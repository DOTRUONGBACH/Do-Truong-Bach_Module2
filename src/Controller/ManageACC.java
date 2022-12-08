package Controller;

import Model.Account.Admin;
import View.Menu_Admin;
import View.User_menu;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManageACC {
    static ArrayList<Admin> account = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static File file = new File("accounts.txt");
    static String hello;
    static String UUser;

    public static void show() {
        readtofile();
        for (int i = 0; i < account.size(); i++) {
            System.out.println(account.get(i));
        }
    }

    public static String getHello() {
        return hello;
    }

    public static void setHello(String hello) {
        ManageACC.hello = hello;
    }
//static File file = new File("account.txt");

    public static void writetofile() {
//cách 1:
//        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
//            for (Map.Entry<String, String>theaccount: account.entrySet()) {
//                writer.write(theaccount.getKey()+" "+theaccount.getValue());
//                writer.newLine();
//            }
//    } catch (IOException e) {
//            System.out.println("Lỗi ghi file");
//            e.printStackTrace();
//        }
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {

            outputStream.writeObject(account);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readtofile() {
        //cách 1:
//        try ( BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            while (true) {
//                final String line = reader.readLine();
//                if (line == null){ break;}
//                else {
//                String txt [] = line.split("\\s+");
//                String user = txt[0];
//                String pass = txt[1];
//                account.put(user,pass);}
//            }
//        } catch (IOException e) {
//            System.out.println("File khong ton tai " +
//                    "hoac co loi trong luc doc.");
//            e.printStackTrace();
//        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            account = (ArrayList<Admin>) inputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();

        }
    }

    public static int findIndexbyuser(String user) {
        for (int i = 0; i < account.size(); i++) {
            if (user.equals(account.get(i).getuSer())) {
                return i;
            }

        }
        return -1;
    }

    public static int findIndexbypass(String pass) {
        for (int i = 0; i < account.size(); i++) {
            if (pass.equals(account.get(i).getPasWord())) {
                return i;
            }

        }
        return -1;
    }

    public static void Register() {
        readtofile();
        System.out.println("nhập username");
        UUser = scanner.nextLine();
        String pass;
        System.out.println("nhập password, bao gồm chữ và số");
        while (true) {
            try {
                pass = scanner.nextLine();
                if (validatePassWord(pass)) {
                    break;
                } else {
                    System.err.println("viết hoa chữ cái đầu tiên, kí tự và ít nhất 8 kí tự");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int check = findIndexbyuser(UUser);
        if (check == -1) {
            Admin accountoj = new Admin(UUser, pass);
            account.add(accountoj);
            System.out.println("Đăng ký thành công");
        } else {
            System.out.println("Tài khoản đã tồn tại");
        }
    }

    //check user tài khoản cấp cho user;
//public static boolean checkUser(String user){
//    for (int i = 0; i < Manage_room.arrayroom.size(); i++) {
//        if ((Manage_room.arrayroom.get(i).getRoomCode()+Manage_room.arrayroom.get(i).getId()).equals(user)){
//            return true;
//        }
//    }return false;
//}

//regex user để tạm đây.
//    public static boolean validateUserName(String regex) {
//        Pattern pattern = Pattern.compile("^[A-Za-z0-9].{6,20}$");
//        Matcher matcher = pattern.matcher(regex);
//        return matcher.matches();
//    }


    public static boolean validatePassWord(String regex) {
        Pattern pattern = Pattern.compile("^[A-Z][A-Za-z0-9].{6,}$");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void Login() {
        System.out.println("nhập username");
        String user = scanner.nextLine();
        UUser = user;
        System.out.println("nhập password, bao gồm chữ và số");
        String pass = scanner.nextLine();

        readtofile();
        int checkUser = findIndexbyuser(user);
        int checkPass = findIndexbypass(pass);
        if (checkUser != -1 && checkPass != -1) {
            if (account.get(checkUser).isRoll()) {
                System.out.println("Đăng nhập thành công");
                hello = "Hello " + user;
                Menu_Admin.menuAdmin();

            } else {
                System.out.println("Đăng nhập thành công");
                hello = "Hello " + user;
                WriteReadRoom.readtoBillfile();
                Manage_room.thongbaoBill();
                User_menu.userMenu();


            }
        } else {
            System.err.println("Tài khoản hoặc mật khẩu không đúng vui lòng đăng nhập lại");
        }

    }

    //mai đi học chửa change.
    public static void ChangePass() {
        System.out.println("nhập username");
        String user = scanner.nextLine();
        System.out.println("nhập password cũ");
        String pass = scanner.nextLine();
        readtofile();
        int checkUser = findIndexbyuser(user);
        int checkPass = findIndexbypass(pass);
        if (checkUser != -1 && checkPass != -1) {
            System.out.println("Nhập mật khẩu mới");
            String newpass = scanner.nextLine();
            account.get(checkUser).setPasWord(newpass);
            System.out.println("đổi mật khẩu thành công");
            ManageACC.writetofile();
        } else {
            System.out.println("Tài khoản hoặc mật khẩu sai ");
        }
    }

    public static void deleteAcc(int user) {
        account.remove(user);
    }

}



