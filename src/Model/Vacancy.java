package Model;

public class Vacancy extends Room {

    private String status = "Vacancy";

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        status = status;
    }

    public Vacancy(String roomCode, String type, double cost) {
        super(roomCode, type, cost);
    }

    @Override
    public String toString() {
        return this.getRoomCode()+getId()+"\t" +this.getType()+"\t"+this.getCost() +"\t" + status;
    }
}
