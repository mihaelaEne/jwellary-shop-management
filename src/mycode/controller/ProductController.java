package mycode.controller;

import mycode.model.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    List<Product> products;

    public ProductController(List<Product> products) {
        this.products = products;
    }

    public ProductController() {
        this.products = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\jwellary-shop-management\\src\\mycode\\data\\product.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Product product = new Product(scanner.nextLine());
                this.products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisareProduct() {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            System.out.println(p.toString());
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getProduct_id() == id) {
                iterator.remove();
            }
        }

    }


    public Product findBuId(int id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getProduct_id() == id) {
                return p;
            }

        }
        return null;

    }

    public String toSave(){
        String text="";
        int i=0;
        for (i=0; i< products.size()-1; i++){
            text+=products.get(i).toSave()+"\n";
        }
        text+=products.get(i).toSave();
        return text;
    }

    public void save(){
        try{
            File file = new File("C:\\mycode\\OOP\\jwellary-shop-management\\src\\mycode\\data\\product.txt");

            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
