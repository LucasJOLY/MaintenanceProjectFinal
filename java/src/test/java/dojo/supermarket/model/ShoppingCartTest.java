package dojo.supermarket.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void testAddItemQuantity() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Pain", ProductUnit.KILO);
        cart.addItemQuantity(product, 2.5);

        assertEquals(2.5, cart.productQuantities().get(product), "La quantité ajoutée ne correspond pas");
    }

    @Test
    void testApplyDiscount() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Pommes", ProductUnit.KILO);
        cart.addItemQuantity(product, 3);
        Discount discount = new Discount(product, "Réduction de 2 euros", 2.0);
        cart.addDiscount(discount);

        assertEquals(1, cart.getDiscounts().size(), "La réduction n'a pas été correctement ajoutée");
        assertTrue(cart.getDiscounts().contains(discount), "La réduction attendue n'est pas présente dans le panier");
    }

}
