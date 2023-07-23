package mycode.view.classes;

import mycode.controller.SalesController;
import mycode.model.Sales;
import mycode.view.interfaces.View;

import java.util.Scanner;

public class ViewSales implements View {

    private Scanner scanner;
    private SalesController salesController;


    @Override
    public void View() {
        salesController=new SalesController();
        scanner=new Scanner(System.in);
    }

    @Override
    public void mwniu() {
        System.out.println("Hello!");
        System.out.println("Press 1 to see all the sales");
        System.out.println("Press 2 to add a sale ");
        System.out.println("Press 3 to remove a sale");
        System.out.println("Press 4 to save and exit");
    }

    public void play(){
        int alegere=0;
        boolean running= true;

        while(running){
            mwniu();
            alegere=Integer.parseInt(scanner.nextLine());


            switch (alegere){
                case 1:
                    salesController.afisareSales();
                    break;
                case 2: add();break;
                case 3: remove();break;
                case 4:
                    running=false;
                    salesController.toSave();
                    break;

                default:
                    System.out.println("Incorrect choice ");
                    break;
            }
        }
    }

    @Override
    public void add() {
        System.out.println("sales_type");
        String sales_type=scanner.nextLine();
        System.out.println("sales_id:");
        int sales_id=Integer.parseInt(scanner.nextLine());
        System.out.println("sales_customer_id:");
        int sales_customer_id=Integer.parseInt(scanner.nextLine());
        System.out.println("sales_amount:");
        int sales_amount=Integer.parseInt(scanner.nextLine());
        System.out.println("sales_description:");
        String sales_description=scanner.nextLine();


        Sales sales=salesController.findBuId(sales_id);
        if(sales==null){
            Sales sales1=new Sales(sales_type,sales_id,sales_customer_id,sales_amount,sales_description);
            salesController.addSales(sales1);
        }else {
            System.out.println("Error(sales add)");
        }
    }

    @Override
    public void remove() {
        System.out.println("sales_id:");
        int sales_id=Integer.parseInt(scanner.nextLine());
        Sales sales=salesController.findBuId(sales_id);
        if(sales==null){
            System.out.println("There is no sale with the entered id:");
        }else {
            salesController.removeSales(sales.getSales_id());
            System.out.println("The sales was remove");
        }
    }













}
