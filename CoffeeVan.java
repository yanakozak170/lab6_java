import java.util.*;

/**
 * Represents a van that holds coffee products.
 */
class CoffeeVan {
    private double maxVolume;
    private List<Coffee> cargo;

    /**
     * Constructs a coffee van with specified maximum volume.
     *
     * @param maxVolume the maximum weight capacity of the van in kilograms
     * @throws IllegalArgumentException if maxVolume is not positive
     */
    public CoffeeVan(double maxVolume) {
        if (maxVolume <= 0) {
            throw new IllegalArgumentException("Максимальний обсяг має бути позитивним");
        }
        this.maxVolume = maxVolume;
        this.cargo = new ArrayList<>();
    }

    /**
     * Gets the maximum volume capacity of the van.
     *
     * @return the maximum weight capacity in kilograms
     */
    public double getMaxVolume() {
        return maxVolume;
    }

    /**
     * Gets the current volume of the cargo in the van.
     *
     * @return the total weight of the cargo in kilograms
     */
    public double getCurrentVolume() {
        return cargo.stream().mapToDouble(Coffee::getWeight).sum();
    }

    /**
     * Adds a coffee product to the van's cargo.
     *
     * @param coffee the coffee product to add
     * @throws IllegalStateException if there is not enough space in the van
     */
    public void addCoffee(Coffee coffee) {
        if (getCurrentVolume() + coffee.getWeight() > maxVolume) {
            throw new IllegalStateException("Недостатньо місця у фургоні для цієї кави!");
        }
        cargo.add(coffee);
    }

    /**
     * Sorts the coffee cargo by price-to-weight ratio in descending order.
     */
    public void sortCargoByPriceToWeightRatio() {
        cargo.sort(Comparator.comparingDouble(Coffee::priceToWeightRatio).reversed());
    }

    /**
     * Finds coffee products within a specified quality range.
     *
     * @param minQuality the minimum quality rating (inclusive)
     * @param maxQuality the maximum quality rating (inclusive)
     * @return a list of coffee products in the specified quality range
     * @throws IllegalArgumentException if the quality range is invalid
     */
    public List<Coffee> findCoffeeByQualityRange(double minQuality, double maxQuality) {
        if (minQuality < 1 || maxQuality > 10 || minQuality > maxQuality) {
            throw new IllegalArgumentException("Неправильний діапазон якості");
        }
        return cargo.stream()
                .filter(c -> c.getQuality() >= minQuality && c.getQuality() <= maxQuality)
                .toList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Coffee coffee : cargo) {
            sb.append(coffee).append("\n");
        }
        sb.append(String.format("\nЗагальна вага: %.2f/%.2f\n", getCurrentVolume(), maxVolume));
        return sb.toString();
    }
}