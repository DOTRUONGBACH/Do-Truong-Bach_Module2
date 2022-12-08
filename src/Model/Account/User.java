package Model.Account;

public class User extends Admin {
    private boolean Roll = false;

    @Override
    public boolean isRoll() {
        return Roll;
    }

    @Override
    public void setRoll(boolean roll) {
        Roll = roll;
    }

    public User(String uSer, String pasWord) {
        super(uSer, pasWord);
    }

}
