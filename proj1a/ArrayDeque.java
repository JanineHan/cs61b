public class ArrayDeque<T> {
    private T[] a;
    private int size;
    private int nextfirst;
    private int nextlast;

    public ArrayDeque() {
        a = (T[]) new Object[8];
        size = 0;
        nextfirst = 0;
        nextlast = 1;
    }

    // "size" is the new size
    private void resize(int size) {
        T[] newa = (T[]) new Object[size];
        int oldlength = a.length;
        int copypointer = (nextfirst + 1) % a.length;
        for (int i = 0; i < a.length; i++) {
            newa[i] = a[copypointer];
            copypointer = (copypointer + 1) % a.length;
        }
        this.a = newa;
        nextfirst = a.length - 1;
        nextlast = oldlength;
    }

    public void addFirst(T item) {
        if (size == a.length) resize(a.length * 2);
        a[nextfirst] = item;
        nextfirst = (nextfirst - 1 + a.length) % a.length;
        size += 1;
    }

    public void addLast(T item) {
        if (size == a.length) resize(a.length * 2);
        a[nextlast] = item;
        nextlast = (nextlast + 1) % a.length;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int p = (nextfirst + 1) % a.length;
        for (int i = 0; i < size; i++) {
            System.out.print(a[p] + " ");
            p = (p + 1) % a.length;
        }
    }

    public T removeFirst() {
        if (size == 0) return null;
        T first = a[(nextfirst + 1) % a.length];
        nextfirst = (nextfirst + 1) % a.length;
        size -= 1;
        if (a.length >= 16 && 4 * size < a.length) {
            resize(a.length / 2);
        }
        return first;
    }

    public T removeLast() {
        if (size == 0) return null;
        T last = a[(nextlast - 1 + a.length) % a.length];
        nextlast = (nextlast - 1 + a.length) % a.length;
        size -= 1;
        if (a.length >= 16 && 4 * size < a.length) {
            resize(size + 1);
        }
        return last;
    }

    public T get(int index) {
        if (index >= size || index < 0) return null;
        int zero = (nextfirst + 1) % a.length;
        return a[(zero + index) % a.length];
    }


}
