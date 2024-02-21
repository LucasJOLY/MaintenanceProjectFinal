package dojo.supermarket.model;

import dojo.supermarket.model.offers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Teller {

    private final SupermarketCatalog catalog;
    private final Map<Product, Offer> offers = new HashMap<>();

    public Teller(SupermarketCatalog catalog) {
        this.catalog = catalog;
    }

    public void addSpecialOffer(SpecialOfferType offerType, Product product, double argument) {
        switch (offerType) {
            case THREE_FOR_TWO:
                offers.put(product, new ThreeForTwoOffer(product, argument));
                break;
            case TEN_PERCENT_DISCOUNT:
                offers.put(product, new TenPercentOffer(product, argument));
                break;
            case TWO_FOR_AMOUNT:
                offers.put(product, new TwoForAmountOffer(product, argument));
                break;
            case FIVE_FOR_AMOUNT:
                offers.put(product, new FiveForAmountOffer(product, argument));
                break;
            default:
                throw new IllegalArgumentException("Unknown offer type: " + offerType);
        }
    }

    public Receipt checksOutArticlesFrom(ShoppingCart theCart) {
        Receipt receipt = new Receipt();
        List<ProductQuantity> productQuantities = theCart.getItems();
        for (ProductQuantity pq : productQuantities) {
            Product p = pq.getProduct();
            double quantity = pq.getQuantity();
            double unitPrice = this.catalog.getUnitPrice(p);
            double price = quantity * unitPrice;
            receipt.addProduct(p, quantity, unitPrice, price);
        }
        if (!this.offers.isEmpty()) {
            theCart.handleOffers(receipt, this.offers, this.catalog);
        }

        return receipt;
    }

}
