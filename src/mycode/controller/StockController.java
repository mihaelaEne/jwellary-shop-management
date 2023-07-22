package mycode.controller;

import mycode.model.Payment;
import mycode.model.Stock;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StockController {
    List<Stock> stocks;

    public StockController(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public StockController() {
        this.stocks = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\jwellary-shop-management\\src\\mycode\\data\\stock.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
               Stock  stock = new Stock(scanner.nextLine());
                this.stocks.add(stock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisareStock() {
        Iterator<Stock> iterator = stocks.iterator();
        while (iterator.hasNext()) {
            Stock s = iterator.next();
            System.out.println(s.toString());
        }
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void removeStock(int id) {
        Iterator<Stock> iterator = stocks.iterator();
        while (iterator.hasNext()) {
            Stock s = iterator.next();
            if (s.getStock_id() == id) {
                iterator.remove();
            }
        }

    }


    public Stock findBuId(int id) {
        Iterator<Stock> iterator = stocks.iterator();
        while (iterator.hasNext()) {
            Stock s = iterator.next();
            if (s.getStock_id() == id) {
                return s;
            }

        }
        return null;

    }

    public String toSave(){
        String text="";
        int i=0;
        for (i=0; i< stocks.size()-1; i++){
            text+=stocks.get(i).toSave()+"\n";
        }
        text+=stocks.get(i).toSave();
        return text;
    }

    public void save(){
        try{
            File file = new File("C:\\mycode\\OOP\\jwellary-shop-management\\src\\mycode\\data\\stock.txt");

            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
