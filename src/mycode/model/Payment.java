package mycode.model;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

public class Payment {
    private  int payment_id;
    private int payment_customer_id;
    private String payment_date;
    private int payment_amount;
    private String payment_description;

    public Payment(){}


    public Payment(int payment_id, int payment_customer_id, String payment_date, int payment_amount, String payment_description) {
        this.payment_id = payment_id;
        this.payment_customer_id = payment_customer_id;
        this.payment_date = payment_date;
        this.payment_amount = payment_amount;
        this.payment_description = payment_description;
    }

    public Payment(String prop){
        String[] split = prop.split(",");
        this.payment_id=Integer.parseInt(split[0]);
        this.payment_customer_id=Integer.parseInt(split[1]);
        this.payment_date= split[2];
        this.payment_amount=Integer.parseInt(split[3]);
        this.payment_description=split[4];

    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getPayment_customer_id() {
        return payment_customer_id;
    }

    public void setPayment_customer_id(int payment_customer_id) {
        this.payment_customer_id = payment_customer_id;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public int getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(int payment_amount) {
        this.payment_amount = payment_amount;
    }

    public String getPayment_description() {
        return payment_description;
    }

    public void setPayment_description(String payment_description) {
        this.payment_description = payment_description;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + payment_id +
                ", payment_customer_id=" + payment_customer_id +
                ", payment_date=" + payment_date +
                ", payment_amount=" + payment_amount +
                ", payment_description='" + payment_description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return payment_id == payment.payment_id && payment_customer_id == payment.payment_customer_id && payment_amount == payment.payment_amount && payment_date.equals(payment.payment_date) && payment_description.equals(payment.payment_description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payment_id, payment_customer_id, payment_date, payment_amount, payment_description);
    }

    public String toSave(){
        return payment_id+","+payment_customer_id+","+ payment_date+","+payment_amount+","+payment_description;
    }
}
