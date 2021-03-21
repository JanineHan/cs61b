public class LinkedListDeque<T> implements Deque<T> {
    public class TNode {
        public T item;
        public TNode next;
        public TNode prev;

        public TNode(T i, TNode p, TNode n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private TNode sentinel;
    private int size;

    @Override
    public void addFirst(T item) {
        TNode a = new TNode(item, sentinel, sentinel.next);
        sentinel.next.prev = a;
        sentinel.next = a;
        // The order of above 2 sentences matters
        size += 1;
    }

    @Override
    public void addLast(T item) {
        TNode a = new TNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = a;
        sentinel.prev = a;

        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    /*Separate by space*/
    public void printDeque() {
        TNode count = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(count.item + " ");
            count = count.next;
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;
        size -= 1;
        T a = sentinel.next.item;

        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return a;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        size -= 1;
        T a = sentinel.prev.item;

        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return a;
    }

    @Override
    public T get(int index) {
        if ((index > size - 1) || (index < 0)) return null;
        TNode p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if ((index > size - 1) || (index < 0)) return null;

        return getR(sentinel.next, index);
    }

    private T getR(TNode a, int i) {
        if (i == 0) return a.item;
        return getR(a.next, i - 1);
    }

    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


}
