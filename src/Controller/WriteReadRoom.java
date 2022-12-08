package Controller;

import Model.Room;
import Model.Bill;

import java.io.*;
import java.util.ArrayList;

import static Controller.Manage_room.*;

public class WriteReadRoom {
    static File roomFile = new File("Room.txt");
    static File billFile = new File("Bill.txt");
    static File elecWaterFile = new File("Elecw.txt");
    static File IDfile = new File("ID.txt");


    public static void writetoRoomfile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(roomFile))) {
            outputStream.writeObject(arrayroom);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readtoRoomfile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(roomFile))) {
            arrayroom = (ArrayList<Room>) inputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void writetoBillfile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(billFile))) {
            outputStream.writeObject(bills);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readtoBillfile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(billFile))) {
            bills = (ArrayList<Bill>) inputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void writetoElecfile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(elecWaterFile))) {
            writer.write(ghiDiennuoc());
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
            e.printStackTrace();
        }
    }

    public static void readtoElecfile() {
        try {
            FileReader reader = new FileReader(elecWaterFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println("Điện: " + bufferedReader.readLine());
            System.out.println("Nước: " + bufferedReader.readLine());
            System.out.println("Wifi: " + bufferedReader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readtoElefile2() {
        try {
            FileReader reader = new FileReader(elecWaterFile);
            BufferedReader bufferedReader = new BufferedReader(reader);

            Elec = Double.parseDouble(bufferedReader.readLine());
            Water = Double.parseDouble(bufferedReader.readLine());
            Wifi = Double.parseDouble(bufferedReader.readLine());
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writetoIDfile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(IDfile))) {
            writer.write(id);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
            e.printStackTrace();
        }
    }

    public static void readtoIDfile() {
        try {
            FileReader reader = new FileReader(IDfile);
            BufferedReader bufferedReader = new BufferedReader(reader);
                id = Integer.parseInt(bufferedReader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}



