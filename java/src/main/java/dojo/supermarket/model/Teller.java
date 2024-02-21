package dojo.supermarket.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Teller {

    private final SupermarketCatalog catalog;
    private final Map<Product, Offer> offers = new HashMap<>();

    public Teller(SupermarketCatalog catalog) {
        this.catalog = catalog;
    }

    public void addSpecialOffer(SpecialOfferType offerType, Product product, double argument) {
        offers.put(product, new Offer(offerType, product, argument));
    }

    public Receipt checksOutArticlesFrom(ShoppingCart cart) {
        Receipt receipt = new Receipt();
        cart.getItems().forEach(item -> {
            double unitPrice = catalog.getUnitPrice(item.getProduct());
            receipt.addProduct(item.getProduct(), item.getQuantity(), unitPrice, unitPrice * item.getQuantity());
        });

        applyOffers(cart, receipt);

        return receipt;
    }

    private void applyOffers(ShoppingCart cart, Receipt receipt) {
        cart.productQuantities().forEach((product, quantity) -> {
            if (offers.containsKey(product)) {
                Offer offer = offers.get(product);
                DiscountCalculator discountCalculator = new DiscountCalculator();
                Discount discount = discountCalculator.calculateDiscount(offer, quantity, catalog.getUnitPrice(product));
                if (discount != null) {
                    receipt.addDiscount(discount);
                }
            }
        });
    }
}
