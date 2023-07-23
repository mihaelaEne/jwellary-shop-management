package mycode.view.classes;

import mycode.controller.PaymentController;
import mycode.model.Payment;
import mycode.view.interfaces.View;

import java.util.Scanner;

public class ViewPayment implements View {


    private Scanner scanner;
    private PaymentController paymentController;

    @Override
    public void View() {
        paymentController=new PaymentController();
        scanner=new Scanner(System.in);
        play();
    }

    @Override
    public void mwniu() {
        System.out.println("Hello!");
        System.out.println("Press 1 ti view all the payments");
        System.out.println("Presss 2 to add a payment");
        System.out.println("Press 3 to remove a payment");
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
                    paymentController.afisarePayment();
                    break;
                case 2:
                    add();
                    break;

                case 3:
                    remove();
                    break;
                case 4:
                    running=false;
                    paymentController.toSave();
                    break;

                default:
                    System.out.println("Incorrect choice");
                    break;
            }
        }
    }

    @Override
    public void add() {
        System.out.println("payment_id:");
        int payment_id=Integer.parseInt(scanner.nextLine());
        System.out.println("payment_customer_id:");
        int payment_customer_id=Integer.parseInt(scanner.nextLine());
        System.out.println("payment_date:");
        String payment_date=scanner.nextLine();
        System.out.println("payment_amount:");
        int payment_amount=Integer.parseInt(scanner.nextLine());
        System.out.println("payment_description:");
        String payment_description=scanner.nextLine();


        Payment payment=paymentController.findBuId(payment_id);
        if(payment==null){
            Payment payment1=new Payment(payment_id,payment_customer_id,payment_date,payment_amount,payment_description);
            paymentController.addPayment(payment1);
        }else{
            System.out.println("Error(add payment)");
        }
    }

    @Override
    public void remove() {
        System.out.println("payment_id:");
        int payment_id=Integer.parseInt(scanner.nextLine());
        Payment payment=paymentController.findBuId(payment_id);
        if(payment==null){
            System.out.println("There is no payment with the entered id");
        }else {
            paymentController.removePaymengt(payment.getPayment_id());
            System.out.println("The payment was remove");
        }
    }


}
