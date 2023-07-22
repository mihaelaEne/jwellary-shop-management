package mycode.controller;

import mycode.model.Jwellary;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class JwellaryController {

    List<Jwellary> jwellaries;

    public JwellaryController(List<Jwellary> jwellaries) {
        this.jwellaries = jwellaries;
    }

    public JwellaryController() {
        this.jwellaries = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\jwellary-shop-management\\src\\mycode\\model\\Jwellary.java");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Jwellary jwellary = new Jwellary(scanner.nextLine());
                this.jwellaries.add(jwellary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisareJwellary() {
        Iterator<Jwellary> iterator = jwellaries.iterator();
        while (iterator.hasNext()) {
            Jwellary j = iterator.next();
            System.out.println(j.toString());
        }
    }

    public void addJwellary(Jwellary jwellary) {
        jwellaries.add(jwellary);
    }

    public void removeJwellary(int id) {
        Iterator<Jwellary> iterator = jwellaries.iterator();
        while (iterator.hasNext()) {
            Jwellary j = iterator.next();
            if (j.getJwellary_id() == id) {
                iterator.remove();
            }
        }

    }


    public Jwellary findBuId(int id) {

        Iterator<Jwellary> iterator = jwellaries.iterator();
        while (iterator.hasNext()) {
            Jwellary j = iterator.next();
            if (j.getJwellary_id() == id) {
                return j;
            }

        }
        return null;

    }

    public String toSave(){
        String text="";
        int i=0;
        for (i=0; i< jwellaries.size()-1; i++){
            text+=jwellaries.get(i).toSave()+"\n";
        }
        text+=jwellaries.get(i).toSave();
        return text;
    }

    public void save(){
        try{
            File file = new File("C:\\mycode\\OOP\\jwellary-shop-management\\src\\mycode\\model\\Jwellary.java");

            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
