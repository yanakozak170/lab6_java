/**
 * Represents ground coffee.
 */
class GroundCoffee extends Coffee {
    /**
     * Constructs a ground coffee product with specified parameters.
     *
     * @param name    the name of the ground coffee
     * @param price   the price per kilogram
     * @param weight  the weight of the product (including packaging)
     * @param quality the quality rating (1-10)
     */
    public GroundCoffee(String name, double price, double weight, double quality) {
        super(name, price, weight, quality);
    }
}