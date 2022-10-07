import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;

public class Purchases {

    private String title;
    private String date;
    private int sum;

    public Purchases() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


    @Override
    public String toString() {
        return title + "," + date + "," + sum;
    }

    //  метод ввода данных в формате json
    public String toJson() throws IOException {

        Purchases purchases = new Purchases();
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String[] parts = message.split(" ");
        purchases.title = parts[0];
        purchases.date = parts[1];
        purchases.sum = Integer.parseInt(parts[2]);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        var str = gson.toJson(purchases);
        return str;
    }
}