package dojo.supermarket.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReceiptItemTest {

    @Test
    void testReceiptItemCreationAndGetters() {
        Product product = new Product("Pain", ProductUnit.KILO);
        double quantity = 1;
        double price = 1.0;
        double totalPrice = 1.0;

        ReceiptItem item = new ReceiptItem(product, quantity, price, totalPrice);

        assertEquals(product, item.getProduct(), "Le produit ne correspond pas");
        assertEquals(quantity, item.getQuantity(), "La quantité ne correspond pas");
        assertEquals(price, item.getPrice(), "Le prix ne correspond pas");
        assertEquals(totalPrice, item.getTotalPrice(), "Le prix total ne correspond pas");
    }

    @Test
    void testEqualsAndHashCode() {
        Product product = new Product("Pain", ProductUnit.KILO);
        ReceiptItem item1 = new ReceiptItem(product, 1, 1.0, 1.0);
        ReceiptItem item2 = new ReceiptItem(product, 1, 1.0, 1.0);
        ReceiptItem item3 = new ReceiptItem(product, 2, 2.0, 4.0);

        assertTrue(item1.equals(item2), "Les items devraient être égaux");
        assertFalse(item1.equals(item3), "Les items ne devraient pas être égaux");
        assertEquals(item1.hashCode(), item2.hashCode(), "Les hashCodes devraient être égaux pour les items égaux");
    }
}
