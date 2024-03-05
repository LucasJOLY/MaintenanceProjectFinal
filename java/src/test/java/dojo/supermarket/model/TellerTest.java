package dojo.supermarket.model;

import dojo.supermarket.model.offers.SpecialOfferType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TellerTest {

    private SupermarketCatalog catalog;
    private Teller teller;
    private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        catalog = new SupermarketCatalogMock();
        teller = new Teller(catalog);
        cart = new ShoppingCart();
    }

    @Test
    public void testCheckoutWithNoOffers() {
        Product pain = new Product("Pain", ProductUnit.EACH);
        // Assuming the price of bread is 1.00 per unit
        catalog.addProduct(pain, 1.00);
        cart.addItemQuantity(pain, 2); // Adding 2 units of bread to the cart
        Receipt receipt = teller.checksOutArticlesFrom(cart);
        assertEquals(2.00, receipt.getTotalPrice(), "Le prix total represente le panier sans aucune reduction.");
    }

    @Test
    public void testCheckoutWithTenPercentDiscountOffer() {
        Product riz = new Product("Riz", ProductUnit.EACH);
        // Assuming the price of bread is 1.00 per unit
        catalog.addProduct(riz, 2.49);
        cart.addItemQuantity(riz, 1); // Adding 2 units of bread to the cart
        teller.addSpecialOffer(SpecialOfferType.TEN_PERCENT_DISCOUNT, riz, 10); // 10% discount on bread
        Receipt receipt = teller.checksOutArticlesFrom(cart);
        // Expected total price with discount: 2 - (0.10 * 2) = 1.80
        assertEquals(2.241, receipt.getTotalPrice(), "Le mrix total represente le prix du riz avec la reduction de 10%.");
    }

    @Test
    public void testCheckoutWithThreeForTwoOffer() {
        Product brosse = new Product("Brosse a dent", ProductUnit.EACH);
        // Assuming the price of bread is 1.00 per unit
        catalog.addProduct(brosse, 0.99);
        cart.addItemQuantity(brosse, 3); // Adding 3 units of bread to the cart
        teller.addSpecialOffer(SpecialOfferType.THREE_FOR_TWO, brosse, 0); // Three for the price of two offer on bread
        Receipt receipt = teller.checksOutArticlesFrom(cart);
        // Expected total price with offer: 2 * 1.00 = 2.00
        assertEquals(1.98, receipt.getTotalPrice(), "Le prix total represente le prix de trois brosse a dent avec la réduction de trois acheté, 1 offert.");
    }

    @Test
    public void testCheckoutWithTwoForAmountOffer() {
        Product tomate = new Product("Boite de tomate cerise", ProductUnit.EACH);
        // Assuming the price of bread is 1.00 per unit
        catalog.addProduct(tomate, 0.69);
        cart.addItemQuantity(tomate, 2); // Adding 2 units of bread to the cart
        teller.addSpecialOffer(SpecialOfferType.TWO_FOR_AMOUNT, tomate, 0.99); // Two for the price of 1.50 offer on bread
        Receipt receipt = teller.checksOutArticlesFrom(cart);
        // Expected total price with offer: 1.50
        assertEquals(0.99, receipt.getTotalPrice(), "Le prix total represente le prix de deux boites de tomates cerises  avec la réduction de deux pour 0.99.");
    }


    // test avec Cinq tubes de dentifrice pour 7,49 €, prix normal de 1,79
    @Test
    public void testCheckoutWithFiveForAmountOffer() {
        Product dentifrice = new Product("Tube de dentifrice", ProductUnit.EACH);
        // Assuming the price of bread is 1.00 per unit
        catalog.addProduct(dentifrice, 1.79);
        cart.addItemQuantity(dentifrice, 5); // Adding 5 units of bread to the cart
        teller.addSpecialOffer(SpecialOfferType.FIVE_FOR_AMOUNT, dentifrice, 7.49); // Five for the price of 7.49 offer on bread
        Receipt receipt = teller.checksOutArticlesFrom(cart);
        // Expected total price with offer: 7.49
        assertEquals(7.49, receipt.getTotalPrice(), "Le prix total represente le prix de cinq tubes de dentifrice avec la réduction de cinq pour 7.49.");
    }



}
