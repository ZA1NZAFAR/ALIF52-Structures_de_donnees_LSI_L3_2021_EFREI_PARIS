package Lab2;

import java.util.Arrays;

public class PileArrayImplementation {
    int SIZE_MAX = 100;
    int[] tab;
    int top;

    public PileArrayImplementation() {
        tab = new int[SIZE_MAX];
        top = -1;
    }

    public void push(int n) {
        top++;
        if (top >= tab.length) {
            increaseSize();
        } else {
            tab[top] = n;
        }
    }

    public void pop() {
        if (top <= 0)
            System.out.println("Array empty!");
        tab[top] = 0;
        top--;
    }

    public int top() {
        return tab[top];
    }

    private void increaseSize() {
        SIZE_MAX++;
        tab = Arrays.copyOf(tab, SIZE_MAX + 1);
    }

    @Override
    public String toString() {
        return "PileArrayImplementation{" +
                "SIZE_MAX=" + SIZE_MAX +
                ", tab=" + Arrays.toString(tab) +
                ", top=" + top +
                '}';
    }
}