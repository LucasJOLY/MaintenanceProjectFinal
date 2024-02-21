package dojo.supermarket.model;

public class Offer {

    private final SpecialOfferType offerType;
    private final Product product;
    private final double argument;

    public Offer(SpecialOfferType offerType, Product product, double argument) {
        this.offerType = offerType;
        this.product = product;
        this.argument = argument;
    }

    public SpecialOfferType getOfferType() {
        return offerType;
    }

    public Product getProduct() {
        return product;
    }

    public double getArgument() {
        return argument;
    }
}
