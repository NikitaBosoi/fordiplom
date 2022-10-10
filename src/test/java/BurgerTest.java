import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.Locale;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends BaseTest{

    @Test
    public void burgerGetPriceMethodTestPriceWithoutIngredientsTest(){
        bun = new Bun("testBun", 100);
        Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        Assert.assertEquals(200, testBurger.getPrice(), 0);
    }

    @Test
    public void burgerGetPriceMethodTestPriceWithIngredientsTest(){
        bun = new Bun("testBun", 100);
        Burger testBurger = new Burger();
        Ingredient ingred = new Ingredient(SAUCE, "TestIngredient", 50);
        testBurger.addIngredient(ingred);
        testBurger.setBuns(bun);
        Assert.assertEquals(250, testBurger.getPrice(), 0);
    }

    @Test
    public void burgerAddIngredientMethodSuccessTest(){
        bun = new Bun("testBun", 100);
        Burger testBurger = new Burger();
        Ingredient ingred = new Ingredient(SAUCE, "TestIngredient", 50);
        testBurger.addIngredient(ingred);
        Assert.assertTrue(testBurger.ingredients.contains(ingred));
    }

    @Test
    public void burgerRemoveIngredientMethodSuccessTest(){
        bun = new Bun("testBun", 100);
        Burger testBurger = new Burger();
        Ingredient ingred = new Ingredient(SAUCE, "TestIngredient", 50);
        testBurger.addIngredient(ingred);
        testBurger.removeIngredient(testBurger.ingredients.indexOf(ingred));
        Assert.assertTrue(testBurger.ingredients.isEmpty());
    }

    @Test
    public void burgerMoveIngredientMethodSuccessTest(){
        bun = new Bun("testBun", 100);
        Burger testBurger = new Burger();
        Ingredient ingred1 = new Ingredient(SAUCE, "TestIngredient1", 50);
        Ingredient ingred2 = new Ingredient(FILLING, "TestIngredient2", 70);
        testBurger.addIngredient(ingred1);
        testBurger.addIngredient(ingred2);
        testBurger.moveIngredient(testBurger.ingredients.indexOf(ingred1), 1);
        Assert.assertEquals(1, testBurger.ingredients.indexOf(ingred1));
    }

    @Test
    public void burgerGetReceiptGeneratingNewReceiptObjectWithIngredientsSuccessTest(){
        bun = new Bun("testBun", 100);
        Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        Ingredient ingred = new Ingredient(SAUCE, "TestIngredient", 50);
        testBurger.addIngredient(ingred);
        String sbString = testBurger.getReceipt().toString();
        String [] arr = sbString.split(" ");
        Assert.assertTrue(arr[1].equals(bun.getName()));
        Assert.assertTrue(arr[3].toUpperCase(Locale.ROOT).equals(ingred.getType().toString().toUpperCase(Locale.ROOT)));
    }

    @Test
    public void burgerGetReceiptGeneratingNewReceiptObjectWithoutIngredientsSuccessTest(){
        bun = new Bun("testBun", 100);
        Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        String sbString = testBurger.getReceipt().toString();
        String [] arr = sbString.split(" ");
        Assert.assertTrue(arr[1].equals(bun.getName()));
    }
}
