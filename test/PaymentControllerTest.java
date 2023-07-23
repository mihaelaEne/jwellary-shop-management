import mycode.controller.PaymentController;
import mycode.model.Payment;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PaymentControllerTest {
    @Test
    public void testFindById() {


        ArrayList<Payment> paymentArrayList = new ArrayList<>();
        Payment p1=new Payment(1,1,"1-10-2007",1,"description1");
        paymentArrayList.add(p1);
        Payment p2=new Payment(2,2,"2-10-2007",2,"description2");
        paymentArrayList.add(p2);
        Payment p3=new Payment(3,3,"3-10-2007",3,"description3");
        paymentArrayList.add(p3);

        PaymentController paymentController = new PaymentController(paymentArrayList);
        assertEquals("description3", paymentController.findBuId(3).getPayment_description());
    }


}
