package Model.Account;

import java.io.Serializable;

public class Admin implements Serializable {
    private String uSer;
    private String pasWord;
    private boolean Roll = true;

    public Admin(String uSer, String pasWord) {
        this.uSer = uSer;
        this.pasWord = pasWord;
    }

    public boolean isRoll() {
        return Roll;
    }

    public void setRoll(boolean roll) {
        Roll = roll;
    }

    public String getuSer() {
        return uSer;
    }

    public void setuSer(String uSer) {
        this.uSer = uSer;
    }

    public String getPasWord() {
        return pasWord;
    }

    public void setPasWord(String pasWord) {
        this.pasWord = pasWord;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "uSer='" + uSer + '\'' +
                ", pasWord='" + pasWord + '\'' +
                '}';
    }
}
