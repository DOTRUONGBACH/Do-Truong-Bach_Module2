package Model;

import java.util.Date;

public class paidRoom extends Room {
String paidOrnot;

    public String getPaidOrnot() {
        return paidOrnot;
    }

    public void setPaidOrnot(String paidOrnot) {
        this.paidOrnot = paidOrnot;
    }

    public paidRoom(String name, int id, String type, double cost, Date okdate, double water, double elec, double wifi, String paid) {
        super(name, id, type, cost, okdate, water, elec, wifi);
        this.paidOrnot = paid;
    }

    public paidRoom(String roomCode, String type, double cost) {
        super(roomCode, type, cost);
    }

    @Override
    public String toString() {
        return super.toString()+ "----"  +
                  paidOrnot + '\'' +
                '}';
    }
}
