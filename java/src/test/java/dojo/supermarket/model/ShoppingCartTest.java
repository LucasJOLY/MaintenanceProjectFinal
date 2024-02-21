package dojo.supermarket.model;

import dojo.supermarket.model.offers.SpecialOfferType;
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
    void testApplyDiscountThroughTeller() {
        ShoppingCart cart = new ShoppingCart();
        SupermarketCatalog catalog = new SupermarketCatalogMock(); // Cette classe mock doit être implémentée
        Teller teller = new Teller(catalog);
        Product product = new Product("Pommes", ProductUnit.KILO);
        cart.addItemQuantity(product, 3);
        teller.addSpecialOffer(SpecialOfferType.TEN_PERCENT_DISCOUNT, product, 10);

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        // Assurez-vous que la réduction attendue est appliquée dans le reçu
        assertTrue(receipt.getDiscounts().stream().anyMatch(d -> d.getProduct().equals(product)), "La réduction attendue n'est pas présente dans le reçu");
    }
}
