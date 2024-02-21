package dojo.supermarket.model;

public class DiscountCalculator {

    public Discount calculateDiscount(Offer offer, double quantity, double unitPrice) {
        Product product = offer.getProduct();
        switch (offer.getOfferType()) {
            case THREE_FOR_TWO:
                return calculateThreeForTwo(offer, quantity, unitPrice, product);
            case TEN_PERCENT_DISCOUNT:
                return calculateTenPercentDiscount(offer, quantity, unitPrice, product);
            case TWO_FOR_AMOUNT:
                return calculateTwoForAmount(offer, quantity, unitPrice, product);
            case FIVE_FOR_AMOUNT:
                return calculateFiveForAmount(offer, quantity, unitPrice, product);
            default:
                return null;
        }
    }

    private Discount calculateThreeForTwo(Offer offer, double quantity, double unitPrice, Product product) {
        if (quantity >= 3) {
            double discountAmount = quantity / 3 * unitPrice;
            return new Discount(product, "3 for 2", -discountAmount);
        }
        return null;
    }

    private Discount calculateTenPercentDiscount(Offer offer, double quantity, double unitPrice, Product product) {
        double discountAmount = quantity * unitPrice * 0.1;
        return new Discount(product, "10% off", -discountAmount);
    }

    private Discount calculateTwoForAmount(Offer offer, double quantity, double unitPrice, Product product) {
        if (quantity >= 2) {
            double total = unitPrice * quantity;
            double discountAmount = total - (offer.getArgument() * (quantity / 2));
            return new Discount(product, "2 for " + offer.getArgument(), -discountAmount);
        }
        return null;
    }

    private Discount calculateFiveForAmount(Offer offer, double quantity, double unitPrice, Product product) {
        if (quantity >= 5) {
            double total = unitPrice * quantity;
            double discountAmount = total - (offer.getArgument() * (quantity / 5));
            return new Discount(product, "5 for " + offer.getArgument(), -discountAmount);
        }
        return null;
    }
}
