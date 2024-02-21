package dojo.supermarket.model.offers;

import dojo.supermarket.model.Discount;
import dojo.supermarket.model.Product;

public class TenPercentOffer implements  Offer {
    private final Product product;
    private final double argument;

    public TenPercentOffer(Product product, double argument) {
        this.product = product;
        this.argument = argument;
    }

    @Override
    public Discount getDiscount(Product p, double quantity, double unitPrice) {
        return new Discount(p, argument + "% off", quantity * unitPrice * argument / 100.0);
    }
}
