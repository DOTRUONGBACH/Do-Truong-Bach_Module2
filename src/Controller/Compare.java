package Controller;

import Model.Bill;
import Model.Room;

import java.util.Comparator;

public class Compare implements Comparator<Bill> {


    @Override
    public int compare(Bill o1, Bill o2) {
        if ( o1.getTotal() == o2.getTotal() )
            return 0;
        else if (o1.getTotal() > o2.getTotal() )
            return 1;
        else
            return -1;
    }
}
