package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ErrorTB {
    public static int creatErr(Scanner scanner) {
        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number > 0) return number;
            throw new Exception();


        } catch (Exception exception) {
            System.err.println("Vui lòng nhập số > 0 ");
        }


        return creatErr(scanner);
    }


    public static double creatErr2(Scanner scanner) {

        try {
            double number = Double.parseDouble(scanner.nextLine());
            if (number > 0) return number;
            throw new Exception();


        } catch (Exception exception) {
            System.err.println("Vui lòng nhập số > 0 ");
        }


        return creatErr2(scanner);
    }

    public static Date creatErrdate(Scanner scanner) {
        Date checkIndate;
            String date = scanner.nextLine();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                checkIndate = format.parse(String.valueOf(date));
                return checkIndate;
            } catch (ParseException e) {
                System.out.println("Nhập lại ngày check in theo dạng dd/MM/yyyy");
            }
            return creatErrdate(scanner);
    }
}