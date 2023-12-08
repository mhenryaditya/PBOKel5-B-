package model;

import com.raven.swing.table.EventAction;
import com.raven.swing.table.ModelAction;

public class ModelBuyer {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoNota() {
        return noNota;
    }

    public void setNoNota(String noNota) {
        this.noNota = noNota;
    }

    public String getPesanan() {
        return pesanan;
    }

    public void setPesanan(String pesanan) {
        this.pesanan = pesanan;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ModelBuyer(String name, String noNota, String date, String pesanan, int count, int cPrice) {
        this.name = name;
        this.noNota = noNota;
        this.pesanan = pesanan;
        this.date = date;
        this.count = count;
        this.price = cPrice;
    }

    private String name;
    private String noNota;
    private String pesanan;
    private String date;
    private int count;
    private int price;

    public Object[] toRowTable(EventAction event) {
        return new Object[]{name, noNota, date, pesanan, count, price, new ModelAction(this, event)};
    }
}
