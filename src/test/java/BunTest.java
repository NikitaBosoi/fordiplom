import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BunTest extends BaseTest{


     @Test
     public void bunGetNameMethodReturnsName(){
         bun = new Bun("testName", 12);
         assertTrue(bun.getName().equals("testName"));
     }

     @Test
     public void bunGetNameMethodReturnsPrice(){
         bun = new Bun("testName", 12);
         assertEquals(bun.getPrice(), 12, 0);
     }
}
