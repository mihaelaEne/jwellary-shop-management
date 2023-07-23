package mycode.view.classes;

import mycode.controller.QualityController;
import mycode.view.interfaces.View;

import java.util.Scanner;

public class ViewQuality implements View {

    private Scanner scanner;
    private QualityController qualityController;




    @Override
    public void View() {
        qualityController=new QualityController();
        scanner=new Scanner(System.in);
        play();
    }

    @Override
    public void mwniu() {
        System.out.println("Hello!");
        System.out.println("Press 1 to view the quality details");
    }


    @Override
    public void play(){
        int alegere=0;
        boolean running=true;

        while (running){
            mwniu();
            alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1:
                    qualityController.afisareQuality();
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }
        }
    }

    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }


}
