package mycode.model;

import java.util.Objects;

public class Sales {

    private String sales_type;
    private int sales_id;
    private int sales_customer_id;
    private int sales_amount;
    private String sales_description;

    public Sales(){}

    public Sales(String sales_type, int sales_id, int sales_customer_id, int sales_amount, String sales_description) {
        this.sales_type = sales_type;
        this.sales_id = sales_id;
        this.sales_customer_id = sales_customer_id;
        this.sales_amount = sales_amount;
        this.sales_description = sales_description;
    }
    public Sales(String prop) {
        String [] split=prop.split(",");
        this.sales_type = split[0];
        this.sales_id = Integer.parseInt(split[1]);
        this.sales_customer_id =  Integer.parseInt(split[2]);
        this.sales_amount =  Integer.parseInt(split[3]);
        this.sales_description = split[4];
    }

    public String getSales_type() {
        return sales_type;
    }

    public void setSales_type(String sales_type) {
        this.sales_type = sales_type;
    }

    public int getSales_id() {
        return sales_id;
    }

    public void setSales_id(int sales_id) {
        this.sales_id = sales_id;
    }

    public int getSales_customer_id() {
        return sales_customer_id;
    }

    public void setSales_customer_id(int sales_customer_id) {
        this.sales_customer_id = sales_customer_id;
    }

    public int getSales_amount() {
        return sales_amount;
    }

    public void setSales_amount(int sales_amount) {
        this.sales_amount = sales_amount;
    }

    public String getSales_description() {
        return sales_description;
    }

    public void setSales_description(String sales_description) {
        this.sales_description = sales_description;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "sales_type='" + sales_type + '\'' +
                ", sales_id=" + sales_id +
                ", sales_customer_id=" + sales_customer_id +
                ", sales_amount=" + sales_amount +
                ", sales_description='" + sales_description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sales)) return false;
        Sales sales = (Sales) o;
        return sales_id == sales.sales_id && sales_customer_id == sales.sales_customer_id && sales_amount == sales.sales_amount && sales_type.equals(sales.sales_type) && sales_description.equals(sales.sales_description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sales_type, sales_id, sales_customer_id, sales_amount, sales_description);
    }

    public String toSave(){
        return sales_type+","+sales_id+","+sales_customer_id+","+sales_amount+","+sales_description;
    }
}
