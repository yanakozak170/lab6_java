/**
 * Represents instant coffee.
 */
class InstantCoffee extends Coffee {
    /**
     * Constructs an instant coffee product with specified parameters.
     *
     * @param name    the name of the instant coffee
     * @param price   the price per kilogram
     * @param weight  the weight of the product (including packaging)
     * @param quality the quality rating (1-10)
     */
    public InstantCoffee(String name, double price, double weight, double quality) {
        super(name, price, weight, quality);
    }
}