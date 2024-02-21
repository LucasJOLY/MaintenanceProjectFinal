package dojo.supermarket.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {

    @Test
    void testAddProductAndGetItems() {
        Receipt receipt = new Receipt();
        Product product = new Product("Pain", ProductUnit.KILO);
        receipt.addProduct(product, 1, 1.0, 1.0);

        assertEquals(1, receipt.getItems().size(), "Le nombre d'items devrait être 1");
    }

    @Test
    void testAddDiscountAndGetDiscounts() {
        Receipt receipt = new Receipt();
        Discount discount = new Discount(new Product("Pain", ProductUnit.KILO), "Remise", 0.5);
        receipt.addDiscount(discount);

        assertEquals(1, receipt.getDiscounts().size(), "Le nombre de réductions devrait être 1");
    }

    @Test
    void testGetTotalPrice() {
        Receipt receipt = new Receipt();
        receipt.addProduct(new Product("Pain", ProductUnit.KILO), 2, 1.0, 2.0);
        receipt.addDiscount(new Discount(new Product("Pain", ProductUnit.KILO), "Remise", -0.5));

        assertEquals(1.5, receipt.getTotalPrice(), "Le prix total calculé ne correspond pas");
    }
}
