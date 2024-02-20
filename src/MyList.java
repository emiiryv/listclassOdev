import java.util.Arrays;

public class MyList<T> {
    private T[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    // Boş constructor
    public MyList() {
        this(DEFAULT_CAPACITY);
    }

    // Constructor with initial capacity
    @SuppressWarnings("unchecked")
    public MyList(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
    }

    // Returns the number of elements in the list
    public int size() {
        return size;
    }

    // Returns the current capacity of the list
    public int getCapacity() {
        return array.length;
    }

    // Adds an element to the list
    public void add(T data) {
        if (size == array.length) {
            ensureCapacity();
        }
        array[size++] = data;
    }

    // Doubles the capacity of the array
    private void ensureCapacity() {
        int newCapacity = array.length * 2;
        T[] newArray = Arrays.copyOf(array, newCapacity);
        array = newArray;
    }

    // Returns the element at the specified index
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }

    // Removes the element at the specified index
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T removedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return removedElement;
    }

    // Sets the element at the specified index with the given data
    public T set(int index, T data) {
        if (index < 0 || index >= size) {
            return null;
        }
        T oldData = array[index];
        array[index] = data;
        return oldData;
    }

    // Returns a string representation of the list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // indexOf method to find the index of a given element
    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    // lastIndexOf method to find the last index of a given element
    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    // isEmpty method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // toArray method to convert the list to an array
    public T[] toArray() {
        return Arrays.copyOf(array, size);
    }

    // clear method to clear the list
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    // sublist method to get a sublist from the list
    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || start >= size || finish < 0 || finish > size || start > finish) {
            return null;
        }
        MyList<T> sublist = new MyList<>();
        for (int i = start; i < finish; i++) {
            sublist.add(array[i]);
        }
        return sublist;
    }

    // contains method to check if the list contains a given element
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    public static void main(String[] args) {
        MyList<Integer> liste = new MyList<>();
        liste.add(10);
        liste.add(20);
        liste.add(30);
        System.out.println("2. indisteki değer : " + liste.get(2));
        liste.remove(2);
        liste.add(40);
        liste.set(0, 100);
        System.out.println("2. indisteki değer : " + liste.get(2));
        System.out.println(liste.toString());
    }
}
