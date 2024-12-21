/**
 * Demonstrates the usage of the CoffeeList class with Coffee objects.
 */
public class Main {
    /**
     * The main method to demonstrate the functionality of the CoffeeList class.
     *
     * <p>In this demonstration, we:
     * <ul>
     *     <li>Create several Coffee objects of different types</li>
     *     <li>Add them to the CoffeeList collection</li>
     *     <li>Remove one item from the collection</li>
     *     <li>Check if the collection contains a specific Coffee object</li>
     *     <li>Retrieve a Coffee object by index</li>
     *     <li>Clear the entire collection</li>
     * </ul>
     * </p>
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Create coffee products
        Coffee coffee1 = new CoffeeBeans("Арабіка", 50.0, 20.0, 9.0);
        Coffee coffee2 = new GroundCoffee("Еспресо", 40.0, 15.0, 8.5);
        Coffee coffee3 = new InstantCoffee("Розчинна Класика", 30.0, 10.0, 7.5);
        Coffee coffee4 = new CoffeeBeans("Робуста", 35.0, 25.0, 8.0);
        Coffee coffee5 = new CoffeeBeans("Преміум Арабіка", 60.0, 30.0, 9.5);
        Coffee coffee6 = new GroundCoffee("Френч Роаст", 45.0, 20.0, 8.0);

        // Create a CoffeeList and test its functionality
        CoffeeList collection = new CoffeeList();

        // Add Coffee objects to the collection
        collection.add(coffee1);
        collection.add(coffee2);
        collection.add(coffee3);
        collection.add(coffee4);
        collection.add(coffee5);
        collection.add(coffee6);

        // Print the initial collection
        System.out.println("Початкова колекція");
        System.out.println(collection);

        // Remove a coffee product and print the collection again
        collection.remove(coffee3);
        System.out.println("Колекція після видалення Розчинної Класики");
        System.out.println(collection);

        // Check if a coffee product is in the collection
        System.out.println("Чи містить колекція Арабіку? " + collection.contains(coffee1));

        // Retrieve a coffee product from the collection
        Coffee retrievedCoffee = collection.get(0);
        System.out.println("Отриманий продукт кави за індексом: " + retrievedCoffee);

        // Clear the collection
        collection.clear();
        System.out.println("\nКолекція після очищення");
        System.out.println(collection);
    }
}
