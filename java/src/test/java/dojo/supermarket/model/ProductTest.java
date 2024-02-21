package dojo.supermarket.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ProductTest {

    @Test
    void testProductCreationAndGetters() {
        Product product = new Product("Pain", ProductUnit.KILO);
        assertEquals("Pain", product.getName(), "Le nom du produit ne correspond pas");
        assertEquals(ProductUnit.KILO, product.getUnit(), "L'unité du produit ne correspond pas");
    }

    @Test
    void testEquals() {
        Product product1 = new Product("Pain", ProductUnit.KILO);
        Product product2 = new Product("Pain", ProductUnit.KILO);
        assertTrue(product1.equals(product2), "Les produits devraient être considérés comme égaux");
    }

    @Test
    void testHashCode() {
        Product product1 = new Product("Pain", ProductUnit.KILO);
        Product product2 = new Product("Pain", ProductUnit.KILO);
        assertEquals(product1.hashCode(), product2.hashCode(), "Les hashCodes devraient être identiques pour les produits égaux");
    }
}
