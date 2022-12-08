package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Room implements Serializable {
    private int id;



    private double Wifi;
    private Date checkIndate;

    private String status = "Occupancy";
    private double Water;
    private double Electric;
    private String roomCode;
    private String Type;
    private double Cost;

    public Room(String name, int id, String type, double cost, Date okdate, double water, double elec, double wifi) {
        this.roomCode = name;
        this.id = id;
        Type = type;
        Cost = cost;
        checkIndate = okdate;
        Water = water;
        Electric = elec;
        Wifi = wifi;
    }

    public Room(String roomCode, double cost) {
        this.roomCode = roomCode;
        this.Cost = cost;
    }


    public double getWifi() {
        return Wifi;
    }

    public void setWifi(double wifi) {
        Wifi = wifi;
    }

    public Room(String roomCode, String type, double cost) {
        this.roomCode = roomCode;
        this.Type = type;
        this.Cost = cost;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCheckIndate() {
        return checkIndate;
    }

    public void setCheckIndate(Date checkIndate) {
        this.checkIndate = checkIndate;
    }

    public double getWater() {
        return Water;
    }

    public void setWater(double water) {
        Water = water;
    }

    public double getElectric() {
        return Electric;
    }

    public void setElectric(double electric) {
        Electric = electric;
    }



    public String toString() {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        return "Roomcode: " + roomCode + id +
                ", Wifi: " + Wifi +
                ", checkIndate: " + date.format(checkIndate) +
                ", Status: " + status + '\'' +
                ", Water: " + Water +
                ", Electric: " + Electric +
                ", Type: " + Type + '\'' +
                ", Cost: " + Cost;
    }
}

