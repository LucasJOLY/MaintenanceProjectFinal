package dojo.supermarket.model.offers;

import dojo.supermarket.model.Discount;
import dojo.supermarket.model.Product;

public interface Offer {

    Discount getDiscount(Product p, double quantity, double unitPrice);


}