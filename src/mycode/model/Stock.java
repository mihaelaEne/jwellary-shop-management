package mycode.model;

import java.util.Objects;

public class Stock {

    private String stock_type;
    private int stock_id;
    private int stock_items;
    private int stock_number;
    private String stock_description;

    public Stock(){}

    public Stock(String stock_type, int stock_id, int stock_items, int stock_number, String stock_description) {
        this.stock_type = stock_type;
        this.stock_id = stock_id;
        this.stock_items = stock_items;
        this.stock_number = stock_number;
        this.stock_description = stock_description;
    }
    public Stock(String prop) {
        String [] split=prop.split(",");
        this.stock_type = split[0];
        this.stock_id = Integer.parseInt(split[1]);
        this.stock_items = Integer.parseInt(split[2]);
        this.stock_number = Integer.parseInt(split[3]);
        this.stock_description = split[4];
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stock_type='" + stock_type + '\'' +
                ", stock_id=" + stock_id +
                ", stock_items=" + stock_items +
                ", stock_number=" + stock_number +
                ", stock_description='" + stock_description + '\'' +
                '}';
    }

    public String getStock_type() {
        return stock_type;
    }

    public void setStock_type(String stock_type) {
        this.stock_type = stock_type;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public int getStock_items() {
        return stock_items;
    }

    public void setStock_items(int stock_items) {
        this.stock_items = stock_items;
    }

    public int getStock_number() {
        return stock_number;
    }

    public void setStock_number(int stock_number) {
        this.stock_number = stock_number;
    }

    public String getStock_description() {
        return stock_description;
    }

    public void setStock_description(String stock_description) {
        this.stock_description = stock_description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;
        Stock stock = (Stock) o;
        return stock_id == stock.stock_id && stock_items == stock.stock_items && stock_number == stock.stock_number && stock_type.equals(stock.stock_type) && stock_description.equals(stock.stock_description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stock_type, stock_id, stock_items, stock_number, stock_description);
    }

    public String toSave(){
        return stock_type+","+stock_id+","+stock_items+","+stock_number+","+stock_description;
    }
}
