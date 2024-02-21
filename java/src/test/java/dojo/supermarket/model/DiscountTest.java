package dojo.supermarket.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    @Test
    void testDiscountCreationAndGetters() {
        Product product = new Product("Pain", ProductUnit.KILO);
        String description = "10% off";
        double discountAmount = 0.1;

        Discount discount = new Discount(product, description, discountAmount);

        assertEquals(product, discount.getProduct(), "Le produit ne correspond pas");
        assertEquals(description, discount.getDescription(), "La description ne correspond pas");
        assertEquals(discountAmount, discount.getDiscountAmount(), "Le montant de la réduction ne correspond pas");
    }
}
