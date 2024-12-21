/**
 * Represents coffee beans.
 */
class CoffeeBeans extends Coffee {
    /**
     * Constructs a coffee bean product with specified parameters.
     *
     * @param name    the name of the coffee beans
     * @param price   the price per kilogram
     * @param weight  the weight of the product (including packaging)
     * @param quality the quality rating (1-10)
     */
    public CoffeeBeans(String name, double price, double weight, double quality) {
        super(name, price, weight, quality);
    }
}