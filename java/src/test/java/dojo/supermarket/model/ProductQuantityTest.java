package dojo.supermarket.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductQuantityTest {

    @Test
    void testProductQuantityCreationAndGetters() {
        Product product = new Product("Pain", ProductUnit.KILO);
        double quantity = 2.5;

        ProductQuantity productQuantity = new ProductQuantity(product, quantity);

        assertEquals(product, productQuantity.getProduct(), "Le produit ne correspond pas");
        assertEquals(quantity, productQuantity.getQuantity(), "La quantité ne correspond pas");
    }
}