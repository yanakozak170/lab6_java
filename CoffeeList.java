import java.util.*;

/**
 * Custom collection that implements a typed list with a doubly linked list structure.
 *
 * <p>This collection is restricted to the Coffee class from the lab work.
 * It provides efficient insertion and deletion operations and supports
 * common List interface functionalities.</p>
 */
public class CoffeeList implements List<Coffee> {
    /**
     * Node structure for the doubly linked list.
     */
    private static class Node {
        Coffee data;
        Node next;
        Node prev;

        /**
         * Constructs a node with the given Coffee object.
         *
         * @param data the Coffee object to store in the node
         */
        Node(Coffee data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    /**
     * Default constructor (creates an empty collection).
     */
    public CoffeeList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Constructor that initializes the collection with a single Coffee object.
     *
     * @param coffee the Coffee object to add to the collection
     */
    public CoffeeList(Coffee coffee) {
        this();
        add(coffee);
    }

    /**
     * Constructor that initializes the collection with a standard collection of Coffee objects.
     *
     * @param coffees a collection of Coffee objects to add to the collection
     */
    public CoffeeList(Collection<Coffee> coffees) {
        this();
        addAll(coffees);
    }


    /**
     * Retrieves the node at a specific index.
     *
     * @param index the index of the node to retrieve
     * @return the node at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс: " + index + ", Розмір: " + size);
        }
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    /** {@inheritDoc} */
    @Override
    public int size() {
        return size;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** {@inheritDoc} */
    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Coffee)) {
            return false;
        }
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public Iterator<Coffee> iterator() {
        return new Iterator<>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Coffee next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Немає наступного елемента.");
                }
                Coffee data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /** {@inheritDoc} */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    /** {@inheritDoc} */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        Node current = head;
        for (int i = 0; i < size; i++) {
            a[i] = (T) current.data;
            current = current.next;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    /** {@inheritDoc} */
    @Override
    public boolean add(Coffee coffee) {
        Node newNode = new Node(coffee);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Coffee)) {
            return false;
        }
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public boolean addAll(Collection<? extends Coffee> c) {
        boolean modified = false;
        for (Coffee coffee : c) {
            modified |= add(coffee);
        }
        return modified;
    }

    /** {@inheritDoc} */
    @Override
    public boolean addAll(int index, Collection<? extends Coffee> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Індекс: " + index + ", Розмір: " + size);
        }
        boolean modified = false;
        for (Coffee coffee : c) {
            add(index++, coffee);
            modified = true;
        }
        return modified;
    }

    /** {@inheritDoc} */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object item : c) {
            modified |= remove(item);
        }
        return modified;
    }

    /** {@inheritDoc} */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node current = head;
        while (current != null) {
            if (!c.contains(current.data)) {
                Node next = current.next;
                remove(current.data);
                current = next;
                modified = true;
            } else {
                current = current.next;
            }
        }
        return modified;
    }

    /** {@inheritDoc} */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /** {@inheritDoc} */
    @Override
    public Coffee get(int index) {
        return getNode(index).data;
    }

    /** {@inheritDoc} */
    @Override
    public Coffee set(int index, Coffee element) {
        Node node = getNode(index);
        Coffee oldData = node.data;
        node.data = element;
        return oldData;
    }

    /** {@inheritDoc} */
    @Override
    public void add(int index, Coffee element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Індекс: " + index + ", Розмір: " + size);
        }
        if (index == size) {
            add(element);
            return;
        }
        Node newNode = new Node(element);
        Node current = getNode(index);
        newNode.next = current;
        newNode.prev = current.prev;
        if (current.prev != null) {
            current.prev.next = newNode;
        } else {
            head = newNode;
        }
        current.prev = newNode;
        size++;
    }

    /** {@inheritDoc} */
    @Override
    public Coffee remove(int index) {
        Node node = getNode(index);
        Coffee data = node.data;
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        size--;
        return data;
    }

    /** {@inheritDoc} */
    @Override
    public int indexOf(Object o) {
        if (!(o instanceof Coffee)) {
            return -1;
        }
        Node current = head;
        for (int index = 0; index < size; index++) {
            if (current.data.equals(o)) {
                return index;
            }
            current = current.next;
        }
        return -1;
    }

    /** {@inheritDoc} */
    @Override
    public int lastIndexOf(Object o) {
        if (!(o instanceof Coffee)) {
            return -1;
        }
        Node current = tail;
        for (int index = size - 1; index >= 0; index--) {
            if (current.data.equals(o)) {
                return index;
            }
            current = current.prev;
        }
        return -1;
    }

    /** {@inheritDoc} */
    @Override
    public ListIterator<Coffee> listIterator() {
        throw new UnsupportedOperationException("Метод listIterator не підтримується.");
    }

    /** {@inheritDoc} */
    @Override
    public ListIterator<Coffee> listIterator(int index) {
        throw new UnsupportedOperationException("Метод listIterator не підтримується.");
    }

    /** {@inheritDoc} */
    @Override
    public List<Coffee> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Метод subList не підтримується.");
    }

    /**
     * Returns a string representation of the CoffeeList collection.
     *
     * @return a string containing all Coffee objects in the collection
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Колекція кави:\n");
        Node current = head;
        while (current != null) {
            sb.append(current.data).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
}
