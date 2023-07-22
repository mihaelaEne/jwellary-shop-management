import mycode.controller.JwellaryController;
import mycode.model.Jwellary;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class JwellaryControllerTest {

    @Test
    public void testAdd() {
        ArrayList<Jwellary> jwellaryArrayList = new ArrayList<>();
        Jwellary j1 = new Jwellary("type1",1,"name1","description1");
        jwellaryArrayList.add(j1);
        Jwellary j2 = new Jwellary(  "type2",2,"name2","description2");
        jwellaryArrayList.add(j2);
        Jwellary j3 = new Jwellary( "type3",3,"name3","description3");
        jwellaryArrayList.add(j3);


        JwellaryController jwellaryController = new JwellaryController(jwellaryArrayList);
        assertNotNull(jwellaryController.findBuId(1));
    }

    @Test
    public void testRemove() {
        ArrayList<Jwellary> jwellaryArrayList = new ArrayList<>();
        Jwellary j1 = new Jwellary("type1",1,"name1","description1");
        jwellaryArrayList.add(j1);
        Jwellary j2 = new Jwellary(  "type2",2,"name2","description2");
        jwellaryArrayList.add(j2);
        Jwellary j3 = new Jwellary( "type3",3,"name3","description3");
        jwellaryArrayList.add(j3);


        JwellaryController jwellaryController = new JwellaryController(jwellaryArrayList);
        jwellaryController.removeJwellary(2);
        assertEquals(null, jwellaryController.findBuId(2));
    }

    @Test
    public void testFindById() {
        ArrayList<Jwellary> jwellaryArrayList = new ArrayList<>();
        Jwellary j1 = new Jwellary("type1",1,"name1","description1");
        jwellaryArrayList.add(j1);
        Jwellary j2 = new Jwellary(  "type2",2,"name2","description2");
        jwellaryArrayList.add(j2);
        Jwellary j3 = new Jwellary( "type3",3,"name3","description3");
        jwellaryArrayList.add(j3);


        JwellaryController jwellaryController = new JwellaryController(jwellaryArrayList);
        assertEquals("name1", jwellaryController.findBuId(1).getJwellary_name());
    }

}
