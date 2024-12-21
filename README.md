# lab6_java
Лабораторна робота 6 з дисципліни "Розробка програмного забезпечення на платфомі Java"

Для запуску лабораторної роботи у класі `Main` треба створити різні види кави та колекцію collection, після чого додати до колекції створену каву:
```java
        Coffee coffee1 = new CoffeeBeans("Арабіка", 50.0, 20.0, 9.0);
        Coffee coffee2 = new GroundCoffee("Еспресо", 40.0, 15.0, 8.5);
        Coffee coffee3 = new InstantCoffee("Розчинна Класика", 30.0, 10.0, 7.5);
        Coffee coffee4 = new CoffeeBeans("Робуста", 35.0, 25.0, 8.0);
        Coffee coffee5 = new CoffeeBeans("Преміум Арабіка", 60.0, 30.0, 9.5);
        Coffee coffee6 = new GroundCoffee("Френч Роаст", 45.0, 20.0, 8.0);

        CoffeeList collection = new CoffeeList();

        collection.add(coffee1);
        collection.add(coffee2);
        collection.add(coffee3);
        collection.add(coffee4);
        collection.add(coffee5);
        collection.add(coffee6);
```
