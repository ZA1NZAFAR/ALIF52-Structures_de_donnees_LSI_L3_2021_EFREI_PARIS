package Lab7;

public class NArrayTree {
    private int[] array;
    private int size;
    private int maxSize;

    public NArrayTree(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        size = 0;
    }

    public void add(int value) {
        if (size == maxSize) {
            System.out.println("SIZE MAX");
            return;
        }
        array[size] = value;
        size++;
    }

    public void remove(int value) {
        int index = 0;
        while (index < size && array[index] != value) {
            index++;
        }
        if (index == size) {
            System.out.println("SIZE MAX");
            return;
        }
        if (size - 1 - index >= 0) System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void print(int value) {
        int index = 0;
        while (index < size && array[index] != value) {
            index++;
        }
        if (index == size) {
            System.out.println("SIZE MAX");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (i == index) {
                System.out.print("*" + array[i] + " ");
            } else {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    public void print(int value, int level) {
        int index = 0;
    }
}
