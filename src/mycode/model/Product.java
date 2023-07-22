package mycode.model;

import java.util.Objects;

public class Product {
    private String product_type;
    private int product_id;
    private int product_customer_id;
    private String product_items;
    private int product_number;
    private String product_description;

    private Product(){}
    public Product(String product_type, int product_id, int product_customer_id, String product_items, int product_number, String product_description) {
        this.product_type = product_type;
        this.product_id = product_id;
        this.product_customer_id = product_customer_id;
        this.product_items = product_items;
        this.product_number = product_number;
        this.product_description = product_description;
    }

    public Product(String prop){
        String [] split=prop.split(",");
        this.product_type = split[0];
        this.product_id = Integer.parseInt(split[1]);
        this.product_customer_id = Integer.parseInt(split[2]);
        this.product_items =  split[3];
        this.product_number =  Integer.parseInt(split[4]);
        this.product_description = split[5];
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_customer_id() {
        return product_customer_id;
    }

    public void setProduct_customer_id(int product_customer_id) {
        this.product_customer_id = product_customer_id;
    }

    public String getProduct_items() {
        return product_items;
    }

    public void setProduct_items(String product_items) {
        this.product_items = product_items;
    }

    public int getProduct_number() {
        return product_number;
    }

    public void setProduct_number(int product_number) {
        this.product_number = product_number;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_type='" + product_type + '\'' +
                ", product_id=" + product_id +
                ", product_customer_id=" + product_customer_id +
                ", product_items='" + product_items + '\'' +
                ", product_number=" + product_number +
                ", product_description='" + product_description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return product_id == product.product_id && product_customer_id == product.product_customer_id && product_number == product.product_number && product_type.equals(product.product_type) && product_items.equals(product.product_items) && product_description.equals(product.product_description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_type, product_id, product_customer_id, product_items, product_number, product_description);
    }

    public String toSave(){
        return product_type+","+ product_id+","+product_customer_id+","+product_items+","+product_number+","+product_description;
    }
}
