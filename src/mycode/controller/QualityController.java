package mycode.controller;

import mycode.model.Product;
import mycode.model.Quality;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class QualityController {
    List<Quality> qualityList;


    public QualityController( List<Quality> qualityList) {
        this.qualityList = qualityList;
    }

    public QualityController() {
        this.qualityList = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\jwellary-shop-management\\src\\mycode\\data\\quality.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Quality quality = new Quality(scanner.nextLine());
                this.qualityList.add(quality);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisareQuality() {
        Iterator<Quality> iterator = qualityList.iterator();
        while (iterator.hasNext()) {
            Quality q = iterator.next();
            System.out.println(q.toString());
        }
    }



    public Quality findBuId(int id) {
        Iterator<Quality> iterator = qualityList.iterator();
        while (iterator.hasNext()) {
            Quality q = iterator.next();
            if (q.getQuality_id() == id) {
                return q;
            }

        }
        return null;

    }

    public String toSave(){
        String text="";
        int i=0;
        for (i=0; i< qualityList.size()-1; i++){
            text+=qualityList.get(i).toSave()+"\n";
        }
        text+=qualityList.get(i).toSave();
        return text;
    }

    public void save(){
        try{
            File file = new File("C:\\mycode\\OOP\\jwellary-shop-management\\src\\mycode\\data\\quality.txt");

            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
