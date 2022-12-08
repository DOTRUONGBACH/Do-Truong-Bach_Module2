package Model;

public class Bill extends Room {

double Waterbill;
double Electricbill;
double Total;

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public Bill(String roomCode, double cost, double wifi , double water, double electric, double total) {
        super(roomCode,cost);
        Waterbill = water;
        Electricbill = electric;
        Total = total;
    }

    public double getWaterbill() {
        return Waterbill;
    }

    public void setWaterbill(double waterbill) {
        Waterbill = waterbill;
    }

    public double getElectricbill() {
        return Electricbill;
    }

    public void setElectricbill(double electricbill) {
        Electricbill = electricbill;
    }

    @Override
    public String toString() {

        return "Bill{" + getRoomCode()+getId()+"---"+"Cost: "+getCost()+"---"+"Wifi: "+ getWifi() +"---"+
                "Waterbill: " + Waterbill +"---"+
                ", Electricbill=" + Electricbill +"---"+ "Total="+Total+
                '}';
    }
}
