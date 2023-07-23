package mycode.view.classes;

import mycode.controller.JwellaryController;
import mycode.model.Jwellary;
import mycode.view.interfaces.View;

import java.util.Scanner;

public class ViewJwellary  implements View {

    private Scanner scanner;
    private JwellaryController jwellaryController;


    @Override
    public void View() {
        jwellaryController=new JwellaryController();
        scanner=new Scanner(System.in);
        play();
    }

    @Override
    public void mwniu() {
        System.out.println("Hello!");
        System.out.println("Press 1 to view all the jwellary");
        System.out.println("Press 2 to add a jwellary");
        System.out.println("Press 3 to remove a jwellary");
        System.out.println("Press 4 to save and exit");
    }

    public void play(){
        int alegere=0;
        boolean running=true;

        while (running){
            mwniu();
            alegere=Integer.parseInt(scanner.nextLine());

            switch (alegere){
                case 1:
                    jwellaryController.afisareJwellary();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    running=false;
                    jwellaryController.toSave();
                    break;
                default:
                    System.out.println("Incorrect choice");
                break;
            }
        }
    }

    @Override
    public void add() {
        System.out.println("jwellary_type:");
        String jwellary_type=scanner.nextLine();
        System.out.println("jwellary_id:");
        int jwellary_id=Integer.parseInt(scanner.nextLine());
        System.out.println("jwellary_name:");
        String jwellary_name=scanner.nextLine();
        System.out.println("jwellary_description:");
        String jwellary_description=scanner.nextLine();

        Jwellary jwellary=jwellaryController.findBuId(jwellary_id);
        if(jwellary==null){
            Jwellary jwellary1=new Jwellary(jwellary_type,jwellary_id,jwellary_name,jwellary_description);
            jwellaryController.addJwellary(jwellary1);
        }else{
            System.out.println("Error (jwellary-add)");
        }


    }

    @Override
    public void remove() {
        System.out.println("jwellary_id:");
        int jwellary_id=Integer.parseInt(scanner.nextLine());
        Jwellary jwellary22=jwellaryController.findBuId(jwellary_id);
        if(jwellary22==null){
            System.out.println("There is no jwellary with the entered id");
        }else {
            jwellaryController.removeJwellary(jwellary22.getJwellary_id());
            System.out.println("The jwellary was remove");
        }
    }




}
