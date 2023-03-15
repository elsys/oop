package org.elsys.oop.cakefactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CakeFactoryTest {
    private CakeFactory cf;

    @BeforeEach
    void setUp() {
        cf = new CakeFactory();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addRecipe() {
//         add a new recipe to the factory
//         assert the recipe is added
        assertEquals(0, cf.getRecipeCount());
        cf.addRecipe(new Recipe("Cake1"));
        assertEquals(1, cf.getRecipeCount());
    }

    @Test
    void addDuplicateRecipe() {
//        add a recipe to the factory
//        add a second recipe with the ssame name
//        assert it throws

        cf.addRecipe(new Recipe("Cake1"));
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                cf.addRecipe(new Recipe("Cake1"));
            }
        });
    }

    @Test
    void createOrder() {
//        add a recipe
//        add all ingredients
//        make an order for that recipe
//        assert it returns an order number
    }

    @Test
    void orderMissingRecipe() {
//        add a recipe
//        make an order for a different recipe
//        assert it throws
    }

    @Test
    void orderMissingIngredients() {
//        add a recipe
//        add only some ingredients
//        make an order for that recipe
//        assert it throws
    }

    @Test
    void ordersUseIngredients() {
//        add a recipe
//        add ingredients, but not enough for 2 orders
//        make an order
//        make a second order
//        assert the second order throws
    }
}