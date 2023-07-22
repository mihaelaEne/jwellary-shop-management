package mycode.controller;

import mycode.model.Payment;
import mycode.model.Sales;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SalesController {

    List<Sales> sales;

    public SalesController( List<Sales> sales) {
        this.sales = sales;
    }

    public SalesController() {
        this.sales = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\jwellary-shop-management\\src\\mycode\\data\\sales.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Sales sales1= new Sales (scanner.nextLine());
                this.sales.add(sales1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisareSales() {
        Iterator<Sales> iterator = sales.iterator();
        while (iterator.hasNext()) {
           Sales s = iterator.next();
            System.out.println(s.toString());
        }
    }

    public void addSales(Sales sales1) {
        sales.add(sales1);
    }

    public void removeSales(int id) {
        Iterator<Sales> iterator = sales.iterator();
        while (iterator.hasNext()) {
            Sales s = iterator.next();
            if (s.getSales_id() == id) {
                iterator.remove();
            }
        }

    }


    public Sales findBuId(int id) {
        Iterator<Sales> iterator = sales.iterator();
        while (iterator.hasNext()) {
            Sales s = iterator.next();
            if (s.getSales_id() == id) {
                return s;
            }

        }
        return null;

    }

    public String toSave(){
        String text="";
        int i=0;
        for (i=0; i< sales.size()-1; i++){
            text+=sales.get(i).toSave()+"\n";
        }
        text+=sales.get(i).toSave();
        return text;
    }

    public void save(){
        try{
            File file = new File("C:\\mycode\\OOP\\jwellary-shop-management\\src\\mycode\\data\\sales.txt");

            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
