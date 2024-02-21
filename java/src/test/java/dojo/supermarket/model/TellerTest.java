package dojo.supermarket.model;

import dojo.supermarket.model.offers.SpecialOfferType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TellerTest {

    private SupermarketCatalog catalog;
    private Teller teller;
    private ShoppingCart cart;
    private Product bread;

    @BeforeEach
    public void setUp() {
        catalog = new SupermarketCatalogMock();
        teller = new Teller(catalog);
        cart = new ShoppingCart();
        bread = new Product("Bread", ProductUnit.EACH);

        // Assuming the price of bread is 1.00 per unit
        catalog.addProduct(bread, 1.00);
        cart.addItemQuantity(bread, 2); // Adding 2 units of bread to the cart
    }

    @Test
    public void testCheckoutWithNoOffers() {
        Receipt receipt = teller.checksOutArticlesFrom(cart);
        assertEquals(2.00, receipt.getTotalPrice(), "Total price should be 2.00 with no special offers.");
    }

    @Test
    public void testCheckoutWithTenPercentDiscountOffer() {
        teller.addSpecialOffer(SpecialOfferType.TEN_PERCENT_DISCOUNT, bread, 10); // 10% discount on bread
        Receipt receipt = teller.checksOutArticlesFrom(cart);
        // Expected total price with discount: 2 - (0.10 * 2) = 1.80
        assertEquals(1.80, receipt.getTotalPrice(), "Total price should reflect the ten percent discount on bread.");
    }
}
