package mycode.controller;

import mycode.model.Payment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PaymentController {
    List<Payment> payments;

    public PaymentController(List<Payment> payments) {
        this.payments = payments;
    }

    public PaymentController() {
        this.payments = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\jwellary-shop-management\\src\\mycode\\data\\payment.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Payment payment = new Payment(scanner.nextLine());
                this.payments.add(payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisarePayment() {
        Iterator<Payment> iterator = payments.iterator();
        while (iterator.hasNext()) {
            Payment p = iterator.next();
            System.out.println(p.toString());
        }
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public void removePaymengt(int id) {
        Iterator<Payment> iterator = payments.iterator();
        while (iterator.hasNext()) {
            Payment p = iterator.next();
            if (p.getPayment_id() == id) {
                iterator.remove();
            }
        }

    }


    public Payment findBuId(int id) {
        Iterator<Payment> iterator = payments.iterator();
        while (iterator.hasNext()) {
            Payment pp = iterator.next();
            if (pp.getPayment_id() == id) {
               return pp;
            }

        }
        return null;

    }

    public String toSave(){
        String text="";
        int i=0;
        for (i=0; i< payments.size()-1; i++){
            text+=payments.get(i).toSave()+"\n";
        }
        text+=payments.get(i).toSave();
        return text;
    }

    public void save(){
        try{
            File file = new File("C:\\mycode\\OOP\\jwellary-shop-management\\src\\mycode\\data\\payment.txt");

            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
