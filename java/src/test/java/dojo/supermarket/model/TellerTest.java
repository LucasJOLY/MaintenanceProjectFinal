package dojo.supermarket.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TellerTest {

    @Test
    void testAddSpecialOffer() {
        SupermarketCatalog catalog = new SupermarketCatalogMock();
        Teller teller = new Teller(catalog);
        Product product = new Product("Pain", ProductUnit.KILO);
        teller.addSpecialOffer(SpecialOfferType.TEN_PERCENT_DISCOUNT, product, 10);

        // Simuler l'ajout de produits au panier
        ShoppingCart cart = new ShoppingCart();
        cart.addItemQuantity(product, 1);

        // Vérifier l'application de l'offre spéciale
        Receipt receipt = teller.checksOutArticlesFrom(cart);
        boolean discountApplied = receipt.getDiscounts().stream()
                .anyMatch(d -> d.getDescription().equals("10% off") && d.getProduct().equals(product));

        assertTrue(discountApplied, "La réduction spéciale devrait être appliquée sur le reçu.");
    }
}
