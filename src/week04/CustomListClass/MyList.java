package week04.CustomListClass;

import java.util.Arrays;

public class MyList<T> {

    private T[] myList;
    private int capacity;
    private int counter;

    public MyList() {
        this(10);
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        this.myList = (T[]) new Object[capacity];
    }

    public int size() {
        return counter;
    }

    public void add(T data) {
        if (counter == capacity) {
            myList = Arrays.copyOf(myList, capacity * 2);
            capacity *= 2;
        }
        myList[counter++] = data;
    }

    public T get(int index) {
        return myList[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= counter) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        T removedElement = myList[index];
        System.arraycopy(myList, index + 1, myList, index, counter - index - 1);
        myList[--counter] = null;
        return removedElement;
    }

    public T set(int index, T data) {
        if (index < 0 || index >= counter) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        T oldData = myList[index];
        myList[index] = data;
        return oldData;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(myList, counter));
    }

    public int indexOf(T data) {
        for (int i = 0; i < counter; i++) {
            if (myList[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = counter - 1; i >= 0; i--) {
            if (myList[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public T[] toArray() {
        return Arrays.copyOf(myList, counter);
    }

    public void clear() {
        Arrays.fill(myList, null);
        counter = 0;
    }

    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || finish >= counter || start > finish) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        MyList<T> sublist = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            sublist.add(myList[i]);
        }
        return sublist;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    public int getCapacity() {
        return capacity;
    }
}

