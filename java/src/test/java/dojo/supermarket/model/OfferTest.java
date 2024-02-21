package dojo.supermarket.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OfferTest {

    @Test
    void testConstructorAndGetter() {
        // Création d'un produit et d'une offre pour le test
        Product product = new Product("Pain", ProductUnit.KILO);
        SpecialOfferType offerType = SpecialOfferType.TEN_PERCENT_DISCOUNT;
        double argument = 10.0;

        Offer offer = new Offer(offerType, product, argument);
        assertEquals(product, offer.getProduct(), "Le produit de l'offre ne correspond pas");

    }
}

