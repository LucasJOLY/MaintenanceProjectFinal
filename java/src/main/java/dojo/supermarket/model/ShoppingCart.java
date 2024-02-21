package dojo.supermarket.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private final List<ProductQuantity> items = new ArrayList<>();
    private final Map<Product, Double> productQuantities = new HashMap<>();
    List<ProductQuantity> getItems() {
        return Collections.unmodifiableList(items);
    }

    void addItem(Product product) {
        addItemQuantity(product, 1.0);
    }

    Map<Product, Double> productQuantities() {
        return Collections.unmodifiableMap(productQuantities);
    }

    public void addItemQuantity(Product product, double quantity) {
        items.add(new ProductQuantity(product, quantity));
        productQuantities.merge(product, quantity, Double::sum);
    }


    public void handleOffers(Receipt receipt, Map<Product, Offer> offers, SupermarketCatalog catalog) {
        for (Map.Entry<Product, Double> entry : productQuantities.entrySet()) {
            Product product = entry.getKey();
            double quantity = entry.getValue();
            if (offers.containsKey(product)) {
                Offer offer = offers.get(product);
                double unitPrice = catalog.getUnitPrice(product);
                DiscountCalculator calculator = new DiscountCalculator();
                Discount discount = calculator.calculateDiscount(offer, quantity, unitPrice);
                if (discount != null) {
                    receipt.addDiscount(discount);
                }
            }
        }
    }


}
