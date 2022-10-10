import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType testIngredientType;

    public IngredientTest(IngredientType type){
        this.testIngredientType = type;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    public void ingredientClassVerifyGetPriceMethodTest(){
        Ingredient i = new Ingredient(testIngredientType, "TestName", 100);
        Assert.assertEquals(100, i.getPrice(), 0);
    }

    @Test
    public void ingredientClassVerifyGetNameMethodTest(){
        Ingredient i = new Ingredient(testIngredientType, "TestName", 100);
        Assert.assertEquals("TestName", i.getName());
    }

    @Test
    public void ingredientClassVerifyGetTypeMethodTest(){
        Ingredient i = new Ingredient(SAUCE, "TestName", 100);
        Assert.assertEquals(SAUCE, i.getType());
    }
}
