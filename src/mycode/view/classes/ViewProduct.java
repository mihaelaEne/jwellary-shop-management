package mycode.view.classes;

import mycode.controller.ProductController;
import mycode.model.Product;
import mycode.view.interfaces.View;

import java.util.Scanner;

public class ViewProduct implements View {

    private Scanner scanner;
    private ProductController productController;

    @Override
    public void View() {
        productController=new ProductController();
        scanner=new Scanner(System.in);
        play();
    }

    @Override
    public void mwniu() {
        System.out.println("Hello!");
        System.out.println("Press 1 to see all the products ");
        System.out.println("Press 2 to add a product ");
        System.out.println("Press 3 to remove a product ");
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
                    productController.afisareProduct();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    running=false;
                    productController.toSave();
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }
        }
    }

    @Override
    public void add() {
        System.out.println("product_type:");
        String product_type=scanner.nextLine();
        System.out.println("product_id:");
        int product_id=Integer.parseInt(scanner.nextLine());
        System.out.println("product_customer_id:");
        int product_customer_id=Integer.parseInt(scanner.nextLine());
        System.out.println("product_items:");
        String product_items=scanner.nextLine();
        System.out.println("product_number");
        int product_number=Integer.parseInt(scanner.nextLine());
        System.out.println("product_description:");
        String product_description=scanner.nextLine();

       Product product=productController.findBuId(product_id);
        if(product==null){
            Product product1=new Product(product_type,product_id,product_customer_id,product_items,product_number,product_description);
            productController.addProduct(product1);
        }else{
            System.out.println("Error (product-add)");
        }


    }

    @Override
    public void remove() {

        System.out.println("product_id:");
        int product_id = Integer.parseInt(scanner.nextLine());
        Product product2 = productController.findBuId(product_id);
        if (product2 == null) {
            System.out.println("There is no product with the entered id");
        } else {
            productController.removeProduct(product2.getProduct_id());
            System.out.println("The product was remove");
        }
    }
}
