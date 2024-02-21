package dojo.supermarket.model;

import java.util.Objects;

public class Product {

    private final String name;
    private final ProductUnit unit;

    public Product(String name, ProductUnit unit) {
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public ProductUnit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Product otherProduct)) {
            return false;
        }

        return Objects.equals(this.name, otherProduct.name) &&
                this.unit == otherProduct.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unit);
    }
}
