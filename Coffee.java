import java.util.*;

/**
 * Represents a general coffee product.
 */
abstract class Coffee {
    private String name; // The name of the coffee product
    private double price; // Price per kilogram
    private double weight; // Weight in kilograms (including packaging)
    private double quality; // Quality rating (1-10)

    /**
     * Constructs a coffee product with specified parameters.
     *
     * @param name    the name of the coffee product
     * @param price   the price per kilogram
     * @param weight  the weight of the product (including packaging)
     * @param quality the quality rating (1-10)
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Coffee(String name, double price, double weight, double quality) {
        if (price <= 0 || weight <= 0 || quality < 1 || quality > 10) {
            throw new IllegalArgumentException("Неправильні параметри");
        }
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.quality = quality;
    }

    /**
     * Gets the name of the coffee product.
     *
     * @return the name of the coffee product
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price per kilogram of the coffee product.
     *
     * @return the price per kilogram
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the weight of the coffee product (including packaging).
     *
     * @return the weight in kilograms
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets the quality rating of the coffee product.
     *
     * @return the quality rating (1-10)
     */
    public double getQuality() {
        return quality;
    }

    /**
     * Calculates the price-to-weight ratio of the coffee product.
     *
     * @return the price-to-weight ratio
     */
    public double priceToWeightRatio() {
        return price / weight;
    }

    @Override
    public String toString() {
        return String.format("%s: Ціна=%.2f, Вага=%.2f, Якість=%.1f", name, price, weight, quality);
    }
}