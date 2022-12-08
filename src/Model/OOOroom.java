package Model;

public class OOOroom extends Room {
    String Comment;
    String Status;

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    @Override
    public String getStatus() {
        return Status;
    }

    @Override
    public void setStatus(String status) {
        Status = status;
    }

    public OOOroom(String roomCodeO, String typeO, double costO, String statusO, String commentO) {
        super(roomCodeO, typeO, costO);
        Comment = commentO;
        this.Status = statusO;
    }

    @Override
    public String toString() {
        return getRoomCode() + getId()+"---"+getType() +"---"+ getCost() +"---"+ getStatus() +"---"+
                "Reason: " + Comment + '\'' +
                '}';
    }
}
