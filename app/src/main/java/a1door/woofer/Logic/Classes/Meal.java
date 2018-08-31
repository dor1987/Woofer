package a1door.woofer.Logic.Classes;

import java.util.Date;

public class Meal {

    private double amount;
    private String date;

    public Meal(double amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}
