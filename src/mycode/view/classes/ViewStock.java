package mycode.view.classes;

import mycode.controller.StockController;
import mycode.model.Stock;
import mycode.view.interfaces.View;

import java.util.Scanner;

public class ViewStock implements View {
    private Scanner scanner;
    private StockController stockController;
    @Override
    public void View() {

    }

    @Override
    public void mwniu() {
        System.out.println("Hello!");
        System.out.println("Press 1 to see all the stock ");
        System.out.println("Press 2 to add a stock ");
        System.out.println("Press 3 to remove a stock ");
        System.out.println("Press 4 to save and exit  ");
    }

    @Override
    public void play() {
        int alegere=0;
        boolean running=true;

        while (running){
            mwniu();
            alegere=Integer.parseInt(scanner.nextLine());

            switch (alegere){
                case 1:
                    stockController.afisareStock();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    running=false;
                    stockController.toSave();
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }
        }
    }

    @Override
    public void add() {
        System.out.println("stock_type:");
        String stock_type=scanner.nextLine();
        System.out.println("stock_id:");
        int stock_id=Integer.parseInt(scanner.nextLine());
        System.out.println("stock_items:");
        int stock_items=Integer.parseInt(scanner.nextLine());
        System.out.println("stock_number");
        int stock_number=Integer.parseInt(scanner.nextLine());
        System.out.println("stock_description:");
        String stock_description=scanner.nextLine();

        Stock stock=stockController.findBuId(stock_id);
        if(stock==null){
            Stock stock1=new Stock(stock_type,stock_id,stock_items,stock_number,stock_description);
            stockController.addStock(stock1);
        }else {
            System.out.println("Error (stock-add)");
        }
    }

    @Override
    public void remove() {
        System.out.println("stock_id:");
        int stock_id=Integer.parseInt(scanner.nextLine());

        Stock stock=stockController.findBuId(stock_id);
        if(stock==null){
            System.out.println("There is no stock with the entered id");

        }else{
            stockController.removeStock(stock.getStock_id());
            System.out.println("The stock was remove");
        }
    }
}
